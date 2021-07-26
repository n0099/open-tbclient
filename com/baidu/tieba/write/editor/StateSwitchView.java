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

    /* renamed from: h  reason: collision with root package name */
    public String f22760h;

    /* renamed from: i  reason: collision with root package name */
    public String f22761i;
    public int j;
    public int k;
    public boolean l;
    public AbsSvgType m;
    public AbsSvgType n;
    public int o;
    public int p;
    public int q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StateSwitchView(Context context) {
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
        this.l = false;
        this.p = 3;
        b();
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.a(i2);
            if (this.p != i2) {
                SkinManager.setViewTextColor(this, R.color.CAM_X0106);
                int i3 = this.q;
                if (i3 > 0) {
                    SkinManager.setBackgroundResource(this, i3);
                }
                e();
                this.p = i2;
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
            this.o = 0;
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int dimension = (int) getResources().getDimension(R.dimen.ds26);
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
            int i2 = this.o;
            if (i2 == 1) {
                if (this.l && (absSvgType2 = this.n) != null) {
                    drawable2 = absSvgType2.getDrawable();
                } else {
                    int i3 = this.k;
                    drawable2 = i3 > 0 ? SkinManager.getDrawable(i3) : null;
                }
                if (drawable2 != null) {
                    drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    setCompoundDrawables(drawable2, null, null, null);
                    setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
                }
            } else if (i2 == 0) {
                if (this.l && (absSvgType = this.m) != null) {
                    drawable = absSvgType.getDrawable();
                } else {
                    drawable = this.k > 0 ? SkinManager.getDrawable(this.j) : null;
                }
                if (drawable != null) {
                    drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    setCompoundDrawables(drawable, null, null, null);
                    setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
                }
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.o == 1) {
                setText(this.f22761i);
            } else {
                setText(this.f22760h);
            }
        }
    }

    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.o : invokeV.intValue;
    }

    public void setBackgroundId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.q = i2;
            if (i2 > 0) {
                SkinManager.setBackgroundResource(this, i2);
            }
        }
    }

    public void setLeftStateDrawable(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            this.j = i2;
            this.k = i3;
            this.l = false;
            e();
        }
    }

    public void setState(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            if (i2 == 0 || i2 == 1) {
                this.o = i2;
            }
            f();
            e();
        }
    }

    public void setStateString(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
            this.f22760h = str;
            this.f22761i = str2;
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
        this.l = false;
        this.p = 3;
        b();
    }

    public void setLeftStateDrawable(AbsSvgType absSvgType, AbsSvgType absSvgType2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, absSvgType, absSvgType2) == null) || absSvgType == null || absSvgType2 == null) {
            return;
        }
        this.l = true;
        this.m = absSvgType;
        this.n = absSvgType2;
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StateSwitchView(Context context, AttributeSet attributeSet, int i2) {
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
        this.l = false;
        this.p = 3;
        b();
    }
}
