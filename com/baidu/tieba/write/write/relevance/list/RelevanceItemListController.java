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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes7.dex */
public class RelevanceItemListController implements BdListView.e, BdRecyclerView.a, a.InterfaceC0902a {
    private String feo;
    private PbListView gxy;
    private BdRecyclerView ikg;
    private final View mRoot;
    private final RelevanceItemListFragment ocY;
    private final a ocZ;
    private List<ReleavanceItemListData.ItemListBean> mDataList = new ArrayList();
    private boolean hasMore = true;
    private RecyclerView.Adapter mAdapter = new RecyclerView.Adapter<ListViewHolder>() { // from class: com.baidu.tieba.write.write.relevance.list.RelevanceItemListController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: T */
        public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.relevance_item_view, (ViewGroup) null));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(ListViewHolder listViewHolder, int i) {
            listViewHolder.a((ReleavanceItemListData.ItemListBean) RelevanceItemListController.this.mDataList.get(i), RelevanceItemListController.this.feo);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return RelevanceItemListController.this.mDataList.size();
        }
    };

    public RelevanceItemListController(RelevanceItemListFragment relevanceItemListFragment, View view, String str, BdUniqueId bdUniqueId) {
        this.mRoot = view;
        this.ocY = relevanceItemListFragment;
        this.ocZ = new a(bdUniqueId, str);
        initUI();
    }

    private void initUI() {
        this.ikg = (BdRecyclerView) this.mRoot.findViewById(R.id.item_list);
        this.ikg.setLayoutManager(new XLinearLayoutManager(this.mRoot.getContext()));
        this.ikg.setAdapter(this.mAdapter);
        this.gxy = new PbListView(this.mRoot.getContext());
        this.gxy.createView();
        this.gxy.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gxy.setLineGone();
        this.gxy.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gxy.setTextSize(R.dimen.tbfontsize33);
        this.gxy.setNoMoreTextColorId(R.color.CAM_X0110);
        this.ikg.setNextPage(this.gxy);
        this.ikg.setOnItemClickListener(this);
        this.ikg.setOnSrollToBottomListener(this);
        this.ocZ.a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dXu() {
        this.ocZ.dXx();
    }

    @Override // com.baidu.tieba.write.write.relevance.list.a.InterfaceC0902a
    public void a(RelevanceItemSearchData relevanceItemSearchData) {
        this.ocY.dhq();
        if (relevanceItemSearchData != null && !x.isEmpty(relevanceItemSearchData.getData().getItem_list())) {
            this.mDataList.addAll(relevanceItemSearchData.getData().getItem_list());
            this.mAdapter.notifyDataSetChanged();
        }
        if (this.ikg.getVisibility() == 8) {
            this.ikg.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.write.write.relevance.list.a.InterfaceC0902a
    public void onError(int i, String str) {
        this.mDataList.clear();
        this.mAdapter.notifyDataSetChanged();
        this.ikg.setVisibility(8);
        this.ocY.onError(str);
    }

    @Override // com.baidu.tieba.write.write.relevance.list.a.InterfaceC0902a
    public void dXv() {
        this.ocY.cMT();
    }

    @Override // com.baidu.tieba.write.write.relevance.list.a.InterfaceC0902a
    public void dXw() {
        this.hasMore = false;
        this.ikg.setNextPage(this.gxy);
        this.gxy.setText(this.ocY.getResources().getString(R.string.list_no_more));
        this.gxy.endLoadData();
        this.gxy.showEmptyView(l.getDimens(this.ikg.getContext(), R.dimen.tbds44));
    }

    @Override // com.baidu.adp.widget.ListView.BdRecyclerView.a
    public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
        if (!x.isEmpty(this.mDataList)) {
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
            this.ocY.getActivity().finish();
        }
    }

    public void onDestroy() {
        this.ocZ.onDestroy();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.hasMore) {
            this.ocZ.dXx();
            Vo();
        }
    }

    public void Vo() {
        this.gxy.setTopExtraViewGone();
        this.gxy.startLoadData();
        this.gxy.setText(this.ikg.getContext().getString(R.string.list_loading));
        this.gxy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void Us(String str) {
        this.mDataList.clear();
        this.hasMore = true;
        this.feo = str;
        this.mAdapter.notifyDataSetChanged();
        this.ocZ.Us(str);
    }

    public BdRecyclerView getListView() {
        return this.ikg;
    }

    /* loaded from: classes7.dex */
    public static class ListViewHolder extends RecyclerView.ViewHolder {
        private final View odb;
        ItemCardView odc;

        public ListViewHolder(View view) {
            super(view);
            this.odc = (ItemCardView) view.findViewById(R.id.item_rate_info);
            this.odc.setBackGroundColor(R.color.transparent_1);
            this.odc.setSizeStyle(1);
            this.odb = view.findViewById(R.id.bottom_divider);
            ao.setBackgroundColor(this.odb, R.color.CAM_X0203);
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
                this.odc.setHighLightText(str + "");
                this.odc.setData(tbRichTextEvaluateItemInfo, 10);
            }
        }
    }
}
