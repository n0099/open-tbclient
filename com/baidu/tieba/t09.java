package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseActivity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.mainentrance.searchsuggestlist.viewholder.SearchSuggestCommonViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class t09 extends lm<y09, SearchSuggestCommonViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* loaded from: classes8.dex */
    public class a implements in {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public a(t09 t09Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t09Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // com.baidu.tieba.in
        public void b(View view2, ym ymVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, ymVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) || !(ymVar instanceof y09)) {
                return;
            }
            y09 y09Var = (y09) ymVar;
            String a = y09Var.a();
            String b = y09Var.b();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921595, b);
            Context context = this.a;
            if (context instanceof BdBaseActivity) {
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2921595, ((BdBaseActivity) context).getUniqueId()));
            }
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            TiebaStatic.eventStat(this.a, "search_bar_result_click", "click", 1, new Object[0]);
            TiebaStatic.log(new StatisticItem("c12842").param("obj_name", a).param("obj_source", "2").param("obj_type", "1").param("obj_locate", i + 1).param("obj_param1", b));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t09(Context context, BdUniqueId bdUniqueId) {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lm
    /* renamed from: s */
    public SearchSuggestCommonViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            return new SearchSuggestCommonViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0886, viewGroup, false));
        }
        return (SearchSuggestCommonViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.lm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, y09 y09Var, SearchSuggestCommonViewHolder searchSuggestCommonViewHolder) {
        t(i, view2, viewGroup, y09Var, searchSuggestCommonViewHolder);
        return view2;
    }

    public View t(int i, View view2, ViewGroup viewGroup, y09 y09Var, SearchSuggestCommonViewHolder searchSuggestCommonViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, y09Var, searchSuggestCommonViewHolder})) == null) {
            if (y09Var == null) {
                return view2;
            }
            u(searchSuggestCommonViewHolder);
            WebPManager.setPureDrawable(searchSuggestCommonViewHolder.c, R.drawable.icon_search_scan, R.color.CAM_X0109, null);
            s09.a(searchSuggestCommonViewHolder.b, y09Var.b(), y09Var.a());
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void u(SearchSuggestCommonViewHolder searchSuggestCommonViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, searchSuggestCommonViewHolder) == null) {
            EMManager.from(searchSuggestCommonViewHolder.b).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X06);
            SkinManager.setBackgroundResource(searchSuggestCommonViewHolder.a, R.drawable.addresslist_item_bg);
            EMManager.from(searchSuggestCommonViewHolder.d).setBackGroundColor(R.color.CAM_X0203);
        }
    }
}
