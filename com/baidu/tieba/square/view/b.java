package com.baidu.tieba.square.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.k.g;
import com.baidu.tieba.R;
import com.baidu.tieba.square.a.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class b {
    private BdListView.e Vz = new BdListView.e() { // from class: com.baidu.tieba.square.view.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.mhJ != null) {
                b.this.mhJ.stopScroll();
            }
            if (b.this.mlK != null) {
                b.this.mlK.onScrollToBottom();
            }
        }
    };
    private PbListView fHm;
    private g fQf;
    private TbPageContext<?> mPageContext;
    private final View mRoot;
    private BdTypeRecyclerView mhJ;
    private RelativeLayout mlE;
    private RecyclerView mlF;
    private LinearLayoutManager mlG;
    private com.baidu.tieba.square.a.a mlH;
    private LinearLayoutManager mlI;
    private com.baidu.tieba.square.a.b mlJ;
    private BdListView.e mlK;

    public b(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRoot = view;
        initView();
        doE();
    }

    private void initView() {
        this.mlE = (RelativeLayout) this.mRoot.findViewById(R.id.right_container);
        this.mlF = (RecyclerView) this.mRoot.findViewById(R.id.rv_left);
        this.mhJ = (BdTypeRecyclerView) this.mRoot.findViewById(R.id.rv_right);
    }

    public String dyD() {
        return this.mlH.dyP();
    }

    public void QQ(String str) {
        if (str != null) {
            int QR = this.mlH.QR(str);
            this.mlH.Ib(QR);
            Ig(QR);
        }
    }

    public void c(String str, List<String> list, boolean z) {
        int position = y.getPosition(list, str);
        this.mlH.p(position, list);
        if (z) {
            Ig(position);
        }
    }

    public void dyE() {
        ArrayList arrayList = new ArrayList();
        z zVar = new z();
        zVar.showText = this.mPageContext.getString(R.string.forum_square_list_no_data);
        zVar.resId = R.drawable.new_pic_emotion_06;
        arrayList.add(zVar);
        this.mlJ.setData(arrayList);
    }

    public void fl(List<q> list) {
        s(list, 0);
    }

    public void s(List<q> list, int i) {
        if (y.isEmpty(list)) {
            dyE();
            return;
        }
        if (i > 0) {
            Pair<Integer, Integer> dyC = dyC();
            int intValue = ((Integer) dyC.first).intValue();
            int intValue2 = ((Integer) dyC.second).intValue();
            int i2 = intValue - i;
            if (this.mlI != null && this.mhJ != null) {
                this.mhJ.qR();
                this.mlI.scrollToPositionWithOffset(i2, intValue2);
                this.mhJ.qS();
            }
        }
        this.mlJ.setData(list);
    }

    private void doE() {
        this.mlG = new LinearLayoutManager(this.mPageContext.getPageActivity());
        this.mlF.setLayoutManager(this.mlG);
        this.mlH = new com.baidu.tieba.square.a.a(this.mPageContext.getPageActivity());
        this.mlF.setAdapter(this.mlH);
        this.mlJ = new com.baidu.tieba.square.a.b(this.mPageContext, this.mhJ);
        this.mlI = new LinearLayoutManager(this.mPageContext.getPageActivity());
        this.mhJ.setLayoutManager(this.mlI);
        this.mhJ.setFadingEdgeLength(0);
        this.mhJ.setOverScrollMode(2);
        this.mhJ.setOnSrollToBottomListener(this.Vz);
        this.fHm = new PbListView(this.mPageContext.getPageActivity());
        this.fHm.getView();
        this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fHm.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.fHm.setLineGone();
        this.fHm.setTextSize(R.dimen.tbfontsize33);
        this.fHm.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fHm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fHm.blq();
    }

    public void e(BdListView.e eVar) {
        this.mlK = eVar;
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.mhJ != null) {
            this.mhJ.removeOnScrollListener(onScrollListener);
            this.mhJ.addOnScrollListener(onScrollListener);
        }
    }

    public void a(a.InterfaceC0798a interfaceC0798a) {
        if (this.mlH != null) {
            this.mlH.b(interfaceC0798a);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mlJ != null) {
            this.mlJ.notifyDataSetChanged();
        }
        if (this.mlH != null) {
            this.mlH.notifyDataSetChanged();
        }
        if (this.fHm != null) {
            this.fHm.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fHm.changeSkin(i);
        }
        if (this.fQf != null) {
            this.fQf.onChangeSkinType();
        }
    }

    public Pair<Integer, Integer> dyC() {
        int firstVisiblePosition = this.mhJ.getFirstVisiblePosition();
        View childAt = this.mhJ.getChildAt(0);
        return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(childAt != null ? childAt.getTop() : 0));
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.mhJ != null && (this.mhJ.getLayoutManager() instanceof LinearLayoutManager) && i <= this.mhJ.getCount() - 1) {
            ((LinearLayoutManager) this.mhJ.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    private void Ig(int i) {
        if (this.mlF != null && (this.mlF.getLayoutManager() instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.mlF.getLayoutManager();
            if (i < 0) {
                i = 0;
            } else if (i > this.mlH.getItemCount() - 1) {
                i = this.mlH.getItemCount() - 1;
            }
            linearLayoutManager.scrollToPositionWithOffset(i, 0);
        }
    }

    public void bIk() {
        this.mhJ.setNextPage(null);
    }

    public void dyJ() {
        this.mhJ.setNextPage(this.fHm);
        this.fHm.hideEmptyView();
        this.fHm.getView().setPadding(0, 0, 0, 0);
        this.fHm.setText(this.mPageContext.getPageActivity().getString(R.string.pb_load_more));
        this.fHm.endLoadData();
    }

    public void dyK() {
        this.mhJ.setNextPage(this.fHm);
        this.fHm.hideEmptyView();
        this.fHm.getView().setPadding(0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds62), 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds362));
        this.fHm.setText(this.mPageContext.getPageActivity().getString(R.string.forum_square_list_has_no_more));
        this.fHm.endLoadData();
    }

    public void dyL() {
        this.mhJ.setNextPage(this.fHm);
        this.fHm.hideEmptyView();
        this.fHm.getView().setPadding(0, 0, 0, 0);
        this.fHm.showLoading();
    }

    private boolean cdE() {
        if (this.fQf != null) {
            return this.fQf.isViewAttached();
        }
        return false;
    }

    public void hideLoadingView() {
        if (this.fQf != null) {
            this.fQf.dettachView(this.mlE);
            this.fQf = null;
        }
    }

    public void gR(boolean z) {
        if (!cdE()) {
            if (this.fQf == null) {
                this.fQf = new g(this.mPageContext.getPageActivity());
                this.fQf.setTopMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds270));
            }
            this.fQf.onChangeSkinType();
            this.fQf.attachView(this.mlE, z);
        }
    }

    public void Ih(int i) {
        this.mhJ.setVisibility(i);
    }

    public void FS(int i) {
        this.mlF.setVisibility(i);
        this.mhJ.setVisibility(i);
    }
}
