package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.md8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class nd8 extends PopupWindow implements ViewTreeObserver.OnGlobalLayoutListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public boolean c;
    public pd8 d;

    public nd8(Context context, final View anchorView) {
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
        anchorView.post(new Runnable() { // from class: com.baidu.tieba.hd8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    nd8.a(nd8.this, anchorView);
                }
            }
        });
    }

    public static final void a(nd8 this$0, View anchorView) {
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

    public final Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (Context) invokeV.objValue;
    }

    public final void c(pd8 pd8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pd8Var) == null) {
            this.d = pd8Var;
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Rect rect = new Rect();
            getContentView().getWindowVisibleDisplayFrame(rect);
            int i = rect.bottom;
            if (i > this.b) {
                this.b = i;
            }
            int b = kd8.b(this.a);
            int i2 = this.b - rect.bottom;
            if (i2 > b / 4) {
                z = true;
            } else {
                z = false;
            }
            if (!this.c && z) {
                this.c = true;
                pd8 pd8Var = this.d;
                if (pd8Var != null) {
                    pd8Var.a(i2);
                }
                md8.a aVar = md8.l;
                md8.m = i2;
            } else if (this.c && !z) {
                this.c = false;
                pd8 pd8Var2 = this.d;
                if (pd8Var2 != null) {
                    pd8Var2.b();
                }
            }
        }
    }
}
