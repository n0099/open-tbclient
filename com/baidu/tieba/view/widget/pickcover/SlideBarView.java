package com.baidu.tieba.view.widget.pickcover;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class SlideBarView extends View implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f58281e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f58282f;

    /* renamed from: g  reason: collision with root package name */
    public float f58283g;

    /* renamed from: h  reason: collision with root package name */
    public float f58284h;

    /* renamed from: i  reason: collision with root package name */
    public float f58285i;

    /* renamed from: j  reason: collision with root package name */
    public GestureDetector f58286j;
    public c k;
    public Bitmap l;
    public int m;
    public int n;
    public int o;
    public int p;
    public Rect q;
    public RectF r;
    public Paint s;
    public float t;
    public long u;
    public Matrix v;
    public boolean w;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public final class b extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SlideBarView f58287e;

        public b(SlideBarView slideBarView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {slideBarView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58287e = slideBarView;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                this.f58287e.moveToPosition(motionEvent2);
                return true;
            }
            return invokeCommon.booleanValue;
        }

        public /* synthetic */ b(SlideBarView slideBarView, a aVar) {
            this(slideBarView);
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(float f2);

        void onProgress(float f2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlideBarView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58281e = R.drawable.pick_cover_slide;
        this.f58285i = 12.0f;
        this.q = new Rect();
        this.r = new RectF();
        this.s = new Paint();
    }

    private float getRealLeftRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            float f2 = this.f58283g;
            float f3 = this.f58285i;
            if (f2 - f3 < 0.0f) {
                return 0.0f;
            }
            return f2 - f3;
        }
        return invokeV.floatValue;
    }

    private float getRealRightRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            float f2 = this.f58284h;
            float f3 = this.f58285i;
            if (f2 + f3 < 0.0f) {
                return 0.0f;
            }
            return f2 + f3;
        }
        return invokeV.floatValue;
    }

    private float getRealSlideRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) ? getRealRightRange() - getRealLeftRange() : invokeV.floatValue;
    }

    public final void a(Context context, AttributeSet attributeSet, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048576, this, context, attributeSet, i2, i3) == null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.SlideBarView, i2, i3);
            this.f58285i = obtainStyledAttributes.getDimension(R$styleable.SlideBarView_borderSize, 12.0f);
            obtainStyledAttributes.recycle();
            this.s.setAntiAlias(true);
        }
    }

    public final void b(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
            float width = f2 - (getWidth() / 2.0f);
            if (width < getRealLeftRange()) {
                setX(getRealLeftRange());
            } else if (width > getRealRightRange()) {
                setX(getRealRightRange());
            } else {
                setX(width);
            }
        }
    }

    public final void c(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) {
            float realLeftRange = (f2 - getRealLeftRange()) - (getWidth() / 2.0f);
            float realSlideRange = getRealSlideRange();
            if (realLeftRange < 0.0f) {
                realLeftRange = 0.0f;
            } else if (realLeftRange >= realSlideRange) {
                realLeftRange = realSlideRange;
            }
            this.t = realLeftRange / realSlideRange;
        }
    }

    public float getCurrentPercent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.t : invokeV.floatValue;
    }

    public void moveToPosition(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, motionEvent) == null) {
            moveToPosition(motionEvent.getRawX());
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            Drawable drawable = getResources().getDrawable(this.f58281e);
            this.f58282f = drawable;
            int i2 = this.o;
            float f4 = this.f58285i;
            drawable.setBounds(0, 0, i2 + ((int) f4), this.p + ((int) f4));
            if (this.w) {
                if (this.l != null) {
                    if (this.v == null) {
                        this.v = new Matrix();
                    }
                    this.v.reset();
                    int i3 = this.m;
                    int i4 = this.n;
                    int i5 = this.o;
                    int i6 = this.p;
                    float f5 = 0.0f;
                    if (i3 * i6 > i5 * i4) {
                        f3 = i6 / i4;
                        f5 = (i5 - (i3 * f3)) * 0.5f;
                        f2 = 0.0f;
                    } else {
                        float f6 = i5 / i3;
                        f2 = (i6 - (i4 * f6)) * 0.5f;
                        f3 = f6;
                    }
                    this.v.setScale(f3, f3);
                    Matrix matrix = this.v;
                    float f7 = this.f58285i;
                    matrix.postTranslate(f5 + (f7 / 2.0f), f2 + (f7 / 2.0f));
                    if (!this.l.isRecycled()) {
                        canvas.drawBitmap(this.l, this.v, this.s);
                    }
                }
                this.f58282f.draw(canvas);
                return;
            }
            float f8 = this.o / this.p;
            int i7 = this.m;
            int i8 = this.n;
            if (f8 > i7 / i8) {
                i8 = (int) (i7 / f8);
            } else {
                i7 = (int) (i8 * f8);
            }
            this.q.set(0, 0, i7, i8);
            RectF rectF = this.r;
            float f9 = this.f58285i;
            rectF.set(f9, f9, this.o, this.p);
            Bitmap bitmap = this.l;
            if (bitmap != null && !bitmap.isRecycled()) {
                canvas.drawBitmap(this.l, this.q, this.r, this.s);
                this.f58282f.draw(canvas);
                return;
            }
            this.f58282f.draw(canvas);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onFinishInflate();
            setOnTouchListener(this);
            this.f58286j = new GestureDetector(new b(this, null));
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            float f2 = this.f58285i;
            this.o = i2 - ((int) f2);
            this.p = i3 - ((int) f2);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, view, motionEvent)) == null) {
            if (motionEvent.getAction() == 1) {
                c cVar = this.k;
                if (cVar != null) {
                    cVar.onProgress(this.t);
                }
            } else if (motionEvent.getAction() == 2 && this.k != null && System.currentTimeMillis() - this.u > 200) {
                this.u = System.currentTimeMillis();
                this.k.a(this.t);
            }
            return this.f58286j.onTouchEvent(motionEvent);
        }
        return invokeLL.booleanValue;
    }

    public void setCoverStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.w = z;
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bitmap) == null) {
            Bitmap bitmap2 = this.l;
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
            this.l = bitmap;
            if (bitmap != null) {
                this.m = bitmap.getWidth();
                this.n = bitmap.getHeight();
            } else {
                this.m = 0;
                this.n = 0;
            }
            invalidate();
        }
    }

    public void setOnProgressListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.k = cVar;
        }
    }

    public void setPickDrawable(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f58281e = i2;
        }
    }

    public void setProgress(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048590, this, f2) == null) {
            moveToPosition((f2 * getRealSlideRange()) + getRealLeftRange() + (getWidth() / 2));
        }
    }

    public void setSlideRange(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.f58283g = f2;
            this.f58284h = f3;
        }
    }

    public void moveToPosition(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048580, this, f2) == null) || getRealSlideRange() <= 0.0f) {
            return;
        }
        b(f2);
        c(f2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlideBarView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f58281e = R.drawable.pick_cover_slide;
        this.f58285i = 12.0f;
        this.q = new Rect();
        this.r = new RectF();
        this.s = new Paint();
        a(context, attributeSet, 0, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlideBarView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f58281e = R.drawable.pick_cover_slide;
        this.f58285i = 12.0f;
        this.q = new Rect();
        this.r = new RectF();
        this.s = new Paint();
        a(context, attributeSet, i2, 0);
    }
}
