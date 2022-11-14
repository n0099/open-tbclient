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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.py7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class TextSizeSeekBar extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public Paint g;
    public int h;
    public Drawable i;
    public int j;
    public String[] k;
    public int l;
    public int m;
    public int n;
    public int o;
    public ArrayList<Rect> p;
    public int q;
    public int r;
    public int s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextSizeSeekBar(Context context) {
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
        this.j = 1;
        this.p = new ArrayList<>(4);
        this.q = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070298);
        this.r = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07023b);
        this.s = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);
        d(context);
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
        this.j = 1;
        this.p = new ArrayList<>(4);
        this.q = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070298);
        this.r = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07023b);
        this.s = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);
        d(context);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
            super.onMeasure(i, i2);
            if (this.a == 0 || this.b == 0) {
                this.a = View.MeasureSpec.getSize(i);
                int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07025d);
                this.b = dimensionPixelSize;
                this.c = (this.a - this.d) / 3;
                this.f = dimensionPixelSize / 2;
                for (int i3 = 0; i3 < 4; i3++) {
                    int i4 = this.c;
                    int i5 = this.f;
                    int i6 = this.e;
                    this.p.add(new Rect(i4 * i3, i5 - (i6 / 2), (i4 * i3) + this.d, i5 + (i6 / 2)));
                }
            }
            setMeasuredDimension(this.a, this.b);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
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
        this.j = 1;
        this.p = new ArrayList<>(4);
        this.q = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070298);
        this.r = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07023b);
        this.s = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);
        d(context);
    }

    public final void a(Canvas canvas) {
        Rect rect;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) && (rect = (Rect) ListUtils.getItem(this.p, this.j)) != null && (drawable = this.i) != null) {
            drawable.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.i.draw(canvas);
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

    public final void b(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            this.g.setColor(this.n);
            this.g.setStrokeWidth(this.q);
            int i = this.d;
            int i2 = this.f;
            canvas.drawLine((float) (i / 2.0d), i2, (float) (this.a - (i / 2.0d)), i2, this.g);
            this.g.setStrokeWidth(this.r);
            this.g.setStrokeCap(Paint.Cap.ROUND);
            for (int i3 = 0; i3 < 4; i3++) {
                canvas.drawPoint((this.c * i3) + (this.d / 2), this.f, this.g);
            }
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            for (int i = 0; i < this.k.length; i++) {
                if (i == this.j) {
                    this.g.setColor(this.l);
                } else {
                    this.g.setColor(this.m);
                }
                this.g.setTextSize(this.h);
                this.g.setTextAlign(Paint.Align.CENTER);
                canvas.drawText(this.k[i], (this.c * i) + (this.d / 2), this.f - this.s, this.g);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 2) {
                int i = 0;
                while (true) {
                    if (i > 3) {
                        break;
                    } else if (this.p.get(i).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                        this.j = i;
                        py7.a(Math.abs(i - 3));
                        invalidate();
                        break;
                    } else {
                        i++;
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds102);
            Paint paint = new Paint();
            this.g = paint;
            paint.setAntiAlias(true);
            this.g.setDither(true);
            this.g.setFilterBitmap(true);
            this.i = SkinManager.getDrawable(R.drawable.pic_wordsize_n);
            this.d = dimensionPixelSize;
            this.e = dimensionPixelSize;
            this.h = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.T_X09);
            this.k = new String[]{context.getString(R.string.obfuscated_res_0x7f0f066b), context.getString(R.string.obfuscated_res_0x7f0f066a), context.getString(R.string.obfuscated_res_0x7f0f0669), context.getString(R.string.obfuscated_res_0x7f0f066c)};
            this.l = SkinManager.getColor(R.color.CAM_X0105);
            this.m = SkinManager.getColor(R.color.CAM_X0109);
            this.n = SkinManager.getColor(R.color.CAM_X0111);
            this.o = TbadkCoreApplication.getInst().getSkinType();
            this.j = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.o != TbadkCoreApplication.getInst().getSkinType()) {
            this.o = TbadkCoreApplication.getInst().getSkinType();
            if (this.i != null) {
                this.i = SkinManager.getDrawable(R.drawable.pic_wordsize_n);
            }
            this.l = SkinManager.getColor(R.color.CAM_X0105);
            this.m = SkinManager.getColor(R.color.CAM_X0109);
            this.n = SkinManager.getColor(R.color.CAM_X0111);
            invalidate();
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.i = SkinManager.getDrawable(R.drawable.pic_wordsize_n);
            this.j = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
            super.onAttachedToWindow();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDetachedFromWindow();
            Drawable drawable = this.i;
            if (drawable != null) {
                drawable.setCallback(null);
                this.i = null;
            }
        }
    }
}
