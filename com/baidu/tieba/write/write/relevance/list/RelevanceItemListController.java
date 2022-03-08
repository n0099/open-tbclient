package com.baidu.tieba.write.write.relevance.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.m.b;
import c.a.d.f.p.n;
import c.a.r0.q4.u.m.a.a;
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
/* loaded from: classes6.dex */
public class RelevanceItemListController implements BdRecyclerView.i, a.b, BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final View f48515e;

    /* renamed from: f  reason: collision with root package name */
    public final RelevanceItemListFragment f48516f;

    /* renamed from: g  reason: collision with root package name */
    public final c.a.r0.q4.u.m.a.a f48517g;

    /* renamed from: h  reason: collision with root package name */
    public BdRecyclerView f48518h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f48519i;

    /* renamed from: j  reason: collision with root package name */
    public List<ReleavanceItemListData.ItemListBean> f48520j;
    public boolean k;
    public String l;
    public RecyclerView.Adapter m;

    /* loaded from: classes6.dex */
    public static class ListViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final View a;

        /* renamed from: b  reason: collision with root package name */
        public ItemCardView f48521b;

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
            this.f48521b = itemCardView;
            itemCardView.setBackGroundColor(R.color.transparent_1);
            this.f48521b.setSizeStyle(1);
            View findViewById = view.findViewById(R.id.bottom_divider);
            this.a = findViewById;
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
            ItemCardView itemCardView = this.f48521b;
            itemCardView.setHighLightText(str + "");
            this.f48521b.setData(tbRichTextEvaluateItemInfo, 10, "");
        }
    }

    /* loaded from: classes6.dex */
    public class a extends RecyclerView.Adapter<ListViewHolder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RelevanceItemListController a;

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
            this.a = relevanceItemListController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(ListViewHolder listViewHolder, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, listViewHolder, i2) == null) {
                listViewHolder.bindData((ReleavanceItemListData.ItemListBean) this.a.f48520j.get(i2), this.a.l);
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.f48520j.size() : invokeV.intValue;
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
        this.f48520j = new ArrayList();
        this.k = true;
        this.m = new a(this);
        this.f48515e = view;
        this.f48516f = relevanceItemListFragment;
        this.f48517g = new c.a.r0.q4.u.m.a.a(bdUniqueId, str);
        j();
    }

    @Override // c.a.r0.q4.u.m.a.a.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f48516f.onNoData();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0082  */
    @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(ViewGroup viewGroup, View view, Object obj, int i2, long j2) {
        double d2;
        double d3;
        double d4;
        int i3;
        double parseDouble;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{viewGroup, view, obj, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || ListUtils.isEmpty(this.f48520j)) {
            return;
        }
        ReleavanceItemListData.ItemListBean itemListBean = this.f48520j.get(i2);
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
            if (this.f48516f.hasSelected(b.g(itemListBean.getItem_id(), 0L))) {
            }
        }
        if (this.f48516f.hasSelected(b.g(itemListBean.getItem_id(), 0L))) {
            MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemSelectedMessage(itemListBean.getItem_id(), itemListBean.getItem_name(), itemListBean.getIcon_url(), d3, d4, i3, itemListBean.getTags()));
            this.f48516f.getActivity().finish();
            return;
        }
        n.M(this.f48516f.getContext(), R.string.write_has_selected_item);
    }

    @Override // c.a.r0.q4.u.m.a.a.b
    public void c(RelevanceItemSearchData relevanceItemSearchData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, relevanceItemSearchData) == null) {
            this.f48516f.onDataRes();
            if (relevanceItemSearchData != null && !ListUtils.isEmpty(relevanceItemSearchData.getData().getItem_list())) {
                this.f48520j.addAll(relevanceItemSearchData.getData().getItem_list());
                this.m.notifyDataSetChanged();
            }
            if (this.f48518h.getVisibility() == 8) {
                this.f48518h.setVisibility(0);
            }
        }
    }

    @Override // c.a.r0.q4.u.m.a.a.b
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.k = false;
            this.f48518h.setNextPage(this.f48519i);
            this.f48519i.D(this.f48516f.getResources().getString(R.string.list_no_more));
            this.f48519i.f();
            this.f48519i.M(n.f(this.f48518h.getContext(), R.dimen.tbds44));
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f48520j.clear();
            this.k = true;
            this.l = str;
            this.m.notifyDataSetChanged();
            this.f48517g.g(str);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f48517g.h();
        }
    }

    public BdRecyclerView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f48518h : (BdRecyclerView) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            BdRecyclerView bdRecyclerView = (BdRecyclerView) this.f48515e.findViewById(R.id.item_list);
            this.f48518h = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new XLinearLayoutManager(this.f48515e.getContext()));
            this.f48518h.setAdapter(this.m);
            PbListView pbListView = new PbListView(this.f48515e.getContext());
            this.f48519i = pbListView;
            pbListView.a();
            this.f48519i.p(R.color.CAM_X0205);
            this.f48519i.y();
            this.f48519i.F(SkinManager.getColor(R.color.CAM_X0107));
            this.f48519i.H(R.dimen.tbfontsize33);
            this.f48519i.B(R.color.CAM_X0110);
            this.f48518h.setNextPage(this.f48519i);
            this.f48518h.setOnItemClickListener(this);
            this.f48518h.setOnSrollToBottomListener(this);
            this.f48517g.m(this);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f48517g.j();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f48519i.K();
            this.f48519i.R();
            this.f48519i.D(this.f48518h.getContext().getString(R.string.list_loading));
            this.f48519i.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    @Override // c.a.r0.q4.u.m.a.a.b
    public void onError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, str) == null) {
            this.f48520j.clear();
            this.m.notifyDataSetChanged();
            this.f48518h.setVisibility(8);
            this.f48516f.onError(str);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.k) {
            this.f48517g.h();
            l();
        }
    }
}
