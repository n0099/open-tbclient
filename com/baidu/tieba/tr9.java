package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.view.breathetip.BreatheTipWidget;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class tr9 {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public static final String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
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
            la5 la5Var = new la5();
            la5Var.b = R.raw.lottie_bubble_breath_tip;
            la5Var.a = BreatheTipWidget.PointType.LOTTIE;
            la5Var.c = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds130);
            ma5 ma5Var = new ma5();
            ma5Var.a = pp9.t(R.string.obfuscated_res_0x7f0f05ae, new Object[0]);
            ma5Var.b = pp9.t(R.string.agree_tip_content, new Object[0]);
            ma5Var.e = R.drawable.pic_guidecard;
            ma5Var.f = BdUtilHelper.getDimens(this.a, R.dimen.tbds156);
            ma5Var.g = BdUtilHelper.getDimens(this.a, R.dimen.tbds489);
            ma5Var.h = BdUtilHelper.getDimens(this.a, R.dimen.tbds286);
            if (this.b == null) {
                return;
            }
            BreatheTipWidget breatheTipWidget = new BreatheTipWidget(this.a);
            breatheTipWidget.j(this.b);
            breatheTipWidget.h(ma5Var, la5Var);
            if (breatheTipWidget.k((Activity) this.a, 4000L)) {
                SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                sharedPrefHelper.putBoolean("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), true);
                kg5.c("c14828");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948190958, "Lcom/baidu/tieba/tr9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948190958, "Lcom/baidu/tieba/tr9;");
                return;
            }
        }
        a = SharedPrefHelper.getSharedPrefKeyWithAccount("key_show_god_agree_tips_count");
        b = SharedPrefHelper.getSharedPrefKeyWithAccount("key_show_god_agree_tips_timestamp");
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && !b()) {
            SharedPrefHelper.getInstance().putLong(b, System.currentTimeMillis());
            SharedPrefHelper.getInstance().putInt(a, 0);
        }
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = SharedPrefHelper.getInstance().getLong(b, 0L);
            if (j >= 0) {
                return TimeHelper.isSameDay(currentTimeMillis, j);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean c(lk9 lk9Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, lk9Var)) == null) {
            if (lk9Var == null || lk9Var.O() == null || !TbadkCoreApplication.isLogin() || !lk9Var.O().isExcellentThread() || lk9Var.O().getHasAgree() == 1) {
                return false;
            }
            if (b()) {
                i = SharedPrefHelper.getInstance().getInt(a, 0);
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

    public static void d(Context context, View view2, lk9 lk9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, view2, lk9Var) != null) || oi9.c() || c(lk9Var)) {
            return;
        }
        SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
        if (!sharedPrefHelper.getBoolean("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), false)) {
            SafeHandler.getInst().postDelayed(new a(context, view2), 500L);
        }
    }
}
