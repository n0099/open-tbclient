package com.baidu.tieba.write.editor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.k0.g;
import c.a.t0.o4.d;
import c.a.t0.o4.e;
import c.a.t0.o4.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
import com.baidu.tieba.write.write.WriteActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class StateSwitchView extends EditorInfoView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NORMAL_STATE = 0;
    public static final int PRESSED_STATE = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public String f51629f;

    /* renamed from: g  reason: collision with root package name */
    public String f51630g;

    /* renamed from: h  reason: collision with root package name */
    public int f51631h;

    /* renamed from: i  reason: collision with root package name */
    public int f51632i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f51633j;

    /* renamed from: k  reason: collision with root package name */
    public AbsSvgType f51634k;
    public AbsSvgType l;
    public int m;
    public g n;
    public int o;
    public int p;

    /* loaded from: classes13.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ StateSwitchView f51635e;

        public a(StateSwitchView stateSwitchView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {stateSwitchView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51635e = stateSwitchView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f51635e.n.I();
            }
        }
    }

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
        this.f51633j = false;
        this.o = 3;
        b();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c();
            d();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.m = 0;
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int dimension = (int) getResources().getDimension(e.ds26);
            setPadding(dimension, 0, dimension, 0);
            f();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void e() {
        Drawable drawable;
        AbsSvgType absSvgType;
        Drawable drawable2;
        AbsSvgType absSvgType2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(e.tbds48);
            int i2 = this.m;
            if (i2 == 1) {
                if (this.f51633j && (absSvgType2 = this.l) != null) {
                    drawable2 = absSvgType2.getDrawable();
                } else {
                    int i3 = this.f51632i;
                    drawable2 = i3 > 0 ? SkinManager.getDrawable(i3) : null;
                }
                if (drawable2 != null) {
                    drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    setCompoundDrawables(drawable2, null, null, null);
                    setCompoundDrawablePadding(getResources().getDimensionPixelSize(e.ds8));
                }
            } else if (i2 == 0) {
                if (this.f51633j && (absSvgType = this.f51634k) != null) {
                    drawable = absSvgType.getDrawable();
                } else {
                    drawable = this.f51632i > 0 ? SkinManager.getDrawable(this.f51631h) : null;
                }
                if (drawable != null) {
                    drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    setCompoundDrawables(drawable, null, null, null);
                    setCompoundDrawablePadding(getResources().getDimensionPixelSize(e.ds8));
                }
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.m == 1) {
                setText(this.f51630g);
            } else {
                setText(this.f51629f);
            }
        }
    }

    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.m : invokeV.intValue;
    }

    public void hideTip() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (gVar = this.n) == null) {
            return;
        }
        gVar.I();
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (this.o != i2) {
                SkinManager.setViewTextColor(this, d.CAM_X0106);
                int i3 = this.p;
                if (i3 > 0) {
                    SkinManager.setBackgroundResource(this, i3);
                }
                e();
                this.o = i2;
            }
        }
    }

    public void setBackgroundId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.p = i2;
            if (i2 > 0) {
                SkinManager.setBackgroundResource(this, i2);
            }
        }
    }

    public void setLeftStateDrawable(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            this.f51631h = i2;
            this.f51632i = i3;
            this.f51633j = false;
            e();
        }
    }

    public void setState(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            if (i2 == 0 || i2 == 1) {
                this.m = i2;
            }
            f();
            e();
        }
    }

    public void setStateString(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) {
            this.f51629f = str;
            this.f51630g = str2;
            f();
        }
    }

    public void showTip(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, str2) == null) {
            if (this.n == null && (getContext() instanceof WriteActivity)) {
                g gVar = new g(((WriteActivity) getContext()).getPageContext(), this);
                this.n = gVar;
                gVar.g0(f.pic_sign_tip_down);
                this.n.M(new a(this));
                int dimensionPixelSize = getResources().getDimensionPixelSize(e.ds10);
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(e.ds24);
                this.n.Z(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
                this.n.j0(0);
                this.n.k0(-67);
                this.n.N(5000);
            }
            g gVar2 = this.n;
            if (gVar2 != null) {
                gVar2.m0(str, str2);
            }
        }
    }

    public void updateState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.m == 0) {
                this.m = 1;
            } else {
                this.m = 0;
            }
            f();
            e();
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
        this.f51633j = false;
        this.o = 3;
        b();
    }

    public void setLeftStateDrawable(AbsSvgType absSvgType, AbsSvgType absSvgType2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, absSvgType, absSvgType2) == null) || absSvgType == null || absSvgType2 == null) {
            return;
        }
        this.f51633j = true;
        this.f51634k = absSvgType;
        this.l = absSvgType2;
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
        this.f51633j = false;
        this.o = 3;
        b();
    }
}
