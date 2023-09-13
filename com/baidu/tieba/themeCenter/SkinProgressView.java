package com.baidu.tieba.themeCenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
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
/* loaded from: classes8.dex */
public class SkinProgressView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public Paint b;
    public Paint c;
    public Paint d;
    public int e;
    public int f;
    public int g;
    public int h;
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

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.k = BdUtilHelper.getDimens(this.a, R.dimen.obfuscated_res_0x7f070404);
            this.g = BdUtilHelper.getDimens(this.a, R.dimen.obfuscated_res_0x7f0702b3);
            this.e = R.color.CAM_X0302;
            this.h = R.color.CAM_X0108;
            Paint paint = new Paint();
            this.b = paint;
            paint.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.d = paint2;
            paint2.setAntiAlias(true);
            Paint paint3 = new Paint();
            this.c = paint3;
            paint3.setAntiAlias(true);
            this.c.setTextSize(this.g);
            this.c.setTextAlign(Paint.Align.CENTER);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void b(int i, float f, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            this.o = false;
            setEnabled(true);
            if (i != 9) {
                switch (i) {
                    case 0:
                        if (i4 == 1) {
                            setText(R.string.obfuscated_res_0x7f0f030d);
                        } else if (i4 == 2) {
                            setText(R.string.obfuscated_res_0x7f0f030e);
                        } else {
                            setText(R.string.obfuscated_res_0x7f0f1650);
                            setEnabled(false);
                        }
                        setTextColor(R.color.CAM_X0105);
                        break;
                    case 1:
                        if (i2 == 0) {
                            setText(R.string.download_free);
                            setTextColor(R.color.CAM_X0105);
                            break;
                        } else {
                            setTextColor(R.color.CAM_X0101);
                            setBgColor(R.color.CAM_X0312);
                            this.o = true;
                            if (i2 == 100) {
                                if (i3 == 0) {
                                    setText(R.string.obfuscated_res_0x7f0f039a);
                                    setBgColor(R.color.CAM_X0302);
                                    break;
                                } else {
                                    setText(R.string.obfuscated_res_0x7f0f05b0);
                                    setBgColor(R.color.CAM_X0302);
                                    break;
                                }
                            } else if (i2 == 101) {
                                setText(R.string.obfuscated_res_0x7f0f039b);
                                break;
                            } else if (i2 > 1) {
                                setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f03a4), Integer.valueOf(i2)));
                                break;
                            } else {
                                setText(R.string.obfuscated_res_0x7f0f034d);
                                break;
                            }
                        }
                    case 2:
                        setText(R.string.obfuscated_res_0x7f0f03d0);
                        if (f > 0.5d) {
                            setTextColor(R.color.CAM_X0101);
                            break;
                        } else {
                            setTextColor(R.color.CAM_X0105);
                            break;
                        }
                    case 3:
                        if (i2 == 0) {
                            setText(R.string.download_free);
                            setTextColor(R.color.CAM_X0105);
                            break;
                        } else {
                            setText(R.string.obfuscated_res_0x7f0f034d);
                            setTextColor(R.color.CAM_X0101);
                            setBgColor(R.color.CAM_X0312);
                            this.o = true;
                            break;
                        }
                    case 4:
                        setText(R.string.use_immediately);
                        setTextColor(R.color.CAM_X0105);
                        break;
                    case 5:
                        setText(R.string.theme_need_update);
                        setTextColor(R.color.CAM_X0105);
                        break;
                    case 6:
                        setText(R.string.obfuscated_res_0x7f0f00b9);
                        setTextColor(R.color.CAM_X0105);
                        setBgColor(R.color.CAM_X0302);
                        this.o = true;
                        break;
                }
            } else {
                if (i4 == 2 && this.p.getDailyPrevilegeStatus() == 1) {
                    setText(R.string.use_immediately);
                    setTextColor(R.color.CAM_X0105);
                } else if (i2 == 0) {
                    setText(R.string.obfuscated_res_0x7f0f17d7);
                    setTextColor(R.color.CAM_X0105);
                } else {
                    setTextColor(R.color.CAM_X0101);
                    setBgColor(R.color.CAM_X0312);
                    this.o = true;
                    if (i2 == 100) {
                        if (i3 == 0) {
                            setText(R.string.obfuscated_res_0x7f0f00b9);
                            setBgColor(R.color.CAM_X0302);
                        } else {
                            setText(R.string.use_immediately);
                            setBgColor(R.color.CAM_X0302);
                        }
                    } else if (i2 == 101) {
                        setText(R.string.obfuscated_res_0x7f0f034b);
                    } else if (i2 > 1) {
                        setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0351), Integer.valueOf(i2)));
                    } else {
                        setText(R.string.obfuscated_res_0x7f0f034e);
                    }
                }
                setEnabled(true);
            }
            setProgress(f);
            invalidate();
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void c(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            setEnabled(true);
            switch (i) {
                case 0:
                    setText(R.string.obfuscated_res_0x7f0f1650);
                    setTextColor(R.color.CAM_X0105);
                    setEnabled(false);
                    break;
                case 1:
                    setText(R.string.obfuscated_res_0x7f0f05b0);
                    setTextColor(R.color.CAM_X0105);
                    break;
                case 2:
                    setText(R.string.obfuscated_res_0x7f0f03d0);
                    if (f > 0.5d) {
                        setTextColor(R.color.CAM_X0101);
                        break;
                    } else {
                        setTextColor(R.color.CAM_X0105);
                        break;
                    }
                case 3:
                    setText(R.string.obfuscated_res_0x7f0f05b0);
                    setTextColor(R.color.CAM_X0105);
                    break;
                case 4:
                    setText(R.string.obfuscated_res_0x7f0f1653);
                    setTextColor(R.color.CAM_X0105);
                    break;
                case 5:
                    setText(R.string.theme_need_update);
                    setTextColor(R.color.CAM_X0105);
                    break;
                case 6:
                    setText(R.string.card_promotion_text);
                    setTextColor(R.color.CAM_X0105);
                    break;
            }
            setProgress(f);
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
                this.d.setColor(SkinManager.getColor(this.f));
                int i = this.k;
                canvas.drawRoundRect(rectF, i, i, this.d);
            }
            RectF rectF2 = new RectF(0.0f, 0.0f, this.i * this.m, this.j);
            this.b.setColor(SkinManager.getColor(this.e));
            int i2 = this.k;
            canvas.drawRoundRect(rectF2, i2, i2, this.b);
            if (StringUtils.isNull(this.l)) {
                return;
            }
            this.c.setColor(SkinManager.getColor(this.h));
            this.c.setTextSize(this.g);
            float f = this.c.getFontMetrics().bottom - this.c.getFontMetrics().top;
            this.n = f;
            float f2 = this.j;
            canvas.drawText(this.l, this.i / 2.0f, (f2 - ((f2 - f) / 2.0f)) - this.c.getFontMetrics().bottom, this.c);
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
            this.f = i;
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
            this.g = i;
        }
    }

    public void setProgress(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f) == null) {
            this.m = f;
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
            this.h = i;
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.l = str;
        }
    }
}
