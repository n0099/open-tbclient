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
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.tieba.service.SignAlertReceiver;
import com.baidu.tieba.view.NavigationBarCoverTip;
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
public class p95 implements l95 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yv5 a;
    public boolean b;
    public int c;
    public int d;
    public Runnable e;

    public static String u(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i)) == null) ? i == 1 ? "forum_sign" : i == 4 ? "sign" : "default" : (String) invokeI.objValue;
    }

    public static int v(int i) {
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
    public class d implements ov5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ TbPageContext b;
        public final /* synthetic */ p95 c;

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
                        this.a.c.a.C();
                        this.a.c.a.f();
                    }
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_OK_CLICK);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    boolean F = o95.d().F();
                    boolean areNotificationsEnabled = NotificationManagerCompat.from(this.a.b.getPageActivity()).areNotificationsEnabled();
                    if (!F) {
                        o95.d().b0(true);
                    }
                    if (areNotificationsEnabled) {
                        pa5.o(this.a.b.getPageActivity());
                    } else {
                        ka5.e(this.a.b);
                    }
                    p95.w(this.a.a, true);
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
                    p95.w(this.a.a, false);
                }
            }
        }

        public d(p95 p95Var, int i, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p95Var, Integer.valueOf(i), tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = p95Var;
            this.a = i;
            this.b = tbPageContext;
        }

        @Override // com.baidu.tieba.ov5
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                View findViewById = view2.findViewById(R.id.layout_bottom_title);
                View findViewById2 = view2.findViewById(R.id.layout_bg);
                View findViewById3 = view2.findViewById(R.id.layout_bg_top);
                SkinManager.setBackgroundResource(findViewById2, R.color.CAM_X0208);
                SkinManager.setBackgroundResource(findViewById3, R.drawable.sign_remind_pic);
                View findViewById4 = view2.findViewById(R.id.layout_content);
                TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092608);
                TextView textView2 = (TextView) view2.findViewById(R.id.sign_remind_timer);
                TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) view2.findViewById(R.id.push_permission_dialog_confirm_button1);
                this.c.q(tBSpecificationBtn);
                TextView textView3 = (TextView) view2.findViewById(R.id.push_permission_dialog_cancel_button1);
                q25.d((WheelView) view2.findViewById(R.id.obfuscated_res_0x7f090f51)).f(R.color.CAM_X0208);
                q25.d((WheelView) view2.findViewById(R.id.obfuscated_res_0x7f0916ad)).f(R.color.CAM_X0208);
                SkinManager.setBackgroundColor(findViewById4, R.color.CAM_X0208);
                SkinManager.setBackgroundColor((LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0923c4), R.color.CAM_X0306);
                q25 d = q25.d(textView);
                d.w(R.color.CAM_X0105);
                d.B(R.dimen.T_X05);
                d.C(R.string.F_X02);
                q25 d2 = q25.d(textView2);
                d2.w(R.color.CAM_X0108);
                d2.B(R.dimen.T_X07);
                d2.C(R.string.F_X01);
                q25 d3 = q25.d(textView3);
                d3.w(R.color.CAM_X0110);
                d3.C(R.string.F_X01);
                d3.B(R.dimen.T_X08);
                Map<String, String> f = pa5.f(p95.u(this.a));
                textView.setText(f.get("view_params_key_title"));
                textView2.setText(f.get("view_params_key_desc"));
                if (tBSpecificationBtn != null) {
                    tBSpecificationBtn.setTextSize(R.dimen.T_X06);
                    tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getString(R.string.push_permission_dialog_confirm_button_text_3));
                    tBSpecificationBtn.setConfig(new m55());
                }
                if (this.a == 3 && tBSpecificationBtn != null) {
                    tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f045d));
                    textView3.setText(TbadkCoreApplication.getInst().getString(R.string.protocol_cancel));
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
        public final /* synthetic */ p95 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(p95 p95Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p95Var, Integer.valueOf(i)};
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
            this.a = p95Var;
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
        public final /* synthetic */ p95 a;

        public b(p95 p95Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p95Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p95Var;
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
    public class c implements tv5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ boolean b;

        public c(p95 p95Var, Activity activity, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p95Var, activity, Boolean.valueOf(z)};
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
        @Override // com.baidu.tieba.tv5
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(Date date, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, date, view2) == null) && date != null) {
                boolean z = true;
                if ("frs.FrsActivity".equals(this.a.getLocalClassName()) && p45.m().i("first_call_attention", true)) {
                    p45.m().w("first_call_attention", false);
                }
                z = false;
                if (z) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001223, date));
                }
            }
        }
    }

    public p95() {
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
        this.b = false;
        this.c = 12;
        this.d = 0;
        this.e = new b(this);
        a aVar = new a(this, CmdConfigHttp.CMD_UPDATE_SIGN_DATA);
        aVar.setPriority(-1);
        MessageManager.getInstance().registerListener(aVar);
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis() + 60000);
            TbadkSettings.getInst().saveInt("alert_sign_hours", calendar.get(11));
            TbadkSettings.getInst().saveInt("alert_sign_mins", calendar.get(12));
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_UPDATE_SIGN_DATA, TbConfig.SERVER_ADDRESS + TbConfig.UPDATE_SIGN_DATA);
            tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
            tbHttpMessageTask.setIsNeedTbs(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65547, null, i) == null) {
            TiebaStatic.log(new StatisticItem("c13674").param("obj_source", v(i)));
        }
    }

    public final int s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            return ii.g(TbadkCoreApplication.getInst(), i);
        }
        return invokeI.intValue;
    }

    public static void w(int i, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            int v = v(i);
            StatisticItem statisticItem = new StatisticItem("c13673");
            if (z) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            TiebaStatic.log(statisticItem.param("obj_type", i2).param("obj_source", v));
        }
    }

    public final void A(boolean z, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            z();
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

    @Override // com.baidu.tieba.l95
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return TbadkSettings.getInst().loadBoolean("alert_sign_on", false);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.l95
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int loadInt = TbadkSettings.getInst().loadInt("alert_sign_mins", -1);
            if (loadInt == -1) {
                y();
                return TbadkSettings.getInst().loadInt("alert_sign_mins", 30);
            }
            return loadInt;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.l95
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int loadInt = TbadkSettings.getInst().loadInt("alert_sign_hours", -1);
            if (loadInt == -1) {
                y();
                return TbadkSettings.getInst().loadInt("alert_sign_hours", 12);
            }
            return loadInt;
        }
        return invokeV.intValue;
    }

    public final Intent r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            Intent intent = new Intent(TbConfig.getBroadcastActionSignAlert());
            intent.setData(Uri.parse("tieba_sign://alert"));
            intent.setClass(TbadkCoreApplication.getInst(), SignAlertReceiver.class);
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // com.baidu.tieba.l95
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            AlarmManager alarmManager = (AlarmManager) inst.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent r = r();
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
                alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(inst, 0, r, 134217728));
                return;
            }
            PendingIntent broadcast = PendingIntent.getBroadcast(inst, 0, r, NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
            if (broadcast != null) {
                alarmManager.cancel(broadcast);
            }
        }
    }

    @Override // com.baidu.tieba.l95
    public Dialog d(int i, TbPageContext tbPageContext, tv5 tv5Var, boolean z) {
        InterceptResult invokeCommon;
        Activity pageActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), tbPageContext, tv5Var, Boolean.valueOf(z)})) == null) {
            if (tbPageContext == null || (pageActivity = tbPageContext.getPageActivity()) == null || !lg.e(pageActivity)) {
                return null;
            }
            Calendar calendar = Calendar.getInstance();
            int j = o95.d().j();
            int k = o95.d().k();
            if (j > 0 && k > 0) {
                calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), j, k);
            } else {
                calendar.setTimeInMillis(System.currentTimeMillis() + 60000);
            }
            mv5 mv5Var = new mv5(pageActivity, tv5Var);
            mv5Var.g(calendar);
            mv5Var.k(R.layout.dialog_sign_remind, new d(this, i, tbPageContext));
            mv5Var.f(18);
            mv5Var.p(new boolean[]{false, false, false, true, true, false});
            mv5Var.j("年", "月", "日", "", "", "秒");
            mv5Var.l(2.0f);
            mv5Var.o(0, 0, 0, 0, 0, 0);
            mv5Var.b(false);
            mv5Var.i(SkinManager.getColor(R.color.CAM_X0204));
            mv5Var.m(SkinManager.getColor(R.color.CAM_X0105));
            mv5Var.n(SkinManager.getColor(R.color.CAM_X0109));
            mv5Var.d(SkinManager.getColor(R.color.black_alpha30));
            mv5Var.e(SkinManager.getColor(R.color.CAM_X0211));
            yv5 a2 = mv5Var.a();
            this.a = a2;
            if (z) {
                jg.a().postDelayed(this.e, TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
            } else {
                a2.u();
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            x(i);
            return this.a.j();
        }
        return (Dialog) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.l95
    public NavigationBarCoverTip e(Activity activity, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, activity, viewGroup)) == null) {
            if (activity != null && viewGroup != null) {
                View findViewById = viewGroup.findViewById(R.id.navbar_cover_tip_view);
                if (findViewById != null) {
                    viewGroup.removeView(findViewById);
                }
                NavigationBarCoverTip navigationBarCoverTip = new NavigationBarCoverTip(activity);
                navigationBarCoverTip.setId(R.id.navbar_cover_tip_view);
                viewGroup.addView(navigationBarCoverTip, new RelativeLayout.LayoutParams(-1, -2));
                TextView textView = new TextView(activity);
                textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                textView.setMinHeight(s(R.dimen.tbds112));
                int s = s(R.dimen.tbds20);
                textView.setPadding(s, 0, s, 0);
                textView.setGravity(17);
                textView.setTextSize(0, s(R.dimen.tbfontsize42));
                textView.setLineSpacing(s(R.dimen.obfuscated_res_0x7f0701d4), 1.0f);
                textView.setText(activity.getString(R.string.sign_remind_timer_succ));
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
                SkinManager.setBackgroundColor(navigationBarCoverTip, R.color.cp_link_tip_a_alpha95);
                navigationBarCoverTip.m(activity, textView);
                return navigationBarCoverTip;
            }
            return null;
        }
        return (NavigationBarCoverTip) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.l95
    public void f(int i, TbPageContext tbPageContext, ViewGroup viewGroup, boolean z) {
        Activity pageActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), tbPageContext, viewGroup, Boolean.valueOf(z)}) == null) && tbPageContext != null && (pageActivity = tbPageContext.getPageActivity()) != null && lg.e(pageActivity)) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(tbPageContext.getPageActivity()).areNotificationsEnabled();
            if (o95.d().F() && areNotificationsEnabled) {
                return;
            }
            d(i, tbPageContext, new c(this, pageActivity, areNotificationsEnabled), z);
            p45.m().z("sign_time_set_dialog", 1);
        }
    }

    @Override // com.baidu.tieba.l95
    public void h(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            int[] t = t(j);
            if (t == null) {
                A(a(), g(), b());
            } else if (t.length == 2) {
                i(z, t[0], t[1]);
                c();
            }
        }
    }

    @Override // com.baidu.tieba.l95
    public void i(boolean z, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            A(z, i, i2);
            TbadkSettings.getInst().saveBoolean("alert_sign_on", z);
            TbadkSettings.getInst().saveInt("alert_sign_hours", i);
            TbadkSettings.getInst().saveInt("alert_sign_mins", i2);
        }
    }

    public final void q(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, view2) == null) && view2 != null && view2.getContext() != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = yh.b(view2.getContext()) + UtilHelper.getDimenPixelSize(R.dimen.tbds10);
                view2.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public final int[] t(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048589, this, j)) == null) {
            if (j <= 0) {
                return null;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j);
            return new int[]{calendar.get(11), calendar.get(12)};
        }
        return (int[]) invokeJ.objValue;
    }
}
