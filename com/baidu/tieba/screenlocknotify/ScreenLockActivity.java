package com.baidu.tieba.screenlocknotify;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreHttpResponseMessage;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreModel;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreSocketResponseMessage;
import com.baidu.tieba.screenlocknotify.view.ScreenLockHeaderView;
import com.baidu.webkit.internal.ETAG;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private ImageView fkG;
    private Window jQE;
    public c jQG;
    public d jQH;
    private ScreenLockLoadMoreModel jQK;
    private ScreenLockHeaderView jQL;
    private Drawable jDR = null;
    public DynamicHeightListView jQF = null;
    private int jQI = 0;
    private TextView jQJ = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver jQM = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra(TiebaInitialize.LogFields.REASON)) != null && stringExtra.equals("homekey")) {
                a.cEw().jQS.cPs();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener jQN = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d data;
            if (ScreenLockActivity.this.jQL != null && !StringUtils.isNull(ScreenLockActivity.this.jQL.getInputMsg()) && (data = ScreenLockActivity.this.jQL.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.PUSH_CCLICK).s("msg_id", data.msgId / 100).s("task_id", data.taskId).cx(TiebaInitialize.Params.OBJ_TO, data.url).cx("app_version", TbConfig.getVersion()).X("obj_source", 2));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.jQL.getInputMsg(), com.baidu.adp.lib.f.b.toLong(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.b.aKJ().up(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.jQL.getInputMsg(), com.baidu.adp.lib.f.b.toLong(data.groupId, 0L), data.userName, data.nameShow, data.jRh);
                    com.baidu.tbadk.coreExtra.messageCenter.b.aKJ().up(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.cEw().jQS.cPs();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.jQH = ScreenLockActivity.this.jQG.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.jQH);
        }
    };
    private View.OnClickListener jQO = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.jQL != null) {
                ScreenLockActivity.this.jQH = ScreenLockActivity.this.jQL.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.jQH);
            }
        }
    };
    private com.baidu.adp.framework.listener.a jQP = new com.baidu.adp.framework.listener.a(1003194, CmdConfigSocket.CMD_SCREEN_LOCK_MESSAGE_MORE) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(R.string.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.jQJ != null) {
                            ScreenLockActivity.this.jQJ.setText(ScreenLockActivity.this.getResources().getString(R.string.data_load_error));
                            ScreenLockActivity.this.jQJ.setEnabled(true);
                            return;
                        }
                        return;
                    }
                    if (responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) {
                        data = ((ScreenLockLoadMoreHttpResponseMessage) responsedMessage).getData();
                    } else {
                        data = responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage ? ((ScreenLockLoadMoreSocketResponseMessage) responsedMessage).getData() : null;
                    }
                    if (data != null) {
                        ArrayList<d> items = data.getItems();
                        if (ScreenLockActivity.this.jQG != null) {
                            ScreenLockActivity.this.jQG.ec(items);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.jQG.setHasMore(false);
                            if (ScreenLockActivity.this.jQJ != null) {
                                ScreenLockActivity.this.jQF.removeFooterView(ScreenLockActivity.this.jQJ);
                                ScreenLockActivity.this.jQJ = null;
                            }
                        }
                    }
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        this.jQE = getWindow();
        this.jQE.addFlags(524288);
        this.jQE.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(R.layout.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.transparent, true);
        if (l.isFlymeOsAbove35()) {
            this.jDR = com.baidu.tieba.v.b.cPw();
            if (this.jDR != null) {
                this.jQE.setBackgroundDrawable(this.jDR);
            }
        }
        this.jQI = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds935) - l.getDimens(getPageContext().getPageActivity(), R.dimen.ds80);
        this.jQK = new ScreenLockLoadMoreModel(this);
        registerListener(this.jQP);
        initUI();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    public void initUI() {
        this.fkG = (ImageView) findViewById(R.id.head_close);
        this.fkG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d item;
                if (ScreenLockActivity.this.jQG.getCount() > 0 && (item = ScreenLockActivity.this.jQG.getItem(0)) != null) {
                    TiebaStatic.log(new an("c11704").s("msg_id", item.msgId / 100).s("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.cEw().jQS.cPs();
            }
        });
        this.jQF = (DynamicHeightListView) findViewById(R.id.screenlock_chat_list_content);
        this.jQG = new c(getPageContext().getPageActivity());
        this.jQF.setAdapter((ListAdapter) this.jQG);
        this.jQF.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.jQM, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.cEw().jQY = false;
        this.jQF.setMaxHeight(this.jQI);
        this.jQF.setTranscriptMode(0);
        this.jQF.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.jQJ != null && ScreenLockActivity.this.jQJ.getParent() != null) {
                    if (ScreenLockActivity.this.jQF.getHeight() != ScreenLockActivity.this.jQI) {
                        ScreenLockActivity.this.jQJ.setText(ScreenLockActivity.this.getResources().getString(R.string.click_load_more));
                        ScreenLockActivity.this.jQJ.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.jQJ.isEnabled()) {
                            ScreenLockActivity.this.jQJ.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                            ScreenLockActivity.this.jQJ.setEnabled(false);
                        }
                        ScreenLockActivity.this.bGJ();
                    }
                }
            }
        });
    }

    private void cEu() {
        this.jQJ = new TextView(getActivity());
        this.jQJ.setGravity(17);
        this.jQJ.setText(R.string.click_load_more);
        this.jQJ.setHeight((int) getResources().getDimension(R.dimen.ds80));
        this.jQJ.setBackgroundResource(R.drawable.screen_notify_item_background);
        this.jQJ.setTextColor(getResources().getColorStateList(R.color.screen_notify_load_more_text_color));
        this.jQJ.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        this.jQJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.jQJ.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                ScreenLockActivity.this.jQJ.setEnabled(false);
                ScreenLockActivity.this.bGJ();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(cEv())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGJ() {
        d item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.jQK.cEC();
            if (this.jQG != null && this.jQG.getCount() > 0 && (item = this.jQG.getItem(0)) != null) {
                TiebaStatic.log(new an("c11738").s("msg_id", item.msgId / 100).s("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.cEw().jQV = 1;
        a.cEw().jQT = 0;
        List<d> cEy = a.cEw().cEy();
        d cEz = a.cEw().cEz();
        a.cEw().release();
        if ((cEy == null || cEy.isEmpty()) && cEz == null && this.jQG.getCount() == 0 && this.jQF.getHeaderViewsCount() == 0) {
            a.cEw().jQS.cPs();
            finish();
            return;
        }
        eb(cEy);
        if (cEz != null) {
            a(cEz);
        }
        if (this.jQL != null) {
            this.jQL.sq(this.jQG.getCount() == 0);
        }
    }

    private void eb(List<d> list) {
        if (list != null && list.size() > 0 && this.jQG != null) {
            this.jQG.ec(list);
            if (this.jQG.isHasMore() && this.jQJ == null) {
                cEu();
                this.jQF.addFooterView(this.jQJ);
            }
        }
    }

    private void a(d dVar) {
        if (this.jQL == null) {
            this.jQL = new ScreenLockHeaderView(getActivity());
            this.jQL.setUIClickListener(this.jQN, this.jQO);
            this.jQL.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.jQF.addHeaderView(this.jQL);
        }
        this.jQL.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.cEw().jQV = 0;
        a.cEw().jQT = 0;
        if (this.jQL != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.jQL.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.jQM);
        a.cEw().release();
        a.cEw().jQV = 0;
        this.jDR = null;
    }

    public void b(d dVar) {
        int i;
        if (dVar != null) {
            switch (dVar.customGroupType) {
                case 1:
                case 2:
                    i = 3;
                    break;
                case 3:
                default:
                    i = 0;
                    break;
                case 4:
                    i = 2;
                    break;
                case 5:
                    i = 1;
                    break;
            }
            TiebaStatic.log(new an(TbadkCoreStatisticKey.PUSH_CCLICK).s("msg_id", dVar.msgId / 100).s("task_id", dVar.taskId).cx(TiebaInitialize.Params.OBJ_TO, dVar.url).cx("app_version", TbConfig.getVersion()).X("obj_source", i));
            if (!j.isNetWorkAvailable()) {
                showToast(getResources().getString(R.string.neterror));
            } else if (!TextUtils.isEmpty(dVar.url)) {
                ba.aGK().b(getPageContext(), new String[]{dVar.url + ETAG.ITEM_SEPARATOR + "is_from_push=true"});
                TiebaStatic.log(new an("c10316").cx("obj_type", dVar.stat).X("obj_locate", 2));
                a.cEw().d(dVar);
                finish();
            } else if (dVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(dVar.groupId, 0L), dVar.groupName, 0L, "from_lock")));
                a.cEw().d(dVar);
                a.cEw().jQS.cPs();
                if (!a.cEw().jQS.cPu()) {
                    a.cEw().jQS.cPt();
                }
                a.cEw().jQT = 0;
                finish();
            } else if (dVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.jQH.groupId, 0L), dVar.groupName, dVar.nameShow, dVar.jRh, 0, dVar.jpS ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, personalChatActivityConfig));
                a.cEw().d(dVar);
                a.cEw().jQT = 0;
                a.cEw().jQS.cPs();
                if (!a.cEw().jQS.cPu()) {
                    a.cEw().jQS.cPt();
                }
                finish();
            } else if (dVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.jQH.groupId, 0L), dVar.groupName, dVar.jRh, 0, 4)));
                a.cEw().d(dVar);
                a.cEw().jQT = 0;
                a.cEw().jQS.cPs();
                if (!a.cEw().jQS.cPu()) {
                    a.cEw().jQS.cPt();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.cEw().d(dVar);
                a.cEw().jQS.cPs();
                if (!a.cEw().jQS.cPu()) {
                    a.cEw().jQS.cPt();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.cEw().jQS.cPs();
            finish();
            return true;
        } else if (i == 82) {
            a.cEw().jQS.cPs();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String cEv() {
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) TbadkApplication.getInst().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(5);
        if (runningTasks == null || runningTasks.size() <= 0) {
            return null;
        }
        ActivityManager.RunningTaskInfo runningTaskInfo = runningTasks.get(0);
        if (runningTaskInfo == null) {
            return null;
        }
        return runningTaskInfo.topActivity.getClassName();
    }
}
