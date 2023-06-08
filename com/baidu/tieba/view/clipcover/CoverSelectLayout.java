package com.baidu.tieba.view.clipcover;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.cw5;
import com.baidu.tieba.lx5;
import com.baidu.tieba.t46;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class CoverSelectLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public ClipCoverView b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public Matrix h;
    public Matrix i;
    public int j;
    public PointF k;
    public PointF l;
    public float m;
    public final float[] n;
    public float o;
    public float p;
    public int q;
    public int r;
    public int s;

    /* loaded from: classes8.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ CoverSelectLayout b;

        public a(CoverSelectLayout coverSelectLayout, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverSelectLayout, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = coverSelectLayout;
            this.a = str;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.f(this.a);
                this.b.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CoverSelectLayout(Context context) {
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CoverSelectLayout(Context context, AttributeSet attributeSet) {
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
    public CoverSelectLayout(Context context, AttributeSet attributeSet, int i) {
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
        this.h = new Matrix();
        this.i = new Matrix();
        this.j = 0;
        this.k = new PointF();
        this.l = new PointF();
        this.m = 1.0f;
        this.n = new float[9];
        this.p = 4.0f;
        e(context, attributeSet);
    }

    public final RectF d(Matrix matrix) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, matrix)) == null) {
            RectF rectF = new RectF();
            Drawable drawable = this.a.getDrawable();
            if (drawable != null) {
                rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                matrix.mapRect(rectF);
            }
            return rectF;
        }
        return (RectF) invokeL.objValue;
    }

    public void setImagSrc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.a.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, str));
        }
    }

    public final void b() {
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            RectF d = d(this.h);
            int width = this.a.getWidth();
            int height = this.a.getHeight();
            float f2 = width;
            float f3 = this.f;
            float f4 = 0.0f;
            if (d.width() + 0.01d >= f2 - (f3 * 2.0f)) {
                float f5 = d.left;
                if (f5 > f3) {
                    f = (-f5) + f3;
                } else {
                    f = 0.0f;
                }
                float f6 = d.right;
                float f7 = this.f;
                if (f6 < f2 - f7) {
                    f = (f2 - f7) - f6;
                }
            } else {
                f = 0.0f;
            }
            float f8 = height;
            float f9 = this.e;
            if (d.height() + 0.01d >= f8 - (2.0f * f9)) {
                float f10 = d.top;
                if (f10 > f9) {
                    f4 = (-f10) + f9;
                }
                float f11 = d.bottom;
                float f12 = this.e;
                if (f11 < f8 - f12) {
                    f4 = (f8 - f12) - f11;
                }
            }
            this.h.postTranslate(f, f4);
        }
    }

    public Bitmap c() {
        InterceptResult invokeV;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.a.setDrawingCacheEnabled(true);
            this.a.buildDrawingCache();
            RectF clipCoverRect = this.b.getClipCoverRect();
            try {
                bitmap = Bitmap.createBitmap(this.a.getDrawingCache(), (int) clipCoverRect.left, (int) clipCoverRect.top, (int) clipCoverRect.width(), (int) clipCoverRect.height());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                bitmap = null;
            }
            this.a.destroyDrawingCache();
            return bitmap;
        }
        return (Bitmap) invokeV.objValue;
    }

    public void e(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t46.CoverSelectLayout);
            this.c = obtainStyledAttributes.getDimensionPixelSize(1, (int) TypedValue.applyDimension(1, 0.0f, getResources().getDisplayMetrics()));
            this.d = obtainStyledAttributes.getDimensionPixelSize(2, (int) TypedValue.applyDimension(1, 0.0f, getResources().getDisplayMetrics()));
            this.g = obtainStyledAttributes.getDimensionPixelSize(0, (int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
            obtainStyledAttributes.recycle();
            ClipCoverView clipCoverView = new ClipCoverView(context);
            this.b = clipCoverView;
            clipCoverView.setClipBorderWidth(this.g);
            this.b.setmHorizontal(this.c);
            this.b.setmVerticalPadding(this.d);
            this.a = new ImageView(context);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            addView(this.a, layoutParams);
            addView(this.b, layoutParams);
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.q = displayMetrics.widthPixels;
            this.r = displayMetrics.heightPixels;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x007f, code lost:
        if (r0 < r1) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x009d, code lost:
        if (r0 < r1) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x009f, code lost:
        r0 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(String str) {
        float height;
        float height2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        int[] e = cw5.e(str);
        int i = e[0];
        int i2 = e[1];
        int i3 = this.q;
        if (i > i3) {
            i = i3;
        }
        int i4 = this.r;
        if (i2 > i4) {
            i2 = i4;
        }
        Bitmap b = cw5.b(str, i, i2);
        if (b == null) {
            return;
        }
        int readPictureDegree = BitmapHelper.readPictureDegree(str);
        Matrix matrix = new Matrix();
        matrix.setRotate(readPictureDegree);
        Bitmap createBitmap = Bitmap.createBitmap(b, 0, 0, b.getWidth(), b.getHeight(), matrix, true);
        float width = (createBitmap.getWidth() * 1.0f) / createBitmap.getHeight();
        RectF clipCoverRect = this.b.getClipCoverRect();
        if (width <= clipCoverRect.width() / clipCoverRect.height()) {
            height = this.a.getWidth() / createBitmap.getWidth();
            height2 = clipCoverRect.width() / createBitmap.getWidth();
            this.o = height2;
        } else {
            height = this.a.getHeight() / createBitmap.getHeight();
            height2 = clipCoverRect.height() / createBitmap.getHeight();
            this.o = height2;
        }
        this.h.postScale(height, height);
        this.h.postTranslate((this.a.getWidth() * 0.5f) - ((int) ((createBitmap.getWidth() * height) * 0.5f)), (this.a.getHeight() * 0.5f) - ((int) ((createBitmap.getHeight() * height) * 0.5f)));
        this.a.setScaleType(ImageView.ScaleType.MATRIX);
        this.a.setImageMatrix(this.h);
        this.a.setImageBitmap(createBitmap);
    }

    public final float getScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            this.h.getValues(this.n);
            return this.n[0];
        }
        return invokeV.floatValue;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action != 2) {
                    if (action != 5) {
                        if (action == 6) {
                            this.j = 0;
                        }
                    } else {
                        float d = lx5.d(motionEvent);
                        this.m = d;
                        if (d > 10.0f) {
                            this.i.set(this.h);
                            this.l = lx5.b(motionEvent);
                            this.j = 2;
                        }
                    }
                } else {
                    int i = this.j;
                    if (i == 1) {
                        this.h.set(this.i);
                        float x = motionEvent.getX() - this.k.x;
                        float y = motionEvent.getY() - this.k.y;
                        this.e = this.b.getClipCoverRect().top;
                        this.f = this.b.getClipCoverRect().left;
                        this.h.postTranslate(x, y);
                        b();
                    } else if (i == 2) {
                        float d2 = lx5.d(motionEvent);
                        if (d2 > 10.0f) {
                            float f = d2 / this.m;
                            if (f < 1.0f) {
                                if (getScale() > this.o) {
                                    this.h.set(this.i);
                                    this.e = this.b.getClipCoverRect().top;
                                    this.f = this.b.getClipCoverRect().left;
                                    Matrix matrix = this.h;
                                    PointF pointF = this.l;
                                    matrix.postScale(f, f, pointF.x, pointF.y);
                                    while (getScale() < this.o) {
                                        Matrix matrix2 = this.h;
                                        PointF pointF2 = this.l;
                                        matrix2.postScale(1.01f, 1.01f, pointF2.x, pointF2.y);
                                    }
                                }
                                b();
                            } else if (getScale() <= this.p) {
                                this.h.set(this.i);
                                this.e = this.b.getClipCoverRect().top;
                                this.f = this.b.getClipCoverRect().left;
                                Matrix matrix3 = this.h;
                                PointF pointF3 = this.l;
                                matrix3.postScale(f, f, pointF3.x, pointF3.y);
                            }
                        }
                    }
                    this.a.setImageMatrix(this.h);
                }
            } else {
                this.i.set(this.h);
                this.k.set(motionEvent.getX(), motionEvent.getY());
                this.j = 1;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setClipType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.s = i;
            if (i == 1) {
                this.c = UtilHelper.getDimenPixelSize(R.dimen.tbds920);
                this.d = UtilHelper.getDimenPixelSize(R.dimen.tbds520);
            } else if (i == 2) {
                this.c = UtilHelper.getDimenPixelSize(R.dimen.tbds920);
                this.d = UtilHelper.getDimenPixelSize(R.dimen.tbds1227);
            }
            float dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.L_X04);
            this.g = dimenPixelSize;
            this.b.setClipBorderWidth(dimenPixelSize);
            this.b.setmHorizontal(this.c);
            this.b.setmVerticalPadding(this.d);
        }
    }
}
