package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.view.OfficialRecommendLiveViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ob6 extends pm<sb6, OfficialRecommendLiveViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public wc6 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ob6(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), sb6.b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: s */
    public OfficialRecommendLiveViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            this.b = new wc6(this.a, viewGroup);
            return new OfficialRecommendLiveViewHolder(this.b);
        }
        return (OfficialRecommendLiveViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: t */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, sb6 sb6Var, OfficialRecommendLiveViewHolder officialRecommendLiveViewHolder) {
        InterceptResult invokeCommon;
        wc6 wc6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, sb6Var, officialRecommendLiveViewHolder})) == null) {
            if (officialRecommendLiveViewHolder != null && (wc6Var = officialRecommendLiveViewHolder.a) != null) {
                wc6Var.i(sb6Var);
                officialRecommendLiveViewHolder.a.j(this.a, TbadkCoreApplication.getInst().getSkinType());
                return officialRecommendLiveViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
