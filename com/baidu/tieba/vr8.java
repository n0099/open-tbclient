package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ur8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class vr8 extends PopupWindow implements ViewTreeObserver.OnGlobalLayoutListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public boolean c;
    public xr8 d;

    public vr8(Context context, final View anchorView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, anchorView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        this.a = context;
        View view2 = new View(this.a);
        setContentView(view2);
        setWidth(0);
        setHeight(-1);
        setBackgroundDrawable(new ColorDrawable(0));
        setSoftInputMode(16);
        setInputMethodMode(1);
        view2.getViewTreeObserver().addOnGlobalLayoutListener(this);
        anchorView.post(new Runnable() { // from class: com.baidu.tieba.pr8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    vr8.a(vr8.this, anchorView);
                }
            }
        });
    }

    public static final void a(vr8 this$0, View anchorView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, anchorView) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(anchorView, "$anchorView");
            this$0.showAtLocation(anchorView, 0, 0, 0);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = 0;
        }
    }

    public final void c(xr8 xr8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xr8Var) == null) {
            this.d = xr8Var;
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Rect rect = new Rect();
            getContentView().getWindowVisibleDisplayFrame(rect);
            int i = rect.bottom;
            if (i > this.b) {
                this.b = i;
            }
            int b = sr8.b(this.a);
            int i2 = this.b - rect.bottom;
            if (i2 > b / 4) {
                z = true;
            } else {
                z = false;
            }
            if (!this.c && z) {
                this.c = true;
                xr8 xr8Var = this.d;
                if (xr8Var != null) {
                    xr8Var.b(i2);
                }
                ur8.a aVar = ur8.l;
                ur8.m = i2;
            } else if (this.c && !z) {
                this.c = false;
                xr8 xr8Var2 = this.d;
                if (xr8Var2 != null) {
                    xr8Var2.a();
                }
            }
        }
    }
}
