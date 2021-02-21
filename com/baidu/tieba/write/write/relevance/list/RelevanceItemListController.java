package com.baidu.tieba.write.write.relevance.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
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
import com.baidu.tieba.write.write.relevance.list.a;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class RelevanceItemListController implements BdListView.e, BdRecyclerView.a, a.InterfaceC0907a {
    private String fgE;
    private PbListView gAw;
    private BdRecyclerView iqc;
    private final View mRoot;
    private final RelevanceItemListFragment ons;
    private final a ont;
    private List<ReleavanceItemListData.ItemListBean> mDataList = new ArrayList();
    private boolean hasMore = true;
    private RecyclerView.Adapter mAdapter = new RecyclerView.Adapter<ListViewHolder>() { // from class: com.baidu.tieba.write.write.relevance.list.RelevanceItemListController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: U */
        public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.relevance_item_view, (ViewGroup) null));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(ListViewHolder listViewHolder, int i) {
            listViewHolder.a((ReleavanceItemListData.ItemListBean) RelevanceItemListController.this.mDataList.get(i), RelevanceItemListController.this.fgE);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return RelevanceItemListController.this.mDataList.size();
        }
    };

    public RelevanceItemListController(RelevanceItemListFragment relevanceItemListFragment, View view, String str, BdUniqueId bdUniqueId) {
        this.mRoot = view;
        this.ons = relevanceItemListFragment;
        this.ont = new a(bdUniqueId, str);
        initUI();
    }

    private void initUI() {
        this.iqc = (BdRecyclerView) this.mRoot.findViewById(R.id.item_list);
        this.iqc.setLayoutManager(new XLinearLayoutManager(this.mRoot.getContext()));
        this.iqc.setAdapter(this.mAdapter);
        this.gAw = new PbListView(this.mRoot.getContext());
        this.gAw.createView();
        this.gAw.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gAw.setLineGone();
        this.gAw.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gAw.setTextSize(R.dimen.tbfontsize33);
        this.gAw.setNoMoreTextColorId(R.color.CAM_X0110);
        this.iqc.setNextPage(this.gAw);
        this.iqc.setOnItemClickListener(this);
        this.iqc.setOnSrollToBottomListener(this);
        this.ont.a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dZN() {
        this.ont.dZQ();
    }

    @Override // com.baidu.tieba.write.write.relevance.list.a.InterfaceC0907a
    public void a(RelevanceItemSearchData relevanceItemSearchData) {
        this.ons.djy();
        if (relevanceItemSearchData != null && !y.isEmpty(relevanceItemSearchData.getData().getItem_list())) {
            this.mDataList.addAll(relevanceItemSearchData.getData().getItem_list());
            this.mAdapter.notifyDataSetChanged();
        }
        if (this.iqc.getVisibility() == 8) {
            this.iqc.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.write.write.relevance.list.a.InterfaceC0907a
    public void onError(int i, String str) {
        this.mDataList.clear();
        this.mAdapter.notifyDataSetChanged();
        this.iqc.setVisibility(8);
        this.ons.onError(str);
    }

    @Override // com.baidu.tieba.write.write.relevance.list.a.InterfaceC0907a
    public void dZO() {
        this.ons.cOW();
    }

    @Override // com.baidu.tieba.write.write.relevance.list.a.InterfaceC0907a
    public void dZP() {
        this.hasMore = false;
        this.iqc.setNextPage(this.gAw);
        this.gAw.setText(this.ons.getResources().getString(R.string.list_no_more));
        this.gAw.endLoadData();
        this.gAw.showEmptyView(l.getDimens(this.iqc.getContext(), R.dimen.tbds44));
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
            this.ons.getActivity().finish();
        }
    }

    public void onDestroy() {
        this.ont.onDestroy();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.hasMore) {
            this.ont.dZQ();
            WX();
        }
    }

    public void WX() {
        this.gAw.setTopExtraViewGone();
        this.gAw.startLoadData();
        this.gAw.setText(this.iqc.getContext().getString(R.string.list_loading));
        this.gAw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void VD(String str) {
        this.mDataList.clear();
        this.hasMore = true;
        this.fgE = str;
        this.mAdapter.notifyDataSetChanged();
        this.ont.VD(str);
    }

    public BdRecyclerView getListView() {
        return this.iqc;
    }

    /* loaded from: classes8.dex */
    public static class ListViewHolder extends RecyclerView.ViewHolder {
        ItemCardView mbW;
        private final View onv;

        public ListViewHolder(View view) {
            super(view);
            this.mbW = (ItemCardView) view.findViewById(R.id.item_rate_info);
            this.mbW.setBackGroundColor(R.color.transparent_1);
            this.mbW.setSizeStyle(1);
            this.onv = view.findViewById(R.id.bottom_divider);
            ap.setBackgroundColor(this.onv, R.color.CAM_X0203);
        }

        public void a(ReleavanceItemListData.ItemListBean itemListBean, String str) {
            if (itemListBean != null) {
                TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo = new TbRichTextEvaluateItemInfo();
                tbRichTextEvaluateItemInfo.setTitle(itemListBean.getItem_name());
                tbRichTextEvaluateItemInfo.setIconUrl(itemListBean.getIcon_url());
                try {
                    tbRichTextEvaluateItemInfo.setScore(Double.parseDouble(itemListBean.getScore()));
                    tbRichTextEvaluateItemInfo.setIconSize(Double.parseDouble(itemListBean.getIcon_size()));
                    tbRichTextEvaluateItemInfo.setStar(Integer.parseInt(itemListBean.getStar()));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                tbRichTextEvaluateItemInfo.setTags(itemListBean.getTags());
                this.mbW.setHighLightText(str + "");
                this.mbW.setData(tbRichTextEvaluateItemInfo, 10);
            }
        }
    }
}
