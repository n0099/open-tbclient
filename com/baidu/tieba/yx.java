package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.SingleLinkCardView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class yx extends vw {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SingleLinkCardView h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yx(Context context) {
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
        if ((TbadkCoreApplication.getInst().getPersonalizeViewData().m instanceof SingleLinkCardView) && TbadkCoreApplication.getInst().getPersonalizeViewData().m.getParent() == null) {
            this.h = (SingleLinkCardView) TbadkCoreApplication.getInst().getPersonalizeViewData().m;
        } else {
            this.h = new SingleLinkCardView(context);
        }
        v(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.gx
    /* renamed from: y */
    public void a(hw4 hw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hw4Var) == null) {
            if (!x(hw4Var) && hw4Var != null && hw4Var.getThreadData() != null && !w(hw4Var) && ListUtils.getCount(hw4Var.getThreadData().getLinkDataList()) + ListUtils.getCount(hw4Var.getThreadData().getGoodsDataList()) == 1) {
                if (hw4Var.getThreadData().getLinkDataList().size() >= 1) {
                    this.h.a((tf6) ListUtils.getItem(hw4Var.getThreadData().getLinkDataList(), 0));
                } else if (hw4Var.getThreadData().getGoodsDataList().size() >= 1) {
                    this.h.a((tf6) ListUtils.getItem(hw4Var.getThreadData().getGoodsDataList(), 0));
                }
                this.h.setVisibility(0);
                return;
            }
            this.h.setVisibility(8);
        }
    }

    public final boolean w(hw4 hw4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, hw4Var)) == null) {
            if (hw4Var != null && hw4Var.getThreadData() != null && hw4Var.getThreadData().isVideoThreadType() && hw4Var.getThreadData().getThreadVideoInfo() != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ow
    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            this.h.d();
        }
    }

    public final boolean x(hw4 hw4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hw4Var)) == null) {
            if (hw4Var != null && hw4Var.getThreadData() != null && hw4Var.getThreadData().getPollData() != null && hw4Var.getThreadData().getPollData().getOptions() != null && hw4Var.getThreadData().getPollData().getOptions().size() > 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
