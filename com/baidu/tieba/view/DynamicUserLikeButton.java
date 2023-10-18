package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.a55;
import com.baidu.tieba.b65;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class DynamicUserLikeButton extends TBSpecificationBtn implements b65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a o;
    public boolean p;
    public boolean q;

    /* loaded from: classes8.dex */
    public interface a {
        void a(View view2);
    }

    @Override // com.baidu.tieba.b65
    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DynamicUserLikeButton(Context context) {
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DynamicUserLikeButton(Context context, @Nullable AttributeSet attributeSet) {
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
    public DynamicUserLikeButton(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        a55 a55Var = new a55();
        a55Var.u(R.color.CAM_X0302);
        setConfig(a55Var);
        setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02ec));
    }

    @Override // com.baidu.tieba.b65
    public void a(View view2) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (aVar = this.o) != null) {
            aVar.a(view2);
        }
    }

    @Override // com.baidu.tieba.b65
    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            setOnClickListener(onClickListener);
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            k();
        }
    }

    public void setGodRecommendStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.q = z;
        }
    }

    public void setOnClickEvent(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.o = aVar;
        }
    }

    public void setUseNewStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.p = z;
        }
    }

    @Override // com.baidu.tieba.b65
    public void b(boolean z, int i, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Boolean.valueOf(z2)}) == null) {
            d(z, i);
        }
    }

    public void d(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            if (z) {
                q(true);
            } else {
                q(false);
            }
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (this.q) {
                if (z) {
                    a55 a55Var = new a55();
                    a55Var.t();
                    setConfig(a55Var);
                    setClickable(true);
                    setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
                } else {
                    a55 a55Var2 = new a55();
                    a55Var2.w(R.color.CAM_X0105);
                    a55Var2.h(UtilHelper.getDimenPixelSize(R.dimen.tbds24));
                    a55Var2.j(R.drawable.icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
                    a55Var2.i(R.color.CAM_X0105);
                    setConfig(a55Var2);
                    setClickable(true);
                    setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02ec));
                }
            } else if (z) {
                a55 a55Var3 = new a55();
                a55Var3.v(R.color.CAM_X0109);
                setConfig(a55Var3);
                setClickable(true);
                setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            } else {
                a55 a55Var4 = new a55();
                a55Var4.u(R.color.CAM_X0302);
                if (this.p) {
                    a55Var4.h(UtilHelper.getDimenPixelSize(R.dimen.tbds24));
                    a55Var4.j(R.drawable.icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
                }
                setConfig(a55Var4);
                setClickable(true);
                setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02ec));
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
