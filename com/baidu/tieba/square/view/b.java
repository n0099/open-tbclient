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
/* loaded from: classes16.dex */
public class b {
    private BdListView.e Vh = new BdListView.e() { // from class: com.baidu.tieba.square.view.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.lYh != null) {
                b.this.lYh.stopScroll();
            }
            if (b.this.mck != null) {
                b.this.mck.onScrollToBottom();
            }
        }
    };
    private PbListView fEa;
    private g fMR;
    private BdTypeRecyclerView lYh;
    private TbPageContext<?> mPageContext;
    private final View mRoot;
    private RelativeLayout mce;
    private RecyclerView mcf;
    private LinearLayoutManager mcg;
    private com.baidu.tieba.square.a.a mch;
    private LinearLayoutManager mci;
    private com.baidu.tieba.square.a.b mcj;
    private BdListView.e mck;

    public b(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRoot = view;
        initView();
        dkX();
    }

    private void initView() {
        this.mce = (RelativeLayout) this.mRoot.findViewById(R.id.right_container);
        this.mcf = (RecyclerView) this.mRoot.findViewById(R.id.rv_left);
        this.lYh = (BdTypeRecyclerView) this.mRoot.findViewById(R.id.rv_right);
    }

    public String duK() {
        return this.mch.duW();
    }

    public void Qq(String str) {
        if (str != null) {
            int Qr = this.mch.Qr(str);
            this.mch.Hy(Qr);
            HD(Qr);
        }
    }

    public void c(String str, List<String> list, boolean z) {
        int position = y.getPosition(list, str);
        this.mch.p(position, list);
        if (z) {
            HD(position);
        }
    }

    public void duL() {
        ArrayList arrayList = new ArrayList();
        z zVar = new z();
        zVar.showText = this.mPageContext.getString(R.string.forum_square_list_no_data);
        zVar.resId = R.drawable.new_pic_emotion_06;
        arrayList.add(zVar);
        this.mcj.setData(arrayList);
    }

    public void fc(List<q> list) {
        s(list, 0);
    }

    public void s(List<q> list, int i) {
        if (y.isEmpty(list)) {
            duL();
            return;
        }
        if (i > 0) {
            Pair<Integer, Integer> duJ = duJ();
            int intValue = ((Integer) duJ.first).intValue();
            int intValue2 = ((Integer) duJ.second).intValue();
            int i2 = intValue - i;
            if (this.mci != null && this.lYh != null) {
                this.lYh.qM();
                this.mci.scrollToPositionWithOffset(i2, intValue2);
                this.lYh.qN();
            }
        }
        this.mcj.setData(list);
    }

    private void dkX() {
        this.mcg = new LinearLayoutManager(this.mPageContext.getPageActivity());
        this.mcf.setLayoutManager(this.mcg);
        this.mch = new com.baidu.tieba.square.a.a(this.mPageContext.getPageActivity());
        this.mcf.setAdapter(this.mch);
        this.mcj = new com.baidu.tieba.square.a.b(this.mPageContext, this.lYh);
        this.mci = new LinearLayoutManager(this.mPageContext.getPageActivity());
        this.lYh.setLayoutManager(this.mci);
        this.lYh.setFadingEdgeLength(0);
        this.lYh.setOverScrollMode(2);
        this.lYh.setOnSrollToBottomListener(this.Vh);
        this.fEa = new PbListView(this.mPageContext.getPageActivity());
        this.fEa.getView();
        this.fEa.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fEa.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.fEa.setLineGone();
        this.fEa.setTextSize(R.dimen.tbfontsize33);
        this.fEa.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fEa.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fEa.bkv();
    }

    public void e(BdListView.e eVar) {
        this.mck = eVar;
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.lYh != null) {
            this.lYh.removeOnScrollListener(onScrollListener);
            this.lYh.addOnScrollListener(onScrollListener);
        }
    }

    public void a(a.InterfaceC0801a interfaceC0801a) {
        if (this.mch != null) {
            this.mch.b(interfaceC0801a);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mcj != null) {
            this.mcj.notifyDataSetChanged();
        }
        if (this.mch != null) {
            this.mch.notifyDataSetChanged();
        }
        if (this.fEa != null) {
            this.fEa.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fEa.changeSkin(i);
        }
        if (this.fMR != null) {
            this.fMR.onChangeSkinType();
        }
    }

    public Pair<Integer, Integer> duJ() {
        int firstVisiblePosition = this.lYh.getFirstVisiblePosition();
        View childAt = this.lYh.getChildAt(0);
        return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(childAt != null ? childAt.getTop() : 0));
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.lYh != null && (this.lYh.getLayoutManager() instanceof LinearLayoutManager) && i <= this.lYh.getCount() - 1) {
            ((LinearLayoutManager) this.lYh.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    private void HD(int i) {
        if (this.mcf != null && (this.mcf.getLayoutManager() instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.mcf.getLayoutManager();
            if (i < 0) {
                i = 0;
            } else if (i > this.mch.getItemCount() - 1) {
                i = this.mch.getItemCount() - 1;
            }
            linearLayoutManager.scrollToPositionWithOffset(i, 0);
        }
    }

    public void bGU() {
        this.lYh.setNextPage(null);
    }

    public void duQ() {
        this.lYh.setNextPage(this.fEa);
        this.fEa.hideEmptyView();
        this.fEa.getView().setPadding(0, 0, 0, 0);
        this.fEa.setText(this.mPageContext.getPageActivity().getString(R.string.pb_load_more));
        this.fEa.endLoadData();
    }

    public void duR() {
        this.lYh.setNextPage(this.fEa);
        this.fEa.hideEmptyView();
        this.fEa.getView().setPadding(0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds62), 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds362));
        this.fEa.setText(this.mPageContext.getPageActivity().getString(R.string.forum_square_list_has_no_more));
        this.fEa.endLoadData();
    }

    public void duS() {
        this.lYh.setNextPage(this.fEa);
        this.fEa.hideEmptyView();
        this.fEa.getView().setPadding(0, 0, 0, 0);
        this.fEa.showLoading();
    }

    private boolean cgw() {
        if (this.fMR != null) {
            return this.fMR.isViewAttached();
        }
        return false;
    }

    public void hideLoadingView() {
        if (this.fMR != null) {
            this.fMR.dettachView(this.mce);
            this.fMR = null;
        }
    }

    public void gT(boolean z) {
        if (!cgw()) {
            if (this.fMR == null) {
                this.fMR = new g(this.mPageContext.getPageActivity());
                this.fMR.setTopMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds270));
            }
            this.fMR.onChangeSkinType();
            this.fMR.attachView(this.mce, z);
        }
    }

    public void HE(int i) {
        this.lYh.setVisibility(i);
    }

    public void Fr(int i) {
        this.mcf.setVisibility(i);
        this.lYh.setVisibility(i);
    }
}
