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
/* loaded from: classes5.dex */
public class oy extends nx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SingleLinkCardView h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oy(Context context) {
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
        s(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    @Override // com.baidu.tieba.gx
    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.h : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            this.h.b();
        }
    }

    public final boolean t(lq4 lq4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, lq4Var)) == null) ? (lq4Var == null || lq4Var.getThreadData() == null || !lq4Var.getThreadData().isVideoThreadType() || lq4Var.getThreadData().getThreadVideoInfo() == null) ? false : true : invokeL.booleanValue;
    }

    public final boolean u(lq4 lq4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, lq4Var)) == null) ? (lq4Var == null || lq4Var.getThreadData() == null || lq4Var.getThreadData().getPollData() == null || lq4Var.getThreadData().getPollData().getOptions() == null || lq4Var.getThreadData().getPollData().getOptions().size() <= 0) ? false : true : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.wx
    /* renamed from: v */
    public void a(lq4 lq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, lq4Var) == null) {
            if (!u(lq4Var) && lq4Var != null && lq4Var.getThreadData() != null && !t(lq4Var) && ((!ListUtils.isEmpty(lq4Var.getThreadData().getLinkDataList()) || ListUtils.getCount(lq4Var.getThreadData().getGoodsDataList()) == 1) && ((!ListUtils.isEmpty(lq4Var.getThreadData().getGoodsDataList()) || ListUtils.getCount(lq4Var.getThreadData().getLinkDataList()) == 1) && ListUtils.getCount(lq4Var.getThreadData().getLinkDataList()) + ListUtils.getCount(lq4Var.getThreadData().getGoodsDataList()) == 1))) {
                if (lq4Var.getThreadData().getLinkDataList().size() >= 1) {
                    this.h.a((d26) ListUtils.getItem(lq4Var.getThreadData().getLinkDataList(), 0));
                } else if (lq4Var.getThreadData().getGoodsDataList().size() >= 1) {
                    this.h.a((d26) ListUtils.getItem(lq4Var.getThreadData().getGoodsDataList(), 0));
                }
                this.h.setVisibility(0);
                return;
            }
            this.h.setVisibility(8);
        }
    }
}
