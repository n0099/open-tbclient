package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.MultiLinkCardView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class vx extends yw {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MultiLinkCardView h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vx(Context context) {
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
        if ((TbadkCoreApplication.getInst().getPersonalizeViewData().n instanceof MultiLinkCardView) && TbadkCoreApplication.getInst().getPersonalizeViewData().n.getParent() == null) {
            this.h = (MultiLinkCardView) TbadkCoreApplication.getInst().getPersonalizeViewData().n;
        } else {
            this.h = new MultiLinkCardView(context);
        }
        x(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kx
    /* renamed from: A */
    public void a(ax4 ax4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ax4Var) == null) {
            if (!z(ax4Var) && !y(ax4Var) && ax4Var != null && ax4Var.getThreadData() != null && ((!ListUtils.isEmpty(ax4Var.getThreadData().getLinkDataList()) || ListUtils.getCount(ax4Var.getThreadData().getGoodsDataList()) > 1) && ((!ListUtils.isEmpty(ax4Var.getThreadData().getGoodsDataList()) || ListUtils.getCount(ax4Var.getThreadData().getLinkDataList()) > 1) && ListUtils.getCount(ax4Var.getThreadData().getLinkDataList()) + ListUtils.getCount(ax4Var.getThreadData().getGoodsDataList()) > 1))) {
                this.h.a(ax4Var.getThreadData().getLinkDataList(), ax4Var.getThreadData().getGoodsDataList());
                this.h.setVisibility(0);
                return;
            }
            this.h.setVisibility(8);
        }
    }

    public final boolean y(ax4 ax4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ax4Var)) == null) {
            if (ax4Var != null && ax4Var.getThreadData() != null && ax4Var.getThreadData().isVideoThreadType() && ax4Var.getThreadData().getThreadVideoInfo() != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.rw
    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            this.h.b();
        }
    }

    public final boolean z(ax4 ax4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ax4Var)) == null) {
            if (ax4Var != null && ax4Var.getThreadData() != null && ax4Var.getThreadData().getPollData() != null && ax4Var.getThreadData().getPollData().getOptions() != null && ax4Var.getThreadData().getPollData().getOptions().size() > 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
