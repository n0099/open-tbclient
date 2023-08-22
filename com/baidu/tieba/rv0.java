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
public abstract class rv0 extends tv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @JvmField
    public ViewGroup b;
    @JvmField
    public tc1 c;
    @JvmField
    public boolean d;

    public View y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (View) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public static final class a implements BubbleManager.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rv0 a;

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
        public a(rv0 rv0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rv0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rv0Var;
        }

        @Override // com.baidu.nadcore.widget.bubble.BubbleManager.b
        public void onBubbleDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.b = null;
            }
        }
    }

    public rv0() {
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

    @Override // com.baidu.tieba.nv0
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.m();
            this.b = null;
            tc1 tc1Var = this.c;
            if (tc1Var != null) {
                tc1Var.k();
            }
        }
    }

    public void x() {
        tc1 tc1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (tc1Var = this.c) != null) {
            tc1Var.c();
        }
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            String string = context.getResources().getString(R.string.nad_bd_video_switch_fullscreen_tip);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…eo_switch_fullscreen_tip)");
            return string;
        }
        return (String) invokeV.objValue;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.d && this.b != null) {
            if (!q().V0()) {
                r().Z(true, true);
            }
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            int color = context.getResources().getColor(R.color.nad_video_bubble_bg_color);
            pc1 pc1Var = (pc1) BubbleManager.t(pc1.class);
            pc1Var.j(y(), this.b);
            pc1Var.q(z());
            pc1Var.r(-1, -1);
            pc1Var.l(color, color);
            pc1Var.m(1, 12.0f);
            pc1Var.p(-2.0f);
            pc1Var.n(BubblePosition.DOWN);
            pc1Var.k(5000);
            pc1Var.i(true);
            pc1Var.o(new a(this));
            tc1 h = pc1Var.h();
            this.c = h;
            if (h != null) {
                h.p();
            }
            this.d = false;
            r().W(5000);
        }
    }

    @Override // com.baidu.tieba.nv0
    public void k(sw0 event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (Intrinsics.areEqual(event.c(), PlayerEvent.ACTION_ON_INFO)) {
                int g = event.g(1);
                if ((g == 904 || g == 956) && y() != null) {
                    A();
                }
            }
        }
    }
}
