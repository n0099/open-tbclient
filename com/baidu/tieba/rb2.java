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
import com.baidu.tieba.x13;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class rb2 extends mb2<qb2> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public final x13 a;
    public final y13 b;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qb2 a;
        public final /* synthetic */ rb2 b;

        public a(rb2 rb2Var, qb2 qb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rb2Var, qb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rb2Var;
            this.a = qb2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap p;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (p = uo3.p()) != null) {
                Message.obtain(this.b, 2, qb2.a(this.a.b, p)).sendToTarget();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948115783, "Lcom/baidu/tieba/rb2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948115783, "Lcom/baidu/tieba/rb2;");
                return;
            }
        }
        c = nr1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rb2(Looper looper) {
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
        this.a = x13.a.a("simple_parser");
        this.b = (y13) x13.a.a("hsv_parser");
    }

    public final boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return TextUtils.equals(xo3.B(), str);
        }
        return invokeL.booleanValue;
    }

    public final void f(qb2 qb2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, qb2Var) != null) || qb2Var == null) {
            return;
        }
        if (c) {
            Log.d("WhitePageHandler", ">> start to get capture.");
        }
        xo3.e0(new a(this, qb2Var));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mb2
    /* renamed from: c */
    public void a(qb2 qb2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qb2Var) != null) || qb2Var == null) {
            return;
        }
        if (!e(qb2Var.b)) {
            if (c) {
                Log.d("WhitePageHandler", ">> stop to capture, page is not top, webViewId =" + qb2Var.b);
                return;
            }
            return;
        }
        f(qb2Var);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mb2
    /* renamed from: d */
    public void b(qb2 qb2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, qb2Var) != null) || qb2Var == null) {
            return;
        }
        if (!e(qb2Var.b)) {
            if (c) {
                Log.d("WhitePageHandler", ">> stop to parse capture, page is not top, webViewId = " + qb2Var.b);
                return;
            }
            return;
        }
        Bitmap bitmap = qb2Var.d;
        la2 f = m13.f();
        View B = qw2.T().B(qb2Var.b);
        if (bitmap != null && f != null && B != null) {
            if (c) {
                Log.d("WhitePageHandler", ">> start parsing capture");
            }
            Rect b = m13.b(bitmap, f, B);
            this.a.c(m13.d(f));
            if (!m13.h() && this.a.a(bitmap, b)) {
                if (c) {
                    Log.d("WhitePageHandler", ">> capture is full white screen.");
                }
                dc2 dc2Var = new dc2();
                dc2Var.e(SceneType.SCENE_WHITE_SCREEN_L1);
                dc2Var.d(qb2Var.b);
                return;
            }
            double d = this.b.d(bitmap, b);
            dc2 dc2Var2 = new dc2();
            if (m13.g() && d >= 0.5d) {
                if (c) {
                    Log.d("WhitePageHandler", ">> capture is part white screen ratio: " + d);
                }
                dc2Var2.e(SceneType.SCENE_WHITE_SCREEN_L3);
                dc2Var2.d(qb2Var.b);
            } else if (d >= 0.7d) {
                if (c) {
                    Log.d("WhitePageHandler", ">> capture is part white screen ratio: " + d);
                }
                dc2Var2.e(SceneType.SCENE_WHITE_SCREEN_L2);
                dc2Var2.d(qb2Var.b);
            } else {
                sb2.b().a();
            }
        } else if (c) {
            Log.d("WhitePageHandler", ">> stop to parse capture, capture or fragment or webView is null.");
        }
    }
}
