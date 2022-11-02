package com.baidu.tieba;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.ad.noadfloat.NoAdFloatContainer;
import com.baidu.tieba.ad.noadfloat.RoundProgressBar;
import com.baidu.tieba.gr5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
/* loaded from: classes4.dex */
public class ir5 {
    public static /* synthetic */ Interceptable $ic;
    public static ir5 G;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public f B;
    public g C;
    public View.OnTouchListener D;
    public gr5.b E;
    public View.OnClickListener F;
    public Activity a;
    public boolean b;
    public boolean c;
    public WindowManager d;
    public View e;
    public NoAdFloatContainer f;
    public boolean g;
    public RoundProgressBar h;
    public WindowManager.LayoutParams i;
    public boolean j;
    public int k;
    public int l;
    public float m;
    public float n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public boolean t;
    public TextView u;
    public ImageView v;
    public ImageView w;
    public View x;
    public gr5 y;
    public long z;

    /* loaded from: classes4.dex */
    public interface f {
        void onClick();
    }

    /* loaded from: classes4.dex */
    public interface g {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947863133, "Lcom/baidu/tieba/ir5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947863133, "Lcom/baidu/tieba/ir5;");
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ir5 a;

        /* renamed from: com.baidu.tieba.ir5$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0313a implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0313a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    this.a.a.i.x = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    this.a.a.d.updateViewLayout(this.a.a.e, this.a.a.i);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    this.a.a.i.x = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    this.a.a.d.updateViewLayout(this.a.a.e, this.a.a.i);
                }
            }
        }

        public a(ir5 ir5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ir5Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 0) {
                    int[] iArr = new int[2];
                    this.a.e.getLocationOnScreen(iArr);
                    int i2 = iArr[0];
                    int i3 = iArr[1];
                    if (motionEvent.getRawX() > i2 && motionEvent.getRawX() < this.a.e.getWidth() + i2 && motionEvent.getRawY() > i3 && motionEvent.getRawY() < this.a.e.getHeight() + i3) {
                        this.a.j = true;
                        this.a.k = ((int) motionEvent.getRawX()) - i2;
                        this.a.l = ((int) motionEvent.getRawY()) - i3;
                    }
                    this.a.m = motionEvent.getRawX();
                    this.a.n = motionEvent.getRawY();
                } else if (motionEvent.getAction() == 2) {
                    if (this.a.j && this.a.i != null && this.a.d != null) {
                        int rawY = (((int) motionEvent.getRawY()) - this.a.l) - this.a.q;
                        int i4 = this.a.r - this.a.q;
                        int i5 = (this.a.p - this.a.s) - this.a.i.height;
                        if (rawY < i4) {
                            rawY = i4;
                        } else if (rawY > i5) {
                            rawY = i5;
                        }
                        this.a.i.x = ((int) motionEvent.getRawX()) - this.a.k;
                        this.a.i.y = rawY;
                        PrintStream printStream = System.out;
                        printStream.println("steven: wmParams.x " + this.a.i.x + " wmParams.y " + this.a.i.y);
                        this.a.d.updateViewLayout(this.a.e, this.a.i);
                    }
                } else if (motionEvent.getAction() == 1) {
                    if (Math.abs(motionEvent.getRawX() - this.a.m) < 2.0f && Math.abs(motionEvent.getRawY() - this.a.n) < 2.0f) {
                        if (this.a.g) {
                            if (!this.a.t) {
                                ValueAnimator ofInt = ValueAnimator.ofInt(this.a.i.x, this.a.i.x - (hr5.b - hr5.a));
                                ofInt.setDuration(200L);
                                ofInt.setInterpolator(new DecelerateInterpolator());
                                ofInt.addUpdateListener(new C0313a(this));
                                ofInt.start();
                            }
                            this.a.f.d();
                            this.a.w.setClickable(true);
                            ir5 ir5Var = this.a;
                            ir5Var.g = !ir5Var.g;
                        } else {
                            this.a.H();
                            if (this.a.B != null) {
                                this.a.B.onClick();
                            }
                        }
                    } else if (this.a.j) {
                        int i6 = this.a.i.x;
                        if ((this.a.f.getWidth() / 2) + i6 > this.a.o / 2) {
                            i = this.a.o - this.a.f.getWidth();
                            this.a.t = false;
                        } else {
                            this.a.t = true;
                            i = 0;
                        }
                        ValueAnimator ofInt2 = ValueAnimator.ofInt(i6, i);
                        ofInt2.setDuration(250L);
                        ofInt2.setInterpolator(new DecelerateInterpolator());
                        ofInt2.addUpdateListener(new b(this));
                        ofInt2.start();
                    }
                    this.a.j = false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ir5 a;

        public b(ir5 ir5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ir5Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.i.x = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.a.d.updateViewLayout(this.a.e, this.a.i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ir5 a;

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

        public c(ir5 ir5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ir5Var;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.f.c();
                this.a.w.setClickable(false);
                this.a.g = true;
                if (this.a.d != null) {
                    this.a.d.removeView(this.a.e);
                }
                this.a.y.b();
                this.a.c = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements gr5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ir5 a;

        public d(ir5 ir5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ir5Var;
        }

        @Override // com.baidu.tieba.gr5.b
        public void a(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) != null) {
                return;
            }
            this.a.A = j2;
            if (this.a.g) {
                this.a.u.setText(this.a.y.c(j2));
            } else {
                this.a.u.setText(this.a.a.getString(R.string.obfuscated_res_0x7f0f0912));
            }
            this.a.h.setProgress((int) ((j2 * 100) / j));
        }

        @Override // com.baidu.tieba.gr5.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.u.setText(this.a.a.getString(R.string.obfuscated_res_0x7f0f0912));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ir5 a;

        public e(ir5 ir5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ir5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2.getId() == this.a.w.getId() && !this.a.g) {
                this.a.K();
                if (this.a.C != null) {
                    this.a.C.a();
                }
            }
        }
    }

    public ir5() {
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
        this.b = false;
        this.c = false;
        this.g = true;
        this.j = false;
        this.k = 0;
        this.l = 0;
        this.m = 0.0f;
        this.n = 0.0f;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = false;
        this.z = 0L;
        this.A = 0L;
        this.D = new a(this);
        this.E = new d(this);
        this.F = new e(this);
    }

    public void H() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.g) {
            return;
        }
        if (!this.t) {
            int i = this.i.x;
            ValueAnimator ofInt = ValueAnimator.ofInt(i, (hr5.b - hr5.a) + i);
            ofInt.setDuration(200L);
            ofInt.setInterpolator(new DecelerateInterpolator());
            ofInt.addUpdateListener(new b(this));
            ofInt.start();
        }
        this.f.b();
        this.w.setClickable(false);
        this.g = !this.g;
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || this.c) {
            return;
        }
        this.f.startAnimation(AnimationUtils.loadAnimation(this.a, R.anim.obfuscated_res_0x7f010063));
        WindowManager.LayoutParams I = I((this.o - hr5.a) - (hr5.c * 2), this.p - hr5.d);
        this.i = I;
        G(this.e, I);
        this.y.e(this.z, this.A);
        this.c = true;
        P(TbadkCoreApplication.getInst().getSkinType());
    }

    public void L(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            long j2 = this.z + j;
            this.z = j2;
            long j3 = this.A + j;
            this.A = j3;
            gr5 gr5Var = this.y;
            if (gr5Var != null) {
                gr5Var.e(j2, j3);
            }
        }
    }

    public void Q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.s = i;
        }
    }

    public void R(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            this.A = j;
        }
    }

    public void S(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) {
            this.B = fVar;
        }
    }

    public void T(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, gVar) == null) {
            this.C = gVar;
        }
    }

    public void U(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.p = i;
        }
    }

    public void V(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.o = i;
        }
    }

    public void W(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.q = i;
        }
    }

    public void X(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.r = i;
        }
    }

    public void Y(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048593, this, j) == null) {
            this.z = j;
        }
    }

    public static ir5 J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (G == null) {
                synchronized (ir5.class) {
                    if (G == null) {
                        G = new ir5();
                    }
                }
            }
            return G;
        }
        return (ir5) invokeV.objValue;
    }

    public void K() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || !this.c) {
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.a, R.anim.fade_out);
        loadAnimation.setAnimationListener(new c(this));
        this.f.startAnimation(loadAnimation);
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public void O() {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.c && (layoutParams = this.i) != null && layoutParams.token == null) {
            G(this.e, layoutParams);
        }
    }

    public final void G(View view2, WindowManager.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, layoutParams) == null) && this.a != null && layoutParams != null && this.d != null && view2 != null) {
            if (view2.isAttachedToWindow()) {
                this.d.removeViewImmediate(view2);
            }
            IBinder windowToken = this.a.getWindow().getDecorView().getWindowToken();
            layoutParams.token = windowToken;
            if (windowToken != null) {
                this.d.addView(view2, layoutParams);
            }
        }
    }

    public final WindowManager.LayoutParams I(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2)) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.type = 1003;
            layoutParams.flags = 520;
            layoutParams.format = -3;
            layoutParams.gravity = 51;
            layoutParams.x = i;
            layoutParams.y = i2;
            layoutParams.width = hr5.b + (hr5.c * 2);
            layoutParams.height = hr5.a + (hr5.c * 2);
            return layoutParams;
        }
        return (WindowManager.LayoutParams) invokeII.objValue;
    }

    public void M(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, activity) == null) && !this.b) {
            View inflate = LayoutInflater.from(activity).inflate(R.layout.obfuscated_res_0x7f0d0674, (ViewGroup) null);
            this.e = inflate;
            inflate.setOnTouchListener(this.D);
            this.f = (NoAdFloatContainer) this.e.findViewById(R.id.obfuscated_res_0x7f0916fa);
            RoundProgressBar roundProgressBar = (RoundProgressBar) this.e.findViewById(R.id.obfuscated_res_0x7f091cd5);
            this.h = roundProgressBar;
            roundProgressBar.setProgress(60);
            this.u = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f091308);
            this.v = (ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f090ef1);
            ImageView imageView = (ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f090f05);
            this.w = imageView;
            imageView.setOnClickListener(this.F);
            this.w.setClickable(false);
            this.x = this.e.findViewById(R.id.obfuscated_res_0x7f0925e5);
            gr5 gr5Var = new gr5();
            this.y = gr5Var;
            gr5Var.d(this.E);
            this.d = (WindowManager) activity.getApplicationContext().getSystemService("window");
            this.b = true;
        }
    }

    public void P(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && this.c && this.x != null && this.u != null && this.v != null && this.w != null) {
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0211).setShapeRadius(xi.g(this.a, R.dimen.tbds65)).setShadowRadius(xi.g(this.a, R.dimen.tbds25)).setShadowColor(R.color.CAM_X0804).setOffsetX(0).setOffsetY(xi.g(this.a, R.dimen.tbds8)).into(this.x);
            kw4.d(this.u).v(R.color.CAM_X0302);
            this.v.setImageResource(SkinManager.getResourceId(R.drawable.obfuscated_res_0x7f080e8f));
            this.w.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080951, SkinManager.getColor(R.color.CAM_X0107), null));
        }
    }

    public void a0(Activity activity) {
        int i;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, activity) == null) {
            this.a = activity;
            if (!this.c) {
                return;
            }
            if (this.d != null && (view2 = this.e) != null && view2.isAttachedToWindow()) {
                this.d.removeViewImmediate(this.e);
            }
            WindowManager.LayoutParams layoutParams = this.i;
            int i2 = 0;
            if (layoutParams != null) {
                i2 = layoutParams.x;
                i = layoutParams.y;
            } else {
                i = 0;
            }
            WindowManager.LayoutParams I = I(i2, i);
            this.i = I;
            G(this.e, I);
        }
    }
}
