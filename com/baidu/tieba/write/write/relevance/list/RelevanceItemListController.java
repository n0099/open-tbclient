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
/* loaded from: classes7.dex */
public class RelevanceItemListController implements BdListView.e, BdRecyclerView.a, a.InterfaceC0913a {
    private String fie;
    private PbListView gCf;
    private BdRecyclerView irL;
    private final View mRoot;
    private final RelevanceItemListFragment opy;
    private final a opz;
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
            listViewHolder.a((ReleavanceItemListData.ItemListBean) RelevanceItemListController.this.mDataList.get(i), RelevanceItemListController.this.fie);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return RelevanceItemListController.this.mDataList.size();
        }
    };

    public RelevanceItemListController(RelevanceItemListFragment relevanceItemListFragment, View view, String str, BdUniqueId bdUniqueId) {
        this.mRoot = view;
        this.opy = relevanceItemListFragment;
        this.opz = new a(bdUniqueId, str);
        initUI();
    }

    private void initUI() {
        this.irL = (BdRecyclerView) this.mRoot.findViewById(R.id.item_list);
        this.irL.setLayoutManager(new XLinearLayoutManager(this.mRoot.getContext()));
        this.irL.setAdapter(this.mAdapter);
        this.gCf = new PbListView(this.mRoot.getContext());
        this.gCf.createView();
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gCf.setLineGone();
        this.gCf.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.irL.setNextPage(this.gCf);
        this.irL.setOnItemClickListener(this);
        this.irL.setOnSrollToBottomListener(this);
        this.opz.a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dZV() {
        this.opz.dZY();
    }

    @Override // com.baidu.tieba.write.write.relevance.list.a.InterfaceC0913a
    public void a(RelevanceItemSearchData relevanceItemSearchData) {
        this.opy.djH();
        if (relevanceItemSearchData != null && !y.isEmpty(relevanceItemSearchData.getData().getItem_list())) {
            this.mDataList.addAll(relevanceItemSearchData.getData().getItem_list());
            this.mAdapter.notifyDataSetChanged();
        }
        if (this.irL.getVisibility() == 8) {
            this.irL.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.write.write.relevance.list.a.InterfaceC0913a
    public void onError(int i, String str) {
        this.mDataList.clear();
        this.mAdapter.notifyDataSetChanged();
        this.irL.setVisibility(8);
        this.opy.onError(str);
    }

    @Override // com.baidu.tieba.write.write.relevance.list.a.InterfaceC0913a
    public void dZW() {
        this.opy.cPd();
    }

    @Override // com.baidu.tieba.write.write.relevance.list.a.InterfaceC0913a
    public void dZX() {
        this.hasMore = false;
        this.irL.setNextPage(this.gCf);
        this.gCf.setText(this.opy.getResources().getString(R.string.list_no_more));
        this.gCf.endLoadData();
        this.gCf.showEmptyView(l.getDimens(this.irL.getContext(), R.dimen.tbds44));
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
            this.opy.getActivity().finish();
        }
    }

    public void onDestroy() {
        this.opz.onDestroy();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.hasMore) {
            this.opz.dZY();
            Xa();
        }
    }

    public void Xa() {
        this.gCf.setTopExtraViewGone();
        this.gCf.startLoadData();
        this.gCf.setText(this.irL.getContext().getString(R.string.list_loading));
        this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void VK(String str) {
        this.mDataList.clear();
        this.hasMore = true;
        this.fie = str;
        this.mAdapter.notifyDataSetChanged();
        this.opz.VK(str);
    }

    public BdRecyclerView getListView() {
        return this.irL;
    }

    /* loaded from: classes7.dex */
    public static class ListViewHolder extends RecyclerView.ViewHolder {
        ItemCardView mdY;
        private final View opB;

        public ListViewHolder(View view) {
            super(view);
            this.mdY = (ItemCardView) view.findViewById(R.id.item_rate_info);
            this.mdY.setBackGroundColor(R.color.transparent_1);
            this.mdY.setSizeStyle(1);
            this.opB = view.findViewById(R.id.bottom_divider);
            ap.setBackgroundColor(this.opB, R.color.CAM_X0203);
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
                this.mdY.setHighLightText(str + "");
                this.mdY.setData(tbRichTextEvaluateItemInfo, 10);
            }
        }
    }
}
