package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.MultiImgLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.nu;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class pt extends os<fw4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MultiImgLayout f;
    public fw4 g;
    public int h;
    public String i;

    /* loaded from: classes7.dex */
    public class a implements nu.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pt a;

        public a(pt ptVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ptVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ptVar;
        }

        @Override // com.baidu.tieba.nu.b
        public boolean a(nu.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (this.a.g != null && this.a.g.getThreadData() != null) {
                    xl6.a(this.a.g.getThreadData().getId());
                    xl6.l(this.a.f.a, this.a.g.getThreadData().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    xl6.l(this.a.f.b, this.a.g.getThreadData().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pt(Context context) {
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
        this.h = 3;
        if ((TbadkCoreApplication.getInst().getPersonalizeViewData().f instanceof MultiImgLayout) && TbadkCoreApplication.getInst().getPersonalizeViewData().f.getParent() == null) {
            this.f = (MultiImgLayout) TbadkCoreApplication.getInst().getPersonalizeViewData().f;
        } else {
            this.f = new MultiImgLayout(context);
        }
    }

    public void A(zh zhVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zhVar) == null) {
            this.f.setPreloadSizeReadyCallback(zhVar);
        }
    }

    @Override // com.baidu.tieba.os
    public void n(mm6<fw4> mm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mm6Var) == null) {
            this.f.setSubClickListener(mm6Var);
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.i = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.it
    /* renamed from: t */
    public void onBindDataToView(fw4 fw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fw4Var) == null) {
            this.g = fw4Var;
            this.f.setFrom(this.i);
            this.f.onBindDataToView(fw4Var);
        }
    }

    public void u(pb<TbImageView> pbVar) {
        MultiImgLayout multiImgLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pbVar) == null) && (multiImgLayout = this.f) != null) {
            multiImgLayout.setConstrainImagePool(pbVar);
        }
    }

    public void x(pb<ConstrainImageLayout> pbVar) {
        MultiImgLayout multiImgLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, pbVar) == null) && (multiImgLayout = this.f) != null) {
            multiImgLayout.setConstrainLayoutPool(pbVar);
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f.setFromCDN(z);
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f.setNeedFrsTabName(z);
        }
    }

    @Override // com.baidu.tieba.os
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.os
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            i(1, new a(this));
        }
    }

    @Override // com.baidu.tieba.jt
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i) == null) {
            if (this.h != i) {
                SkinManager.setBackgroundResource(g(), R.drawable.addresslist_item_bg);
                this.f.d.b();
            }
            this.h = i;
        }
    }
}
