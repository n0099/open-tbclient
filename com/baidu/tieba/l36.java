package com.baidu.tieba;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
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
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.ad.noadfloat.NoAdFloatContainer;
import com.baidu.tieba.ad.noadfloat.RoundProgressBar;
import com.baidu.tieba.j36;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
/* loaded from: classes7.dex */
public class l36 {
    public static /* synthetic */ Interceptable $ic;
    public static l36 G;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public f B;
    public g C;
    public View.OnTouchListener D;
    public j36.b E;
    public View.OnClickListener F;
    @NonNull
    public final MutableContextWrapper a;
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
    public j36 y;
    public long z;

    /* loaded from: classes7.dex */
    public interface f {
        void onClick();
    }

    /* loaded from: classes7.dex */
    public interface g {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947891994, "Lcom/baidu/tieba/l36;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947891994, "Lcom/baidu/tieba/l36;");
        }
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l36 a;

        /* renamed from: com.baidu.tieba.l36$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0385a implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0385a(a aVar) {
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

        /* loaded from: classes7.dex */
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

        public a(l36 l36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l36Var;
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
                                ValueAnimator ofInt = ValueAnimator.ofInt(this.a.i.x, this.a.i.x - (k36.b - k36.a));
                                ofInt.setDuration(200L);
                                ofInt.setInterpolator(new DecelerateInterpolator());
                                ofInt.addUpdateListener(new C0385a(this));
                                ofInt.start();
                            }
                            this.a.f.d();
                            this.a.w.setClickable(true);
                            l36 l36Var = this.a;
                            l36Var.g = !l36Var.g;
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

    /* loaded from: classes7.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l36 a;

        public b(l36 l36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l36Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, valueAnimator) != null) || !this.a.e.isAttachedToWindow()) {
                return;
            }
            this.a.i.x = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            this.a.d.updateViewLayout(this.a.e, this.a.i);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l36 a;

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

        public c(l36 l36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l36Var;
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

    /* loaded from: classes7.dex */
    public class d implements j36.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l36 a;

        public d(l36 l36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l36Var;
        }

