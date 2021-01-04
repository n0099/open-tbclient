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
            if (b.this.nkz != null) {
                b.this.nkz.stopScroll();
            }
            if (b.this.noA != null) {
                b.this.noA.onScrollToBottom();
            }
        }
    };
    private PbListView gCf;
    private g gLj;
    private TbPageContext<?> mPageContext;
    private final View mRoot;
    private BdTypeRecyclerView nkz;
    private BdListView.e noA;
    private RelativeLayout nos;
    private RecyclerView nou;
    private LinearLayoutManager nov;
    private LeftAdapter nox;
    private LinearLayoutManager noy;
    private com.baidu.tieba.square.adapter.a noz;

    public b(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRoot = view;
        initView();
        dCF();
    }

    private void initView() {
        this.nos = (RelativeLayout) this.mRoot.findViewById(R.id.right_container);
        this.nou = (RecyclerView) this.mRoot.findViewById(R.id.rv_left);
        this.nkz = (BdTypeRecyclerView) this.mRoot.findViewById(R.id.rv_right);
    }

    public String dMY() {
        return this.nox.dNk();
    }

    public void SS(String str) {
        if (str != null) {
            int ST = this.nox.ST(str);
            this.nox.we(ST);
            KE(ST);
        }
    }

    public void d(String str, List<String> list, boolean z) {
        int position = x.getPosition(list, str);
        this.nox.p(position, list);
        if (z) {
            KE(position);
        }
    }

    public void dMZ() {
        ArrayList arrayList = new ArrayList();
        v vVar = new v();
        vVar.showText = this.mPageContext.getString(R.string.forum_square_list_no_data);
        vVar.resId = R.drawable.new_pic_emotion_06;
        arrayList.add(vVar);
        this.noz.setData(arrayList);
    }

    public void fS(List<n> list) {
        v(list, 0);
    }

    public void v(List<n> list, int i) {
        if (x.isEmpty(list)) {
            dMZ();
            return;
        }
        if (i > 0) {
            Pair<Integer, Integer> dMX = dMX();
            int intValue = ((Integer) dMX.first).intValue();
            int intValue2 = ((Integer) dMX.second).intValue();
            int i2 = intValue - i;
            if (this.noy != null && this.nkz != null) {
                this.nkz.qv();
                this.noy.scrollToPositionWithOffset(i2, intValue2);
                this.nkz.qw();
            }
        }
        this.noz.setData(list);
    }

    private void dCF() {
        this.nov = new LinearLayoutManager(this.mPageContext.getPageActivity());
        this.nou.setLayoutManager(this.nov);
        this.nox = new LeftAdapter(this.mPageContext.getPageActivity());
        this.nou.setAdapter(this.nox);
        this.noz = new com.baidu.tieba.square.adapter.a(this.mPageContext, this.nkz);
        this.noy = new LinearLayoutManager(this.mPageContext.getPageActivity());
        this.nkz.setLayoutManager(this.noy);
        this.nkz.setFadingEdgeLength(0);
        this.nkz.setOverScrollMode(2);
        this.nkz.setOnSrollToBottomListener(this.WN);
        this.gCf = new PbListView(this.mPageContext.getPageActivity());
        this.gCf.getView();
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gCf.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.gCf.setLineGone();
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gCf.bxC();
    }

    public void e(BdListView.e eVar) {
        this.noA = eVar;
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.nkz != null) {
            this.nkz.removeOnScrollListener(onScrollListener);
            this.nkz.addOnScrollListener(onScrollListener);
        }
    }

    public void a(LeftAdapter.a aVar) {
        if (this.nox != null) {
            this.nox.b(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.noz != null) {
            this.noz.notifyDataSetChanged();
        }
        if (this.nox != null) {
            this.nox.notifyDataSetChanged();
        }
        if (this.gCf != null) {
            this.gCf.setTextColor(ao.getColor(R.color.CAM_X0107));
            this.gCf.changeSkin(i);
        }
        if (this.gLj != null) {
            this.gLj.onChangeSkinType();
        }
    }

    public Pair<Integer, Integer> dMX() {
        int firstVisiblePosition = this.nkz.getFirstVisiblePosition();
        View childAt = this.nkz.getChildAt(0);
        return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(childAt != null ? childAt.getTop() : 0));
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.nkz != null && (this.nkz.getLayoutManager() instanceof LinearLayoutManager) && i <= this.nkz.getCount() - 1) {
            ((LinearLayoutManager) this.nkz.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    private void KE(int i) {
        if (this.nou != null && (this.nou.getLayoutManager() instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.nou.getLayoutManager();
            if (i < 0) {
                i = 0;
            } else if (i > this.nox.getItemCount() - 1) {
                i = this.nox.getItemCount() - 1;
            }
            linearLayoutManager.scrollToPositionWithOffset(i, 0);
        }
    }

    public void bVF() {
        this.nkz.setNextPage(null);
    }

    public void dNe() {
        this.nkz.setNextPage(this.gCf);
        this.gCf.hideEmptyView();
        this.gCf.getView().setPadding(0, 0, 0, 0);
        this.gCf.setText(this.mPageContext.getPageActivity().getString(R.string.pb_load_more));
        this.gCf.endLoadData();
    }

    public void dNf() {
        this.nkz.setNextPage(this.gCf);
        this.gCf.hideEmptyView();
        this.gCf.getView().setPadding(0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds62), 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds362));
        this.gCf.setText(this.mPageContext.getPageActivity().getString(R.string.forum_square_list_has_no_more));
        this.gCf.endLoadData();
    }

    public void dNg() {
        this.nkz.setNextPage(this.gCf);
        this.gCf.hideEmptyView();
        this.gCf.getView().setPadding(0, 0, 0, 0);
        this.gCf.showLoading();
    }

    private boolean cts() {
        if (this.gLj != null) {
            return this.gLj.isViewAttached();
        }
        return false;
    }

    public void hideLoadingView() {
        if (this.gLj != null) {
            this.gLj.dettachView(this.nos);
            this.gLj = null;
        }
    }

    public void it(boolean z) {
        if (!cts()) {
            if (this.gLj == null) {
                this.gLj = new g(this.mPageContext.getPageActivity());
                this.gLj.setTopMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds270));
            }
            this.gLj.onChangeSkinType();
            this.gLj.attachView(this.nos, z);
        }
    }

    public void KF(int i) {
        this.nkz.setVisibility(i);
    }

    public void In(int i) {
        this.nou.setVisibility(i);
        this.nkz.setVisibility(i);
    }
}
