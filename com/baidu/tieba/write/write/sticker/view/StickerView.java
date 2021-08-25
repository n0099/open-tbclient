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
import c.a.e.e.p.l;
import c.a.p0.b1.h;
import c.a.p0.b1.j0;
import c.a.q0.b4.u.n.a;
import c.a.q0.b4.u.n.b.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class StickerView extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f58943e;

    /* renamed from: f  reason: collision with root package name */
    public a f58944f;

    /* renamed from: g  reason: collision with root package name */
    public Matrix f58945g;

    /* renamed from: h  reason: collision with root package name */
    public Matrix f58946h;

    /* renamed from: i  reason: collision with root package name */
    public PointF f58947i;

    /* renamed from: j  reason: collision with root package name */
    public b f58948j;
    public Paint k;
    public int l;
    public boolean m;
    public boolean n;
    public c.a.q0.b4.u.n.b.a o;
    public long p;
    public float q;
    public float r;
    public float s;
    public float t;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StickerView(Context context) {
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

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f58943e = context;
            setScaleType(ImageView.ScaleType.MATRIX);
            this.f58948j = new b(context);
            Paint paint = new Paint();
            this.k = paint;
            paint.setColor(-1);
            this.k.setStrokeWidth(l.g(context, R.dimen.ds4));
            this.k.setAntiAlias(true);
        }
    }

    public final boolean b(a aVar, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, motionEvent)) == null) ? j0.e(h.d(aVar.c(), aVar.b()), motionEvent.getX(), motionEvent.getY()) : invokeLL.booleanValue;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) || (aVar = this.f58944f) == null) {
            return;
        }
        aVar.a(canvas);
        float[] d2 = h.d(this.f58944f.c(), this.f58944f.b());
        float f2 = d2[0];
        float f3 = d2[1];
        float f4 = d2[2];
        float f5 = d2[3];
        float f6 = d2[4];
        float f7 = d2[5];
        float f8 = d2[6];
        float f9 = d2[7];
        if (this.n) {
            canvas.drawLine(f2, f3, f4, f5, this.k);
            canvas.drawLine(f4, f5, f8, f9, this.k);
            canvas.drawLine(f8, f9, f6, f7, this.k);
            canvas.drawLine(f6, f7, f2, f3, this.k);
            canvas.drawPoint(f2, f3, this.k);
            canvas.drawPoint(f4, f5, this.k);
            canvas.drawPoint(f6, f7, this.k);
            canvas.drawPoint(f8, f9, this.k);
            this.f58948j.a(canvas, f4, f5);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (z) {
                this.f58944f.b().postTranslate((getWidth() - this.f58944f.e()) / 2, (getHeight() - this.f58944f.d()) / 2);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        c.a.q0.b4.u.n.b.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        if (!this.m || motionEvent.getX() != this.q || motionEvent.getY() != this.r) {
                            this.m = false;
                        }
                        int i2 = this.l;
                        if (i2 == 2) {
                            this.f58946h.set(this.f58945g);
                            float d2 = j0.d(motionEvent) / this.s;
                            float c2 = j0.c(motionEvent) - this.t;
                            PointF b2 = j0.b(motionEvent);
                            Matrix matrix = this.f58946h;
                            PointF pointF = this.f58947i;
                            matrix.postScale(d2, d2, pointF.x, pointF.y);
                            Matrix matrix2 = this.f58946h;
                            PointF pointF2 = this.f58947i;
                            matrix2.postRotate(c2, pointF2.x, pointF2.y);
                            Matrix matrix3 = this.f58946h;
                            float f2 = b2.x;
                            PointF pointF3 = this.f58947i;
                            matrix3.postTranslate(f2 - pointF3.x, b2.y - pointF3.y);
                            this.f58944f.b().set(this.f58946h);
                        } else if (i2 == 1) {
                            this.f58946h.set(this.f58945g);
                            this.f58946h.postTranslate(motionEvent.getX() - this.q, motionEvent.getY() - this.r);
                            this.f58944f.b().set(this.f58946h);
                        }
                        if (this.m) {
                            return true;
                        }
                        invalidate();
                        return true;
                    } else if (actionMasked == 5) {
                        this.l = 2;
                        this.s = j0.d(motionEvent);
                        this.t = j0.c(motionEvent);
                        this.f58947i = j0.b(motionEvent);
                        this.f58945g.set(this.f58944f.b());
                        return true;
                    } else if (actionMasked != 6) {
                        return true;
                    }
                }
                this.l = 0;
                this.f58947i = null;
                c.a.q0.b4.u.n.b.a aVar2 = this.o;
                if (aVar2 != null) {
                    if (this.m) {
                        aVar2.c(this);
                    }
                    if (this.n) {
                        this.m = false;
                    }
                    this.o.b(this, this.m);
                    invalidate();
                    return true;
                }
                return true;
            }
            this.q = motionEvent.getX();
            this.r = motionEvent.getY();
            if (this.f58944f == null) {
                return false;
            }
            if (this.n && this.f58948j.b(motionEvent)) {
                this.m = false;
                c.a.q0.b4.u.n.b.a aVar3 = this.o;
                if (aVar3 != null) {
                    aVar3.onDelete();
                    return true;
                }
                return true;
            } else if (b(this.f58944f, motionEvent)) {
                this.m = true;
                if (System.currentTimeMillis() - this.p <= 300 && (aVar = this.o) != null) {
                    aVar.a(this);
                    this.m = false;
                }
                this.p = System.currentTimeMillis();
                this.l = 1;
                this.f58945g.set(this.f58944f.b());
                return true;
            } else {
                this.m = false;
                c.a.q0.b4.u.n.b.a aVar4 = this.o;
                if (aVar4 != null) {
                    aVar4.b(this, false);
                    invalidate();
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void replaceImageBitmap(Bitmap bitmap) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bitmap) == null) || (aVar = this.f58944f) == null) {
            return;
        }
        aVar.c().recycle();
        this.f58944f.f(bitmap);
        invalidate();
    }

    public void setEdit(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.n = z;
            postInvalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bitmap) == null) {
            this.f58944f = new a(bitmap);
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f58944f = new a(BitmapHelper.getResBitmap(this.f58943e, i2));
        }
    }

    public void setRemoveRes(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f58948j.c(i2);
        }
    }

    public void setmOnStickerActionListener(c.a.q0.b4.u.n.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.o = aVar;
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
    public StickerView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f58945g = new Matrix();
        this.f58946h = new Matrix();
        this.f58947i = new PointF();
        this.m = true;
        this.n = false;
        this.p = 0L;
        a(context);
    }
}
