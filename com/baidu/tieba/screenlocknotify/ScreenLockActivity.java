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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
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
    private ImageView ixO;
    private Window nci;
    public c nck;
    public d ncl;
    private ScreenLockLoadMoreModel nco;
    private ScreenLockHeaderView ncp;
    private Drawable mNR = null;
    public DynamicHeightListView ncj = null;
    private int ncm = 0;
    private TextView ncn = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver ncq = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra(TiebaInitialize.LogFields.REASON)) != null && stringExtra.equals("homekey")) {
                a.dFp().ncw.dRR();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener ncr = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d data;
            if (ScreenLockActivity.this.ncp != null && !StringUtils.isNull(ScreenLockActivity.this.ncp.getInputMsg()) && (data = ScreenLockActivity.this.ncp.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.PUSH_CCLICK).v("msg_id", data.msgId / 100).v("task_id", data.taskId).v(Constants.EXTRA_SERVICE, data.serviceId).dR(AdExtParam.KEY_SHOUBAI_CUID, TbadkCoreApplication.getInst().getCuidGalaxy2()).dR(TiebaInitialize.Params.OBJ_TO, data.url).dR("app_version", TbConfig.getVersion()).ap("obj_source", 2).ap("obj_id", TbadkCoreApplication.getInst().getStartType()).ap("obj_ishost", 1));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.ncp.getInputMsg(), com.baidu.adp.lib.f.b.toLong(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.b.bxB().Ca(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.ncp.getInputMsg(), com.baidu.adp.lib.f.b.toLong(data.groupId, 0L), data.userName, data.nameShow, data.ncM);
                    com.baidu.tbadk.coreExtra.messageCenter.b.bxB().Ca(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new aj("lockscreen_reply", true).start();
                a.dFp().ncw.dRR();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.ncl = ScreenLockActivity.this.nck.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.ncl);
        }
    };
    private View.OnClickListener ncs = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.ncp != null) {
                ScreenLockActivity.this.ncl = ScreenLockActivity.this.ncp.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.ncl);
            }
        }
    };
    private com.baidu.adp.framework.listener.a nct = new com.baidu.adp.framework.listener.a(1003194, CmdConfigSocket.CMD_SCREEN_LOCK_MESSAGE_MORE) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(R.string.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.ncn != null) {
                            ScreenLockActivity.this.ncn.setText(ScreenLockActivity.this.getResources().getString(R.string.data_load_error));
                            ScreenLockActivity.this.ncn.setEnabled(true);
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
                        ArrayList<d> dFv = data.dFv();
                        if (ScreenLockActivity.this.nck != null) {
                            ScreenLockActivity.this.nck.fP(dFv);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.nck.setHasMore(false);
                            if (ScreenLockActivity.this.ncn != null) {
                                ScreenLockActivity.this.ncj.removeFooterView(ScreenLockActivity.this.ncn);
                                ScreenLockActivity.this.ncn = null;
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
        this.nci = getWindow();
        this.nci.addFlags(524288);
        this.nci.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(R.layout.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.transparent, true);
        if (l.isFlymeOsAbove35()) {
            this.mNR = com.baidu.tieba.v.b.dRV();
            if (this.mNR != null) {
                this.nci.setBackgroundDrawable(this.mNR);
            }
        }
        this.ncm = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds935) - l.getDimens(getPageContext().getPageActivity(), R.dimen.ds80);
        this.nco = new ScreenLockLoadMoreModel(this);
        registerListener(this.nct);
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
        this.ixO = (ImageView) findViewById(R.id.head_close);
        this.ixO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d item;
                if (ScreenLockActivity.this.nck.getCount() > 0 && (item = ScreenLockActivity.this.nck.getItem(0)) != null) {
                    TiebaStatic.log(new ar("c11704").v("msg_id", item.msgId / 100).v("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.dFp().ncw.dRR();
            }
        });
        this.ncj = (DynamicHeightListView) findViewById(R.id.screenlock_chat_list_content);
        this.nck = new c(getPageContext().getPageActivity());
        this.ncj.setAdapter((ListAdapter) this.nck);
        this.ncj.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.ncq, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.dFp().ncC = false;
        this.ncj.setMaxHeight(this.ncm);
        this.ncj.setTranscriptMode(0);
        this.ncj.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.ncn != null && ScreenLockActivity.this.ncn.getParent() != null) {
                    if (ScreenLockActivity.this.ncj.getHeight() != ScreenLockActivity.this.ncm) {
                        ScreenLockActivity.this.ncn.setText(ScreenLockActivity.this.getResources().getString(R.string.click_load_more));
                        ScreenLockActivity.this.ncn.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.ncn.isEnabled()) {
                            ScreenLockActivity.this.ncn.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                            ScreenLockActivity.this.ncn.setEnabled(false);
                        }
                        ScreenLockActivity.this.cFF();
                    }
                }
            }
        });
    }

    private void cQV() {
        this.ncn = new TextView(getActivity());
        this.ncn.setGravity(17);
        this.ncn.setText(R.string.click_load_more);
        this.ncn.setHeight((int) getResources().getDimension(R.dimen.ds80));
        this.ncn.setBackgroundResource(R.drawable.screen_notify_item_background);
        this.ncn.setTextColor(getResources().getColorStateList(R.color.screen_notify_load_more_text_color));
        this.ncn.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        this.ncn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.ncn.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                ScreenLockActivity.this.ncn.setEnabled(false);
                ScreenLockActivity.this.cFF();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(dFo())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFF() {
        d item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.nco.dFw();
            if (this.nck != null && this.nck.getCount() > 0 && (item = this.nck.getItem(0)) != null) {
                TiebaStatic.log(new ar("c11738").v("msg_id", item.msgId / 100).v("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.dFp().ncz = 1;
        a.dFp().ncx = 0;
        List<d> dFr = a.dFp().dFr();
        d dFs = a.dFp().dFs();
        a.dFp().release();
        if ((dFr == null || dFr.isEmpty()) && dFs == null && this.nck.getCount() == 0 && this.ncj.getHeaderViewsCount() == 0) {
            a.dFp().ncw.dRR();
            finish();
            return;
        }
        fO(dFr);
        if (dFs != null) {
            a(dFs);
        }
        if (this.ncp != null) {
            this.ncp.xL(this.nck.getCount() == 0);
        }
    }

    private void fO(List<d> list) {
        if (list != null && list.size() > 0 && this.nck != null) {
            this.nck.fP(list);
            if (this.nck.isHasMore() && this.ncn == null) {
                cQV();
                this.ncj.addFooterView(this.ncn);
            }
        }
    }

    private void a(d dVar) {
        if (this.ncp == null) {
            this.ncp = new ScreenLockHeaderView(getActivity());
            this.ncp.setUIClickListener(this.ncr, this.ncs);
            this.ncp.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.ncj.addHeaderView(this.ncp);
        }
        this.ncp.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.dFp().ncz = 0;
        a.dFp().ncx = 0;
        if (this.ncp != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.ncp.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.ncq);
        a.dFp().release();
        a.dFp().ncz = 0;
        this.mNR = null;
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
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.PUSH_CCLICK).v("msg_id", dVar.msgId / 100).v("task_id", dVar.taskId).v(Constants.EXTRA_SERVICE, dVar.serviceId).dR(AdExtParam.KEY_SHOUBAI_CUID, TbadkCoreApplication.getInst().getCuidGalaxy2()).dR(TiebaInitialize.Params.OBJ_TO, dVar.url).dR("app_version", TbConfig.getVersion()).ap("obj_source", i).ap("obj_id", TbadkCoreApplication.getInst().getStartType()).ap("obj_ishost", 1));
            if (!j.isNetWorkAvailable()) {
                showToast(getResources().getString(R.string.neterror));
            } else if (!TextUtils.isEmpty(dVar.url)) {
                bf.bsV().b(getPageContext(), new String[]{dVar.url + ETAG.ITEM_SEPARATOR + TbWebViewActivityConfig.INTENT_KEY_IS_FROM_PUSH_NOTIFY + "=true"});
                TiebaStatic.log(new ar("c10316").dR("obj_type", dVar.stat).ap("obj_locate", 2));
                a.dFp().d(dVar);
                finish();
            } else if (dVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(dVar.groupId, 0L), dVar.groupName, 0L, "from_lock")));
                a.dFp().d(dVar);
                a.dFp().ncw.dRR();
                if (!a.dFp().ncw.dRT()) {
                    a.dFp().ncw.dRS();
                }
                a.dFp().ncx = 0;
                finish();
            } else if (dVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.ncl.groupId, 0L), dVar.groupName, dVar.nameShow, dVar.ncM, 0, dVar.mBk ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, personalChatActivityConfig));
                a.dFp().d(dVar);
                a.dFp().ncx = 0;
                a.dFp().ncw.dRR();
                if (!a.dFp().ncw.dRT()) {
                    a.dFp().ncw.dRS();
                }
                finish();
            } else if (dVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.ncl.groupId, 0L), dVar.groupName, dVar.ncM, 0, 4)));
                a.dFp().d(dVar);
                a.dFp().ncx = 0;
                a.dFp().ncw.dRR();
                if (!a.dFp().ncw.dRT()) {
                    a.dFp().ncw.dRS();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.dFp().d(dVar);
                a.dFp().ncw.dRR();
                if (!a.dFp().ncw.dRT()) {
                    a.dFp().ncw.dRS();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.dFp().ncw.dRR();
            finish();
            return true;
        } else if (i == 82) {
            a.dFp().ncw.dRR();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String dFo() {
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
