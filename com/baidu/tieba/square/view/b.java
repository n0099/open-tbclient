package com.baidu.tieba.square.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.k.g;
import com.baidu.tieba.R;
import com.baidu.tieba.square.a.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class b {
    private BdListView.e VQ = new BdListView.e() { // from class: com.baidu.tieba.square.view.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.mxm != null) {
                b.this.mxm.stopScroll();
            }
            if (b.this.mBm != null) {
                b.this.mBm.onScrollToBottom();
            }
        }
    };
    private PbListView fTv;
    private g gcx;
    private RelativeLayout mBf;
    private RecyclerView mBh;
    private LinearLayoutManager mBi;
    private com.baidu.tieba.square.a.a mBj;
    private LinearLayoutManager mBk;
    private com.baidu.tieba.square.a.b mBl;
    private BdListView.e mBm;
    private TbPageContext<?> mPageContext;
    private final View mRoot;
    private BdTypeRecyclerView mxm;

    public b(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRoot = view;
        initView();
        dsp();
    }

    private void initView() {
        this.mBf = (RelativeLayout) this.mRoot.findViewById(R.id.right_container);
        this.mBh = (RecyclerView) this.mRoot.findViewById(R.id.rv_left);
        this.mxm = (BdTypeRecyclerView) this.mRoot.findViewById(R.id.rv_right);
    }

    public String dCo() {
        return this.mBj.dCA();
    }

    public void RE(String str) {
        if (str != null) {
            int RF = this.mBj.RF(str);
            this.mBj.IH(RF);
            IM(RF);
        }
    }

    public void c(String str, List<String> list, boolean z) {
        int position = y.getPosition(list, str);
        this.mBj.p(position, list);
        if (z) {
            IM(position);
        }
    }

    public void dCp() {
        ArrayList arrayList = new ArrayList();
        z zVar = new z();
        zVar.showText = this.mPageContext.getString(R.string.forum_square_list_no_data);
        zVar.resId = R.drawable.new_pic_emotion_06;
        arrayList.add(zVar);
        this.mBl.setData(arrayList);
    }

    public void fo(List<q> list) {
        u(list, 0);
    }

    public void u(List<q> list, int i) {
        if (y.isEmpty(list)) {
            dCp();
            return;
        }
        if (i > 0) {
            Pair<Integer, Integer> dCn = dCn();
            int intValue = ((Integer) dCn.first).intValue();
            int intValue2 = ((Integer) dCn.second).intValue();
            int i2 = intValue - i;
            if (this.mBk != null && this.mxm != null) {
                this.mxm.qR();
                this.mBk.scrollToPositionWithOffset(i2, intValue2);
                this.mxm.qS();
            }
        }
        this.mBl.setData(list);
    }

    private void dsp() {
        this.mBi = new LinearLayoutManager(this.mPageContext.getPageActivity());
        this.mBh.setLayoutManager(this.mBi);
        this.mBj = new com.baidu.tieba.square.a.a(this.mPageContext.getPageActivity());
        this.mBh.setAdapter(this.mBj);
        this.mBl = new com.baidu.tieba.square.a.b(this.mPageContext, this.mxm);
        this.mBk = new LinearLayoutManager(this.mPageContext.getPageActivity());
        this.mxm.setLayoutManager(this.mBk);
        this.mxm.setFadingEdgeLength(0);
        this.mxm.setOverScrollMode(2);
        this.mxm.setOnSrollToBottomListener(this.VQ);
        this.fTv = new PbListView(this.mPageContext.getPageActivity());
        this.fTv.getView();
        this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fTv.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.fTv.setLineGone();
        this.fTv.setTextSize(R.dimen.tbfontsize33);
        this.fTv.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fTv.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fTv.boa();
    }

    public void e(BdListView.e eVar) {
        this.mBm = eVar;
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.mxm != null) {
            this.mxm.removeOnScrollListener(onScrollListener);
            this.mxm.addOnScrollListener(onScrollListener);
        }
    }

    public void a(a.InterfaceC0816a interfaceC0816a) {
        if (this.mBj != null) {
            this.mBj.b(interfaceC0816a);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mBl != null) {
            this.mBl.notifyDataSetChanged();
        }
        if (this.mBj != null) {
            this.mBj.notifyDataSetChanged();
        }
        if (this.fTv != null) {
            this.fTv.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fTv.changeSkin(i);
        }
        if (this.gcx != null) {
            this.gcx.onChangeSkinType();
        }
    }

    public Pair<Integer, Integer> dCn() {
        int firstVisiblePosition = this.mxm.getFirstVisiblePosition();
        View childAt = this.mxm.getChildAt(0);
        return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(childAt != null ? childAt.getTop() : 0));
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.mxm != null && (this.mxm.getLayoutManager() instanceof LinearLayoutManager) && i <= this.mxm.getCount() - 1) {
            ((LinearLayoutManager) this.mxm.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    private void IM(int i) {
        if (this.mBh != null && (this.mBh.getLayoutManager() instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.mBh.getLayoutManager();
            if (i < 0) {
                i = 0;
            } else if (i > this.mBj.getItemCount() - 1) {
                i = this.mBj.getItemCount() - 1;
            }
            linearLayoutManager.scrollToPositionWithOffset(i, 0);
        }
    }

    public void bKU() {
        this.mxm.setNextPage(null);
    }

    public void dCu() {
        this.mxm.setNextPage(this.fTv);
        this.fTv.hideEmptyView();
        this.fTv.getView().setPadding(0, 0, 0, 0);
        this.fTv.setText(this.mPageContext.getPageActivity().getString(R.string.pb_load_more));
        this.fTv.endLoadData();
    }

    public void dCv() {
        this.mxm.setNextPage(this.fTv);
        this.fTv.hideEmptyView();
        this.fTv.getView().setPadding(0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds62), 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds362));
        this.fTv.setText(this.mPageContext.getPageActivity().getString(R.string.forum_square_list_has_no_more));
        this.fTv.endLoadData();
    }

    public void dCw() {
        this.mxm.setNextPage(this.fTv);
        this.fTv.hideEmptyView();
        this.fTv.getView().setPadding(0, 0, 0, 0);
        this.fTv.showLoading();
    }

    private boolean cha() {
        if (this.gcx != null) {
            return this.gcx.isViewAttached();
        }
        return false;
    }

    public void hideLoadingView() {
        if (this.gcx != null) {
            this.gcx.dettachView(this.mBf);
            this.gcx = null;
        }
    }

    public void hn(boolean z) {
        if (!cha()) {
            if (this.gcx == null) {
                this.gcx = new g(this.mPageContext.getPageActivity());
                this.gcx.setTopMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds270));
            }
            this.gcx.onChangeSkinType();
            this.gcx.attachView(this.mBf, z);
        }
    }

    public void IN(int i) {
        this.mxm.setVisibility(i);
    }

    public void Gy(int i) {
        this.mBh.setVisibility(i);
        this.mxm.setVisibility(i);
    }
}
