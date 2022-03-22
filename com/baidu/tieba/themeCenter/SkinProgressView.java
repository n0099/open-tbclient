package com.baidu.tieba.themeCenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class SkinProgressView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f36288b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f36289c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f36290d;

    /* renamed from: e  reason: collision with root package name */
    public int f36291e;

    /* renamed from: f  reason: collision with root package name */
    public int f36292f;

    /* renamed from: g  reason: collision with root package name */
    public int f36293g;

    /* renamed from: h  reason: collision with root package name */
    public int f36294h;
    public float i;
    public float j;
    public int k;
    public String l;
    public float m;
    public float n;
    public boolean o;
    public DressItemData p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkinProgressView(Context context) {
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
        this.o = false;
        this.a = context;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.k = n.f(this.a, R.dimen.obfuscated_res_0x7f0702df);
            this.f36293g = n.f(this.a, R.dimen.obfuscated_res_0x7f0702b3);
            this.f36291e = R.color.CAM_X0302;
            this.f36294h = R.color.CAM_X0108;
            Paint paint = new Paint();
            this.f36288b = paint;
            paint.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.f36290d = paint2;
            paint2.setAntiAlias(true);
            Paint paint3 = new Paint();
            this.f36289c = paint3;
            paint3.setAntiAlias(true);
            this.f36289c.setTextSize(this.f36293g);
            this.f36289c.setTextAlign(Paint.Align.CENTER);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void b(int i, float f2, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            this.o = false;
            setEnabled(true);
            if (i != 9) {
                switch (i) {
                    case 0:
                        if (i4 == 1) {
                            setText(R.string.obfuscated_res_0x7f0f02bc);
                        } else if (i4 == 2) {
                            setText(R.string.obfuscated_res_0x7f0f02bd);
                        } else {
                            setText(R.string.obfuscated_res_0x7f0f1388);
                            setEnabled(false);
                        }
                        setTextColor(R.color.CAM_X0105);
                        break;
                    case 1:
                        if (i2 == 0) {
                            setText(R.string.obfuscated_res_0x7f0f04f1);
                            setTextColor(R.color.CAM_X0105);
                            break;
                        } else {
                            setTextColor(R.color.CAM_X0101);
                            setBgColor(R.color.CAM_X0312);
                            this.o = true;
                            if (i2 != 100) {
                                if (i2 != 101) {
                                    if (i2 <= 1) {
                                        setText(R.string.obfuscated_res_0x7f0f02f6);
                                        break;
                                    } else {
                                        setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0339), Integer.valueOf(i2)));
                                        break;
                                    }
                                } else {
                                    setText(R.string.obfuscated_res_0x7f0f0338);
                                    break;
                                }
                            } else if (i3 == 0) {
                                setText(R.string.obfuscated_res_0x7f0f0337);
                                setBgColor(R.color.CAM_X0302);
                                break;
                            } else {
                                setText(R.string.obfuscated_res_0x7f0f04e3);
                                setBgColor(R.color.CAM_X0302);
                                break;
                            }
                        }
                    case 2:
                        setText(R.string.obfuscated_res_0x7f0f036c);
                        if (f2 > 0.5d) {
                            setTextColor(R.color.CAM_X0101);
                            break;
                        } else {
                            setTextColor(R.color.CAM_X0105);
                            break;
                        }
                    case 3:
                        if (i2 == 0) {
                            setText(R.string.obfuscated_res_0x7f0f04f1);
                            setTextColor(R.color.CAM_X0105);
                            break;
                        } else {
                            setText(R.string.obfuscated_res_0x7f0f02f6);
                            setTextColor(R.color.CAM_X0101);
                            setBgColor(R.color.CAM_X0312);
                            this.o = true;
                            break;
                        }
                    case 4:
                        setText(R.string.obfuscated_res_0x7f0f149c);
                        setTextColor(R.color.CAM_X0105);
                        break;
                    case 5:
                        setText(R.string.obfuscated_res_0x7f0f1389);
                        setTextColor(R.color.CAM_X0105);
                        break;
                    case 6:
                        setText(R.string.obfuscated_res_0x7f0f008a);
                        setTextColor(R.color.CAM_X0105);
                        setBgColor(R.color.CAM_X0302);
                        this.o = true;
                        break;
                }
            } else {
                if (i4 == 2 && this.p.getDailyPrevilegeStatus() == 1) {
                    setText(R.string.obfuscated_res_0x7f0f149c);
                    setTextColor(R.color.CAM_X0105);
                } else if (i2 == 0) {
                    setText(R.string.obfuscated_res_0x7f0f149b);
                    setTextColor(R.color.CAM_X0105);
                } else {
                    setTextColor(R.color.CAM_X0101);
                    setBgColor(R.color.CAM_X0312);
                    this.o = true;
                    if (i2 == 100) {
                        if (i3 == 0) {
                            setText(R.string.obfuscated_res_0x7f0f008a);
                            setBgColor(R.color.CAM_X0302);
                        } else {
                            setText(R.string.obfuscated_res_0x7f0f149c);
                            setBgColor(R.color.CAM_X0302);
                        }
                    } else if (i2 == 101) {
                        setText(R.string.obfuscated_res_0x7f0f02f4);
                    } else if (i2 > 1) {
                        setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f02fa), Integer.valueOf(i2)));
                    } else {
                        setText(R.string.obfuscated_res_0x7f0f02f7);
                    }
                }
                setEnabled(true);
            }
            setProgress(f2);
            invalidate();
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void c(int i, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2)}) == null) {
            setEnabled(true);
            switch (i) {
                case 0:
                    setText(R.string.obfuscated_res_0x7f0f1388);
                    setTextColor(R.color.CAM_X0105);
                    setEnabled(false);
                    break;
                case 1:
                    setText(R.string.obfuscated_res_0x7f0f04e3);
                    setTextColor(R.color.CAM_X0105);
                    break;
                case 2:
                    setText(R.string.obfuscated_res_0x7f0f036c);
                    if (f2 > 0.5d) {
                        setTextColor(R.color.CAM_X0101);
                        break;
                    } else {
                        setTextColor(R.color.CAM_X0105);
                        break;
                    }
                case 3:
                    setText(R.string.obfuscated_res_0x7f0f04e3);
                    setTextColor(R.color.CAM_X0105);
                    break;
                case 4:
                    setText(R.string.obfuscated_res_0x7f0f138b);
                    setTextColor(R.color.CAM_X0105);
                    break;
                case 5:
                    setText(R.string.obfuscated_res_0x7f0f1389);
                    setTextColor(R.color.CAM_X0105);
                    break;
                case 6:
                    setText(R.string.obfuscated_res_0x7f0f0380);
                    setTextColor(R.color.CAM_X0105);
                    break;
            }
            setProgress(f2);
            invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.o) {
                RectF rectF = new RectF(0.0f, 0.0f, this.i, this.j);
                this.f36290d.setColor(SkinManager.getColor(this.f36292f));
                int i = this.k;
                canvas.drawRoundRect(rectF, i, i, this.f36290d);
            }
            RectF rectF2 = new RectF(0.0f, 0.0f, this.i * this.m, this.j);
            this.f36288b.setColor(SkinManager.getColor(this.f36291e));
            int i2 = this.k;
            canvas.drawRoundRect(rectF2, i2, i2, this.f36288b);
            if (StringUtils.isNull(this.l)) {
                return;
            }
            this.f36289c.setColor(SkinManager.getColor(this.f36294h));
            this.f36289c.setTextSize(this.f36293g);
            float f2 = this.f36289c.getFontMetrics().bottom - this.f36289c.getFontMetrics().top;
            this.n = f2;
            float f3 = this.j;
            canvas.drawText(this.l, this.i / 2.0f, (f3 - ((f3 - f2) / 2.0f)) - this.f36289c.getFontMetrics().bottom, this.f36289c);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            super.onMeasure(i, i2);
            this.i = View.MeasureSpec.getSize(i);
            this.j = View.MeasureSpec.getSize(i2);
        }
    }

    public void setBgColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.f36292f = i;
        }
    }

    public void setDressData(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dressItemData) == null) {
            this.p = dressItemData;
        }
    }

    public void setFontSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.f36293g = i;
        }
    }

    public void setProgress(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f2) == null) {
            this.m = f2;
        }
    }

    public void setText(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.l = this.a.getResources().getString(i);
        }
    }

    public void setTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.f36294h = i;
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.l = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkinProgressView(Context context, AttributeSet attributeSet) {
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
        this.o = false;
        this.a = context;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkinProgressView(Context context, AttributeSet attributeSet, int i) {
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
        this.o = false;
        this.a = context;
        a();
    }
}
