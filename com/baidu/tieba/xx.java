package com.baidu.tieba;

import android.content.Context;
import android.view.View;
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
/* loaded from: classes7.dex */
public class xx extends ww {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbLabelWidget h;
    public ThreadData i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xx(Context context) {
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
        int g = ii.g(context, R.dimen.M_H_X003);
        int g2 = ii.g(context, R.dimen.tbds0);
        v(g);
        u(g2);
        if ((TbadkCoreApplication.getInst().getPersonalizeViewData().s instanceof TbLabelWidget) && TbadkCoreApplication.getInst().getPersonalizeViewData().s.getParent() == null) {
            this.h = (TbLabelWidget) TbadkCoreApplication.getInst().getPersonalizeViewData().s;
        } else {
            this.h = new TbLabelWidget(context);
        }
    }

    public void A(TbPageContext tbPageContext) {
        TbLabelWidget tbLabelWidget;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) && (tbLabelWidget = this.h) != null) {
            tbLabelWidget.setPageContext(tbPageContext);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.hx
    /* renamed from: y */
    public void a(jw4 jw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jw4Var) == null) {
            if (jw4Var != null) {
                this.i = jw4Var.getThreadData();
            }
            this.h.setData(jw4Var);
        }
    }

    public void z(TbLabelWidget.b bVar) {
        TbLabelWidget tbLabelWidget;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) && (tbLabelWidget = this.h) != null) {
            tbLabelWidget.setEventCallback(bVar);
        }
    }

    @Override // com.baidu.tieba.pw
    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int g = ii.g(this.b, R.dimen.M_H_X003);
            int g2 = ii.g(this.b, R.dimen.tbds0);
            v(g);
            u(g2);
        }
    }

    public ThreadData x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.i;
        }
        return (ThreadData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ix
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            this.h.k();
        }
    }
}
