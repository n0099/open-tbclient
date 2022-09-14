package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class rl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ViewGroup b;
    public ViewGroup c;
    public ViewGroup d;
    public hl5 e;
    public kl5 f;
    public boolean g;
    public Animation h;
    public Animation i;
    public boolean j;
    public int k;
    public Dialog l;
    public View m;
    public boolean n;
    public View.OnKeyListener o;
    public final View.OnTouchListener p;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl5 a;

        public a(rl5 rl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rl5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.f();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl5 a;

        public b(rl5 rl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rl5Var;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.h();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl5 a;

        public c(rl5 rl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rl5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                rl5 rl5Var = this.a;
                rl5Var.e.y.removeView(rl5Var.c);
                this.a.j = false;
                this.a.g = false;
                if (this.a.f != null) {
                    this.a.f.a(this.a);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl5 a;

        public d(rl5 rl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rl5Var;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view2, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view2, i, keyEvent)) == null) {
                if (i == 4 && keyEvent.getAction() == 0 && this.a.p()) {
                    this.a.f();
                    return true;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl5 a;

        public e(rl5 rl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rl5Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 0) {
                    this.a.f();
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl5 a;

        public f(rl5 rl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rl5Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || this.a.f == null) {
                return;
            }
            this.a.f.a(this.a);
        }
    }

    public rl5(Context context) {
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
        this.k = 80;
        this.n = true;
        this.o = new d(this);
        this.p = new e(this);
        this.a = context;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.d == null) {
            return;
        }
        Dialog dialog = new Dialog(this.a, R.style.obfuscated_res_0x7f1003ab);
        this.l = dialog;
        dialog.setCancelable(this.e.S);
        this.l.setContentView(this.d);
        Window window = this.l.getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.obfuscated_res_0x7f1003d2);
            window.setGravity(17);
        }
        this.l.setOnDismissListener(new f(this));
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (o()) {
                g();
            } else if (this.g) {
            } else {
                if (this.n) {
                    this.h.setAnimationListener(new b(this));
                    this.b.startAnimation(this.h);
                } else {
                    h();
                }
                this.g = true;
            }
        }
    }

    public final void g() {
        Dialog dialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (dialog = this.l) == null) {
            return;
        }
        dialog.dismiss();
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.e.y.post(new c(this));
        }
    }

    public View i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? this.b.findViewById(i) : (View) invokeI.objValue;
    }

    public Dialog j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.l : (Dialog) invokeV.objValue;
    }

    public final Animation k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? AnimationUtils.loadAnimation(this.a, ql5.a(this.k, true)) : (Animation) invokeV.objValue;
    }

    public final Animation l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? AnimationUtils.loadAnimation(this.a, ql5.a(this.k, false)) : (Animation) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.i = k();
            this.h = l();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
            LayoutInflater from = LayoutInflater.from(this.a);
            if (o()) {
                ViewGroup viewGroup = (ViewGroup) from.inflate(R.layout.obfuscated_res_0x7f0d048f, (ViewGroup) null, false);
                this.d = viewGroup;
                viewGroup.setBackgroundColor(0);
                ViewGroup viewGroup2 = (ViewGroup) this.d.findViewById(R.id.obfuscated_res_0x7f0906e9);
                this.b = viewGroup2;
                layoutParams.leftMargin = 30;
                layoutParams.rightMargin = 30;
                viewGroup2.setLayoutParams(layoutParams);
                e();
                this.d.setOnClickListener(new a(this));
            } else {
                hl5 hl5Var = this.e;
                if (hl5Var.y == null) {
                    hl5Var.y = (ViewGroup) ((Activity) this.a).getWindow().getDecorView();
                }
                ViewGroup viewGroup3 = (ViewGroup) from.inflate(R.layout.obfuscated_res_0x7f0d048f, this.e.y, false);
                this.c = viewGroup3;
                viewGroup3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                int i = this.e.P;
                if (i != -1) {
                    this.c.setBackgroundColor(i);
                }
                ViewGroup viewGroup4 = (ViewGroup) this.c.findViewById(R.id.obfuscated_res_0x7f0906e9);
                this.b = viewGroup4;
                viewGroup4.setLayoutParams(layoutParams);
            }
            s(true);
        }
    }

    public abstract boolean o();

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (o()) {
                return false;
            }
            return this.c.getParent() != null || this.j;
        }
        return invokeV.booleanValue;
    }

    public final void q(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            this.e.y.addView(view2);
            if (this.n) {
                this.b.startAnimation(this.i);
            }
        }
    }

    public void r() {
        Dialog dialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (dialog = this.l) == null) {
            return;
        }
        dialog.setCancelable(this.e.S);
    }

    public void s(boolean z) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (o()) {
                viewGroup = this.d;
            } else {
                viewGroup = this.c;
            }
            viewGroup.setFocusable(z);
            viewGroup.setFocusableInTouchMode(z);
            if (z) {
                viewGroup.setOnKeyListener(this.o);
            } else {
                viewGroup.setOnKeyListener(null);
            }
        }
    }

    public rl5 t(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            ViewGroup viewGroup = this.c;
            if (viewGroup != null) {
                View findViewById = viewGroup.findViewById(R.id.obfuscated_res_0x7f091776);
                if (z) {
                    findViewById.setOnTouchListener(this.p);
                } else {
                    findViewById.setOnTouchListener(null);
                }
            }
            return this;
        }
        return (rl5) invokeZ.objValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (o()) {
                v();
            } else if (p()) {
            } else {
                this.j = true;
                q(this.c);
                this.c.requestFocus();
            }
        }
    }

    public final void v() {
        Dialog dialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (dialog = this.l) == null) {
            return;
        }
        dialog.show();
    }
}
