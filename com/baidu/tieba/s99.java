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
public class s99 {
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
            ea5 ea5Var = new ea5();
            ea5Var.b = R.raw.lottie_bubble_breath_tip;
            ea5Var.a = BreatheTipWidget.PointType.LOTTIE;
            ea5Var.c = vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds130);
            fa5 fa5Var = new fa5();
            fa5Var.a = u79.t(R.string.obfuscated_res_0x7f0f05a2, new Object[0]);
            fa5Var.b = u79.t(R.string.agree_tip_content, new Object[0]);
            fa5Var.e = R.drawable.pic_guidecard;
            fa5Var.f = vi.g(this.a, R.dimen.tbds156);
            fa5Var.g = vi.g(this.a, R.dimen.tbds489);
            fa5Var.h = vi.g(this.a, R.dimen.tbds286);
            if (this.b == null) {
                return;
            }
            BreatheTipWidget breatheTipWidget = new BreatheTipWidget(this.a);
            breatheTipWidget.j(this.b);
            breatheTipWidget.h(fa5Var, ea5Var);
            if (breatheTipWidget.k((Activity) this.a, 4000L)) {
                n95 m = n95.m();
                m.w("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), true);
                sf5.c("c14828");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948106390, "Lcom/baidu/tieba/s99;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948106390, "Lcom/baidu/tieba/s99;");
                return;
            }
        }
        a = n95.q("key_show_god_agree_tips_count");
        b = n95.q("key_show_god_agree_tips_timestamp");
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && !b()) {
            n95.m().A(b, System.currentTimeMillis());
            n95.m().z(a, 0);
        }
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long o = n95.m().o(b, 0L);
            if (o >= 0) {
                return TimeHelper.isSameDay(currentTimeMillis, o);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean c(m39 m39Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, m39Var)) == null) {
            if (m39Var == null || m39Var.N() == null || !TbadkCoreApplication.isLogin() || !m39Var.N().isExcellentThread() || m39Var.N().getHasAgree() == 1) {
                return false;
            }
            if (b()) {
                i = n95.m().n(a, 0);
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

    public static void d(Context context, View view2, m39 m39Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, view2, m39Var) != null) || c(m39Var)) {
            return;
        }
        n95 m = n95.m();
        if (!m.i("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), false)) {
            wg.a().postDelayed(new a(context, view2), 500L);
        }
    }
}
