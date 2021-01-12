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
/* loaded from: classes7.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private ImageView kdU;
    private Window mSl;
    public c mSn;
    public d mSo;
    private ScreenLockLoadMoreModel mSs;
    private ScreenLockHeaderView mSt;
    private Drawable mEx = null;
    public DynamicHeightListView mSm = null;
    private int mSq = 0;
    private TextView mSr = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver mSu = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra(TiebaInitialize.LogFields.REASON)) != null && stringExtra.equals("homekey")) {
                a.dCY().mSA.dPy();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener mSv = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d data;
            if (ScreenLockActivity.this.mSt != null && !StringUtils.isNull(ScreenLockActivity.this.mSt.getInputMsg()) && (data = ScreenLockActivity.this.mSt.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.PUSH_CCLICK).w("msg_id", data.msgId / 100).w("task_id", data.taskId).w(Constants.EXTRA_SERVICE, data.serviceId).dW(AdExtParam.KEY_SHOUBAI_CUID, TbadkCoreApplication.getInst().getCuidGalaxy2()).dW(TiebaInitialize.Params.OBJ_TO, data.url).dW("app_version", TbConfig.getVersion()).an("obj_source", 2).an("obj_id", TbadkCoreApplication.getInst().getStartType()).an("obj_ishost", 1));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.mSt.getInputMsg(), com.baidu.adp.lib.f.b.toLong(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.b.bxj().BJ(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.mSt.getInputMsg(), com.baidu.adp.lib.f.b.toLong(data.groupId, 0L), data.userName, data.nameShow, data.mSR);
                    com.baidu.tbadk.coreExtra.messageCenter.b.bxj().BJ(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ai("lockscreen_reply", true).start();
                a.dCY().mSA.dPy();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.mSo = ScreenLockActivity.this.mSn.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.mSo);
        }
    };
    private View.OnClickListener mSw = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.mSt != null) {
                ScreenLockActivity.this.mSo = ScreenLockActivity.this.mSt.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.mSo);
            }
        }
    };
    private com.baidu.adp.framework.listener.a mSx = new com.baidu.adp.framework.listener.a(1003194, CmdConfigSocket.CMD_SCREEN_LOCK_MESSAGE_MORE) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(R.string.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.mSr != null) {
                            ScreenLockActivity.this.mSr.setText(ScreenLockActivity.this.getResources().getString(R.string.data_load_error));
                            ScreenLockActivity.this.mSr.setEnabled(true);
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
                        ArrayList<d> dDe = data.dDe();
                        if (ScreenLockActivity.this.mSn != null) {
                            ScreenLockActivity.this.mSn.fR(dDe);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.mSn.setHasMore(false);
                            if (ScreenLockActivity.this.mSr != null) {
                                ScreenLockActivity.this.mSm.removeFooterView(ScreenLockActivity.this.mSr);
                                ScreenLockActivity.this.mSr = null;
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
        this.mSl = getWindow();
        this.mSl.addFlags(524288);
        this.mSl.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(R.layout.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.transparent, true);
        if (l.isFlymeOsAbove35()) {
            this.mEx = com.baidu.tieba.v.b.dPC();
            if (this.mEx != null) {
                this.mSl.setBackgroundDrawable(this.mEx);
            }
        }
        this.mSq = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds935) - l.getDimens(getPageContext().getPageActivity(), R.dimen.ds80);
        this.mSs = new ScreenLockLoadMoreModel(this);
        registerListener(this.mSx);
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
        this.kdU = (ImageView) findViewById(R.id.head_close);
        this.kdU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d item;
                if (ScreenLockActivity.this.mSn.getCount() > 0 && (item = ScreenLockActivity.this.mSn.getItem(0)) != null) {
                    TiebaStatic.log(new aq("c11704").w("msg_id", item.msgId / 100).w("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.dCY().mSA.dPy();
            }
        });
        this.mSm = (DynamicHeightListView) findViewById(R.id.screenlock_chat_list_content);
        this.mSn = new c(getPageContext().getPageActivity());
        this.mSm.setAdapter((ListAdapter) this.mSn);
        this.mSm.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.mSu, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.dCY().mSG = false;
        this.mSm.setMaxHeight(this.mSq);
        this.mSm.setTranscriptMode(0);
        this.mSm.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.mSr != null && ScreenLockActivity.this.mSr.getParent() != null) {
                    if (ScreenLockActivity.this.mSm.getHeight() != ScreenLockActivity.this.mSq) {
                        ScreenLockActivity.this.mSr.setText(ScreenLockActivity.this.getResources().getString(R.string.click_load_more));
                        ScreenLockActivity.this.mSr.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.mSr.isEnabled()) {
                            ScreenLockActivity.this.mSr.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                            ScreenLockActivity.this.mSr.setEnabled(false);
                        }
                        ScreenLockActivity.this.cEl();
                    }
                }
            }
        });
    }

    private void dCW() {
        this.mSr = new TextView(getActivity());
        this.mSr.setGravity(17);
        this.mSr.setText(R.string.click_load_more);
        this.mSr.setHeight((int) getResources().getDimension(R.dimen.ds80));
        this.mSr.setBackgroundResource(R.drawable.screen_notify_item_background);
        this.mSr.setTextColor(getResources().getColorStateList(R.color.screen_notify_load_more_text_color));
        this.mSr.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        this.mSr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.mSr.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                ScreenLockActivity.this.mSr.setEnabled(false);
                ScreenLockActivity.this.cEl();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(dCX())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEl() {
        d item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.mSs.dDf();
            if (this.mSn != null && this.mSn.getCount() > 0 && (item = this.mSn.getItem(0)) != null) {
                TiebaStatic.log(new aq("c11738").w("msg_id", item.msgId / 100).w("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.dCY().mSD = 1;
        a.dCY().mSB = 0;
        List<d> dDa = a.dCY().dDa();
        d dDb = a.dCY().dDb();
        a.dCY().release();
        if ((dDa == null || dDa.isEmpty()) && dDb == null && this.mSn.getCount() == 0 && this.mSm.getHeaderViewsCount() == 0) {
            a.dCY().mSA.dPy();
            finish();
            return;
        }
        fQ(dDa);
        if (dDb != null) {
            a(dDb);
        }
        if (this.mSt != null) {
            this.mSt.xs(this.mSn.getCount() == 0);
        }
    }

    private void fQ(List<d> list) {
        if (list != null && list.size() > 0 && this.mSn != null) {
            this.mSn.fR(list);
            if (this.mSn.isHasMore() && this.mSr == null) {
                dCW();
                this.mSm.addFooterView(this.mSr);
            }
        }
    }

    private void a(d dVar) {
        if (this.mSt == null) {
            this.mSt = new ScreenLockHeaderView(getActivity());
            this.mSt.setUIClickListener(this.mSv, this.mSw);
            this.mSt.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.mSm.addHeaderView(this.mSt);
        }
        this.mSt.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.dCY().mSD = 0;
        a.dCY().mSB = 0;
        if (this.mSt != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.mSt.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.mSu);
        a.dCY().release();
        a.dCY().mSD = 0;
        this.mEx = null;
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
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.PUSH_CCLICK).w("msg_id", dVar.msgId / 100).w("task_id", dVar.taskId).w(Constants.EXTRA_SERVICE, dVar.serviceId).dW(AdExtParam.KEY_SHOUBAI_CUID, TbadkCoreApplication.getInst().getCuidGalaxy2()).dW(TiebaInitialize.Params.OBJ_TO, dVar.url).dW("app_version", TbConfig.getVersion()).an("obj_source", i).an("obj_id", TbadkCoreApplication.getInst().getStartType()).an("obj_ishost", 1));
            if (!j.isNetWorkAvailable()) {
                showToast(getResources().getString(R.string.neterror));
            } else if (!TextUtils.isEmpty(dVar.url)) {
                be.bsB().b(getPageContext(), new String[]{dVar.url + ETAG.ITEM_SEPARATOR + TbWebViewActivityConfig.INTENT_KEY_IS_FROM_PUSH_NOTIFY + "=true"});
                TiebaStatic.log(new aq("c10316").dW("obj_type", dVar.stat).an("obj_locate", 2));
                a.dCY().d(dVar);
                finish();
            } else if (dVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(dVar.groupId, 0L), dVar.groupName, 0L, "from_lock")));
                a.dCY().d(dVar);
                a.dCY().mSA.dPy();
                if (!a.dCY().mSA.dPA()) {
                    a.dCY().mSA.dPz();
                }
                a.dCY().mSB = 0;
                finish();
            } else if (dVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.mSo.groupId, 0L), dVar.groupName, dVar.nameShow, dVar.mSR, 0, dVar.mrU ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, personalChatActivityConfig));
                a.dCY().d(dVar);
                a.dCY().mSB = 0;
                a.dCY().mSA.dPy();
                if (!a.dCY().mSA.dPA()) {
                    a.dCY().mSA.dPz();
                }
                finish();
            } else if (dVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.mSo.groupId, 0L), dVar.groupName, dVar.mSR, 0, 4)));
                a.dCY().d(dVar);
                a.dCY().mSB = 0;
                a.dCY().mSA.dPy();
                if (!a.dCY().mSA.dPA()) {
                    a.dCY().mSA.dPz();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.dCY().d(dVar);
                a.dCY().mSA.dPy();
                if (!a.dCY().mSA.dPA()) {
                    a.dCY().mSA.dPz();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.dCY().mSA.dPy();
            finish();
            return true;
        } else if (i == 82) {
            a.dCY().mSA.dPy();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String dCX() {
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
