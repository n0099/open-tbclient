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
/* loaded from: classes8.dex */
public class xz0 extends tz0 implements View.OnClickListener, vx0 {
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

    public BdVideoSeekbarImageView X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (BdVideoSeekbarImageView) invokeV.objValue;
    }

    public BdVideoSeekbarImageView Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (BdVideoSeekbarImageView) invokeV.objValue;
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final int j0(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048602, this, i, i2)) == null) {
            if (i < 0) {
                return 0;
            }
            return i > i2 ? i2 : i;
        }
        return invokeII.intValue;
    }

    public boolean k0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz0 a;

        public a(xz0 xz0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.t) {
                xz0 xz0Var = this.a;
                xz0Var.p0(Math.max(0, xz0Var.getCurrentPosition() - 5));
                Handler handler = this.a.d;
                if (handler != null) {
                    handler.postDelayed(this, 1000L);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends FrameLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz0 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(xz0 xz0Var, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz0Var, context};
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
            this.a = xz0Var;
        }

        @Override // android.view.View
        public void onConfigurationChanged(Configuration configuration) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, configuration) == null) {
                super.onConfigurationChanged(configuration);
                xz0 xz0Var = this.a;
                Context context = xz0Var.c;
                if (context != null) {
                    xz0Var.n.f(context);
                }
                if (!this.a.t) {
                    return;
                }
                this.a.m0();
            }
        }

        @Override // android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                if (this.a.u().p1()) {
                    return super.onTouchEvent(motionEvent);
                }
                if (this.a.t) {
                    if (motionEvent.getAction() == 1 || !this.a.u().Y()) {
                        this.a.m0();
                    }
                    return true;
                } else if (this.a.u().V0() && !ru0.W0() && this.a.u().A() != null && this.a.u().A().getContentView() != null && this.a.u().A().Q() != null && this.a.u().A().getContentView().onTouchEvent(motionEvent)) {
                    return true;
                } else {
                    if (this.a.n0() && getParent() != null) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    IVideoUpdateStrategy n1 = this.a.u().n1();
                    if (!n1.b()) {
                        return super.onTouchEvent(motionEvent);
                    }
                    if (!n1.d()) {
                        return false;
                    }
                    boolean V0 = this.a.u().V0();
                    if (this.a.u().o1() != null) {
                        this.a.u().o1().getPage();
                    }
                    if (V0 && !this.a.i0() && this.a.l0(motionEvent)) {
                        return true;
                    }
                    if (this.a.o.onTouchEvent(motionEvent) && this.a.U()) {
                        return true;
                    }
                    if (!ru0.W0() && this.a.g0()) {
                        if (!this.a.u().V0()) {
                            this.a.W(motionEvent);
                        }
                        if (this.a.i0()) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                            return true;
                        } else if (this.a.n.b(motionEvent)) {
                            return true;
                        }
                    }
                    if (motionEvent.getAction() == 0) {
                        return this.a.k0(motionEvent);
                    }
                    return super.onTouchEvent(motionEvent);
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz0 a;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        public c(xz0 xz0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz0Var;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
                fu0 u = this.a.u();
                if (u != null && u.y() != null && !ru0.W0()) {
                    return u.y().x(motionEvent);
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
                xz0 xz0Var = this.a;
                boolean z = false;
                if (xz0Var.e != null) {
                    if (xz0Var.u().W()) {
                        this.a.u().l0();
                    }
                    if (!this.a.u().Y()) {
                        return;
                    }
                    if (this.a.e.getParent() != null) {
                        this.a.e.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    this.a.t = true;
                    if (this.a.u().V0() && ru0.W0()) {
                        if (this.a.m.getVisibility() == 0) {
                            this.a.u0();
                        }
                    } else {
                        this.a.H(ow0.w(LayerEvent.ACTION_LONG_PRESS));
                    }
                    if (motionEvent.getX() > this.a.e.getWidth() / 2.0d) {
                        z = true;
                    }
                    if (z) {
                        this.a.v = "speed";
                        this.a.u().z0(this.a.Z());
                    } else {
                        this.a.v = "backward";
                        xz0 xz0Var2 = this.a;
                        xz0Var2.d.post(xz0Var2.w);
                    }
                    if (this.a.u().y() != null) {
                        this.a.u().y().D(z, true);
                        return;
                    }
                    return;
                }
                xz0Var.t = false;
            }
        }

        public final boolean b(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                if (!this.a.u().Q() && !this.a.u().R()) {
                    if (this.a.f0()) {
                        c(motionEvent);
                    } else {
                        this.a.u0();
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
                if (motionEvent.getAction() != 0 || this.a.u().Q()) {
                    return false;
                }
                this.a.H(ow0.w(LayerEvent.ACTION_TOUCH_DOWN));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948317531, "Lcom/baidu/tieba/xz0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948317531, "Lcom/baidu/tieba/xz0;");
                return;
            }
        }
        x = q71.a(124.0f);
        y = q71.a(85.0f);
        z = q71.a(119.0f);
        A = q71.a(50.0f);
    }

    public xz0() {
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

    public final float Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            this.u = u().G();
            float min = Math.min(this.u * t21.i(), t21.h());
            if (min <= 0.0f) {
                return this.u;
            }
            return min;
        }
        return invokeV.floatValue;
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f.setVisibility(4);
            this.g.setVisibility(4);
            if (!this.r) {
                this.h.setVisibility(4);
                this.i.setVisibility(4);
            }
            this.j.setVisibility(4);
            H(ow0.w(LayerEvent.ACTION_POSITION_SLIDE_COMPLETE));
        }
    }

    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (U() && t21.q() && V() && u().r() >= 60) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.t = false;
            boolean equals = TextUtils.equals(this.v, "speed");
            if (equals) {
                u().z0(this.u);
            } else {
                this.d.removeCallbacks(this.w);
            }
            if (u().y() != null) {
                u().y().D(equals, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xz0(@NonNull Activity activity) {
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

    @Override // com.baidu.tieba.lz0, com.baidu.tieba.zx0
    public void q(@NonNull yw0 yw0Var) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, yw0Var) == null) {
            String c3 = yw0Var.c();
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
            t0(yw0Var.g(1), yw0Var.g(2), yw0Var.g(3));
        }
    }

    @Override // com.baidu.tieba.lz0
    public void B(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            super.B(message);
            if (message != null && message.what == 20 && !this.q) {
                this.m.setVisibility(4);
                this.d.removeMessages(20);
            }
        }
    }

    public final boolean l0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, motionEvent)) == null) {
            if (ru0.W0()) {
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.vx0
    public void m(BdVideoGesture.VideoPluginGesture videoPluginGesture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, videoPluginGesture) == null) {
            c0();
            if (videoPluginGesture == BdVideoGesture.VideoPluginGesture.InitChange) {
                u().y().w();
            } else {
                u().y().v();
            }
        }
    }

    public final void p0(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            int r = u().r();
            if (r > 1 && i > (i2 = r - 1)) {
                i = i2;
            }
            u().o0(i);
        }
    }

    public void s0(boolean z2) {
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

    @Override // com.baidu.tieba.lz0, com.baidu.tieba.zx0
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            if (playerStatus == PlayerStatus.PLAYING) {
                this.e.setVisibility(0);
                s0(false);
            } else if (playerStatus == PlayerStatus.PREPARING) {
                s0(true);
                this.e.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.vx0
    public void l(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            p0((int) (i + f));
        }
    }

    @Override // com.baidu.tieba.lz0
    public void D() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            e0();
            this.e = new b(this, this.c);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(q71.a(300.0f), q71.a(300.0f));
            this.k = new BdVideoNewCacheView(this.c);
            s0(false);
            layoutParams.gravity = 17;
            this.e.addView(this.k, layoutParams);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 80;
            layoutParams2.bottomMargin = q71.b(-4.3f);
            BdThumbSeekBar bdThumbSeekBar = new BdThumbSeekBar(this.c, 2);
            this.l = bdThumbSeekBar;
            bdThumbSeekBar.setThumbScaleVisible(false);
            this.l.setDragable(false);
            this.e.addView(this.l, layoutParams2);
            LockImageView lockImageView = new LockImageView(this.c);
            this.m = lockImageView;
            lockImageView.setBackground(this.c.getResources().getDrawable(R.drawable.nad_videoplayer_playbtn_bg));
            LockImageView lockImageView2 = this.m;
            if (ru0.W0()) {
                i = 1000;
            } else {
                i = 2000;
            }
            lockImageView2.e(i);
            this.m.setOnClickListener(this);
            this.m.setVisibility(4);
            this.e.addView(this.m, a0());
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            layoutParams3.gravity = 17;
            BdVideoSeekbarImageView Y = Y();
            this.f = Y;
            if (Y == null) {
                BdVideoSeekbarImageView bdVideoSeekbarImageView = new BdVideoSeekbarImageView(this.c);
                this.f = bdVideoSeekbarImageView;
                bdVideoSeekbarImageView.setIcon(R.drawable.nad_videoplayer_player_seek_forward);
                this.f.setWidth(q71.a(124.0f));
                this.f.setHeight(q71.a(85.0f));
            }
            this.f.setVisibility(4);
            this.e.addView(this.f, layoutParams3);
            BdVideoSeekbarImageView X = X();
            this.g = X;
            if (X == null) {
                BdVideoSeekbarImageView bdVideoSeekbarImageView2 = new BdVideoSeekbarImageView(this.c);
                this.g = bdVideoSeekbarImageView2;
                bdVideoSeekbarImageView2.setIcon(R.drawable.nad_videoplayer_player_seek_back);
                this.g.setWidth(q71.a(124.0f));
                this.g.setHeight(q71.a(85.0f));
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
            return u().V0();
        }
        return invokeV.booleanValue;
    }

    public FrameLayout.LayoutParams a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(q71.a(37.0f), q71.a(37.0f));
            layoutParams.gravity = 16;
            layoutParams.leftMargin = q71.b(15.0f);
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vx0
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            H(ow0.w(LayerEvent.ACTION_ADJUST_VOLUME_COMPLETE));
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.q) {
                this.l.setVisibility(4);
            } else {
                this.l.setVisibility(0);
            }
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.d.sendEmptyMessageDelayed(20, 3000L);
        }
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.n = new cx0(this.c, this);
            this.p = new c(this);
            this.o = new GestureDetector(this.c, this.p);
        }
    }

    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (u().V0() && ru0.W0()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return u().V0();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yz0
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vx0
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return u().C();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.zx0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return new int[]{4, 2, 3, 5};
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vx0
    public Activity o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return getActivity();
        }
        return (Activity) invokeV.objValue;
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            s21.i(this);
        }
    }

    @Override // com.baidu.tieba.tz0, com.baidu.tieba.lz0, com.baidu.tieba.yz0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onLayerRelease();
            this.n.h();
            this.o.setOnDoubleTapListener(null);
        }
    }

    @Override // com.baidu.tieba.vx0
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return u().Q();
        }
        return invokeV.booleanValue;
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            s21.k(this);
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.d.removeMessages(20);
            if (this.m.getVisibility() != 0) {
                this.m.setVisibility(0);
                d0();
                return;
            }
            this.m.setVisibility(4);
        }
    }

    @Override // com.baidu.tieba.vx0
    public void c(int i, int i2) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
            int r = u().r();
            int j0 = j0(i2 + i, r);
            int i3 = j0 - i;
            if (r >= 3600) {
                z2 = true;
            } else {
                z2 = false;
            }
            String a2 = a61.a(j0, z2);
            String a3 = a61.a(r, z2);
            if (i3 >= 0) {
                this.f.setVisibility(0);
                this.g.setVisibility(8);
                this.f.setMsg(a2, a3);
                this.f.c(j0, r);
                if (Y() == null) {
                    v0(this.f);
                }
            } else {
                this.f.setVisibility(8);
                this.g.setVisibility(0);
                this.g.setMsg(a2, a3);
                this.g.c(j0, r);
                if (X() == null) {
                    v0(this.g);
                }
            }
            this.g.requestLayout();
            this.f.requestLayout();
            yw0 w = ow0.w(LayerEvent.ACTION_POSITION_SLIDE);
            w.n(2, Integer.valueOf(i));
            w.n(3, Integer.valueOf(i3));
            H(w);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.lz0, com.baidu.tieba.zx0
    public void d(@NonNull yw0 yw0Var) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, yw0Var) == null) {
            String c3 = yw0Var.c();
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
                                m0();
                                return;
                            }
                            return;
                        }
                        this.l.setProgress(0);
                        return;
                    }
                    s0(false);
                    return;
                }
                this.e.setVisibility(4);
                this.n.g();
                c0();
                return;
            }
            int g = yw0Var.g(1);
            if (701 == g) {
                s0(true);
            } else if (702 == g) {
                s0(false);
            } else if (904 == g || g == 956) {
                s0(false);
                if (h0()) {
                    r0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.vx0
    public void f(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f) == null) {
            if (u().f1() == 1) {
                u().y().v();
                return;
            }
            int b2 = (int) ((f / l21.b(this.c)) * 100.0f);
            if (l21.c(this.c) == 0) {
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
            l21.d(ok0.b(), (int) f);
            yw0 w = ow0.w(LayerEvent.ACTION_ADJUST_VOLUME);
            w.n(20, Integer.valueOf(b2));
            H(w);
            i21.b("GestureLayer", "onVolumeSlide : " + f);
        }
    }

    @Override // com.baidu.tieba.vx0
    public void i(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048600, this, f) == null) {
            if (u().f1() == 1) {
                u().y().v();
                return;
            }
            this.j.setVisibility(0);
            this.j.requestLayout();
            BdVideoPopImageView bdVideoPopImageView = this.j;
            bdVideoPopImageView.setMsg(((int) ((f / 255.0f) * 100.0f)) + "%");
            u61.d(getActivity(), (int) f);
            H(ow0.w(LayerEvent.ACTION_ADJUST_LIGHT));
            i21.b("GestureLayer", "onBrightSlide : " + f);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.lz0, com.baidu.tieba.zx0
    public void k(@NonNull yw0 yw0Var) {
        char c2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, yw0Var) == null) {
            String c3 = yw0Var.c();
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
                        s0(true);
                        return;
                    }
                    return;
                case 1:
                    this.m.setVisibility(4);
                    c0();
                    o0();
                    return;
                case 2:
                    q0();
                    return;
                case 3:
                default:
                    return;
                case 4:
                case 5:
                    s0(false);
                    return;
                case 6:
                    this.q = ((Boolean) yw0Var.f(9)).booleanValue();
                    b0();
                    if (u().V0()) {
                        this.d.removeMessages(20);
                        if (!ru0.W0()) {
                            LockImageView lockImageView = this.m;
                            if (this.q) {
                                i2 = 0;
                            }
                            lockImageView.setVisibility(i2);
                            return;
                        }
                        d0();
                        return;
                    } else if (u().U0()) {
                        this.l.setVisibility(0);
                        return;
                    } else {
                        return;
                    }
                case 7:
                    LockImageView lockImageView2 = this.m;
                    if (ru0.W0()) {
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
        if ((interceptable == null || interceptable.invokeL(1048612, this, view2) == null) && view2.equals(this.m)) {
            u().a1();
            this.m.b();
            t11.c().d(ow0.w(LayerEvent.ACTION_LOCK_SCREEN));
            u().y().E(ru0.W0());
        }
    }

    public final void v0(BdVideoSeekbarImageView bdVideoSeekbarImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, bdVideoSeekbarImageView) == null) {
            if (u().V0()) {
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

    public void t0(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048620, this, i, i2, i3) == null) {
            if (u().r1()) {
                i = u().k1();
                i2 = u().j1();
            }
            this.l.h(i, i2, i3);
        }
    }
}
