package com.baidu.tieba.write.write.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import c.a.d.f.p.n;
import c.a.o0.c1.m;
import c.a.o0.c1.m0;
import c.a.p0.s4.u.n.a;
import c.a.p0.s4.u.n.b.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class StickerView extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public a f37486b;

    /* renamed from: c  reason: collision with root package name */
    public Matrix f37487c;

    /* renamed from: d  reason: collision with root package name */
    public Matrix f37488d;

    /* renamed from: e  reason: collision with root package name */
    public PointF f37489e;

    /* renamed from: f  reason: collision with root package name */
    public b f37490f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f37491g;

    /* renamed from: h  reason: collision with root package name */
    public int f37492h;
    public boolean i;
    public boolean j;
    public c.a.p0.s4.u.n.b.a k;
    public long l;
    public float m;
    public float n;
    public float o;
    public float p;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StickerView(Context context) {
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

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.a = context;
            setScaleType(ImageView.ScaleType.MATRIX);
            this.f37490f = new b(context);
            Paint paint = new Paint();
            this.f37491g = paint;
            paint.setColor(-1);
            this.f37491g.setStrokeWidth(n.f(context, R.dimen.obfuscated_res_0x7f070224));
            this.f37491g.setAntiAlias(true);
        }
    }

    public final boolean b(a aVar, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, motionEvent)) == null) ? m0.e(m.d(aVar.c(), aVar.b()), motionEvent.getX(), motionEvent.getY()) : invokeLL.booleanValue;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) || (aVar = this.f37486b) == null) {
            return;
        }
        aVar.a(canvas);
        float[] d2 = m.d(this.f37486b.c(), this.f37486b.b());
        float f2 = d2[0];
        float f3 = d2[1];
        float f4 = d2[2];
        float f5 = d2[3];
        float f6 = d2[4];
        float f7 = d2[5];
        float f8 = d2[6];
        float f9 = d2[7];
        if (this.j) {
            canvas.drawLine(f2, f3, f4, f5, this.f37491g);
            canvas.drawLine(f4, f5, f8, f9, this.f37491g);
            canvas.drawLine(f8, f9, f6, f7, this.f37491g);
            canvas.drawLine(f6, f7, f2, f3, this.f37491g);
            canvas.drawPoint(f2, f3, this.f37491g);
            canvas.drawPoint(f4, f5, this.f37491g);
            canvas.drawPoint(f6, f7, this.f37491g);
            canvas.drawPoint(f8, f9, this.f37491g);
            this.f37490f.a(canvas, f4, f5);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            if (z) {
                this.f37486b.b().postTranslate((getWidth() - this.f37486b.e()) / 2, (getHeight() - this.f37486b.d()) / 2);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        c.a.p0.s4.u.n.b.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        if (!this.i || motionEvent.getX() != this.m || motionEvent.getY() != this.n) {
                            this.i = false;
                        }
                        int i = this.f37492h;
                        if (i == 2) {
                            this.f37488d.set(this.f37487c);
                            float d2 = m0.d(motionEvent) / this.o;
                            float c2 = m0.c(motionEvent) - this.p;
                            PointF b2 = m0.b(motionEvent);
                            Matrix matrix = this.f37488d;
                            PointF pointF = this.f37489e;
                            matrix.postScale(d2, d2, pointF.x, pointF.y);
                            Matrix matrix2 = this.f37488d;
                            PointF pointF2 = this.f37489e;
                            matrix2.postRotate(c2, pointF2.x, pointF2.y);
                            Matrix matrix3 = this.f37488d;
                            float f2 = b2.x;
                            PointF pointF3 = this.f37489e;
                            matrix3.postTranslate(f2 - pointF3.x, b2.y - pointF3.y);
                            this.f37486b.b().set(this.f37488d);
                        } else if (i == 1) {
                            this.f37488d.set(this.f37487c);
                            this.f37488d.postTranslate(motionEvent.getX() - this.m, motionEvent.getY() - this.n);
                            this.f37486b.b().set(this.f37488d);
                        }
                        if (this.i) {
                            return true;
                        }
                        invalidate();
                        return true;
                    } else if (actionMasked == 5) {
                        this.f37492h = 2;
                        this.o = m0.d(motionEvent);
                        this.p = m0.c(motionEvent);
                        this.f37489e = m0.b(motionEvent);
                        this.f37487c.set(this.f37486b.b());
                        return true;
                    } else if (actionMasked != 6) {
                        return true;
                    }
                }
                this.f37492h = 0;
                this.f37489e = null;
                c.a.p0.s4.u.n.b.a aVar2 = this.k;
                if (aVar2 != null) {
                    if (this.i) {
                        aVar2.c(this);
                    }
                    if (this.j) {
                        this.i = false;
                    }
                    this.k.b(this, this.i);
                    invalidate();
                    return true;
                }
                return true;
            }
            this.m = motionEvent.getX();
            this.n = motionEvent.getY();
            if (this.f37486b == null) {
                return false;
            }
            if (this.j && this.f37490f.b(motionEvent)) {
                this.i = false;
                c.a.p0.s4.u.n.b.a aVar3 = this.k;
                if (aVar3 != null) {
                    aVar3.onDelete();
                    return true;
                }
                return true;
            } else if (b(this.f37486b, motionEvent)) {
                this.i = true;
                if (System.currentTimeMillis() - this.l <= 300 && (aVar = this.k) != null) {
                    aVar.a(this);
                    this.i = false;
                }
                this.l = System.currentTimeMillis();
                this.f37492h = 1;
                this.f37487c.set(this.f37486b.b());
                return true;
            } else {
                this.i = false;
                c.a.p0.s4.u.n.b.a aVar4 = this.k;
                if (aVar4 != null) {
                    aVar4.b(this, false);
                    invalidate();
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void setEdit(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.j = z;
            postInvalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bitmap) == null) {
            this.f37486b = new a(bitmap);
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.f37486b = new a(BitmapHelper.getResBitmap(this.a, i));
        }
    }

    public void setRemoveRes(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.f37490f.c(i);
        }
    }

    public void setmOnStickerActionListener(c.a.p0.s4.u.n.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.k = aVar;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StickerView(Context context, AttributeSet attributeSet) {
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
    public StickerView(Context context, AttributeSet attributeSet, int i) {
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
        this.f37487c = new Matrix();
        this.f37488d = new Matrix();
        this.f37489e = new PointF();
        this.i = true;
        this.j = false;
        this.l = 0L;
        a(context);
    }
}
