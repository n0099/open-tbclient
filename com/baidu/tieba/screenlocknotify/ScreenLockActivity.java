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
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.j;
import b.a.e.f.p.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tieba.R;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreHttpResponseMessage;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreModel;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreSocketResponseMessage;
import com.baidu.tieba.screenlocknotify.view.ScreenLockHeaderView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* loaded from: classes9.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTIVITY_SCREEN_LOCK_ACTIVITY = "com.baidu.tieba.screenlocknotify.ScreenLockActivity";
    public static final String SYSTEM_HOME_KEY = "homekey";
    public static final String SYSTEM_REASON = "reason";
    public transient /* synthetic */ FieldHolder $fh;
    public Drawable background;
    public View.OnClickListener headerContentClickListener;
    public ScreenLockHeaderView headerView;
    public b.a.r0.c3.c mAdapter;
    public DynamicHeightListView mChatList;
    public ImageView mClose;
    public TextView mFootView;
    public BroadcastReceiver mHomeReceiver;
    public boolean mIsLoading;
    public int mListViewMaxHeight;
    public b.a.e.c.g.a mLoadMoreListener;
    public ScreenLockLoadMoreModel mLoadMoreModel;
    public AdapterView.OnItemClickListener mOnItemClickListener;
    public View.OnClickListener sendClickListener;
    public b.a.r0.c3.d showItem;
    public Window win;

    /* loaded from: classes9.dex */
    public class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScreenLockActivity this$0;

        public a(ScreenLockActivity screenLockActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {screenLockActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = screenLockActivity;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals("homekey")) {
                b.a.r0.c3.a.j().f16622d.d();
                this.this$0.finish();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ScreenLockActivity f54659e;

        public b(ScreenLockActivity screenLockActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {screenLockActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54659e = screenLockActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.a.r0.c3.d item;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f54659e.mAdapter.getCount() > 0 && (item = this.f54659e.mAdapter.getItem(0)) != null) {
                    TiebaStatic.log(new StatisticItem("c11704").param("msg_id", item.m / 100).param("task_id", item.s));
                }
                this.f54659e.finish();
                b.a.r0.c3.a.j().f16622d.d();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ScreenLockActivity f54660e;

        public c(ScreenLockActivity screenLockActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {screenLockActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54660e = screenLockActivity;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) || this.f54660e.mFootView == null || this.f54660e.mFootView.getParent() == null) {
                return;
            }
            if (this.f54660e.mChatList.getHeight() != this.f54660e.mListViewMaxHeight) {
                this.f54660e.mFootView.setText(this.f54660e.getResources().getString(R.string.click_load_more));
                this.f54660e.mFootView.setEnabled(true);
            } else if (i2 + i3 == i4) {
                if (this.f54660e.mFootView.isEnabled()) {
                    this.f54660e.mFootView.setText(this.f54660e.getResources().getString(R.string.loading));
                    this.f54660e.mFootView.setEnabled(false);
                }
                this.f54660e.loadMoreData();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ScreenLockActivity f54661e;

        public d(ScreenLockActivity screenLockActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {screenLockActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54661e = screenLockActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.a.r0.c3.d data;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f54661e.headerView == null || StringUtils.isNull(this.f54661e.headerView.getInputMsg()) || (data = this.f54661e.headerView.getData()) == null) {
                return;
            }
            if (data.f16647h == 4) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("msg_id", data.m / 100).param("task_id", data.s).param("service_id", data.t).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, data.q).param("app_version", TbConfig.getVersion()).param("obj_source", 2).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1));
            }
            int i2 = data.f16647h;
            if (i2 == 1) {
                MessageUtils.createGroupChatMessage(1, this.f54661e.headerView.getInputMsg(), b.a.e.f.m.b.g(data.j, 0L));
                b.a.q0.t.d.b.g0().s(data.j);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.j, 1)));
            } else if (i2 == 2) {
                MessageUtils.createPersonalChatMessage(1, this.f54661e.headerView.getInputMsg(), b.a.e.f.m.b.g(data.j, 0L), data.f16641b, data.f16642c, data.k);
                b.a.q0.t.d.b.g0().s(data.j);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.j, 2)));
                MessageUtils.sendHasReadMessage(data.j, 2);
            }
            new PvThread("lockscreen_reply", true).start();
            b.a.r0.c3.a.j().f16622d.d();
            this.f54661e.finish();
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ScreenLockActivity f54662e;

        public e(ScreenLockActivity screenLockActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {screenLockActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54662e = screenLockActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f54662e.mFootView.setText(this.f54662e.getResources().getString(R.string.loading));
                this.f54662e.mFootView.setEnabled(false);
                this.f54662e.loadMoreData();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ScreenLockActivity f54663e;

        public f(ScreenLockActivity screenLockActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {screenLockActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54663e = screenLockActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                ScreenLockActivity screenLockActivity = this.f54663e;
                screenLockActivity.showItem = screenLockActivity.mAdapter.getItem(i2);
                ScreenLockActivity screenLockActivity2 = this.f54663e;
                screenLockActivity2.gotoTalkablePage(screenLockActivity2.showItem);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ScreenLockActivity f54664e;

        public g(ScreenLockActivity screenLockActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {screenLockActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54664e = screenLockActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f54664e.headerView == null) {
                return;
            }
            ScreenLockActivity screenLockActivity = this.f54664e;
            screenLockActivity.showItem = screenLockActivity.headerView.getData();
            ScreenLockActivity screenLockActivity2 = this.f54664e;
            screenLockActivity2.gotoTalkablePage(screenLockActivity2.showItem);
        }
    }

    /* loaded from: classes9.dex */
    public class h extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScreenLockActivity f54665a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(ScreenLockActivity screenLockActivity, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {screenLockActivity, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54665a = screenLockActivity;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage responsedMessage) {
            b.a.r0.c3.e.a data;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f54665a.mIsLoading = false;
                if (responsedMessage == null) {
                    return;
                }
                boolean z = responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage;
                if (z || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        this.f54665a.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? this.f54665a.getResources().getString(R.string.screen_notify_load_error) : responsedMessage.getErrorString());
                        if (this.f54665a.mFootView != null) {
                            this.f54665a.mFootView.setText(this.f54665a.getResources().getString(R.string.data_load_error));
                            this.f54665a.mFootView.setEnabled(true);
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
                    ArrayList<b.a.r0.c3.d> a2 = data.a();
                    b.a.r0.c3.c cVar = this.f54665a.mAdapter;
                    if (cVar != null) {
                        cVar.a(a2);
                    }
                    if (data.b()) {
                        return;
                    }
                    this.f54665a.mAdapter.f(false);
                    if (this.f54665a.mFootView != null) {
                        ScreenLockActivity screenLockActivity = this.f54665a;
                        screenLockActivity.mChatList.removeFooterView(screenLockActivity.mFootView);
                        this.f54665a.mFootView = null;
                    }
                }
            }
        }
    }

    public ScreenLockActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.background = null;
        this.mChatList = null;
        this.mListViewMaxHeight = 0;
        this.mFootView = null;
        this.mIsLoading = false;
        this.mHomeReceiver = new a(this);
        this.sendClickListener = new d(this);
        this.mOnItemClickListener = new f(this);
        this.headerContentClickListener = new g(this);
        this.mLoadMoreListener = new h(this, CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420);
    }

    private void initFooterView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            TextView textView = new TextView(getActivity());
            this.mFootView = textView;
            textView.setGravity(17);
            this.mFootView.setText(R.string.click_load_more);
            this.mFootView.setHeight((int) getResources().getDimension(R.dimen.ds80));
            this.mFootView.setBackgroundResource(R.drawable.screen_notify_item_background);
            this.mFootView.setTextColor(getResources().getColorStateList(R.color.screen_notify_load_more_text_color));
            this.mFootView.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
            this.mFootView.setOnClickListener(new e(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadMoreData() {
        b.a.r0.c3.d item;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || this.mIsLoading) {
            return;
        }
        this.mIsLoading = true;
        this.mLoadMoreModel.w();
        b.a.r0.c3.c cVar = this.mAdapter;
        if (cVar == null || cVar.getCount() <= 0 || (item = this.mAdapter.getItem(0)) == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c11738").param("msg_id", item.m / 100).param("task_id", item.s));
    }

    private void updateItemDatas(List<b.a.r0.c3.d> list) {
        b.a.r0.c3.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, this, list) == null) || list == null || list.size() <= 0 || (cVar = this.mAdapter) == null) {
            return;
        }
        cVar.a(list);
        if (this.mAdapter.e() && this.mFootView == null) {
            initFooterView();
            this.mChatList.addFooterView(this.mFootView);
        }
    }

    private void updateListViewHeader(b.a.r0.c3.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, dVar) == null) {
            if (this.headerView == null) {
                ScreenLockHeaderView screenLockHeaderView = new ScreenLockHeaderView(getActivity());
                this.headerView = screenLockHeaderView;
                screenLockHeaderView.setUIClickListener(this.sendClickListener, this.headerContentClickListener);
                this.headerView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                this.mChatList.addHeaderView(this.headerView);
            }
            this.headerView.updateUI(dVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    public String getTopActivityName() {
        InterceptResult invokeV;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) TbadkApplication.getInst().getSystemService("activity")).getRunningTasks(5);
            if (runningTasks == null || runningTasks.size() <= 0 || (runningTaskInfo = runningTasks.get(0)) == null) {
                return null;
            }
            return runningTaskInfo.topActivity.getClassName();
        }
        return (String) invokeV.objValue;
    }

    public void gotoTalkablePage(b.a.r0.c3.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) || dVar == null) {
            return;
        }
        int i2 = dVar.f16647h;
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("msg_id", dVar.m / 100).param("task_id", dVar.s).param("service_id", dVar.t).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, dVar.q).param("app_version", TbConfig.getVersion()).param("obj_source", (i2 == 1 || i2 == 2) ? 3 : i2 != 4 ? i2 != 5 ? 0 : 1 : 2).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1));
        if (!j.z()) {
            showToast(getResources().getString(R.string.neterror));
        } else if (!TextUtils.isEmpty(dVar.q)) {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{dVar.q + "&" + TbWebViewActivityConfig.INTENT_KEY_IS_FROM_PUSH_NOTIFY + "=true"});
            TiebaStatic.log(new StatisticItem("c10316").param("obj_type", dVar.r).param("obj_locate", 2));
            b.a.r0.c3.a.j().h(dVar);
            finish();
        } else {
            int i3 = dVar.f16647h;
            if (i3 == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), b.a.e.f.m.b.g(dVar.j, 0L), dVar.f16640a, 0L, "from_lock")));
                b.a.r0.c3.a.j().h(dVar);
                b.a.r0.c3.a.j().f16622d.d();
                if (!b.a.r0.c3.a.j().f16622d.b()) {
                    b.a.r0.c3.a.j().f16622d.e();
                }
                b.a.r0.c3.a.j().f16623e = 0;
                finish();
            } else if (i3 == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), b.a.e.f.m.b.g(this.showItem.j, 0L), dVar.f16640a, dVar.f16642c, dVar.k, 0, dVar.o ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(dVar.p);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
                b.a.r0.c3.a.j().h(dVar);
                b.a.r0.c3.a.j().f16623e = 0;
                b.a.r0.c3.a.j().f16622d.d();
                if (!b.a.r0.c3.a.j().f16622d.b()) {
                    b.a.r0.c3.a.j().f16622d.e();
                }
                finish();
            } else if (i3 == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), b.a.e.f.m.b.g(this.showItem.j, 0L), dVar.f16640a, dVar.k, 0, 4)));
                b.a.r0.c3.a.j().h(dVar);
                b.a.r0.c3.a.j().f16623e = 0;
                b.a.r0.c3.a.j().f16622d.d();
                if (!b.a.r0.c3.a.j().f16622d.b()) {
                    b.a.r0.c3.a.j().f16622d.e();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                b.a.r0.c3.a.j().h(dVar);
                b.a.r0.c3.a.j().f16622d.d();
                if (!b.a.r0.c3.a.j().f16622d.b()) {
                    b.a.r0.c3.a.j().f16622d.e();
                }
                finish();
            }
        }
    }

    public void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ImageView imageView = (ImageView) findViewById(R.id.head_close);
            this.mClose = imageView;
            imageView.setOnClickListener(new b(this));
            this.mChatList = (DynamicHeightListView) findViewById(R.id.screenlock_chat_list_content);
            b.a.r0.c3.c cVar = new b.a.r0.c3.c(getPageContext().getPageActivity());
            this.mAdapter = cVar;
            this.mChatList.setAdapter((ListAdapter) cVar);
            this.mChatList.setOnItemClickListener(this.mOnItemClickListener);
            registerReceiver(this.mHomeReceiver, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
            b.a.r0.c3.a.j().f16625g = false;
            this.mChatList.setMaxHeight(this.mListViewMaxHeight);
            this.mChatList.setTranscriptMode(0);
            this.mChatList.setOnScrollListener(new c(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
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
            if (l.A()) {
                Drawable a2 = b.a.r0.y3.c.a();
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
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            unregisterReceiver(this.mHomeReceiver);
            b.a.r0.c3.a.j().s();
            b.a.r0.c3.a.j().f16624f = 0;
            this.background = null;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048583, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                b.a.r0.c3.a.j().f16622d.d();
                finish();
                return true;
            } else if (i2 == 82) {
                b.a.r0.c3.a.j().f16622d.d();
                finish();
                return true;
            } else {
                return super.onKeyDown(i2, keyEvent);
            }
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onPause();
            b.a.r0.c3.a.j().f16624f = 0;
            b.a.r0.c3.a.j().f16623e = 0;
            if (this.headerView != null) {
                HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.headerView.getEditText());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onResume();
            b.a.r0.c3.a.j().f16624f = 1;
            b.a.r0.c3.a.j().f16623e = 0;
            List<b.a.r0.c3.d> m = b.a.r0.c3.a.j().m();
            b.a.r0.c3.d l = b.a.r0.c3.a.j().l();
            b.a.r0.c3.a.j().s();
            if ((m == null || m.isEmpty()) && l == null && this.mAdapter.getCount() == 0 && this.mChatList.getHeaderViewsCount() == 0) {
                b.a.r0.c3.a.j().f16622d.d();
                finish();
                return;
            }
            updateItemDatas(m);
            if (l != null) {
                updateListViewHeader(l);
            }
            ScreenLockHeaderView screenLockHeaderView = this.headerView;
            if (screenLockHeaderView != null) {
                screenLockHeaderView.updateInputView(this.mAdapter.getCount() == 0);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onStop();
            if (ACTIVITY_SCREEN_LOCK_ACTIVITY.equalsIgnoreCase(getTopActivityName())) {
                return;
            }
            finish();
        }
    }

    public String refreshLastTime(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) ? new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j)) : (String) invokeJ.objValue;
    }

    public String refreshUnreadCount(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            if (i2 < 100) {
                return "" + i2;
            }
            return "99+";
        }
        return (String) invokeI.objValue;
    }
}
