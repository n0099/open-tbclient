package com.baidu.tieba.write.write.relevance.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.e.p.l;
import c.a.p0.b4.u.m.a.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.EvaluateRelevanceItemSelectedMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.relevance.RelevanceItemSearchData;
import com.baidu.tieba.write.write.relevance.list.ReleavanceItemListData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class RelevanceItemListController implements BdRecyclerView.i, a.b, BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final View f58725e;

    /* renamed from: f  reason: collision with root package name */
    public final RelevanceItemListFragment f58726f;

    /* renamed from: g  reason: collision with root package name */
    public final c.a.p0.b4.u.m.a.a f58727g;

    /* renamed from: h  reason: collision with root package name */
    public BdRecyclerView f58728h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f58729i;

    /* renamed from: j  reason: collision with root package name */
    public List<ReleavanceItemListData.ItemListBean> f58730j;
    public boolean k;
    public String l;
    public RecyclerView.Adapter m;

    /* loaded from: classes7.dex */
    public static class ListViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final View f58731a;

        /* renamed from: b  reason: collision with root package name */
        public ItemCardView f58732b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ListViewHolder(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            ItemCardView itemCardView = (ItemCardView) view.findViewById(R.id.item_rate_info);
            this.f58732b = itemCardView;
            itemCardView.setBackGroundColor(R.color.transparent_1);
            this.f58732b.setSizeStyle(1);
            View findViewById = view.findViewById(R.id.bottom_divider);
            this.f58731a = findViewById;
            SkinManager.setBackgroundColor(findViewById, R.color.CAM_X0203);
        }

        public void bindData(ReleavanceItemListData.ItemListBean itemListBean, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, itemListBean, str) == null) || itemListBean == null) {
                return;
            }
            TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo = new TbRichTextEvaluateItemInfo();
            tbRichTextEvaluateItemInfo.setTitle(itemListBean.getItem_name());
            tbRichTextEvaluateItemInfo.setIconUrl(itemListBean.getIcon_url());
            try {
                tbRichTextEvaluateItemInfo.setScore(Double.parseDouble(itemListBean.getScore()));
                tbRichTextEvaluateItemInfo.setIconSize(Double.parseDouble(itemListBean.getIcon_size()));
                tbRichTextEvaluateItemInfo.setStar(Integer.parseInt(itemListBean.getStar()));
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
            tbRichTextEvaluateItemInfo.setTags(itemListBean.getTags());
            ItemCardView itemCardView = this.f58732b;
            itemCardView.setHighLightText(str + "");
            this.f58732b.setData(tbRichTextEvaluateItemInfo, 10, "");
        }
    }

    /* loaded from: classes7.dex */
    public class a extends RecyclerView.Adapter<ListViewHolder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RelevanceItemListController f58733a;

        public a(RelevanceItemListController relevanceItemListController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {relevanceItemListController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58733a = relevanceItemListController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(ListViewHolder listViewHolder, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, listViewHolder, i2) == null) {
                listViewHolder.bindData((ReleavanceItemListData.ItemListBean) this.f58733a.f58730j.get(i2), this.f58733a.l);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: c */
        public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) ? new ListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.relevance_item_view, (ViewGroup) null)) : (ListViewHolder) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f58733a.f58730j.size() : invokeV.intValue;
        }
    }

    public RelevanceItemListController(RelevanceItemListFragment relevanceItemListFragment, View view, String str, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {relevanceItemListFragment, view, str, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58730j = new ArrayList();
        this.k = true;
        this.m = new a(this);
        this.f58725e = view;
        this.f58726f = relevanceItemListFragment;
        this.f58727g = new c.a.p0.b4.u.m.a.a(bdUniqueId, str);
        j();
    }

    @Override // c.a.p0.b4.u.m.a.a.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f58726f.onNoData();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
    public void b(ViewGroup viewGroup, View view, Object obj, int i2, long j2) {
        double d2;
        double d3;
        double d4;
        int i3;
        double parseDouble;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{viewGroup, view, obj, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || ListUtils.isEmpty(this.f58730j)) {
            return;
        }
        ReleavanceItemListData.ItemListBean itemListBean = this.f58730j.get(i2);
        double d5 = 0.0d;
        try {
            parseDouble = Double.parseDouble(itemListBean.getScore());
        } catch (NumberFormatException e2) {
            e = e2;
            d2 = 0.0d;
        }
        try {
            d5 = Double.parseDouble(itemListBean.getIcon_size());
            i3 = Integer.parseInt(itemListBean.getStar());
            d4 = d5;
            d3 = parseDouble;
        } catch (NumberFormatException e3) {
            e = e3;
            double d6 = d5;
            d5 = parseDouble;
            d2 = d6;
            e.printStackTrace();
            d3 = d5;
            d4 = d2;
            i3 = 0;
            MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemSelectedMessage(itemListBean.getItem_id(), itemListBean.getItem_name(), itemListBean.getIcon_url(), d3, d4, i3, itemListBean.getTags()));
            this.f58726f.getActivity().finish();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemSelectedMessage(itemListBean.getItem_id(), itemListBean.getItem_name(), itemListBean.getIcon_url(), d3, d4, i3, itemListBean.getTags()));
        this.f58726f.getActivity().finish();
    }

    @Override // c.a.p0.b4.u.m.a.a.b
    public void c(RelevanceItemSearchData relevanceItemSearchData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, relevanceItemSearchData) == null) {
            this.f58726f.onDataRes();
            if (relevanceItemSearchData != null && !ListUtils.isEmpty(relevanceItemSearchData.getData().getItem_list())) {
                this.f58730j.addAll(relevanceItemSearchData.getData().getItem_list());
                this.m.notifyDataSetChanged();
            }
            if (this.f58728h.getVisibility() == 8) {
                this.f58728h.setVisibility(0);
            }
        }
    }

    @Override // c.a.p0.b4.u.m.a.a.b
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.k = false;
            this.f58728h.setNextPage(this.f58729i);
            this.f58729i.A(this.f58726f.getResources().getString(R.string.list_no_more));
            this.f58729i.f();
            this.f58729i.J(l.g(this.f58728h.getContext(), R.dimen.tbds44));
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f58730j.clear();
            this.k = true;
            this.l = str;
            this.m.notifyDataSetChanged();
            this.f58727g.g(str);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f58727g.h();
        }
    }

    public BdRecyclerView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f58728h : (BdRecyclerView) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            BdRecyclerView bdRecyclerView = (BdRecyclerView) this.f58725e.findViewById(R.id.item_list);
            this.f58728h = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new XLinearLayoutManager(this.f58725e.getContext()));
            this.f58728h.setAdapter(this.m);
            PbListView pbListView = new PbListView(this.f58725e.getContext());
            this.f58729i = pbListView;
            pbListView.a();
            this.f58729i.o(R.color.CAM_X0205);
            this.f58729i.v();
            this.f58729i.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f58729i.E(R.dimen.tbfontsize33);
            this.f58729i.y(R.color.CAM_X0110);
            this.f58728h.setNextPage(this.f58729i);
            this.f58728h.setOnItemClickListener(this);
            this.f58728h.setOnSrollToBottomListener(this);
            this.f58727g.m(this);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f58727g.j();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f58729i.H();
            this.f58729i.O();
            this.f58729i.A(this.f58728h.getContext().getString(R.string.list_loading));
            this.f58729i.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    @Override // c.a.p0.b4.u.m.a.a.b
    public void onError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, str) == null) {
            this.f58730j.clear();
            this.m.notifyDataSetChanged();
            this.f58728h.setVisibility(8);
            this.f58726f.onError(str);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.k) {
            this.f58727g.h();
            l();
        }
    }
}
