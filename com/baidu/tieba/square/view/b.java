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
    private BdListView.e TT = new BdListView.e() { // from class: com.baidu.tieba.square.view.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.kLx != null) {
                b.this.kLx.stopScroll();
            }
            if (b.this.kPB != null) {
                b.this.kPB.onScrollToBottom();
            }
        }
    };
    private PbListView ePr;
    private g eYg;
    private BdTypeRecyclerView kLx;
    private com.baidu.tieba.square.a.b kPA;
    private BdListView.e kPB;
    private RelativeLayout kPv;
    private RecyclerView kPw;
    private LinearLayoutManager kPx;
    private com.baidu.tieba.square.a.a kPy;
    private LinearLayoutManager kPz;
    private Activity mActivity;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        initView();
        cLb();
    }

    private void initView() {
        this.kPv = (RelativeLayout) this.mActivity.findViewById(R.id.right_container);
        this.kPw = (RecyclerView) this.mActivity.findViewById(R.id.rv_left);
        this.kLx = (BdTypeRecyclerView) this.mActivity.findViewById(R.id.rv_right);
    }

    public String cUp() {
        return this.kPy.cUB();
    }

    public void b(String str, List<String> list, boolean z) {
        int position = v.getPosition(list, str);
        this.kPy.p(position, list);
        if (z) {
            CW(position);
        }
    }

    public void cUq() {
        ArrayList arrayList = new ArrayList();
        t tVar = new t();
        tVar.showText = this.mActivity.getString(R.string.forum_square_list_no_data);
        tVar.resId = R.drawable.new_pic_emotion_06;
        arrayList.add(tVar);
        this.kPA.setData(arrayList);
    }

    public void er(List<m> list) {
        o(list, 0);
    }

    public void o(List<m> list, int i) {
        if (v.isEmpty(list)) {
            cUq();
            return;
        }
        if (i > 0) {
            Pair<Integer, Integer> cUo = cUo();
            int intValue = ((Integer) cUo.first).intValue();
            int intValue2 = ((Integer) cUo.second).intValue();
            int i2 = intValue - i;
            if (this.kPz != null && this.kLx != null) {
                this.kLx.oQ();
                this.kPz.scrollToPositionWithOffset(i2, intValue2);
                this.kLx.oR();
            }
        }
        this.kPA.setData(list);
    }

    private void cLb() {
        this.kPx = new LinearLayoutManager(this.mActivity);
        this.kPw.setLayoutManager(this.kPx);
        this.kPy = new com.baidu.tieba.square.a.a(this.mActivity);
        this.kPw.setAdapter(this.kPy);
        this.kPA = new com.baidu.tieba.square.a.b(this.mPageContext, this.kLx);
        this.kPz = new LinearLayoutManager(this.mActivity);
        this.kLx.setLayoutManager(this.kPz);
        this.kLx.setFadingEdgeLength(0);
        this.kLx.setOverScrollMode(2);
        this.kLx.setOnSrollToBottomListener(this.TT);
        this.ePr = new PbListView(this.mActivity);
        this.ePr.getView();
        this.ePr.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ePr.setHeight(l.getDimens(this.mActivity, R.dimen.tbds182));
        this.ePr.setLineGone();
        this.ePr.setTextSize(R.dimen.tbfontsize33);
        this.ePr.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ePr.setNoMoreTextColorId(R.color.cp_cont_e);
        this.ePr.aQa();
    }

    public void e(BdListView.e eVar) {
        this.kPB = eVar;
    }

    public void a(RecyclerView.OnScrollListener onScrollListener) {
        if (this.kLx != null) {
            this.kLx.removeOnScrollListener(onScrollListener);
            this.kLx.addOnScrollListener(onScrollListener);
        }
    }

    public void a(a.InterfaceC0668a interfaceC0668a) {
        if (this.kPy != null) {
            this.kPy.b(interfaceC0668a);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kPA != null) {
            this.kPA.notifyDataSetChanged();
        }
        if (this.kPy != null) {
            this.kPy.notifyDataSetChanged();
        }
        if (this.ePr != null) {
            this.ePr.setTextColor(am.getColor(R.color.cp_cont_j));
            this.ePr.changeSkin(i);
        }
        if (this.eYg != null) {
            this.eYg.onChangeSkinType();
        }
    }

    public Pair<Integer, Integer> cUo() {
        int firstVisiblePosition = this.kLx.getFirstVisiblePosition();
        View childAt = this.kLx.getChildAt(0);
        return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(childAt != null ? childAt.getTop() : 0));
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.kLx != null && (this.kLx.getLayoutManager() instanceof LinearLayoutManager) && i <= this.kLx.getCount() - 1) {
            ((LinearLayoutManager) this.kLx.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    private void CW(int i) {
        if (this.kPw != null && (this.kPw.getLayoutManager() instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.kPw.getLayoutManager();
            if (i < 0) {
                i = 0;
            } else if (i > this.kPy.getItemCount() - 1) {
                i = this.kPy.getItemCount() - 1;
            }
            linearLayoutManager.scrollToPositionWithOffset(i, 0);
        }
    }

    public void bmo() {
        this.kLx.setNextPage(null);
    }

    public void cUv() {
        this.kLx.setNextPage(this.ePr);
        this.ePr.hideEmptyView();
        this.ePr.getView().setPadding(0, 0, 0, 0);
        this.ePr.setText(this.mActivity.getString(R.string.pb_load_more));
        this.ePr.endLoadData();
    }

    public void cUw() {
        this.kLx.setNextPage(this.ePr);
        this.ePr.hideEmptyView();
        this.ePr.getView().setPadding(0, l.getDimens(this.mActivity, R.dimen.tbds62), 0, l.getDimens(this.mActivity, R.dimen.tbds362));
        this.ePr.setText(this.mActivity.getString(R.string.forum_square_list_has_no_more));
        this.ePr.endLoadData();
    }

    public void cUx() {
        this.kLx.setNextPage(this.ePr);
        this.ePr.hideEmptyView();
        this.ePr.getView().setPadding(0, 0, 0, 0);
        this.ePr.showLoading();
    }

    private boolean bJr() {
        if (this.eYg != null) {
            return this.eYg.isViewAttached();
        }
        return false;
    }

    public void hideLoadingView() {
        if (this.eYg != null) {
            this.eYg.dettachView(this.kPv);
            this.eYg = null;
        }
    }

    public void fK(boolean z) {
        if (!bJr()) {
            if (this.eYg == null) {
                this.eYg = new g(this.mActivity);
                this.eYg.setTopMargin(this.mActivity.getResources().getDimensionPixelSize(R.dimen.ds270));
            }
            this.eYg.onChangeSkinType();
            this.eYg.attachView(this.kPv, z);
        }
    }

    public void CX(int i) {
        this.kLx.setVisibility(i);
    }

    public void AH(int i) {
        this.kPw.setVisibility(i);
        this.kLx.setVisibility(i);
    }
}
