package com.baidu.tieba.write.write.relevance.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.EvaluateRelevanceItemSelectedMessage;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.relevance.RelevanceItemSearchData;
import com.baidu.tieba.write.write.relevance.list.ReleavanceItemListData;
import com.baidu.tieba.write.write.relevance.list.b;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class a implements BdListView.e, BdRecyclerView.a, b.a {
    private PbListView grg;
    private BdRecyclerView icp;
    private final View mRoot;
    private final RelevanceItemListFragment oga;
    private final b ogb;
    private Editable ogc;
    private List<ReleavanceItemListData.ItemListBean> mDataList = new ArrayList();
    private boolean hasMore = true;
    private RecyclerView.Adapter mAdapter = new RecyclerView.Adapter<C0906a>() { // from class: com.baidu.tieba.write.write.relevance.list.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: P */
        public C0906a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new C0906a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.relevance_item_view, (ViewGroup) null));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(C0906a c0906a, int i) {
            c0906a.a((ReleavanceItemListData.ItemListBean) a.this.mDataList.get(i), a.this.ogc);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return a.this.mDataList.size();
        }
    };

    public a(RelevanceItemListFragment relevanceItemListFragment, View view, String str, BdUniqueId bdUniqueId) {
        this.mRoot = view;
        this.oga = relevanceItemListFragment;
        this.ogb = new b(bdUniqueId, str);
        initUI();
    }

    private void initUI() {
        this.icp = (BdRecyclerView) this.mRoot.findViewById(R.id.item_list);
        this.icp.setLayoutManager(new c(this.mRoot.getContext()));
        this.icp.setAdapter(this.mAdapter);
        this.grg = new PbListView(this.mRoot.getContext());
        this.grg.createView();
        this.grg.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.grg.setLineGone();
        this.grg.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.grg.setTextSize(R.dimen.tbfontsize33);
        this.grg.setNoMoreTextColorId(R.color.CAM_X0110);
        this.icp.setNextPage(this.grg);
        this.icp.setOnItemClickListener(this);
        this.icp.setOnSrollToBottomListener(this);
        this.ogb.a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ecp() {
        this.ogb.ecs();
    }

    @Override // com.baidu.tieba.write.write.relevance.list.b.a
    public void a(RelevanceItemSearchData relevanceItemSearchData) {
        this.oga.dlx();
        if (relevanceItemSearchData != null && !y.isEmpty(relevanceItemSearchData.getData().getItem_list())) {
            this.mDataList.addAll(relevanceItemSearchData.getData().getItem_list());
            this.mAdapter.notifyDataSetChanged();
        }
        if (this.icp.getVisibility() == 8) {
            this.icp.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.write.write.relevance.list.b.a
    public void onError(int i, String str) {
        this.mDataList.clear();
        this.mAdapter.notifyDataSetChanged();
        this.icp.setVisibility(8);
        this.oga.onError(str);
    }

    @Override // com.baidu.tieba.write.write.relevance.list.b.a
    public void ecq() {
        this.oga.cNE();
    }

    @Override // com.baidu.tieba.write.write.relevance.list.b.a
    public void ecr() {
        this.hasMore = false;
        this.icp.setNextPage(this.grg);
        this.grg.setText(this.oga.getResources().getString(R.string.list_no_more));
        this.grg.endLoadData();
        this.grg.showEmptyView(l.getDimens(this.icp.getContext(), R.dimen.tbds44));
    }

    @Override // com.baidu.adp.widget.ListView.BdRecyclerView.a
    public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
        if (!y.isEmpty(this.mDataList)) {
            ReleavanceItemListData.ItemListBean itemListBean = this.mDataList.get(i);
            double d = 0.0d;
            double d2 = 0.0d;
            int i2 = 0;
            try {
                d = Double.parseDouble(itemListBean.getScore());
                d2 = Double.parseDouble(itemListBean.getIcon_size());
                i2 = Integer.parseInt(itemListBean.getStar());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemSelectedMessage(itemListBean.getItem_id(), itemListBean.getItem_name(), itemListBean.getIcon_url(), d, d2, i2, itemListBean.getTags()));
            this.oga.getActivity().finish();
        }
    }

    public void onDestroy() {
        this.ogb.onDestroy();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.hasMore) {
            this.ogb.ecs();
            XZ();
        }
    }

    public void XZ() {
        this.grg.setTopExtraViewGone();
        this.grg.startLoadData();
        this.grg.setText(this.icp.getContext().getString(R.string.list_loading));
        this.grg.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void g(Editable editable) {
        this.mDataList.clear();
        this.hasMore = true;
        this.ogc = editable;
        this.mAdapter.notifyDataSetChanged();
        this.ogb.g(editable);
    }

    public BdRecyclerView getListView() {
        return this.icp;
    }

    /* renamed from: com.baidu.tieba.write.write.relevance.list.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0906a extends RecyclerView.ViewHolder {
        private final View oge;
        ItemCardView ogf;

        public C0906a(View view) {
            super(view);
            this.ogf = (ItemCardView) view.findViewById(R.id.item_rate_info);
            this.ogf.setBackGroundColor(R.color.transparent_1);
            this.ogf.setSizeStyle(1);
            this.oge = view.findViewById(R.id.bottom_divider);
            ap.setBackgroundColor(this.oge, R.color.CAM_X0203);
        }

        public void a(ReleavanceItemListData.ItemListBean itemListBean, Editable editable) {
            if (itemListBean != null) {
                TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo = new TbRichTextEvaluateItemInfo();
                tbRichTextEvaluateItemInfo.setTitle(itemListBean.getItem_name());
                tbRichTextEvaluateItemInfo.setIconUrl(itemListBean.getIcon_url());
                try {
                    tbRichTextEvaluateItemInfo.y(Double.parseDouble(itemListBean.getScore()));
                    tbRichTextEvaluateItemInfo.setIconSize(Double.parseDouble(itemListBean.getIcon_size()));
                    tbRichTextEvaluateItemInfo.setStar(Integer.parseInt(itemListBean.getStar()));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                tbRichTextEvaluateItemInfo.setTags(itemListBean.getTags());
                this.ogf.setHighLightText(((Object) editable) + "");
                this.ogf.setData(tbRichTextEvaluateItemInfo, 10);
            }
        }
    }
}
