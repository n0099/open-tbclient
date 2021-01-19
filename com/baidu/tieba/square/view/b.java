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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.l.g;
import com.baidu.tieba.R;
import com.baidu.tieba.square.adapter.LeftAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private BdListView.e WL = new BdListView.e() { // from class: com.baidu.tieba.square.view.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.nfT != null) {
                b.this.nfT.stopScroll();
            }
            if (b.this.njT != null) {
                b.this.njT.onScrollToBottom();
            }
        }
    };
    private g gGD;
    private PbListView gxy;
    private TbPageContext<?> mPageContext;
    private final View mRoot;
    private BdTypeRecyclerView nfT;
    private RelativeLayout njN;
    private RecyclerView njO;
    private LinearLayoutManager njP;
    private LeftAdapter njQ;
    private LinearLayoutManager njR;
    private com.baidu.tieba.square.adapter.a njS;
    private BdListView.e njT;

    public b(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRoot = view;
        initView();
        dyO();
    }

    private void initView() {
        this.njN = (RelativeLayout) this.mRoot.findViewById(R.id.right_container);
        this.njO = (RecyclerView) this.mRoot.findViewById(R.id.rv_left);
        this.nfT = (BdTypeRecyclerView) this.mRoot.findViewById(R.id.rv_right);
    }

    public String dJh() {
        return this.njQ.dJt();
    }

    public void RK(String str) {
        if (str != null) {
            int RL = this.njQ.RL(str);
            this.njQ.uy(RL);
            IX(RL);
        }
    }

    public void d(String str, List<String> list, boolean z) {
        int position = x.getPosition(list, str);
        this.njQ.p(position, list);
        if (z) {
            IX(position);
        }
    }

    public void dJi() {
        ArrayList arrayList = new ArrayList();
        v vVar = new v();
        vVar.showText = this.mPageContext.getString(R.string.forum_square_list_no_data);
        vVar.resId = R.drawable.new_pic_emotion_06;
        arrayList.add(vVar);
        this.njS.setData(arrayList);
    }

    public void fS(List<n> list) {
        v(list, 0);
    }

    public void v(List<n> list, int i) {
        if (x.isEmpty(list)) {
            dJi();
            return;
        }
        if (i > 0) {
            Pair<Integer, Integer> dJg = dJg();
            int intValue = ((Integer) dJg.first).intValue();
            int intValue2 = ((Integer) dJg.second).intValue();
            int i2 = intValue - i;
            if (this.njR != null && this.nfT != null) {
                this.nfT.qv();
                this.njR.scrollToPositionWithOffset(i2, intValue2);
                this.nfT.qw();
            }
        }
        this.njS.setData(list);
    }

    private void dyO() {
        this.njP = new LinearLayoutManager(this.mPageContext.getPageActivity());
        this.njO.setLayoutManager(this.njP);
        this.njQ = new LeftAdapter(this.mPageContext.getPageActivity());
        this.njO.setAdapter(this.njQ);
        this.njS = new com.baidu.tieba.square.adapter.a(this.mPageContext, this.nfT);
        this.njR = new LinearLayoutManager(this.mPageContext.getPageActivity());
        this.nfT.setLayoutManager(this.njR);
        this.nfT.setFadingEdgeLength(0);
        this.nfT.setOverScrollMode(2);
        this.nfT.setOnSrollToBottomListener(this.WL);
        this.gxy = new PbListView(this.mPageContext.getPageActivity());
        this.gxy.getView();
        this.gxy.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gxy.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.gxy.setLineGone();
        this.gxy.setTextSize(R.dimen.tbfontsize33);
        this.gxy.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gxy.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gxy.btJ();
    }

    public void e(BdListView.e eVar) {
        this.njT = eVar;
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.nfT != null) {
            this.nfT.removeOnScrollListener(onScrollListener);
            this.nfT.addOnScrollListener(onScrollListener);
        }
    }

    public void a(LeftAdapter.a aVar) {
        if (this.njQ != null) {
            this.njQ.b(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.njS != null) {
            this.njS.notifyDataSetChanged();
        }
        if (this.njQ != null) {
            this.njQ.notifyDataSetChanged();
        }
        if (this.gxy != null) {
            this.gxy.setTextColor(ao.getColor(R.color.CAM_X0107));
            this.gxy.changeSkin(i);
        }
        if (this.gGD != null) {
            this.gGD.onChangeSkinType();
        }
    }

    public Pair<Integer, Integer> dJg() {
        int firstVisiblePosition = this.nfT.getFirstVisiblePosition();
        View childAt = this.nfT.getChildAt(0);
        return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(childAt != null ? childAt.getTop() : 0));
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.nfT != null && (this.nfT.getLayoutManager() instanceof LinearLayoutManager) && i <= this.nfT.getCount() - 1) {
            ((LinearLayoutManager) this.nfT.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    private void IX(int i) {
        if (this.njO != null && (this.njO.getLayoutManager() instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.njO.getLayoutManager();
            if (i < 0) {
                i = 0;
            } else if (i > this.njQ.getItemCount() - 1) {
                i = this.njQ.getItemCount() - 1;
            }
            linearLayoutManager.scrollToPositionWithOffset(i, 0);
        }
    }

    public void bRO() {
        this.nfT.setNextPage(null);
    }

    public void dJn() {
        this.nfT.setNextPage(this.gxy);
        this.gxy.hideEmptyView();
        this.gxy.getView().setPadding(0, 0, 0, 0);
        this.gxy.setText(this.mPageContext.getPageActivity().getString(R.string.pb_load_more));
        this.gxy.endLoadData();
    }

    public void dJo() {
        this.nfT.setNextPage(this.gxy);
        this.gxy.hideEmptyView();
        this.gxy.getView().setPadding(0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds62), 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds362));
        this.gxy.setText(this.mPageContext.getPageActivity().getString(R.string.forum_square_list_has_no_more));
        this.gxy.endLoadData();
    }

    public void dJp() {
        this.nfT.setNextPage(this.gxy);
        this.gxy.hideEmptyView();
        this.gxy.getView().setPadding(0, 0, 0, 0);
        this.gxy.showLoading();
    }

    private boolean cpB() {
        if (this.gGD != null) {
            return this.gGD.isViewAttached();
        }
        return false;
    }

    public void hideLoadingView() {
        if (this.gGD != null) {
            this.gGD.dettachView(this.njN);
            this.gGD = null;
        }
    }

    public void ip(boolean z) {
        if (!cpB()) {
            if (this.gGD == null) {
                this.gGD = new g(this.mPageContext.getPageActivity());
                this.gGD.setTopMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds270));
            }
            this.gGD.onChangeSkinType();
            this.gGD.attachView(this.njN, z);
        }
    }

    public void IY(int i) {
        this.nfT.setVisibility(i);
    }

    public void GG(int i) {
        this.njO.setVisibility(i);
        this.nfT.setVisibility(i);
    }
}
