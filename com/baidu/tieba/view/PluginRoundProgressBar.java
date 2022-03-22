package com.baidu.tieba.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class PluginRoundProgressBar extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint a;

    /* renamed from: b  reason: collision with root package name */
    public int f36941b;

    /* renamed from: c  reason: collision with root package name */
    public int f36942c;

    /* renamed from: d  reason: collision with root package name */
    public int f36943d;

    /* renamed from: e  reason: collision with root package name */
    public float f36944e;

    /* renamed from: f  reason: collision with root package name */
    public float f36945f;

    /* renamed from: g  reason: collision with root package name */
    public int f36946g;

    /* renamed from: h  reason: collision with root package name */
    public int f36947h;
    public boolean i;
    public int j;
    public RectF k;
    public a l;

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PluginRoundProgressBar(Context context) {
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

    public synchronized int getMax() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                i = this.f36946g;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public synchronized int getProgress() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                i = this.f36947h;
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            int width = getWidth() / 2;
            float f2 = width;
            int i2 = (int) ((f2 - (this.f36945f / 2.0f)) - 5.0f);
            this.a.setColor(this.f36941b);
            this.a.setStyle(Paint.Style.STROKE);
            this.a.setStrokeWidth(this.f36945f);
            this.a.setAntiAlias(true);
            canvas.drawCircle(f2, f2, i2, this.a);
            this.a.setStyle(Paint.Style.FILL);
            this.a.setStrokeWidth(0.0f);
            this.a.setColor(this.f36943d);
            this.a.setTextSize(this.f36944e);
            int i3 = (int) ((this.f36947h / this.f36946g) * 100.0f);
            float measureText = this.a.measureText(i3 + "%");
            if (this.i && this.j == 0) {
                if (i3 == 0) {
                    i3 = 1;
                }
                canvas.drawText(i3 + "%", f2 - (measureText / 2.0f), f2 + (this.f36944e / 2.0f), this.a);
            }
            this.a.setStrokeWidth(this.f36945f);
            this.a.setColor(this.f36942c);
            float f3 = width - i2;
            float f4 = width + i2;
            this.k.set(f3, f3, f4, f4);
            int i4 = this.j;
            if (i4 == 0) {
                this.a.setStyle(Paint.Style.STROKE);
                canvas.drawArc(this.k, -90.0f, (this.f36947h * 360) / this.f36946g, false, this.a);
            } else if (i4 != 1) {
            } else {
                this.a.setStyle(Paint.Style.FILL_AND_STROKE);
                if (this.f36947h != 0) {
                    canvas.drawArc(this.k, -90.0f, (i * 360) / this.f36946g, true, this.a);
                }
            }
        }
    }

    public synchronized void setMax(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            synchronized (this) {
                if (i >= 0) {
                    this.f36946g = i;
                } else {
                    throw new IllegalArgumentException("max not less than 0");
                }
            }
        }
    }

    public void setOnProgressChangeListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.l = aVar;
        }
    }

    public synchronized void setProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            synchronized (this) {
                if (i >= 0) {
                    if (i > this.f36946g) {
                        i = this.f36946g;
                    }
                    if (i <= this.f36946g) {
                        this.f36947h = i;
                        if (this.l != null) {
                            this.l.a(i);
                        }
                        postInvalidate();
                    }
                } else {
                    throw new IllegalArgumentException("progress not less than 0");
                }
            }
        }
    }

    public void setRoundColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.f36941b = i;
        }
    }

    public void setRoundProgressColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.f36942c = i;
        }
    }

    public void setTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.f36943d = i;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PluginRoundProgressBar(Context context, AttributeSet attributeSet) {
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
    public PluginRoundProgressBar(Context context, AttributeSet attributeSet, int i) {
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
        this.a = new Paint();
        this.k = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040508, R.attr.obfuscated_res_0x7f04050a, R.attr.obfuscated_res_0x7f04050c, R.attr.obfuscated_res_0x7f04050d, R.attr.obfuscated_res_0x7f04050e, R.attr.obfuscated_res_0x7f04050f, R.attr.obfuscated_res_0x7f040510, R.attr.obfuscated_res_0x7f040511, R.attr.obfuscated_res_0x7f040592, R.attr.obfuscated_res_0x7f04061b});
        this.f36941b = obtainStyledAttributes.getColor(0, getResources().getColor(R.color.obfuscated_res_0x7f0608d9));
        this.f36942c = obtainStyledAttributes.getColor(2, getResources().getColor(R.color.obfuscated_res_0x7f060443));
        this.f36943d = obtainStyledAttributes.getColor(4, getResources().getColor(R.color.obfuscated_res_0x7f0608ba));
        this.f36944e = obtainStyledAttributes.getDimension(6, n.d(getContext(), 11.0f));
        this.f36945f = obtainStyledAttributes.getDimension(7, 7.0f);
        this.f36946g = obtainStyledAttributes.getInteger(1, 100);
        this.i = obtainStyledAttributes.getBoolean(5, true);
        this.j = obtainStyledAttributes.getInt(3, 0);
        obtainStyledAttributes.recycle();
    }
}
