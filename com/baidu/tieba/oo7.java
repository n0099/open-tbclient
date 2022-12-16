package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.mainentrance.searchsuggestlist.viewholder.SearchSuggestForumViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class oo7 extends kn<to7, SearchSuggestForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* loaded from: classes5.dex */
    public class a implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ oo7 b;

        public a(oo7 oo7Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oo7Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = oo7Var;
            this.a = context;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) || !(xnVar instanceof to7)) {
                return;
            }
            to7 to7Var = (to7) xnVar;
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.a).createNormalCfg(to7Var.c(), FrsActivityConfig.FRS_FROM_SEARCH_SUG);
            createNormalCfg.setCallFrom(16);
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
            this.b.u(to7Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oo7(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
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
        this.a = context;
        this.mType = bdUniqueId;
        setOnAdapterItemClickListener(new a(this, context));
    }

    public final void t(StatisticItem statisticItem, to7 to7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, statisticItem, to7Var) == null) {
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", to7Var.b().longValue());
            statisticItem.param("fname", to7Var.c());
        }
    }

    public final void u(to7 to7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, to7Var) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_FORUM_CLICK);
            t(statisticItem, to7Var);
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: v */
    public SearchSuggestForumViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            return new SearchSuggestForumViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d07cd, viewGroup, false));
        }
        return (SearchSuggestForumViewHolder) invokeL.objValue;
    }

    public final void y(to7 to7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, to7Var) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_FORUM_SHOW);
            t(statisticItem, to7Var);
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.kn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, to7 to7Var, SearchSuggestForumViewHolder searchSuggestForumViewHolder) {
        w(i, view2, viewGroup, to7Var, searchSuggestForumViewHolder);
        return view2;
    }

    public View w(int i, View view2, ViewGroup viewGroup, to7 to7Var, SearchSuggestForumViewHolder searchSuggestForumViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, to7Var, searchSuggestForumViewHolder})) == null) {
            if (to7Var == null) {
                return view2;
            }
            x(searchSuggestForumViewHolder);
            searchSuggestForumViewHolder.b.setConrers(15);
            searchSuggestForumViewHolder.b.setRadiusById(R.string.J_X06);
            searchSuggestForumViewHolder.b.K(to7Var.a(), 10, false);
            searchSuggestForumViewHolder.c.setText(to7Var.c() + this.a.getString(R.string.obfuscated_res_0x7f0f0683));
            if (!StringUtils.isNull(to7Var.g())) {
                searchSuggestForumViewHolder.d.setText(this.a.getString(R.string.obfuscated_res_0x7f0f1145, to7Var.g()));
            } else {
                Context context = this.a;
                searchSuggestForumViewHolder.d.setText(context.getString(R.string.obfuscated_res_0x7f0f1145, context.getString(R.string.obfuscated_res_0x7f0f1146)));
            }
            searchSuggestForumViewHolder.e.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0439), StringHelper.numberUniformFormatExtraWithRoundInt(to7Var.f().intValue())));
            searchSuggestForumViewHolder.f.setText(String.format(this.a.getString(R.string.forum_thread_number), StringHelper.numberUniformFormatExtraWithRoundInt(to7Var.h().intValue())));
            y(to7Var);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void x(SearchSuggestForumViewHolder searchSuggestForumViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, searchSuggestForumViewHolder) == null) {
            rw4 d = rw4.d(searchSuggestForumViewHolder.c);
            d.A(R.string.F_X02);
            d.z(R.dimen.T_X06);
            d.v(R.color.CAM_X0105);
            rw4 d2 = rw4.d(searchSuggestForumViewHolder.d);
            d2.z(R.dimen.T_X09);
            d2.v(R.color.CAM_X0108);
            rw4 d3 = rw4.d(searchSuggestForumViewHolder.e);
            d3.z(R.dimen.T_X09);
            d3.v(R.color.CAM_X0108);
            rw4 d4 = rw4.d(searchSuggestForumViewHolder.f);
            d4.z(R.dimen.T_X09);
            d4.v(R.color.CAM_X0108);
            SkinManager.setBackgroundResource(searchSuggestForumViewHolder.a, R.drawable.addresslist_item_bg);
            rw4.d(searchSuggestForumViewHolder.g).f(R.color.CAM_X0203);
        }
    }
}
