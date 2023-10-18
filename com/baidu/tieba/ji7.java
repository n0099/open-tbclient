package com.baidu.tieba;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.extra.adapter.FrsU9ViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ji7 extends yc7<yda, FrsU9ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ji7(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: G */
    public FrsU9ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            Log.e("Adapter", "Frs U9 Context:" + this.mContext + "   Resource:" + this.mContext.getResources() + "  Asset:" + this.mContext.getResources().getAssets());
            return new FrsU9ViewHolder(this.c, LayoutInflater.from(this.mContext).inflate(R.layout.u9_info_layout, (ViewGroup) null, true), this.mPageId);
        }
        return (FrsU9ViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yc7, com.baidu.tieba.lh
    /* renamed from: H */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, yda ydaVar, FrsU9ViewHolder frsU9ViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ydaVar, frsU9ViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) ydaVar, (yda) frsU9ViewHolder);
            if (ydaVar != null && frsU9ViewHolder != null) {
                frsU9ViewHolder.f(ydaVar);
                frsU9ViewHolder.g(TbadkCoreApplication.getInst().getSkinType());
                return frsU9ViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
