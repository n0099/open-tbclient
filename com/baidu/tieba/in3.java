package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.view.SwanAppNARootViewScrollView;
import com.baidu.swan.apps.view.narootview.SwanAppInlineFullScreenContainer;
import com.baidu.tieba.bu1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class in3<T extends bu1> implements h92, ym3, PullToRefreshBaseWebView.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout a;
    public FrameLayout b;
    public T c;
    public PullToRefreshBaseWebView d;
    public Context e;
    public au1 f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947859227, "Lcom/baidu/tieba/in3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947859227, "Lcom/baidu/tieba/in3;");
                return;
            }
        }
        g = eo1.a;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f.U(this);
        }
    }

    public in3(Context context, @NonNull au1<T> au1Var, @NonNull FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, au1Var, frameLayout};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = context;
        this.a = frameLayout;
        this.f = au1Var;
        e(au1Var);
    }

    @Override // com.baidu.tieba.ym3
    public boolean a(View view2, ay2 ay2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, ay2Var)) == null) {
            if (view2 == null || this.b == null || ay2Var == null) {
                return false;
            }
            if (g) {
                Log.d("NAParentViewManager", "updateView pos: " + ay2Var);
            }
            if (d(view2, this.b)) {
                Object tag = view2.getTag(R.id.obfuscated_res_0x7f0901a5);
                if (tag instanceof jn3) {
                    jn3 jn3Var = (jn3) tag;
                    kn3.a(jn3Var, ay2Var);
                    view2.setTag(R.id.obfuscated_res_0x7f0901a5, jn3Var);
                }
                this.b.updateViewLayout(view2, kn3.b(this.c, ay2Var));
            } else if (!g(view2)) {
                return false;
            } else {
                Object tag2 = view2.getTag(R.id.obfuscated_res_0x7f0901a5);
                if (tag2 instanceof jn3) {
                    jn3 jn3Var2 = (jn3) tag2;
                    kn3.a(jn3Var2, ay2Var);
                    view2.setTag(R.id.obfuscated_res_0x7f0901a5, jn3Var2);
                }
                ((ViewGroup) view2.getParent()).updateViewLayout(view2, kn3.b(this.c, ay2Var));
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.swan.apps.core.container.PullToRefreshBaseWebView.a
    public void b(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3, i4) == null) {
            this.b.scrollTo(i, i2);
        }
    }

    @Override // com.baidu.tieba.ym3
    public boolean c(View view2, ay2 ay2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, ay2Var)) == null) {
            if (this.e != null && ay2Var != null) {
                jn3 jn3Var = new jn3();
                kn3.a(jn3Var, ay2Var);
                view2.setTag(R.id.obfuscated_res_0x7f0901a5, jn3Var);
                if (this.b.indexOfChild(view2) >= 0) {
                    n42.a("NAParentViewManager", "repeat insert view!");
                    this.b.removeView(view2);
                }
                this.b.addView(view2, kn3.b(this.c, ay2Var));
                return true;
            } else if (g) {
                Log.d("NAParentViewManager", "insertView failed");
                return false;
            } else {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final boolean d(View view2, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, viewGroup)) == null) {
            if (view2 == null || viewGroup == null || view2.getParent() != viewGroup || viewGroup.indexOfChild(view2) < 0) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final boolean e(au1<T> au1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, au1Var)) == null) {
            if (g) {
                Log.d("NAParentViewManager", "createViewAndListener");
            }
            au1Var.t(this);
            T r = au1Var.r();
            this.c = r;
            if (r == null) {
                return false;
            }
            SwanAppNARootViewScrollView swanAppNARootViewScrollView = new SwanAppNARootViewScrollView(this.e);
            this.a.addView(swanAppNARootViewScrollView, new FrameLayout.LayoutParams(-1, -1));
            this.b = new FrameLayout(this.e);
            swanAppNARootViewScrollView.addView(this.b, new FrameLayout.LayoutParams(-1, -1));
            swanAppNARootViewScrollView.setFillViewport(true);
            PullToRefreshBaseWebView h0 = au1Var.h0();
            this.d = h0;
            if (h0 != null) {
                h0.setOnPullToRefreshScrollChangeListener(this);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean g(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) {
            if (view2 == null) {
                return false;
            }
            return view2.getParent() instanceof SwanAppInlineFullScreenContainer;
        }
        return invokeL.booleanValue;
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.b.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.h92
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3, i4) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.b.getLayoutParams();
            marginLayoutParams.leftMargin = -i;
            marginLayoutParams.topMargin = -i2;
            this.b.setLayoutParams(marginLayoutParams);
            for (int i5 = 0; i5 < this.b.getChildCount(); i5++) {
                View childAt = this.b.getChildAt(i5);
                if (childAt != null) {
                    Object tag = childAt.getTag(R.id.obfuscated_res_0x7f0901a5);
                    jn3 jn3Var = null;
                    if (tag instanceof jn3) {
                        jn3Var = (jn3) tag;
                    }
                    if (jn3Var != null && jn3Var.d()) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                        marginLayoutParams2.leftMargin = jn3Var.b() + i;
                        marginLayoutParams2.topMargin = jn3Var.c() + i2;
                        childAt.setLayoutParams(marginLayoutParams2);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ym3
    public boolean removeView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, view2)) == null) {
            if (d(view2, this.b)) {
                try {
                    this.b.removeView(view2);
                } catch (Exception e) {
                    if (g) {
                        e.printStackTrace();
                    }
                }
                return true;
            } else if (g(view2)) {
                try {
                    ((ViewGroup) view2.getParent()).removeView(view2);
                } catch (Exception e2) {
                    if (g) {
                        e2.printStackTrace();
                    }
                }
                return true;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
