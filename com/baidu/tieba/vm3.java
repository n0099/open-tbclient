package com.baidu.tieba;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class vm3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public View c;
    public int d;
    public um3 e;

    /* loaded from: classes8.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ vm3 b;

        public a(vm3 vm3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vm3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vm3Var;
            this.a = str;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.b.e != null) {
                    this.b.e.c(this.a);
                }
                Rect rect = new Rect();
                this.b.c.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.b.d != this.b.a) {
                    if (this.b.d == height) {
                        return;
                    }
                    if (this.b.d - height > this.b.b) {
                        if (this.b.e != null) {
                            this.b.e.b(this.a, this.b.d - height);
                        }
                        this.b.d = height;
                        return;
                    } else if (height - this.b.d > this.b.b) {
                        if (this.b.e != null) {
                            this.b.e.a(this.a, height - this.b.d);
                        }
                        this.b.d = height;
                        return;
                    } else {
                        return;
                    }
                }
                this.b.d = height;
            }
        }
    }

    public vm3(String str, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = 200;
        View decorView = activity.getWindow().getDecorView();
        this.c = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, str));
    }

    public final void h(um3 um3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, um3Var) == null) {
            this.e = um3Var;
        }
    }

    public static void g(String str, Activity activity, um3 um3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, activity, um3Var) == null) {
            new vm3(str, activity).h(um3Var);
        }
    }
}
