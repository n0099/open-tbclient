package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.pb.pb.adapter.PbNoDataItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class pj9 extends qi9<kf9, PbNoDataItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pj9(bo9 bo9Var, BdUniqueId bdUniqueId) {
        super(bo9Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bo9Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((bo9) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: u */
    public PbNoDataItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            return new PbNoDataItemViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d07b0, viewGroup, false), this.mContext);
        }
        return (PbNoDataItemViewHolder) invokeL.objValue;
    }

    @Override // com.baidu.tieba.qi9, com.baidu.tieba.lh
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        x(i, view2, viewGroup, (kf9) obj, (PbNoDataItemViewHolder) viewHolder);
        return view2;
    }

    public View x(int i, View view2, ViewGroup viewGroup, kf9 kf9Var, PbNoDataItemViewHolder pbNoDataItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, kf9Var, pbNoDataItemViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) kf9Var, (kf9) pbNoDataItemViewHolder);
            this.d = TbadkCoreApplication.getInst().getSkinType();
            pbNoDataItemViewHolder.a.setTextOption(NoDataViewFactory.e.c(kf9Var.h1));
            if (kf9Var.g1 != 0) {
                int dimens = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds156);
                int i2 = kf9Var.i1;
                if (i2 != 0) {
                    dimens = i2;
                }
                int dimens2 = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds312);
                int dimens3 = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds312);
                NoDataViewFactory.d.a aVar = new NoDataViewFactory.d.a();
                aVar.i(NoDataViewFactory.ImgType.LOCAL);
                aVar.h(kf9Var.g1);
                aVar.j(dimens);
                aVar.k(dimens2);
                aVar.g(dimens3);
                pbNoDataItemViewHolder.a.setImgOption(aVar.f());
            } else {
                pbNoDataItemViewHolder.a.setImgOption(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdUtilHelper.getDimens(this.mContext, R.dimen.tbds156)));
            }
            pbNoDataItemViewHolder.a.f(k4.a(view2.getContext()), this.d);
            pbNoDataItemViewHolder.a.setVisibility(kf9Var.j1);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
