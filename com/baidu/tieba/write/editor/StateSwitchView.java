package com.baidu.tieba.write.editor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class StateSwitchView extends EditorInfoView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String d;
    public String e;
    public int f;
    public int g;
    public boolean h;
    public AbsSvgType i;
    public AbsSvgType j;
    public int k;
    public int l;
    public int m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StateSwitchView(Context context) {
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
        this.h = false;
        this.l = 3;
        b();
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.a(i);
            if (this.l != i) {
                SkinManager.setViewTextColor(this, (int) R.color.CAM_X0106);
                int i2 = this.m;
                if (i2 > 0) {
                    SkinManager.setBackgroundResource(this, i2);
                }
                e();
                this.l = i;
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c();
            d();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.k = 0;
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int dimension = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f0701f0);
            setPadding(dimension, 0, dimension, 0);
            f();
            a(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void e() {
        Drawable drawable;
        AbsSvgType absSvgType;
        Drawable drawable2;
        AbsSvgType absSvgType2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds48);
            int i = this.k;
            if (i == 1) {
                if (this.h && (absSvgType2 = this.j) != null) {
                    drawable2 = absSvgType2.getDrawable();
                } else {
                    int i2 = this.g;
                    drawable2 = i2 > 0 ? SkinManager.getDrawable(i2) : null;
                }
                if (drawable2 != null) {
                    drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    setCompoundDrawables(drawable2, null, null, null);
                    setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070302));
                }
            } else if (i == 0) {
                if (this.h && (absSvgType = this.i) != null) {
                    drawable = absSvgType.getDrawable();
                } else {
                    drawable = this.g > 0 ? SkinManager.getDrawable(this.f) : null;
                }
                if (drawable != null) {
                    drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    setCompoundDrawables(drawable, null, null, null);
                    setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070302));
                }
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.k == 1) {
                setText(this.e);
            } else {
                setText(this.d);
            }
        }
    }

    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.k : invokeV.intValue;
    }

    public void setBackgroundId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.m = i;
            if (i > 0) {
                SkinManager.setBackgroundResource(this, i);
            }
        }
    }

    public void setLeftStateDrawable(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
            this.f = i;
            this.g = i2;
            this.h = false;
            e();
        }
    }

    public void setState(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            if (i == 0 || i == 1) {
                this.k = i;
            }
            f();
            e();
        }
    }

    public void setStateString(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
            this.d = str;
            this.e = str2;
            f();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StateSwitchView(Context context, AttributeSet attributeSet) {
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
        this.h = false;
        this.l = 3;
        b();
    }

    public void setLeftStateDrawable(AbsSvgType absSvgType, AbsSvgType absSvgType2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, absSvgType, absSvgType2) == null) || absSvgType == null || absSvgType2 == null) {
            return;
        }
        this.h = true;
        this.i = absSvgType;
        this.j = absSvgType2;
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StateSwitchView(Context context, AttributeSet attributeSet, int i) {
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
        this.h = false;
        this.l = 3;
        b();
    }
}
