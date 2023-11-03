package com.baidu.tieba.view.widget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.nsb;
import com.baidu.tieba.p5b;
import com.baidu.tieba.view.capture.camera.AspectGLSurfaceView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
/* loaded from: classes8.dex */
public class RecordPreviewContainer extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public float b;
    public int c;
    public int d;
    public long e;
    public long f;
    public boolean g;
    public boolean h;
    public boolean i;
    public float j;
    public float k;
    public float l;
    public float m;
    public int n;
    public Handler o;
    public Runnable p;
    public Context q;
    public FocusCircleView r;
    public ImageView s;
    public AspectGLSurfaceView t;
    public f u;
    public g v;
    public boolean w;

    /* loaded from: classes8.dex */
    public interface e {
    }

    /* loaded from: classes8.dex */
    public interface f {
        void a(MotionEvent motionEvent, int i);

        void b(MotionEvent motionEvent, int i, int i2, int i3, int i4);

        void c();
    }

    /* loaded from: classes8.dex */
    public interface g {
        void a(MotionEvent motionEvent);

        void b(MotionEvent motionEvent);

        void c(MotionEvent motionEvent, float f, float f2);

        void d(MotionEvent motionEvent);
    }

    public void setOnFollowControlClickListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, eVar) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordPreviewContainer a;

        public a(RecordPreviewContainer recordPreviewContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordPreviewContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recordPreviewContainer;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.n();
            this.a.m();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordPreviewContainer a;

        public b(RecordPreviewContainer recordPreviewContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordPreviewContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recordPreviewContainer;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) != null) {
                return invokeLL.booleanValue;
            }
            this.a.l(motionEvent);
            return true;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MotionEvent a;
        public final /* synthetic */ RecordPreviewContainer b;

        public c(RecordPreviewContainer recordPreviewContainer, MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordPreviewContainer, motionEvent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = recordPreviewContainer;
            this.a = motionEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.b.v == null) {
                return;
            }
            g gVar = this.b.v;
            MotionEvent motionEvent = this.a;
            gVar.c(motionEvent, motionEvent.getX(), this.a.getY());
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MotionEvent a;
        public final /* synthetic */ RecordPreviewContainer b;

        public d(RecordPreviewContainer recordPreviewContainer, MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordPreviewContainer, motionEvent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = recordPreviewContainer;
            this.a = motionEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.b.g && this.b.h && Math.abs(this.b.l - this.a.getX()) < 30.0f && this.b.v != null) {
                this.b.v.d(this.a);
            }
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final float p(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, motionEvent)) == null) {
            if (motionEvent == null) {
                return 0.0f;
            }
            double x = motionEvent.getX(0) - motionEvent.getX(1);
            double y = motionEvent.getY(0) - motionEvent.getY(1);
            return (float) Math.sqrt((x * x) + (y * y));
        }
        return invokeL.floatValue;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordPreviewContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.i = true;
        this.w = false;
        this.q = context;
    }

    public void h(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            view2.setOnTouchListener(new b(this));
        }
    }

    public void setCanDragTo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.i = z;
        }
    }

    public void setFollowControlVisible(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            ImageView imageView = this.s;
            if (imageView != null) {
                if (z) {
                    i = 0;
                } else {
                    i = 8;
                }
                imageView.setVisibility(i);
            } else if (z) {
                n();
            }
        }
    }

    public void setOnPreviewStateChangedListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, fVar) == null) {
            this.u = fVar;
        }
    }

    public void setOnViewClickListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, gVar) == null) {
            this.v = gVar;
        }
    }

    public void setSurfaceView(AspectGLSurfaceView aspectGLSurfaceView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, aspectGLSurfaceView) == null) {
            this.t = aspectGLSurfaceView;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            aspectGLSurfaceView.setLayoutParams(layoutParams);
            addView(aspectGLSurfaceView);
        }
    }

    public FocusCircleView getFocusView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.r;
        }
        return (FocusCircleView) invokeV.objValue;
    }

    public AspectGLSurfaceView getSurfaceView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.t;
        }
        return (AspectGLSurfaceView) invokeV.objValue;
    }

    public final void m() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.r == null) {
            FocusCircleView focusCircleView = new FocusCircleView(getContext());
            this.r = focusCircleView;
            if (getChildCount() > 0) {
                i = 1;
            } else {
                i = 0;
            }
            addView(focusCircleView, i);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.o.removeCallbacks(this.p);
        }
    }

    public final void i(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, motionEvent) == null) && !this.g && this.h && Math.abs(this.l - motionEvent.getX()) < 30.0f && Math.abs(this.m - motionEvent.getY()) < 30.0f) {
            this.o.removeCallbacks(this.p);
            d dVar = new d(this, MotionEvent.obtain(motionEvent));
            this.p = dVar;
            this.o.postDelayed(dVar, 300L);
        }
    }

    public final boolean j(MotionEvent motionEvent) {
        InterceptResult invokeL;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            if (this.g) {
                if (Math.abs(this.k - motionEvent.getX()) < this.n && Math.abs(this.j - motionEvent.getY()) < this.n) {
                    this.o.postDelayed(new c(this, motionEvent), 200L);
                    return true;
                }
            } else if (!this.i) {
                return false;
            } else {
                if (Math.abs(this.l - motionEvent.getX()) > this.n && (this.l - motionEvent.getX()) - 50.0f > Math.abs(this.m - motionEvent.getY())) {
                    g gVar2 = this.v;
                    if (gVar2 != null) {
                        gVar2.b(motionEvent);
                        return true;
                    }
                } else if (Math.abs(this.l - motionEvent.getX()) > this.n && (motionEvent.getX() - this.l) - 50.0f > Math.abs(this.m - motionEvent.getY()) && (gVar = this.v) != null) {
                    gVar.a(motionEvent);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean k(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 1) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y > this.c || x < nsb.k(R.dimen.obfuscated_res_0x7f070258)) {
                    return true;
                }
                int a2 = p5b.a(x, Cea708Decoder.COMMAND_DF2, this.d - Cea708Decoder.COMMAND_DF2);
                int a3 = p5b.a(y, Cea708Decoder.COMMAND_DF2, this.c - Cea708Decoder.COMMAND_DF2);
                f fVar = this.u;
                if (fVar != null) {
                    fVar.b(motionEvent, 308, 308, a2, a3);
                }
                if (this.r == null) {
                    m();
                }
                int equipmentWidth = BdUtilHelper.getEquipmentWidth(getContext());
                int equipmentHeight = BdUtilHelper.getEquipmentHeight(getContext());
                this.r.setTranslationX(motionEvent.getX() - (equipmentWidth * 0.5f));
                this.r.setTranslationY(motionEvent.getY() - (equipmentHeight * 0.5f));
                this.r.d();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean l(MotionEvent motionEvent) {
        InterceptResult invokeL;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        if (action != 3) {
                            if (action == 5) {
                                this.a = 1;
                                this.b = p(motionEvent);
                            }
                        }
                    } else if (this.a == 1) {
                        if (motionEvent.getPointerCount() < 2) {
                            return false;
                        }
                        float p = p(motionEvent);
                        int i = (int) ((p - this.b) / 100.0f);
                        if ((i >= 1 || i <= -1) && (fVar = this.u) != null) {
                            this.w = true;
                            fVar.a(motionEvent, i);
                            this.b = p;
                        }
                    } else if (Math.abs(this.l - motionEvent.getX()) > this.n || Math.abs(this.m - motionEvent.getY()) > this.n) {
                        o();
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.e < 100 && currentTimeMillis - this.f < 500) {
                    this.g = true;
                } else {
                    this.g = false;
                }
                if (!this.w) {
                    if (!j(motionEvent)) {
                        i(motionEvent);
                    } else {
                        o();
                    }
                }
                f fVar2 = this.u;
                if (fVar2 != null && this.w) {
                    this.w = false;
                    fVar2.c();
                }
                this.f = currentTimeMillis;
            } else {
                float x = motionEvent.getX();
                this.l = x;
                this.k = x;
                float y = motionEvent.getY();
                this.m = y;
                this.j = y;
                this.a = 0;
                this.e = System.currentTimeMillis();
                this.h = true;
                this.g = false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || this.s != null) {
            return;
        }
        ImageView imageView = new ImageView(getContext());
        this.s = imageView;
        imageView.setImageResource(R.drawable.obfuscated_res_0x7f080c95);
        if (this.s != null) {
            int width = getWidth();
            int width2 = this.s.getWidth();
            int i = this.d;
            int i2 = (((i * 3) / 4) - (width2 / 2)) + ((width - i) / 2);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds44), UtilHelper.getDimenPixelSize(R.dimen.tbds52));
            layoutParams.gravity = 17;
            layoutParams.leftMargin = i2;
            this.s.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onFinishInflate();
            this.n = ViewConfiguration.get(getContext()).getScaledPagingTouchSlop();
            this.d = BdUtilHelper.getEquipmentWidth(getContext());
            this.c = BdUtilHelper.getEquipmentHeight(getContext());
            this.o = new Handler();
            postDelayed(new a(this), 4000L);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
            super.onMeasure(i, i2);
            int size = View.MeasureSpec.getSize(i2);
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(getContext());
            int equipmentHeight = BdUtilHelper.getEquipmentHeight(getContext());
            if ((equipmentWidth * 1.0f) / equipmentHeight > 0.5625f) {
                setMeasuredDimension((int) ((size * 9.0f) / 16.0f), size);
            } else {
                setMeasuredDimension(equipmentWidth, equipmentHeight);
            }
        }
    }
}
