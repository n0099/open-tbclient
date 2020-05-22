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
            if (b.this.ldN != null) {
                b.this.ldN.stopScroll();
            }
            if (b.this.lhR != null) {
                b.this.lhR.onScrollToBottom();
            }
        }
    };
    private PbListView fbY;
    private g fkQ;
    private BdTypeRecyclerView ldN;
    private RelativeLayout lhL;
    private RecyclerView lhM;
    private LinearLayoutManager lhN;
    private com.baidu.tieba.square.a.a lhO;
    private LinearLayoutManager lhP;
    private com.baidu.tieba.square.a.b lhQ;
    private BdListView.e lhR;
    private Activity mActivity;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        initView();
        cSc();
    }

    private void initView() {
        this.lhL = (RelativeLayout) this.mActivity.findViewById(R.id.right_container);
        this.lhM = (RecyclerView) this.mActivity.findViewById(R.id.rv_left);
        this.ldN = (BdTypeRecyclerView) this.mActivity.findViewById(R.id.rv_right);
    }

    public String dbu() {
        return this.lhO.dbG();
    }

    public void b(String str, List<String> list, boolean z) {
        int position = v.getPosition(list, str);
        this.lhO.p(position, list);
        if (z) {
            DG(position);
        }
    }

    public void dbv() {
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.ListView.v vVar = new com.baidu.adp.widget.ListView.v();
        vVar.showText = this.mActivity.getString(R.string.forum_square_list_no_data);
        vVar.resId = R.drawable.new_pic_emotion_06;
        arrayList.add(vVar);
        this.lhQ.setData(arrayList);
    }

    public void ey(List<o> list) {
        q(list, 0);
    }

    public void q(List<o> list, int i) {
        if (v.isEmpty(list)) {
            dbv();
            return;
        }
        if (i > 0) {
            Pair<Integer, Integer> dbt = dbt();
            int intValue = ((Integer) dbt.first).intValue();
            int intValue2 = ((Integer) dbt.second).intValue();
            int i2 = intValue - i;
            if (this.lhP != null && this.ldN != null) {
                this.ldN.oV();
                this.lhP.scrollToPositionWithOffset(i2, intValue2);
                this.ldN.oW();
            }
        }
        this.lhQ.setData(list);
    }

    private void cSc() {
        this.lhN = new LinearLayoutManager(this.mActivity);
        this.lhM.setLayoutManager(this.lhN);
        this.lhO = new com.baidu.tieba.square.a.a(this.mActivity);
        this.lhM.setAdapter(this.lhO);
        this.lhQ = new com.baidu.tieba.square.a.b(this.mPageContext, this.ldN);
        this.lhP = new LinearLayoutManager(this.mActivity);
        this.ldN.setLayoutManager(this.lhP);
        this.ldN.setFadingEdgeLength(0);
        this.ldN.setOverScrollMode(2);
        this.ldN.setOnSrollToBottomListener(this.Uf);
        this.fbY = new PbListView(this.mActivity);
        this.fbY.getView();
        this.fbY.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fbY.setHeight(l.getDimens(this.mActivity, R.dimen.tbds182));
        this.fbY.setLineGone();
        this.fbY.setTextSize(R.dimen.tbfontsize33);
        this.fbY.setTextColor(am.getColor(R.color.cp_cont_j));
        this.fbY.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fbY.aWe();
    }

    public void e(BdListView.e eVar) {
        this.lhR = eVar;
    }

    public void a(RecyclerView.OnScrollListener onScrollListener) {
        if (this.ldN != null) {
            this.ldN.removeOnScrollListener(onScrollListener);
            this.ldN.addOnScrollListener(onScrollListener);
        }
    }

    public void a(a.InterfaceC0721a interfaceC0721a) {
        if (this.lhO != null) {
            this.lhO.b(interfaceC0721a);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lhQ != null) {
            this.lhQ.notifyDataSetChanged();
        }
        if (this.lhO != null) {
            this.lhO.notifyDataSetChanged();
        }
        if (this.fbY != null) {
            this.fbY.setTextColor(am.getColor(R.color.cp_cont_j));
            this.fbY.changeSkin(i);
        }
        if (this.fkQ != null) {
            this.fkQ.onChangeSkinType();
        }
    }

    public Pair<Integer, Integer> dbt() {
        int firstVisiblePosition = this.ldN.getFirstVisiblePosition();
        View childAt = this.ldN.getChildAt(0);
        return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(childAt != null ? childAt.getTop() : 0));
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.ldN != null && (this.ldN.getLayoutManager() instanceof LinearLayoutManager) && i <= this.ldN.getCount() - 1) {
            ((LinearLayoutManager) this.ldN.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    private void DG(int i) {
        if (this.lhM != null && (this.lhM.getLayoutManager() instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.lhM.getLayoutManager();
            if (i < 0) {
                i = 0;
            } else if (i > this.lhO.getItemCount() - 1) {
                i = this.lhO.getItemCount() - 1;
            }
            linearLayoutManager.scrollToPositionWithOffset(i, 0);
        }
    }

    public void brM() {
        this.ldN.setNextPage(null);
    }

    public void dbA() {
        this.ldN.setNextPage(this.fbY);
        this.fbY.hideEmptyView();
        this.fbY.getView().setPadding(0, 0, 0, 0);
        this.fbY.setText(this.mActivity.getString(R.string.pb_load_more));
        this.fbY.endLoadData();
    }

    public void dbB() {
        this.ldN.setNextPage(this.fbY);
        this.fbY.hideEmptyView();
        this.fbY.getView().setPadding(0, l.getDimens(this.mActivity, R.dimen.tbds62), 0, l.getDimens(this.mActivity, R.dimen.tbds362));
        this.fbY.setText(this.mActivity.getString(R.string.forum_square_list_has_no_more));
        this.fbY.endLoadData();
    }

    public void dbC() {
        this.ldN.setNextPage(this.fbY);
        this.fbY.hideEmptyView();
        this.fbY.getView().setPadding(0, 0, 0, 0);
        this.fbY.showLoading();
    }

    private boolean bPL() {
        if (this.fkQ != null) {
            return this.fkQ.isViewAttached();
        }
        return false;
    }

    public void hideLoadingView() {
        if (this.fkQ != null) {
            this.fkQ.dettachView(this.lhL);
            this.fkQ = null;
        }
    }

    public void fV(boolean z) {
        if (!bPL()) {
            if (this.fkQ == null) {
                this.fkQ = new g(this.mActivity);
                this.fkQ.setTopMargin(this.mActivity.getResources().getDimensionPixelSize(R.dimen.ds270));
            }
            this.fkQ.onChangeSkinType();
            this.fkQ.attachView(this.lhL, z);
        }
    }

    public void DH(int i) {
        this.ldN.setVisibility(i);
    }

    public void Bs(int i) {
        this.lhM.setVisibility(i);
        this.ldN.setVisibility(i);
    }
}
