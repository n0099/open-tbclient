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
    private BdListView.e WN = new BdListView.e() { // from class: com.baidu.tieba.square.view.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.nky != null) {
                b.this.nky.stopScroll();
            }
            if (b.this.noz != null) {
                b.this.noz.onScrollToBottom();
            }
        }
    };
    private PbListView gCf;
    private g gLj;
    private TbPageContext<?> mPageContext;
    private final View mRoot;
    private BdTypeRecyclerView nky;
    private RelativeLayout nor;
    private RecyclerView nos;
    private LinearLayoutManager nou;
    private LeftAdapter nov;
    private LinearLayoutManager nox;
    private com.baidu.tieba.square.adapter.a noy;
    private BdListView.e noz;

    public b(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRoot = view;
        initView();
        dCG();
    }

    private void initView() {
        this.nor = (RelativeLayout) this.mRoot.findViewById(R.id.right_container);
        this.nos = (RecyclerView) this.mRoot.findViewById(R.id.rv_left);
        this.nky = (BdTypeRecyclerView) this.mRoot.findViewById(R.id.rv_right);
    }

    public String dMZ() {
        return this.nov.dNl();
    }

    public void SR(String str) {
        if (str != null) {
            int SS = this.nov.SS(str);
            this.nov.we(SS);
            KE(SS);
        }
    }

    public void d(String str, List<String> list, boolean z) {
        int position = x.getPosition(list, str);
        this.nov.p(position, list);
        if (z) {
            KE(position);
        }
    }

    public void dNa() {
        ArrayList arrayList = new ArrayList();
        v vVar = new v();
        vVar.showText = this.mPageContext.getString(R.string.forum_square_list_no_data);
        vVar.resId = R.drawable.new_pic_emotion_06;
        arrayList.add(vVar);
        this.noy.setData(arrayList);
    }

    public void fS(List<n> list) {
        v(list, 0);
    }

    public void v(List<n> list, int i) {
        if (x.isEmpty(list)) {
            dNa();
            return;
        }
        if (i > 0) {
            Pair<Integer, Integer> dMY = dMY();
            int intValue = ((Integer) dMY.first).intValue();
            int intValue2 = ((Integer) dMY.second).intValue();
            int i2 = intValue - i;
            if (this.nox != null && this.nky != null) {
                this.nky.qv();
                this.nox.scrollToPositionWithOffset(i2, intValue2);
                this.nky.qw();
            }
        }
        this.noy.setData(list);
    }

    private void dCG() {
        this.nou = new LinearLayoutManager(this.mPageContext.getPageActivity());
        this.nos.setLayoutManager(this.nou);
        this.nov = new LeftAdapter(this.mPageContext.getPageActivity());
        this.nos.setAdapter(this.nov);
        this.noy = new com.baidu.tieba.square.adapter.a(this.mPageContext, this.nky);
        this.nox = new LinearLayoutManager(this.mPageContext.getPageActivity());
        this.nky.setLayoutManager(this.nox);
        this.nky.setFadingEdgeLength(0);
        this.nky.setOverScrollMode(2);
        this.nky.setOnSrollToBottomListener(this.WN);
        this.gCf = new PbListView(this.mPageContext.getPageActivity());
        this.gCf.getView();
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gCf.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.gCf.setLineGone();
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gCf.bxD();
    }

    public void e(BdListView.e eVar) {
        this.noz = eVar;
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.nky != null) {
            this.nky.removeOnScrollListener(onScrollListener);
            this.nky.addOnScrollListener(onScrollListener);
        }
    }

    public void a(LeftAdapter.a aVar) {
        if (this.nov != null) {
            this.nov.b(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.noy != null) {
            this.noy.notifyDataSetChanged();
        }
        if (this.nov != null) {
            this.nov.notifyDataSetChanged();
        }
        if (this.gCf != null) {
            this.gCf.setTextColor(ao.getColor(R.color.CAM_X0107));
            this.gCf.changeSkin(i);
        }
        if (this.gLj != null) {
            this.gLj.onChangeSkinType();
        }
    }

    public Pair<Integer, Integer> dMY() {
        int firstVisiblePosition = this.nky.getFirstVisiblePosition();
        View childAt = this.nky.getChildAt(0);
        return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(childAt != null ? childAt.getTop() : 0));
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.nky != null && (this.nky.getLayoutManager() instanceof LinearLayoutManager) && i <= this.nky.getCount() - 1) {
            ((LinearLayoutManager) this.nky.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    private void KE(int i) {
        if (this.nos != null && (this.nos.getLayoutManager() instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.nos.getLayoutManager();
            if (i < 0) {
                i = 0;
            } else if (i > this.nov.getItemCount() - 1) {
                i = this.nov.getItemCount() - 1;
            }
            linearLayoutManager.scrollToPositionWithOffset(i, 0);
        }
    }

    public void bVG() {
        this.nky.setNextPage(null);
    }

    public void dNf() {
        this.nky.setNextPage(this.gCf);
        this.gCf.hideEmptyView();
        this.gCf.getView().setPadding(0, 0, 0, 0);
        this.gCf.setText(this.mPageContext.getPageActivity().getString(R.string.pb_load_more));
        this.gCf.endLoadData();
    }

    public void dNg() {
        this.nky.setNextPage(this.gCf);
        this.gCf.hideEmptyView();
        this.gCf.getView().setPadding(0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds62), 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds362));
        this.gCf.setText(this.mPageContext.getPageActivity().getString(R.string.forum_square_list_has_no_more));
        this.gCf.endLoadData();
    }

    public void dNh() {
        this.nky.setNextPage(this.gCf);
        this.gCf.hideEmptyView();
        this.gCf.getView().setPadding(0, 0, 0, 0);
        this.gCf.showLoading();
    }

    private boolean ctt() {
        if (this.gLj != null) {
            return this.gLj.isViewAttached();
        }
        return false;
    }

    public void hideLoadingView() {
        if (this.gLj != null) {
            this.gLj.dettachView(this.nor);
            this.gLj = null;
        }
    }

    public void it(boolean z) {
        if (!ctt()) {
            if (this.gLj == null) {
                this.gLj = new g(this.mPageContext.getPageActivity());
                this.gLj.setTopMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds270));
            }
            this.gLj.onChangeSkinType();
            this.gLj.attachView(this.nor, z);
        }
    }

    public void KF(int i) {
        this.nky.setVisibility(i);
    }

    public void In(int i) {
        this.nos.setVisibility(i);
        this.nky.setVisibility(i);
    }
}
