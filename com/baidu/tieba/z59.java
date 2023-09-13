package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
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
/* loaded from: classes9.dex */
public class z59 extends pm<e69, SearchSuggestForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public static final int b;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* loaded from: classes9.dex */
    public class a implements mn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ z59 b;

        public a(z59 z59Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z59Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z59Var;
            this.a = context;
        }

        @Override // com.baidu.tieba.mn
        public void b(View view2, cn cnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, cnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) || !(cnVar instanceof e69)) {
                return;
            }
            e69 e69Var = (e69) cnVar;
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.a).createNormalCfg(e69Var.c(), FrsActivityConfig.FRS_FROM_SEARCH_SUG);
            createNormalCfg.setCallFrom(16);
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
            this.b.u(e69Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948311083, "Lcom/baidu/tieba/z59;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948311083, "Lcom/baidu/tieba/z59;");
                return;
            }
        }
        b = BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds370);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z59(Context context, BdUniqueId bdUniqueId) {
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

    public final void t(StatisticItem statisticItem, e69 e69Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, statisticItem, e69Var) == null) {
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", e69Var.b().longValue());
            statisticItem.param("fname", e69Var.c());
        }
    }

    public final void A(e69 e69Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, e69Var) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_FORUM_SHOW);
            t(statisticItem, e69Var);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void u(e69 e69Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, e69Var) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_FORUM_CLICK);
            t(statisticItem, e69Var);
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: x */
    public SearchSuggestForumViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            return new SearchSuggestForumViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d08a2, viewGroup, false));
        }
        return (SearchSuggestForumViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.pm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, e69 e69Var, SearchSuggestForumViewHolder searchSuggestForumViewHolder) {
        y(i, view2, viewGroup, e69Var, searchSuggestForumViewHolder);
        return view2;
    }

    public View y(int i, View view2, ViewGroup viewGroup, e69 e69Var, SearchSuggestForumViewHolder searchSuggestForumViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, e69Var, searchSuggestForumViewHolder})) == null) {
            if (e69Var == null) {
                return view2;
            }
            z(searchSuggestForumViewHolder);
            searchSuggestForumViewHolder.b.setConrers(15);
            searchSuggestForumViewHolder.b.setRadiusById(R.string.J_X06);
            searchSuggestForumViewHolder.b.startLoad(e69Var.a(), 10, false);
            String str = e69Var.c() + this.a.getString(R.string.obfuscated_res_0x7f0f077f);
            searchSuggestForumViewHolder.c.setText(str);
            if (!StringUtils.isNull(e69Var.g())) {
                searchSuggestForumViewHolder.d.setText(this.a.getString(R.string.obfuscated_res_0x7f0f132a, e69Var.g()));
            } else {
                Context context = this.a;
                searchSuggestForumViewHolder.d.setText(context.getString(R.string.obfuscated_res_0x7f0f132a, context.getString(R.string.obfuscated_res_0x7f0f132b)));
            }
            searchSuggestForumViewHolder.e.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f04b8), StringHelper.numberUniformFormatExtraWithRoundInt(e69Var.f().intValue())));
            searchSuggestForumViewHolder.f.setText(String.format(this.a.getString(R.string.forum_thread_number), StringHelper.numberUniformFormatExtraWithRoundInt(e69Var.h().intValue())));
            if (e69Var.e()) {
                if (!StringUtils.isNull(e69Var.g())) {
                    searchSuggestForumViewHolder.d.setText(e69Var.g());
                } else {
                    searchSuggestForumViewHolder.d.setText(this.a.getString(R.string.obfuscated_res_0x7f0f132b));
                }
                if (e69Var.d() == 1) {
                    searchSuggestForumViewHolder.h.setVisibility(0);
                    searchSuggestForumViewHolder.c.setText(MeasureTextLength.fitTextLabel(str, "...", MeasureTextLength.spaceLength(b), searchSuggestForumViewHolder.c.getPaint(), ""));
                } else {
                    searchSuggestForumViewHolder.h.setVisibility(8);
                }
            }
            A(e69Var);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void z(SearchSuggestForumViewHolder searchSuggestForumViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, searchSuggestForumViewHolder) == null) {
            EMManager.from(searchSuggestForumViewHolder.c).setTextStyle(R.string.F_X02).setTextSize(R.dimen.T_X06).setTextColor(R.color.CAM_X0105);
            EMManager.from(searchSuggestForumViewHolder.d).setTextSize(R.dimen.T_X09).setTextColor(R.color.CAM_X0108);
            EMManager.from(searchSuggestForumViewHolder.e).setTextSize(R.dimen.T_X09).setTextColor(R.color.CAM_X0108);
            EMManager.from(searchSuggestForumViewHolder.f).setTextSize(R.dimen.T_X09).setTextColor(R.color.CAM_X0108);
            SkinManager.setBackgroundResource(searchSuggestForumViewHolder.a, R.drawable.addresslist_item_bg);
            EMManager.from(searchSuggestForumViewHolder.g).setBackGroundColor(R.color.CAM_X0203);
            TextView textView = searchSuggestForumViewHolder.h;
            if (textView != null) {
                EMManager.from(textView).setTextSize(R.dimen.T_X10).setTextStyle(R.string.F_X01).setTextColor(R.color.msg_chat_friend_text_color).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0204);
            }
        }
    }
}
