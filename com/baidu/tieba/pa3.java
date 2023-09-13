package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.ext.widget.LoadingViewHelper;
import com.baidu.swan.apps.res.ui.BdShimmerView;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import com.baidu.tieba.oa3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.WeakHashMap;
/* loaded from: classes7.dex */
public final class pa3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final WeakHashMap<ViewGroup, qa3> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oa3 a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;

        public a(oa3 oa3Var, Context context, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oa3Var, context, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oa3Var;
            this.b = context;
            this.c = str;
            this.d = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            LoadingView loadingView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                View d = this.a.d();
                if (d instanceof LoadingView) {
                    loadingView = (LoadingView) d;
                } else {
                    loadingView = new LoadingView(this.b);
                    FrameLayout frameLayout = new FrameLayout(this.b);
                    frameLayout.setPadding(0, 0, 0, yo3.g(160.0f));
                    frameLayout.addView(loadingView);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    this.a.o(frameLayout, layoutParams);
                }
                if (!TextUtils.isEmpty(this.c)) {
                    loadingView.setMsg(this.c);
                }
                this.a.k(this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ na2 a;

        public b(na2 na2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {na2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = na2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            oa3 floatLayer;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (floatLayer = ((oa3.a) this.a).getFloatLayer()) != null && (floatLayer.d() instanceof FrameLayout) && (((FrameLayout) floatLayer.d()).getChildAt(0) instanceof LoadingView)) {
                floatLayer.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948055271, "Lcom/baidu/tieba/pa3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948055271, "Lcom/baidu/tieba/pa3;");
                return;
            }
        }
        a = rr1.a & true;
        b = new WeakHashMap<>();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            for (ViewGroup viewGroup : b.keySet()) {
                qa3 qa3Var = b.get(viewGroup);
                if (qa3Var != null && qa3Var.getLoadingView() != null) {
                    viewGroup.removeView(qa3Var.getLoadingView());
                }
            }
            b.clear();
        }
    }

    public static boolean b(ViewGroup viewGroup) {
        InterceptResult invokeL;
        qa3 qa3Var;
        View loadingView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, viewGroup)) == null) {
            if (viewGroup == null) {
                return false;
            }
            qa3 qa3Var2 = b.get(viewGroup);
            if (qa3Var2 != null && qa3Var2.getLoadingView() != null) {
                qa3Var2.getLoadingView().setVisibility(8);
                return true;
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if ((viewGroup.getChildAt(i) instanceof qa3) && (loadingView = (qa3Var = (qa3) viewGroup.getChildAt(i)).getLoadingView()) != null) {
                    loadingView.setVisibility(8);
                    b.put(viewGroup, qa3Var);
                    if (a) {
                        Log.d(LoadingViewHelper.TAG, "The count of cached loading views is : " + b.size());
                        Log.d(LoadingViewHelper.TAG, "The content of cached views is : " + b.toString());
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean e(ViewGroup viewGroup) {
        InterceptResult invokeL;
        qa3 qa3Var;
        View loadingView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, viewGroup)) == null) {
            if (viewGroup == null) {
                return false;
            }
            qa3 qa3Var2 = b.get(viewGroup);
            if (qa3Var2 != null && qa3Var2.getLoadingView() != null) {
                qa3Var2.getLoadingView().setVisibility(0);
                return true;
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if ((viewGroup.getChildAt(i) instanceof qa3) && (loadingView = (qa3Var = (qa3) viewGroup.getChildAt(i)).getLoadingView()) != null) {
                    loadingView.setVisibility(0);
                    b.put(viewGroup, qa3Var);
                    if (a) {
                        Log.d(LoadingViewHelper.TAG, "The count of cached loading views is : " + b.size());
                        Log.d(LoadingViewHelper.TAG, "The content of cached views is : " + b.toString());
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void c(@NonNull na2 na2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, na2Var) != null) || !(na2Var instanceof oa3.a)) {
            return;
        }
        bp3.e0(new b(na2Var));
    }

    public static boolean d(ViewGroup viewGroup) {
        InterceptResult invokeL;
        qa3 qa3Var;
        View loadingView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, viewGroup)) == null) {
            if (viewGroup == null) {
                return false;
            }
            qa3 qa3Var2 = b.get(viewGroup);
            if (qa3Var2 != null) {
                View loadingView2 = qa3Var2.getLoadingView();
                if (loadingView2 != null) {
                    if (loadingView2 instanceof BdShimmerView) {
                        ((BdShimmerView) loadingView2).p();
                    }
                    loadingView2.setVisibility(8);
                    viewGroup.removeView(loadingView2);
                    b.remove(viewGroup);
                    if (a) {
                        Log.d(LoadingViewHelper.TAG, "The count of cached loading views is : " + b.size());
                        Log.d(LoadingViewHelper.TAG, "The content of cached views is : " + b.toString());
                    }
                }
                return true;
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if ((viewGroup.getChildAt(i) instanceof qa3) && (loadingView = (qa3Var = (qa3) viewGroup.getChildAt(i)).getLoadingView()) != null) {
                    loadingView.setVisibility(8);
                    viewGroup.removeView((View) qa3Var);
                    b.remove(viewGroup);
                    if (a) {
                        Log.d(LoadingViewHelper.TAG, "The count of cached loading views is : " + b.size());
                        Log.d(LoadingViewHelper.TAG, "The content of cached views is : " + b.toString());
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void f(@NonNull oa3 oa3Var, @NonNull Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{oa3Var, context, str, Boolean.valueOf(z)}) == null) {
            bp3.e0(new a(oa3Var, context, str, z));
        }
    }

    public static boolean g(Context context, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, viewGroup)) == null) {
            return h(context, viewGroup, "");
        }
        return invokeLL.booleanValue;
    }

    public static boolean h(Context context, ViewGroup viewGroup, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, context, viewGroup, str)) == null) {
            if (context != null && viewGroup != null) {
                if (e(viewGroup)) {
                    return true;
                }
                LoadingView loadingView = new LoadingView(context);
                LoadingView loadingView2 = loadingView.getLoadingView();
                if (loadingView2 == null) {
                    return false;
                }
                if (!TextUtils.isEmpty(str)) {
                    loadingView2.setMsg(str);
                }
                ViewGroup viewGroup2 = (ViewGroup) loadingView2.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(loadingView2);
                }
                if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    viewGroup.addView(loadingView2, layoutParams);
                } else if (viewGroup instanceof LinearLayout) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 17;
                    viewGroup.addView(loadingView2, layoutParams2);
                } else if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams3.gravity = 17;
                    viewGroup.addView(loadingView2, layoutParams3);
                }
                b.put(viewGroup, loadingView);
                loadingView2.setVisibility(0);
                if (a) {
                    Log.d(LoadingViewHelper.TAG, "The count of cached loading views is : " + b.size());
                    Log.d(LoadingViewHelper.TAG, "The content of cached views is : " + b.toString());
                }
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
