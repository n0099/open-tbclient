package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.player.helper.BdVideoGesture;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
import com.baidu.nadcore.player.utils.BdNetUtils;
import com.baidu.nadcore.video.videoplayer.ui.full.BdThumbSeekBar;
import com.baidu.nadcore.video.videoplayer.ui.full.BdVideoCacheView;
import com.baidu.nadcore.video.videoplayer.ui.full.BdVideoNewCacheView;
import com.baidu.nadcore.video.videoplayer.ui.full.BdVideoPopImageView;
import com.baidu.nadcore.video.videoplayer.ui.full.BdVideoSeekbarImageView;
import com.baidu.nadcore.video.videoplayer.widget.LockImageView;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qu0 extends mu0 implements View.OnClickListener, os0 {
    public static /* synthetic */ Interceptable $ic;
    public static final int A;
    public static final int x;
    public static final int y;
    public static final int z;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout e;
    public BdVideoSeekbarImageView f;
    public BdVideoSeekbarImageView g;
    public BdVideoPopImageView h;
    public BdVideoPopImageView i;
    public BdVideoPopImageView j;
    public BdVideoCacheView k;
    public BdThumbSeekBar l;
    public LockImageView m;
    public BdVideoGesture n;
    public GestureDetector o;
    public GestureDetector.SimpleOnGestureListener p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public float u;
    public String v;
    public final Runnable w;

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void W(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, motionEvent) == null) {
        }
    }

    public BdVideoSeekbarImageView Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (BdVideoSeekbarImageView) invokeV.objValue;
    }

    public BdVideoSeekbarImageView Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (BdVideoSeekbarImageView) invokeV.objValue;
    }

    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final int k0(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048603, this, i, i2)) == null) {
            if (i < 0) {
                return 0;
            }
            return i > i2 ? i2 : i;
        }
        return invokeII.intValue;
    }

    public boolean l0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qu0 a;

        public a(qu0 qu0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qu0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.t) {
                qu0 qu0Var = this.a;
                qu0Var.q0(Math.max(0, qu0Var.getCurrentPosition() - 5));
                Handler handler = this.a.d;
                if (handler != null) {
                    handler.postDelayed(this, 1000L);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends FrameLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qu0 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(qu0 qu0Var, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu0Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qu0Var;
        }

        @Override // android.view.View
        public void onConfigurationChanged(Configuration configuration) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, configuration) == null) {
                super.onConfigurationChanged(configuration);
                qu0 qu0Var = this.a;
                Context context = qu0Var.c;
                if (context != null) {
                    qu0Var.n.f(context);
                }
                if (!this.a.t) {
                    return;
                }
                this.a.n0();
            }
        }

        @Override // android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                if (this.a.x().l1()) {
                    return super.onTouchEvent(motionEvent);
                }
                if (this.a.t) {
                    if (motionEvent.getAction() == 1 || !this.a.x().W()) {
                        this.a.n0();
                    }
                    return true;
                } else if (this.a.x().Q0() && !lp0.R0() && this.a.x().B() != null && this.a.x().B().getContentView() != null && this.a.x().B().Q() != null && this.a.x().B().getContentView().onTouchEvent(motionEvent)) {
                    return true;
                } else {
                    if (this.a.o0() && getParent() != null) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    IVideoUpdateStrategy i1 = this.a.x().i1();
                    if (!i1.b()) {
                        return super.onTouchEvent(motionEvent);
                    }
                    if (!i1.d()) {
                        return false;
                    }
                    boolean Q0 = this.a.x().Q0();
                    if (this.a.x().j1() != null) {
                        this.a.x().j1().getPage();
                    }
                    if (Q0 && !this.a.j0() && this.a.m0(motionEvent)) {
                        return true;
                    }
                    if (this.a.o.onTouchEvent(motionEvent) && this.a.U()) {
                        return true;
                    }
                    if (!lp0.R0() && this.a.h0()) {
                        if (!this.a.x().Q0()) {
                            this.a.W(motionEvent);
                        }
                        if (this.a.j0()) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                            return true;
                        } else if (this.a.n.b(motionEvent)) {
                            return true;
                        }
                    }
                    if (motionEvent.getAction() == 0) {
                        return this.a.l0(motionEvent);
                    }
                    return super.onTouchEvent(motionEvent);
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qu0 a;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        public c(qu0 qu0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qu0Var;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
                zo0 x = this.a.x();
                if (x != null && x.z() != null && !lp0.R0()) {
                    return x.z().x(motionEvent);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, motionEvent) == null) && this.a.U() && this.a.V()) {
                a(motionEvent);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
                return b(motionEvent);
            }
            return invokeL.booleanValue;
        }

        public final void a(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) {
                qu0 qu0Var = this.a;
                boolean z = false;
                if (qu0Var.e != null) {
                    if (qu0Var.x().U()) {
                        this.a.x().j0();
                    }
                    if (!this.a.x().W()) {
                        return;
                    }
                    if (this.a.e.getParent() != null) {
                        this.a.e.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    this.a.t = true;
                    if (this.a.x().Q0() && lp0.R0()) {
                        if (this.a.m.getVisibility() == 0) {
                            this.a.v0();
                        }
                    } else {
                        this.a.I(ir0.x(LayerEvent.ACTION_LONG_PRESS));
                    }
                    if (motionEvent.getX() > this.a.e.getWidth() / 2.0d) {
                        z = true;
                    }
                    if (z) {
                        this.a.v = "speed";
                        this.a.x().x0(this.a.a0());
                    } else {
                        this.a.v = "backward";
                        qu0 qu0Var2 = this.a;
                        qu0Var2.d.post(qu0Var2.w);
                    }
                    if (this.a.x().z() != null) {
                        this.a.x().z().D(z, true);
                        return;
                    }
                    return;
                }
                qu0Var.t = false;
            }
        }

        public final boolean b(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                if (!this.a.x().P() && !this.a.x().Q()) {
                    if (this.a.g0()) {
                        c(motionEvent);
                    } else {
                        this.a.v0();
                    }
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public final boolean c(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
                this.a.e.setVisibility(0);
                if (motionEvent.getAction() != 0 || this.a.x().P()) {
                    return false;
                }
                this.a.I(ir0.x(LayerEvent.ACTION_TOUCH_DOWN));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948104189, "Lcom/baidu/tieba/qu0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948104189, "Lcom/baidu/tieba/qu0;");
                return;
            }
        }
        x = q21.a(124.0f);
        y = q21.a(85.0f);
        z = q21.a(119.0f);
        A = q21.a(50.0f);
    }

    public qu0() {
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
        this.q = false;
        this.r = false;
        this.s = true;
        this.t = false;
        this.u = 1.0f;
        this.v = "speed";
        this.w = new a(this);
    }

    public final float a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            this.u = x().H();
            float min = Math.min(this.u * bx0.i(), bx0.h());
            if (min <= 0.0f) {
                return this.u;
            }
            return min;
        }
        return invokeV.floatValue;
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f.setVisibility(4);
            this.g.setVisibility(4);
            if (!this.r) {
                this.h.setVisibility(4);
                this.i.setVisibility(4);
            }
            this.j.setVisibility(4);
            I(ir0.x(LayerEvent.ACTION_POSITION_SLIDE_COMPLETE));
        }
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (U() && bx0.p() && V() && x().s() >= 60) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.t = false;
            boolean equals = TextUtils.equals(this.v, "speed");
            if (equals) {
                x().x0(this.u);
            } else {
                this.d.removeCallbacks(this.w);
            }
            if (x().z() != null) {
                x().z().D(equals, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qu0(@NonNull Activity activity) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Activity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.q = false;
        this.r = false;
        this.s = true;
        this.t = false;
        this.u = 1.0f;
        this.v = "speed";
        this.w = new a(this);
    }

    @Override // com.baidu.tieba.eu0, com.baidu.tieba.ss0
    public void q(@NonNull sr0 sr0Var) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, sr0Var) == null) {
            String c3 = sr0Var.c();
            int hashCode = c3.hashCode();
            if (hashCode != -1530009462) {
                if (hashCode == 906917140 && c3.equals(ControlEvent.ACTION_RESUME)) {
                    c2 = 1;
                }
                c2 = 65535;
            } else {
                if (c3.equals(ControlEvent.ACTION_SYNC_PROGRESS)) {
                    c2 = 0;
                }
                c2 = 65535;
            }
            if (c2 != 0) {
                if (c2 == 1) {
                    this.e.setVisibility(0);
                    return;
                }
                return;
            }
            u0(sr0Var.g(1), sr0Var.g(2), sr0Var.g(3));
        }
    }

    @Override // com.baidu.tieba.eu0
    public void C(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            super.C(message);
            if (message != null && message.what == 20 && !this.q) {
                this.m.setVisibility(4);
                this.d.removeMessages(20);
            }
        }
    }

    @Override // com.baidu.tieba.os0
    public void m(BdVideoGesture.VideoPluginGesture videoPluginGesture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, videoPluginGesture) == null) {
            d0();
            if (videoPluginGesture == BdVideoGesture.VideoPluginGesture.InitChange) {
                x().z().w();
            } else {
                x().z().v();
            }
        }
    }

    public final boolean m0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, motionEvent)) == null) {
            if (lp0.R0()) {
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void q0(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            int s = x().s();
            if (s > 1 && i > (i2 = s - 1)) {
                i = i2;
            }
            x().m0(i);
        }
    }

    public void t0(boolean z2) {
        BdVideoCacheView bdVideoCacheView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048619, this, z2) == null) && this.s && (bdVideoCacheView = this.k) != null) {
            if (z2) {
                bdVideoCacheView.c(0);
            } else {
                bdVideoCacheView.c(4);
            }
        }
    }

    @Override // com.baidu.tieba.eu0, com.baidu.tieba.ss0
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            if (playerStatus == PlayerStatus.PLAYING) {
                this.e.setVisibility(0);
                t0(false);
            } else if (playerStatus == PlayerStatus.PREPARING) {
                t0(true);
                this.e.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.os0
    public void l(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            q0((int) (i + f));
        }
    }

    @Override // com.baidu.tieba.eu0
    public void E() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            f0();
            this.e = new b(this, this.c);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(q21.a(300.0f), q21.a(300.0f));
            this.k = new BdVideoNewCacheView(this.c);
            t0(false);
            layoutParams.gravity = 17;
            this.e.addView(this.k, layoutParams);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 80;
            layoutParams2.bottomMargin = q21.b(-4.3f);
            BdThumbSeekBar bdThumbSeekBar = new BdThumbSeekBar(this.c, 2);
            this.l = bdThumbSeekBar;
            bdThumbSeekBar.setThumbScaleVisible(false);
            this.l.setDragable(false);
            this.e.addView(this.l, layoutParams2);
            LockImageView lockImageView = new LockImageView(this.c);
            this.m = lockImageView;
            lockImageView.setBackground(this.c.getResources().getDrawable(R.drawable.nad_videoplayer_playbtn_bg));
            LockImageView lockImageView2 = this.m;
            if (lp0.R0()) {
                i = 1000;
            } else {
                i = 2000;
            }
            lockImageView2.e(i);
            this.m.setOnClickListener(this);
            this.m.setVisibility(4);
            this.e.addView(this.m, b0());
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            layoutParams3.gravity = 17;
            BdVideoSeekbarImageView Z = Z();
            this.f = Z;
            if (Z == null) {
                BdVideoSeekbarImageView bdVideoSeekbarImageView = new BdVideoSeekbarImageView(this.c);
                this.f = bdVideoSeekbarImageView;
                bdVideoSeekbarImageView.setIcon(R.drawable.nad_videoplayer_player_seek_forward);
                this.f.setWidth(q21.a(124.0f));
                this.f.setHeight(q21.a(85.0f));
            }
            this.f.setVisibility(4);
            this.e.addView(this.f, layoutParams3);
            BdVideoSeekbarImageView Y = Y();
            this.g = Y;
            if (Y == null) {
                BdVideoSeekbarImageView bdVideoSeekbarImageView2 = new BdVideoSeekbarImageView(this.c);
                this.g = bdVideoSeekbarImageView2;
                bdVideoSeekbarImageView2.setIcon(R.drawable.nad_videoplayer_player_seek_back);
                this.g.setWidth(q21.a(124.0f));
                this.g.setHeight(q21.a(85.0f));
            }
            this.g.setVisibility(4);
            this.e.addView(this.g, layoutParams3);
            if (!this.r) {
                BdVideoPopImageView bdVideoPopImageView = new BdVideoPopImageView(this.c);
                this.h = bdVideoPopImageView;
                bdVideoPopImageView.setIcon(R.drawable.nad_videoplayer_player_volume_open_big);
                this.h.setMsg("100%");
                this.h.setVisibility(4);
                this.e.addView(this.h, layoutParams3);
                BdVideoPopImageView bdVideoPopImageView2 = new BdVideoPopImageView(this.c);
                this.i = bdVideoPopImageView2;
                bdVideoPopImageView2.setMsg("0%");
                this.i.setIcon(R.drawable.nad_videoplayer_player_volume_close_big);
                this.i.setVisibility(4);
                this.e.addView(this.i, layoutParams3);
            }
            BdVideoPopImageView bdVideoPopImageView3 = new BdVideoPopImageView(this.c);
            this.j = bdVideoPopImageView3;
            bdVideoPopImageView3.setMsg("0%");
            this.j.setIcon(R.drawable.nad_videoplayer_player_bright);
            this.j.setVisibility(4);
            this.e.addView(this.j, layoutParams3);
        }
    }

    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return x().Q0();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.os0
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            I(ir0.x(LayerEvent.ACTION_ADJUST_VOLUME_COMPLETE));
        }
    }

    public FrameLayout.LayoutParams b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(q21.a(37.0f), q21.a(37.0f));
            layoutParams.gravity = 16;
            layoutParams.leftMargin = q21.b(15.0f);
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeV.objValue;
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.q) {
                this.l.setVisibility(4);
            } else {
                this.l.setVisibility(0);
            }
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.d.sendEmptyMessageDelayed(20, 3000L);
        }
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.n = new wr0(this.c, this);
            this.p = new c(this);
            this.o = new GestureDetector(this.c, this.p);
        }
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (x().Q0() && lp0.R0()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ru0
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.os0
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return x().D();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ss0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return new int[]{4, 2, 3, 5};
        }
        return (int[]) invokeV.objValue;
    }

    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return x().Q0();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.os0
    public Activity o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return t();
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mu0, com.baidu.tieba.eu0, com.baidu.tieba.ru0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            super.onLayerRelease();
            this.n.h();
            this.o.setOnDoubleTapListener(null);
        }
    }

    @Override // com.baidu.tieba.os0
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return x().P();
        }
        return invokeV.booleanValue;
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            ax0.i(this);
        }
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            ax0.k(this);
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.d.removeMessages(20);
            if (this.m.getVisibility() != 0) {
                this.m.setVisibility(0);
                e0();
                return;
            }
            this.m.setVisibility(4);
        }
    }

    @Override // com.baidu.tieba.os0
    public void c(int i, int i2) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
            int s = x().s();
            int k0 = k0(i2 + i, s);
            int i3 = k0 - i;
            if (s >= 3600) {
                z2 = true;
            } else {
                z2 = false;
            }
            String a2 = w01.a(k0, z2);
            String a3 = w01.a(s, z2);
            if (i3 >= 0) {
                this.f.setVisibility(0);
                this.g.setVisibility(8);
                this.f.setMsg(a2, a3);
                this.f.c(k0, s);
                if (Z() == null) {
                    w0(this.f);
                }
            } else {
                this.f.setVisibility(8);
                this.g.setVisibility(0);
                this.g.setMsg(a2, a3);
                this.g.c(k0, s);
                if (Y() == null) {
                    w0(this.g);
                }
            }
            this.g.requestLayout();
            this.f.requestLayout();
            sr0 x2 = ir0.x(LayerEvent.ACTION_POSITION_SLIDE);
            x2.o(2, Integer.valueOf(i));
            x2.o(3, Integer.valueOf(i3));
            I(x2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.eu0, com.baidu.tieba.ss0
    public void d(@NonNull sr0 sr0Var) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, sr0Var) == null) {
            String c3 = sr0Var.c();
            switch (c3.hashCode()) {
                case -1759675333:
                    if (c3.equals(PlayerEvent.ACTION_GO_BACK_OR_FOREGROUND)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -971135626:
                    if (c3.equals(PlayerEvent.ACTION_PLAYER_DETACH)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -882902390:
                    if (c3.equals(PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -525235558:
                    if (c3.equals(PlayerEvent.ACTION_ON_PREPARED)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -461848373:
                    if (c3.equals(PlayerEvent.ACTION_ON_ERROR)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 154871702:
                    if (c3.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1370689931:
                    if (c3.equals(PlayerEvent.ACTION_ON_INFO)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2 && c2 != 3) {
                        if (c2 != 4) {
                            if (c2 == 5 && this.t) {
                                n0();
                                return;
                            }
                            return;
                        }
                        this.l.setProgress(0);
                        return;
                    }
                    t0(false);
                    return;
                }
                this.e.setVisibility(4);
                this.n.g();
                d0();
                return;
            }
            int g = sr0Var.g(1);
            if (701 == g) {
                t0(true);
            } else if (702 == g) {
                t0(false);
            } else if (904 == g || g == 956) {
                t0(false);
                if (i0()) {
                    s0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.os0
    public void f(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048591, this, f) == null) {
            if (x().a1() == 1) {
                x().z().v();
                return;
            }
            int b2 = (int) ((f / uw0.b(this.c)) * 100.0f);
            if (uw0.c(this.c) == 0) {
                b2 = 0;
            }
            if (!this.r) {
                if (b2 == 0) {
                    if (this.i.getVisibility() == 4) {
                        if (this.h.getVisibility() == 0) {
                            this.h.setVisibility(4);
                            this.h.requestLayout();
                        }
                        this.i.setVisibility(0);
                        this.i.requestLayout();
                    }
                } else if (this.h.getVisibility() == 4) {
                    if (this.i.getVisibility() == 0) {
                        this.i.setVisibility(4);
                        this.i.requestLayout();
                    }
                    this.h.setVisibility(0);
                    this.h.requestLayout();
                }
                BdVideoPopImageView bdVideoPopImageView = this.h;
                bdVideoPopImageView.setMsg(b2 + "%");
                BdVideoPopImageView bdVideoPopImageView2 = this.i;
                bdVideoPopImageView2.setMsg(b2 + "%");
            }
            uw0.d(pe0.b(), (int) f);
            sr0 x2 = ir0.x(LayerEvent.ACTION_ADJUST_VOLUME);
            x2.o(20, Integer.valueOf(b2));
            I(x2);
            rw0.b("GestureLayer", "onVolumeSlide : " + f);
        }
    }

    @Override // com.baidu.tieba.os0
    public void i(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048599, this, f) == null) {
            if (x().a1() == 1) {
                x().z().v();
                return;
            }
            this.j.setVisibility(0);
            this.j.requestLayout();
            BdVideoPopImageView bdVideoPopImageView = this.j;
            bdVideoPopImageView.setMsg(((int) ((f / 255.0f) * 100.0f)) + "%");
            s11.d(t(), (int) f);
            I(ir0.x(LayerEvent.ACTION_ADJUST_LIGHT));
            rw0.b("GestureLayer", "onBrightSlide : " + f);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.eu0, com.baidu.tieba.ss0
    public void k(@NonNull sr0 sr0Var) {
        char c2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, sr0Var) == null) {
            String c3 = sr0Var.c();
            int i2 = 4;
            switch (c3.hashCode()) {
                case -1638530599:
                    if (c3.equals(LayerEvent.ACTION_PANEL_VISIBLE_CHANGED)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -997577826:
                    if (c3.equals(LayerEvent.ACTION_CLICK_RETRY)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -552621273:
                    if (c3.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -552580917:
                    if (c3.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 250537257:
                    if (c3.equals(LayerEvent.ACTION_NET_ERROR_SHOW)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 264969781:
                    if (c3.equals(LayerEvent.ACTION_HIDE_CACHE_LOADING)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 665895127:
                    if (c3.equals(LayerEvent.ACTION_BARRAGE_VIEW)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1231554669:
                    if (c3.equals(LayerEvent.ACTION_LOCK_SCREEN)) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1409909918:
                    if (c3.equals(LayerEvent.ACTION_SWITCH_FLOATING)) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    if (BdNetUtils.h()) {
                        t0(true);
                        return;
                    }
                    return;
                case 1:
                    this.m.setVisibility(4);
                    d0();
                    p0();
                    return;
                case 2:
                    r0();
                    return;
                case 3:
                default:
                    return;
                case 4:
                case 5:
                    t0(false);
                    return;
                case 6:
                    this.q = ((Boolean) sr0Var.f(9)).booleanValue();
                    c0();
                    if (x().Q0()) {
                        this.d.removeMessages(20);
                        if (!lp0.R0()) {
                            LockImageView lockImageView = this.m;
                            if (this.q) {
                                i2 = 0;
                            }
                            lockImageView.setVisibility(i2);
                            return;
                        }
                        e0();
                        return;
                    } else if (x().P0()) {
                        this.l.setVisibility(0);
                        return;
                    } else {
                        return;
                    }
                case 7:
                    LockImageView lockImageView2 = this.m;
                    if (lp0.R0()) {
                        i = 1000;
                    } else {
                        i = 2000;
                    }
                    lockImageView2.e(i);
                    return;
                case '\b':
                    this.l.setVisibility(0);
                    this.m.setVisibility(4);
                    return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048611, this, view2) == null) && view2.equals(this.m)) {
            x().V0();
            this.m.b();
            hw0.c().d(ir0.x(LayerEvent.ACTION_LOCK_SCREEN));
            x().z().E(lp0.R0());
        }
    }

    public final void w0(BdVideoSeekbarImageView bdVideoSeekbarImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, bdVideoSeekbarImageView) == null) {
            if (x().Q0()) {
                bdVideoSeekbarImageView.setIconVisible(true);
                bdVideoSeekbarImageView.setWidth(x);
                bdVideoSeekbarImageView.setHeight(y);
                return;
            }
            bdVideoSeekbarImageView.setIconVisible(false);
            bdVideoSeekbarImageView.setWidth(z);
            bdVideoSeekbarImageView.setHeight(A);
        }
    }

    public void u0(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048620, this, i, i2, i3) == null) {
            if (x().n1()) {
                i = x().f1();
                i2 = x().e1();
            }
            this.l.h(i, i2, i3);
        }
    }
}
