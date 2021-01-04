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
/* loaded from: classes8.dex */
public class RelevanceItemListController implements BdListView.e, BdRecyclerView.a, a.InterfaceC0881a {
    private String fiZ;
    private PbListView gCf;
    private BdRecyclerView ioP;
    private final View mRoot;
    private final RelevanceItemListFragment ohF;
    private final a ohG;
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
            listViewHolder.a((ReleavanceItemListData.ItemListBean) RelevanceItemListController.this.mDataList.get(i), RelevanceItemListController.this.fiZ);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return RelevanceItemListController.this.mDataList.size();
        }
    };

    public RelevanceItemListController(RelevanceItemListFragment relevanceItemListFragment, View view, String str, BdUniqueId bdUniqueId) {
        this.mRoot = view;
        this.ohF = relevanceItemListFragment;
        this.ohG = new a(bdUniqueId, str);
        initUI();
    }

    private void initUI() {
        this.ioP = (BdRecyclerView) this.mRoot.findViewById(R.id.item_list);
        this.ioP.setLayoutManager(new XLinearLayoutManager(this.mRoot.getContext()));
        this.ioP.setAdapter(this.mAdapter);
        this.gCf = new PbListView(this.mRoot.getContext());
        this.gCf.createView();
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gCf.setLineGone();
        this.gCf.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.ioP.setNextPage(this.gCf);
        this.ioP.setOnItemClickListener(this);
        this.ioP.setOnSrollToBottomListener(this);
        this.ohG.a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ebl() {
        this.ohG.ebo();
    }

    @Override // com.baidu.tieba.write.write.relevance.list.a.InterfaceC0881a
    public void a(RelevanceItemSearchData relevanceItemSearchData) {
        this.ohF.dlh();
        if (relevanceItemSearchData != null && !x.isEmpty(relevanceItemSearchData.getData().getItem_list())) {
            this.mDataList.addAll(relevanceItemSearchData.getData().getItem_list());
            this.mAdapter.notifyDataSetChanged();
        }
        if (this.ioP.getVisibility() == 8) {
            this.ioP.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.write.write.relevance.list.a.InterfaceC0881a
    public void onError(int i, String str) {
        this.mDataList.clear();
        this.mAdapter.notifyDataSetChanged();
        this.ioP.setVisibility(8);
        this.ohF.onError(str);
    }

    @Override // com.baidu.tieba.write.write.relevance.list.a.InterfaceC0881a
    public void ebm() {
        this.ohF.cQK();
    }

    @Override // com.baidu.tieba.write.write.relevance.list.a.InterfaceC0881a
    public void ebn() {
        this.hasMore = false;
        this.ioP.setNextPage(this.gCf);
        this.gCf.setText(this.ohF.getResources().getString(R.string.list_no_more));
        this.gCf.endLoadData();
        this.gCf.showEmptyView(l.getDimens(this.ioP.getContext(), R.dimen.tbds44));
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
            this.ohF.getActivity().finish();
        }
    }

    public void onDestroy() {
        this.ohG.onDestroy();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.hasMore) {
            this.ohG.ebo();
            Zg();
        }
    }

    public void Zg() {
        this.gCf.setTopExtraViewGone();
        this.gCf.startLoadData();
        this.gCf.setText(this.ioP.getContext().getString(R.string.list_loading));
        this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void VB(String str) {
        this.mDataList.clear();
        this.hasMore = true;
        this.fiZ = str;
        this.mAdapter.notifyDataSetChanged();
        this.ohG.VB(str);
    }

    public BdRecyclerView getListView() {
        return this.ioP;
    }

    /* loaded from: classes8.dex */
    public static class ListViewHolder extends RecyclerView.ViewHolder {
        private final View ohI;
        ItemCardView ohJ;

        public ListViewHolder(View view) {
            super(view);
            this.ohJ = (ItemCardView) view.findViewById(R.id.item_rate_info);
            this.ohJ.setBackGroundColor(R.color.transparent_1);
            this.ohJ.setSizeStyle(1);
            this.ohI = view.findViewById(R.id.bottom_divider);
            ao.setBackgroundColor(this.ohI, R.color.CAM_X0203);
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
                this.ohJ.setHighLightText(str + "");
                this.ohJ.setData(tbRichTextEvaluateItemInfo, 10);
            }
        }
    }
}
