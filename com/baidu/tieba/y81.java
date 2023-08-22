package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.webpanel.PanelScrollView;
import com.baidu.nadcore.webpanel.model.AdData;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class y81 extends PopupWindow implements e91, ViewTreeObserver.OnWindowFocusChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public AdImageView b;
    public ViewGroup c;
    public v81 d;
    public g91 e;
    public f91 f;

    /* loaded from: classes8.dex */
    public class a implements PanelScrollView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y81 a;

        public a(y81 y81Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y81Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y81Var;
        }

        @Override // com.baidu.nadcore.webpanel.PanelScrollView.c
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.f != null) {
                this.a.f.e();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements PanelScrollView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y81 a;

        public b(y81 y81Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y81Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y81Var;
        }

        @Override // com.baidu.nadcore.webpanel.PanelScrollView.d
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.f != null) {
                this.a.f.c();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g91 a;
        public final /* synthetic */ y81 b;

        public c(y81 y81Var, g91 g91Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y81Var, g91Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y81Var;
            this.a = g91Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.f != null) {
                if (!this.a.t()) {
                    this.b.f.b();
                    return;
                }
                this.b.g();
                this.b.b.setVisibility(8);
                this.b.f.a();
            }
        }
    }

    public y81(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setAnimationStyle(R.style.obfuscated_res_0x7f1003e9);
        setClippingEnabled(true);
        setWidth(-1);
        setHeight(-1);
        setContentView(f(context, R.layout.nad_panel_pop_view));
    }

    @Override // com.baidu.tieba.e91
    public void a(int i) {
        ClogBuilder.Page page;
        ClogBuilder.LogType logType;
        f91 f91Var;
        f91 f91Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (this.e.n() && (f91Var2 = this.f) != null) {
                f91Var2.d();
                return;
            }
            if (this.e.s()) {
                page = ClogBuilder.Page.WELFAREWEB;
            } else {
                page = ClogBuilder.Page.NAD_POP_WEB_PANEL;
            }
            if (this.e.s()) {
                logType = ClogBuilder.LogType.REWARD_HALF_TAIL_SLIDE;
            } else {
                logType = ClogBuilder.LogType.NAVIDEO_POP_CLOSE;
            }
            n91.b(page, logType, String.valueOf(i), "", this.e.d());
            g();
            if (i == 0 && (f91Var = this.f) != null) {
                f91Var.f();
            }
        }
    }

    public void h(g91 g91Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, g91Var) == null) {
            this.e = g91Var;
            v81 v81Var = new v81((Activity) this.a.getContext(), (ViewGroup) this.a);
            this.d = v81Var;
            v81Var.f(g91Var);
            this.d.a(this);
            PanelScrollView b2 = this.d.b();
            if (b2 != null) {
                b2.setOnGestureScrollListener(new a(this));
                b2.setOnGestureSingleTapUpListener(new b(this));
            }
            l(g91Var);
        }
    }

    public y81(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = null;
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setAnimationStyle(R.style.obfuscated_res_0x7f1003e9);
        setClippingEnabled(true);
        setWidth(-1);
        setHeight(-1);
        setContentView(f(context, i));
    }

    public void i(@NonNull f91 f91Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, f91Var) == null) {
            this.f = f91Var;
        }
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && this.e.q()) {
            p91.a(this.a.getContext(), this);
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                StackTraceElement[] stackTrace = new Exception().getStackTrace();
                if (stackTrace.length >= 2 && stackTrace[1] != null && "dispatchKeyEvent".equals(stackTrace[1].getMethodName())) {
                    if (this.e.r()) {
                        if (this.d != null) {
                            this.d.d("javascript:onAndroidBack()");
                        }
                    } else if (!this.d.g()) {
                        a(0);
                    }
                } else {
                    a(0);
                }
            } catch (Exception unused) {
                a(0);
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            en0.a().a(new b91(5, this.e.a()));
            this.d.e();
            this.a.getViewTreeObserver().removeOnWindowFocusChangeListener(this);
            if (this.e.m()) {
                this.c = p91.b(this.a.getContext(), this.c, false);
            }
            u81.b.c(false);
            u81.b.b(false);
            super.dismiss();
            f91 f91Var = this.f;
            if (f91Var != null) {
                f91Var.dismiss();
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            g();
        }
    }

    public final View f(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, context, i)) == null) {
            View inflate = LayoutInflater.from(context).inflate(i, (ViewGroup) null);
            this.a = inflate;
            this.b = (AdImageView) inflate.findViewById(R.id.top_right_icon);
            return this.a;
        }
        return (View) invokeLI.objValue;
    }

    public void j() {
        ClogBuilder.Page page;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.getViewTreeObserver().addOnWindowFocusChangeListener(this);
            if (this.e.q()) {
                p91.a(this.a.getContext(), this);
            }
            View.OnTouchListener c2 = this.d.c();
            if (c2 != null && !this.e.o()) {
                setTouchInterceptor(c2);
            }
            if (this.e.m()) {
                this.c = p91.b(this.a.getContext(), this.c, true);
            }
            en0.a().a(new b91(7, this.d.b()));
            k(this.a.getContext(), ((Activity) this.a.getContext()).getWindow().getDecorView(), 80, 0, 0);
            u81.b.c(true);
            u81.b.b(false);
            if (this.e.s()) {
                page = ClogBuilder.Page.WELFAREWEB;
            } else {
                page = ClogBuilder.Page.NAD_POP_WEB_PANEL;
            }
            n91.b(page, ClogBuilder.LogType.FREE_SHOW, "", "", this.e.d());
        }
    }

    public final void k(Context context, View view2, int i, int i2, int i3) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                try {
                    showAtLocation(view2, i, i2, i3);
                    en0.a().a(new b91(0, (AdData) null));
                } catch (Exception e) {
                    fb1.d(e);
                }
            }
        }
    }

    public final void l(g91 g91Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, g91Var) != null) || !g91Var.v()) {
            return;
        }
        if (g91Var.t()) {
            this.b.setImageResource(R.drawable.nad_reward_video_lp_down_arrow);
        } else {
            this.b.setImageResource(R.drawable.nad_reward_video_lp_close_btn);
        }
        this.b.setVisibility(0);
        this.b.setOnClickListener(new c(this, g91Var));
    }
}
