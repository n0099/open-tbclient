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
import d.b.b.e.p.l;
import d.b.i0.u3.v.m.a.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class RelevanceItemListController implements BdRecyclerView.i, a.b, BdListView.p {

    /* renamed from: e  reason: collision with root package name */
    public final View f22580e;

    /* renamed from: f  reason: collision with root package name */
    public final RelevanceItemListFragment f22581f;

    /* renamed from: g  reason: collision with root package name */
    public final d.b.i0.u3.v.m.a.a f22582g;

    /* renamed from: h  reason: collision with root package name */
    public BdRecyclerView f22583h;
    public PbListView i;
    public String l;
    public List<ReleavanceItemListData.ItemListBean> j = new ArrayList();
    public boolean k = true;
    public RecyclerView.Adapter m = new a();

    /* loaded from: classes5.dex */
    public static class ListViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final View f22584a;

        /* renamed from: b  reason: collision with root package name */
        public ItemCardView f22585b;

        public ListViewHolder(View view) {
            super(view);
            ItemCardView itemCardView = (ItemCardView) view.findViewById(R.id.item_rate_info);
            this.f22585b = itemCardView;
            itemCardView.setBackGroundColor(R.color.transparent_1);
            this.f22585b.setSizeStyle(1);
            View findViewById = view.findViewById(R.id.bottom_divider);
            this.f22584a = findViewById;
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
            ItemCardView itemCardView = this.f22585b;
            itemCardView.setHighLightText(str + "");
            this.f22585b.setData(tbRichTextEvaluateItemInfo, 10);
        }
    }

    /* loaded from: classes5.dex */
    public class a extends RecyclerView.Adapter<ListViewHolder> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: c */
        public void onBindViewHolder(ListViewHolder listViewHolder, int i) {
            listViewHolder.a((ReleavanceItemListData.ItemListBean) RelevanceItemListController.this.j.get(i), RelevanceItemListController.this.l);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d */
        public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.relevance_item_view, (ViewGroup) null));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return RelevanceItemListController.this.j.size();
        }
    }

    public RelevanceItemListController(RelevanceItemListFragment relevanceItemListFragment, View view, String str, BdUniqueId bdUniqueId) {
        this.f22580e = view;
        this.f22581f = relevanceItemListFragment;
        this.f22582g = new d.b.i0.u3.v.m.a.a(bdUniqueId, str);
        j();
    }

    @Override // d.b.i0.u3.v.m.a.a.b
    public void a() {
        this.f22581f.I0();
    }

    @Override // d.b.i0.u3.v.m.a.a.b
    public void b(RelevanceItemSearchData relevanceItemSearchData) {
        this.f22581f.G0();
        if (relevanceItemSearchData != null && !ListUtils.isEmpty(relevanceItemSearchData.getData().getItem_list())) {
            this.j.addAll(relevanceItemSearchData.getData().getItem_list());
            this.m.notifyDataSetChanged();
        }
        if (this.f22583h.getVisibility() == 8) {
            this.f22583h.setVisibility(0);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
    public void c(ViewGroup viewGroup, View view, Object obj, int i, long j) {
        double d2;
        double d3;
        double d4;
        int i2;
        if (ListUtils.isEmpty(this.j)) {
            return;
        }
        ReleavanceItemListData.ItemListBean itemListBean = this.j.get(i);
        double d5 = 0.0d;
        try {
            double parseDouble = Double.parseDouble(itemListBean.getScore());
            try {
                d5 = Double.parseDouble(itemListBean.getIcon_size());
                i2 = Integer.parseInt(itemListBean.getStar());
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
                i2 = 0;
                MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemSelectedMessage(itemListBean.getItem_id(), itemListBean.getItem_name(), itemListBean.getIcon_url(), d3, d4, i2, itemListBean.getTags()));
                this.f22581f.getActivity().finish();
            }
        } catch (NumberFormatException e3) {
            e = e3;
            d2 = 0.0d;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemSelectedMessage(itemListBean.getItem_id(), itemListBean.getItem_name(), itemListBean.getIcon_url(), d3, d4, i2, itemListBean.getTags()));
        this.f22581f.getActivity().finish();
    }

    @Override // d.b.i0.u3.v.m.a.a.b
    public void d() {
        this.k = false;
        this.f22583h.setNextPage(this.i);
        this.i.A(this.f22581f.getResources().getString(R.string.list_no_more));
        this.i.f();
        this.i.J(l.g(this.f22583h.getContext(), R.dimen.tbds44));
    }

    public void g(String str) {
        this.j.clear();
        this.k = true;
        this.l = str;
        this.m.notifyDataSetChanged();
        this.f22582g.g(str);
    }

    public void h() {
        this.f22582g.h();
    }

    public BdRecyclerView i() {
        return this.f22583h;
    }

    public final void j() {
        BdRecyclerView bdRecyclerView = (BdRecyclerView) this.f22580e.findViewById(R.id.item_list);
        this.f22583h = bdRecyclerView;
        bdRecyclerView.setLayoutManager(new XLinearLayoutManager(this.f22580e.getContext()));
        this.f22583h.setAdapter(this.m);
        PbListView pbListView = new PbListView(this.f22580e.getContext());
        this.i = pbListView;
        pbListView.a();
        this.i.o(R.color.CAM_X0205);
        this.i.v();
        this.i.C(SkinManager.getColor(R.color.CAM_X0107));
        this.i.E(R.dimen.tbfontsize33);
        this.i.y(R.color.CAM_X0110);
        this.f22583h.setNextPage(this.i);
        this.f22583h.setOnItemClickListener(this);
        this.f22583h.setOnSrollToBottomListener(this);
        this.f22582g.m(this);
    }

    public void k() {
        this.f22582g.j();
    }

    public void l() {
        this.i.H();
        this.i.O();
        this.i.A(this.f22583h.getContext().getString(R.string.list_loading));
        this.i.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    @Override // d.b.i0.u3.v.m.a.a.b
    public void onError(int i, String str) {
        this.j.clear();
        this.m.notifyDataSetChanged();
        this.f22583h.setVisibility(8);
        this.f22581f.H0(str);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        if (this.k) {
            this.f22582g.h();
            l();
        }
    }
}
