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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.AdExtParam;
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
    private ImageView kiB;
    private Window mWX;
    public c mWZ;
    public d mXa;
    private ScreenLockLoadMoreModel mXd;
    private ScreenLockHeaderView mXe;
    private Drawable mJh = null;
    public DynamicHeightListView mWY = null;
    private int mXb = 0;
    private TextView mXc = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver mXf = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra(TiebaInitialize.LogFields.REASON)) != null && stringExtra.equals("homekey")) {
                a.dGQ().mXl.dTq();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener mXg = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d data;
            if (ScreenLockActivity.this.mXe != null && !StringUtils.isNull(ScreenLockActivity.this.mXe.getInputMsg()) && (data = ScreenLockActivity.this.mXe.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.PUSH_CCLICK).w("msg_id", data.msgId / 100).w("task_id", data.taskId).w(Constants.EXTRA_SERVICE, data.serviceId).dX(AdExtParam.KEY_SHOUBAI_CUID, TbadkCoreApplication.getInst().getCuidGalaxy2()).dX(TiebaInitialize.Params.OBJ_TO, data.url).dX("app_version", TbConfig.getVersion()).an("obj_source", 2).an("obj_id", TbadkCoreApplication.getInst().getStartType()).an("obj_ishost", 1));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.mXe.getInputMsg(), com.baidu.adp.lib.f.b.toLong(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.b.bBd().CU(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.mXe.getInputMsg(), com.baidu.adp.lib.f.b.toLong(data.groupId, 0L), data.userName, data.nameShow, data.mXB);
                    com.baidu.tbadk.coreExtra.messageCenter.b.bBd().CU(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ai("lockscreen_reply", true).start();
                a.dGQ().mXl.dTq();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.mXa = ScreenLockActivity.this.mWZ.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.mXa);
        }
    };
    private View.OnClickListener mXh = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.mXe != null) {
                ScreenLockActivity.this.mXa = ScreenLockActivity.this.mXe.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.mXa);
            }
        }
    };
    private com.baidu.adp.framework.listener.a mXi = new com.baidu.adp.framework.listener.a(1003194, CmdConfigSocket.CMD_SCREEN_LOCK_MESSAGE_MORE) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(R.string.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.mXc != null) {
                            ScreenLockActivity.this.mXc.setText(ScreenLockActivity.this.getResources().getString(R.string.data_load_error));
                            ScreenLockActivity.this.mXc.setEnabled(true);
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
                        ArrayList<d> dGW = data.dGW();
                        if (ScreenLockActivity.this.mWZ != null) {
                            ScreenLockActivity.this.mWZ.fR(dGW);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.mWZ.setHasMore(false);
                            if (ScreenLockActivity.this.mXc != null) {
                                ScreenLockActivity.this.mWY.removeFooterView(ScreenLockActivity.this.mXc);
                                ScreenLockActivity.this.mXc = null;
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
        this.mWX = getWindow();
        this.mWX.addFlags(524288);
        this.mWX.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(R.layout.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.transparent, true);
        if (l.isFlymeOsAbove35()) {
            this.mJh = com.baidu.tieba.v.b.dTu();
            if (this.mJh != null) {
                this.mWX.setBackgroundDrawable(this.mJh);
            }
        }
        this.mXb = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds935) - l.getDimens(getPageContext().getPageActivity(), R.dimen.ds80);
        this.mXd = new ScreenLockLoadMoreModel(this);
        registerListener(this.mXi);
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
        this.kiB = (ImageView) findViewById(R.id.head_close);
        this.kiB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d item;
                if (ScreenLockActivity.this.mWZ.getCount() > 0 && (item = ScreenLockActivity.this.mWZ.getItem(0)) != null) {
                    TiebaStatic.log(new aq("c11704").w("msg_id", item.msgId / 100).w("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.dGQ().mXl.dTq();
            }
        });
        this.mWY = (DynamicHeightListView) findViewById(R.id.screenlock_chat_list_content);
        this.mWZ = new c(getPageContext().getPageActivity());
        this.mWY.setAdapter((ListAdapter) this.mWZ);
        this.mWY.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.mXf, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.dGQ().mXr = false;
        this.mWY.setMaxHeight(this.mXb);
        this.mWY.setTranscriptMode(0);
        this.mWY.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.mXc != null && ScreenLockActivity.this.mXc.getParent() != null) {
                    if (ScreenLockActivity.this.mWY.getHeight() != ScreenLockActivity.this.mXb) {
                        ScreenLockActivity.this.mXc.setText(ScreenLockActivity.this.getResources().getString(R.string.click_load_more));
                        ScreenLockActivity.this.mXc.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.mXc.isEnabled()) {
                            ScreenLockActivity.this.mXc.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                            ScreenLockActivity.this.mXc.setEnabled(false);
                        }
                        ScreenLockActivity.this.cId();
                    }
                }
            }
        });
    }

    private void dGO() {
        this.mXc = new TextView(getActivity());
        this.mXc.setGravity(17);
        this.mXc.setText(R.string.click_load_more);
        this.mXc.setHeight((int) getResources().getDimension(R.dimen.ds80));
        this.mXc.setBackgroundResource(R.drawable.screen_notify_item_background);
        this.mXc.setTextColor(getResources().getColorStateList(R.color.screen_notify_load_more_text_color));
        this.mXc.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        this.mXc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.mXc.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                ScreenLockActivity.this.mXc.setEnabled(false);
                ScreenLockActivity.this.cId();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(dGP())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cId() {
        d item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.mXd.dGX();
            if (this.mWZ != null && this.mWZ.getCount() > 0 && (item = this.mWZ.getItem(0)) != null) {
                TiebaStatic.log(new aq("c11738").w("msg_id", item.msgId / 100).w("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.dGQ().mXo = 1;
        a.dGQ().mXm = 0;
        List<d> dGS = a.dGQ().dGS();
        d dGT = a.dGQ().dGT();
        a.dGQ().release();
        if ((dGS == null || dGS.isEmpty()) && dGT == null && this.mWZ.getCount() == 0 && this.mWY.getHeaderViewsCount() == 0) {
            a.dGQ().mXl.dTq();
            finish();
            return;
        }
        fQ(dGS);
        if (dGT != null) {
            a(dGT);
        }
        if (this.mXe != null) {
            this.mXe.xw(this.mWZ.getCount() == 0);
        }
    }

    private void fQ(List<d> list) {
        if (list != null && list.size() > 0 && this.mWZ != null) {
            this.mWZ.fR(list);
            if (this.mWZ.isHasMore() && this.mXc == null) {
                dGO();
                this.mWY.addFooterView(this.mXc);
            }
        }
    }

    private void a(d dVar) {
        if (this.mXe == null) {
            this.mXe = new ScreenLockHeaderView(getActivity());
            this.mXe.setUIClickListener(this.mXg, this.mXh);
            this.mXe.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.mWY.addHeaderView(this.mXe);
        }
        this.mXe.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.dGQ().mXo = 0;
        a.dGQ().mXm = 0;
        if (this.mXe != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.mXe.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.mXf);
        a.dGQ().release();
        a.dGQ().mXo = 0;
        this.mJh = null;
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
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.PUSH_CCLICK).w("msg_id", dVar.msgId / 100).w("task_id", dVar.taskId).w(Constants.EXTRA_SERVICE, dVar.serviceId).dX(AdExtParam.KEY_SHOUBAI_CUID, TbadkCoreApplication.getInst().getCuidGalaxy2()).dX(TiebaInitialize.Params.OBJ_TO, dVar.url).dX("app_version", TbConfig.getVersion()).an("obj_source", i).an("obj_id", TbadkCoreApplication.getInst().getStartType()).an("obj_ishost", 1));
            if (!j.isNetWorkAvailable()) {
                showToast(getResources().getString(R.string.neterror));
            } else if (!TextUtils.isEmpty(dVar.url)) {
                be.bwv().b(getPageContext(), new String[]{dVar.url + ETAG.ITEM_SEPARATOR + TbWebViewActivityConfig.INTENT_KEY_IS_FROM_PUSH_NOTIFY + "=true"});
                TiebaStatic.log(new aq("c10316").dX("obj_type", dVar.stat).an("obj_locate", 2));
                a.dGQ().d(dVar);
                finish();
            } else if (dVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(dVar.groupId, 0L), dVar.groupName, 0L, "from_lock")));
                a.dGQ().d(dVar);
                a.dGQ().mXl.dTq();
                if (!a.dGQ().mXl.dTs()) {
                    a.dGQ().mXl.dTr();
                }
                a.dGQ().mXm = 0;
                finish();
            } else if (dVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.mXa.groupId, 0L), dVar.groupName, dVar.nameShow, dVar.mXB, 0, dVar.mwz ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, personalChatActivityConfig));
                a.dGQ().d(dVar);
                a.dGQ().mXm = 0;
                a.dGQ().mXl.dTq();
                if (!a.dGQ().mXl.dTs()) {
                    a.dGQ().mXl.dTr();
                }
                finish();
            } else if (dVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.mXa.groupId, 0L), dVar.groupName, dVar.mXB, 0, 4)));
                a.dGQ().d(dVar);
                a.dGQ().mXm = 0;
                a.dGQ().mXl.dTq();
                if (!a.dGQ().mXl.dTs()) {
                    a.dGQ().mXl.dTr();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.dGQ().d(dVar);
                a.dGQ().mXl.dTq();
                if (!a.dGQ().mXl.dTs()) {
                    a.dGQ().mXl.dTr();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.dGQ().mXl.dTq();
            finish();
            return true;
        } else if (i == 82) {
            a.dGQ().mXl.dTq();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String dGP() {
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
