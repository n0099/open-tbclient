package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class j82 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (view2.getParent() != null) {
                    view2.getParent().requestDisallowInterceptTouchEvent(true);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollView a;
        public final /* synthetic */ d82 b;

        public b(ScrollView scrollView, d82 d82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollView, d82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = scrollView;
            this.b = d82Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.smoothScrollTo(0, this.b.D);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947837093, "Lcom/baidu/tieba/j82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947837093, "Lcom/baidu/tieba/j82;");
                return;
            }
        }
        a = fs1.a;
    }

    public static FrameLayout.LayoutParams a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.leftMargin = 0;
            layoutParams.topMargin = 0;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeV.objValue;
    }

    public static boolean b(@NonNull k82 k82Var, @NonNull l72 l72Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, k82Var, l72Var, swanAppComponentContainerView)) == null) {
            v82.c("Component-Container-Scroll", "insert component（scroll）");
            if (l72Var.h == null) {
                o82.a("Component-Container-Scroll", "insert component（scroll） with a null position");
                return false;
            } else if (TextUtils.isEmpty(l72Var.d)) {
                ScrollView h = h(swanAppComponentContainerView, l72Var);
                if (h == null || !k82Var.a.c(h, l72Var.h)) {
                    return false;
                }
                return true;
            } else {
                SwanAppComponentContainerView a2 = k82Var.a(l72Var.d);
                if (a2 == null) {
                    v82.c("Component-Container-Scroll", "insert component（scroll） to parent with a null parent container view");
                    return false;
                }
                ScrollView h2 = h(swanAppComponentContainerView, l72Var);
                if (h2 == null) {
                    v82.c("Component-Container-Scroll", "insert component（scroll） to parent with a null scroll view");
                    return false;
                }
                a2.addView(h2, l72Var.b());
                return true;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static boolean g(@NonNull k82 k82Var, @NonNull l72 l72Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, k82Var, l72Var, swanAppComponentContainerView)) == null) {
            if (TextUtils.isEmpty(l72Var.d)) {
                return k82Var.a.removeView(swanAppComponentContainerView.getScrollView());
            }
            SwanAppComponentContainerView a2 = k82Var.a(l72Var.d);
            if (a2 == null) {
                v82.c("Component-Container-Scroll", "remove component（scroll） to parent with a null parent container view");
                return false;
            }
            ScrollView scrollView = swanAppComponentContainerView.getScrollView();
            boolean z = true;
            if (scrollView != null && scrollView.getParent() == a2) {
                a2.removeView(scrollView);
                return true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("remove component（scroll）to parent with a illegal parent view");
            if (scrollView != null) {
                z = false;
            }
            sb.append(z);
            o82.a("Component-Container-Scroll", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean c(@NonNull l72 l72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, l72Var)) == null) {
            if ((l72Var instanceof d82) && TextUtils.equals(((d82) l72Var).E, "scroll")) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean d(@NonNull k82 k82Var, @NonNull k72 k72Var, @NonNull l72 l72Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull n82 n82Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, k82Var, k72Var, l72Var, swanAppComponentContainerView, n82Var)) == null) {
            if (!(l72Var instanceof d82)) {
                return false;
            }
            ScrollView scrollView = swanAppComponentContainerView.getScrollView();
            if (n82Var.a(7)) {
                if (a) {
                    Log.d("Component-Container-Scroll", "update component（scroll）overflow_y");
                }
                if (scrollView != null) {
                    if (scrollView.getParent() == null) {
                        return false;
                    }
                    ((ViewGroup) swanAppComponentContainerView.getParent()).removeView(swanAppComponentContainerView);
                    ((ViewGroup) scrollView.getParent()).removeView(scrollView);
                    swanAppComponentContainerView.setScrollView(null);
                } else {
                    ((ViewGroup) swanAppComponentContainerView.getParent()).removeView(swanAppComponentContainerView);
                }
                if (k82Var.b(k72Var)) {
                    return true;
                }
                o82.a("Component-Container-Scroll", "update component（scroll） overflow_y fail");
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    public static boolean e(@NonNull k82 k82Var, @NonNull l72 l72Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, k82Var, l72Var, swanAppComponentContainerView)) == null) {
            if (a) {
                Log.d("Component-Container-Scroll", "update component（scroll）position");
            }
            String str = l72Var.d;
            if (TextUtils.isEmpty(str)) {
                ScrollView scrollView = swanAppComponentContainerView.getScrollView();
                ScrollView scrollView2 = swanAppComponentContainerView;
                if (scrollView != null) {
                    scrollView2 = swanAppComponentContainerView.getScrollView();
                }
                return k82Var.a.a(scrollView2, l72Var.h);
            }
            SwanAppComponentContainerView a2 = k82Var.a(str);
            if (a2 == null) {
                v82.c("Component-Container-Scroll", "update component（scroll）to parent with a null parent container view");
                return false;
            }
            ScrollView scrollView3 = swanAppComponentContainerView.getScrollView();
            boolean z = true;
            if (scrollView3 != null && scrollView3.getParent() == a2) {
                a2.updateViewLayout(scrollView3, l72Var.b());
                return true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("update component（scroll）to parent with a illegal parent view (Scroll) ");
            if (scrollView3 != null) {
                z = false;
            }
            sb.append(z);
            o82.a("Component-Container-Scroll", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static void f(@NonNull k82 k82Var, @NonNull k72 k72Var, @NonNull l72 l72Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull n82 n82Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(65542, null, k82Var, k72Var, l72Var, swanAppComponentContainerView, n82Var) != null) || !(l72Var instanceof d82)) {
            return;
        }
        ScrollView scrollView = swanAppComponentContainerView.getScrollView();
        if (n82Var.a(8)) {
            if (a) {
                Log.d("Component-Container-Scroll", "update component（scroll） scroll_top");
            }
            if (scrollView != null) {
                scrollView.smoothScrollTo(0, ((d82) l72Var).D);
            }
        }
    }

    @Nullable
    public static ScrollView h(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull l72 l72Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, swanAppComponentContainerView, l72Var)) == null) {
            if (!(l72Var instanceof d82)) {
                return null;
            }
            ScrollView scrollView = new ScrollView(swanAppComponentContainerView.getContext());
            scrollView.setFillViewport(true);
            scrollView.setOnTouchListener(new a());
            FrameLayout frameLayout = new FrameLayout(swanAppComponentContainerView.getContext());
            frameLayout.addView(swanAppComponentContainerView, a());
            scrollView.addView(frameLayout);
            swanAppComponentContainerView.postDelayed(new b(scrollView, (d82) l72Var), 100L);
            swanAppComponentContainerView.setScrollView(scrollView);
            return scrollView;
        }
        return (ScrollView) invokeLL.objValue;
    }
}
