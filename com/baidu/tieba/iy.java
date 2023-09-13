package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.widget.TbLabelWidget;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class iy extends hx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbLabelWidget h;
    public ThreadData i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public iy(Context context) {
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
        int dimens = BdUtilHelper.getDimens(context, R.dimen.M_H_X003);
        int dimens2 = BdUtilHelper.getDimens(context, R.dimen.tbds0);
        x(dimens);
        u(dimens2);
        if ((TbadkCoreApplication.getInst().getPersonalizeViewData().s instanceof TbLabelWidget) && TbadkCoreApplication.getInst().getPersonalizeViewData().s.getParent() == null) {
            this.h = (TbLabelWidget) TbadkCoreApplication.getInst().getPersonalizeViewData().s;
        } else {
            this.h = new TbLabelWidget(context);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ux
    /* renamed from: A */
    public void onBindDataToView(b15 b15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, b15Var) == null) {
            if (b15Var != null) {
                this.i = b15Var.getThreadData();
            }
            this.h.setData(b15Var);
        }
    }

    public void B(TbLabelWidget.b bVar) {
        TbLabelWidget tbLabelWidget;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) && (tbLabelWidget = this.h) != null) {
            tbLabelWidget.setEventCallback(bVar);
        }
    }

    public void C(TbPageContext tbPageContext) {
        TbLabelWidget tbLabelWidget;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext) == null) && (tbLabelWidget = this.h) != null) {
            tbLabelWidget.setPageContext(tbPageContext);
        }
    }

    @Override // com.baidu.tieba.ax
    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int dimens = BdUtilHelper.getDimens(this.b, R.dimen.M_H_X003);
            int dimens2 = BdUtilHelper.getDimens(this.b, R.dimen.tbds0);
            x(dimens);
            u(dimens2);
        }
    }

    public ThreadData z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.i;
        }
        return (ThreadData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i) == null) {
            this.h.k();
        }
    }
}
