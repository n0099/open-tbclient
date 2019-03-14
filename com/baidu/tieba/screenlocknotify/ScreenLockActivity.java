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
    private ImageView fNQ;
    private Window ipo;
    public c ipq;
    public d ipr;
    private ScreenLockLoadMoreModel ipu;
    private ScreenLockHeaderView ipv;
    private Drawable idB = null;
    public DynamicHeightListView ipp = null;
    private int ips = 0;
    private TextView ipt = null;
    private boolean mIsLoading = false;
    private BroadcastReceiver ipw = new BroadcastReceiver() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                a.bYi().ipC.ciG();
                ScreenLockActivity.this.finish();
            }
        }
    };
    View.OnClickListener ipx = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d data;
            if (ScreenLockActivity.this.ipv != null && !StringUtils.isNull(ScreenLockActivity.this.ipv.getInputMsg()) && (data = ScreenLockActivity.this.ipv.getData()) != null) {
                if (data.customGroupType == 4) {
                    TiebaStatic.log(new am("c11703").k("msg_id", data.msgId / 100).k("task_id", data.taskId).bJ("obj_to", data.url).bJ(Constants.EXTRA_KEY_APP_VERSION, TbConfig.getVersion()).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                }
                if (data.customGroupType == 1) {
                    MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.ipv.getInputMsg(), com.baidu.adp.lib.g.b.d(data.groupId, 0L));
                    com.baidu.tbadk.coreExtra.messageCenter.b.ahA().nK(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                } else if (data.customGroupType == 2) {
                    MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.ipv.getInputMsg(), com.baidu.adp.lib.g.b.d(data.groupId, 0L), data.userName, data.nameShow, data.ipS);
                    com.baidu.tbadk.coreExtra.messageCenter.b.ahA().nK(data.groupId);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                    MessageUtils.sendHasReadMessage(data.groupId, 2);
                }
                new ag("lockscreen_reply", true).start();
                a.bYi().ipC.ciG();
                ScreenLockActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity.this.ipr = ScreenLockActivity.this.ipq.getItem(i);
            ScreenLockActivity.this.b(ScreenLockActivity.this.ipr);
        }
    };
    private View.OnClickListener ipy = new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.ipv != null) {
                ScreenLockActivity.this.ipr = ScreenLockActivity.this.ipv.getData();
                ScreenLockActivity.this.b(ScreenLockActivity.this.ipr);
            }
        }
    };
    private com.baidu.adp.framework.listener.a ipz = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420) { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.8
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage responsedMessage) {
            com.baidu.tieba.screenlocknotify.loadmore.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(d.j.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (ScreenLockActivity.this.ipt != null) {
                            ScreenLockActivity.this.ipt.setText(ScreenLockActivity.this.getResources().getString(d.j.data_load_error));
                            ScreenLockActivity.this.ipt.setEnabled(true);
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
                        ArrayList<d> bYo = data.bYo();
                        if (ScreenLockActivity.this.ipq != null) {
                            ScreenLockActivity.this.ipq.dT(bYo);
                        }
                        if (!data.isHasMore()) {
                            ScreenLockActivity.this.ipq.setHasMore(false);
                            if (ScreenLockActivity.this.ipt != null) {
                                ScreenLockActivity.this.ipp.removeFooterView(ScreenLockActivity.this.ipt);
                                ScreenLockActivity.this.ipt = null;
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
        this.ipo = getWindow();
        this.ipo.addFlags(524288);
        this.ipo.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(d.h.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(d.C0277d.transparent, true);
        if (l.lr()) {
            this.idB = com.baidu.tieba.t.b.ciJ();
            if (this.idB != null) {
                this.ipo.setBackgroundDrawable(this.idB);
            }
        }
        this.ips = l.h(getPageContext().getPageActivity(), d.e.ds935) - l.h(getPageContext().getPageActivity(), d.e.ds80);
        this.ipu = new ScreenLockLoadMoreModel(this);
        registerListener(this.ipz);
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
        this.fNQ = (ImageView) findViewById(d.g.head_close);
        this.fNQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d item;
                if (ScreenLockActivity.this.ipq.getCount() > 0 && (item = ScreenLockActivity.this.ipq.getItem(0)) != null) {
                    TiebaStatic.log(new am("c11704").k("msg_id", item.msgId / 100).k("task_id", item.taskId));
                }
                ScreenLockActivity.this.finish();
                a.bYi().ipC.ciG();
            }
        });
        this.ipp = (DynamicHeightListView) findViewById(d.g.screenlock_chat_list_content);
        this.ipq = new c(getPageContext().getPageActivity());
        this.ipp.setAdapter((ListAdapter) this.ipq);
        this.ipp.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.ipw, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        a.bYi().ipI = false;
        this.ipp.setMaxHeight(this.ips);
        this.ipp.setTranscriptMode(0);
        this.ipp.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (ScreenLockActivity.this.ipt != null && ScreenLockActivity.this.ipt.getParent() != null) {
                    if (ScreenLockActivity.this.ipp.getHeight() != ScreenLockActivity.this.ips) {
                        ScreenLockActivity.this.ipt.setText(ScreenLockActivity.this.getResources().getString(d.j.click_load_more));
                        ScreenLockActivity.this.ipt.setEnabled(true);
                    } else if (i + i2 == i3) {
                        if (ScreenLockActivity.this.ipt.isEnabled()) {
                            ScreenLockActivity.this.ipt.setText(ScreenLockActivity.this.getResources().getString(d.j.loading));
                            ScreenLockActivity.this.ipt.setEnabled(false);
                        }
                        ScreenLockActivity.this.beZ();
                    }
                }
            }
        });
    }

    private void bYg() {
        this.ipt = new TextView(getActivity());
        this.ipt.setGravity(17);
        this.ipt.setText(d.j.click_load_more);
        this.ipt.setHeight((int) getResources().getDimension(d.e.ds80));
        this.ipt.setBackgroundResource(d.f.screen_notify_item_background);
        this.ipt.setTextColor(getResources().getColorStateList(d.C0277d.screen_notify_load_more_text_color));
        this.ipt.setTextSize(0, getResources().getDimension(d.e.fontsize32));
        this.ipt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.screenlocknotify.ScreenLockActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenLockActivity.this.ipt.setText(ScreenLockActivity.this.getResources().getString(d.j.loading));
                ScreenLockActivity.this.ipt.setEnabled(false);
                ScreenLockActivity.this.beZ();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(bYh())) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beZ() {
        d item;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            this.ipu.bYp();
            if (this.ipq != null && this.ipq.getCount() > 0 && (item = this.ipq.getItem(0)) != null) {
                TiebaStatic.log(new am("c11738").k("msg_id", item.msgId / 100).k("task_id", item.taskId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a.bYi().ipF = 1;
        a.bYi().ipD = 0;
        List<d> bYk = a.bYi().bYk();
        d bYl = a.bYi().bYl();
        a.bYi().release();
        if ((bYk == null || bYk.isEmpty()) && bYl == null && this.ipq.getCount() == 0 && this.ipp.getHeaderViewsCount() == 0) {
            a.bYi().ipC.ciG();
            finish();
            return;
        }
        dS(bYk);
        if (bYl != null) {
            a(bYl);
        }
        if (this.ipv != null) {
            this.ipv.pu(this.ipq.getCount() == 0);
        }
    }

    private void dS(List<d> list) {
        if (list != null && list.size() > 0 && this.ipq != null) {
            this.ipq.dT(list);
            if (this.ipq.isHasMore() && this.ipt == null) {
                bYg();
                this.ipp.addFooterView(this.ipt);
            }
        }
    }

    private void a(d dVar) {
        if (this.ipv == null) {
            this.ipv = new ScreenLockHeaderView(getActivity());
            this.ipv.setUIClickListener(this.ipx, this.ipy);
            this.ipv.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.ipp.addHeaderView(this.ipv);
        }
        this.ipv.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a.bYi().ipF = 0;
        a.bYi().ipD = 0;
        if (this.ipv != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.ipv.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.ipw);
        a.bYi().release();
        a.bYi().ipF = 0;
        this.idB = null;
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
                a.bYi().d(dVar);
                finish();
            } else if (dVar.customGroupType == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(dVar.groupId, 0L), dVar.groupName, 0L, "from_lock")));
                a.bYi().d(dVar);
                a.bYi().ipC.ciG();
                if (!a.bYi().ipC.ciI()) {
                    a.bYi().ipC.ciH();
                }
                a.bYi().ipD = 0;
                finish();
            } else if (dVar.customGroupType == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(this.ipr.groupId, 0L), dVar.groupName, dVar.nameShow, dVar.ipS, 0, dVar.hRw ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.followStatus);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
                a.bYi().d(dVar);
                a.bYi().ipD = 0;
                a.bYi().ipC.ciG();
                if (!a.bYi().ipC.ciI()) {
                    a.bYi().ipC.ciH();
                }
                finish();
            } else if (dVar.customGroupType == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(this.ipr.groupId, 0L), dVar.groupName, dVar.ipS, 0, 4)));
                a.bYi().d(dVar);
                a.bYi().ipD = 0;
                a.bYi().ipC.ciG();
                if (!a.bYi().ipC.ciI()) {
                    a.bYi().ipC.ciH();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                a.bYi().d(dVar);
                a.bYi().ipC.ciG();
                if (!a.bYi().ipC.ciI()) {
                    a.bYi().ipC.ciH();
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a.bYi().ipC.ciG();
            finish();
            return true;
        } else if (i == 82) {
            a.bYi().ipC.ciG();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public String bYh() {
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
