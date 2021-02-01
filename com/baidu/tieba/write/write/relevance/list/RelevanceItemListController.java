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
public class RelevanceItemListController implements BdListView.e, BdRecyclerView.a, a.InterfaceC0905a {
    private String fgE;
    private PbListView gAi;
    private BdRecyclerView ipO;
    private final View mRoot;
    private final RelevanceItemListFragment omR;
    private final a omS;
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
        this.omR = relevanceItemListFragment;
        this.omS = new a(bdUniqueId, str);
        initUI();
    }

    private void initUI() {
        this.ipO = (BdRecyclerView) this.mRoot.findViewById(R.id.item_list);
        this.ipO.setLayoutManager(new XLinearLayoutManager(this.mRoot.getContext()));
        this.ipO.setAdapter(this.mAdapter);
        this.gAi = new PbListView(this.mRoot.getContext());
        this.gAi.createView();
        this.gAi.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gAi.setLineGone();
        this.gAi.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gAi.setTextSize(R.dimen.tbfontsize33);
        this.gAi.setNoMoreTextColorId(R.color.CAM_X0110);
        this.ipO.setNextPage(this.gAi);
        this.ipO.setOnItemClickListener(this);
        this.ipO.setOnSrollToBottomListener(this);
        this.omS.a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dZF() {
        this.omS.dZI();
    }

    @Override // com.baidu.tieba.write.write.relevance.list.a.InterfaceC0905a
    public void a(RelevanceItemSearchData relevanceItemSearchData) {
        this.omR.djr();
        if (relevanceItemSearchData != null && !y.isEmpty(relevanceItemSearchData.getData().getItem_list())) {
            this.mDataList.addAll(relevanceItemSearchData.getData().getItem_list());
            this.mAdapter.notifyDataSetChanged();
        }
        if (this.ipO.getVisibility() == 8) {
            this.ipO.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.write.write.relevance.list.a.InterfaceC0905a
    public void onError(int i, String str) {
        this.mDataList.clear();
        this.mAdapter.notifyDataSetChanged();
        this.ipO.setVisibility(8);
        this.omR.onError(str);
    }

    @Override // com.baidu.tieba.write.write.relevance.list.a.InterfaceC0905a
    public void dZG() {
        this.omR.cOP();
    }

    @Override // com.baidu.tieba.write.write.relevance.list.a.InterfaceC0905a
    public void dZH() {
        this.hasMore = false;
        this.ipO.setNextPage(this.gAi);
        this.gAi.setText(this.omR.getResources().getString(R.string.list_no_more));
        this.gAi.endLoadData();
        this.gAi.showEmptyView(l.getDimens(this.ipO.getContext(), R.dimen.tbds44));
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
            this.omR.getActivity().finish();
        }
    }

    public void onDestroy() {
        this.omS.onDestroy();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.hasMore) {
            this.omS.dZI();
            WX();
        }
    }

    public void WX() {
        this.gAi.setTopExtraViewGone();
        this.gAi.startLoadData();
        this.gAi.setText(this.ipO.getContext().getString(R.string.list_loading));
        this.gAi.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void Vr(String str) {
        this.mDataList.clear();
        this.hasMore = true;
        this.fgE = str;
        this.mAdapter.notifyDataSetChanged();
        this.omS.Vr(str);
    }

    public BdRecyclerView getListView() {
        return this.ipO;
    }

    /* loaded from: classes8.dex */
    public static class ListViewHolder extends RecyclerView.ViewHolder {
        ItemCardView mbH;
        private final View omU;

        public ListViewHolder(View view) {
            super(view);
            this.mbH = (ItemCardView) view.findViewById(R.id.item_rate_info);
            this.mbH.setBackGroundColor(R.color.transparent_1);
            this.mbH.setSizeStyle(1);
            this.omU = view.findViewById(R.id.bottom_divider);
            ap.setBackgroundColor(this.omU, R.color.CAM_X0203);
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
                this.mbH.setHighLightText(str + "");
                this.mbH.setData(tbRichTextEvaluateItemInfo, 10);
            }
        }
    }
}
