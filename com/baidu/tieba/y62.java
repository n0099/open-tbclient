package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.launchtips.scene.SceneType;
import com.baidu.tieba.ex2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class y62 extends t62<x62> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public final ex2 a;
    public final fx2 b;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x62 a;
        public final /* synthetic */ y62 b;

        public a(y62 y62Var, x62 x62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y62Var, x62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y62Var;
            this.a = x62Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap p;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (p = bk3.p()) != null) {
                Message.obtain(this.b, 2, x62.a(this.a.b, p)).sendToTarget();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948282036, "Lcom/baidu/tieba/y62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948282036, "Lcom/baidu/tieba/y62;");
                return;
            }
        }
        c = vm1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y62(Looper looper) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {looper};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = ex2.a.a("simple_parser");
        this.b = (fx2) ex2.a.a("hsv_parser");
    }

    public final boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return TextUtils.equals(ek3.B(), str);
        }
        return invokeL.booleanValue;
    }

    public final void f(x62 x62Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, x62Var) != null) || x62Var == null) {
            return;
        }
        if (c) {
            Log.d("WhitePageHandler", ">> start to get capture.");
        }
        ek3.e0(new a(this, x62Var));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.t62
    /* renamed from: c */
    public void a(x62 x62Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, x62Var) != null) || x62Var == null) {
            return;
        }
        if (!e(x62Var.b)) {
            if (c) {
                Log.d("WhitePageHandler", ">> stop to capture, page is not top, webViewId =" + x62Var.b);
                return;
            }
            return;
        }
        f(x62Var);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.t62
    /* renamed from: d */
    public void b(x62 x62Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, x62Var) != null) || x62Var == null) {
            return;
        }
        if (!e(x62Var.b)) {
            if (c) {
                Log.d("WhitePageHandler", ">> stop to parse capture, page is not top, webViewId = " + x62Var.b);
                return;
            }
            return;
        }
        Bitmap bitmap = x62Var.d;
        s52 f = tw2.f();
        View C = xr2.V().C(x62Var.b);
        if (bitmap != null && f != null && C != null) {
            if (c) {
                Log.d("WhitePageHandler", ">> start parsing capture");
            }
            Rect b = tw2.b(bitmap, f, C);
            this.a.c(tw2.d(f));
            if (!tw2.h() && this.a.a(bitmap, b)) {
                if (c) {
                    Log.d("WhitePageHandler", ">> capture is full white screen.");
                }
                k72 k72Var = new k72();
                k72Var.e(SceneType.SCENE_WHITE_SCREEN_L1);
                k72Var.d(x62Var.b);
                return;
            }
            double d = this.b.d(bitmap, b);
            k72 k72Var2 = new k72();
            if (tw2.g() && d >= 0.5d) {
                if (c) {
                    Log.d("WhitePageHandler", ">> capture is part white screen ratio: " + d);
                }
                k72Var2.e(SceneType.SCENE_WHITE_SCREEN_L3);
                k72Var2.d(x62Var.b);
            } else if (d >= 0.7d) {
                if (c) {
                    Log.d("WhitePageHandler", ">> capture is part white screen ratio: " + d);
                }
                k72Var2.e(SceneType.SCENE_WHITE_SCREEN_L2);
                k72Var2.d(x62Var.b);
            } else {
                z62.b().a();
            }
        } else if (c) {
            Log.d("WhitePageHandler", ">> stop to parse capture, capture or fragment or webView is null.");
        }
    }
}