        @Override // com.baidu.tieba.j36.b
        public void a(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) != null) {
                return;
            }
            this.a.A = j2;
            if (this.a.g) {
                this.a.u.setText(this.a.y.c(j2));
            } else {
                this.a.u.setText(this.a.a.getString(R.string.increase_no_ad_time));
            }
            this.a.h.setProgress((int) ((j2 * 100) / j));
        }

        @Override // com.baidu.tieba.j36.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.u.setText(this.a.a.getString(R.string.increase_no_ad_time));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l36 a;

        public e(l36 l36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l36Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2.getId() == this.a.w.getId() && !this.a.g) {
                this.a.M();
                if (this.a.C != null) {
                    this.a.C.a();
                }
            }
        }
    }

    public l36() {
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
        this.a = new MutableContextWrapper(TbadkCoreApplication.getInst().getCurrentActivity());
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

    public void K(Activity activity) {
        MutableContextWrapper mutableContextWrapper;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, activity) == null) && (mutableContextWrapper = this.a) != null && mutableContextWrapper.getBaseContext() == activity) {
            this.a.setBaseContext(null);
        }
    }

    public void N(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            long j2 = this.z + j;
            this.z = j2;
            long j3 = this.A + j;
            this.A = j3;
            j36 j36Var = this.y;
            if (j36Var != null) {
                j36Var.e(j2, j3);
            }
        }
    }

    public void T(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.s = i;
        }
    }

    public void U(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j) == null) {
            this.A = j;
        }
    }

    public void V(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, fVar) == null) {
            this.B = fVar;
        }
    }

    public void W(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, gVar) == null) {
            this.C = gVar;
        }
    }

    public void X(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.p = i;
        }
    }

    public void Y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.o = i;
        }
    }

    public void Z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.q = i;
        }
    }

    public void a0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.r = i;
        }
    }

    public void b0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j) == null) {
            this.z = j;
        }
    }

    public static l36 L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (G == null) {
                synchronized (l36.class) {
                    if (G == null) {
                        G = new l36();
                    }
                }
            }
            return G;
        }
        return (l36) invokeV.objValue;
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MutableContextWrapper mutableContextWrapper = this.a;
            if (mutableContextWrapper != null) {
                mutableContextWrapper.setBaseContext(null);
            }
            this.b = false;
            this.c = false;
            this.t = false;
            j36 j36Var = this.y;
            if (j36Var != null) {
                j36Var.b();
            }
            this.y = null;
            this.B = null;
            this.C = null;
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || !this.c) {
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.a, R.anim.obfuscated_res_0x7f010064);
        loadAnimation.setAnimationListener(new c(this));
        this.f.startAnimation(loadAnimation);
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public void R() {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && P(this.a.getBaseContext()) && this.c && (layoutParams = this.i) != null && layoutParams.token == null) {
            G(this.e, layoutParams);
        }
    }

    public final void G(View view2, WindowManager.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, layoutParams) == null) && this.a != null && layoutParams != null && this.d != null && view2 != null) {
            if (view2.isAttachedToWindow()) {
                this.d.removeViewImmediate(view2);
            }
            Context baseContext = this.a.getBaseContext();
            if (baseContext instanceof Activity) {
                IBinder windowToken = ((Activity) baseContext).getWindow().getDecorView().getWindowToken();
                layoutParams.token = windowToken;
                if (windowToken != null) {
                    this.d.addView(view2, layoutParams);
                }
            }
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || !P(this.a.getBaseContext()) || this.g) {
            return;
        }
        if (!this.t) {
            int i = this.i.x;
            ValueAnimator ofInt = ValueAnimator.ofInt(i, (k36.b - k36.a) + i);
            ofInt.setDuration(200L);
            ofInt.setInterpolator(new DecelerateInterpolator());
            ofInt.addUpdateListener(new b(this));
            ofInt.start();
        }
        this.f.b();
        this.w.setClickable(false);
        this.g = !this.g;
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || this.c) {
            return;
        }
        this.f.startAnimation(AnimationUtils.loadAnimation(this.a, R.anim.fade_in));
        WindowManager.LayoutParams I = I((this.o - k36.a) - (k36.c * 2), this.p - k36.d);
        this.i = I;
        G(this.e, I);
        this.y.e(this.z, this.A);
        this.c = true;
        S(TbadkCoreApplication.getInst().getSkinType());
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
            layoutParams.width = k36.b + (k36.c * 2);
            layoutParams.height = k36.a + (k36.c * 2);
            return layoutParams;
        }
        return (WindowManager.LayoutParams) invokeII.objValue;
    }

    public void O(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, activity) == null) && !this.b) {
            this.a.setBaseContext(activity);
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.no_ad_float_view, (ViewGroup) null);
            this.e = inflate;
            inflate.setOnTouchListener(this.D);
            this.f = (NoAdFloatContainer) this.e.findViewById(R.id.no_ad_float_container);
            RoundProgressBar roundProgressBar = (RoundProgressBar) this.e.findViewById(R.id.round_progress);
            this.h = roundProgressBar;
            roundProgressBar.setProgress(60);
            this.u = (TextView) this.e.findViewById(R.id.left_time);
            this.v = (ImageView) this.e.findViewById(R.id.img_ad);
            ImageView imageView = (ImageView) this.e.findViewById(R.id.img_close);
            this.w = imageView;
            imageView.setOnClickListener(this.F);
            this.w.setClickable(false);
            this.x = this.e.findViewById(R.id.view_bg);
            j36 j36Var = new j36();
            this.y = j36Var;
            j36Var.d(this.E);
            this.d = (WindowManager) this.a.getApplicationContext().getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
            this.b = true;
        }
    }

    public void S(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && P(this.a.getBaseContext()) && this.c && this.x != null && this.u != null && this.v != null && this.w != null) {
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0211).setShapeRadius(BdUtilHelper.getDimens(this.a, R.dimen.tbds65)).setShadowRadius(BdUtilHelper.getDimens(this.a, R.dimen.tbds25)).setShadowColor(R.color.CAM_X0804).setOffsetX(0).setOffsetY(BdUtilHelper.getDimens(this.a, R.dimen.tbds8)).into(this.x);
            EMManager.from(this.u).setTextColor(R.color.CAM_X0302);
            this.v.setImageResource(SkinManager.getResourceId(R.drawable.no_ad_icon));
            this.w.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_close12, SkinManager.getColor(R.color.CAM_X0107), null));
        }
    }

    public final boolean P(Context context) {
        InterceptResult invokeL;
        String simpleName;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
            if (context == null || (simpleName = context.getClass().getSimpleName()) == null || simpleName.equals("LogoActivity") || simpleName.equals("ImageViewerActivity") || simpleName.equals("InterestGuideActivity")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void d0(Activity activity) {
        MutableContextWrapper mutableContextWrapper;
        int i;
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048598, this, activity) != null) || (mutableContextWrapper = this.a) == null) {
            return;
        }
        mutableContextWrapper.setBaseContext(activity);
        if ((!(activity instanceof BaseActivity) && !(activity instanceof BaseFragmentActivity)) || !P(this.a.getBaseContext()) || !this.c) {
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
