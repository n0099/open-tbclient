package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class k17 extends om<t35, CardViewHolder<b>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public String b;

    public void x(hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, hnVar) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements ln {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;
        public final /* synthetic */ k17 b;

        public a(k17 k17Var, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k17Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k17Var;
            this.a = bVar;
        }

        @Override // com.baidu.tieba.ln
        public void b(View view2, bn bnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, bnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.r();
                StatisticItem statisticItem = new StatisticItem("c13647");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_id", this.b.getPositionByType(i) + 1);
                statisticItem.param("resource_id", this.b.b);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends ln6<t35> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbPageContext<?> i;
        public TbImageView j;
        public String k;

        @Override // com.baidu.tieba.ln6
        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01e0 : invokeV.intValue;
        }

        @Override // com.baidu.tieba.ln6
        public void j(TbPageContext<?> tbPageContext, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
            super(tbPageContext, viewGroup);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = tbPageContext;
            TbImageView tbImageView = (TbImageView) h().findViewById(R.id.obfuscated_res_0x7f09108c);
            this.j = tbImageView;
            tbImageView.setOnClickListener(this);
            this.j.setConrers(15);
            this.j.setScaleType(ImageView.ScaleType.FIT_XY);
            this.j.setRadius(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.j.setDrawCorner(true);
            this.j.setAutoChangeStyle(true);
            this.j.setPlaceHolder(2);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && view2 == this.j) {
                r();
            }
        }

        public void r() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && !TextUtils.isEmpty(this.k)) {
                UrlManager.getInstance().dealOneLink(this.i, new String[]{this.k});
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ln6
        /* renamed from: s */
        public void i(t35 t35Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, t35Var) == null) {
                if (t35Var != null) {
                    this.k = t35Var.b;
                    this.j.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.j.setPlaceHolder(2);
                    this.j.startLoad(t35Var.a, 10, false);
                }
                j(this.i, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k17(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: t */
    public CardViewHolder<b> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            b bVar = new b(this.a, viewGroup);
            setOnAdapterItemClickListener(new a(this, bVar));
            return new CardViewHolder<>(bVar);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: u */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, t35 t35Var, CardViewHolder<b> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, t35Var, cardViewHolder})) == null) {
            if (t35Var != null && cardViewHolder != null && cardViewHolder.b() != null) {
                cardViewHolder.b().i(t35Var);
                StatisticItem statisticItem = new StatisticItem("c13646");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_id", getPositionByType(i) + 1);
                statisticItem.param("resource_id", this.b);
                TiebaStatic.log(statisticItem);
                return cardViewHolder.b().h();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
