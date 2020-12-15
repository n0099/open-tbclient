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
            if (b.this.neT != null) {
                b.this.neT.stopScroll();
            }
            if (b.this.niT != null) {
                b.this.niT.onScrollToBottom();
            }
        }
    };
    private g gAg;
    private PbListView grg;
    private TbPageContext<?> mPageContext;
    private final View mRoot;
    private BdTypeRecyclerView neT;
    private RelativeLayout niN;
    private RecyclerView niO;
    private LinearLayoutManager niP;
    private com.baidu.tieba.square.a.a niQ;
    private LinearLayoutManager niR;
    private com.baidu.tieba.square.a.b niS;
    private BdListView.e niT;

    public b(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRoot = view;
        initView();
        dCQ();
    }

    private void initView() {
        this.niN = (RelativeLayout) this.mRoot.findViewById(R.id.right_container);
        this.niO = (RecyclerView) this.mRoot.findViewById(R.id.rv_left);
        this.neT = (BdTypeRecyclerView) this.mRoot.findViewById(R.id.rv_right);
    }

    public String dNg() {
        return this.niQ.dNs();
    }

    public void Tj(String str) {
        if (str != null) {
            int Tk = this.niQ.Tk(str);
            this.niQ.vT(Tk);
            KJ(Tk);
        }
    }

    public void c(String str, List<String> list, boolean z) {
        int position = y.getPosition(list, str);
        this.niQ.p(position, list);
        if (z) {
            KJ(position);
        }
    }

    public void dNh() {
        ArrayList arrayList = new ArrayList();
        z zVar = new z();
        zVar.showText = this.mPageContext.getString(R.string.forum_square_list_no_data);
        zVar.resId = R.drawable.new_pic_emotion_06;
        arrayList.add(zVar);
        this.niS.setData(arrayList);
    }

    public void fT(List<q> list) {
        v(list, 0);
    }

    public void v(List<q> list, int i) {
        if (y.isEmpty(list)) {
            dNh();
            return;
        }
        if (i > 0) {
            Pair<Integer, Integer> dNf = dNf();
            int intValue = ((Integer) dNf.first).intValue();
            int intValue2 = ((Integer) dNf.second).intValue();
            int i2 = intValue - i;
            if (this.niR != null && this.neT != null) {
                this.neT.qT();
                this.niR.scrollToPositionWithOffset(i2, intValue2);
                this.neT.qU();
            }
        }
        this.niS.setData(list);
    }

    private void dCQ() {
        this.niP = new LinearLayoutManager(this.mPageContext.getPageActivity());
        this.niO.setLayoutManager(this.niP);
        this.niQ = new com.baidu.tieba.square.a.a(this.mPageContext.getPageActivity());
        this.niO.setAdapter(this.niQ);
        this.niS = new com.baidu.tieba.square.a.b(this.mPageContext, this.neT);
        this.niR = new LinearLayoutManager(this.mPageContext.getPageActivity());
        this.neT.setLayoutManager(this.niR);
        this.neT.setFadingEdgeLength(0);
        this.neT.setOverScrollMode(2);
        this.neT.setOnSrollToBottomListener(this.WQ);
        this.grg = new PbListView(this.mPageContext.getPageActivity());
        this.grg.getView();
        this.grg.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.grg.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.grg.setLineGone();
        this.grg.setTextSize(R.dimen.tbfontsize33);
        this.grg.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.grg.setNoMoreTextColorId(R.color.CAM_X0110);
        this.grg.bvh();
    }

    public void e(BdListView.e eVar) {
        this.niT = eVar;
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.neT != null) {
            this.neT.removeOnScrollListener(onScrollListener);
            this.neT.addOnScrollListener(onScrollListener);
        }
    }

    public void a(a.InterfaceC0864a interfaceC0864a) {
        if (this.niQ != null) {
            this.niQ.b(interfaceC0864a);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.niS != null) {
            this.niS.notifyDataSetChanged();
        }
        if (this.niQ != null) {
            this.niQ.notifyDataSetChanged();
        }
        if (this.grg != null) {
            this.grg.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.grg.changeSkin(i);
        }
        if (this.gAg != null) {
            this.gAg.onChangeSkinType();
        }
    }

    public Pair<Integer, Integer> dNf() {
        int firstVisiblePosition = this.neT.getFirstVisiblePosition();
        View childAt = this.neT.getChildAt(0);
        return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(childAt != null ? childAt.getTop() : 0));
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.neT != null && (this.neT.getLayoutManager() instanceof LinearLayoutManager) && i <= this.neT.getCount() - 1) {
            ((LinearLayoutManager) this.neT.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    private void KJ(int i) {
        if (this.niO != null && (this.niO.getLayoutManager() instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.niO.getLayoutManager();
            if (i < 0) {
                i = 0;
            } else if (i > this.niQ.getItemCount() - 1) {
                i = this.niQ.getItemCount() - 1;
            }
            linearLayoutManager.scrollToPositionWithOffset(i, 0);
        }
    }

    public void bTb() {
        this.neT.setNextPage(null);
    }

    public void dNm() {
        this.neT.setNextPage(this.grg);
        this.grg.hideEmptyView();
        this.grg.getView().setPadding(0, 0, 0, 0);
        this.grg.setText(this.mPageContext.getPageActivity().getString(R.string.pb_load_more));
        this.grg.endLoadData();
    }

    public void dNn() {
        this.neT.setNextPage(this.grg);
        this.grg.hideEmptyView();
        this.grg.getView().setPadding(0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds62), 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds362));
        this.grg.setText(this.mPageContext.getPageActivity().getString(R.string.forum_square_list_has_no_more));
        this.grg.endLoadData();
    }

    public void dNo() {
        this.neT.setNextPage(this.grg);
        this.grg.hideEmptyView();
        this.grg.getView().setPadding(0, 0, 0, 0);
        this.grg.showLoading();
    }

    private boolean cqz() {
        if (this.gAg != null) {
            return this.gAg.isViewAttached();
        }
        return false;
    }

    public void hideLoadingView() {
        if (this.gAg != null) {
            this.gAg.dettachView(this.niN);
            this.gAg = null;
        }
    }

    public void ib(boolean z) {
        if (!cqz()) {
            if (this.gAg == null) {
                this.gAg = new g(this.mPageContext.getPageActivity());
                this.gAg.setTopMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds270));
            }
            this.gAg.onChangeSkinType();
            this.gAg.attachView(this.niN, z);
        }
    }

    public void KK(int i) {
        this.neT.setVisibility(i);
    }

    public void It(int i) {
        this.niO.setVisibility(i);
        this.neT.setVisibility(i);
    }
}
