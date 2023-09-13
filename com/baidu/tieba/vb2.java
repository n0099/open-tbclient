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
import com.baidu.tieba.b23;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class vb2 extends qb2<ub2> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public final b23 a;
    public final c23 b;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ub2 a;
        public final /* synthetic */ vb2 b;

        public a(vb2 vb2Var, ub2 ub2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vb2Var, ub2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vb2Var;
            this.a = ub2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap p;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (p = yo3.p()) != null) {
                Message.obtain(this.b, 2, ub2.a(this.a.b, p)).sendToTarget();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948234947, "Lcom/baidu/tieba/vb2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948234947, "Lcom/baidu/tieba/vb2;");
                return;
            }
        }
        c = rr1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vb2(Looper looper) {
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
        this.a = b23.a.a("simple_parser");
        this.b = (c23) b23.a.a("hsv_parser");
    }

    public final boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return TextUtils.equals(bp3.B(), str);
        }
        return invokeL.booleanValue;
    }

    public final void f(ub2 ub2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, ub2Var) != null) || ub2Var == null) {
            return;
        }
        if (c) {
            Log.d("WhitePageHandler", ">> start to get capture.");
        }
        bp3.e0(new a(this, ub2Var));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qb2
    /* renamed from: c */
    public void a(ub2 ub2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ub2Var) != null) || ub2Var == null) {
            return;
        }
        if (!e(ub2Var.b)) {
            if (c) {
                Log.d("WhitePageHandler", ">> stop to capture, page is not top, webViewId =" + ub2Var.b);
                return;
            }
            return;
        }
        f(ub2Var);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qb2
    /* renamed from: d */
    public void b(ub2 ub2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, ub2Var) != null) || ub2Var == null) {
            return;
        }
        if (!e(ub2Var.b)) {
            if (c) {
                Log.d("WhitePageHandler", ">> stop to parse capture, page is not top, webViewId = " + ub2Var.b);
                return;
            }
            return;
        }
        Bitmap bitmap = ub2Var.d;
        pa2 f = q13.f();
        View B = uw2.T().B(ub2Var.b);
        if (bitmap != null && f != null && B != null) {
            if (c) {
                Log.d("WhitePageHandler", ">> start parsing capture");
            }
            Rect b = q13.b(bitmap, f, B);
            this.a.c(q13.d(f));
            if (!q13.h() && this.a.a(bitmap, b)) {
                if (c) {
                    Log.d("WhitePageHandler", ">> capture is full white screen.");
                }
                hc2 hc2Var = new hc2();
                hc2Var.e(SceneType.SCENE_WHITE_SCREEN_L1);
                hc2Var.d(ub2Var.b);
                return;
            }
            double d = this.b.d(bitmap, b);
            hc2 hc2Var2 = new hc2();
            if (q13.g() && d >= 0.5d) {
                if (c) {
                    Log.d("WhitePageHandler", ">> capture is part white screen ratio: " + d);
                }
                hc2Var2.e(SceneType.SCENE_WHITE_SCREEN_L3);
                hc2Var2.d(ub2Var.b);
            } else if (d >= 0.7d) {
                if (c) {
                    Log.d("WhitePageHandler", ">> capture is part white screen ratio: " + d);
                }
                hc2Var2.e(SceneType.SCENE_WHITE_SCREEN_L2);
                hc2Var2.d(ub2Var.b);
            } else {
                wb2.b().a();
            }
        } else if (c) {
            Log.d("WhitePageHandler", ">> stop to parse capture, capture or fragment or webView is null.");
        }
    }
}
