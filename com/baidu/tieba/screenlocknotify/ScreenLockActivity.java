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
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreHttpResponseMessage;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreModel;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreSocketResponseMessage;
import com.baidu.tieba.screenlocknotify.view.ScreenLockHeaderView;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    private ImageView fNR;
    private ScreenLockLoadMoreModel ipB;
    private ScreenLockHeaderView ipC;
    private Window ipv;
    public c ipx;
    public d ipy;
    private Drawable idH = null;
    public DynamicHeightListView ipw = null;
    private int ipz = 0;
    private TextView ipA = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver ipD = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                a.bYg().ipJ.ciD();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener ipE = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d data;
            if (ScreenLockActivity.this.ipC != null && !StringUtils.isNull(ScreenLockActivity.this.ipC.getInputMsg()) && (data = ScreenLockActivity.this.ipC.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new am("c11703").k("msg_id", data.msgId / 100).k("task_id", data.taskId).bJ("obj_to", data.url).bJ(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.ipC.getInputMsg(), com.baidu.adp.lib.g.b.d(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.b.ahA().nK(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.ipC.getInputMsg(), com.baidu.adp.lib.g.b.d(data.groupId, 0L), data.userName, data.nameShow, data.ipZ);
                    com.baidu.tbadk.coreExtra.messageCenter.b.ahA().nK(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.bYg().ipJ.ciD();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.ipy = ScreenLockActivity.this.ipx.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.ipy);
        }
    };
    private View.OnClickListener ipF = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.ipC != null) {
                ScreenLockActivity.this.ipy = ScreenLockActivity.this.ipC.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.ipy);
            }
        }
    };
    private com.baidu.adp.framework.listener.a ipG = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(d.j.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.ipA != null) {
                            ScreenLockActivity.this.ipA.setText(ScreenLockActivity.this.getResources().getString(d.j.data_load_error));
                            ScreenLockActivity.this.ipA.setEnabled(true);
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
                        ArrayList<d> bYm = data.bYm();
                        if (ScreenLockActivity.this.ipx != null) {
                            ScreenLockActivity.this.ipx.dT(bYm);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.ipx.setHasMore(false);
                            if (ScreenLockActivity.this.ipA != null) {
                                ScreenLockActivity.this.ipw.removeFooterView(ScreenLockActivity.this.ipA);
                                ScreenLockActivity.this.ipA = null;
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
        this.ipv = getWindow();
        this.ipv.addFlags(524288);
        this.ipv.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(d.h.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.C0236d.transparent, true);
        if (l.lr()) {
            this.idH = com.baidu.tieba.t.b.ciG();
            if (this.idH != null) {
                this.ipv.setBackgroundDrawable(this.idH);
            }
        }
        this.ipz = l.h(getPageContext().getPageActivity(), d.e.ds935) - l.h(getPageContext().getPageActivity(), d.e.ds80);
        this.ipB = new ScreenLockLoadMoreModel(this);
        registerListener(this.ipG);
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
        this.fNR = (ImageView) findViewById(d.g.head_close);
        this.fNR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d item;
                if (ScreenLockActivity.this.ipx.getCount() > 0 && (item = ScreenLockActivity.this.ipx.getItem(0)) != null) {
                    TiebaStatic.log(new am("c11704").k("msg_id", item.msgId / 100).k("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.bYg().ipJ.ciD();
            }
        });
        this.ipw = (DynamicHeightListView) findViewById(d.g.screenlock_chat_list_content);
        this.ipx = new c(getPageContext().getPageActivity());
        this.ipw.setAdapter((ListAdapter) this.ipx);
        this.ipw.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.ipD, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.bYg().ipP = false;
        this.ipw.setMaxHeight(this.ipz);
        this.ipw.setTranscriptMode(0);
        this.ipw.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.ipA != null && ScreenLockActivity.this.ipA.getParent() != null) {
                    if (ScreenLockActivity.this.ipw.getHeight() != ScreenLockActivity.this.ipz) {
                        ScreenLockActivity.this.ipA.setText(ScreenLockActivity.this.getResources().getString(d.j.click_load_more));
                        ScreenLockActivity.this.ipA.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.ipA.isEnabled()) {
                            ScreenLockActivity.this.ipA.setText(ScreenLockActivity.this.getResources().getString(d.j.loading));
                            ScreenLockActivity.this.ipA.setEnabled(false);
                        }
                        ScreenLockActivity.this.bfa();
                    }
                }
            }
        });
    }

    private void bYe() {
        this.ipA = new TextView(getActivity());
        this.ipA.setGravity(17);
        this.ipA.setText(d.j.click_load_more);
        this.ipA.setHeight((int) getResources().getDimension(d.e.ds80));
        this.ipA.setBackgroundResource(d.f.screen_notify_item_background);
        this.ipA.setTextColor(getResources().getColorStateList(d.C0236d.screen_notify_load_more_text_color));
        this.ipA.setTextSize(0, getResources().getDimension(d.e.fontsize32));
        this.ipA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.ipA.setText(ScreenLockActivity.this.getResources().getString(d.j.loading));
                ScreenLockActivity.this.ipA.setEnabled(false);
                ScreenLockActivity.this.bfa();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(bYf())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfa() {
        d item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.ipB.bYn();
            if (this.ipx != null && this.ipx.getCount() > 0 && (item = this.ipx.getItem(0)) != null) {
                TiebaStatic.log(new am("c11738").k("msg_id", item.msgId / 100).k("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.bYg().ipM = 1;
        a.bYg().ipK = 0;
        List<d> bYi = a.bYg().bYi();
        d bYj = a.bYg().bYj();
        a.bYg().release();
        if ((bYi == null || bYi.isEmpty()) && bYj == null && this.ipx.getCount() == 0 && this.ipw.getHeaderViewsCount() == 0) {
            a.bYg().ipJ.ciD();
            finish();
            return;
        }
        dS(bYi);
        if (bYj != null) {
            a(bYj);
        }
        if (this.ipC != null) {
            this.ipC.pu(this.ipx.getCount() == 0);
        }
    }

    private void dS(List<d> list) {
        if (list != null && list.size() > 0 && this.ipx != null) {
            this.ipx.dT(list);
            if (this.ipx.isHasMore() && this.ipA == null) {
                bYe();
                this.ipw.addFooterView(this.ipA);
            }
        }
    }

    private void a(d dVar) {
        if (this.ipC == null) {
            this.ipC = new ScreenLockHeaderView(getActivity());
            this.ipC.setUIClickListener(this.ipE, this.ipF);
            this.ipC.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.ipw.addHeaderView(this.ipC);
        }
        this.ipC.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.bYg().ipM = 0;
        a.bYg().ipK = 0;
        if (this.ipC != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.ipC.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.ipD);
        a.bYg().release();
        a.bYg().ipM = 0;
        this.idH = null;
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
            TiebaStatic.log(new am("c11703").k("msg_id", dVar.msgId / 100).k("task_id", dVar.taskId).bJ("obj_to", dVar.url).bJ(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, i));
            if (!j.kY()) {
                showToast(getResources().getString(d.j.neterror));
            } else if (!TextUtils.isEmpty(dVar.url)) {
                ba.adD().c(getPageContext(), new String[]{dVar.url + "&is_from_push=true"});
                TiebaStatic.log(new am("c10316").bJ("obj_type", dVar.stat).T("obj_locate", 2));
                a.bYg().d(dVar);
                finish();
            } else if (dVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(dVar.groupId, 0L), dVar.groupName, 0L, "from_lock")));
                a.bYg().d(dVar);
                a.bYg().ipJ.ciD();
                if (!a.bYg().ipJ.ciF()) {
                    a.bYg().ipJ.ciE();
                }
                a.bYg().ipK = 0;
                finish();
            } else if (dVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(this.ipy.groupId, 0L), dVar.groupName, dVar.nameShow, dVar.ipZ, 0, dVar.hRC ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
                a.bYg().d(dVar);
                a.bYg().ipK = 0;
                a.bYg().ipJ.ciD();
                if (!a.bYg().ipJ.ciF()) {
                    a.bYg().ipJ.ciE();
                }
                finish();
            } else if (dVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(this.ipy.groupId, 0L), dVar.groupName, dVar.ipZ, 0, 4)));
                a.bYg().d(dVar);
                a.bYg().ipK = 0;
                a.bYg().ipJ.ciD();
                if (!a.bYg().ipJ.ciF()) {
                    a.bYg().ipJ.ciE();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.bYg().d(dVar);
                a.bYg().ipJ.ciD();
                if (!a.bYg().ipJ.ciF()) {
                    a.bYg().ipJ.ciE();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.bYg().ipJ.ciD();
            finish();
            return true;
        } else if (i == 82) {
            a.bYg().ipJ.ciD();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String bYf() {
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
