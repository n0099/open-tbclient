package com.baidu.tieba;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class lk3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public static jk3 g;
    public static volatile lk3 h;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public ViewTreeObserver.OnGlobalLayoutListener d;
    public String e;

    /* loaded from: classes5.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ lk3 b;

        public a(lk3 lk3Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lk3Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lk3Var;
            this.a = view2;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (lk3.g != null) {
                    lk3.g.c(this.b.e);
                }
                Rect rect = new Rect();
                this.a.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.b.c != this.b.a) {
                    if (this.b.c == height) {
                        return;
                    }
                    if (this.b.c - height > this.b.b) {
                        if (lk3.g != null) {
                            lk3.g.b(this.b.e, this.b.c - height);
                            if (lk3.f) {
                                Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + this.b.c + " visibleHeight " + height);
                            }
                        }
                        this.b.c = height;
                        return;
                    } else if (height - this.b.c > this.b.b) {
                        if (lk3.g != null) {
                            lk3.g.a(this.b.e, height - this.b.c);
                        }
                        if (lk3.f) {
                            Log.d("SoftKeyboardHelper", "onKeyBoardHide: mRootViewVisibleHeight " + this.b.c + " visibleHeight " + height);
                        }
                        this.b.c = height;
                        return;
                    } else {
                        return;
                    }
                }
                this.b.c = height;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947945717, "Lcom/baidu/tieba/lk3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947945717, "Lcom/baidu/tieba/lk3;");
                return;
            }
        }
        f = gp1.a;
    }

    public lk3() {
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
        this.a = 0;
        this.b = 200;
    }

    public static lk3 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (h == null) {
                synchronized (lk3.class) {
                    if (h == null) {
                        h = new lk3();
                    }
                }
            }
            return h;
        }
        return (lk3) invokeV.objValue;
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            g = null;
            h = null;
        }
    }

    public final void h(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            if (this.d == null) {
                this.d = new a(this, view2);
            }
            view2.getViewTreeObserver().addOnGlobalLayoutListener(this.d);
        }
    }

    public void k(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            view2.getViewTreeObserver().removeOnGlobalLayoutListener(this.d);
            this.e = "";
            g = null;
            this.c = 0;
        }
    }

    public void l(View view2, String str, jk3 jk3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, view2, str, jk3Var) == null) {
            h(view2);
            this.e = str;
            g = jk3Var;
            this.c = 0;
        }
    }
}
