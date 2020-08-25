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
/* loaded from: classes16.dex */
public class b {
    private BdListView.e Vh = new BdListView.e() { // from class: com.baidu.tieba.square.view.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.lXS != null) {
                b.this.lXS.stopScroll();
            }
            if (b.this.mbV != null) {
                b.this.mbV.onScrollToBottom();
            }
        }
    };
    private PbListView fDW;
    private g fMN;
    private BdTypeRecyclerView lXS;
    private TbPageContext<?> mPageContext;
    private final View mRoot;
    private RelativeLayout mbP;
    private RecyclerView mbQ;
    private LinearLayoutManager mbR;
    private com.baidu.tieba.square.a.a mbS;
    private LinearLayoutManager mbT;
    private com.baidu.tieba.square.a.b mbU;
    private BdListView.e mbV;

    public b(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRoot = view;
        initView();
        dkU();
    }

    private void initView() {
        this.mbP = (RelativeLayout) this.mRoot.findViewById(R.id.right_container);
        this.mbQ = (RecyclerView) this.mRoot.findViewById(R.id.rv_left);
        this.lXS = (BdTypeRecyclerView) this.mRoot.findViewById(R.id.rv_right);
    }

    public String duF() {
        return this.mbS.duR();
    }

    public void Qq(String str) {
        if (str != null) {
            int Qr = this.mbS.Qr(str);
            this.mbS.Hy(Qr);
            HD(Qr);
        }
    }

    public void c(String str, List<String> list, boolean z) {
        int position = y.getPosition(list, str);
        this.mbS.p(position, list);
        if (z) {
            HD(position);
        }
    }

    public void duG() {
        ArrayList arrayList = new ArrayList();
        z zVar = new z();
        zVar.showText = this.mPageContext.getString(R.string.forum_square_list_no_data);
        zVar.resId = R.drawable.new_pic_emotion_06;
        arrayList.add(zVar);
        this.mbU.setData(arrayList);
    }

    public void fc(List<q> list) {
        s(list, 0);
    }

    public void s(List<q> list, int i) {
        if (y.isEmpty(list)) {
            duG();
            return;
        }
        if (i > 0) {
            Pair<Integer, Integer> duE = duE();
            int intValue = ((Integer) duE.first).intValue();
            int intValue2 = ((Integer) duE.second).intValue();
            int i2 = intValue - i;
            if (this.mbT != null && this.lXS != null) {
                this.lXS.qM();
                this.mbT.scrollToPositionWithOffset(i2, intValue2);
                this.lXS.qN();
            }
        }
        this.mbU.setData(list);
    }

    private void dkU() {
        this.mbR = new LinearLayoutManager(this.mPageContext.getPageActivity());
        this.mbQ.setLayoutManager(this.mbR);
        this.mbS = new com.baidu.tieba.square.a.a(this.mPageContext.getPageActivity());
        this.mbQ.setAdapter(this.mbS);
        this.mbU = new com.baidu.tieba.square.a.b(this.mPageContext, this.lXS);
        this.mbT = new LinearLayoutManager(this.mPageContext.getPageActivity());
        this.lXS.setLayoutManager(this.mbT);
        this.lXS.setFadingEdgeLength(0);
        this.lXS.setOverScrollMode(2);
        this.lXS.setOnSrollToBottomListener(this.Vh);
        this.fDW = new PbListView(this.mPageContext.getPageActivity());
        this.fDW.getView();
        this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fDW.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.fDW.setLineGone();
        this.fDW.setTextSize(R.dimen.tbfontsize33);
        this.fDW.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fDW.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fDW.bkv();
    }

    public void e(BdListView.e eVar) {
        this.mbV = eVar;
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.lXS != null) {
            this.lXS.removeOnScrollListener(onScrollListener);
            this.lXS.addOnScrollListener(onScrollListener);
        }
    }

    public void a(a.InterfaceC0801a interfaceC0801a) {
        if (this.mbS != null) {
            this.mbS.b(interfaceC0801a);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mbU != null) {
            this.mbU.notifyDataSetChanged();
        }
        if (this.mbS != null) {
            this.mbS.notifyDataSetChanged();
        }
        if (this.fDW != null) {
            this.fDW.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fDW.changeSkin(i);
        }
        if (this.fMN != null) {
            this.fMN.onChangeSkinType();
        }
    }

    public Pair<Integer, Integer> duE() {
        int firstVisiblePosition = this.lXS.getFirstVisiblePosition();
        View childAt = this.lXS.getChildAt(0);
        return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(childAt != null ? childAt.getTop() : 0));
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.lXS != null && (this.lXS.getLayoutManager() instanceof LinearLayoutManager) && i <= this.lXS.getCount() - 1) {
            ((LinearLayoutManager) this.lXS.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    private void HD(int i) {
        if (this.mbQ != null && (this.mbQ.getLayoutManager() instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.mbQ.getLayoutManager();
            if (i < 0) {
                i = 0;
            } else if (i > this.mbS.getItemCount() - 1) {
                i = this.mbS.getItemCount() - 1;
            }
            linearLayoutManager.scrollToPositionWithOffset(i, 0);
        }
    }

    public void bGT() {
        this.lXS.setNextPage(null);
    }

    public void duL() {
        this.lXS.setNextPage(this.fDW);
        this.fDW.hideEmptyView();
        this.fDW.getView().setPadding(0, 0, 0, 0);
        this.fDW.setText(this.mPageContext.getPageActivity().getString(R.string.pb_load_more));
        this.fDW.endLoadData();
    }

    public void duM() {
        this.lXS.setNextPage(this.fDW);
        this.fDW.hideEmptyView();
        this.fDW.getView().setPadding(0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds62), 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds362));
        this.fDW.setText(this.mPageContext.getPageActivity().getString(R.string.forum_square_list_has_no_more));
        this.fDW.endLoadData();
    }

    public void duN() {
        this.lXS.setNextPage(this.fDW);
        this.fDW.hideEmptyView();
        this.fDW.getView().setPadding(0, 0, 0, 0);
        this.fDW.showLoading();
    }

    private boolean cgv() {
        if (this.fMN != null) {
            return this.fMN.isViewAttached();
        }
        return false;
    }

    public void hideLoadingView() {
        if (this.fMN != null) {
            this.fMN.dettachView(this.mbP);
            this.fMN = null;
        }
    }

    public void gS(boolean z) {
        if (!cgv()) {
            if (this.fMN == null) {
                this.fMN = new g(this.mPageContext.getPageActivity());
                this.fMN.setTopMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds270));
            }
            this.fMN.onChangeSkinType();
            this.fMN.attachView(this.mbP, z);
        }
    }

    public void HE(int i) {
        this.lXS.setVisibility(i);
    }

    public void Fr(int i) {
        this.mbQ.setVisibility(i);
        this.lXS.setVisibility(i);
    }
}
