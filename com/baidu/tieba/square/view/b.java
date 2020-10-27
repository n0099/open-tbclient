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
/* loaded from: classes22.dex */
public class b {
    private BdListView.e VR = new BdListView.e() { // from class: com.baidu.tieba.square.view.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.mJW != null) {
                b.this.mJW.stopScroll();
            }
            if (b.this.mNV != null) {
                b.this.mNV.onScrollToBottom();
            }
        }
    };
    private PbListView gdy;
    private g gmB;
    private BdTypeRecyclerView mJW;
    private RelativeLayout mNP;
    private RecyclerView mNQ;
    private LinearLayoutManager mNR;
    private com.baidu.tieba.square.a.a mNS;
    private LinearLayoutManager mNT;
    private com.baidu.tieba.square.a.b mNU;
    private BdListView.e mNV;
    private TbPageContext<?> mPageContext;
    private final View mRoot;

    public b(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRoot = view;
        initView();
        dvw();
    }

    private void initView() {
        this.mNP = (RelativeLayout) this.mRoot.findViewById(R.id.right_container);
        this.mNQ = (RecyclerView) this.mRoot.findViewById(R.id.rv_left);
        this.mJW = (BdTypeRecyclerView) this.mRoot.findViewById(R.id.rv_right);
    }

    public String dFw() {
        return this.mNS.dFI();
    }

    public void Sd(String str) {
        if (str != null) {
            int Se = this.mNS.Se(str);
            this.mNS.uE(Se);
            Je(Se);
        }
    }

    public void c(String str, List<String> list, boolean z) {
        int position = y.getPosition(list, str);
        this.mNS.p(position, list);
        if (z) {
            Je(position);
        }
    }

    public void dFx() {
        ArrayList arrayList = new ArrayList();
        z zVar = new z();
        zVar.showText = this.mPageContext.getString(R.string.forum_square_list_no_data);
        zVar.resId = R.drawable.new_pic_emotion_06;
        arrayList.add(zVar);
        this.mNU.setData(arrayList);
    }

    public void fx(List<q> list) {
        v(list, 0);
    }

    public void v(List<q> list, int i) {
        if (y.isEmpty(list)) {
            dFx();
            return;
        }
        if (i > 0) {
            Pair<Integer, Integer> dFv = dFv();
            int intValue = ((Integer) dFv.first).intValue();
            int intValue2 = ((Integer) dFv.second).intValue();
            int i2 = intValue - i;
            if (this.mNT != null && this.mJW != null) {
                this.mJW.qR();
                this.mNT.scrollToPositionWithOffset(i2, intValue2);
                this.mJW.qS();
            }
        }
        this.mNU.setData(list);
    }

    private void dvw() {
        this.mNR = new LinearLayoutManager(this.mPageContext.getPageActivity());
        this.mNQ.setLayoutManager(this.mNR);
        this.mNS = new com.baidu.tieba.square.a.a(this.mPageContext.getPageActivity());
        this.mNQ.setAdapter(this.mNS);
        this.mNU = new com.baidu.tieba.square.a.b(this.mPageContext, this.mJW);
        this.mNT = new LinearLayoutManager(this.mPageContext.getPageActivity());
        this.mJW.setLayoutManager(this.mNT);
        this.mJW.setFadingEdgeLength(0);
        this.mJW.setOverScrollMode(2);
        this.mJW.setOnSrollToBottomListener(this.VR);
        this.gdy = new PbListView(this.mPageContext.getPageActivity());
        this.gdy.getView();
        this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gdy.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.gdy.setLineGone();
        this.gdy.setTextSize(R.dimen.tbfontsize33);
        this.gdy.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.gdy.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gdy.bpT();
    }

    public void e(BdListView.e eVar) {
        this.mNV = eVar;
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.mJW != null) {
            this.mJW.removeOnScrollListener(onScrollListener);
            this.mJW.addOnScrollListener(onScrollListener);
        }
    }

    public void a(a.InterfaceC0831a interfaceC0831a) {
        if (this.mNS != null) {
            this.mNS.b(interfaceC0831a);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNU != null) {
            this.mNU.notifyDataSetChanged();
        }
        if (this.mNS != null) {
            this.mNS.notifyDataSetChanged();
        }
        if (this.gdy != null) {
            this.gdy.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.gdy.changeSkin(i);
        }
        if (this.gmB != null) {
            this.gmB.onChangeSkinType();
        }
    }

    public Pair<Integer, Integer> dFv() {
        int firstVisiblePosition = this.mJW.getFirstVisiblePosition();
        View childAt = this.mJW.getChildAt(0);
        return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(childAt != null ? childAt.getTop() : 0));
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.mJW != null && (this.mJW.getLayoutManager() instanceof LinearLayoutManager) && i <= this.mJW.getCount() - 1) {
            ((LinearLayoutManager) this.mJW.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    private void Je(int i) {
        if (this.mNQ != null && (this.mNQ.getLayoutManager() instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.mNQ.getLayoutManager();
            if (i < 0) {
                i = 0;
            } else if (i > this.mNS.getItemCount() - 1) {
                i = this.mNS.getItemCount() - 1;
            }
            linearLayoutManager.scrollToPositionWithOffset(i, 0);
        }
    }

    public void bNw() {
        this.mJW.setNextPage(null);
    }

    public void dFC() {
        this.mJW.setNextPage(this.gdy);
        this.gdy.hideEmptyView();
        this.gdy.getView().setPadding(0, 0, 0, 0);
        this.gdy.setText(this.mPageContext.getPageActivity().getString(R.string.pb_load_more));
        this.gdy.endLoadData();
    }

    public void dFD() {
        this.mJW.setNextPage(this.gdy);
        this.gdy.hideEmptyView();
        this.gdy.getView().setPadding(0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds62), 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds362));
        this.gdy.setText(this.mPageContext.getPageActivity().getString(R.string.forum_square_list_has_no_more));
        this.gdy.endLoadData();
    }

    public void dFE() {
        this.mJW.setNextPage(this.gdy);
        this.gdy.hideEmptyView();
        this.gdy.getView().setPadding(0, 0, 0, 0);
        this.gdy.showLoading();
    }

    private boolean ckh() {
        if (this.gmB != null) {
            return this.gmB.isViewAttached();
        }
        return false;
    }

    public void hideLoadingView() {
        if (this.gmB != null) {
            this.gmB.dettachView(this.mNP);
            this.gmB = null;
        }
    }

    public void hA(boolean z) {
        if (!ckh()) {
            if (this.gmB == null) {
                this.gmB = new g(this.mPageContext.getPageActivity());
                this.gmB.setTopMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds270));
            }
            this.gmB.onChangeSkinType();
            this.gmB.attachView(this.mNP, z);
        }
    }

    public void Jf(int i) {
        this.mJW.setVisibility(i);
    }

    public void GR(int i) {
        this.mNQ.setVisibility(i);
        this.mJW.setVisibility(i);
    }
}
