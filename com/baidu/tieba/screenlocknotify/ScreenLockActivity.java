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
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private ImageView gmq;
    private Window iPS;
    public c iPU;
    public d iPV;
    private ScreenLockLoadMoreModel iPY;
    private ScreenLockHeaderView iPZ;
    private Drawable iDm = null;
    public DynamicHeightListView iPT = null;
    private int iPW = 0;
    private TextView iPX = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver iQa = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra(TiebaInitialize.LogFields.REASON)) != null && stringExtra.equals("homekey")) {
                a.chn().iQg.csr();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener iQb = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d data;
            if (ScreenLockActivity.this.iPZ != null && !StringUtils.isNull(ScreenLockActivity.this.iPZ.getInputMsg()) && (data = ScreenLockActivity.this.iPZ.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.PUSH_CCLICK).p("msg_id", data.msgId / 100).p("task_id", data.taskId).bS(TiebaInitialize.Params.OBJ_TO, data.url).bS("app_version", TbConfig.getVersion()).O("obj_source", 2));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.iPZ.getInputMsg(), com.baidu.adp.lib.g.b.toLong(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.b.aqr().oP(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.iPZ.getInputMsg(), com.baidu.adp.lib.g.b.toLong(data.groupId, 0L), data.userName, data.nameShow, data.iQw);
                    com.baidu.tbadk.coreExtra.messageCenter.b.aqr().oP(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.chn().iQg.csr();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.iPV = ScreenLockActivity.this.iPU.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.iPV);
        }
    };
    private View.OnClickListener iQc = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.iPZ != null) {
                ScreenLockActivity.this.iPV = ScreenLockActivity.this.iPZ.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.iPV);
            }
        }
    };
    private com.baidu.adp.framework.listener.a iQd = new com.baidu.adp.framework.listener.a(1003194, CmdConfigSocket.CMD_SCREEN_LOCK_MESSAGE_MORE) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(R.string.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.iPX != null) {
                            ScreenLockActivity.this.iPX.setText(ScreenLockActivity.this.getResources().getString(R.string.data_load_error));
                            ScreenLockActivity.this.iPX.setEnabled(true);
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
                        ArrayList<d> cht = data.cht();
                        if (ScreenLockActivity.this.iPU != null) {
                            ScreenLockActivity.this.iPU.eo(cht);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.iPU.setHasMore(false);
                            if (ScreenLockActivity.this.iPX != null) {
                                ScreenLockActivity.this.iPT.removeFooterView(ScreenLockActivity.this.iPX);
                                ScreenLockActivity.this.iPX = null;
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
        this.iPS = getWindow();
        this.iPS.addFlags(524288);
        this.iPS.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(R.layout.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.transparent, true);
        if (l.isFlymeOsAbove35()) {
            this.iDm = com.baidu.tieba.t.b.csv();
            if (this.iDm != null) {
                this.iPS.setBackgroundDrawable(this.iDm);
            }
        }
        this.iPW = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds935) - l.getDimens(getPageContext().getPageActivity(), R.dimen.ds80);
        this.iPY = new ScreenLockLoadMoreModel(this);
        registerListener(this.iQd);
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
        this.gmq = (ImageView) findViewById(R.id.head_close);
        this.gmq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d item;
                if (ScreenLockActivity.this.iPU.getCount() > 0 && (item = ScreenLockActivity.this.iPU.getItem(0)) != null) {
                    TiebaStatic.log(new an("c11704").p("msg_id", item.msgId / 100).p("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.chn().iQg.csr();
            }
        });
        this.iPT = (DynamicHeightListView) findViewById(R.id.screenlock_chat_list_content);
        this.iPU = new c(getPageContext().getPageActivity());
        this.iPT.setAdapter((ListAdapter) this.iPU);
        this.iPT.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.iQa, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.chn().iQm = false;
        this.iPT.setMaxHeight(this.iPW);
        this.iPT.setTranscriptMode(0);
        this.iPT.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.iPX != null && ScreenLockActivity.this.iPX.getParent() != null) {
                    if (ScreenLockActivity.this.iPT.getHeight() != ScreenLockActivity.this.iPW) {
                        ScreenLockActivity.this.iPX.setText(ScreenLockActivity.this.getResources().getString(R.string.click_load_more));
                        ScreenLockActivity.this.iPX.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.iPX.isEnabled()) {
                            ScreenLockActivity.this.iPX.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                            ScreenLockActivity.this.iPX.setEnabled(false);
                        }
                        ScreenLockActivity.this.bmu();
                    }
                }
            }
        });
    }

    private void chl() {
        this.iPX = new TextView(getActivity());
        this.iPX.setGravity(17);
        this.iPX.setText(R.string.click_load_more);
        this.iPX.setHeight((int) getResources().getDimension(R.dimen.ds80));
        this.iPX.setBackgroundResource(R.drawable.screen_notify_item_background);
        this.iPX.setTextColor(getResources().getColorStateList(R.color.screen_notify_load_more_text_color));
        this.iPX.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        this.iPX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.iPX.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                ScreenLockActivity.this.iPX.setEnabled(false);
                ScreenLockActivity.this.bmu();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(chm())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmu() {
        d item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.iPY.chu();
            if (this.iPU != null && this.iPU.getCount() > 0 && (item = this.iPU.getItem(0)) != null) {
                TiebaStatic.log(new an("c11738").p("msg_id", item.msgId / 100).p("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.chn().iQj = 1;
        a.chn().iQh = 0;
        List<d> chp = a.chn().chp();
        d chq = a.chn().chq();
        a.chn().release();
        if ((chp == null || chp.isEmpty()) && chq == null && this.iPU.getCount() == 0 && this.iPT.getHeaderViewsCount() == 0) {
            a.chn().iQg.csr();
            finish();
            return;
        }
        en(chp);
        if (chq != null) {
            a(chq);
        }
        if (this.iPZ != null) {
            this.iPZ.qm(this.iPU.getCount() == 0);
        }
    }

    private void en(List<d> list) {
        if (list != null && list.size() > 0 && this.iPU != null) {
            this.iPU.eo(list);
            if (this.iPU.isHasMore() && this.iPX == null) {
                chl();
                this.iPT.addFooterView(this.iPX);
            }
        }
    }

    private void a(d dVar) {
        if (this.iPZ == null) {
            this.iPZ = new ScreenLockHeaderView(getActivity());
            this.iPZ.setUIClickListener(this.iQb, this.iQc);
            this.iPZ.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.iPT.addHeaderView(this.iPZ);
        }
        this.iPZ.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.chn().iQj = 0;
        a.chn().iQh = 0;
        if (this.iPZ != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.iPZ.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.iQa);
        a.chn().release();
        a.chn().iQj = 0;
        this.iDm = null;
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
            TiebaStatic.log(new an(TbadkCoreStatisticKey.PUSH_CCLICK).p("msg_id", dVar.msgId / 100).p("task_id", dVar.taskId).bS(TiebaInitialize.Params.OBJ_TO, dVar.url).bS("app_version", TbConfig.getVersion()).O("obj_source", i));
            if (!j.isNetWorkAvailable()) {
                showToast(getResources().getString(R.string.neterror));
            } else if (!TextUtils.isEmpty(dVar.url)) {
                ba.amO().b(getPageContext(), new String[]{dVar.url + "&is_from_push=true"});
                TiebaStatic.log(new an("c10316").bS("obj_type", dVar.stat).O("obj_locate", 2));
                a.chn().d(dVar);
                finish();
            } else if (dVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.toLong(dVar.groupId, 0L), dVar.groupName, 0L, "from_lock")));
                a.chn().d(dVar);
                a.chn().iQg.csr();
                if (!a.chn().iQg.cst()) {
                    a.chn().iQg.css();
                }
                a.chn().iQh = 0;
                finish();
            } else if (dVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.toLong(this.iPV.groupId, 0L), dVar.groupName, dVar.nameShow, dVar.iQw, 0, dVar.ird ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, personalChatActivityConfig));
                a.chn().d(dVar);
                a.chn().iQh = 0;
                a.chn().iQg.csr();
                if (!a.chn().iQg.cst()) {
                    a.chn().iQg.css();
                }
                finish();
            } else if (dVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.toLong(this.iPV.groupId, 0L), dVar.groupName, dVar.iQw, 0, 4)));
                a.chn().d(dVar);
                a.chn().iQh = 0;
                a.chn().iQg.csr();
                if (!a.chn().iQg.cst()) {
                    a.chn().iQg.css();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.chn().d(dVar);
                a.chn().iQg.csr();
                if (!a.chn().iQg.cst()) {
                    a.chn().iQg.css();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.chn().iQg.csr();
            finish();
            return true;
        } else if (i == 82) {
            a.chn().iQg.csr();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String chm() {
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
