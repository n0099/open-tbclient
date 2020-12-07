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
import com.baidu.tbadk.l.g;
import com.baidu.tieba.R;
import com.baidu.tieba.square.a.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class b {
    private BdListView.e WQ = new BdListView.e() { // from class: com.baidu.tieba.square.view.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.neR != null) {
                b.this.neR.stopScroll();
            }
            if (b.this.niR != null) {
                b.this.niR.onScrollToBottom();
            }
        }
    };
    private g gAe;
    private PbListView gre;
    private TbPageContext<?> mPageContext;
    private final View mRoot;
    private BdTypeRecyclerView neR;
    private RelativeLayout niL;
    private RecyclerView niM;
    private LinearLayoutManager niN;
    private com.baidu.tieba.square.a.a niO;
    private LinearLayoutManager niP;
    private com.baidu.tieba.square.a.b niQ;
    private BdListView.e niR;

    public b(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRoot = view;
        initView();
        dCP();
    }

    private void initView() {
        this.niL = (RelativeLayout) this.mRoot.findViewById(R.id.right_container);
        this.niM = (RecyclerView) this.mRoot.findViewById(R.id.rv_left);
        this.neR = (BdTypeRecyclerView) this.mRoot.findViewById(R.id.rv_right);
    }

    public String dNf() {
        return this.niO.dNr();
    }

    public void Tj(String str) {
        if (str != null) {
            int Tk = this.niO.Tk(str);
            this.niO.vT(Tk);
            KJ(Tk);
        }
    }

    public void c(String str, List<String> list, boolean z) {
        int position = y.getPosition(list, str);
        this.niO.p(position, list);
        if (z) {
            KJ(position);
        }
    }

    public void dNg() {
        ArrayList arrayList = new ArrayList();
        z zVar = new z();
        zVar.showText = this.mPageContext.getString(R.string.forum_square_list_no_data);
        zVar.resId = R.drawable.new_pic_emotion_06;
        arrayList.add(zVar);
        this.niQ.setData(arrayList);
    }

    public void fT(List<q> list) {
        v(list, 0);
    }

    public void v(List<q> list, int i) {
        if (y.isEmpty(list)) {
            dNg();
            return;
        }
        if (i > 0) {
            Pair<Integer, Integer> dNe = dNe();
            int intValue = ((Integer) dNe.first).intValue();
            int intValue2 = ((Integer) dNe.second).intValue();
            int i2 = intValue - i;
            if (this.niP != null && this.neR != null) {
                this.neR.qT();
                this.niP.scrollToPositionWithOffset(i2, intValue2);
                this.neR.qU();
            }
        }
        this.niQ.setData(list);
    }

    private void dCP() {
        this.niN = new LinearLayoutManager(this.mPageContext.getPageActivity());
        this.niM.setLayoutManager(this.niN);
        this.niO = new com.baidu.tieba.square.a.a(this.mPageContext.getPageActivity());
        this.niM.setAdapter(this.niO);
        this.niQ = new com.baidu.tieba.square.a.b(this.mPageContext, this.neR);
        this.niP = new LinearLayoutManager(this.mPageContext.getPageActivity());
        this.neR.setLayoutManager(this.niP);
        this.neR.setFadingEdgeLength(0);
        this.neR.setOverScrollMode(2);
        this.neR.setOnSrollToBottomListener(this.WQ);
        this.gre = new PbListView(this.mPageContext.getPageActivity());
        this.gre.getView();
        this.gre.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gre.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.gre.setLineGone();
        this.gre.setTextSize(R.dimen.tbfontsize33);
        this.gre.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gre.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gre.bvh();
    }

    public void e(BdListView.e eVar) {
        this.niR = eVar;
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.neR != null) {
            this.neR.removeOnScrollListener(onScrollListener);
            this.neR.addOnScrollListener(onScrollListener);
        }
    }

    public void a(a.InterfaceC0864a interfaceC0864a) {
        if (this.niO != null) {
            this.niO.b(interfaceC0864a);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.niQ != null) {
            this.niQ.notifyDataSetChanged();
        }
        if (this.niO != null) {
            this.niO.notifyDataSetChanged();
        }
        if (this.gre != null) {
            this.gre.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gre.changeSkin(i);
        }
        if (this.gAe != null) {
            this.gAe.onChangeSkinType();
        }
    }

    public Pair<Integer, Integer> dNe() {
        int firstVisiblePosition = this.neR.getFirstVisiblePosition();
        View childAt = this.neR.getChildAt(0);
        return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(childAt != null ? childAt.getTop() : 0));
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.neR != null && (this.neR.getLayoutManager() instanceof LinearLayoutManager) && i <= this.neR.getCount() - 1) {
            ((LinearLayoutManager) this.neR.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    private void KJ(int i) {
        if (this.niM != null && (this.niM.getLayoutManager() instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.niM.getLayoutManager();
            if (i < 0) {
                i = 0;
            } else if (i > this.niO.getItemCount() - 1) {
                i = this.niO.getItemCount() - 1;
            }
            linearLayoutManager.scrollToPositionWithOffset(i, 0);
        }
    }

    public void bTa() {
        this.neR.setNextPage(null);
    }

    public void dNl() {
        this.neR.setNextPage(this.gre);
        this.gre.hideEmptyView();
        this.gre.getView().setPadding(0, 0, 0, 0);
        this.gre.setText(this.mPageContext.getPageActivity().getString(R.string.pb_load_more));
        this.gre.endLoadData();
    }

    public void dNm() {
        this.neR.setNextPage(this.gre);
        this.gre.hideEmptyView();
        this.gre.getView().setPadding(0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds62), 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds362));
        this.gre.setText(this.mPageContext.getPageActivity().getString(R.string.forum_square_list_has_no_more));
        this.gre.endLoadData();
    }

    public void dNn() {
        this.neR.setNextPage(this.gre);
        this.gre.hideEmptyView();
        this.gre.getView().setPadding(0, 0, 0, 0);
        this.gre.showLoading();
    }

    private boolean cqy() {
        if (this.gAe != null) {
            return this.gAe.isViewAttached();
        }
        return false;
    }

    public void hideLoadingView() {
        if (this.gAe != null) {
            this.gAe.dettachView(this.niL);
            this.gAe = null;
        }
    }

    public void ib(boolean z) {
        if (!cqy()) {
            if (this.gAe == null) {
                this.gAe = new g(this.mPageContext.getPageActivity());
                this.gAe.setTopMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds270));
            }
            this.gAe.onChangeSkinType();
            this.gAe.attachView(this.niL, z);
        }
    }

    public void KK(int i) {
        this.neR.setVisibility(i);
    }

    public void It(int i) {
        this.niM.setVisibility(i);
        this.neR.setVisibility(i);
    }
}
