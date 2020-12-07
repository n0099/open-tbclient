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
    private PbListView gre;
    private BdRecyclerView icn;
    private final View mRoot;
    private final RelevanceItemListFragment ofY;
    private final b ofZ;
    private Editable oga;
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
            c0906a.a((ReleavanceItemListData.ItemListBean) a.this.mDataList.get(i), a.this.oga);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return a.this.mDataList.size();
        }
    };

    public a(RelevanceItemListFragment relevanceItemListFragment, View view, String str, BdUniqueId bdUniqueId) {
        this.mRoot = view;
        this.ofY = relevanceItemListFragment;
        this.ofZ = new b(bdUniqueId, str);
        initUI();
    }

    private void initUI() {
        this.icn = (BdRecyclerView) this.mRoot.findViewById(R.id.item_list);
        this.icn.setLayoutManager(new c(this.mRoot.getContext()));
        this.icn.setAdapter(this.mAdapter);
        this.gre = new PbListView(this.mRoot.getContext());
        this.gre.createView();
        this.gre.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gre.setLineGone();
        this.gre.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gre.setTextSize(R.dimen.tbfontsize33);
        this.gre.setNoMoreTextColorId(R.color.CAM_X0110);
        this.icn.setNextPage(this.gre);
        this.icn.setOnItemClickListener(this);
        this.icn.setOnSrollToBottomListener(this);
        this.ofZ.a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eco() {
        this.ofZ.ecr();
    }

    @Override // com.baidu.tieba.write.write.relevance.list.b.a
    public void a(RelevanceItemSearchData relevanceItemSearchData) {
        this.ofY.dlw();
        if (relevanceItemSearchData != null && !y.isEmpty(relevanceItemSearchData.getData().getItem_list())) {
            this.mDataList.addAll(relevanceItemSearchData.getData().getItem_list());
            this.mAdapter.notifyDataSetChanged();
        }
        if (this.icn.getVisibility() == 8) {
            this.icn.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.write.write.relevance.list.b.a
    public void onError(int i, String str) {
        this.mDataList.clear();
        this.mAdapter.notifyDataSetChanged();
        this.icn.setVisibility(8);
        this.ofY.onError(str);
    }

    @Override // com.baidu.tieba.write.write.relevance.list.b.a
    public void ecp() {
        this.ofY.cND();
    }

    @Override // com.baidu.tieba.write.write.relevance.list.b.a
    public void ecq() {
        this.hasMore = false;
        this.icn.setNextPage(this.gre);
        this.gre.setText(this.ofY.getResources().getString(R.string.list_no_more));
        this.gre.endLoadData();
        this.gre.showEmptyView(l.getDimens(this.icn.getContext(), R.dimen.tbds44));
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
            this.ofY.getActivity().finish();
        }
    }

    public void onDestroy() {
        this.ofZ.onDestroy();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.hasMore) {
            this.ofZ.ecr();
            XZ();
        }
    }

    public void XZ() {
        this.gre.setTopExtraViewGone();
        this.gre.startLoadData();
        this.gre.setText(this.icn.getContext().getString(R.string.list_loading));
        this.gre.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void g(Editable editable) {
        this.mDataList.clear();
        this.hasMore = true;
        this.oga = editable;
        this.mAdapter.notifyDataSetChanged();
        this.ofZ.g(editable);
    }

    public BdRecyclerView getListView() {
        return this.icn;
    }

    /* renamed from: com.baidu.tieba.write.write.relevance.list.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0906a extends RecyclerView.ViewHolder {
        private final View ogc;
        ItemCardView ogd;

        public C0906a(View view) {
            super(view);
            this.ogd = (ItemCardView) view.findViewById(R.id.item_rate_info);
            this.ogd.setBackGroundColor(R.color.transparent_1);
            this.ogd.setSizeStyle(1);
            this.ogc = view.findViewById(R.id.bottom_divider);
            ap.setBackgroundColor(this.ogc, R.color.CAM_X0203);
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
                this.ogd.setHighLightText(((Object) editable) + "");
                this.ogd.setData(tbRichTextEvaluateItemInfo, 10);
            }
        }
    }
}
