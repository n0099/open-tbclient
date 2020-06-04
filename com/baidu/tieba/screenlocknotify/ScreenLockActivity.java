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
    private ImageView gdY;
    private Window kTh;
    public c kTj;
    public d kTk;
    private ScreenLockLoadMoreModel kTn;
    private ScreenLockHeaderView kTo;
    private Drawable kGR = null;
    public DynamicHeightListView kTi = null;
    private int kTl = 0;
    private TextView kTm = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver kTp = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra(TiebaInitialize.LogFields.REASON)) != null && stringExtra.equals("homekey")) {
                a.cWn().kTv.dhP();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener kTq = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d data;
            if (ScreenLockActivity.this.kTo != null && !StringUtils.isNull(ScreenLockActivity.this.kTo.getInputMsg()) && (data = ScreenLockActivity.this.kTo.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.PUSH_CCLICK).s("msg_id", data.msgId / 100).s("task_id", data.taskId).dh(TiebaInitialize.Params.OBJ_TO, data.url).dh("app_version", TbConfig.getVersion()).ag("obj_source", 2));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.kTo.getInputMsg(), com.baidu.adp.lib.f.b.toLong(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.b.aZm().xm(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.kTo.getInputMsg(), com.baidu.adp.lib.f.b.toLong(data.groupId, 0L), data.userName, data.nameShow, data.kTK);
                    com.baidu.tbadk.coreExtra.messageCenter.b.aZm().xm(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.cWn().kTv.dhP();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.kTk = ScreenLockActivity.this.kTj.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.kTk);
        }
    };
    private View.OnClickListener kTr = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.kTo != null) {
                ScreenLockActivity.this.kTk = ScreenLockActivity.this.kTo.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.kTk);
            }
        }
    };
    private com.baidu.adp.framework.listener.a kTs = new com.baidu.adp.framework.listener.a(1003194, CmdConfigSocket.CMD_SCREEN_LOCK_MESSAGE_MORE) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(R.string.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.kTm != null) {
                            ScreenLockActivity.this.kTm.setText(ScreenLockActivity.this.getResources().getString(R.string.data_load_error));
                            ScreenLockActivity.this.kTm.setEnabled(true);
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
                        ArrayList<d> cWt = data.cWt();
                        if (ScreenLockActivity.this.kTj != null) {
                            ScreenLockActivity.this.kTj.ez(cWt);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.kTj.setHasMore(false);
                            if (ScreenLockActivity.this.kTm != null) {
                                ScreenLockActivity.this.kTi.removeFooterView(ScreenLockActivity.this.kTm);
                                ScreenLockActivity.this.kTm = null;
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
        this.kTh = getWindow();
        this.kTh.addFlags(524288);
        this.kTh.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(R.layout.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.transparent, true);
        if (l.isFlymeOsAbove35()) {
            this.kGR = com.baidu.tieba.v.b.dhT();
            if (this.kGR != null) {
                this.kTh.setBackgroundDrawable(this.kGR);
            }
        }
        this.kTl = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds935) - l.getDimens(getPageContext().getPageActivity(), R.dimen.ds80);
        this.kTn = new ScreenLockLoadMoreModel(this);
        registerListener(this.kTs);
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
        this.gdY = (ImageView) findViewById(R.id.head_close);
        this.gdY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d item;
                if (ScreenLockActivity.this.kTj.getCount() > 0 && (item = ScreenLockActivity.this.kTj.getItem(0)) != null) {
                    TiebaStatic.log(new an("c11704").s("msg_id", item.msgId / 100).s("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.cWn().kTv.dhP();
            }
        });
        this.kTi = (DynamicHeightListView) findViewById(R.id.screenlock_chat_list_content);
        this.kTj = new c(getPageContext().getPageActivity());
        this.kTi.setAdapter((ListAdapter) this.kTj);
        this.kTi.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.kTp, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.cWn().kTB = false;
        this.kTi.setMaxHeight(this.kTl);
        this.kTi.setTranscriptMode(0);
        this.kTi.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.kTm != null && ScreenLockActivity.this.kTm.getParent() != null) {
                    if (ScreenLockActivity.this.kTi.getHeight() != ScreenLockActivity.this.kTl) {
                        ScreenLockActivity.this.kTm.setText(ScreenLockActivity.this.getResources().getString(R.string.click_load_more));
                        ScreenLockActivity.this.kTm.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.kTm.isEnabled()) {
                            ScreenLockActivity.this.kTm.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                            ScreenLockActivity.this.kTm.setEnabled(false);
                        }
                        ScreenLockActivity.this.bXH();
                    }
                }
            }
        });
    }

    private void cWl() {
        this.kTm = new TextView(getActivity());
        this.kTm.setGravity(17);
        this.kTm.setText(R.string.click_load_more);
        this.kTm.setHeight((int) getResources().getDimension(R.dimen.ds80));
        this.kTm.setBackgroundResource(R.drawable.screen_notify_item_background);
        this.kTm.setTextColor(getResources().getColorStateList(R.color.screen_notify_load_more_text_color));
        this.kTm.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        this.kTm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.kTm.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                ScreenLockActivity.this.kTm.setEnabled(false);
                ScreenLockActivity.this.bXH();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(cWm())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXH() {
        d item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.kTn.cWu();
            if (this.kTj != null && this.kTj.getCount() > 0 && (item = this.kTj.getItem(0)) != null) {
                TiebaStatic.log(new an("c11738").s("msg_id", item.msgId / 100).s("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.cWn().kTy = 1;
        a.cWn().kTw = 0;
        List<d> cWp = a.cWn().cWp();
        d cWq = a.cWn().cWq();
        a.cWn().release();
        if ((cWp == null || cWp.isEmpty()) && cWq == null && this.kTj.getCount() == 0 && this.kTi.getHeaderViewsCount() == 0) {
            a.cWn().kTv.dhP();
            finish();
            return;
        }
        ey(cWp);
        if (cWq != null) {
            a(cWq);
        }
        if (this.kTo != null) {
            this.kTo.tP(this.kTj.getCount() == 0);
        }
    }

    private void ey(List<d> list) {
        if (list != null && list.size() > 0 && this.kTj != null) {
            this.kTj.ez(list);
            if (this.kTj.isHasMore() && this.kTm == null) {
                cWl();
                this.kTi.addFooterView(this.kTm);
            }
        }
    }

    private void a(d dVar) {
        if (this.kTo == null) {
            this.kTo = new ScreenLockHeaderView(getActivity());
            this.kTo.setUIClickListener(this.kTq, this.kTr);
            this.kTo.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.kTi.addHeaderView(this.kTo);
        }
        this.kTo.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.cWn().kTy = 0;
        a.cWn().kTw = 0;
        if (this.kTo != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.kTo.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.kTp);
        a.cWn().release();
        a.cWn().kTy = 0;
        this.kGR = null;
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
            TiebaStatic.log(new an(TbadkCoreStatisticKey.PUSH_CCLICK).s("msg_id", dVar.msgId / 100).s("task_id", dVar.taskId).dh(TiebaInitialize.Params.OBJ_TO, dVar.url).dh("app_version", TbConfig.getVersion()).ag("obj_source", i));
            if (!j.isNetWorkAvailable()) {
                showToast(getResources().getString(R.string.neterror));
            } else if (!TextUtils.isEmpty(dVar.url)) {
                ba.aVa().b(getPageContext(), new String[]{dVar.url + ETAG.ITEM_SEPARATOR + "is_from_push=true"});
                TiebaStatic.log(new an("c10316").dh("obj_type", dVar.stat).ag("obj_locate", 2));
                a.cWn().d(dVar);
                finish();
            } else if (dVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(dVar.groupId, 0L), dVar.groupName, 0L, "from_lock")));
                a.cWn().d(dVar);
                a.cWn().kTv.dhP();
                if (!a.cWn().kTv.dhR()) {
                    a.cWn().kTv.dhQ();
                }
                a.cWn().kTw = 0;
                finish();
            } else if (dVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.kTk.groupId, 0L), dVar.groupName, dVar.nameShow, dVar.kTK, 0, dVar.ktj ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, personalChatActivityConfig));
                a.cWn().d(dVar);
                a.cWn().kTw = 0;
                a.cWn().kTv.dhP();
                if (!a.cWn().kTv.dhR()) {
                    a.cWn().kTv.dhQ();
                }
                finish();
            } else if (dVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.kTk.groupId, 0L), dVar.groupName, dVar.kTK, 0, 4)));
                a.cWn().d(dVar);
                a.cWn().kTw = 0;
                a.cWn().kTv.dhP();
                if (!a.cWn().kTv.dhR()) {
                    a.cWn().kTv.dhQ();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.cWn().d(dVar);
                a.cWn().kTv.dhP();
                if (!a.cWn().kTv.dhR()) {
                    a.cWn().kTv.dhQ();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.cWn().kTv.dhP();
            finish();
            return true;
        } else if (i == 82) {
            a.cWn().kTv.dhP();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String cWm() {
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
