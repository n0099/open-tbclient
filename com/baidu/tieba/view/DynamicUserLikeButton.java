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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.pv4;
import com.repackage.sw4;
/* loaded from: classes4.dex */
public class DynamicUserLikeButton extends TBSpecificationBtn implements sw4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a o;
    public boolean p;
    public boolean q;

    /* loaded from: classes4.dex */
    public interface a {
        void a(View view2);
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

    @Override // com.repackage.sw4
    public void a(View view2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (aVar = this.o) == null) {
            return;
        }
        aVar.a(view2);
    }

    @Override // com.repackage.sw4
    public void b(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            setOnClickListener(onClickListener);
        }
    }

    @Override // com.repackage.sw4
    public void c(boolean z, int i, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Boolean.valueOf(z2)}) == null) {
            e(z, i);
        }
    }

    @Override // com.repackage.sw4
    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
        }
    }

    public void e(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            if (z) {
                s(true);
            } else {
                s(false);
            }
        }
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            k();
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (this.q) {
                if (z) {
                    pv4 pv4Var = new pv4();
                    pv4Var.q();
                    setConfig(pv4Var);
                    setClickable(true);
                    setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fbd));
                } else {
                    pv4 pv4Var2 = new pv4();
                    pv4Var2.u(R.color.CAM_X0105);
                    pv4Var2.g(UtilHelper.getDimenPixelSize(R.dimen.tbds24));
                    pv4Var2.i(R.drawable.icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
                    pv4Var2.h(R.color.CAM_X0105);
                    setConfig(pv4Var2);
                    setClickable(true);
                    setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02ab));
                }
            } else if (z) {
                pv4 pv4Var3 = new pv4();
                pv4Var3.t(R.color.CAM_X0109);
                setConfig(pv4Var3);
                setClickable(true);
                setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fbd));
            } else {
                pv4 pv4Var4 = new pv4();
                pv4Var4.r(R.color.CAM_X0302);
                if (this.p) {
                    pv4Var4.g(UtilHelper.getDimenPixelSize(R.dimen.tbds24));
                    pv4Var4.i(R.drawable.icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
                }
                setConfig(pv4Var4);
                setClickable(true);
                setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02ab));
            }
            r(TbadkCoreApplication.getInst().getSkinType());
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
        pv4 pv4Var = new pv4();
        pv4Var.r(R.color.CAM_X0302);
        setConfig(pv4Var);
        setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02ab));
    }
}
