package com.baidu.tieba;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.bubble.BubbleManager;
import com.baidu.nadcore.widget.bubble.BubblePosition;
import com.baidu.tieba.t11;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes9.dex */
public abstract class x71 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public int c;
    public BubbleManager.b d;
    public BubbleManager.a e;
    public g f;
    public boolean g;
    public boolean h;
    public boolean i;
    public ObjectAnimator j;
    public boolean k;
    public b81 l;
    public t71 m;

    public abstract b81 f();

    public abstract void k();

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x71 a;

        public a(x71 x71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x71Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x71 a;

        public b(x71 x71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x71Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                x71 x71Var = this.a;
                BubblePosition b = x71Var.m.b(x71Var.l);
                if (b == BubblePosition.INVALID) {
                    this.a.l.m();
                    s71.a().b("——>show: remove bubble view end");
                    x71 x71Var2 = this.a;
                    if (x71Var2.g) {
                        x71Var2.l.l();
                        s71.a().b("——>show: remove bg view end");
                    }
                    x71 x71Var3 = this.a;
                    if (x71Var3.h) {
                        x71Var3.l.k();
                        s71.a().b("——>show: remove anchorlayer view end");
                        return;
                    }
                    return;
                }
                this.a.l.z(b);
                this.a.r(b);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BubblePosition a;
        public final /* synthetic */ x71 b;

        public c(x71 x71Var, BubblePosition bubblePosition) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x71Var, bubblePosition};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x71Var;
            this.a = bubblePosition;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                x71 x71Var = this.b;
                int[] i3 = x71Var.m.i(this.a, x71Var.l);
                this.b.l.A(i3);
                x71 x71Var2 = this.b;
                if (x71Var2.i) {
                    int a = t11.c.a(null, x71Var2.m.b + 11.0f);
                    BubblePosition bubblePosition = this.a;
                    if (bubblePosition != BubblePosition.UP && bubblePosition != BubblePosition.DOWN) {
                        if (bubblePosition == BubblePosition.RIGHT || bubblePosition == BubblePosition.LEFT) {
                            if (this.a == BubblePosition.LEFT) {
                                i2 = i3[0] + a;
                            } else {
                                i2 = i3[0] - a;
                            }
                            x71 x71Var3 = this.b;
                            x71Var3.b(x71Var3.l.b, i2, i3[0], i3[1], i3[1]);
                        }
                    } else {
                        if (this.a == BubblePosition.UP) {
                            i = i3[1] + a;
                        } else {
                            i = i3[1] - a;
                        }
                        x71 x71Var4 = this.b;
                        x71Var4.b(x71Var4.l.b, i3[0], i3[0], i, i3[1]);
                    }
                }
                x71 x71Var5 = this.b;
                if (x71Var5.h) {
                    x71Var5.l.y();
                }
                x71 x71Var6 = this.b;
                x71Var6.a = true;
                if (x71Var6.b) {
                    x71Var6.f.sendEmptyMessageDelayed(0, x71Var6.c);
                }
                BubbleManager.b bVar = this.b.d;
                if (bVar != null) {
                    bVar.onBubbleShow();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x71 a;

        public d(x71 x71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x71Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.i(view2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x71 a;

        public e(x71 x71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x71Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.i(view2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x71 a;

        public f(x71 x71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x71Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.i(view2);
                BubbleManager.a aVar = this.a.e;
                if (aVar != null) {
                    aVar.onAnchorClick();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class g extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<x71> a;

        public g(x71 x71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(x71Var);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            x71 x71Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 0 && (x71Var = this.a.get()) != null) {
                x71Var.c();
            }
        }
    }

    public x71(b81 b81Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b81Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = true;
        this.c = 7000;
        this.k = true;
        this.m = new t71();
        this.l = b81Var;
    }

    public final void b(View view2, float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            ObjectAnimator objectAnimator = this.j;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.j.cancel();
            }
            ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(view2, PropertyValuesHolder.ofFloat(Key.ALPHA, 0.0f, 1.0f), PropertyValuesHolder.ofFloat(Key.TRANSLATION_X, f2, f3), PropertyValuesHolder.ofFloat(Key.TRANSLATION_Y, f4, f5)).setDuration(180L);
            this.j = duration;
            duration.start();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || !this.a) {
            return;
        }
        vf0.c(new a(this));
    }

    public t71 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.m;
        }
        return (t71) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return !this.a;
        }
        return invokeV.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            b81 b81Var = this.l;
            if (b81Var != null) {
                b81Var.n();
                this.l = null;
            }
            this.d = null;
            this.f = null;
            this.j = null;
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.i = z;
        }
    }

    public void i(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            BubbleManager.b bVar = this.d;
            if (bVar != null) {
                bVar.onBubbleClick();
            }
            if (this.k) {
                c();
            }
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            if (i <= 0) {
                this.c = 7000;
            } else {
                this.c = i;
            }
        }
    }

    public void o(BubbleManager.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.d = bVar;
        }
    }

    public void r(BubblePosition bubblePosition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bubblePosition) == null) {
            this.l.j(new c(this, bubblePosition));
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.l.g()) {
            this.f = new g(this);
            this.l.v(new d(this));
            this.l.u(new e(this));
            this.l.t(new f(this));
        }
    }

    public void q() {
        b81 b81Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || (b81Var = this.l) == null || b81Var.c == null || TextUtils.isEmpty(b81Var.c()) || !this.l.h() || !h()) {
            return;
        }
        p();
    }

    public void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.a) {
            ObjectAnimator objectAnimator = this.j;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.j.cancel();
            }
            if (this.g) {
                this.l.l();
                s71.a().b("——>dismiss BgView end");
            }
            if (this.h) {
                this.l.k();
                s71.a().b("——>dismiss anchorLayer end");
            }
            this.l.m();
            s71.a().b("——>dismiss BubbleView end");
            this.a = false;
            g gVar = this.f;
            if (gVar != null) {
                gVar.removeMessages(0);
            }
            BubbleManager.b bVar = this.d;
            if (bVar != null) {
                bVar.onBubbleDismiss();
            }
            m();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            s71.a().b("——>show");
            g();
            if (this.g) {
                this.l.q();
            }
            if (this.h) {
                this.l.p();
                this.l.o();
            }
            this.l.r();
            if (!this.k) {
                this.l.f();
            }
            k();
            this.l.j(new b(this));
        }
    }
}
