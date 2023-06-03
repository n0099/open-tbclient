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
public class p99 {
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
            ca5 ca5Var = new ca5();
            ca5Var.b = R.raw.lottie_bubble_breath_tip;
            ca5Var.a = BreatheTipWidget.PointType.LOTTIE;
            ca5Var.c = vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds130);
            da5 da5Var = new da5();
            da5Var.a = r79.t(R.string.obfuscated_res_0x7f0f05a2, new Object[0]);
            da5Var.b = r79.t(R.string.agree_tip_content, new Object[0]);
            da5Var.e = R.drawable.pic_guidecard;
            da5Var.f = vi.g(this.a, R.dimen.tbds156);
            da5Var.g = vi.g(this.a, R.dimen.tbds489);
            da5Var.h = vi.g(this.a, R.dimen.tbds286);
            if (this.b == null) {
                return;
            }
            BreatheTipWidget breatheTipWidget = new BreatheTipWidget(this.a);
            breatheTipWidget.j(this.b);
            breatheTipWidget.h(da5Var, ca5Var);
            if (breatheTipWidget.k((Activity) this.a, 4000L)) {
                l95 m = l95.m();
                m.w("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), true);
                qf5.c("c14828");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948017017, "Lcom/baidu/tieba/p99;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948017017, "Lcom/baidu/tieba/p99;");
                return;
            }
        }
        a = l95.q("key_show_god_agree_tips_count");
        b = l95.q("key_show_god_agree_tips_timestamp");
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && !b()) {
            l95.m().A(b, System.currentTimeMillis());
            l95.m().z(a, 0);
        }
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long o = l95.m().o(b, 0L);
            if (o >= 0) {
                return TimeHelper.isSameDay(currentTimeMillis, o);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean c(j39 j39Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, j39Var)) == null) {
            if (j39Var == null || j39Var.N() == null || !TbadkCoreApplication.isLogin() || !j39Var.N().isExcellentThread() || j39Var.N().getHasAgree() == 1) {
                return false;
            }
            if (b()) {
                i = l95.m().n(a, 0);
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

    public static void d(Context context, View view2, j39 j39Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, view2, j39Var) != null) || c(j39Var)) {
            return;
        }
        l95 m = l95.m();
        if (!m.i("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), false)) {
            wg.a().postDelayed(new a(context, view2), 500L);
        }
    }
}
