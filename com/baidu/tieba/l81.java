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
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class l81 extends PopupWindow implements q81, ViewTreeObserver.OnWindowFocusChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public AdImageView b;
    public ViewGroup c;
    public i81 d;
    public s81 e;
    public r81 f;

    /* loaded from: classes6.dex */
    public class a implements PanelScrollView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l81 a;

        public a(l81 l81Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l81Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l81Var;
        }

        @Override // com.baidu.nadcore.webpanel.PanelScrollView.c
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.f != null) {
                this.a.f.e();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements PanelScrollView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l81 a;

        public b(l81 l81Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l81Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l81Var;
        }

        @Override // com.baidu.nadcore.webpanel.PanelScrollView.d
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.f != null) {
                this.a.f.c();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s81 a;
        public final /* synthetic */ l81 b;

        public c(l81 l81Var, s81 s81Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l81Var, s81Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l81Var;
            this.a = s81Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.f != null) {
                if (this.a.q()) {
                    this.b.g();
                    this.b.b.setVisibility(8);
                    this.b.f.a();
                    return;
                }
                this.b.f.b();
            }
        }
    }

    public l81(Context context) {
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
        setAnimationStyle(R.style.obfuscated_res_0x7f1003e7);
        setClippingEnabled(true);
        setWidth(-1);
        setHeight(-1);
        setContentView(f(context));
    }

    public void h(s81 s81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, s81Var) == null) {
            this.e = s81Var;
            i81 i81Var = new i81((Activity) this.a.getContext(), (ViewGroup) this.a);
            this.d = i81Var;
            i81Var.f(s81Var);
            this.d.a(this);
            PanelScrollView b2 = this.d.b();
            if (b2 != null) {
                b2.setOnGestureScrollListener(new a(this));
                b2.setOnGestureSingleTapUpListener(new b(this));
            }
            l(s81Var);
        }
    }

    public final View f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.nad_panel_pop_view, (ViewGroup) null);
            this.a = inflate;
            this.b = (AdImageView) inflate.findViewById(R.id.top_right_icon);
            return this.a;
        }
        return (View) invokeL.objValue;
    }

    public void i(@NonNull r81 r81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, r81Var) == null) {
            this.f = r81Var;
        }
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && this.e.o()) {
            a91.a(this.a.getContext(), this);
        }
    }

    @Override // com.baidu.tieba.q81
    public void a(int i) {
        r81 r81Var;
        r81 r81Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (this.e.l() && (r81Var2 = this.f) != null) {
                r81Var2.d();
                return;
            }
            y81.a(ClogBuilder.LogType.NAVIDEO_POP_CLOSE, String.valueOf(i), "", this.e.c());
            g();
            if (i == 0 && (r81Var = this.f) != null) {
                r81Var.f();
            }
        }
    }

    public final void l(s81 s81Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, s81Var) != null) || !s81Var.s()) {
            return;
        }
        if (s81Var.q()) {
            this.b.setImageResource(R.drawable.nad_reward_video_lp_down_arrow);
        }
        this.b.setVisibility(0);
        this.b.setOnClickListener(new c(this, s81Var));
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                StackTraceElement[] stackTrace = new Exception().getStackTrace();
                if (stackTrace.length >= 2 && stackTrace[1] != null && "dispatchKeyEvent".equals(stackTrace[1].getMethodName())) {
                    if (this.e.p()) {
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
            pn0.a().a(new n81(5, this.e.a()));
            this.d.e();
            this.a.getViewTreeObserver().removeOnWindowFocusChangeListener(this);
            if (this.e.k()) {
                this.c = a91.b(this.a.getContext(), this.c, false);
            }
            h81.a.b(false);
            h81.a.a(false);
            super.dismiss();
            r81 r81Var = this.f;
            if (r81Var != null) {
                r81Var.dismiss();
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            g();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.getViewTreeObserver().addOnWindowFocusChangeListener(this);
            if (this.e.o()) {
                a91.a(this.a.getContext(), this);
            }
            View.OnTouchListener c2 = this.d.c();
            if (c2 != null && !this.e.m()) {
                setTouchInterceptor(c2);
            }
            if (this.e.k()) {
                this.c = a91.b(this.a.getContext(), this.c, true);
            }
            k(this.a.getContext(), ((Activity) this.a.getContext()).getWindow().getDecorView(), 80, 0, 0);
            h81.a.b(true);
            h81.a.a(false);
            y81.a(ClogBuilder.LogType.FREE_SHOW, "", "", this.e.c());
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
                } catch (Exception e) {
                    qa1.d(e);
                }
            }
        }
    }
}
