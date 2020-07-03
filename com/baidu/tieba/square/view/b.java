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
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.k.g;
import com.baidu.tieba.R;
import com.baidu.tieba.square.a.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private BdListView.e UJ = new BdListView.e() { // from class: com.baidu.tieba.square.view.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.lyU != null) {
                b.this.lyU.stopScroll();
            }
            if (b.this.lCV != null) {
                b.this.lCV.onScrollToBottom();
            }
        }
    };
    private PbListView fnt;
    private g fwo;
    private RelativeLayout lCP;
    private RecyclerView lCQ;
    private LinearLayoutManager lCR;
    private com.baidu.tieba.square.a.a lCS;
    private LinearLayoutManager lCT;
    private com.baidu.tieba.square.a.b lCU;
    private BdListView.e lCV;
    private BdTypeRecyclerView lyU;
    private Activity mActivity;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mActivity = tbPageContext.getPageActivity();
        initView();
        cWI();
    }

    private void initView() {
        this.lCP = (RelativeLayout) this.mActivity.findViewById(R.id.right_container);
        this.lCQ = (RecyclerView) this.mActivity.findViewById(R.id.rv_left);
        this.lyU = (BdTypeRecyclerView) this.mActivity.findViewById(R.id.rv_right);
    }

    public String dfY() {
        return this.lCS.dgk();
    }

    public void b(String str, List<String> list, boolean z) {
        int position = w.getPosition(list, str);
        this.lCS.p(position, list);
        if (z) {
            EK(position);
        }
    }

    public void dfZ() {
        ArrayList arrayList = new ArrayList();
        x xVar = new x();
        xVar.showText = this.mActivity.getString(R.string.forum_square_list_no_data);
        xVar.resId = R.drawable.new_pic_emotion_06;
        arrayList.add(xVar);
        this.lCU.setData(arrayList);
    }

    public void eO(List<q> list) {
        r(list, 0);
    }

    public void r(List<q> list, int i) {
        if (w.isEmpty(list)) {
            dfZ();
            return;
        }
        if (i > 0) {
            Pair<Integer, Integer> dfX = dfX();
            int intValue = ((Integer) dfX.first).intValue();
            int intValue2 = ((Integer) dfX.second).intValue();
            int i2 = intValue - i;
            if (this.lCT != null && this.lyU != null) {
                this.lyU.pm();
                this.lCT.scrollToPositionWithOffset(i2, intValue2);
                this.lyU.pn();
            }
        }
        this.lCU.setData(list);
    }

    private void cWI() {
        this.lCR = new LinearLayoutManager(this.mActivity);
        this.lCQ.setLayoutManager(this.lCR);
        this.lCS = new com.baidu.tieba.square.a.a(this.mActivity);
        this.lCQ.setAdapter(this.lCS);
        this.lCU = new com.baidu.tieba.square.a.b(this.mPageContext, this.lyU);
        this.lCT = new LinearLayoutManager(this.mActivity);
        this.lyU.setLayoutManager(this.lCT);
        this.lyU.setFadingEdgeLength(0);
        this.lyU.setOverScrollMode(2);
        this.lyU.setOnSrollToBottomListener(this.UJ);
        this.fnt = new PbListView(this.mActivity);
        this.fnt.getView();
        this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fnt.setHeight(l.getDimens(this.mActivity, R.dimen.tbds182));
        this.fnt.setLineGone();
        this.fnt.setTextSize(R.dimen.tbfontsize33);
        this.fnt.setTextColor(an.getColor(R.color.cp_cont_j));
        this.fnt.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fnt.aXZ();
    }

    public void e(BdListView.e eVar) {
        this.lCV = eVar;
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.lyU != null) {
            this.lyU.removeOnScrollListener(onScrollListener);
            this.lyU.addOnScrollListener(onScrollListener);
        }
    }

    public void a(a.InterfaceC0738a interfaceC0738a) {
        if (this.lCS != null) {
            this.lCS.b(interfaceC0738a);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lCU != null) {
            this.lCU.notifyDataSetChanged();
        }
        if (this.lCS != null) {
            this.lCS.notifyDataSetChanged();
        }
        if (this.fnt != null) {
            this.fnt.setTextColor(an.getColor(R.color.cp_cont_j));
            this.fnt.changeSkin(i);
        }
        if (this.fwo != null) {
            this.fwo.onChangeSkinType();
        }
    }

    public Pair<Integer, Integer> dfX() {
        int firstVisiblePosition = this.lyU.getFirstVisiblePosition();
        View childAt = this.lyU.getChildAt(0);
        return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(childAt != null ? childAt.getTop() : 0));
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.lyU != null && (this.lyU.getLayoutManager() instanceof LinearLayoutManager) && i <= this.lyU.getCount() - 1) {
            ((LinearLayoutManager) this.lyU.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    private void EK(int i) {
        if (this.lCQ != null && (this.lCQ.getLayoutManager() instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.lCQ.getLayoutManager();
            if (i < 0) {
                i = 0;
            } else if (i > this.lCS.getItemCount() - 1) {
                i = this.lCS.getItemCount() - 1;
            }
            linearLayoutManager.scrollToPositionWithOffset(i, 0);
        }
    }

    public void buK() {
        this.lyU.setNextPage(null);
    }

    public void dge() {
        this.lyU.setNextPage(this.fnt);
        this.fnt.hideEmptyView();
        this.fnt.getView().setPadding(0, 0, 0, 0);
        this.fnt.setText(this.mActivity.getString(R.string.pb_load_more));
        this.fnt.endLoadData();
    }

    public void dgf() {
        this.lyU.setNextPage(this.fnt);
        this.fnt.hideEmptyView();
        this.fnt.getView().setPadding(0, l.getDimens(this.mActivity, R.dimen.tbds62), 0, l.getDimens(this.mActivity, R.dimen.tbds362));
        this.fnt.setText(this.mActivity.getString(R.string.forum_square_list_has_no_more));
        this.fnt.endLoadData();
    }

    public void dgg() {
        this.lyU.setNextPage(this.fnt);
        this.fnt.hideEmptyView();
        this.fnt.getView().setPadding(0, 0, 0, 0);
        this.fnt.showLoading();
    }

    private boolean bSQ() {
        if (this.fwo != null) {
            return this.fwo.isViewAttached();
        }
        return false;
    }

    public void hideLoadingView() {
        if (this.fwo != null) {
            this.fwo.dettachView(this.lCP);
            this.fwo = null;
        }
    }

    public void ga(boolean z) {
        if (!bSQ()) {
            if (this.fwo == null) {
                this.fwo = new g(this.mActivity);
                this.fwo.setTopMargin(this.mActivity.getResources().getDimensionPixelSize(R.dimen.ds270));
            }
            this.fwo.onChangeSkinType();
            this.fwo.attachView(this.lCP, z);
        }
    }

    public void EL(int i) {
        this.lyU.setVisibility(i);
    }

    public void Cw(int i) {
        this.lCQ.setVisibility(i);
        this.lyU.setVisibility(i);
    }
}
