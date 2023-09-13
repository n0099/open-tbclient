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
/* loaded from: classes8.dex */
public class wm3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public static um3 g;
    public static volatile wm3 h;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public ViewTreeObserver.OnGlobalLayoutListener d;
    public String e;

    /* loaded from: classes8.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ wm3 b;

        public a(wm3 wm3Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wm3Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wm3Var;
            this.a = view2;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (wm3.g != null) {
                    wm3.g.c(this.b.e);
                }
                Rect rect = new Rect();
                this.a.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.b.c != this.b.a) {
                    if (this.b.c == height) {
                        return;
                    }
                    if (this.b.c - height > this.b.b) {
                        if (wm3.g != null) {
                            wm3.g.b(this.b.e, this.b.c - height);
                            if (wm3.f) {
                                Log.d("SoftKeyboardHelper", "onKeyBoardShow: mRootViewVisibleHeight " + this.b.c + " visibleHeight " + height);
                            }
                        }
                        this.b.c = height;
                        return;
                    } else if (height - this.b.c > this.b.b) {
                        if (wm3.g != null) {
                            wm3.g.a(this.b.e, height - this.b.c);
                        }
                        if (wm3.f) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948275340, "Lcom/baidu/tieba/wm3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948275340, "Lcom/baidu/tieba/wm3;");
                return;
            }
        }
        f = rr1.a;
    }

    public wm3() {
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

    public static wm3 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (h == null) {
                synchronized (wm3.class) {
                    if (h == null) {
                        h = new wm3();
                    }
                }
            }
            return h;
        }
        return (wm3) invokeV.objValue;
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

    public void l(View view2, String str, um3 um3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, view2, str, um3Var) == null) {
            h(view2);
            this.e = str;
            g = um3Var;
            this.c = 0;
        }
    }
}
