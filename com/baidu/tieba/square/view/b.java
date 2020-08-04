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
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.k.g;
import com.baidu.tieba.R;
import com.baidu.tieba.square.a.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class b {
    private BdListView.e UC = new BdListView.e() { // from class: com.baidu.tieba.square.view.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.lGm != null) {
                b.this.lGm.stopScroll();
            }
            if (b.this.lKm != null) {
                b.this.lKm.onScrollToBottom();
            }
        }
    };
    private g fBv;
    private PbListView fsC;
    private BdTypeRecyclerView lGm;
    private RelativeLayout lKg;
    private RecyclerView lKh;
    private LinearLayoutManager lKi;
    private com.baidu.tieba.square.a.a lKj;
    private LinearLayoutManager lKk;
    private com.baidu.tieba.square.a.b lKl;
    private BdListView.e lKm;
    private Activity mActivity;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        initView();
        cZQ();
    }

    private void initView() {
        this.lKg = (RelativeLayout) this.mActivity.findViewById(R.id.right_container);
        this.lKh = (RecyclerView) this.mActivity.findViewById(R.id.rv_left);
        this.lGm = (BdTypeRecyclerView) this.mActivity.findViewById(R.id.rv_right);
    }

    public String dji() {
        return this.lKj.dju();
    }

    public void b(String str, List<String> list, boolean z) {
        int position = x.getPosition(list, str);
        this.lKj.p(position, list);
        if (z) {
            Fg(position);
        }
    }

    public void djj() {
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.ListView.x xVar = new com.baidu.adp.widget.ListView.x();
        xVar.showText = this.mActivity.getString(R.string.forum_square_list_no_data);
        xVar.resId = R.drawable.new_pic_emotion_06;
        arrayList.add(xVar);
        this.lKl.setData(arrayList);
    }

    public void eU(List<q> list) {
        p(list, 0);
    }

    public void p(List<q> list, int i) {
        if (x.isEmpty(list)) {
            djj();
            return;
        }
        if (i > 0) {
            Pair<Integer, Integer> djh = djh();
            int intValue = ((Integer) djh.first).intValue();
            int intValue2 = ((Integer) djh.second).intValue();
            int i2 = intValue - i;
            if (this.lKk != null && this.lGm != null) {
                this.lGm.pn();
                this.lKk.scrollToPositionWithOffset(i2, intValue2);
                this.lGm.po();
            }
        }
        this.lKl.setData(list);
    }

    private void cZQ() {
        this.lKi = new LinearLayoutManager(this.mActivity);
        this.lKh.setLayoutManager(this.lKi);
        this.lKj = new com.baidu.tieba.square.a.a(this.mActivity);
        this.lKh.setAdapter(this.lKj);
        this.lKl = new com.baidu.tieba.square.a.b(this.mPageContext, this.lGm);
        this.lKk = new LinearLayoutManager(this.mActivity);
        this.lGm.setLayoutManager(this.lKk);
        this.lGm.setFadingEdgeLength(0);
        this.lGm.setOverScrollMode(2);
        this.lGm.setOnSrollToBottomListener(this.UC);
        this.fsC = new PbListView(this.mActivity);
        this.fsC.getView();
        this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fsC.setHeight(l.getDimens(this.mActivity, R.dimen.tbds182));
        this.fsC.setLineGone();
        this.fsC.setTextSize(R.dimen.tbfontsize33);
        this.fsC.setTextColor(ao.getColor(R.color.cp_cont_j));
        this.fsC.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fsC.bbZ();
    }

    public void e(BdListView.e eVar) {
        this.lKm = eVar;
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.lGm != null) {
            this.lGm.removeOnScrollListener(onScrollListener);
            this.lGm.addOnScrollListener(onScrollListener);
        }
    }

    public void a(a.InterfaceC0748a interfaceC0748a) {
        if (this.lKj != null) {
            this.lKj.b(interfaceC0748a);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lKl != null) {
            this.lKl.notifyDataSetChanged();
        }
        if (this.lKj != null) {
            this.lKj.notifyDataSetChanged();
        }
        if (this.fsC != null) {
            this.fsC.setTextColor(ao.getColor(R.color.cp_cont_j));
            this.fsC.changeSkin(i);
        }
        if (this.fBv != null) {
            this.fBv.onChangeSkinType();
        }
    }

    public Pair<Integer, Integer> djh() {
        int firstVisiblePosition = this.lGm.getFirstVisiblePosition();
        View childAt = this.lGm.getChildAt(0);
        return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(childAt != null ? childAt.getTop() : 0));
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.lGm != null && (this.lGm.getLayoutManager() instanceof LinearLayoutManager) && i <= this.lGm.getCount() - 1) {
            ((LinearLayoutManager) this.lGm.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    private void Fg(int i) {
        if (this.lKh != null && (this.lKh.getLayoutManager() instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.lKh.getLayoutManager();
            if (i < 0) {
                i = 0;
            } else if (i > this.lKj.getItemCount() - 1) {
                i = this.lKj.getItemCount() - 1;
            }
            linearLayoutManager.scrollToPositionWithOffset(i, 0);
        }
    }

    public void bxU() {
        this.lGm.setNextPage(null);
    }

    public void djo() {
        this.lGm.setNextPage(this.fsC);
        this.fsC.hideEmptyView();
        this.fsC.getView().setPadding(0, 0, 0, 0);
        this.fsC.setText(this.mActivity.getString(R.string.pb_load_more));
        this.fsC.endLoadData();
    }

    public void djp() {
        this.lGm.setNextPage(this.fsC);
        this.fsC.hideEmptyView();
        this.fsC.getView().setPadding(0, l.getDimens(this.mActivity, R.dimen.tbds62), 0, l.getDimens(this.mActivity, R.dimen.tbds362));
        this.fsC.setText(this.mActivity.getString(R.string.forum_square_list_has_no_more));
        this.fsC.endLoadData();
    }

    public void djq() {
        this.lGm.setNextPage(this.fsC);
        this.fsC.hideEmptyView();
        this.fsC.getView().setPadding(0, 0, 0, 0);
        this.fsC.showLoading();
    }

    private boolean bWi() {
        if (this.fBv != null) {
            return this.fBv.isViewAttached();
        }
        return false;
    }

    public void hideLoadingView() {
        if (this.fBv != null) {
            this.fBv.dettachView(this.lKg);
            this.fBv = null;
        }
    }

    public void gw(boolean z) {
        if (!bWi()) {
            if (this.fBv == null) {
                this.fBv = new g(this.mActivity);
                this.fBv.setTopMargin(this.mActivity.getResources().getDimensionPixelSize(R.dimen.ds270));
            }
            this.fBv.onChangeSkinType();
            this.fBv.attachView(this.lKg, z);
        }
    }

    public void Fh(int i) {
        this.lGm.setVisibility(i);
    }

    public void CW(int i) {
        this.lKh.setVisibility(i);
        this.lGm.setVisibility(i);
    }
}
