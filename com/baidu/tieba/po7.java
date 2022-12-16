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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.mainentrance.searchsuggestlist.viewholder.SearchSuggestItemViewHolder;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class po7 extends kn<uo7, SearchSuggestItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* loaded from: classes5.dex */
    public class a implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ po7 b;

        public a(po7 po7Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {po7Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = po7Var;
            this.a = context;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) || !(xnVar instanceof uo7)) {
                return;
            }
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            uo7 uo7Var = (uo7) xnVar;
            sb.append(uo7Var.b());
            sb.append("");
            hashMap.put("itemID", sb.toString());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a, "GameItemDetailsPage", hashMap)));
            this.b.u(uo7Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public po7(Context context, BdUniqueId bdUniqueId) {
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

    public final void t(StatisticItem statisticItem, uo7 uo7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, statisticItem, uo7Var) == null) {
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("item_id", uo7Var.b().longValue());
        }
    }

    public final void u(uo7 uo7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, uo7Var) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_ITEM_CLICK);
            t(statisticItem, uo7Var);
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: v */
    public SearchSuggestItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            return new SearchSuggestItemViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d07cf, viewGroup, false));
        }
        return (SearchSuggestItemViewHolder) invokeL.objValue;
    }

    public final void y(uo7 uo7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, uo7Var) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_ITEM_SHOW);
            t(statisticItem, uo7Var);
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.kn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, uo7 uo7Var, SearchSuggestItemViewHolder searchSuggestItemViewHolder) {
        w(i, view2, viewGroup, uo7Var, searchSuggestItemViewHolder);
        return view2;
    }

    public View w(int i, View view2, ViewGroup viewGroup, uo7 uo7Var, SearchSuggestItemViewHolder searchSuggestItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, uo7Var, searchSuggestItemViewHolder})) == null) {
            if (uo7Var == null) {
                return view2;
            }
            x(searchSuggestItemViewHolder);
            searchSuggestItemViewHolder.b.setConrers(15);
            searchSuggestItemViewHolder.b.setRadiusById(R.string.J_X06);
            searchSuggestItemViewHolder.b.K(uo7Var.a(), 10, false);
            searchSuggestItemViewHolder.c.setText(uo7Var.c());
            searchSuggestItemViewHolder.f.setStarSpacing(yi.g(this.a, R.dimen.M_W_X002));
            searchSuggestItemViewHolder.f.setStarCount(uo7Var.g().intValue());
            TextView textView = searchSuggestItemViewHolder.d;
            StringBuilder sb = new StringBuilder();
            sb.append(uo7Var.f());
            String str = "";
            sb.append("");
            textView.setText(sb.toString());
            if (uo7Var.h() != null) {
                for (String str2 : uo7Var.h()) {
                    if (!StringUtils.isNull(str2)) {
                        if (!StringUtils.isNull(str)) {
                            str2 = str + " " + str2;
                        }
                        str = str2;
                    }
                }
            }
            searchSuggestItemViewHolder.e.setText(str);
            y(uo7Var);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void x(SearchSuggestItemViewHolder searchSuggestItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, searchSuggestItemViewHolder) == null) {
            rw4 d = rw4.d(searchSuggestItemViewHolder.c);
            d.A(R.string.F_X02);
            d.v(R.color.CAM_X0105);
            d.z(R.dimen.T_X06);
            rw4 d2 = rw4.d(searchSuggestItemViewHolder.d);
            d2.v(R.color.CAM_X0108);
            d2.z(R.dimen.T_X09);
            rw4 d3 = rw4.d(searchSuggestItemViewHolder.e);
            d3.v(R.color.CAM_X0108);
            d3.z(R.dimen.T_X09);
            SkinManager.setBackgroundResource(searchSuggestItemViewHolder.a, R.drawable.addresslist_item_bg);
            rw4.d(searchSuggestItemViewHolder.g).f(R.color.CAM_X0203);
        }
    }
}
