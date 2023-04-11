package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.nadcore.lp.reward.view.NadRewardFullTailView;
import com.baidu.nadcore.lp.reward.view.NadRewardHalfTailHolder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public interface nn0 {
    public static final a k0 = a.a;

    ViewGroup getView();

    void setData(sp0 sp0Var);

    void setOnReplayClickListener(Function0<Unit> function0);

    void setVisibility(boolean z);

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-569986564, "Lcom/baidu/tieba/nn0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-569986564, "Lcom/baidu/tieba/nn0$a;");
                    return;
                }
            }
            a = new a();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public final nn0 a(sp0 adModel, Context context) {
            InterceptResult invokeLL;
            String str;
            xp0 xp0Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, adModel, context)) == null) {
                Intrinsics.checkNotNullParameter(adModel, "adModel");
                Intrinsics.checkNotNullParameter(context, "context");
                vp0 vp0Var = adModel.j;
                if (vp0Var != null && (xp0Var = vp0Var.i) != null) {
                    str = xp0Var.a;
                } else {
                    str = null;
                }
                if (str != null && str.hashCode() == 49 && str.equals("1")) {
                    return new NadRewardHalfTailHolder(context, null, 0, 6, null);
                }
                return new NadRewardFullTailView(context, null, 0, 6, null);
            }
            return (nn0) invokeLL.objValue;
        }
    }
}
