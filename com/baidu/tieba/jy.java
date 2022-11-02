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
/* loaded from: classes4.dex */
public class jy extends gx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SingleLinkCardView h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jy(Context context) {
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

    public final boolean w(rr4 rr4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, rr4Var)) == null) {
            if (rr4Var != null && rr4Var.getThreadData() != null && rr4Var.getThreadData().isVideoThreadType() && rr4Var.getThreadData().getThreadVideoInfo() != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.zw
    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            this.h.b();
        }
    }

    public final boolean x(rr4 rr4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, rr4Var)) == null) {
            if (rr4Var != null && rr4Var.getThreadData() != null && rr4Var.getThreadData().getPollData() != null && rr4Var.getThreadData().getPollData().getOptions() != null && rr4Var.getThreadData().getPollData().getOptions().size() > 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rx
    /* renamed from: y */
    public void a(rr4 rr4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, rr4Var) == null) {
            if (!x(rr4Var) && rr4Var != null && rr4Var.getThreadData() != null && !w(rr4Var) && ((!ListUtils.isEmpty(rr4Var.getThreadData().getLinkDataList()) || ListUtils.getCount(rr4Var.getThreadData().getGoodsDataList()) == 1) && ((!ListUtils.isEmpty(rr4Var.getThreadData().getGoodsDataList()) || ListUtils.getCount(rr4Var.getThreadData().getLinkDataList()) == 1) && ListUtils.getCount(rr4Var.getThreadData().getLinkDataList()) + ListUtils.getCount(rr4Var.getThreadData().getGoodsDataList()) == 1))) {
                if (rr4Var.getThreadData().getLinkDataList().size() >= 1) {
                    this.h.a((h46) ListUtils.getItem(rr4Var.getThreadData().getLinkDataList(), 0));
                } else if (rr4Var.getThreadData().getGoodsDataList().size() >= 1) {
                    this.h.a((h46) ListUtils.getItem(rr4Var.getThreadData().getGoodsDataList(), 0));
                }
                this.h.setVisibility(0);
                return;
            }
            this.h.setVisibility(8);
        }
    }
}
