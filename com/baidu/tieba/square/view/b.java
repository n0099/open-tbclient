package com.baidu.tieba.square.view;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.t;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.k.g;
import com.baidu.tieba.R;
import com.baidu.tieba.square.a.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private BdListView.e TQ = new BdListView.e() { // from class: com.baidu.tieba.square.view.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.kLt != null) {
                b.this.kLt.stopScroll();
            }
            if (b.this.kPx != null) {
                b.this.kPx.onScrollToBottom();
            }
        }
    };
    private PbListView ePm;
    private g eYb;
    private BdTypeRecyclerView kLt;
    private RelativeLayout kPr;
    private RecyclerView kPs;
    private LinearLayoutManager kPt;
    private com.baidu.tieba.square.a.a kPu;
    private LinearLayoutManager kPv;
    private com.baidu.tieba.square.a.b kPw;
    private BdListView.e kPx;
    private Activity mActivity;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        initView();
        cLe();
    }

    private void initView() {
        this.kPr = (RelativeLayout) this.mActivity.findViewById(R.id.right_container);
        this.kPs = (RecyclerView) this.mActivity.findViewById(R.id.rv_left);
        this.kLt = (BdTypeRecyclerView) this.mActivity.findViewById(R.id.rv_right);
    }

    public String cUs() {
        return this.kPu.cUE();
    }

    public void b(String str, List<String> list, boolean z) {
        int position = v.getPosition(list, str);
        this.kPu.p(position, list);
        if (z) {
            CW(position);
        }
    }

    public void cUt() {
        ArrayList arrayList = new ArrayList();
        t tVar = new t();
        tVar.showText = this.mActivity.getString(R.string.forum_square_list_no_data);
        tVar.resId = R.drawable.new_pic_emotion_06;
        arrayList.add(tVar);
        this.kPw.setData(arrayList);
    }

    public void er(List<m> list) {
        o(list, 0);
    }

    public void o(List<m> list, int i) {
        if (v.isEmpty(list)) {
            cUt();
            return;
        }
        if (i > 0) {
            Pair<Integer, Integer> cUr = cUr();
            int intValue = ((Integer) cUr.first).intValue();
            int intValue2 = ((Integer) cUr.second).intValue();
            int i2 = intValue - i;
            if (this.kPv != null && this.kLt != null) {
                this.kLt.oQ();
                this.kPv.scrollToPositionWithOffset(i2, intValue2);
                this.kLt.oR();
            }
        }
        this.kPw.setData(list);
    }

    private void cLe() {
        this.kPt = new LinearLayoutManager(this.mActivity);
        this.kPs.setLayoutManager(this.kPt);
        this.kPu = new com.baidu.tieba.square.a.a(this.mActivity);
        this.kPs.setAdapter(this.kPu);
        this.kPw = new com.baidu.tieba.square.a.b(this.mPageContext, this.kLt);
        this.kPv = new LinearLayoutManager(this.mActivity);
        this.kLt.setLayoutManager(this.kPv);
        this.kLt.setFadingEdgeLength(0);
        this.kLt.setOverScrollMode(2);
        this.kLt.setOnSrollToBottomListener(this.TQ);
        this.ePm = new PbListView(this.mActivity);
        this.ePm.getView();
        this.ePm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ePm.setHeight(l.getDimens(this.mActivity, R.dimen.tbds182));
        this.ePm.setLineGone();
        this.ePm.setTextSize(R.dimen.tbfontsize33);
        this.ePm.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ePm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.ePm.aQd();
    }

    public void e(BdListView.e eVar) {
        this.kPx = eVar;
    }

    public void a(RecyclerView.OnScrollListener onScrollListener) {
        if (this.kLt != null) {
            this.kLt.removeOnScrollListener(onScrollListener);
            this.kLt.addOnScrollListener(onScrollListener);
        }
    }

    public void a(a.InterfaceC0647a interfaceC0647a) {
        if (this.kPu != null) {
            this.kPu.b(interfaceC0647a);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kPw != null) {
            this.kPw.notifyDataSetChanged();
        }
        if (this.kPu != null) {
            this.kPu.notifyDataSetChanged();
        }
        if (this.ePm != null) {
            this.ePm.setTextColor(am.getColor(R.color.cp_cont_j));
            this.ePm.changeSkin(i);
        }
        if (this.eYb != null) {
            this.eYb.onChangeSkinType();
        }
    }

    public Pair<Integer, Integer> cUr() {
        int firstVisiblePosition = this.kLt.getFirstVisiblePosition();
        View childAt = this.kLt.getChildAt(0);
        return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(childAt != null ? childAt.getTop() : 0));
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.kLt != null && (this.kLt.getLayoutManager() instanceof LinearLayoutManager) && i <= this.kLt.getCount() - 1) {
            ((LinearLayoutManager) this.kLt.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    private void CW(int i) {
        if (this.kPs != null && (this.kPs.getLayoutManager() instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.kPs.getLayoutManager();
            if (i < 0) {
                i = 0;
            } else if (i > this.kPu.getItemCount() - 1) {
                i = this.kPu.getItemCount() - 1;
            }
            linearLayoutManager.scrollToPositionWithOffset(i, 0);
        }
    }

    public void bmq() {
        this.kLt.setNextPage(null);
    }

    public void cUy() {
        this.kLt.setNextPage(this.ePm);
        this.ePm.hideEmptyView();
        this.ePm.getView().setPadding(0, 0, 0, 0);
        this.ePm.setText(this.mActivity.getString(R.string.pb_load_more));
        this.ePm.endLoadData();
    }

    public void cUz() {
        this.kLt.setNextPage(this.ePm);
        this.ePm.hideEmptyView();
        this.ePm.getView().setPadding(0, l.getDimens(this.mActivity, R.dimen.tbds62), 0, l.getDimens(this.mActivity, R.dimen.tbds362));
        this.ePm.setText(this.mActivity.getString(R.string.forum_square_list_has_no_more));
        this.ePm.endLoadData();
    }

    public void cUA() {
        this.kLt.setNextPage(this.ePm);
        this.ePm.hideEmptyView();
        this.ePm.getView().setPadding(0, 0, 0, 0);
        this.ePm.showLoading();
    }

    private boolean bJt() {
        if (this.eYb != null) {
            return this.eYb.isViewAttached();
        }
        return false;
    }

    public void hideLoadingView() {
        if (this.eYb != null) {
            this.eYb.dettachView(this.kPr);
            this.eYb = null;
        }
    }

    public void fK(boolean z) {
        if (!bJt()) {
            if (this.eYb == null) {
                this.eYb = new g(this.mActivity);
                this.eYb.setTopMargin(this.mActivity.getResources().getDimensionPixelSize(R.dimen.ds270));
            }
            this.eYb.onChangeSkinType();
            this.eYb.attachView(this.kPr, z);
        }
    }

    public void CX(int i) {
        this.kLt.setVisibility(i);
    }

    public void AH(int i) {
        this.kPs.setVisibility(i);
        this.kLt.setVisibility(i);
    }
}
