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
/* loaded from: classes8.dex */
public class v72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollView a;
        public final /* synthetic */ p72 b;

        public b(ScrollView scrollView, p72 p72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollView, p72Var};
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
            this.b = p72Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948193624, "Lcom/baidu/tieba/v72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948193624, "Lcom/baidu/tieba/v72;");
                return;
            }
        }
        a = rr1.a;
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

    public static boolean b(@NonNull w72 w72Var, @NonNull x62 x62Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, w72Var, x62Var, swanAppComponentContainerView)) == null) {
            h82.c("Component-Container-Scroll", "insert component（scroll）");
            if (x62Var.h == null) {
                a82.a("Component-Container-Scroll", "insert component（scroll） with a null position");
                return false;
            } else if (TextUtils.isEmpty(x62Var.d)) {
                ScrollView h = h(swanAppComponentContainerView, x62Var);
                if (h == null || !w72Var.a.c(h, x62Var.h)) {
                    return false;
                }
                return true;
            } else {
                SwanAppComponentContainerView a2 = w72Var.a(x62Var.d);
                if (a2 == null) {
                    h82.c("Component-Container-Scroll", "insert component（scroll） to parent with a null parent container view");
                    return false;
                }
                ScrollView h2 = h(swanAppComponentContainerView, x62Var);
                if (h2 == null) {
                    h82.c("Component-Container-Scroll", "insert component（scroll） to parent with a null scroll view");
                    return false;
                }
                a2.addView(h2, x62Var.b());
                return true;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static boolean g(@NonNull w72 w72Var, @NonNull x62 x62Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, w72Var, x62Var, swanAppComponentContainerView)) == null) {
            if (TextUtils.isEmpty(x62Var.d)) {
                return w72Var.a.removeView(swanAppComponentContainerView.getScrollView());
            }
            SwanAppComponentContainerView a2 = w72Var.a(x62Var.d);
            if (a2 == null) {
                h82.c("Component-Container-Scroll", "remove component（scroll） to parent with a null parent container view");
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
            a82.a("Component-Container-Scroll", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean c(@NonNull x62 x62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, x62Var)) == null) {
            if ((x62Var instanceof p72) && TextUtils.equals(((p72) x62Var).E, "scroll")) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean d(@NonNull w72 w72Var, @NonNull w62 w62Var, @NonNull x62 x62Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull z72 z72Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, w72Var, w62Var, x62Var, swanAppComponentContainerView, z72Var)) == null) {
            if (!(x62Var instanceof p72)) {
                return false;
            }
            ScrollView scrollView = swanAppComponentContainerView.getScrollView();
            if (z72Var.a(7)) {
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
                if (w72Var.b(w62Var)) {
                    return true;
                }
                a82.a("Component-Container-Scroll", "update component（scroll） overflow_y fail");
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    public static boolean e(@NonNull w72 w72Var, @NonNull x62 x62Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, w72Var, x62Var, swanAppComponentContainerView)) == null) {
            if (a) {
                Log.d("Component-Container-Scroll", "update component（scroll）position");
            }
            String str = x62Var.d;
            if (TextUtils.isEmpty(str)) {
                ScrollView scrollView = swanAppComponentContainerView.getScrollView();
                ScrollView scrollView2 = swanAppComponentContainerView;
                if (scrollView != null) {
                    scrollView2 = swanAppComponentContainerView.getScrollView();
                }
                return w72Var.a.a(scrollView2, x62Var.h);
            }
            SwanAppComponentContainerView a2 = w72Var.a(str);
            if (a2 == null) {
                h82.c("Component-Container-Scroll", "update component（scroll）to parent with a null parent container view");
                return false;
            }
            ScrollView scrollView3 = swanAppComponentContainerView.getScrollView();
            boolean z = true;
            if (scrollView3 != null && scrollView3.getParent() == a2) {
                a2.updateViewLayout(scrollView3, x62Var.b());
                return true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("update component（scroll）to parent with a illegal parent view (Scroll) ");
            if (scrollView3 != null) {
                z = false;
            }
            sb.append(z);
            a82.a("Component-Container-Scroll", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static void f(@NonNull w72 w72Var, @NonNull w62 w62Var, @NonNull x62 x62Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull z72 z72Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(65542, null, w72Var, w62Var, x62Var, swanAppComponentContainerView, z72Var) != null) || !(x62Var instanceof p72)) {
            return;
        }
        ScrollView scrollView = swanAppComponentContainerView.getScrollView();
        if (z72Var.a(8)) {
            if (a) {
                Log.d("Component-Container-Scroll", "update component（scroll） scroll_top");
            }
            if (scrollView != null) {
                scrollView.smoothScrollTo(0, ((p72) x62Var).D);
            }
        }
    }

    @Nullable
    public static ScrollView h(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull x62 x62Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, swanAppComponentContainerView, x62Var)) == null) {
            if (!(x62Var instanceof p72)) {
                return null;
            }
            ScrollView scrollView = new ScrollView(swanAppComponentContainerView.getContext());
            scrollView.setFillViewport(true);
            scrollView.setOnTouchListener(new a());
            FrameLayout frameLayout = new FrameLayout(swanAppComponentContainerView.getContext());
            frameLayout.addView(swanAppComponentContainerView, a());
            scrollView.addView(frameLayout);
            swanAppComponentContainerView.postDelayed(new b(scrollView, (p72) x62Var), 100L);
            swanAppComponentContainerView.setScrollView(scrollView);
            return scrollView;
        }
        return (ScrollView) invokeLL.objValue;
    }
}
