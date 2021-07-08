package com.baidu.tieba.view.widget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.view.capture.camera.AspectGLSurfaceView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.v0.t.t;
/* loaded from: classes4.dex */
public class RecordPreviewContainer extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;

    /* renamed from: e  reason: collision with root package name */
    public int f22367e;

    /* renamed from: f  reason: collision with root package name */
    public float f22368f;

    /* renamed from: g  reason: collision with root package name */
    public int f22369g;

    /* renamed from: h  reason: collision with root package name */
    public int f22370h;

    /* renamed from: i  reason: collision with root package name */
    public long f22371i;
    public long j;
    public boolean k;
    public boolean l;
    public boolean m;
    public float n;
    public float o;
    public float p;
    public float q;
    public int r;
    public Handler s;
    public Runnable t;
    public Context u;
    public FocusCircleView v;
    public ImageView w;
    public AspectGLSurfaceView x;
    public e y;
    public f z;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecordPreviewContainer f22372e;

        public a(RecordPreviewContainer recordPreviewContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordPreviewContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22372e = recordPreviewContainer;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22372e.l();
                this.f22372e.k();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MotionEvent f22373e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RecordPreviewContainer f22374f;

        public b(RecordPreviewContainer recordPreviewContainer, MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordPreviewContainer, motionEvent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22374f = recordPreviewContainer;
            this.f22373e = motionEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22374f.z == null) {
                return;
            }
            f fVar = this.f22374f.z;
            MotionEvent motionEvent = this.f22373e;
            fVar.c(motionEvent, motionEvent.getX(), this.f22373e.getY());
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MotionEvent f22375e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RecordPreviewContainer f22376f;

        public c(RecordPreviewContainer recordPreviewContainer, MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordPreviewContainer, motionEvent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22376f = recordPreviewContainer;
            this.f22375e = motionEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22376f.k || !this.f22376f.l || Math.abs(this.f22376f.p - this.f22375e.getX()) >= 30.0f || this.f22376f.z == null) {
                return;
            }
            this.f22376f.z.d(this.f22375e);
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(MotionEvent motionEvent, int i2);

        void b(MotionEvent motionEvent, int i2, int i3, int i4, int i5);

        void c();
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(MotionEvent motionEvent);

        void b(MotionEvent motionEvent);

        void c(MotionEvent motionEvent, float f2, float f3);

        void d(MotionEvent motionEvent);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecordPreviewContainer(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void g(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) || this.k || !this.l || Math.abs(this.p - motionEvent.getX()) >= 30.0f || Math.abs(this.q - motionEvent.getY()) >= 30.0f) {
            return;
        }
        this.s.removeCallbacks(this.t);
        c cVar = new c(this, MotionEvent.obtain(motionEvent));
        this.t = cVar;
        this.s.postDelayed(cVar, 300L);
    }

    public FocusCircleView getFocusView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.v : (FocusCircleView) invokeV.objValue;
    }

    public AspectGLSurfaceView getSurfaceView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.x : (AspectGLSurfaceView) invokeV.objValue;
    }

    public final boolean h(MotionEvent motionEvent) {
        InterceptResult invokeL;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
            if (this.k) {
                if (Math.abs(this.o - motionEvent.getX()) < this.r && Math.abs(this.n - motionEvent.getY()) < this.r) {
                    this.s.postDelayed(new b(this, motionEvent), 200L);
                    return true;
                }
            } else if (!this.m) {
                return false;
            } else {
                if (Math.abs(this.p - motionEvent.getX()) > this.r && (this.p - motionEvent.getX()) - 50.0f > Math.abs(this.q - motionEvent.getY())) {
                    f fVar2 = this.z;
                    if (fVar2 != null) {
                        fVar2.b(motionEvent);
                        return true;
                    }
                } else if (Math.abs(this.p - motionEvent.getX()) > this.r && (motionEvent.getX() - this.p) - 50.0f > Math.abs(this.q - motionEvent.getY()) && (fVar = this.z) != null) {
                    fVar.a(motionEvent);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean i(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 1) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y > this.f22369g || x < t.k(R.dimen.ds64)) {
                    return true;
                }
                int a2 = d.a.p0.z3.k.a.h.a.a(x, Opcodes.IFNE, this.f22370h - Opcodes.IFNE);
                int a3 = d.a.p0.z3.k.a.h.a.a(y, Opcodes.IFNE, this.f22369g - Opcodes.IFNE);
                e eVar = this.y;
                if (eVar != null) {
                    eVar.b(motionEvent, 308, 308, a2, a3);
                }
                if (this.v == null) {
                    k();
                }
                int k = l.k(getContext());
                int i2 = l.i(getContext());
                this.v.setTranslationX(motionEvent.getX() - (k * 0.5f));
                this.v.setTranslationY(motionEvent.getY() - (i2 * 0.5f));
                this.v.d();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean j(MotionEvent motionEvent) {
        InterceptResult invokeL;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        if (action != 3) {
                            if (action == 5) {
                                this.f22367e = 1;
                                this.f22368f = n(motionEvent);
                            }
                        }
                    } else if (this.f22367e == 1) {
                        if (motionEvent.getPointerCount() < 2) {
                            return false;
                        }
                        float n = n(motionEvent);
                        int i2 = (int) ((n - this.f22368f) / 100.0f);
                        if ((i2 >= 1 || i2 <= -1) && (eVar = this.y) != null) {
                            this.A = true;
                            eVar.a(motionEvent, i2);
                            this.f22368f = n;
                        }
                    } else if (Math.abs(this.p - motionEvent.getX()) > this.r || Math.abs(this.q - motionEvent.getY()) > this.r) {
                        m();
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f22371i < 100 && currentTimeMillis - this.j < 500) {
                    this.k = true;
                } else {
                    this.k = false;
                }
                if (!this.A) {
                    if (!h(motionEvent)) {
                        g(motionEvent);
                    } else {
                        m();
                    }
                }
                e eVar2 = this.y;
                if (eVar2 != null && this.A) {
                    this.A = false;
                    eVar2.c();
                }
                this.j = currentTimeMillis;
            } else {
                float x = motionEvent.getX();
                this.p = x;
                this.o = x;
                float y = motionEvent.getY();
                this.q = y;
                this.n = y;
                this.f22367e = 0;
                this.f22371i = System.currentTimeMillis();
                this.l = true;
                this.k = false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.v == null) {
            FocusCircleView focusCircleView = new FocusCircleView(getContext());
            this.v = focusCircleView;
            addView(focusCircleView, getChildCount() > 0 ? 1 : 0);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.w == null) {
            ImageView imageView = new ImageView(getContext());
            this.w = imageView;
            imageView.setImageResource(R.drawable.icon_replication_play);
            if (this.w != null) {
                int width = getWidth();
                int width2 = this.w.getWidth();
                int i2 = this.f22370h;
                int i3 = (((i2 * 3) / 4) - (width2 / 2)) + ((width - i2) / 2);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds44), UtilHelper.getDimenPixelSize(R.dimen.tbds52));
                layoutParams.gravity = 17;
                layoutParams.leftMargin = i3;
                this.w.setLayoutParams(layoutParams);
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.s.removeCallbacks(this.t);
        }
    }

    public final float n(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            if (motionEvent == null) {
                return 0.0f;
            }
            double x = motionEvent.getX(0) - motionEvent.getX(1);
            double y = motionEvent.getY(0) - motionEvent.getY(1);
            return (float) Math.sqrt((x * x) + (y * y));
        }
        return invokeL.floatValue;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onFinishInflate();
            this.r = ViewConfiguration.get(getContext()).getScaledPagingTouchSlop();
            this.f22370h = l.k(getContext());
            this.f22369g = l.i(getContext());
            this.x = (AspectGLSurfaceView) findViewById(R.id.capture_surface_view);
            this.s = new Handler();
            postDelayed(new a(this), PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, motionEvent)) == null) {
            j(motionEvent);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setCanDragTo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.m = z;
        }
    }

    public void setFollowControlVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            ImageView imageView = this.w;
            if (imageView != null) {
                imageView.setVisibility(z ? 0 : 8);
            } else if (z) {
                l();
            }
        }
    }

    public void setOnFollowControlClickListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, dVar) == null) {
        }
    }

    public void setOnPreviewStateChangedListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, eVar) == null) {
            this.y = eVar;
        }
    }

    public void setOnViewClickListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, fVar) == null) {
            this.z = fVar;
        }
    }

    public void setSurfaceView(AspectGLSurfaceView aspectGLSurfaceView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aspectGLSurfaceView) == null) {
            this.x = aspectGLSurfaceView;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecordPreviewContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordPreviewContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f22367e = 0;
        this.m = true;
        this.A = false;
        this.u = context;
    }
}
