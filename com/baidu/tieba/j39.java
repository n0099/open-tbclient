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
/* loaded from: classes6.dex */
public class j39 {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public static final String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
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
            g75 g75Var = new g75();
            g75Var.b = R.raw.lottie_bubble_breath_tip;
            g75Var.a = BreatheTipWidget.PointType.LOTTIE;
            g75Var.c = ri.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds130);
            h75 h75Var = new h75();
            h75Var.a = n19.t(R.string.obfuscated_res_0x7f0f0597, new Object[0]);
            h75Var.b = n19.t(R.string.agree_tip_content, new Object[0]);
            h75Var.e = R.drawable.pic_guidecard;
            h75Var.f = ri.g(this.a, R.dimen.tbds156);
            h75Var.g = ri.g(this.a, R.dimen.tbds489);
            h75Var.h = ri.g(this.a, R.dimen.tbds286);
            if (this.b == null) {
                return;
            }
            BreatheTipWidget breatheTipWidget = new BreatheTipWidget(this.a);
            breatheTipWidget.i(this.b);
            breatheTipWidget.g(h75Var, g75Var);
            if (breatheTipWidget.j((Activity) this.a, 4000L)) {
                o65 m = o65.m();
                m.w("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), true);
                oc5.c("c14828");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947832505, "Lcom/baidu/tieba/j39;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947832505, "Lcom/baidu/tieba/j39;");
                return;
            }
        }
        a = o65.q("key_show_god_agree_tips_count");
        b = o65.q("key_show_god_agree_tips_timestamp");
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && !b()) {
            o65.m().A(b, System.currentTimeMillis());
            o65.m().z(a, 0);
        }
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long o = o65.m().o(b, 0L);
            if (o >= 0) {
                return TimeHelper.isSameDay(currentTimeMillis, o);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean c(lx8 lx8Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, lx8Var)) == null) {
            if (lx8Var == null || lx8Var.M() == null || !TbadkCoreApplication.isLogin() || !lx8Var.M().isExcellentThread() || lx8Var.M().getHasAgree() == 1) {
                return false;
            }
            if (b()) {
                i = o65.m().n(a, 0);
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

    public static void d(Context context, View view2, lx8 lx8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, view2, lx8Var) != null) || c(lx8Var)) {
            return;
        }
        o65 m = o65.m();
        if (!m.i("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), false)) {
            sg.a().postDelayed(new a(context, view2), 500L);
        }
    }
}
