package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.ala.alasquare.livetab.view.LiveTabAlaRecommendViewHolder;
import com.baidu.tieba.card.ala.secondfloor.AlaRecommendLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class yw5 extends jn<zw5, LiveTabAlaRecommendViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public AlaRecommendLayout b;
    public int c;
    public String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yw5(TbPageContext tbPageContext, int i, String str) {
        super(tbPageContext.getPageActivity(), zw5.b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = "0";
        this.a = tbPageContext;
        this.c = i;
        this.d = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: s */
    public LiveTabAlaRecommendViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            AlaRecommendLayout alaRecommendLayout = new AlaRecommendLayout(this.a.getPageActivity());
            this.b = alaRecommendLayout;
            alaRecommendLayout.setPadding(UtilHelper.getDimenPixelSize(R.dimen.tbds34), UtilHelper.getDimenPixelSize(R.dimen.tbds21), UtilHelper.getDimenPixelSize(R.dimen.tbds34), this.b.getPaddingBottom());
            this.b.setFid(this.d);
            TiebaStatic.log(c46.e("c13620", this.c, this.d));
            return new LiveTabAlaRecommendViewHolder(this.b);
        }
        return (LiveTabAlaRecommendViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: t */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, zw5 zw5Var, LiveTabAlaRecommendViewHolder liveTabAlaRecommendViewHolder) {
        InterceptResult invokeCommon;
        AlaRecommendLayout alaRecommendLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, zw5Var, liveTabAlaRecommendViewHolder})) == null) {
            if (liveTabAlaRecommendViewHolder != null && (alaRecommendLayout = liveTabAlaRecommendViewHolder.a) != null && zw5Var != null) {
                kw4 d = kw4.d(alaRecommendLayout.findViewById(R.id.obfuscated_res_0x7f090236));
                d.n(R.string.J_X06);
                d.f(R.color.CAM_X0201);
                d46 d46Var = zw5Var.a;
                if (d46Var != null && !ListUtils.isEmpty(d46Var.c())) {
                    liveTabAlaRecommendViewHolder.a.setData(zw5Var.a);
                    liveTabAlaRecommendViewHolder.a.d(TbadkCoreApplication.getInst().getSkinType());
                    liveTabAlaRecommendViewHolder.a.setVisibility(0);
                } else {
                    liveTabAlaRecommendViewHolder.a.setVisibility(8);
                }
                return liveTabAlaRecommendViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
