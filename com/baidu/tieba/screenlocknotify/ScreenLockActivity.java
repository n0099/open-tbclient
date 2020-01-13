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
/* loaded from: classes6.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private ImageView fgN;
    private Window jNN;
    public c jNP;
    public d jNQ;
    private ScreenLockLoadMoreModel jNT;
    private ScreenLockHeaderView jNU;
    private Drawable jBi = null;
    public DynamicHeightListView jNO = null;
    private int jNR = 0;
    private TextView jNS = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver jNV = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra(TiebaInitialize.LogFields.REASON)) != null && stringExtra.equals("homekey")) {
                a.cCw().jOb.cNy();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener jNW = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d data;
            if (ScreenLockActivity.this.jNU != null && !StringUtils.isNull(ScreenLockActivity.this.jNU.getInputMsg()) && (data = ScreenLockActivity.this.jNU.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.PUSH_CCLICK).s("msg_id", data.msgId / 100).s("task_id", data.taskId).cp(TiebaInitialize.Params.OBJ_TO, data.url).cp("app_version", TbConfig.getVersion()).Z("obj_source", 2));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.jNU.getInputMsg(), com.baidu.adp.lib.f.b.toLong(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.b.aIj().tX(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.jNU.getInputMsg(), com.baidu.adp.lib.f.b.toLong(data.groupId, 0L), data.userName, data.nameShow, data.jOq);
                    com.baidu.tbadk.coreExtra.messageCenter.b.aIj().tX(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.cCw().jOb.cNy();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.jNQ = ScreenLockActivity.this.jNP.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.jNQ);
        }
    };
    private View.OnClickListener jNX = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.jNU != null) {
                ScreenLockActivity.this.jNQ = ScreenLockActivity.this.jNU.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.jNQ);
            }
        }
    };
    private com.baidu.adp.framework.listener.a jNY = new com.baidu.adp.framework.listener.a(1003194, CmdConfigSocket.CMD_SCREEN_LOCK_MESSAGE_MORE) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(R.string.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.jNS != null) {
                            ScreenLockActivity.this.jNS.setText(ScreenLockActivity.this.getResources().getString(R.string.data_load_error));
                            ScreenLockActivity.this.jNS.setEnabled(true);
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
                        if (ScreenLockActivity.this.jNP != null) {
                            ScreenLockActivity.this.jNP.eg(items);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.jNP.setHasMore(false);
                            if (ScreenLockActivity.this.jNS != null) {
                                ScreenLockActivity.this.jNO.removeFooterView(ScreenLockActivity.this.jNS);
                                ScreenLockActivity.this.jNS = null;
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
        this.jNN = getWindow();
        this.jNN.addFlags(524288);
        this.jNN.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(R.layout.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.transparent, true);
        if (l.isFlymeOsAbove35()) {
            this.jBi = com.baidu.tieba.u.b.cNC();
            if (this.jBi != null) {
                this.jNN.setBackgroundDrawable(this.jBi);
            }
        }
        this.jNR = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds935) - l.getDimens(getPageContext().getPageActivity(), R.dimen.ds80);
        this.jNT = new ScreenLockLoadMoreModel(this);
        registerListener(this.jNY);
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
        this.fgN = (ImageView) findViewById(R.id.head_close);
        this.fgN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d item;
                if (ScreenLockActivity.this.jNP.getCount() > 0 && (item = ScreenLockActivity.this.jNP.getItem(0)) != null) {
                    TiebaStatic.log(new an("c11704").s("msg_id", item.msgId / 100).s("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.cCw().jOb.cNy();
            }
        });
        this.jNO = (DynamicHeightListView) findViewById(R.id.screenlock_chat_list_content);
        this.jNP = new c(getPageContext().getPageActivity());
        this.jNO.setAdapter((ListAdapter) this.jNP);
        this.jNO.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.jNV, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.cCw().jOh = false;
        this.jNO.setMaxHeight(this.jNR);
        this.jNO.setTranscriptMode(0);
        this.jNO.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.jNS != null && ScreenLockActivity.this.jNS.getParent() != null) {
                    if (ScreenLockActivity.this.jNO.getHeight() != ScreenLockActivity.this.jNR) {
                        ScreenLockActivity.this.jNS.setText(ScreenLockActivity.this.getResources().getString(R.string.click_load_more));
                        ScreenLockActivity.this.jNS.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.jNS.isEnabled()) {
                            ScreenLockActivity.this.jNS.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                            ScreenLockActivity.this.jNS.setEnabled(false);
                        }
                        ScreenLockActivity.this.bES();
                    }
                }
            }
        });
    }

    private void cCu() {
        this.jNS = new TextView(getActivity());
        this.jNS.setGravity(17);
        this.jNS.setText(R.string.click_load_more);
        this.jNS.setHeight((int) getResources().getDimension(R.dimen.ds80));
        this.jNS.setBackgroundResource(R.drawable.screen_notify_item_background);
        this.jNS.setTextColor(getResources().getColorStateList(R.color.screen_notify_load_more_text_color));
        this.jNS.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        this.jNS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.jNS.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                ScreenLockActivity.this.jNS.setEnabled(false);
                ScreenLockActivity.this.bES();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(cCv())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bES() {
        d item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.jNT.cCC();
            if (this.jNP != null && this.jNP.getCount() > 0 && (item = this.jNP.getItem(0)) != null) {
                TiebaStatic.log(new an("c11738").s("msg_id", item.msgId / 100).s("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.cCw().jOe = 1;
        a.cCw().jOc = 0;
        List<d> cCy = a.cCw().cCy();
        d cCz = a.cCw().cCz();
        a.cCw().release();
        if ((cCy == null || cCy.isEmpty()) && cCz == null && this.jNP.getCount() == 0 && this.jNO.getHeaderViewsCount() == 0) {
            a.cCw().jOb.cNy();
            finish();
            return;
        }
        ef(cCy);
        if (cCz != null) {
            a(cCz);
        }
        if (this.jNU != null) {
            this.jNU.sh(this.jNP.getCount() == 0);
        }
    }

    private void ef(List<d> list) {
        if (list != null && list.size() > 0 && this.jNP != null) {
            this.jNP.eg(list);
            if (this.jNP.isHasMore() && this.jNS == null) {
                cCu();
                this.jNO.addFooterView(this.jNS);
            }
        }
    }

    private void a(d dVar) {
        if (this.jNU == null) {
            this.jNU = new ScreenLockHeaderView(getActivity());
            this.jNU.setUIClickListener(this.jNW, this.jNX);
            this.jNU.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.jNO.addHeaderView(this.jNU);
        }
        this.jNU.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.cCw().jOe = 0;
        a.cCw().jOc = 0;
        if (this.jNU != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.jNU.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.jNV);
        a.cCw().release();
        a.cCw().jOe = 0;
        this.jBi = null;
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
            TiebaStatic.log(new an(TbadkCoreStatisticKey.PUSH_CCLICK).s("msg_id", dVar.msgId / 100).s("task_id", dVar.taskId).cp(TiebaInitialize.Params.OBJ_TO, dVar.url).cp("app_version", TbConfig.getVersion()).Z("obj_source", i));
            if (!j.isNetWorkAvailable()) {
                showToast(getResources().getString(R.string.neterror));
            } else if (!TextUtils.isEmpty(dVar.url)) {
                ba.aEt().b(getPageContext(), new String[]{dVar.url + ETAG.ITEM_SEPARATOR + "is_from_push=true"});
                TiebaStatic.log(new an("c10316").cp("obj_type", dVar.stat).Z("obj_locate", 2));
                a.cCw().d(dVar);
                finish();
            } else if (dVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(dVar.groupId, 0L), dVar.groupName, 0L, "from_lock")));
                a.cCw().d(dVar);
                a.cCw().jOb.cNy();
                if (!a.cCw().jOb.cNA()) {
                    a.cCw().jOb.cNz();
                }
                a.cCw().jOc = 0;
                finish();
            } else if (dVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.jNQ.groupId, 0L), dVar.groupName, dVar.nameShow, dVar.jOq, 0, dVar.jnh ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, personalChatActivityConfig));
                a.cCw().d(dVar);
                a.cCw().jOc = 0;
                a.cCw().jOb.cNy();
                if (!a.cCw().jOb.cNA()) {
                    a.cCw().jOb.cNz();
                }
                finish();
            } else if (dVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.jNQ.groupId, 0L), dVar.groupName, dVar.jOq, 0, 4)));
                a.cCw().d(dVar);
                a.cCw().jOc = 0;
                a.cCw().jOb.cNy();
                if (!a.cCw().jOb.cNA()) {
                    a.cCw().jOb.cNz();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.cCw().d(dVar);
                a.cCw().jOb.cNy();
                if (!a.cCw().jOb.cNA()) {
                    a.cCw().jOb.cNz();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.cCw().jOb.cNy();
            finish();
            return true;
        } else if (i == 82) {
            a.cCw().jOb.cNy();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String cCv() {
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
