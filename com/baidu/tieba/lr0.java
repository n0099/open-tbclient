package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.bubble.BubbleManager;
import com.baidu.nadcore.widget.bubble.BubblePosition;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public abstract class lr0 extends nr0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @JvmField
    public ViewGroup b;
    @JvmField
    public d81 c;
    @JvmField
    public boolean d;

    public abstract View A();

    /* loaded from: classes7.dex */
    public static final class a implements BubbleManager.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lr0 a;

        @Override // com.baidu.nadcore.widget.bubble.BubbleManager.b
        public void onBubbleClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.nadcore.widget.bubble.BubbleManager.b
        public void onBubbleShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(lr0 lr0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lr0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lr0Var;
        }

        @Override // com.baidu.nadcore.widget.bubble.BubbleManager.b
        public void onBubbleDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.b = null;
            }
        }
    }

    public lr0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Context context = f();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            String string = context.getResources().getString(R.string.nad_bd_video_switch_fullscreen_tip);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…eo_switch_fullscreen_tip)");
            return string;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hr0
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.o();
            this.b = null;
            d81 d81Var = this.c;
            if (d81Var != null) {
                d81Var.k();
            }
        }
    }

    public void z() {
        d81 d81Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (d81Var = this.c) != null) {
            d81Var.c();
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.d && this.b != null) {
            if (!s().Q0()) {
                t().a0(true, true);
            }
            Context context = f();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            int color = context.getResources().getColor(R.color.nad_video_bubble_bg_color);
            z71 z71Var = (z71) BubbleManager.u(z71.class);
            z71Var.j(A(), this.b);
            z71Var.q(B());
            z71Var.r(-1, -1);
            z71Var.l(color, color);
            z71Var.m(1, 12.0f);
            z71Var.p(-2.0f);
            z71Var.n(BubblePosition.DOWN);
            z71Var.k(5000);
            z71Var.i(true);
            z71Var.o(new a(this));
            d81 h = z71Var.h();
            this.c = h;
            if (h != null) {
                h.q();
            }
            this.d = false;
            t().X(5000);
        }
    }

    @Override // com.baidu.tieba.hr0
    public void l(ms0 event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (Intrinsics.areEqual(event.c(), PlayerEvent.ACTION_ON_INFO)) {
                int g = event.g(1);
                if ((g == 904 || g == 956) && A() != null) {
                    C();
                }
            }
        }
    }
}
