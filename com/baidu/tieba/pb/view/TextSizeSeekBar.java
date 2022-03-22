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
import c.a.p0.w2.j.b;
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
/* loaded from: classes5.dex */
public class TextSizeSeekBar extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f35297b;

    /* renamed from: c  reason: collision with root package name */
    public int f35298c;

    /* renamed from: d  reason: collision with root package name */
    public int f35299d;

    /* renamed from: e  reason: collision with root package name */
    public int f35300e;

    /* renamed from: f  reason: collision with root package name */
    public int f35301f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f35302g;

    /* renamed from: h  reason: collision with root package name */
    public int f35303h;
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
        this.q = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070291);
        this.r = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070234);
        this.s = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);
        d(context);
    }

    public final void a(Canvas canvas) {
        Rect rect;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) || (rect = (Rect) ListUtils.getItem(this.p, this.j)) == null || (drawable = this.i) == null) {
            return;
        }
        drawable.setBounds(rect.left, rect.top, rect.right, rect.bottom);
        this.i.draw(canvas);
    }

    public final void b(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            this.f35302g.setColor(this.n);
            this.f35302g.setStrokeWidth(this.q);
            int i = this.f35299d;
            int i2 = this.f35301f;
            canvas.drawLine((float) (i / 2.0d), i2, (float) (this.a - (i / 2.0d)), i2, this.f35302g);
            this.f35302g.setStrokeWidth(this.r);
            this.f35302g.setStrokeCap(Paint.Cap.ROUND);
            for (int i3 = 0; i3 < 4; i3++) {
                canvas.drawPoint((this.f35298c * i3) + (this.f35299d / 2), this.f35301f, this.f35302g);
            }
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            for (int i = 0; i < this.k.length; i++) {
                if (i == this.j) {
                    this.f35302g.setColor(this.l);
                } else {
                    this.f35302g.setColor(this.m);
                }
                this.f35302g.setTextSize(this.f35303h);
                this.f35302g.setTextAlign(Paint.Align.CENTER);
                canvas.drawText(this.k[i], (this.f35298c * i) + (this.f35299d / 2), this.f35301f - this.s, this.f35302g);
            }
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds102);
            Paint paint = new Paint();
            this.f35302g = paint;
            paint.setAntiAlias(true);
            this.f35302g.setDither(true);
            this.f35302g.setFilterBitmap(true);
            this.i = SkinManager.getDrawable(R.drawable.pic_wordsize_n);
            this.f35299d = dimensionPixelSize;
            this.f35300e = dimensionPixelSize;
            this.f35303h = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.T_X09);
            this.k = new String[]{context.getString(R.string.obfuscated_res_0x7f0f062c), context.getString(R.string.obfuscated_res_0x7f0f062b), context.getString(R.string.obfuscated_res_0x7f0f062a), context.getString(R.string.obfuscated_res_0x7f0f062d)};
            this.l = SkinManager.getColor(R.color.CAM_X0105);
            this.m = SkinManager.getColor(R.color.CAM_X0109);
            this.n = SkinManager.getColor(R.color.CAM_X0111);
            this.o = TbadkCoreApplication.getInst().getSkinType();
            this.j = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.o == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        this.o = TbadkCoreApplication.getInst().getSkinType();
        if (this.i != null) {
            this.i = SkinManager.getDrawable(R.drawable.pic_wordsize_n);
        }
        this.l = SkinManager.getColor(R.color.CAM_X0105);
        this.m = SkinManager.getColor(R.color.CAM_X0109);
        this.n = SkinManager.getColor(R.color.CAM_X0111);
        invalidate();
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
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
            super.onMeasure(i, i2);
            if (this.a == 0 || this.f35297b == 0) {
                this.a = View.MeasureSpec.getSize(i);
                int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070255);
                this.f35297b = dimensionPixelSize;
                this.f35298c = (this.a - this.f35299d) / 3;
                this.f35301f = dimensionPixelSize / 2;
                for (int i3 = 0; i3 < 4; i3++) {
                    int i4 = this.f35298c;
                    int i5 = this.f35301f;
                    int i6 = this.f35300e;
                    this.p.add(new Rect(i4 * i3, i5 - (i6 / 2), (i4 * i3) + this.f35299d, i5 + (i6 / 2)));
                }
            }
            setMeasuredDimension(this.a, this.f35297b);
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
                        b.a(Math.abs(i - 3));
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
        this.q = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070291);
        this.r = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070234);
        this.s = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);
        d(context);
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
        this.q = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070291);
        this.r = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070234);
        this.s = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);
        d(context);
    }
}
