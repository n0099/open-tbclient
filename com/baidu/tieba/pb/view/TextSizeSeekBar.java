package com.baidu.tieba.pb.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.j2.i.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class TextSizeSeekBar extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f55725e;

    /* renamed from: f  reason: collision with root package name */
    public int f55726f;

    /* renamed from: g  reason: collision with root package name */
    public int f55727g;

    /* renamed from: h  reason: collision with root package name */
    public int f55728h;

    /* renamed from: i  reason: collision with root package name */
    public int f55729i;

    /* renamed from: j  reason: collision with root package name */
    public int f55730j;
    public Paint k;
    public int l;
    public Drawable m;
    public int n;
    public String[] o;
    public int p;
    public int q;
    public int r;
    public int s;
    public ArrayList<Rect> t;
    public int u;
    public int v;
    public int w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextSizeSeekBar(Context context) {
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
        this.n = 1;
        this.t = new ArrayList<>(4);
        this.u = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.v = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.w = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);
        d(context);
    }

    public final void a(Canvas canvas) {
        Rect rect;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) || (rect = (Rect) ListUtils.getItem(this.t, this.n)) == null || (drawable = this.m) == null) {
            return;
        }
        drawable.setBounds(rect.left, rect.top, rect.right, rect.bottom);
        this.m.draw(canvas);
    }

    public final void b(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            this.k.setColor(this.r);
            this.k.setStrokeWidth(this.u);
            int i2 = this.f55728h;
            int i3 = this.f55730j;
            canvas.drawLine((float) (i2 / 2.0d), i3, (float) (this.f55725e - (i2 / 2.0d)), i3, this.k);
            this.k.setStrokeWidth(this.v);
            this.k.setStrokeCap(Paint.Cap.ROUND);
            for (int i4 = 0; i4 < 4; i4++) {
                canvas.drawPoint((this.f55727g * i4) + (this.f55728h / 2), this.f55730j, this.k);
            }
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            for (int i2 = 0; i2 < this.o.length; i2++) {
                if (i2 == this.n) {
                    this.k.setColor(this.p);
                } else {
                    this.k.setColor(this.q);
                }
                this.k.setTextSize(this.l);
                this.k.setTextAlign(Paint.Align.CENTER);
                canvas.drawText(this.o[i2], (this.f55727g * i2) + (this.f55728h / 2), this.f55730j - this.w, this.k);
            }
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds102);
            Paint paint = new Paint();
            this.k = paint;
            paint.setAntiAlias(true);
            this.k.setDither(true);
            this.k.setFilterBitmap(true);
            this.m = SkinManager.getDrawable(R.drawable.pic_wordsize_n);
            this.f55728h = dimensionPixelSize;
            this.f55729i = dimensionPixelSize;
            this.l = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.T_X09);
            this.o = new String[]{context.getString(R.string.font_size_small), context.getString(R.string.font_size_mid), context.getString(R.string.font_size_big), context.getString(R.string.font_size_xlarge)};
            this.p = SkinManager.getColor(R.color.CAM_X0105);
            this.q = SkinManager.getColor(R.color.CAM_X0109);
            this.r = SkinManager.getColor(R.color.CAM_X0111);
            this.s = TbadkCoreApplication.getInst().getSkinType();
            this.n = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.m = SkinManager.getDrawable(R.drawable.pic_wordsize_n);
            this.n = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
            super.onAttachedToWindow();
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.s == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        this.s = TbadkCoreApplication.getInst().getSkinType();
        if (this.m != null) {
            this.m = SkinManager.getDrawable(R.drawable.pic_wordsize_n);
        }
        this.p = SkinManager.getColor(R.color.CAM_X0105);
        this.q = SkinManager.getColor(R.color.CAM_X0109);
        this.r = SkinManager.getColor(R.color.CAM_X0111);
        invalidate();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDetachedFromWindow();
            Drawable drawable = this.m;
            if (drawable != null) {
                drawable.setCallback(null);
                this.m = null;
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
            super.onDraw(canvas);
            c(canvas);
            b(canvas);
            a(canvas);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            if (this.f55725e == 0 || this.f55726f == 0) {
                this.f55725e = View.MeasureSpec.getSize(i2);
                int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds176);
                this.f55726f = dimensionPixelSize;
                this.f55727g = (this.f55725e - this.f55728h) / 3;
                this.f55730j = dimensionPixelSize / 2;
                for (int i4 = 0; i4 < 4; i4++) {
                    int i5 = this.f55727g;
                    int i6 = this.f55730j;
                    int i7 = this.f55729i;
                    this.t.add(new Rect(i5 * i4, i6 - (i7 / 2), (i5 * i4) + this.f55728h, i6 + (i7 / 2)));
                }
            }
            setMeasuredDimension(this.f55725e, this.f55726f);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 2) {
                int i2 = 0;
                while (true) {
                    if (i2 > 3) {
                        break;
                    } else if (this.t.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                        this.n = i2;
                        b.a(Math.abs(i2 - 3));
                        invalidate();
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
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
        this.n = 1;
        this.t = new ArrayList<>(4);
        this.u = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.v = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.w = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);
        d(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i2) {
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
        this.n = 1;
        this.t = new ArrayList<>(4);
        this.u = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.v = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.w = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);
        d(context);
    }
}
