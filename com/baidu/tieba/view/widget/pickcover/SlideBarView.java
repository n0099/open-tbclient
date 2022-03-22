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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class SlideBarView extends View implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public Drawable f37212b;

    /* renamed from: c  reason: collision with root package name */
    public float f37213c;

    /* renamed from: d  reason: collision with root package name */
    public float f37214d;

    /* renamed from: e  reason: collision with root package name */
    public float f37215e;

    /* renamed from: f  reason: collision with root package name */
    public GestureDetector f37216f;

    /* renamed from: g  reason: collision with root package name */
    public c f37217g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f37218h;
    public int i;
    public int j;
    public int k;
    public int l;
    public Rect m;
    public RectF n;
    public Paint o;
    public float p;
    public long q;
    public Matrix r;
    public boolean s;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public final class b extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SlideBarView a;

        public b(SlideBarView slideBarView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {slideBarView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = slideBarView;
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
                this.a.d(motionEvent2);
                return true;
            }
            return invokeCommon.booleanValue;
        }

        public /* synthetic */ b(SlideBarView slideBarView, a aVar) {
            this(slideBarView);
        }
    }

    /* loaded from: classes6.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = R.drawable.obfuscated_res_0x7f080f73;
        this.f37215e = 12.0f;
        this.m = new Rect();
        this.n = new RectF();
        this.o = new Paint();
    }

    private float getRealLeftRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            float f2 = this.f37213c;
            float f3 = this.f37215e;
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
            float f2 = this.f37214d;
            float f3 = this.f37215e;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) ? getRealRightRange() - getRealLeftRange() : invokeV.floatValue;
    }

    public final void a(Context context, AttributeSet attributeSet, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048576, this, context, attributeSet, i, i2) == null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0400de}, i, i2);
            this.f37215e = obtainStyledAttributes.getDimension(0, 12.0f);
            obtainStyledAttributes.recycle();
            this.o.setAntiAlias(true);
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

    public void c(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) || getRealSlideRange() <= 0.0f) {
            return;
        }
        b(f2);
        e(f2);
    }

    public void d(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, motionEvent) == null) {
            c(motionEvent.getRawX());
        }
    }

    public final void e(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f2) == null) {
            float realLeftRange = (f2 - getRealLeftRange()) - (getWidth() / 2.0f);
            float realSlideRange = getRealSlideRange();
            if (realLeftRange < 0.0f) {
                realLeftRange = 0.0f;
            } else if (realLeftRange >= realSlideRange) {
                realLeftRange = realSlideRange;
            }
            this.p = realLeftRange / realSlideRange;
        }
    }

    public float getCurrentPercent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.p : invokeV.floatValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            Drawable drawable = getResources().getDrawable(this.a);
            this.f37212b = drawable;
            int i = this.k;
            float f4 = this.f37215e;
            drawable.setBounds(0, 0, i + ((int) f4), this.l + ((int) f4));
            if (this.s) {
                if (this.f37218h != null) {
                    if (this.r == null) {
                        this.r = new Matrix();
                    }
                    this.r.reset();
                    int i2 = this.i;
                    int i3 = this.j;
                    int i4 = this.k;
                    int i5 = this.l;
                    float f5 = 0.0f;
                    if (i2 * i5 > i4 * i3) {
                        f3 = i5 / i3;
                        f5 = (i4 - (i2 * f3)) * 0.5f;
                        f2 = 0.0f;
                    } else {
                        float f6 = i4 / i2;
                        f2 = (i5 - (i3 * f6)) * 0.5f;
                        f3 = f6;
                    }
                    this.r.setScale(f3, f3);
                    Matrix matrix = this.r;
                    float f7 = this.f37215e;
                    matrix.postTranslate(f5 + (f7 / 2.0f), f2 + (f7 / 2.0f));
                    if (!this.f37218h.isRecycled()) {
                        canvas.drawBitmap(this.f37218h, this.r, this.o);
                    }
                }
                this.f37212b.draw(canvas);
                return;
            }
            float f8 = this.k / this.l;
            int i6 = this.i;
            int i7 = this.j;
            if (f8 > i6 / i7) {
                i7 = (int) (i6 / f8);
            } else {
                i6 = (int) (i7 * f8);
            }
            this.m.set(0, 0, i6, i7);
            RectF rectF = this.n;
            float f9 = this.f37215e;
            rectF.set(f9, f9, this.k, this.l);
            Bitmap bitmap = this.f37218h;
            if (bitmap != null && !bitmap.isRecycled()) {
                canvas.drawBitmap(this.f37218h, this.m, this.n, this.o);
                this.f37212b.draw(canvas);
                return;
            }
            this.f37212b.draw(canvas);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onFinishInflate();
            setOnTouchListener(this);
            this.f37216f = new GestureDetector(new b(this, null));
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            float f2 = this.f37215e;
            this.k = i - ((int) f2);
            this.l = i2 - ((int) f2);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, view, motionEvent)) == null) {
            if (motionEvent.getAction() == 1) {
                c cVar = this.f37217g;
                if (cVar != null) {
                    cVar.onProgress(this.p);
                }
            } else if (motionEvent.getAction() == 2 && this.f37217g != null && System.currentTimeMillis() - this.q > 200) {
                this.q = System.currentTimeMillis();
                this.f37217g.a(this.p);
            }
            return this.f37216f.onTouchEvent(motionEvent);
        }
        return invokeLL.booleanValue;
    }

    public void setCoverStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.s = z;
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bitmap) == null) {
            Bitmap bitmap2 = this.f37218h;
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
            this.f37218h = bitmap;
            if (bitmap != null) {
                this.i = bitmap.getWidth();
                this.j = bitmap.getHeight();
            } else {
                this.i = 0;
                this.j = 0;
            }
            invalidate();
        }
    }

    public void setOnProgressListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.f37217g = cVar;
        }
    }

    public void setPickDrawable(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.a = i;
        }
    }

    public void setProgress(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048590, this, f2) == null) {
            c((f2 * getRealSlideRange()) + getRealLeftRange() + (getWidth() / 2));
        }
    }

    public void setSlideRange(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.f37213c = f2;
            this.f37214d = f3;
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = R.drawable.obfuscated_res_0x7f080f73;
        this.f37215e = 12.0f;
        this.m = new Rect();
        this.n = new RectF();
        this.o = new Paint();
        a(context, attributeSet, 0, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlideBarView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.a = R.drawable.obfuscated_res_0x7f080f73;
        this.f37215e = 12.0f;
        this.m = new Rect();
        this.n = new RectF();
        this.o = new Paint();
        a(context, attributeSet, i, 0);
    }
}
