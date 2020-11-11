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
            if (b.this.mPT != null) {
                b.this.mPT.stopScroll();
            }
            if (b.this.mTY != null) {
                b.this.mTY.onScrollToBottom();
            }
        }
    };
    private PbListView gjo;
    private g gso;
    private BdTypeRecyclerView mPT;
    private TbPageContext<?> mPageContext;
    private final View mRoot;
    private RelativeLayout mTS;
    private RecyclerView mTT;
    private LinearLayoutManager mTU;
    private com.baidu.tieba.square.a.a mTV;
    private LinearLayoutManager mTW;
    private com.baidu.tieba.square.a.b mTX;
    private BdListView.e mTY;

    public b(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRoot = view;
        initView();
        dxY();
    }

    private void initView() {
        this.mTS = (RelativeLayout) this.mRoot.findViewById(R.id.right_container);
        this.mTT = (RecyclerView) this.mRoot.findViewById(R.id.rv_left);
        this.mPT = (BdTypeRecyclerView) this.mRoot.findViewById(R.id.rv_right);
    }

    public String dHY() {
        return this.mTV.dIk();
    }

    public void Su(String str) {
        if (str != null) {
            int Sv = this.mTV.Sv(str);
            this.mTV.uO(Sv);
            Jr(Sv);
        }
    }

    public void c(String str, List<String> list, boolean z) {
        int position = y.getPosition(list, str);
        this.mTV.p(position, list);
        if (z) {
            Jr(position);
        }
    }

    public void dHZ() {
        ArrayList arrayList = new ArrayList();
        z zVar = new z();
        zVar.showText = this.mPageContext.getString(R.string.forum_square_list_no_data);
        zVar.resId = R.drawable.new_pic_emotion_06;
        arrayList.add(zVar);
        this.mTX.setData(arrayList);
    }

    public void fF(List<q> list) {
        v(list, 0);
    }

    public void v(List<q> list, int i) {
        if (y.isEmpty(list)) {
            dHZ();
            return;
        }
        if (i > 0) {
            Pair<Integer, Integer> dHX = dHX();
            int intValue = ((Integer) dHX.first).intValue();
            int intValue2 = ((Integer) dHX.second).intValue();
            int i2 = intValue - i;
            if (this.mTW != null && this.mPT != null) {
                this.mPT.qR();
                this.mTW.scrollToPositionWithOffset(i2, intValue2);
                this.mPT.qS();
            }
        }
        this.mTX.setData(list);
    }

    private void dxY() {
        this.mTU = new LinearLayoutManager(this.mPageContext.getPageActivity());
        this.mTT.setLayoutManager(this.mTU);
        this.mTV = new com.baidu.tieba.square.a.a(this.mPageContext.getPageActivity());
        this.mTT.setAdapter(this.mTV);
        this.mTX = new com.baidu.tieba.square.a.b(this.mPageContext, this.mPT);
        this.mTW = new LinearLayoutManager(this.mPageContext.getPageActivity());
        this.mPT.setLayoutManager(this.mTW);
        this.mPT.setFadingEdgeLength(0);
        this.mPT.setOverScrollMode(2);
        this.mPT.setOnSrollToBottomListener(this.VR);
        this.gjo = new PbListView(this.mPageContext.getPageActivity());
        this.gjo.getView();
        this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gjo.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.gjo.setLineGone();
        this.gjo.setTextSize(R.dimen.tbfontsize33);
        this.gjo.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.gjo.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gjo.bst();
    }

    public void e(BdListView.e eVar) {
        this.mTY = eVar;
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.mPT != null) {
            this.mPT.removeOnScrollListener(onScrollListener);
            this.mPT.addOnScrollListener(onScrollListener);
        }
    }

    public void a(a.InterfaceC0846a interfaceC0846a) {
        if (this.mTV != null) {
            this.mTV.b(interfaceC0846a);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mTX != null) {
            this.mTX.notifyDataSetChanged();
        }
        if (this.mTV != null) {
            this.mTV.notifyDataSetChanged();
        }
        if (this.gjo != null) {
            this.gjo.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.gjo.changeSkin(i);
        }
        if (this.gso != null) {
            this.gso.onChangeSkinType();
        }
    }

    public Pair<Integer, Integer> dHX() {
        int firstVisiblePosition = this.mPT.getFirstVisiblePosition();
        View childAt = this.mPT.getChildAt(0);
        return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(childAt != null ? childAt.getTop() : 0));
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.mPT != null && (this.mPT.getLayoutManager() instanceof LinearLayoutManager) && i <= this.mPT.getCount() - 1) {
            ((LinearLayoutManager) this.mPT.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    private void Jr(int i) {
        if (this.mTT != null && (this.mTT.getLayoutManager() instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.mTT.getLayoutManager();
            if (i < 0) {
                i = 0;
            } else if (i > this.mTV.getItemCount() - 1) {
                i = this.mTV.getItemCount() - 1;
            }
            linearLayoutManager.scrollToPositionWithOffset(i, 0);
        }
    }

    public void bPW() {
        this.mPT.setNextPage(null);
    }

    public void dIe() {
        this.mPT.setNextPage(this.gjo);
        this.gjo.hideEmptyView();
        this.gjo.getView().setPadding(0, 0, 0, 0);
        this.gjo.setText(this.mPageContext.getPageActivity().getString(R.string.pb_load_more));
        this.gjo.endLoadData();
    }

    public void dIf() {
        this.mPT.setNextPage(this.gjo);
        this.gjo.hideEmptyView();
        this.gjo.getView().setPadding(0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds62), 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds362));
        this.gjo.setText(this.mPageContext.getPageActivity().getString(R.string.forum_square_list_has_no_more));
        this.gjo.endLoadData();
    }

    public void dIg() {
        this.mPT.setNextPage(this.gjo);
        this.gjo.hideEmptyView();
        this.gjo.getView().setPadding(0, 0, 0, 0);
        this.gjo.showLoading();
    }

    private boolean cmJ() {
        if (this.gso != null) {
            return this.gso.isViewAttached();
        }
        return false;
    }

    public void hideLoadingView() {
        if (this.gso != null) {
            this.gso.dettachView(this.mTS);
            this.gso = null;
        }
    }

    public void hJ(boolean z) {
        if (!cmJ()) {
            if (this.gso == null) {
                this.gso = new g(this.mPageContext.getPageActivity());
                this.gso.setTopMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds270));
            }
            this.gso.onChangeSkinType();
            this.gso.attachView(this.mTS, z);
        }
    }

    public void Js(int i) {
        this.mPT.setVisibility(i);
    }

    public void He(int i) {
        this.mTT.setVisibility(i);
        this.mPT.setVisibility(i);
    }
}
