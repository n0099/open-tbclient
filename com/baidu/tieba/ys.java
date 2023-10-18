package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.MutiImgSingleVerticalLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.vt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class ys extends wr<jv4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MutiImgSingleVerticalLayout f;
    public jv4 g;
    public int h;
    public String i;

    /* loaded from: classes9.dex */
    public class a implements vt.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ys a;

        public a(ys ysVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ysVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ysVar;
        }

        @Override // com.baidu.tieba.vt.b
        public boolean a(vt.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (this.a.g != null && this.a.g.getThreadData() != null) {
                    mj6.a(this.a.g.getThreadData().getId());
                    ys ysVar = this.a;
                    mj6.l(ysVar.f.a, ysVar.g.getThreadData().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    ys ysVar2 = this.a;
                    mj6.l(ysVar2.f.b, ysVar2.g.getThreadData().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ys(Context context) {
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
        if ((TbadkCoreApplication.getInst().getPersonalizeViewData().h instanceof MutiImgSingleVerticalLayout) && TbadkCoreApplication.getInst().getPersonalizeViewData().h.getParent() == null) {
            MutiImgSingleVerticalLayout mutiImgSingleVerticalLayout = (MutiImgSingleVerticalLayout) TbadkCoreApplication.getInst().getPersonalizeViewData().h;
            this.f = mutiImgSingleVerticalLayout;
            mutiImgSingleVerticalLayout.setRealContext(context);
            return;
        }
        this.f = new MutiImgSingleVerticalLayout(context);
    }

    public void A(MutiImgSingleVerticalLayout.d dVar) {
        MutiImgSingleVerticalLayout mutiImgSingleVerticalLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) && (mutiImgSingleVerticalLayout = this.f) != null) {
            mutiImgSingleVerticalLayout.setBusinessOnClickCallBack(dVar);
        }
    }

    @Override // com.baidu.tieba.wr
    public void p(bk6<jv4> bk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bk6Var) == null) {
            this.f.setSubClickListener(bk6Var);
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.i = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qs
    /* renamed from: x */
    public void onBindDataToView(jv4 jv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jv4Var) == null) {
            this.g = jv4Var;
            this.f.setFrom(this.i);
            this.f.onBindDataToView(jv4Var);
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f.setFromCDN(z);
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f.setNeedFrsTabName(z);
        }
    }

    public static ys u(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, context, str, z)) == null) {
            ys ysVar = new ys(context);
            ysVar.setFrom(str);
            ysVar.y(z);
            return ysVar;
        }
        return (ys) invokeLLZ.objValue;
    }

    @Override // com.baidu.tieba.wr
    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wr
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            m(1, new a(this));
        }
    }

    @Override // com.baidu.tieba.rs
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) {
            this.h = i;
        }
    }
}
