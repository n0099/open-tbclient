package com.baidu.tieba;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class n47 {
    public static /* synthetic */ Interceptable $ic;
    public static final a b;
    public static final int c;
    public static final int d;
    public static final int e = 0;
    public static final int f;
    public transient /* synthetic */ FieldHolder $fh;
    public final RecyclerView.RecycledViewPool a;

    public static final int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? b.a() : invokeV.intValue;
    }

    @JvmStatic
    public static final n47 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? b.b() : (n47) invokeV.objValue;
    }

    @JvmStatic
    @JvmOverloads
    public static final View h(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, view2)) == null) {
            b.c(view2);
            return view2;
        }
        return (View) invokeL.objValue;
    }

    @JvmStatic
    @JvmOverloads
    public static final View i(View view2, Integer num) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, view2, num)) == null) {
            b.d(view2, num);
            return view2;
        }
        return (View) invokeLL.objValue;
    }

    @JvmStatic
    @JvmOverloads
    public static final View j(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, view2)) == null) {
            b.g(view2);
            return view2;
        }
        return (View) invokeL.objValue;
    }

    @JvmStatic
    @JvmOverloads
    public static final View k(View view2, Integer num) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, view2, num)) == null) {
            b.h(view2, num);
            return view2;
        }
        return (View) invokeLL.objValue;
    }

    @JvmStatic
    @JvmOverloads
    public static final View l(View view2, Integer num, Integer num2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, null, view2, num, num2)) == null) {
            b.i(view2, num, num2);
            return view2;
        }
        return (View) invokeLLL.objValue;
    }

    @JvmStatic
    @JvmOverloads
    public static final View m(View view2, Integer num, Integer num2, Integer num3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, view2, num, num2, num3)) == null) {
            b.j(view2, num, num2, num3);
            return view2;
        }
        return (View) invokeLLLL.objValue;
    }

    @JvmStatic
    @JvmOverloads
    public static final View n(View view2, Integer num, Integer num2, Integer num3, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{view2, num, num2, num3, Integer.valueOf(i)})) == null) {
            b.k(view2, num, num2, num3, i);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    @JvmStatic
    public static final void o(View view2, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, view2, motionEvent) == null) {
            b.n(view2, motionEvent);
        }
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @JvmOverloads
        public final View c(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
                Intrinsics.checkNotNullParameter(view2, "view");
                f(this, view2, null, null, 6, null);
                return view2;
            }
            return (View) invokeL.objValue;
        }

        @JvmStatic
        @JvmOverloads
        public final View d(View view2, Integer num) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, num)) == null) {
                Intrinsics.checkNotNullParameter(view2, "view");
                f(this, view2, num, null, 4, null);
                return view2;
            }
            return (View) invokeLL.objValue;
        }

        @JvmStatic
        @JvmOverloads
        public final View g(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view2)) == null) {
                Intrinsics.checkNotNullParameter(view2, "view");
                m(this, view2, null, null, null, 0, 0, 62, null);
                return view2;
            }
            return (View) invokeL.objValue;
        }

        @JvmStatic
        @JvmOverloads
        public final View h(View view2, Integer num) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, view2, num)) == null) {
                Intrinsics.checkNotNullParameter(view2, "view");
                m(this, view2, num, null, null, 0, 0, 60, null);
                return view2;
            }
            return (View) invokeLL.objValue;
        }

        @JvmStatic
        @JvmOverloads
        public final View i(View view2, Integer num, Integer num2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, view2, num, num2)) == null) {
                Intrinsics.checkNotNullParameter(view2, "view");
                m(this, view2, num, num2, null, 0, 0, 56, null);
                return view2;
            }
            return (View) invokeLLL.objValue;
        }

        @JvmStatic
        @JvmOverloads
        public final View j(View view2, Integer num, Integer num2, Integer num3) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, num, num2, num3)) == null) {
                Intrinsics.checkNotNullParameter(view2, "view");
                m(this, view2, num, num2, num3, 0, 0, 48, null);
                return view2;
            }
            return (View) invokeLLLL.objValue;
        }

        @JvmStatic
        @JvmOverloads
        public final View k(View view2, Integer num, Integer num2, Integer num3, int i) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{view2, num, num2, num3, Integer.valueOf(i)})) == null) {
                Intrinsics.checkNotNullParameter(view2, "view");
                m(this, view2, num, num2, num3, i, 0, 32, null);
                return view2;
            }
            return (View) invokeCommon.objValue;
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
                return invokeV.intValue;
            }
            return n47.f;
        }

        @JvmStatic
        public final n47 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return b.a.a();
            }
            return (n47) invokeV.objValue;
        }

        public static /* synthetic */ View f(a aVar, View view2, Integer num, Integer num2, int i, Object obj) {
            if ((i & 2) != 0) {
                num = null;
            }
            if ((i & 4) != 0) {
                num2 = null;
            }
            aVar.e(view2, num, num2);
            return view2;
        }

        public static /* synthetic */ View m(a aVar, View view2, Integer num, Integer num2, Integer num3, int i, int i2, int i3, Object obj) {
            Integer num4;
            Integer num5;
            int i4;
            int i5;
            Integer num6 = null;
            if ((i3 & 2) != 0) {
                num4 = null;
            } else {
                num4 = num;
            }
            if ((i3 & 4) != 0) {
                num5 = null;
            } else {
                num5 = num2;
            }
            if ((i3 & 8) == 0) {
                num6 = num3;
            }
            if ((i3 & 16) != 0) {
                i4 = -1;
            } else {
                i4 = i;
            }
            if ((i3 & 32) != 0) {
                i5 = -2;
            } else {
                i5 = i2;
            }
            aVar.l(view2, num4, num5, num6, i4, i5);
            return view2;
        }

        @JvmStatic
        @JvmOverloads
        public final View e(View view2, Integer num, Integer num2) {
            InterceptResult invokeLLL;
            ViewGroup.MarginLayoutParams marginLayoutParams;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, view2, num, num2)) == null) {
                Intrinsics.checkNotNullParameter(view2, "view");
                if (view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if (layoutParams != null) {
                        marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    }
                } else {
                    marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
                }
                if (num != null) {
                    marginLayoutParams.topMargin = num.intValue();
                } else {
                    marginLayoutParams.topMargin = a();
                }
                if (num2 != null) {
                    marginLayoutParams.bottomMargin = num2.intValue();
                } else {
                    marginLayoutParams.bottomMargin = a();
                }
                view2.setLayoutParams(marginLayoutParams);
                return view2;
            }
            return (View) invokeLLL.objValue;
        }

        @JvmStatic
        @JvmOverloads
        public final View l(View view2, Integer num, Integer num2, Integer num3, int i, int i2) {
            InterceptResult invokeCommon;
            ViewGroup.MarginLayoutParams marginLayoutParams;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{view2, num, num2, num3, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
                Intrinsics.checkNotNullParameter(view2, "view");
                if (view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if (layoutParams != null) {
                        marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    }
                } else {
                    marginLayoutParams = new ViewGroup.MarginLayoutParams(i, i2);
                }
                if (num != null) {
                    marginLayoutParams.leftMargin = num.intValue();
                    marginLayoutParams.rightMargin = num.intValue();
                } else {
                    marginLayoutParams.leftMargin = n47.c;
                    marginLayoutParams.rightMargin = n47.c;
                }
                if (num2 != null) {
                    marginLayoutParams.topMargin = num2.intValue();
                } else {
                    marginLayoutParams.topMargin = n47.d;
                }
                if (num3 != null) {
                    marginLayoutParams.bottomMargin = num3.intValue();
                } else {
                    marginLayoutParams.bottomMargin = n47.e;
                }
                view2.setLayoutParams(marginLayoutParams);
                return view2;
            }
            return (View) invokeCommon.objValue;
        }

        @JvmStatic
        public final void n(View targetView, MotionEvent event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, targetView, event) == null) {
                Intrinsics.checkNotNullParameter(targetView, "targetView");
                Intrinsics.checkNotNullParameter(event, "event");
                int action = event.getAction();
                if (action != 0) {
                    if (action == 1 || action == 3) {
                        targetView.setPressed(false);
                        return;
                    }
                    return;
                }
                targetView.setPressed(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public static final n47 b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-623342214, "Lcom/baidu/tieba/n47$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-623342214, "Lcom/baidu/tieba/n47$b;");
                    return;
                }
            }
            a = new b();
            b = new n47();
        }

        public b() {
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

        public final n47 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b;
            }
            return (n47) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947952568, "Lcom/baidu/tieba/n47;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947952568, "Lcom/baidu/tieba/n47;");
                return;
            }
        }
        b = new a(null);
        c = ri.g(TbadkApplication.getInst(), R.dimen.M_W_X005);
        d = ri.g(TbadkApplication.getInst(), R.dimen.M_H_X002);
        f = ri.g(TbadkApplication.getInst(), R.dimen.M_H_X003) / 2;
    }

    public n47() {
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
        this.a = new RecyclerView.RecycledViewPool();
    }

    public final RecyclerView.RecycledViewPool g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (RecyclerView.RecycledViewPool) invokeV.objValue;
    }
}
