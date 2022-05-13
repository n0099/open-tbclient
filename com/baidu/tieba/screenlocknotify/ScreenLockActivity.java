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
import com.baidu.tbadk.core.util.PermissionUtil;
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
import com.repackage.er8;
import com.repackage.gc8;
import com.repackage.ic8;
import com.repackage.jc8;
import com.repackage.kc8;
import com.repackage.kg;
import com.repackage.ki;
import com.repackage.ky4;
import com.repackage.mi;
import com.repackage.wa;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* loaded from: classes3.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTIVITY_SCREEN_LOCK_ACTIVITY = "com.baidu.tieba.screenlocknotify.ScreenLockActivity";
    public static final String SYSTEM_HOME_KEY = "homekey";
    public static final String SYSTEM_REASON = "reason";
    public transient /* synthetic */ FieldHolder $fh;
    public Drawable background;
    public View.OnClickListener headerContentClickListener;
    public ScreenLockHeaderView headerView;
    public ic8 mAdapter;
    public DynamicHeightListView mChatList;
    public ImageView mClose;
    public TextView mFootView;
    public BroadcastReceiver mHomeReceiver;
    public boolean mIsLoading;
    public int mListViewMaxHeight;
    public wa mLoadMoreListener;
    public ScreenLockLoadMoreModel mLoadMoreModel;
    public AdapterView.OnItemClickListener mOnItemClickListener;
    public View.OnClickListener sendClickListener;
    public jc8 showItem;
    public Window win;

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                gc8.j().d.d();
                this.this$0.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScreenLockActivity a;

        public b(ScreenLockActivity screenLockActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {screenLockActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = screenLockActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            jc8 item;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.mAdapter.getCount() > 0 && (item = this.a.mAdapter.getItem(0)) != null) {
                    TiebaStatic.log(new StatisticItem("c11704").param("msg_id", item.m / 100).param("task_id", item.s));
                }
                this.a.finish();
                gc8.j().d.d();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScreenLockActivity a;

        public c(ScreenLockActivity screenLockActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {screenLockActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = screenLockActivity;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) || this.a.mFootView == null || this.a.mFootView.getParent() == null) {
                return;
            }
            if (this.a.mChatList.getHeight() != this.a.mListViewMaxHeight) {
                this.a.mFootView.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f03e4));
                this.a.mFootView.setEnabled(true);
            } else if (i + i2 == i3) {
                if (this.a.mFootView.isEnabled()) {
                    this.a.mFootView.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a34));
                    this.a.mFootView.setEnabled(false);
                }
                this.a.loadMoreData();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScreenLockActivity a;

        public d(ScreenLockActivity screenLockActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {screenLockActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = screenLockActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            jc8 data;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.headerView == null || StringUtils.isNull(this.a.headerView.getInputMsg()) || (data = this.a.headerView.getData()) == null) {
                return;
            }
            if (data.h == 4) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("msg_id", data.m / 100).param("task_id", data.s).param("service_id", data.t).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, data.q).param("app_version", TbConfig.getVersion()).param("obj_source", 2).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1));
            }
            int i = data.h;
            if (i == 1) {
                MessageUtils.createGroupChatMessage(1, this.a.headerView.getInputMsg(), kg.g(data.j, 0L));
                ky4.h0().s(data.j);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.j, 1)));
            } else if (i == 2) {
                MessageUtils.createPersonalChatMessage(1, this.a.headerView.getInputMsg(), kg.g(data.j, 0L), data.b, data.c, data.k);
                ky4.h0().s(data.j);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.j, 2)));
                MessageUtils.sendHasReadMessage(data.j, 2);
            }
            if (PermissionUtil.isAgreePrivacyPolicy()) {
                new PvThread("lockscreen_reply", true).start();
            }
            gc8.j().d.d();
            this.a.finish();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScreenLockActivity a;

        public e(ScreenLockActivity screenLockActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {screenLockActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = screenLockActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.mFootView.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a34));
                this.a.mFootView.setEnabled(false);
                this.a.loadMoreData();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScreenLockActivity a;

        public f(ScreenLockActivity screenLockActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {screenLockActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = screenLockActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                ScreenLockActivity screenLockActivity = this.a;
                screenLockActivity.showItem = screenLockActivity.mAdapter.getItem(i);
                ScreenLockActivity screenLockActivity2 = this.a;
                screenLockActivity2.gotoTalkablePage(screenLockActivity2.showItem);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScreenLockActivity a;

        public g(ScreenLockActivity screenLockActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {screenLockActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = screenLockActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.headerView == null) {
                return;
            }
            ScreenLockActivity screenLockActivity = this.a;
            screenLockActivity.showItem = screenLockActivity.headerView.getData();
            ScreenLockActivity screenLockActivity2 = this.a;
            screenLockActivity2.gotoTalkablePage(screenLockActivity2.showItem);
        }
    }

    /* loaded from: classes3.dex */
    public class h extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScreenLockActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(ScreenLockActivity screenLockActivity, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {screenLockActivity, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = screenLockActivity;
        }

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage responsedMessage) {
            kc8 data;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.mIsLoading = false;
                if (responsedMessage == null) {
                    return;
                }
                boolean z = responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage;
                if (z || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                    if (responsedMessage.getError() != 0) {
                        this.a.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1094) : responsedMessage.getErrorString());
                        if (this.a.mFootView != null) {
                            this.a.mFootView.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f047b));
                            this.a.mFootView.setEnabled(true);
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
                    ArrayList<jc8> a = data.a();
                    ic8 ic8Var = this.a.mAdapter;
                    if (ic8Var != null) {
                        ic8Var.a(a);
                    }
                    if (data.b()) {
                        return;
                    }
                    this.a.mAdapter.f(false);
                    if (this.a.mFootView != null) {
                        ScreenLockActivity screenLockActivity = this.a;
                        screenLockActivity.mChatList.removeFooterView(screenLockActivity.mFootView);
                        this.a.mFootView = null;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            this.mFootView.setText(R.string.obfuscated_res_0x7f0f03e4);
            this.mFootView.setHeight((int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070275));
            this.mFootView.setBackgroundResource(R.drawable.obfuscated_res_0x7f081091);
            this.mFootView.setTextColor(getResources().getColorStateList(R.color.obfuscated_res_0x7f060a14));
            this.mFootView.setTextSize(0, getResources().getDimension(R.dimen.obfuscated_res_0x7f0702b7));
            this.mFootView.setOnClickListener(new e(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadMoreData() {
        jc8 item;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || this.mIsLoading) {
            return;
        }
        this.mIsLoading = true;
        this.mLoadMoreModel.y();
        ic8 ic8Var = this.mAdapter;
        if (ic8Var == null || ic8Var.getCount() <= 0 || (item = this.mAdapter.getItem(0)) == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c11738").param("msg_id", item.m / 100).param("task_id", item.s));
    }

    private void updateItemDatas(List<jc8> list) {
        ic8 ic8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, this, list) == null) || list == null || list.size() <= 0 || (ic8Var = this.mAdapter) == null) {
            return;
        }
        ic8Var.a(list);
        if (this.mAdapter.e() && this.mFootView == null) {
            initFooterView();
            this.mChatList.addFooterView(this.mFootView);
        }
    }

    private void updateListViewHeader(jc8 jc8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, jc8Var) == null) {
            if (this.headerView == null) {
                ScreenLockHeaderView screenLockHeaderView = new ScreenLockHeaderView(getActivity());
                this.headerView = screenLockHeaderView;
                screenLockHeaderView.setUIClickListener(this.sendClickListener, this.headerContentClickListener);
                this.headerView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                this.mChatList.addHeaderView(this.headerView);
            }
            this.headerView.d(jc8Var);
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

    public void gotoTalkablePage(jc8 jc8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jc8Var) == null) || jc8Var == null) {
            return;
        }
        int i = jc8Var.h;
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("msg_id", jc8Var.m / 100).param("task_id", jc8Var.s).param("service_id", jc8Var.t).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, jc8Var.q).param("app_version", TbConfig.getVersion()).param("obj_source", (i == 1 || i == 2) ? 3 : i != 4 ? i != 5 ? 0 : 1 : 2).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1));
        if (!ki.z()) {
            showToast(getResources().getString(R.string.obfuscated_res_0x7f0f0c2d));
        } else if (!TextUtils.isEmpty(jc8Var.q)) {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{jc8Var.q + "&" + TbWebViewActivityConfig.INTENT_KEY_IS_FROM_PUSH_NOTIFY + "=true"});
            TiebaStatic.log(new StatisticItem("c10316").param("obj_type", jc8Var.r).param("obj_locate", 2));
            gc8.j().h(jc8Var);
            finish();
        } else {
            int i2 = jc8Var.h;
            if (i2 == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(getPageContext().getPageActivity(), kg.g(jc8Var.j, 0L), jc8Var.a, 0L, "from_lock")));
                gc8.j().h(jc8Var);
                gc8.j().d.d();
                if (!gc8.j().d.b()) {
                    gc8.j().d.e();
                }
                gc8.j().e = 0;
                finish();
            } else if (i2 == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), kg.g(this.showItem.j, 0L), jc8Var.a, jc8Var.c, jc8Var.k, 0, jc8Var.o ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(jc8Var.p);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
                gc8.j().h(jc8Var);
                gc8.j().e = 0;
                gc8.j().d.d();
                if (!gc8.j().d.b()) {
                    gc8.j().d.e();
                }
                finish();
            } else if (i2 == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), kg.g(this.showItem.j, 0L), jc8Var.a, jc8Var.k, 0, 4)));
                gc8.j().h(jc8Var);
                gc8.j().e = 0;
                gc8.j().d.d();
                if (!gc8.j().d.b()) {
                    gc8.j().d.e();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getPageContext().getContext(), 2)));
                gc8.j().h(jc8Var);
                gc8.j().d.d();
                if (!gc8.j().d.b()) {
                    gc8.j().d.e();
                }
                finish();
            }
        }
    }

    public void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f090d13);
            this.mClose = imageView;
            imageView.setOnClickListener(new b(this));
            this.mChatList = (DynamicHeightListView) findViewById(R.id.obfuscated_res_0x7f091c3f);
            ic8 ic8Var = new ic8(getPageContext().getPageActivity());
            this.mAdapter = ic8Var;
            this.mChatList.setAdapter((ListAdapter) ic8Var);
            this.mChatList.setOnItemClickListener(this.mOnItemClickListener);
            registerReceiver(this.mHomeReceiver, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
            gc8.j().g = false;
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
            setContentView(R.layout.obfuscated_res_0x7f0d0051);
            addGlobalLayoutListener();
            adjustResizeForSoftInput(R.color.transparent, true);
            if (mi.z()) {
                Drawable a2 = er8.a();
                this.background = a2;
                if (a2 != null) {
                    this.win.setBackgroundDrawable(a2);
                }
            }
            this.mListViewMaxHeight = mi.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07030e) - mi.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070275);
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
            gc8.j().s();
            gc8.j().f = 0;
            this.background = null;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048583, this, i, keyEvent)) == null) {
            if (i == 4) {
                gc8.j().d.d();
                finish();
                return true;
            } else if (i == 82) {
                gc8.j().d.d();
                finish();
                return true;
            } else {
                return super.onKeyDown(i, keyEvent);
            }
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onPause();
            gc8.j().f = 0;
            gc8.j().e = 0;
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
            gc8.j().f = 1;
            gc8.j().e = 0;
            List<jc8> m = gc8.j().m();
            jc8 l = gc8.j().l();
            gc8.j().s();
            if ((m == null || m.isEmpty()) && l == null && this.mAdapter.getCount() == 0 && this.mChatList.getHeaderViewsCount() == 0) {
                gc8.j().d.d();
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

    public String refreshUnreadCount(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            if (i < 100) {
                return "" + i;
            }
            return "99+";
        }
        return (String) invokeI.objValue;
    }
}
