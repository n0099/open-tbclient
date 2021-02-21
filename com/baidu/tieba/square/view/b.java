package com.baidu.tieba.square.view;

import android.util.Pair;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.l.g;
import com.baidu.tieba.R;
import com.baidu.tieba.square.adapter.LeftAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private BdListView.e WH = new BdListView.e() { // from class: com.baidu.tieba.square.view.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.nqc != null) {
                b.this.nqc.stopScroll();
            }
            if (b.this.nub != null) {
                b.this.nub.onScrollToBottom();
            }
        }
    };
    private PbListView gAw;
    private g gJB;
    private TbPageContext<?> mPageContext;
    private final View mRoot;
    private BdTypeRecyclerView nqc;
    private RelativeLayout ntV;
    private RecyclerView ntW;
    private LinearLayoutManager ntX;
    private LeftAdapter ntY;
    private LinearLayoutManager ntZ;
    private com.baidu.tieba.square.adapter.a nua;
    private BdListView.e nub;

    public b(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRoot = view;
        initView();
        dBf();
    }

    private void initView() {
        this.ntV = (RelativeLayout) this.mRoot.findViewById(R.id.right_container);
        this.ntW = (RecyclerView) this.mRoot.findViewById(R.id.rv_left);
        this.nqc = (BdTypeRecyclerView) this.mRoot.findViewById(R.id.rv_right);
    }

    public String dLA() {
        return this.ntY.dLM();
    }

    public void ST(String str) {
        if (str != null) {
            int SU = this.ntY.SU(str);
            this.ntY.uE(SU);
            Jr(SU);
        }
    }

    public void e(String str, List<String> list, boolean z) {
        int position = y.getPosition(list, str);
        this.ntY.setData(position, list);
        if (z) {
            Jr(position);
        }
    }

    public void dLB() {
        ArrayList arrayList = new ArrayList();
        v vVar = new v();
        vVar.showText = this.mPageContext.getString(R.string.forum_square_list_no_data);
        vVar.resId = R.drawable.new_pic_emotion_06;
        arrayList.add(vVar);
        this.nua.setData(arrayList);
    }

    public void fQ(List<n> list) {
        v(list, 0);
    }

    public void v(List<n> list, int i) {
        if (y.isEmpty(list)) {
            dLB();
            return;
        }
        if (i > 0) {
            Pair<Integer, Integer> dLz = dLz();
            int intValue = ((Integer) dLz.first).intValue();
            int intValue2 = ((Integer) dLz.second).intValue();
            int i2 = intValue - i;
            if (this.ntZ != null && this.nqc != null) {
                this.nqc.qt();
                this.ntZ.scrollToPositionWithOffset(i2, intValue2);
                this.nqc.qu();
            }
        }
        this.nua.setData(list);
    }

    private void dBf() {
        this.ntX = new LinearLayoutManager(this.mPageContext.getPageActivity());
        this.ntW.setLayoutManager(this.ntX);
        this.ntY = new LeftAdapter(this.mPageContext.getPageActivity());
        this.ntW.setAdapter(this.ntY);
        this.nua = new com.baidu.tieba.square.adapter.a(this.mPageContext, this.nqc);
        this.ntZ = new LinearLayoutManager(this.mPageContext.getPageActivity());
        this.nqc.setLayoutManager(this.ntZ);
        this.nqc.setFadingEdgeLength(0);
        this.nqc.setOverScrollMode(2);
        this.nqc.setOnSrollToBottomListener(this.WH);
        this.gAw = new PbListView(this.mPageContext.getPageActivity());
        this.gAw.getView();
        this.gAw.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gAw.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.gAw.setLineGone();
        this.gAw.setTextSize(R.dimen.tbfontsize33);
        this.gAw.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gAw.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gAw.bud();
    }

    public void e(BdListView.e eVar) {
        this.nub = eVar;
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.nqc != null) {
            this.nqc.removeOnScrollListener(onScrollListener);
            this.nqc.addOnScrollListener(onScrollListener);
        }
    }

    public void a(LeftAdapter.a aVar) {
        if (this.ntY != null) {
            this.ntY.b(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.nua != null) {
            this.nua.notifyDataSetChanged();
        }
        if (this.ntY != null) {
            this.ntY.notifyDataSetChanged();
        }
        if (this.gAw != null) {
            this.gAw.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gAw.changeSkin(i);
        }
        if (this.gJB != null) {
            this.gJB.onChangeSkinType();
        }
    }

    public Pair<Integer, Integer> dLz() {
        int firstVisiblePosition = this.nqc.getFirstVisiblePosition();
        View childAt = this.nqc.getChildAt(0);
        return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(childAt != null ? childAt.getTop() : 0));
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.nqc != null && (this.nqc.getLayoutManager() instanceof LinearLayoutManager) && i <= this.nqc.getCount() - 1) {
            ((LinearLayoutManager) this.nqc.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    private void Jr(int i) {
        if (this.ntW != null && (this.ntW.getLayoutManager() instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.ntW.getLayoutManager();
            if (i < 0) {
                i = 0;
            } else if (i > this.ntY.getItemCount() - 1) {
                i = this.ntY.getItemCount() - 1;
            }
            linearLayoutManager.scrollToPositionWithOffset(i, 0);
        }
    }

    public void bSy() {
        this.nqc.setNextPage(null);
    }

    public void dLG() {
        this.nqc.setNextPage(this.gAw);
        this.gAw.hideEmptyView();
        this.gAw.getView().setPadding(0, 0, 0, 0);
        this.gAw.setText(this.mPageContext.getPageActivity().getString(R.string.pb_load_more));
        this.gAw.endLoadData();
    }

    public void dLH() {
        this.nqc.setNextPage(this.gAw);
        this.gAw.hideEmptyView();
        this.gAw.getView().setPadding(0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds62), 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds362));
        this.gAw.setText(this.mPageContext.getPageActivity().getString(R.string.forum_square_list_has_no_more));
        this.gAw.endLoadData();
    }

    public void dLI() {
        this.nqc.setNextPage(this.gAw);
        this.gAw.hideEmptyView();
        this.gAw.getView().setPadding(0, 0, 0, 0);
        this.gAw.showLoading();
    }

    private boolean cqS() {
        if (this.gJB != null) {
            return this.gJB.isViewAttached();
        }
        return false;
    }

    public void hideLoadingView() {
        if (this.gJB != null) {
            this.gJB.dettachView(this.ntV);
            this.gJB = null;
        }
    }

    public void ir(boolean z) {
        if (!cqS()) {
            if (this.gJB == null) {
                this.gJB = new g(this.mPageContext.getPageActivity());
                this.gJB.setTopMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds270));
            }
            this.gJB.onChangeSkinType();
            this.gJB.attachView(this.ntV, z);
        }
    }

    public void Js(int i) {
        this.nqc.setVisibility(i);
    }

    public void GY(int i) {
        this.ntW.setVisibility(i);
        this.nqc.setVisibility(i);
    }
}
