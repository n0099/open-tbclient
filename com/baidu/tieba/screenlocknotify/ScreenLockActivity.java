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
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.PvThread;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.be5;
import com.baidu.tieba.hka;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreHttpResponseMessage;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreModel;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreSocketResponseMessage;
import com.baidu.tieba.screenlocknotify.view.ScreenLockHeaderView;
import com.baidu.tieba.v1a;
import com.baidu.tieba.x1a;
import com.baidu.tieba.y1a;
import com.baidu.tieba.z1a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class ScreenLockActivity extends BaseActivity<ScreenLockActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Window a;
    public ImageView b;
    public Drawable c;
    public DynamicHeightListView d;
    public x1a e;
    public y1a f;
    public int g;
    public TextView h;
    public ScreenLockLoadMoreModel i;
    public boolean j;
    public ScreenLockHeaderView k;
    public BroadcastReceiver l;
    public View.OnClickListener m;
    public AdapterView.OnItemClickListener n;
    public View.OnClickListener o;
    public NetMessageListener p;

    /* loaded from: classes7.dex */
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
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals(PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_HOME_KEY)) {
                v1a.j().d.d();
                this.this$0.finish();
            }
        }
    }

    /* loaded from: classes7.dex */
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
            y1a item;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.e.getCount() > 0 && (item = this.a.e.getItem(0)) != null) {
                    TiebaStatic.log(new StatisticItem("c11704").param("msg_id", item.m / 100).param("task_id", item.s));
                }
                this.a.finish();
                v1a.j().d.d();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScreenLockActivity a;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) {
            }
        }

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
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) && this.a.h != null && this.a.h.getParent() != null) {
                if (this.a.d.getHeight() == this.a.g) {
                    if (i + i2 == i3) {
                        if (this.a.h.isEnabled()) {
                            this.a.h.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0be4));
                            this.a.h.setEnabled(false);
                        }
                        this.a.F1();
                        return;
                    }
                    return;
                }
                this.a.h.setText(this.a.getResources().getString(R.string.click_load_more));
                this.a.h.setEnabled(true);
            }
        }
    }

    /* loaded from: classes7.dex */
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
            y1a data;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.k == null || StringUtils.isNull(this.a.k.getInputMsg()) || (data = this.a.k.getData()) == null) {
                return;
            }
            if (data.h == 4) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("msg_id", data.m / 100).param("task_id", data.s).param("service_id", data.t).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, data.q).param("app_version", TbConfig.getVersion()).param("obj_source", 2).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1));
            }
            if (data.h == 2) {
                MessageUtils.createPersonalChatMessage(1, this.a.k.getInputMsg(), JavaTypesHelper.toLong(data.j, 0L), data.b, data.c, data.k);
                be5.p0().r(data.j);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.j, 2)));
                MessageUtils.sendHasReadMessage(data.j, 2);
            }
            if (PermissionUtil.isAgreePrivacyPolicy()) {
                new PvThread("lockscreen_reply", true).start();
            }
            v1a.j().d.d();
            this.a.finish();
        }
    }

    /* loaded from: classes7.dex */
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
                this.a.h.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0be4));
                this.a.h.setEnabled(false);
                this.a.F1();
            }
        }
    }

    /* loaded from: classes7.dex */
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
                screenLockActivity.f = screenLockActivity.e.getItem(i);
                ScreenLockActivity screenLockActivity2 = this.a;
                screenLockActivity2.B1(screenLockActivity2.f);
            }
        }
    }

    /* loaded from: classes7.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.k != null) {
                ScreenLockActivity screenLockActivity = this.a;
                screenLockActivity.f = screenLockActivity.k.getData();
                ScreenLockActivity screenLockActivity2 = this.a;
                screenLockActivity2.B1(screenLockActivity2.f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends NetMessageListener {
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

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage responsedMessage) {
            z1a z1aVar;
            String errorString;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) {
                return;
            }
            this.a.j = false;
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage;
            if (!z && !(responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                return;
            }
            if (responsedMessage.getError() != 0) {
                ScreenLockActivity screenLockActivity = this.a;
                if (TextUtils.isEmpty(responsedMessage.getErrorString())) {
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f12e8);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                screenLockActivity.showToast(errorString);
                if (this.a.h != null) {
                    this.a.h.setText(this.a.getResources().getString(R.string.data_load_error));
                    this.a.h.setEnabled(true);
                    return;
                }
                return;
            }
            if (z) {
                z1aVar = ((ScreenLockLoadMoreHttpResponseMessage) responsedMessage).getData();
            } else if (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage) {
                z1aVar = ((ScreenLockLoadMoreSocketResponseMessage) responsedMessage).getData();
            } else {
                z1aVar = null;
            }
            if (z1aVar == null) {
                return;
            }
            ArrayList<y1a> a = z1aVar.a();
            x1a x1aVar = this.a.e;
            if (x1aVar != null) {
                x1aVar.a(a);
            }
            if (!z1aVar.b()) {
                this.a.e.f(false);
                if (this.a.h != null) {
                    ScreenLockActivity screenLockActivity2 = this.a;
                    screenLockActivity2.d.removeFooterView(screenLockActivity2.h);
                    this.a.h = null;
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
        this.c = null;
        this.d = null;
        this.g = 0;
        this.h = null;
        this.j = false;
        this.l = new a(this);
        this.m = new d(this);
        this.n = new f(this);
        this.o = new g(this);
        this.p = new h(this, CmdConfigHttp.CMD_SCREEN_LOCK_MESSAGE_MORE, 309420);
    }

    public final void F1() {
        y1a item;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.j) {
            return;
        }
        this.j = true;
        this.i.N();
        x1a x1aVar = this.e;
        if (x1aVar != null && x1aVar.getCount() > 0 && (item = this.e.getItem(0)) != null) {
            TiebaStatic.log(new StatisticItem("c11738").param("msg_id", item.m / 100).param("task_id", item.s));
        }
    }

    public String A1() {
        InterceptResult invokeV;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) TbadkApplication.getInst().getSystemService("activity")).getRunningTasks(5);
            if (runningTasks == null || runningTasks.size() <= 0 || (runningTaskInfo = runningTasks.get(0)) == null) {
                return null;
            }
            return runningTaskInfo.topActivity.getClassName();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onPause();
            v1a.j().f = 0;
            v1a.j().e = 0;
            if (this.k != null) {
                HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.k.getEditText());
            }
        }
    }

    public void B1(y1a y1aVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y1aVar) != null) || y1aVar == null) {
            return;
        }
        int i2 = y1aVar.h;
        if (i2 != 2) {
            if (i2 != 4) {
                if (i2 != 5) {
                    i = 0;
                } else {
                    i = 1;
                }
            } else {
                i = 2;
            }
        } else {
            i = 3;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.PUSH_CCLICK).param("msg_id", y1aVar.m / 100).param("task_id", y1aVar.s).param("service_id", y1aVar.t).param("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2()).param(TiebaStatic.Params.OBJ_TO, y1aVar.q).param("app_version", TbConfig.getVersion()).param("obj_source", i).param("hdid", TbadkCoreApplication.getInst().getHdid()).param("obj_id", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_ISHOST, 1));
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            showToast(getResources().getString(R.string.obfuscated_res_0x7f0f0e21));
        } else if (!TextUtils.isEmpty(y1aVar.q)) {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{y1aVar.q + "&is_from_push=true"});
            TiebaStatic.log(new StatisticItem("c10316").param("obj_type", y1aVar.r).param("obj_locate", 2));
            v1a.j().h(y1aVar);
            finish();
        } else {
            int i3 = y1aVar.h;
            if (i3 == 2) {
                PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(getPageContext().getPageActivity(), JavaTypesHelper.toLong(this.f.j, 0L), y1aVar.a, y1aVar.c, y1aVar.k, 0, y1aVar.o ? 1 : 0);
                personalChatActivityConfig.setFollowStatus(y1aVar.p);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
                v1a.j().h(y1aVar);
                v1a.j().e = 0;
                v1a.j().d.d();
                if (!v1a.j().d.b()) {
                    v1a.j().d.e();
                }
                finish();
            } else if (i3 == 4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(getPageContext().getPageActivity(), JavaTypesHelper.toLong(this.f.j, 0L), y1aVar.a, y1aVar.k, 0, 4)));
                v1a.j().h(y1aVar);
                v1a.j().e = 0;
                v1a.j().d.d();
                if (!v1a.j().d.b()) {
                    v1a.j().d.e();
                }
                finish();
            } else {
                TiebaStatic.log("c11962");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(getPageContext().getContext(), -2)));
                v1a.j().h(y1aVar);
                v1a.j().d.d();
                if (!v1a.j().d.b()) {
                    v1a.j().d.e();
                }
                finish();
            }
        }
    }

    public final void D1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TextView textView = new TextView(getActivity());
            this.h = textView;
            textView.setGravity(17);
            this.h.setText(R.string.click_load_more);
            this.h.setHeight((int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070275));
            this.h.setBackgroundResource(R.drawable.obfuscated_res_0x7f081341);
            this.h.setTextColor(getResources().getColorStateList(R.color.obfuscated_res_0x7f060a88));
            this.h.setTextSize(0, getResources().getDimension(R.dimen.obfuscated_res_0x7f0702b7));
            this.h.setOnClickListener(new e(this));
        }
    }

    public void E1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f090eef);
            this.b = imageView;
            imageView.setOnClickListener(new b(this));
            this.d = (DynamicHeightListView) findViewById(R.id.obfuscated_res_0x7f0920c9);
            x1a x1aVar = new x1a(getPageContext().getPageActivity());
            this.e = x1aVar;
            this.d.setAdapter((ListAdapter) x1aVar);
            this.d.setOnItemClickListener(this.n);
            registerReceiver(this.l, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
            v1a.j().g = false;
            this.d.setMaxHeight(this.g);
            this.d.setTranscriptMode(0);
            this.d.setOnScrollListener(new c(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onResume();
            boolean z = true;
            v1a.j().f = 1;
            v1a.j().e = 0;
            List<y1a> m = v1a.j().m();
            y1a l = v1a.j().l();
            v1a.j().s();
            if ((m == null || m.isEmpty()) && l == null && this.e.getCount() == 0 && this.d.getHeaderViewsCount() == 0) {
                v1a.j().d.d();
                finish();
                return;
            }
            G1(m);
            if (l != null) {
                I1(l);
            }
            ScreenLockHeaderView screenLockHeaderView = this.k;
            if (screenLockHeaderView != null) {
                if (this.e.getCount() != 0) {
                    z = false;
                }
                screenLockHeaderView.c(z);
            }
        }
    }

    public final void G1(List<y1a> list) {
        x1a x1aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, list) == null) && list != null && list.size() > 0 && (x1aVar = this.e) != null) {
            x1aVar.a(list);
            if (this.e.e() && this.h == null) {
                D1();
                this.d.addFooterView(this.h);
            }
        }
    }

    public final void I1(y1a y1aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, y1aVar) == null) {
            if (this.k == null) {
                ScreenLockHeaderView screenLockHeaderView = new ScreenLockHeaderView(getActivity());
                this.k = screenLockHeaderView;
                screenLockHeaderView.setUIClickListener(this.m, this.o);
                this.k.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                this.d.addHeaderView(this.k);
            }
            this.k.d(y1aVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            unregisterReceiver(this.l);
            v1a.j().s();
            v1a.j().f = 0;
            this.c = null;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onStop();
            if (!"com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(A1())) {
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            setActivityBgTransparent();
            Window window = getWindow();
            this.a = window;
            window.addFlags(524288);
            this.a.addFlags(2097152);
            getWindow().getDecorView().setDrawingCacheEnabled(false);
            setContentView(R.layout.obfuscated_res_0x7f0d0051);
            addGlobalLayoutListener();
            adjustResizeForSoftInput(R.color.transparent, true);
            if (BdUtilHelper.isFlymeOsAbove35()) {
                Drawable a2 = hka.a();
                this.c = a2;
                if (a2 != null) {
                    this.a.setBackgroundDrawable(a2);
                }
            }
            this.g = BdUtilHelper.getDimens(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070425) - BdUtilHelper.getDimens(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070275);
            this.i = new ScreenLockLoadMoreModel(this);
            registerListener(this.p);
            E1();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048587, this, i, keyEvent)) == null) {
            if (i == 4) {
                v1a.j().d.d();
                finish();
                return true;
            } else if (i == 82) {
                v1a.j().d.d();
                finish();
                return true;
            } else {
                return super.onKeyDown(i, keyEvent);
            }
        }
        return invokeIL.booleanValue;
    }
}
