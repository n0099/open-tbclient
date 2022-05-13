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
/* loaded from: classes4.dex */
public class SlideBarView extends View implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public Drawable b;
    public float c;
    public float d;
    public float e;
    public GestureDetector f;
    public c g;
    public Bitmap h;
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

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
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
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                this.a.d(motionEvent2);
                return true;
            }
            return invokeCommon.booleanValue;
        }

        public /* synthetic */ b(SlideBarView slideBarView, a aVar) {
            this(slideBarView);
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(float f);

        void onProgress(float f);
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
        this.a = R.drawable.obfuscated_res_0x7f080f94;
        this.e = 12.0f;
        this.m = new Rect();
        this.n = new RectF();
        this.o = new Paint();
    }

    private float getRealLeftRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            float f = this.c;
            float f2 = this.e;
            if (f - f2 < 0.0f) {
                return 0.0f;
            }
            return f - f2;
        }
        return invokeV.floatValue;
    }

    private float getRealRightRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            float f = this.d;
            float f2 = this.e;
            if (f + f2 < 0.0f) {
                return 0.0f;
            }
            return f + f2;
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
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0400e1}, i, i2);
            this.e = obtainStyledAttributes.getDimension(0, 12.0f);
            obtainStyledAttributes.recycle();
            this.o.setAntiAlias(true);
        }
    }

    public final void b(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) {
            float width = f - (getWidth() / 2.0f);
            if (width < getRealLeftRange()) {
                setX(getRealLeftRange());
            } else if (width > getRealRightRange()) {
                setX(getRealRightRange());
            } else {
                setX(width);
            }
        }
    }

    public void c(float f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f) == null) || getRealSlideRange() <= 0.0f) {
            return;
        }
        b(f);
        e(f);
    }

    public void d(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, motionEvent) == null) {
            c(motionEvent.getRawX());
        }
    }

    public final void e(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f) == null) {
            float realLeftRange = (f - getRealLeftRange()) - (getWidth() / 2.0f);
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
        float f;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            Drawable drawable = getResources().getDrawable(this.a);
            this.b = drawable;
            int i = this.k;
            float f3 = this.e;
            drawable.setBounds(0, 0, i + ((int) f3), this.l + ((int) f3));
            if (this.s) {
                if (this.h != null) {
                    if (this.r == null) {
                        this.r = new Matrix();
                    }
                    this.r.reset();
                    int i2 = this.i;
                    int i3 = this.j;
                    int i4 = this.k;
                    int i5 = this.l;
                    float f4 = 0.0f;
                    if (i2 * i5 > i4 * i3) {
                        f2 = i5 / i3;
                        f4 = (i4 - (i2 * f2)) * 0.5f;
                        f = 0.0f;
                    } else {
                        float f5 = i4 / i2;
                        f = (i5 - (i3 * f5)) * 0.5f;
                        f2 = f5;
                    }
                    this.r.setScale(f2, f2);
                    Matrix matrix = this.r;
                    float f6 = this.e;
                    matrix.postTranslate(f4 + (f6 / 2.0f), f + (f6 / 2.0f));
                    if (!this.h.isRecycled()) {
                        canvas.drawBitmap(this.h, this.r, this.o);
                    }
                }
                this.b.draw(canvas);
                return;
            }
            float f7 = this.k / this.l;
            int i6 = this.i;
            int i7 = this.j;
            if (f7 > i6 / i7) {
                i7 = (int) (i6 / f7);
            } else {
                i6 = (int) (i7 * f7);
            }
            this.m.set(0, 0, i6, i7);
            RectF rectF = this.n;
            float f8 = this.e;
            rectF.set(f8, f8, this.k, this.l);
            Bitmap bitmap = this.h;
            if (bitmap != null && !bitmap.isRecycled()) {
                canvas.drawBitmap(this.h, this.m, this.n, this.o);
                this.b.draw(canvas);
                return;
            }
            this.b.draw(canvas);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onFinishInflate();
            setOnTouchListener(this);
            this.f = new GestureDetector(new b(this, null));
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            float f = this.e;
            this.k = i - ((int) f);
            this.l = i2 - ((int) f);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, view2, motionEvent)) == null) {
            if (motionEvent.getAction() == 1) {
                c cVar = this.g;
                if (cVar != null) {
                    cVar.onProgress(this.p);
                }
            } else if (motionEvent.getAction() == 2 && this.g != null && System.currentTimeMillis() - this.q > 200) {
                this.q = System.currentTimeMillis();
                this.g.a(this.p);
            }
            return this.f.onTouchEvent(motionEvent);
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
            Bitmap bitmap2 = this.h;
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
            this.h = bitmap;
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
            this.g = cVar;
        }
    }

    public void setPickDrawable(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.a = i;
        }
    }

    public void setProgress(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048590, this, f) == null) {
            c((f * getRealSlideRange()) + getRealLeftRange() + (getWidth() / 2));
        }
    }

    public void setSlideRange(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.c = f;
            this.d = f2;
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
        this.a = R.drawable.obfuscated_res_0x7f080f94;
        this.e = 12.0f;
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
        this.a = R.drawable.obfuscated_res_0x7f080f94;
        this.e = 12.0f;
        this.m = new Rect();
        this.n = new RectF();
        this.o = new Paint();
        a(context, attributeSet, i, 0);
    }
}
