package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.MeasureTextLength;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.mainentrance.searchsuggestlist.viewholder.SearchSuggestForumViewHolder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ww8 extends kn<bx8, SearchSuggestForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public static final int b;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* loaded from: classes8.dex */
    public class a implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ ww8 b;

        public a(ww8 ww8Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ww8Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ww8Var;
            this.a = context;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) || !(xnVar instanceof bx8)) {
                return;
            }
            bx8 bx8Var = (bx8) xnVar;
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.a).createNormalCfg(bx8Var.c(), FrsActivityConfig.FRS_FROM_SEARCH_SUG);
            createNormalCfg.setCallFrom(16);
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
            this.b.u(bx8Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948285105, "Lcom/baidu/tieba/ww8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948285105, "Lcom/baidu/tieba/ww8;");
                return;
            }
        }
        b = xi.g(TbadkApplication.getInst(), R.dimen.tbds370);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ww8(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context;
        this.mType = bdUniqueId;
        setOnAdapterItemClickListener(new a(this, context));
    }

    public final void t(StatisticItem statisticItem, bx8 bx8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, statisticItem, bx8Var) == null) {
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", bx8Var.b().longValue());
            statisticItem.param("fname", bx8Var.c());
        }
    }

    public final void A(bx8 bx8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bx8Var) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_FORUM_SHOW);
            t(statisticItem, bx8Var);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void u(bx8 bx8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bx8Var) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_FORUM_CLICK);
            t(statisticItem, bx8Var);
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: x */
    public SearchSuggestForumViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            return new SearchSuggestForumViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0863, viewGroup, false));
        }
        return (SearchSuggestForumViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.kn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, bx8 bx8Var, SearchSuggestForumViewHolder searchSuggestForumViewHolder) {
        y(i, view2, viewGroup, bx8Var, searchSuggestForumViewHolder);
        return view2;
    }

    public View y(int i, View view2, ViewGroup viewGroup, bx8 bx8Var, SearchSuggestForumViewHolder searchSuggestForumViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, bx8Var, searchSuggestForumViewHolder})) == null) {
            if (bx8Var == null) {
                return view2;
            }
            z(searchSuggestForumViewHolder);
            searchSuggestForumViewHolder.b.setConrers(15);
            searchSuggestForumViewHolder.b.setRadiusById(R.string.J_X06);
            searchSuggestForumViewHolder.b.N(bx8Var.a(), 10, false);
            String str = bx8Var.c() + this.a.getString(R.string.obfuscated_res_0x7f0f076a);
            searchSuggestForumViewHolder.c.setText(str);
            if (!StringUtils.isNull(bx8Var.h())) {
                searchSuggestForumViewHolder.d.setText(this.a.getString(R.string.obfuscated_res_0x7f0f12ec, bx8Var.h()));
            } else {
                Context context = this.a;
                searchSuggestForumViewHolder.d.setText(context.getString(R.string.obfuscated_res_0x7f0f12ec, context.getString(R.string.obfuscated_res_0x7f0f12ed)));
            }
            searchSuggestForumViewHolder.e.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f04b2), StringHelper.numberUniformFormatExtraWithRoundInt(bx8Var.f().intValue())));
            searchSuggestForumViewHolder.f.setText(String.format(this.a.getString(R.string.forum_thread_number), StringHelper.numberUniformFormatExtraWithRoundInt(bx8Var.i().intValue())));
            if (bx8Var.e()) {
                if (!StringUtils.isNull(bx8Var.h())) {
                    searchSuggestForumViewHolder.d.setText(bx8Var.h());
                } else {
                    searchSuggestForumViewHolder.d.setText(this.a.getString(R.string.obfuscated_res_0x7f0f12ed));
                }
                if (bx8Var.d() == 1) {
                    searchSuggestForumViewHolder.h.setVisibility(0);
                    searchSuggestForumViewHolder.c.setText(MeasureTextLength.fitTextLabel(str, "...", MeasureTextLength.spaceLength(b), searchSuggestForumViewHolder.c.getPaint(), ""));
                } else {
                    searchSuggestForumViewHolder.h.setVisibility(8);
                }
            }
            A(bx8Var);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void z(SearchSuggestForumViewHolder searchSuggestForumViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, searchSuggestForumViewHolder) == null) {
            s75 d = s75.d(searchSuggestForumViewHolder.c);
            d.D(R.string.F_X02);
            d.C(R.dimen.T_X06);
            d.x(R.color.CAM_X0105);
            s75 d2 = s75.d(searchSuggestForumViewHolder.d);
            d2.C(R.dimen.T_X09);
            d2.x(R.color.CAM_X0108);
            s75 d3 = s75.d(searchSuggestForumViewHolder.e);
            d3.C(R.dimen.T_X09);
            d3.x(R.color.CAM_X0108);
            s75 d4 = s75.d(searchSuggestForumViewHolder.f);
            d4.C(R.dimen.T_X09);
            d4.x(R.color.CAM_X0108);
            SkinManager.setBackgroundResource(searchSuggestForumViewHolder.a, R.drawable.addresslist_item_bg);
            s75.d(searchSuggestForumViewHolder.g).f(R.color.CAM_X0203);
            TextView textView = searchSuggestForumViewHolder.h;
            if (textView != null) {
                s75 d5 = s75.d(textView);
                d5.C(R.dimen.T_X10);
                d5.D(R.string.F_X01);
                d5.x(R.color.msg_chat_friend_text_color);
                d5.o(R.string.J_X04);
                d5.f(R.color.CAM_X0204);
            }
        }
    }
}
