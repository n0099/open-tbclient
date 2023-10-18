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
/* loaded from: classes8.dex */
public abstract class rq0 extends tq0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @JvmField
    public ViewGroup b;
    @JvmField
    public j71 c;
    @JvmField
    public boolean d;

    public abstract View z();

    /* loaded from: classes8.dex */
    public static final class a implements BubbleManager.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rq0 a;

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
        public a(rq0 rq0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rq0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rq0Var;
        }

        @Override // com.baidu.nadcore.widget.bubble.BubbleManager.b
        public void onBubbleDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.b = null;
            }
        }
    }

    public rq0() {
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

    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Context context = f();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            String string = context.getResources().getString(R.string.nad_bd_video_switch_fullscreen_tip);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…eo_switch_fullscreen_tip)");
            return string;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nq0
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.n();
            this.b = null;
            j71 j71Var = this.c;
            if (j71Var != null) {
                j71Var.k();
            }
        }
    }

    public void y() {
        j71 j71Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (j71Var = this.c) != null) {
            j71Var.c();
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.d && this.b != null) {
            if (!r().Q0()) {
                s().a0(true, true);
            }
            Context context = f();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            int color = context.getResources().getColor(R.color.nad_video_bubble_bg_color);
            f71 f71Var = (f71) BubbleManager.t(f71.class);
            f71Var.j(z(), this.b);
            f71Var.q(A());
            f71Var.r(-1, -1);
            f71Var.l(color, color);
            f71Var.m(1, 12.0f);
            f71Var.p(-2.0f);
            f71Var.n(BubblePosition.DOWN);
            f71Var.k(5000);
            f71Var.i(true);
            f71Var.o(new a(this));
            j71 h = f71Var.h();
            this.c = h;
            if (h != null) {
                h.p();
            }
            this.d = false;
            s().W(5000);
        }
    }

    @Override // com.baidu.tieba.nq0
    public void l(sr0 event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (Intrinsics.areEqual(event.c(), PlayerEvent.ACTION_ON_INFO)) {
                int g = event.g(1);
                if ((g == 904 || g == 956) && z() != null) {
                    B();
                }
            }
        }
    }
}
