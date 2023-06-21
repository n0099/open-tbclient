package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.view.breathetip.BreatheTipWidget;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class pa9 {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public static final String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ View b;

        public a(Context context, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || BreatheTipWidget.f() || this.a == null) {
                return;
            }
            fa5 fa5Var = new fa5();
            fa5Var.b = R.raw.lottie_bubble_breath_tip;
            fa5Var.a = BreatheTipWidget.PointType.LOTTIE;
            fa5Var.c = wi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds130);
            ga5 ga5Var = new ga5();
            ga5Var.a = q89.t(R.string.obfuscated_res_0x7f0f05a3, new Object[0]);
            ga5Var.b = q89.t(R.string.agree_tip_content, new Object[0]);
            ga5Var.e = R.drawable.pic_guidecard;
            ga5Var.f = wi.g(this.a, R.dimen.tbds156);
            ga5Var.g = wi.g(this.a, R.dimen.tbds489);
            ga5Var.h = wi.g(this.a, R.dimen.tbds286);
            if (this.b == null) {
                return;
            }
            BreatheTipWidget breatheTipWidget = new BreatheTipWidget(this.a);
            breatheTipWidget.j(this.b);
            breatheTipWidget.h(ga5Var, fa5Var);
            if (breatheTipWidget.k((Activity) this.a, 4000L)) {
                o95 p = o95.p();
                p.A("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), true);
                xf5.c("c14828");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948055457, "Lcom/baidu/tieba/pa9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948055457, "Lcom/baidu/tieba/pa9;");
                return;
            }
        }
        a = o95.t("key_show_god_agree_tips_count");
        b = o95.t("key_show_god_agree_tips_timestamp");
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && !b()) {
            o95.p().H(b, System.currentTimeMillis());
            o95.p().F(a, 0);
        }
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long r = o95.p().r(b, 0L);
            if (r >= 0) {
                return TimeHelper.isSameDay(currentTimeMillis, r);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean c(j49 j49Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, j49Var)) == null) {
            if (j49Var == null || j49Var.N() == null || !TbadkCoreApplication.isLogin() || !j49Var.N().isExcellentThread() || j49Var.N().getHasAgree() == 1) {
                return false;
            }
            if (b()) {
                i = o95.p().q(a, 0);
            } else {
                i = 0;
            }
            if (i >= 2) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void d(Context context, View view2, j49 j49Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, view2, j49Var) != null) || j39.c() || c(j49Var)) {
            return;
        }
        o95 p = o95.p();
        if (!p.l("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), false)) {
            xg.a().postDelayed(new a(context, view2), 500L);
        }
    }
}
