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
import com.baidu.adp.widget.ListView.o;
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
    private BdListView.e Uf = new BdListView.e() { // from class: com.baidu.tieba.square.view.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.leX != null) {
                b.this.leX.stopScroll();
            }
            if (b.this.lja != null) {
                b.this.lja.onScrollToBottom();
            }
        }
    };
    private PbListView fcj;
    private g flb;
    private BdTypeRecyclerView leX;
    private RelativeLayout liU;
    private RecyclerView liV;
    private LinearLayoutManager liW;
    private com.baidu.tieba.square.a.a liX;
    private LinearLayoutManager liY;
    private com.baidu.tieba.square.a.b liZ;
    private BdListView.e lja;
    private Activity mActivity;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        initView();
        cSs();
    }

    private void initView() {
        this.liU = (RelativeLayout) this.mActivity.findViewById(R.id.right_container);
        this.liV = (RecyclerView) this.mActivity.findViewById(R.id.rv_left);
        this.leX = (BdTypeRecyclerView) this.mActivity.findViewById(R.id.rv_right);
    }

    public String dbJ() {
        return this.liX.dbV();
    }

    public void b(String str, List<String> list, boolean z) {
        int position = v.getPosition(list, str);
        this.liX.p(position, list);
        if (z) {
            DI(position);
        }
    }

    public void dbK() {
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.ListView.v vVar = new com.baidu.adp.widget.ListView.v();
        vVar.showText = this.mActivity.getString(R.string.forum_square_list_no_data);
        vVar.resId = R.drawable.new_pic_emotion_06;
        arrayList.add(vVar);
        this.liZ.setData(arrayList);
    }

    public void eA(List<o> list) {
        q(list, 0);
    }

    public void q(List<o> list, int i) {
        if (v.isEmpty(list)) {
            dbK();
            return;
        }
        if (i > 0) {
            Pair<Integer, Integer> dbI = dbI();
            int intValue = ((Integer) dbI.first).intValue();
            int intValue2 = ((Integer) dbI.second).intValue();
            int i2 = intValue - i;
            if (this.liY != null && this.leX != null) {
                this.leX.oV();
                this.liY.scrollToPositionWithOffset(i2, intValue2);
                this.leX.oW();
            }
        }
        this.liZ.setData(list);
    }

    private void cSs() {
        this.liW = new LinearLayoutManager(this.mActivity);
        this.liV.setLayoutManager(this.liW);
        this.liX = new com.baidu.tieba.square.a.a(this.mActivity);
        this.liV.setAdapter(this.liX);
        this.liZ = new com.baidu.tieba.square.a.b(this.mPageContext, this.leX);
        this.liY = new LinearLayoutManager(this.mActivity);
        this.leX.setLayoutManager(this.liY);
        this.leX.setFadingEdgeLength(0);
        this.leX.setOverScrollMode(2);
        this.leX.setOnSrollToBottomListener(this.Uf);
        this.fcj = new PbListView(this.mActivity);
        this.fcj.getView();
        this.fcj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fcj.setHeight(l.getDimens(this.mActivity, R.dimen.tbds182));
        this.fcj.setLineGone();
        this.fcj.setTextSize(R.dimen.tbfontsize33);
        this.fcj.setTextColor(am.getColor(R.color.cp_cont_j));
        this.fcj.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fcj.aWf();
    }

    public void e(BdListView.e eVar) {
        this.lja = eVar;
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.leX != null) {
            this.leX.removeOnScrollListener(onScrollListener);
            this.leX.addOnScrollListener(onScrollListener);
        }
    }

    public void a(a.InterfaceC0722a interfaceC0722a) {
        if (this.liX != null) {
            this.liX.b(interfaceC0722a);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.liZ != null) {
            this.liZ.notifyDataSetChanged();
        }
        if (this.liX != null) {
            this.liX.notifyDataSetChanged();
        }
        if (this.fcj != null) {
            this.fcj.setTextColor(am.getColor(R.color.cp_cont_j));
            this.fcj.changeSkin(i);
        }
        if (this.flb != null) {
            this.flb.onChangeSkinType();
        }
    }

    public Pair<Integer, Integer> dbI() {
        int firstVisiblePosition = this.leX.getFirstVisiblePosition();
        View childAt = this.leX.getChildAt(0);
        return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(childAt != null ? childAt.getTop() : 0));
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.leX != null && (this.leX.getLayoutManager() instanceof LinearLayoutManager) && i <= this.leX.getCount() - 1) {
            ((LinearLayoutManager) this.leX.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    private void DI(int i) {
        if (this.liV != null && (this.liV.getLayoutManager() instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.liV.getLayoutManager();
            if (i < 0) {
                i = 0;
            } else if (i > this.liX.getItemCount() - 1) {
                i = this.liX.getItemCount() - 1;
            }
            linearLayoutManager.scrollToPositionWithOffset(i, 0);
        }
    }

    public void brO() {
        this.leX.setNextPage(null);
    }

    public void dbP() {
        this.leX.setNextPage(this.fcj);
        this.fcj.hideEmptyView();
        this.fcj.getView().setPadding(0, 0, 0, 0);
        this.fcj.setText(this.mActivity.getString(R.string.pb_load_more));
        this.fcj.endLoadData();
    }

    public void dbQ() {
        this.leX.setNextPage(this.fcj);
        this.fcj.hideEmptyView();
        this.fcj.getView().setPadding(0, l.getDimens(this.mActivity, R.dimen.tbds62), 0, l.getDimens(this.mActivity, R.dimen.tbds362));
        this.fcj.setText(this.mActivity.getString(R.string.forum_square_list_has_no_more));
        this.fcj.endLoadData();
    }

    public void dbR() {
        this.leX.setNextPage(this.fcj);
        this.fcj.hideEmptyView();
        this.fcj.getView().setPadding(0, 0, 0, 0);
        this.fcj.showLoading();
    }

    private boolean bPN() {
        if (this.flb != null) {
            return this.flb.isViewAttached();
        }
        return false;
    }

    public void hideLoadingView() {
        if (this.flb != null) {
            this.flb.dettachView(this.liU);
            this.flb = null;
        }
    }

    public void fV(boolean z) {
        if (!bPN()) {
            if (this.flb == null) {
                this.flb = new g(this.mActivity);
                this.flb.setTopMargin(this.mActivity.getResources().getDimensionPixelSize(R.dimen.ds270));
            }
            this.flb.onChangeSkinType();
            this.flb.attachView(this.liU, z);
        }
    }

    public void DJ(int i) {
        this.leX.setVisibility(i);
    }

    public void Bu(int i) {
        this.liV.setVisibility(i);
        this.leX.setVisibility(i);
    }
}
