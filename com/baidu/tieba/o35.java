package com.baidu.tieba;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.TooltipCompatHandler;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.tieba.service.SignAlertReceiver;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.auth.NTLMEngineImpl;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
/* loaded from: classes5.dex */
public class o35 implements k35 {
    public static /* synthetic */ Interceptable $ic;
    public static final long f;
    public transient /* synthetic */ FieldHolder $fh;
    public un5 a;
    public boolean b;
    public int c;
    public int d;
    public Runnable e;

    public static String s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i)) == null) ? i == 1 ? "forum_sign" : i == 4 ? "sign" : "default" : (String) invokeI.objValue;
    }

    public static int t(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i)) == null) {
            if (i == 1) {
                return 2;
            }
            return i == 4 ? 5 : 0;
        }
        return invokeI.intValue;
    }

    /* loaded from: classes5.dex */
    public class d implements kn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ TbPageContext b;
        public final /* synthetic */ o35 c;

        /* loaded from: classes5.dex */
        public class a implements View.OnTouchListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                    return true;
                }
                return invokeLL.booleanValue;
            }

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public b(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    if (this.a.c.a != null) {
                        this.a.c.a.A();
                        this.a.c.a.f();
                    }
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_OK_CLICK);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    boolean D = n35.d().D();
                    boolean areNotificationsEnabled = NotificationManagerCompat.from(this.a.b.getPageActivity()).areNotificationsEnabled();
                    if (!D) {
                        n35.d().X(true);
                    }
                    if (areNotificationsEnabled) {
                        m45.l(this.a.b.getPageActivity());
                    } else {
                        i45.e(this.a.b);
                    }
                    o35.u(this.a.a, true);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public c(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    if (this.a.c.a != null) {
                        this.a.c.a.f();
                    }
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_CLOSE_CLICK);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    o35.u(this.a.a, false);
                }
            }
        }

        public d(o35 o35Var, int i, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o35Var, Integer.valueOf(i), tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = o35Var;
            this.a = i;
            this.b = tbPageContext;
        }

        @Override // com.baidu.tieba.kn5
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f0912ae);
                View findViewById2 = view2.findViewById(R.id.obfuscated_res_0x7f0912a9);
                View findViewById3 = view2.findViewById(R.id.obfuscated_res_0x7f0912aa);
                SkinManager.setBackgroundResource(findViewById2, R.color.CAM_X0208);
                SkinManager.setBackgroundResource(findViewById3, R.drawable.sign_remind_pic);
                View findViewById4 = view2.findViewById(R.id.obfuscated_res_0x7f0912b8);
                TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092467);
                TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091f30);
                TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) view2.findViewById(R.id.obfuscated_res_0x7f091b69);
                TextView textView3 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b67);
                pw4.d((WheelView) view2.findViewById(R.id.obfuscated_res_0x7f090e2f)).f(R.color.CAM_X0208);
                pw4.d((WheelView) view2.findViewById(R.id.obfuscated_res_0x7f09156b)).f(R.color.CAM_X0208);
                SkinManager.setBackgroundColor(findViewById4, R.color.CAM_X0208);
                SkinManager.setBackgroundColor((LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f092238), R.color.CAM_X0306);
                pw4 d = pw4.d(textView);
                d.v(R.color.CAM_X0105);
                d.z(R.dimen.T_X05);
                d.A(R.string.F_X02);
                pw4 d2 = pw4.d(textView2);
                d2.v(R.color.CAM_X0108);
                d2.z(R.dimen.T_X07);
                d2.A(R.string.F_X01);
                pw4 d3 = pw4.d(textView3);
                d3.v(R.color.CAM_X0110);
                d3.A(R.string.F_X01);
                d3.z(R.dimen.T_X08);
                Map<String, String> f = m45.f(o35.s(this.a));
                textView.setText(f.get("view_params_key_title"));
                textView2.setText(f.get("view_params_key_desc"));
                if (tBSpecificationBtn != null) {
                    tBSpecificationBtn.setTextSize(R.dimen.T_X06);
                    tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fa4));
                    tBSpecificationBtn.setConfig(new nz4());
                }
                if (this.a == 3 && tBSpecificationBtn != null) {
                    tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0440));
                    textView3.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f7e));
                }
                a aVar = new a(this);
                findViewById.setOnTouchListener(aVar);
                findViewById4.setOnTouchListener(aVar);
                tBSpecificationBtn.setOnClickListener(new b(this));
                textView3.setOnClickListener(new c(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o35 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(o35 o35Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o35Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o35Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (httpResponsedMessage.isSuccess() && httpResponsedMessage.getError() == 0) {
                    this.a.c();
                    return;
                }
                TbadkSettings.getInst().saveBoolean("alert_sign_on", this.a.b);
                TbadkSettings.getInst().saveInt("alert_sign_hours", this.a.c);
                TbadkSettings.getInst().saveInt("alert_sign_mins", this.a.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o35 a;

        public b(o35 o35Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o35Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o35Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a.u();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements pn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ boolean b;

        public c(o35 o35Var, Activity activity, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o35Var, activity, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
            this.b = z;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
            if (r4.b == false) goto L10;
         */
        @Override // com.baidu.tieba.pn5
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(Date date, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, date, view2) == null) && date != null) {
                boolean z = true;
                if ("frs.FrsActivity".equals(this.a.getLocalClassName()) && py4.k().h("first_call_attention", true)) {
                    py4.k().u("first_call_attention", false);
                }
                z = false;
                if (z) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001223, date));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947981336, "Lcom/baidu/tieba/o35;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947981336, "Lcom/baidu/tieba/o35;");
                return;
            }
        }
        f = StringHelper.MS_TO_MIN * 1;
    }

    @Override // com.baidu.tieba.k35
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return TbadkSettings.getInst().loadBoolean("alert_sign_on", false);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.k35
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int loadInt = TbadkSettings.getInst().loadInt("alert_sign_mins", -1);
            if (loadInt == -1) {
                w();
                return TbadkSettings.getInst().loadInt("alert_sign_mins", 30);
            }
            return loadInt;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.k35
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int loadInt = TbadkSettings.getInst().loadInt("alert_sign_hours", -1);
            if (loadInt == -1) {
                w();
                return TbadkSettings.getInst().loadInt("alert_sign_hours", 12);
            }
            return loadInt;
        }
        return invokeV.intValue;
    }

    public final Intent p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Intent intent = new Intent(TbConfig.getBroadcastActionSignAlert());
            intent.setData(Uri.parse("tieba_sign://alert"));
            intent.setClass(TbadkCoreApplication.getInst(), SignAlertReceiver.class);
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    public o35() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = false;
        this.c = 12;
        this.d = 0;
        this.e = new b(this);
        a aVar = new a(this, CmdConfigHttp.CMD_UPDATE_SIGN_DATA);
        aVar.setPriority(-1);
        MessageManager.getInstance().registerListener(aVar);
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis() + f);
            TbadkSettings.getInst().saveInt("alert_sign_hours", calendar.get(11));
            TbadkSettings.getInst().saveInt("alert_sign_mins", calendar.get(12));
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_UPDATE_SIGN_DATA, TbConfig.SERVER_ADDRESS + TbConfig.UPDATE_SIGN_DATA);
            tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
            tbHttpMessageTask.setIsNeedTbs(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65547, null, i) == null) {
            TiebaStatic.log(new StatisticItem("c13674").param("obj_source", t(i)));
        }
    }

    public final int q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            return yi.g(TbadkCoreApplication.getInst(), i);
        }
        return invokeI.intValue;
    }

    public static void u(int i, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            int t = t(i);
            StatisticItem statisticItem = new StatisticItem("c13673");
            if (z) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            TiebaStatic.log(statisticItem.param("obj_type", i2).param("obj_source", t));
        }
    }

    @Override // com.baidu.tieba.k35
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            AlarmManager alarmManager = (AlarmManager) inst.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent p = p();
            if (a() && UbsABTestHelper.isUseLocalSignPush()) {
                Calendar calendar = Calendar.getInstance();
                int g = g();
                int i = calendar.get(11);
                int b2 = b();
                int i2 = calendar.get(12);
                calendar.set(11, g);
                calendar.set(12, b2);
                calendar.set(13, 0);
                calendar.set(14, 0);
                if (i >= g && (i != g || i2 >= b2)) {
                    calendar.set(6, calendar.get(6) + 1);
                }
                alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(inst, 0, p, 134217728));
                return;
            }
            PendingIntent broadcast = PendingIntent.getBroadcast(inst, 0, p, NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
            if (broadcast != null) {
                alarmManager.cancel(broadcast);
            }
        }
    }

    @Override // com.baidu.tieba.k35
    public Dialog d(int i, TbPageContext tbPageContext, pn5 pn5Var, boolean z) {
        InterceptResult invokeCommon;
        Activity pageActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), tbPageContext, pn5Var, Boolean.valueOf(z)})) == null) {
            if (tbPageContext == null || (pageActivity = tbPageContext.getPageActivity()) == null || !ch.e(pageActivity)) {
                return null;
            }
            Calendar calendar = Calendar.getInstance();
            int j = n35.d().j();
            int k = n35.d().k();
            if (j > 0 && k > 0) {
                calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), j, k);
            } else {
                calendar.setTimeInMillis(System.currentTimeMillis() + f);
            }
            in5 in5Var = new in5(pageActivity, pn5Var);
            in5Var.g(calendar);
            in5Var.k(R.layout.obfuscated_res_0x7f0d0235, new d(this, i, tbPageContext));
            in5Var.f(18);
            in5Var.p(new boolean[]{false, false, false, true, true, false});
            in5Var.j("年", "月", "日", "", "", "秒");
            in5Var.l(2.0f);
            in5Var.o(0, 0, 0, 0, 0, 0);
            in5Var.b(false);
            in5Var.i(SkinManager.getColor(R.color.CAM_X0204));
            in5Var.m(SkinManager.getColor(R.color.CAM_X0105));
            in5Var.n(SkinManager.getColor(R.color.CAM_X0109));
            in5Var.d(SkinManager.getColor(R.color.black_alpha30));
            in5Var.e(SkinManager.getColor(R.color.CAM_X0211));
            un5 a2 = in5Var.a();
            this.a = a2;
            if (z) {
                ah.a().postDelayed(this.e, TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
            } else {
                a2.u();
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            v(i);
            return this.a.j();
        }
        return (Dialog) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.k35
    public NavigationBarCoverTip e(Activity activity, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, activity, viewGroup)) == null) {
            if (activity != null && viewGroup != null) {
                View findViewById = viewGroup.findViewById(R.id.obfuscated_res_0x7f091666);
                if (findViewById != null) {
                    viewGroup.removeView(findViewById);
                }
                NavigationBarCoverTip navigationBarCoverTip = new NavigationBarCoverTip(activity);
                navigationBarCoverTip.setId(R.id.obfuscated_res_0x7f091666);
                viewGroup.addView(navigationBarCoverTip, new RelativeLayout.LayoutParams(-1, -2));
                TextView textView = new TextView(activity);
                textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                textView.setMinHeight(q(R.dimen.tbds112));
                int q = q(R.dimen.tbds20);
                textView.setPadding(q, 0, q, 0);
                textView.setGravity(17);
                textView.setTextSize(0, q(R.dimen.tbfontsize42));
                textView.setLineSpacing(q(R.dimen.obfuscated_res_0x7f0701d4), 1.0f);
                textView.setText(activity.getString(R.string.obfuscated_res_0x7f0f11e1));
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
                SkinManager.setBackgroundColor(navigationBarCoverTip, R.color.cp_link_tip_a_alpha95);
                navigationBarCoverTip.m(activity, textView);
                return navigationBarCoverTip;
            }
            return null;
        }
        return (NavigationBarCoverTip) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.k35
    public void f(int i, TbPageContext tbPageContext, ViewGroup viewGroup, boolean z) {
        Activity pageActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), tbPageContext, viewGroup, Boolean.valueOf(z)}) == null) && tbPageContext != null && (pageActivity = tbPageContext.getPageActivity()) != null && ch.e(pageActivity)) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(tbPageContext.getPageActivity()).areNotificationsEnabled();
            if (n35.d().D() && areNotificationsEnabled) {
                return;
            }
            d(i, tbPageContext, new c(this, pageActivity, areNotificationsEnabled), z);
            py4.k().w("sign_time_set_dialog", 1);
        }
    }

    @Override // com.baidu.tieba.k35
    public void h(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            int[] r = r(j);
            if (r == null) {
                y(a(), g(), b());
            } else if (r.length == 2) {
                i(z, r[0], r[1]);
                c();
            }
        }
    }

    @Override // com.baidu.tieba.k35
    public void i(boolean z, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            y(z, i, i2);
            TbadkSettings.getInst().saveBoolean("alert_sign_on", z);
            TbadkSettings.getInst().saveInt("alert_sign_hours", i);
            TbadkSettings.getInst().saveInt("alert_sign_mins", i2);
        }
    }

    public final int[] r(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) {
            if (j <= 0) {
                return null;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j);
            return new int[]{calendar.get(11), calendar.get(12)};
        }
        return (int[]) invokeJ.objValue;
    }

    public final void y(boolean z, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            x();
            this.b = a();
            this.c = g();
            this.d = b();
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, i);
            calendar.set(12, i2);
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_UPDATE_SIGN_DATA);
            httpMessage.addParam("sign_push_mask", z ? 1 : 0);
            httpMessage.addParam("sign_push_time_stamp", calendar.getTimeInMillis() / 1000);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
