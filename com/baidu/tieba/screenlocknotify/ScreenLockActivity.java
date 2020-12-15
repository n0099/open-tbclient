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
/* loaded from: classes21.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private ImageView jVp;
    public d mRA;
    private ScreenLockLoadMoreModel mRD;
    private ScreenLockHeaderView mRE;
    private Window mRx;
    public c mRz;
    private Drawable mDP = null;
    public DynamicHeightListView mRy = null;
    private int mRB = 0;
    private TextView mRC = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver mRF = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra(TiebaInitialize.LogFields.REASON)) != null && stringExtra.equals("homekey")) {
                a.dHa().mRL.dTy();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener mRG = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d data;
            if (ScreenLockActivity.this.mRE != null && !StringUtils.isNull(ScreenLockActivity.this.mRE.getInputMsg()) && (data = ScreenLockActivity.this.mRE.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.PUSH_CCLICK).w("msg_id", data.msgId / 100).w("task_id", data.taskId).w(Constants.EXTRA_SERVICE, data.serviceId).dY(AdExtParam.KEY_SHOUBAI_CUID, TbadkCoreApplication.getInst().getCuidGalaxy2()).dY(TiebaInitialize.Params.OBJ_TO, data.url).dY("app_version", TbConfig.getVersion()).al("obj_source", 2));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.mRE.getInputMsg(), com.baidu.adp.lib.f.b.toLong(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.b.byI().CX(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.mRE.getInputMsg(), com.baidu.adp.lib.f.b.toLong(data.groupId, 0L), data.userName, data.nameShow, data.mSb);
                    com.baidu.tbadk.coreExtra.messageCenter.b.byI().CX(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new aj("lockscreen_reply", true).start();
                a.dHa().mRL.dTy();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.mRA = ScreenLockActivity.this.mRz.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.mRA);
        }
    };
    private View.OnClickListener mRH = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.mRE != null) {
                ScreenLockActivity.this.mRA = ScreenLockActivity.this.mRE.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.mRA);
            }
        }
    };
    private com.baidu.adp.framework.listener.a mRI = new com.baidu.adp.framework.listener.a(1003194, CmdConfigSocket.CMD_SCREEN_LOCK_MESSAGE_MORE) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(R.string.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.mRC != null) {
                            ScreenLockActivity.this.mRC.setText(ScreenLockActivity.this.getResources().getString(R.string.data_load_error));
                            ScreenLockActivity.this.mRC.setEnabled(true);
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
                        ArrayList<d> dHg = data.dHg();
                        if (ScreenLockActivity.this.mRz != null) {
                            ScreenLockActivity.this.mRz.fR(dHg);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.mRz.setHasMore(false);
                            if (ScreenLockActivity.this.mRC != null) {
                                ScreenLockActivity.this.mRy.removeFooterView(ScreenLockActivity.this.mRC);
                                ScreenLockActivity.this.mRC = null;
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
        this.mRx = getWindow();
        this.mRx.addFlags(524288);
        this.mRx.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(R.layout.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.transparent, true);
        if (l.isFlymeOsAbove35()) {
            this.mDP = com.baidu.tieba.w.b.dTC();
            if (this.mDP != null) {
                this.mRx.setBackgroundDrawable(this.mDP);
            }
        }
        this.mRB = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds935) - l.getDimens(getPageContext().getPageActivity(), R.dimen.ds80);
        this.mRD = new ScreenLockLoadMoreModel(this);
        registerListener(this.mRI);
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
        this.jVp = (ImageView) findViewById(R.id.head_close);
        this.jVp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d item;
                if (ScreenLockActivity.this.mRz.getCount() > 0 && (item = ScreenLockActivity.this.mRz.getItem(0)) != null) {
                    TiebaStatic.log(new ar("c11704").w("msg_id", item.msgId / 100).w("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.dHa().mRL.dTy();
            }
        });
        this.mRy = (DynamicHeightListView) findViewById(R.id.screenlock_chat_list_content);
        this.mRz = new c(getPageContext().getPageActivity());
        this.mRy.setAdapter((ListAdapter) this.mRz);
        this.mRy.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.mRF, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.dHa().mRR = false;
        this.mRy.setMaxHeight(this.mRB);
        this.mRy.setTranscriptMode(0);
        this.mRy.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.mRC != null && ScreenLockActivity.this.mRC.getParent() != null) {
                    if (ScreenLockActivity.this.mRy.getHeight() != ScreenLockActivity.this.mRB) {
                        ScreenLockActivity.this.mRC.setText(ScreenLockActivity.this.getResources().getString(R.string.click_load_more));
                        ScreenLockActivity.this.mRC.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.mRC.isEnabled()) {
                            ScreenLockActivity.this.mRC.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                            ScreenLockActivity.this.mRC.setEnabled(false);
                        }
                        ScreenLockActivity.this.cFi();
                    }
                }
            }
        });
    }

    private void dGY() {
        this.mRC = new TextView(getActivity());
        this.mRC.setGravity(17);
        this.mRC.setText(R.string.click_load_more);
        this.mRC.setHeight((int) getResources().getDimension(R.dimen.ds80));
        this.mRC.setBackgroundResource(R.drawable.screen_notify_item_background);
        this.mRC.setTextColor(getResources().getColorStateList(R.color.screen_notify_load_more_text_color));
        this.mRC.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        this.mRC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.mRC.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                ScreenLockActivity.this.mRC.setEnabled(false);
                ScreenLockActivity.this.cFi();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(dGZ())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFi() {
        d item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.mRD.dHh();
            if (this.mRz != null && this.mRz.getCount() > 0 && (item = this.mRz.getItem(0)) != null) {
                TiebaStatic.log(new ar("c11738").w("msg_id", item.msgId / 100).w("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.dHa().mRO = 1;
        a.dHa().mRM = 0;
        List<d> dHc = a.dHa().dHc();
        d dHd = a.dHa().dHd();
        a.dHa().release();
        if ((dHc == null || dHc.isEmpty()) && dHd == null && this.mRz.getCount() == 0 && this.mRy.getHeaderViewsCount() == 0) {
            a.dHa().mRL.dTy();
            finish();
            return;
        }
        fQ(dHc);
        if (dHd != null) {
            a(dHd);
        }
        if (this.mRE != null) {
            this.mRE.xv(this.mRz.getCount() == 0);
        }
    }

    private void fQ(List<d> list) {
        if (list != null && list.size() > 0 && this.mRz != null) {
            this.mRz.fR(list);
            if (this.mRz.isHasMore() && this.mRC == null) {
                dGY();
                this.mRy.addFooterView(this.mRC);
            }
        }
    }

    private void a(d dVar) {
        if (this.mRE == null) {
            this.mRE = new ScreenLockHeaderView(getActivity());
            this.mRE.setUIClickListener(this.mRG, this.mRH);
            this.mRE.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.mRy.addHeaderView(this.mRE);
        }
        this.mRE.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.dHa().mRO = 0;
        a.dHa().mRM = 0;
        if (this.mRE != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.mRE.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.mRF);
        a.dHa().release();
        a.dHa().mRO = 0;
        this.mDP = null;
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
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.PUSH_CCLICK).w("msg_id", dVar.msgId / 100).w("task_id", dVar.taskId).w(Constants.EXTRA_SERVICE, dVar.serviceId).dY(AdExtParam.KEY_SHOUBAI_CUID, TbadkCoreApplication.getInst().getCuidGalaxy2()).dY(TiebaInitialize.Params.OBJ_TO, dVar.url).dY("app_version", TbConfig.getVersion()).al("obj_source", i));
            if (!j.isNetWorkAvailable()) {
                showToast(getResources().getString(R.string.neterror));
            } else if (!TextUtils.isEmpty(dVar.url)) {
                bf.bua().b(getPageContext(), new String[]{dVar.url + ETAG.ITEM_SEPARATOR + TbWebViewActivityConfig.INTENT_KEY_IS_FROM_PUSH_NOTIFY + "=true"});
                TiebaStatic.log(new ar("c10316").dY("obj_type", dVar.stat).al("obj_locate", 2));
                a.dHa().d(dVar);
                finish();
            } else if (dVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(dVar.groupId, 0L), dVar.groupName, 0L, "from_lock")));
                a.dHa().d(dVar);
                a.dHa().mRL.dTy();
                if (!a.dHa().mRL.dTA()) {
                    a.dHa().mRL.dTz();
                }
                a.dHa().mRM = 0;
                finish();
            } else if (dVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.mRA.groupId, 0L), dVar.groupName, dVar.nameShow, dVar.mSb, 0, dVar.mrm ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, personalChatActivityConfig));
                a.dHa().d(dVar);
                a.dHa().mRM = 0;
                a.dHa().mRL.dTy();
                if (!a.dHa().mRL.dTA()) {
                    a.dHa().mRL.dTz();
                }
                finish();
            } else if (dVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.mRA.groupId, 0L), dVar.groupName, dVar.mSb, 0, 4)));
                a.dHa().d(dVar);
                a.dHa().mRM = 0;
                a.dHa().mRL.dTy();
                if (!a.dHa().mRL.dTA()) {
                    a.dHa().mRL.dTz();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.dHa().d(dVar);
                a.dHa().mRL.dTy();
                if (!a.dHa().mRL.dTA()) {
                    a.dHa().mRL.dTz();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.dHa().mRL.dTy();
            finish();
            return true;
        } else if (i == 82) {
            a.dHa().mRL.dTy();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String dGZ() {
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
