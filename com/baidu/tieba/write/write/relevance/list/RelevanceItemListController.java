package com.baidu.tieba.write.write.relevance.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
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
import d.a.c.e.p.l;
import d.a.k0.v3.u.m.a.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class RelevanceItemListController implements BdRecyclerView.i, a.b, BdListView.p {

    /* renamed from: e  reason: collision with root package name */
    public final View f22207e;

    /* renamed from: f  reason: collision with root package name */
    public final RelevanceItemListFragment f22208f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.k0.v3.u.m.a.a f22209g;

    /* renamed from: h  reason: collision with root package name */
    public BdRecyclerView f22210h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f22211i;
    public String l;
    public List<ReleavanceItemListData.ItemListBean> j = new ArrayList();
    public boolean k = true;
    public RecyclerView.Adapter m = new a();

    /* loaded from: classes5.dex */
    public static class ListViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final View f22212a;

        /* renamed from: b  reason: collision with root package name */
        public ItemCardView f22213b;

        public ListViewHolder(View view) {
            super(view);
            ItemCardView itemCardView = (ItemCardView) view.findViewById(R.id.item_rate_info);
            this.f22213b = itemCardView;
            itemCardView.setBackGroundColor(R.color.transparent_1);
            this.f22213b.setSizeStyle(1);
            View findViewById = view.findViewById(R.id.bottom_divider);
            this.f22212a = findViewById;
            SkinManager.setBackgroundColor(findViewById, R.color.CAM_X0203);
        }

        public void a(ReleavanceItemListData.ItemListBean itemListBean, String str) {
            if (itemListBean == null) {
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
            ItemCardView itemCardView = this.f22213b;
            itemCardView.setHighLightText(str + "");
            this.f22213b.setData(tbRichTextEvaluateItemInfo, 10);
        }
    }

    /* loaded from: classes5.dex */
    public class a extends RecyclerView.Adapter<ListViewHolder> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: c */
        public void onBindViewHolder(ListViewHolder listViewHolder, int i2) {
            listViewHolder.a((ReleavanceItemListData.ItemListBean) RelevanceItemListController.this.j.get(i2), RelevanceItemListController.this.l);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d */
        public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            return new ListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.relevance_item_view, (ViewGroup) null));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return RelevanceItemListController.this.j.size();
        }
    }

    public RelevanceItemListController(RelevanceItemListFragment relevanceItemListFragment, View view, String str, BdUniqueId bdUniqueId) {
        this.f22207e = view;
        this.f22208f = relevanceItemListFragment;
        this.f22209g = new d.a.k0.v3.u.m.a.a(bdUniqueId, str);
        j();
    }

    @Override // d.a.k0.v3.u.m.a.a.b
    public void a() {
        this.f22208f.H0();
    }

    @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
    public void b(ViewGroup viewGroup, View view, Object obj, int i2, long j) {
        double d2;
        double d3;
        double d4;
        int i3;
        if (ListUtils.isEmpty(this.j)) {
            return;
        }
        ReleavanceItemListData.ItemListBean itemListBean = this.j.get(i2);
        double d5 = 0.0d;
        try {
            double parseDouble = Double.parseDouble(itemListBean.getScore());
            try {
                d5 = Double.parseDouble(itemListBean.getIcon_size());
                i3 = Integer.parseInt(itemListBean.getStar());
                d4 = d5;
                d3 = parseDouble;
            } catch (NumberFormatException e2) {
                e = e2;
                double d6 = d5;
                d5 = parseDouble;
                d2 = d6;
                e.printStackTrace();
                d3 = d5;
                d4 = d2;
                i3 = 0;
                MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemSelectedMessage(itemListBean.getItem_id(), itemListBean.getItem_name(), itemListBean.getIcon_url(), d3, d4, i3, itemListBean.getTags()));
                this.f22208f.getActivity().finish();
            }
        } catch (NumberFormatException e3) {
            e = e3;
            d2 = 0.0d;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemSelectedMessage(itemListBean.getItem_id(), itemListBean.getItem_name(), itemListBean.getIcon_url(), d3, d4, i3, itemListBean.getTags()));
        this.f22208f.getActivity().finish();
    }

    @Override // d.a.k0.v3.u.m.a.a.b
    public void c(RelevanceItemSearchData relevanceItemSearchData) {
        this.f22208f.F0();
        if (relevanceItemSearchData != null && !ListUtils.isEmpty(relevanceItemSearchData.getData().getItem_list())) {
            this.j.addAll(relevanceItemSearchData.getData().getItem_list());
            this.m.notifyDataSetChanged();
        }
        if (this.f22210h.getVisibility() == 8) {
            this.f22210h.setVisibility(0);
        }
    }

    @Override // d.a.k0.v3.u.m.a.a.b
    public void d() {
        this.k = false;
        this.f22210h.setNextPage(this.f22211i);
        this.f22211i.A(this.f22208f.getResources().getString(R.string.list_no_more));
        this.f22211i.f();
        this.f22211i.J(l.g(this.f22210h.getContext(), R.dimen.tbds44));
    }

    public void g(String str) {
        this.j.clear();
        this.k = true;
        this.l = str;
        this.m.notifyDataSetChanged();
        this.f22209g.g(str);
    }

    public void h() {
        this.f22209g.h();
    }

    public BdRecyclerView i() {
        return this.f22210h;
    }

    public final void j() {
        BdRecyclerView bdRecyclerView = (BdRecyclerView) this.f22207e.findViewById(R.id.item_list);
        this.f22210h = bdRecyclerView;
        bdRecyclerView.setLayoutManager(new XLinearLayoutManager(this.f22207e.getContext()));
        this.f22210h.setAdapter(this.m);
        PbListView pbListView = new PbListView(this.f22207e.getContext());
        this.f22211i = pbListView;
        pbListView.a();
        this.f22211i.o(R.color.CAM_X0205);
        this.f22211i.v();
        this.f22211i.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f22211i.E(R.dimen.tbfontsize33);
        this.f22211i.y(R.color.CAM_X0110);
        this.f22210h.setNextPage(this.f22211i);
        this.f22210h.setOnItemClickListener(this);
        this.f22210h.setOnSrollToBottomListener(this);
        this.f22209g.m(this);
    }

    public void k() {
        this.f22209g.j();
    }

    public void l() {
        this.f22211i.H();
        this.f22211i.O();
        this.f22211i.A(this.f22210h.getContext().getString(R.string.list_loading));
        this.f22211i.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    @Override // d.a.k0.v3.u.m.a.a.b
    public void onError(int i2, String str) {
        this.j.clear();
        this.m.notifyDataSetChanged();
        this.f22210h.setVisibility(8);
        this.f22208f.G0(str);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        if (this.k) {
            this.f22209g.h();
            l();
        }
    }
}
