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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.gr5;
import com.baidu.tieba.ii;
import com.baidu.tieba.v6a;
import com.baidu.tieba.w6a;
import com.baidu.tieba.wp5;
import com.baidu.tieba.x6a;
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
    public v6a b;
    public Matrix c;
    public Matrix d;
    public PointF e;
    public x6a f;
    public Paint g;
    public int h;
    public boolean i;
    public boolean j;
    public w6a k;
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
            this.f = new x6a(context);
            Paint paint = new Paint();
            this.g = paint;
            paint.setColor(-1);
            this.g.setStrokeWidth(ii.g(context, R.dimen.obfuscated_res_0x7f070224));
            this.g.setAntiAlias(true);
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
        this.c = new Matrix();
        this.d = new Matrix();
        this.e = new PointF();
        this.i = true;
        this.j = false;
        this.l = 0L;
        a(context);
    }

    public final boolean b(v6a v6aVar, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v6aVar, motionEvent)) == null) {
            return gr5.e(wp5.d(v6aVar.c(), v6aVar.b()), motionEvent.getX(), motionEvent.getY());
        }
        return invokeLL.booleanValue;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        v6a v6aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) != null) || (v6aVar = this.b) == null) {
            return;
        }
        v6aVar.a(canvas);
        float[] d = wp5.d(this.b.c(), this.b.b());
        float f = d[0];
        float f2 = d[1];
        float f3 = d[2];
        float f4 = d[3];
        float f5 = d[4];
        float f6 = d[5];
        float f7 = d[6];
        float f8 = d[7];
        if (this.j) {
            canvas.drawLine(f, f2, f3, f4, this.g);
            canvas.drawLine(f3, f4, f7, f8, this.g);
            canvas.drawLine(f7, f8, f5, f6, this.g);
            canvas.drawLine(f5, f6, f, f2, this.g);
            canvas.drawPoint(f, f2, this.g);
            canvas.drawPoint(f3, f4, this.g);
            canvas.drawPoint(f5, f6, this.g);
            canvas.drawPoint(f7, f8, this.g);
            this.f.a(canvas, f3, f4);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            if (z) {
                this.b.b().postTranslate((getWidth() - this.b.e()) / 2, (getHeight() - this.b.d()) / 2);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        w6a w6aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        if (actionMasked != 5) {
                            if (actionMasked != 6) {
                                return true;
                            }
                        } else {
                            this.h = 2;
                            this.o = gr5.d(motionEvent);
                            this.p = gr5.c(motionEvent);
                            this.e = gr5.b(motionEvent);
                            this.c.set(this.b.b());
                            return true;
                        }
                    } else {
                        if (!this.i || motionEvent.getX() != this.m || motionEvent.getY() != this.n) {
                            this.i = false;
                        }
                        int i = this.h;
                        if (i == 2) {
                            this.d.set(this.c);
                            float d = gr5.d(motionEvent) / this.o;
                            float c = gr5.c(motionEvent) - this.p;
                            PointF b = gr5.b(motionEvent);
                            Matrix matrix = this.d;
                            PointF pointF = this.e;
                            matrix.postScale(d, d, pointF.x, pointF.y);
                            Matrix matrix2 = this.d;
                            PointF pointF2 = this.e;
                            matrix2.postRotate(c, pointF2.x, pointF2.y);
                            Matrix matrix3 = this.d;
                            float f = b.x;
                            PointF pointF3 = this.e;
                            matrix3.postTranslate(f - pointF3.x, b.y - pointF3.y);
                            this.b.b().set(this.d);
                        } else if (i == 1) {
                            this.d.set(this.c);
                            this.d.postTranslate(motionEvent.getX() - this.m, motionEvent.getY() - this.n);
                            this.b.b().set(this.d);
                        }
                        if (this.i) {
                            return true;
                        }
                        invalidate();
                        return true;
                    }
                }
                this.h = 0;
                this.e = null;
                w6a w6aVar2 = this.k;
                if (w6aVar2 == null) {
                    return true;
                }
                if (this.i) {
                    w6aVar2.c(this);
                }
                if (this.j) {
                    this.i = false;
                }
                this.k.b(this, this.i);
                invalidate();
                return true;
            }
            this.m = motionEvent.getX();
            this.n = motionEvent.getY();
            if (this.b == null) {
                return false;
            }
            if (this.j && this.f.b(motionEvent)) {
                this.i = false;
                w6a w6aVar3 = this.k;
                if (w6aVar3 == null) {
                    return true;
                }
                w6aVar3.onDelete();
                return true;
            } else if (b(this.b, motionEvent)) {
                this.i = true;
                if (System.currentTimeMillis() - this.l <= 300 && (w6aVar = this.k) != null) {
                    w6aVar.a(this);
                    this.i = false;
                }
                this.l = System.currentTimeMillis();
                this.h = 1;
                this.c.set(this.b.b());
                return true;
            } else {
                this.i = false;
                w6a w6aVar4 = this.k;
                if (w6aVar4 != null) {
                    w6aVar4.b(this, false);
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
            this.b = new v6a(bitmap);
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.b = new v6a(BitmapHelper.getResBitmap(this.a, i));
        }
    }

    public void setRemoveRes(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.f.c(i);
        }
    }

    public void setmOnStickerActionListener(w6a w6aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, w6aVar) == null) {
            this.k = w6aVar;
        }
    }
}
