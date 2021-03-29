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
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.PvThread;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tieba.R;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreHttpResponseMessage;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreModel;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreSocketResponseMessage;
import com.baidu.tieba.screenlocknotify.view.ScreenLockHeaderView;
import d.b.b.e.p.j;
import d.b.b.e.p.l;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* loaded from: classes5.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    public static final String ACTIVITY_SCREEN_LOCK_ACTIVITY = "com.baidu.tieba.screenlocknotify.ScreenLockActivity";
    public static final String SYSTEM_HOME_KEY = "homekey";
    public static final String SYSTEM_REASON = "reason";
    public ScreenLockHeaderView headerView;
    public d.b.i0.t2.c mAdapter;
    public ImageView mClose;
    public ScreenLockLoadMoreModel mLoadMoreModel;
    public d.b.i0.t2.d showItem;
    public Window win;
    public Drawable background = null;
    public DynamicHeightListView mChatList = null;
    public int mListViewMaxHeight = 0;
    public TextView mFootView = null;
    public boolean mIsLoading = false;
    public BroadcastReceiver mHomeReceiver = new a();
    public View.OnClickListener sendClickListener = new d();
    public AdapterView.OnItemClickListener mOnItemClickListener = new f();
    public View.OnClickListener headerContentClickListener = new g();
    public d.b.b.c.g.a mLoadMoreListener = new h(CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420);

    /* loaded from: classes5.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                d.b.i0.t2.a.j().f61101d.d();
                ScreenLockActivity.this.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.i0.t2.d item;
            if (ScreenLockActivity.this.mAdapter.getCount() > 0 && (item = ScreenLockActivity.this.mAdapter.getItem(0)) != null) {
                TiebaStatic.log(new StatisticItem("c11704").param("msg_id", item.m / 100).param("task_id", item.s));
            }
            ScreenLockActivity.this.finish();
            d.b.i0.t2.a.j().f61101d.d();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements AbsListView.OnScrollListener {
        public c() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (ScreenLockActivity.this.mFootView == null || ScreenLockActivity.this.mFootView.getParent() == null) {
                return;
            }
            if (ScreenLockActivity.this.mChatList.getHeight() != ScreenLockActivity.this.mListViewMaxHeight) {
                ScreenLockActivity.this.mFootView.setText(ScreenLockActivity.this.getResources().getString(R.string.click_load_more));
                ScreenLockActivity.this.mFootView.setEnabled(true);
            } else if (i + i2 == i3) {
                if (ScreenLockActivity.this.mFootView.isEnabled()) {
                    ScreenLockActivity.this.mFootView.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
                    ScreenLockActivity.this.mFootView.setEnabled(false);
                }
                ScreenLockActivity.this.loadMoreData();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.i0.t2.d data;
            if (ScreenLockActivity.this.headerView == null || StringUtils.isNull(ScreenLockActivity.this.headerView.getInputMsg()) || (data = ScreenLockActivity.this.headerView.getData()) == null) {
                return;
            }
            if (data.f61125h == 4) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("msg_id", data.m / 100).param("task_id", data.s).param("service_id", data.t).param(AdExtParam.KEY_SHOUBAI_CUID, TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, data.q).param("app_version", TbConfig.getVersion()).param("obj_source", 2).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1));
            }
            int i = data.f61125h;
            if (i == 1) {
                MessageUtils.createGroupChatMessage(1, ScreenLockActivity.this.headerView.getInputMsg(), d.b.b.e.m.b.f(data.j, 0L));
                d.b.h0.s.d.b.g0().s(data.j);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.j, 1)));
            } else if (i == 2) {
                MessageUtils.createPersonalChatMessage(1, ScreenLockActivity.this.headerView.getInputMsg(), d.b.b.e.m.b.f(data.j, 0L), data.f61119b, data.f61120c, data.k);
                d.b.h0.s.d.b.g0().s(data.j);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.j, 2)));
                MessageUtils.sendHasReadMessage(data.j, 2);
            }
            new PvThread("lockscreen_reply", true).start();
            d.b.i0.t2.a.j().f61101d.d();
            ScreenLockActivity.this.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ScreenLockActivity.this.mFootView.setText(ScreenLockActivity.this.getResources().getString(R.string.loading));
            ScreenLockActivity.this.mFootView.setEnabled(false);
            ScreenLockActivity.this.loadMoreData();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements AdapterView.OnItemClickListener {
        public f() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScreenLockActivity screenLockActivity = ScreenLockActivity.this;
            screenLockActivity.showItem = screenLockActivity.mAdapter.getItem(i);
            ScreenLockActivity screenLockActivity2 = ScreenLockActivity.this;
            screenLockActivity2.gotoTalkablePage(screenLockActivity2.showItem);
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenLockActivity.this.headerView != null) {
                ScreenLockActivity screenLockActivity = ScreenLockActivity.this;
                screenLockActivity.showItem = screenLockActivity.headerView.getData();
                ScreenLockActivity screenLockActivity2 = ScreenLockActivity.this;
                screenLockActivity2.gotoTalkablePage(screenLockActivity2.showItem);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends d.b.b.c.g.a {
        public h(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage responsedMessage) {
            d.b.i0.t2.e.a data;
            ScreenLockActivity.this.mIsLoading = false;
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage;
            if (z || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                if (responsedMessage.getError() != 0) {
                    ScreenLockActivity.this.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? ScreenLockActivity.this.getResources().getString(R.string.screen_notify_load_error) : responsedMessage.getErrorString());
                    if (ScreenLockActivity.this.mFootView != null) {
                        ScreenLockActivity.this.mFootView.setText(ScreenLockActivity.this.getResources().getString(R.string.data_load_error));
                        ScreenLockActivity.this.mFootView.setEnabled(true);
                        return;
                    }
                    return;
                }
                if (z) {
                    data = ((ScreenLockLoadMoreHttpResponseMessage) responsedMessage).getData();
                } else {
                    data = responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage ? ((ScreenLockLoadMoreSocketResponseMessage) responsedMessage).getData() : null;
                }
                if (data == null) {
                    return;
                }
                ArrayList<d.b.i0.t2.d> a2 = data.a();
                d.b.i0.t2.c cVar = ScreenLockActivity.this.mAdapter;
                if (cVar != null) {
                    cVar.a(a2);
                }
                if (data.b()) {
                    return;
                }
                ScreenLockActivity.this.mAdapter.f(false);
                if (ScreenLockActivity.this.mFootView != null) {
                    ScreenLockActivity screenLockActivity = ScreenLockActivity.this;
                    screenLockActivity.mChatList.removeFooterView(screenLockActivity.mFootView);
                    ScreenLockActivity.this.mFootView = null;
                }
            }
        }
    }

    private void initFooterView() {
        TextView textView = new TextView(getActivity());
        this.mFootView = textView;
        textView.setGravity(17);
        this.mFootView.setText(R.string.click_load_more);
        this.mFootView.setHeight((int) getResources().getDimension(R.dimen.ds80));
        this.mFootView.setBackgroundResource(R.drawable.screen_notify_item_background);
        this.mFootView.setTextColor(getResources().getColorStateList(R.color.screen_notify_load_more_text_color));
        this.mFootView.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        this.mFootView.setOnClickListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadMoreData() {
        d.b.i0.t2.d item;
        if (this.mIsLoading) {
            return;
        }
        this.mIsLoading = true;
        this.mLoadMoreModel.s();
        d.b.i0.t2.c cVar = this.mAdapter;
        if (cVar == null || cVar.getCount() <= 0 || (item = this.mAdapter.getItem(0)) == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c11738").param("msg_id", item.m / 100).param("task_id", item.s));
    }

    private void updateItemDatas(List<d.b.i0.t2.d> list) {
        d.b.i0.t2.c cVar;
        if (list == null || list.size() <= 0 || (cVar = this.mAdapter) == null) {
            return;
        }
        cVar.a(list);
        if (this.mAdapter.e() && this.mFootView == null) {
            initFooterView();
            this.mChatList.addFooterView(this.mFootView);
        }
    }

    private void updateListViewHeader(d.b.i0.t2.d dVar) {
        if (this.headerView == null) {
            ScreenLockHeaderView screenLockHeaderView = new ScreenLockHeaderView(getActivity());
            this.headerView = screenLockHeaderView;
            screenLockHeaderView.setUIClickListener(this.sendClickListener, this.headerContentClickListener);
            this.headerView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.mChatList.addHeaderView(this.headerView);
        }
        this.headerView.d(dVar);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    public String getTopActivityName() {
        ActivityManager.RunningTaskInfo runningTaskInfo;
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) TbadkApplication.getInst().getSystemService("activity")).getRunningTasks(5);
        if (runningTasks == null || runningTasks.size() <= 0 || (runningTaskInfo = runningTasks.get(0)) == null) {
            return null;
        }
        return runningTaskInfo.topActivity.getClassName();
    }

    public void gotoTalkablePage(d.b.i0.t2.d dVar) {
        if (dVar == null) {
            return;
        }
        int i = dVar.f61125h;
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("msg_id", dVar.m / 100).param("task_id", dVar.s).param("service_id", dVar.t).param(AdExtParam.KEY_SHOUBAI_CUID, TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, dVar.q).param("app_version", TbConfig.getVersion()).param("obj_source", (i == 1 || i == 2) ? 3 : i != 4 ? i != 5 ? 0 : 1 : 2).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1));
        if (!j.z()) {
            showToast(getResources().getString(R.string.neterror));
        } else if (!TextUtils.isEmpty(dVar.q)) {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{dVar.q + "&" + TbWebViewActivityConfig.INTENT_KEY_IS_FROM_PUSH_NOTIFY + "=true"});
            TiebaStatic.log(new StatisticItem("c10316").param("obj_type", dVar.r).param("obj_locate", 2));
            d.b.i0.t2.a.j().h(dVar);
            finish();
        } else {
            int i2 = dVar.f61125h;
            if (i2 == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), d.b.b.e.m.b.f(dVar.j, 0L), dVar.f61118a, 0L, "from_lock")));
                d.b.i0.t2.a.j().h(dVar);
                d.b.i0.t2.a.j().f61101d.d();
                if (!d.b.i0.t2.a.j().f61101d.b()) {
                    d.b.i0.t2.a.j().f61101d.e();
                }
                d.b.i0.t2.a.j().f61102e = 0;
                finish();
            } else if (i2 == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), d.b.b.e.m.b.f(this.showItem.j, 0L), dVar.f61118a, dVar.f61120c, dVar.k, 0, dVar.o ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.p);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
                d.b.i0.t2.a.j().h(dVar);
                d.b.i0.t2.a.j().f61102e = 0;
                d.b.i0.t2.a.j().f61101d.d();
                if (!d.b.i0.t2.a.j().f61101d.b()) {
                    d.b.i0.t2.a.j().f61101d.e();
                }
                finish();
            } else if (i2 == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), d.b.b.e.m.b.f(this.showItem.j, 0L), dVar.f61118a, dVar.k, 0, 4)));
                d.b.i0.t2.a.j().h(dVar);
                d.b.i0.t2.a.j().f61102e = 0;
                d.b.i0.t2.a.j().f61101d.d();
                if (!d.b.i0.t2.a.j().f61101d.b()) {
                    d.b.i0.t2.a.j().f61101d.e();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                d.b.i0.t2.a.j().h(dVar);
                d.b.i0.t2.a.j().f61101d.d();
                if (!d.b.i0.t2.a.j().f61101d.b()) {
                    d.b.i0.t2.a.j().f61101d.e();
                }
                finish();
            }
        }
    }

    public void initUI() {
        ImageView imageView = (ImageView) findViewById(R.id.head_close);
        this.mClose = imageView;
        imageView.setOnClickListener(new b());
        this.mChatList = (DynamicHeightListView) findViewById(R.id.screenlock_chat_list_content);
        d.b.i0.t2.c cVar = new d.b.i0.t2.c(getPageContext().getPageActivity());
        this.mAdapter = cVar;
        this.mChatList.setAdapter((ListAdapter) cVar);
        this.mChatList.setOnItemClickListener(this.mOnItemClickListener);
        registerReceiver(this.mHomeReceiver, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        d.b.i0.t2.a.j().f61104g = false;
        this.mChatList.setMaxHeight(this.mListViewMaxHeight);
        this.mChatList.setTranscriptMode(0);
        this.mChatList.setOnScrollListener(new c());
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        Window window = getWindow();
        this.win = window;
        window.addFlags(524288);
        this.win.addFlags(2097152);
        getWindow().getDecorView().setDrawingCacheEnabled(false);
        setContentView(R.layout.activity_screen_lock);
        addGlobalLayoutListener();
        adjustResizeForSoftInput(R.color.transparent, true);
        if (l.z()) {
            Drawable a2 = d.b.i0.o3.b.a();
            this.background = a2;
            if (a2 != null) {
                this.win.setBackgroundDrawable(a2);
            }
        }
        this.mListViewMaxHeight = l.g(getPageContext().getPageActivity(), R.dimen.ds935) - l.g(getPageContext().getPageActivity(), R.dimen.ds80);
        this.mLoadMoreModel = new ScreenLockLoadMoreModel(this);
        registerListener(this.mLoadMoreListener);
        initUI();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.mHomeReceiver);
        d.b.i0.t2.a.j().s();
        d.b.i0.t2.a.j().f61103f = 0;
        this.background = null;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            d.b.i0.t2.a.j().f61101d.d();
            finish();
            return true;
        } else if (i == 82) {
            d.b.i0.t2.a.j().f61101d.d();
            finish();
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        d.b.i0.t2.a.j().f61103f = 0;
        d.b.i0.t2.a.j().f61102e = 0;
        if (this.headerView != null) {
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.headerView.getEditText());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        d.b.i0.t2.a.j().f61103f = 1;
        d.b.i0.t2.a.j().f61102e = 0;
        List<d.b.i0.t2.d> m = d.b.i0.t2.a.j().m();
        d.b.i0.t2.d l = d.b.i0.t2.a.j().l();
        d.b.i0.t2.a.j().s();
        if ((m == null || m.isEmpty()) && l == null && this.mAdapter.getCount() == 0 && this.mChatList.getHeaderViewsCount() == 0) {
            d.b.i0.t2.a.j().f61101d.d();
            finish();
            return;
        }
        updateItemDatas(m);
        if (l != null) {
            updateListViewHeader(l);
        }
        ScreenLockHeaderView screenLockHeaderView = this.headerView;
        if (screenLockHeaderView != null) {
            screenLockHeaderView.c(this.mAdapter.getCount() == 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (ACTIVITY_SCREEN_LOCK_ACTIVITY.equalsIgnoreCase(getTopActivityName())) {
            return;
        }
        finish();
    }

    public String refreshLastTime(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
    }

    public String refreshUnreadCount(int i) {
        if (i < 100) {
            return "" + i;
        }
        return "99+";
    }
}
