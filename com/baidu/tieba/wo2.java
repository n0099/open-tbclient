package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.swan.apps.view.narootview.SwanAppInlineFullScreenContainer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class wo2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public static final ViewGroup.LayoutParams j;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public FrameLayout c;
    public int d;
    public int e;
    public String f;
    public c g;
    public d h;

    /* loaded from: classes6.dex */
    public interface c {
        void onCustomViewHidden();
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wo2 a;

        public a(wo2 wo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wo2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wo2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b != null) {
                this.a.b.requestFocus();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        public b(wo2 wo2Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wo2Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                rh3.c().e(this.a, -1.0f);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements it2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Activity a;
        public String b;

        @Override // com.baidu.tieba.it2
        public void b(bu1 bu1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bu1Var) == null) {
            }
        }

        @Override // com.baidu.tieba.it2
        public void c(bu1 bu1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bu1Var) == null) {
            }
        }

        @Override // com.baidu.tieba.it2
        public void d(bu1 bu1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bu1Var) == null) {
            }
        }

        public d(Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.it2
        public void a(bu1 bu1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, bu1Var) != null) || !TextUtils.equals(bu1Var.a(), this.b)) {
                return;
            }
            wo2.f(this.a, true);
            ((ViewGroup) this.a.getWindow().getDecorView()).setSystemUiVisibility(4098);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948277231, "Lcom/baidu/tieba/wo2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948277231, "Lcom/baidu/tieba/wo2;");
                return;
            }
        }
        i = do1.a;
        j = new FrameLayout.LayoutParams(-1, -1);
    }

    public wo2(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context;
        this.f = str;
    }

    public static void f(Activity activity, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, z) == null) {
            Window window = activity.getWindow();
            if (!z) {
                i2 = 0;
            } else {
                i2 = 1024;
            }
            window.setFlags(i2, 1024);
        }
    }

    @UiThread
    public synchronized void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            synchronized (this) {
                if (i) {
                    Log.d("SwanCustomViewHelper", "addComponentToFullScreen: " + str);
                }
                i32 b2 = g42.b(this.f, str);
                if (b2 == null) {
                    return;
                }
                if (!"coverView".equals(b2.n().a) && !"coverImage".equals(b2.n().a)) {
                    return;
                }
                if (this.c == null) {
                    return;
                }
                SwanAppComponentContainerView m = b2.m();
                if (m == null) {
                    return;
                }
                ViewParent parent = m.getParent();
                if (!(parent instanceof ViewGroup)) {
                    return;
                }
                ((ViewGroup) parent).removeView(m);
                this.c.addView(m);
            }
        }
    }

    @UiThread
    public synchronized void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            synchronized (this) {
                if (i) {
                    Log.d("SwanCustomViewHelper", "removeComponentFromFullScreen: " + str);
                }
                i32 b2 = g42.b(this.f, str);
                if (b2 == null) {
                    return;
                }
                if (!"coverView".equals(b2.n().a) && !"coverImage".equals(b2.n().a)) {
                    return;
                }
                SwanAppComponentContainerView m = b2.m();
                if (m == null) {
                    return;
                }
                ViewParent parent = m.getParent();
                if (!(parent instanceof ViewGroup)) {
                    return;
                }
                ((ViewGroup) parent).removeView(m);
                b2.insert();
            }
        }
    }

    public void d() {
        Activity activity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.b == null) {
            return;
        }
        if (i) {
            Log.i("SwanCustomViewHelper", "hideCustomView");
        }
        Context context = this.a;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            nl3.a0(new b(this, activity));
            jt2.f(this.h);
            this.h = null;
            f(activity, false);
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            viewGroup.removeView(this.c);
            this.c = null;
            this.b = null;
            c cVar = this.g;
            if (cVar != null) {
                cVar.onCustomViewHidden();
            }
            activity.setRequestedOrientation(this.d);
            viewGroup.setSystemUiVisibility(this.e);
        }
    }

    public void g(View view2, int i2, @Nullable c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, view2, i2, cVar) == null) {
            if (i) {
                Log.i("SwanCustomViewHelper", "showCustomView");
            }
            Context context = this.a;
            Activity activity = null;
            if (context instanceof Activity) {
                activity = (Activity) context;
            }
            if (activity != null) {
                if (this.b != null) {
                    if (cVar != null) {
                        cVar.onCustomViewHidden();
                        this.g = cVar;
                        return;
                    }
                    return;
                }
                this.d = activity.getRequestedOrientation();
                ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                SwanAppInlineFullScreenContainer swanAppInlineFullScreenContainer = new SwanAppInlineFullScreenContainer(activity);
                this.c = swanAppInlineFullScreenContainer;
                swanAppInlineFullScreenContainer.addView(view2, j);
                viewGroup.addView(this.c, j);
                this.b = view2;
                f(activity, true);
                activity.setRequestedOrientation(i2);
                if (ar2.M().a() && (activity instanceof SwanAppActivity)) {
                    ((SwanAppActivity) activity).z(true, false);
                }
                this.e = viewGroup.getSystemUiVisibility();
                viewGroup.setSystemUiVisibility(4098);
                if (this.h == null) {
                    this.h = new d(activity, this.f);
                }
                jt2.e(this.h);
                nl3.a0(new a(this));
            }
        }
    }
}
