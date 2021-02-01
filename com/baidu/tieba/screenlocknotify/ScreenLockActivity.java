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
    private ImageView ixA;
    private Window nbI;
    public c nbK;
    public d nbL;
    private ScreenLockLoadMoreModel nbO;
    private ScreenLockHeaderView nbP;
    private Drawable mNC = null;
    public DynamicHeightListView nbJ = null;
    private int nbM = 0;
    private TextView nbN = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver nbQ = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra(TiebaInitialize.LogFields.REASON)) != null && stringExtra.equals("homekey")) {
                a.dFh().nbW.dRJ();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener nbR = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d data;
            if (ScreenLockActivity.this.nbP != null && !StringUtils.isNull(ScreenLockActivity.this.nbP.getInputMsg()) && (data = ScreenLockActivity.this.nbP.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.PUSH_CCLICK).v("msg_id", data.msgId / 100).v("task_id", data.taskId).v(Constants.EXTRA_SERVICE, data.serviceId).dR(AdExtParam.KEY_SHOUBAI_CUID, TbadkCoreApplication.getInst().getCuidGalaxy2()).dR(TiebaInitialize.Params.OBJ_TO, data.url).dR("app_version", TbConfig.getVersion()).ap("obj_source", 2).ap("obj_id", TbadkCoreApplication.getInst().getStartType()).ap("obj_ishost", 1));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.nbP.getInputMsg(), com.baidu.adp.lib.f.b.toLong(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.b.bxB().Ca(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.nbP.getInputMsg(), com.baidu.adp.lib.f.b.toLong(data.groupId, 0L), data.userName, data.nameShow, data.ncm);
                    com.baidu.tbadk.coreExtra.messageCenter.b.bxB().Ca(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new aj("lockscreen_reply", true).start();
                a.dFh().nbW.dRJ();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.nbL = ScreenLockActivity.this.nbK.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.nbL);
        }
    };
    private View.OnClickListener nbS = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.nbP != null) {
                ScreenLockActivity.this.nbL = ScreenLockActivity.this.nbP.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.nbL);
            }
        }
    };
    private com.baidu.adp.framework.listener.a nbT = new com.baidu.adp.framework.listener.a(1003194, CmdConfigSocket.CMD_SCREEN_LOCK_MESSAGE_MORE) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(R.string.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.nbN != null) {
                            ScreenLockActivity.this.nbN.setText(ScreenLockActivity.this.getResources().getString(R.string.data_load_error));
                            ScreenLockActivity.this.nbN.setEnabled(true);
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
                        ArrayList<d> dFn = data.dFn();
                        if (ScreenLockActivity.this.nbK != null) {
                            ScreenLockActivity.this.nbK.fP(dFn);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.nbK.setHasMore(false);
                            if (ScreenLockActivity.this.nbN != null) {
                                ScreenLockActivity.this.nbJ.removeFooterView(ScreenLockActivity.this.nbN);
                                ScreenLockActivity.this.nbN = null;
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
        this.nbI = getWindow();
        this.nbI.addFlags(524288);
        this.nbI.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(R.layout.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.transparent, true);
        if (l.isFlymeOsAbove35()) {
            this.mNC = com.baidu.tieba.v.b.dRN();
            if (this.mNC != null) {
                this.nbI.setBackgroundDrawable(this.mNC);
            }
        }
        this.nbM = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds935) - l.getDimens(getPageContext().getPageActivity(), R.dimen.ds80);
        this.nbO = new ScreenLockLoadMoreModel(this);
        registerListener(this.nbT);
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
        this.ixA = (ImageView) findViewById(R.id.head_close);
        this.ixA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d item;
                if (ScreenLockActivity.this.nbK.getCount() > 0 && (item = ScreenLockActivity.this.nbK.getItem(0)) != null) {
                    TiebaStatic.log(new ar("c11704").v("msg_id", item.msgId / 100).v("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.dFh().nbW.dRJ();
            }
        });
        this.nbJ = (DynamicHeightListView) findViewById(R.id.screenlock_chat_list_content);
        this.nbK = new c(getPageContext().getPageActivity());
        this.nbJ.setAdapter((ListAdapter) this.nbK);
        this.nbJ.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.nbQ, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.dFh().ncc = false;
        this.nbJ.setMaxHeight(this.nbM);
        this.nbJ.setTranscriptMode(0);
        this.nbJ.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.nbN != null && ScreenLockActivity.this.nbN.getParent() != null) {
                    if (ScreenLockActivity.this.nbJ.getHeight() != ScreenLockActivity.this.nbM) {
                        ScreenLockActivity.this.nbN.setText(ScreenLockActivity.this.getResources().getString(R.string.click_load_more));
                        ScreenLockActivity.this.nbN.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.nbN.isEnabled()) {
                            ScreenLockActivity.this.nbN.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                            ScreenLockActivity.this.nbN.setEnabled(false);
                        }
                        ScreenLockActivity.this.cFy();
                    }
                }
            }
        });
    }

    private void cQO() {
        this.nbN = new TextView(getActivity());
        this.nbN.setGravity(17);
        this.nbN.setText(R.string.click_load_more);
        this.nbN.setHeight((int) getResources().getDimension(R.dimen.ds80));
        this.nbN.setBackgroundResource(R.drawable.screen_notify_item_background);
        this.nbN.setTextColor(getResources().getColorStateList(R.color.screen_notify_load_more_text_color));
        this.nbN.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        this.nbN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.nbN.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                ScreenLockActivity.this.nbN.setEnabled(false);
                ScreenLockActivity.this.cFy();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(dFg())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFy() {
        d item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.nbO.dFo();
            if (this.nbK != null && this.nbK.getCount() > 0 && (item = this.nbK.getItem(0)) != null) {
                TiebaStatic.log(new ar("c11738").v("msg_id", item.msgId / 100).v("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.dFh().nbZ = 1;
        a.dFh().nbX = 0;
        List<d> dFj = a.dFh().dFj();
        d dFk = a.dFh().dFk();
        a.dFh().release();
        if ((dFj == null || dFj.isEmpty()) && dFk == null && this.nbK.getCount() == 0 && this.nbJ.getHeaderViewsCount() == 0) {
            a.dFh().nbW.dRJ();
            finish();
            return;
        }
        fO(dFj);
        if (dFk != null) {
            a(dFk);
        }
        if (this.nbP != null) {
            this.nbP.xL(this.nbK.getCount() == 0);
        }
    }

    private void fO(List<d> list) {
        if (list != null && list.size() > 0 && this.nbK != null) {
            this.nbK.fP(list);
            if (this.nbK.isHasMore() && this.nbN == null) {
                cQO();
                this.nbJ.addFooterView(this.nbN);
            }
        }
    }

    private void a(d dVar) {
        if (this.nbP == null) {
            this.nbP = new ScreenLockHeaderView(getActivity());
            this.nbP.setUIClickListener(this.nbR, this.nbS);
            this.nbP.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.nbJ.addHeaderView(this.nbP);
        }
        this.nbP.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.dFh().nbZ = 0;
        a.dFh().nbX = 0;
        if (this.nbP != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.nbP.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.nbQ);
        a.dFh().release();
        a.dFh().nbZ = 0;
        this.mNC = null;
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
                a.dFh().d(dVar);
                finish();
            } else if (dVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(dVar.groupId, 0L), dVar.groupName, 0L, "from_lock")));
                a.dFh().d(dVar);
                a.dFh().nbW.dRJ();
                if (!a.dFh().nbW.dRL()) {
                    a.dFh().nbW.dRK();
                }
                a.dFh().nbX = 0;
                finish();
            } else if (dVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.nbL.groupId, 0L), dVar.groupName, dVar.nameShow, dVar.ncm, 0, dVar.mAU ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, personalChatActivityConfig));
                a.dFh().d(dVar);
                a.dFh().nbX = 0;
                a.dFh().nbW.dRJ();
                if (!a.dFh().nbW.dRL()) {
                    a.dFh().nbW.dRK();
                }
                finish();
            } else if (dVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(this.nbL.groupId, 0L), dVar.groupName, dVar.ncm, 0, 4)));
                a.dFh().d(dVar);
                a.dFh().nbX = 0;
                a.dFh().nbW.dRJ();
                if (!a.dFh().nbW.dRL()) {
                    a.dFh().nbW.dRK();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.dFh().d(dVar);
                a.dFh().nbW.dRJ();
                if (!a.dFh().nbW.dRL()) {
                    a.dFh().nbW.dRK();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.dFh().nbW.dRJ();
            finish();
            return true;
        } else if (i == 82) {
            a.dFh().nbW.dRJ();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String dFg() {
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
