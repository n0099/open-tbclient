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
import com.baidu.tieba.p23;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class jc2 extends ec2<ic2> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public final p23 a;
    public final q23 b;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ic2 a;
        public final /* synthetic */ jc2 b;

        public a(jc2 jc2Var, ic2 ic2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jc2Var, ic2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jc2Var;
            this.a = ic2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap p;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (p = mp3.p()) != null) {
                Message.obtain(this.b, 2, ic2.a(this.a.b, p)).sendToTarget();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947878416, "Lcom/baidu/tieba/jc2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947878416, "Lcom/baidu/tieba/jc2;");
                return;
            }
        }
        c = fs1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jc2(Looper looper) {
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
        this.a = p23.a.a("simple_parser");
        this.b = (q23) p23.a.a("hsv_parser");
    }

    public final boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return TextUtils.equals(pp3.B(), str);
        }
        return invokeL.booleanValue;
    }

    public final void f(ic2 ic2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, ic2Var) != null) || ic2Var == null) {
            return;
        }
        if (c) {
            Log.d("WhitePageHandler", ">> start to get capture.");
        }
        pp3.e0(new a(this, ic2Var));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ec2
    /* renamed from: c */
    public void a(ic2 ic2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ic2Var) != null) || ic2Var == null) {
            return;
        }
        if (!e(ic2Var.b)) {
            if (c) {
                Log.d("WhitePageHandler", ">> stop to capture, page is not top, webViewId =" + ic2Var.b);
                return;
            }
            return;
        }
        f(ic2Var);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ec2
    /* renamed from: d */
    public void b(ic2 ic2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, ic2Var) != null) || ic2Var == null) {
            return;
        }
        if (!e(ic2Var.b)) {
            if (c) {
                Log.d("WhitePageHandler", ">> stop to parse capture, page is not top, webViewId = " + ic2Var.b);
                return;
            }
            return;
        }
        Bitmap bitmap = ic2Var.d;
        db2 f = e23.f();
        View B = ix2.T().B(ic2Var.b);
        if (bitmap != null && f != null && B != null) {
            if (c) {
                Log.d("WhitePageHandler", ">> start parsing capture");
            }
            Rect b = e23.b(bitmap, f, B);
            this.a.c(e23.d(f));
            if (!e23.h() && this.a.a(bitmap, b)) {
                if (c) {
                    Log.d("WhitePageHandler", ">> capture is full white screen.");
                }
                vc2 vc2Var = new vc2();
                vc2Var.e(SceneType.SCENE_WHITE_SCREEN_L1);
                vc2Var.d(ic2Var.b);
                return;
            }
            double d = this.b.d(bitmap, b);
            vc2 vc2Var2 = new vc2();
            if (e23.g() && d >= 0.5d) {
                if (c) {
                    Log.d("WhitePageHandler", ">> capture is part white screen ratio: " + d);
                }
                vc2Var2.e(SceneType.SCENE_WHITE_SCREEN_L3);
                vc2Var2.d(ic2Var.b);
            } else if (d >= 0.7d) {
                if (c) {
                    Log.d("WhitePageHandler", ">> capture is part white screen ratio: " + d);
                }
                vc2Var2.e(SceneType.SCENE_WHITE_SCREEN_L2);
                vc2Var2.d(ic2Var.b);
            } else {
                kc2.b().a();
            }
        } else if (c) {
            Log.d("WhitePageHandler", ">> stop to parse capture, capture or fragment or webView is null.");
        }
    }
}
