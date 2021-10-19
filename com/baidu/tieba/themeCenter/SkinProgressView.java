package com.baidu.tieba.themeCenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
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
/* loaded from: classes7.dex */
public class SkinProgressView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f57438e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f57439f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f57440g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f57441h;

    /* renamed from: i  reason: collision with root package name */
    public int f57442i;

    /* renamed from: j  reason: collision with root package name */
    public int f57443j;
    public int k;
    public int l;
    public float m;
    public float n;
    public int o;
    public String p;
    public float q;
    public float r;
    public boolean s;
    public DressItemData t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkinProgressView(Context context) {
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
        this.s = false;
        this.f57438e = context;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.o = l.g(this.f57438e, R.dimen.ds6);
            this.k = l.g(this.f57438e, R.dimen.fontsize24);
            this.f57442i = R.color.CAM_X0302;
            this.l = R.color.CAM_X0108;
            Paint paint = new Paint();
            this.f57439f = paint;
            paint.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.f57441h = paint2;
            paint2.setAntiAlias(true);
            Paint paint3 = new Paint();
            this.f57440g = paint3;
            paint3.setAntiAlias(true);
            this.f57440g.setTextSize(this.k);
            this.f57440g.setTextAlign(Paint.Align.CENTER);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.s) {
                RectF rectF = new RectF(0.0f, 0.0f, this.m, this.n);
                this.f57441h.setColor(SkinManager.getColor(this.f57443j));
                int i2 = this.o;
                canvas.drawRoundRect(rectF, i2, i2, this.f57441h);
            }
            RectF rectF2 = new RectF(0.0f, 0.0f, this.m * this.q, this.n);
            this.f57439f.setColor(SkinManager.getColor(this.f57442i));
            int i3 = this.o;
            canvas.drawRoundRect(rectF2, i3, i3, this.f57439f);
            if (StringUtils.isNull(this.p)) {
                return;
            }
            this.f57440g.setColor(SkinManager.getColor(this.l));
            this.f57440g.setTextSize(this.k);
            float f2 = this.f57440g.getFontMetrics().bottom - this.f57440g.getFontMetrics().top;
            this.r = f2;
            float f3 = this.n;
            canvas.drawText(this.p, this.m / 2.0f, (f3 - ((f3 - f2) / 2.0f)) - this.f57440g.getFontMetrics().bottom, this.f57440g);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            this.m = View.MeasureSpec.getSize(i2);
            this.n = View.MeasureSpec.getSize(i3);
        }
    }

    public void setBgColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f57443j = i2;
        }
    }

    public void setDressData(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dressItemData) == null) {
            this.t = dressItemData;
        }
    }

    public void setFontSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.k = i2;
        }
    }

    public void setProgress(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
            this.q = f2;
        }
    }

    public void setText(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.p = this.f57438e.getResources().getString(i2);
        }
    }

    public void setTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.l = i2;
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void updateStatuesInSkinDetail(int i2, float f2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            this.s = false;
            setEnabled(true);
            if (i2 != 9) {
                switch (i2) {
                    case 0:
                        if (i5 == 1) {
                            setText(R.string.back_to_home);
                        } else if (i5 == 2) {
                            setText(R.string.back_to_person);
                        } else {
                            setText(R.string.theme_in_use);
                            setEnabled(false);
                        }
                        setTextColor(R.color.CAM_X0105);
                        break;
                    case 1:
                        if (i3 == 0) {
                            setText(R.string.download_free);
                            setTextColor(R.color.CAM_X0105);
                            break;
                        } else {
                            setTextColor(R.color.CAM_X0101);
                            setBgColor(R.color.CAM_X0312);
                            this.s = true;
                            if (i3 != 100) {
                                if (i3 != 101) {
                                    if (i3 <= 1) {
                                        setText(R.string.become_member_download_free);
                                        break;
                                    } else {
                                        setText(String.format(this.f57438e.getString(R.string.btn_vip_can_download_free), Integer.valueOf(i3)));
                                        break;
                                    }
                                } else {
                                    setText(R.string.btn_annual_download_free);
                                    break;
                                }
                            } else if (i4 == 0) {
                                setText(R.string.btn_activity_skin_free);
                                setBgColor(R.color.CAM_X0302);
                                break;
                            } else {
                                setText(R.string.download);
                                setBgColor(R.color.CAM_X0302);
                                break;
                            }
                        }
                    case 2:
                        setText(R.string.cancel);
                        if (f2 > 0.5d) {
                            setTextColor(R.color.CAM_X0101);
                            break;
                        } else {
                            setTextColor(R.color.CAM_X0105);
                            break;
                        }
                    case 3:
                        if (i3 == 0) {
                            setText(R.string.download_free);
                            setTextColor(R.color.CAM_X0105);
                            break;
                        } else {
                            setText(R.string.become_member_download_free);
                            setTextColor(R.color.CAM_X0101);
                            setBgColor(R.color.CAM_X0312);
                            this.s = true;
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
                        setText(R.string.activity_free_use);
                        setTextColor(R.color.CAM_X0105);
                        setBgColor(R.color.CAM_X0302);
                        this.s = true;
                        break;
                }
            } else {
                if (i5 == 2 && this.t.getDailyPrevilegeStatus() == 1) {
                    setText(R.string.use_immediately);
                    setTextColor(R.color.CAM_X0105);
                } else if (i3 == 0) {
                    setText(R.string.use_freely);
                    setTextColor(R.color.CAM_X0105);
                } else {
                    setTextColor(R.color.CAM_X0101);
                    setBgColor(R.color.CAM_X0312);
                    this.s = true;
                    if (i3 == 100) {
                        if (i4 == 0) {
                            setText(R.string.activity_free_use);
                            setBgColor(R.color.CAM_X0302);
                        } else {
                            setText(R.string.use_immediately);
                            setBgColor(R.color.CAM_X0302);
                        }
                    } else if (i3 == 101) {
                        setText(R.string.become_annual_free_use);
                    } else if (i3 > 1) {
                        setText(String.format(this.f57438e.getString(R.string.become_vip_free_use), Integer.valueOf(i3)));
                    } else {
                        setText(R.string.become_member_free_use);
                    }
                }
                setEnabled(true);
            }
            setProgress(f2);
            invalidate();
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void updateStatus(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            setEnabled(true);
            switch (i2) {
                case 0:
                    setText(R.string.theme_in_use);
                    setTextColor(R.color.CAM_X0105);
                    setEnabled(false);
                    break;
                case 1:
                    setText(R.string.download);
                    setTextColor(R.color.CAM_X0105);
                    break;
                case 2:
                    setText(R.string.cancel);
                    if (f2 > 0.5d) {
                        setTextColor(R.color.CAM_X0101);
                        break;
                    } else {
                        setTextColor(R.color.CAM_X0105);
                        break;
                    }
                case 3:
                    setText(R.string.download);
                    setTextColor(R.color.CAM_X0105);
                    break;
                case 4:
                    setText(R.string.theme_use);
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
            setProgress(f2);
            invalidate();
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.p = str;
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
        this.s = false;
        this.f57438e = context;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkinProgressView(Context context, AttributeSet attributeSet, int i2) {
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
        this.s = false;
        this.f57438e = context;
        a();
    }
}
