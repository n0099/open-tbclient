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
            if (b.this.npC != null) {
                b.this.npC.stopScroll();
            }
            if (b.this.ntB != null) {
                b.this.ntB.onScrollToBottom();
            }
        }
    };
    private PbListView gAi;
    private g gJn;
    private TbPageContext<?> mPageContext;
    private final View mRoot;
    private BdTypeRecyclerView npC;
    private com.baidu.tieba.square.adapter.a ntA;
    private BdListView.e ntB;
    private RelativeLayout ntv;
    private RecyclerView ntw;
    private LinearLayoutManager ntx;
    private LeftAdapter nty;
    private LinearLayoutManager ntz;

    public b(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRoot = view;
        initView();
        dAY();
    }

    private void initView() {
        this.ntv = (RelativeLayout) this.mRoot.findViewById(R.id.right_container);
        this.ntw = (RecyclerView) this.mRoot.findViewById(R.id.rv_left);
        this.npC = (BdTypeRecyclerView) this.mRoot.findViewById(R.id.rv_right);
    }

    public String dLs() {
        return this.nty.dLE();
    }

    public void SH(String str) {
        if (str != null) {
            int SI = this.nty.SI(str);
            this.nty.uE(SI);
            Jr(SI);
        }
    }

    public void e(String str, List<String> list, boolean z) {
        int position = y.getPosition(list, str);
        this.nty.setData(position, list);
        if (z) {
            Jr(position);
        }
    }

    public void dLt() {
        ArrayList arrayList = new ArrayList();
        v vVar = new v();
        vVar.showText = this.mPageContext.getString(R.string.forum_square_list_no_data);
        vVar.resId = R.drawable.new_pic_emotion_06;
        arrayList.add(vVar);
        this.ntA.setData(arrayList);
    }

    public void fQ(List<n> list) {
        v(list, 0);
    }

    public void v(List<n> list, int i) {
        if (y.isEmpty(list)) {
            dLt();
            return;
        }
        if (i > 0) {
            Pair<Integer, Integer> dLr = dLr();
            int intValue = ((Integer) dLr.first).intValue();
            int intValue2 = ((Integer) dLr.second).intValue();
            int i2 = intValue - i;
            if (this.ntz != null && this.npC != null) {
                this.npC.qt();
                this.ntz.scrollToPositionWithOffset(i2, intValue2);
                this.npC.qu();
            }
        }
        this.ntA.setData(list);
    }

    private void dAY() {
        this.ntx = new LinearLayoutManager(this.mPageContext.getPageActivity());
        this.ntw.setLayoutManager(this.ntx);
        this.nty = new LeftAdapter(this.mPageContext.getPageActivity());
        this.ntw.setAdapter(this.nty);
        this.ntA = new com.baidu.tieba.square.adapter.a(this.mPageContext, this.npC);
        this.ntz = new LinearLayoutManager(this.mPageContext.getPageActivity());
        this.npC.setLayoutManager(this.ntz);
        this.npC.setFadingEdgeLength(0);
        this.npC.setOverScrollMode(2);
        this.npC.setOnSrollToBottomListener(this.WH);
        this.gAi = new PbListView(this.mPageContext.getPageActivity());
        this.gAi.getView();
        this.gAi.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gAi.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.gAi.setLineGone();
        this.gAi.setTextSize(R.dimen.tbfontsize33);
        this.gAi.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gAi.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gAi.bud();
    }

    public void e(BdListView.e eVar) {
        this.ntB = eVar;
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.npC != null) {
            this.npC.removeOnScrollListener(onScrollListener);
            this.npC.addOnScrollListener(onScrollListener);
        }
    }

    public void a(LeftAdapter.a aVar) {
        if (this.nty != null) {
            this.nty.b(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ntA != null) {
            this.ntA.notifyDataSetChanged();
        }
        if (this.nty != null) {
            this.nty.notifyDataSetChanged();
        }
        if (this.gAi != null) {
            this.gAi.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gAi.changeSkin(i);
        }
        if (this.gJn != null) {
            this.gJn.onChangeSkinType();
        }
    }

    public Pair<Integer, Integer> dLr() {
        int firstVisiblePosition = this.npC.getFirstVisiblePosition();
        View childAt = this.npC.getChildAt(0);
        return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(childAt != null ? childAt.getTop() : 0));
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.npC != null && (this.npC.getLayoutManager() instanceof LinearLayoutManager) && i <= this.npC.getCount() - 1) {
            ((LinearLayoutManager) this.npC.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    private void Jr(int i) {
        if (this.ntw != null && (this.ntw.getLayoutManager() instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.ntw.getLayoutManager();
            if (i < 0) {
                i = 0;
            } else if (i > this.nty.getItemCount() - 1) {
                i = this.nty.getItemCount() - 1;
            }
            linearLayoutManager.scrollToPositionWithOffset(i, 0);
        }
    }

    public void bSr() {
        this.npC.setNextPage(null);
    }

    public void dLy() {
        this.npC.setNextPage(this.gAi);
        this.gAi.hideEmptyView();
        this.gAi.getView().setPadding(0, 0, 0, 0);
        this.gAi.setText(this.mPageContext.getPageActivity().getString(R.string.pb_load_more));
        this.gAi.endLoadData();
    }

    public void dLz() {
        this.npC.setNextPage(this.gAi);
        this.gAi.hideEmptyView();
        this.gAi.getView().setPadding(0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds62), 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds362));
        this.gAi.setText(this.mPageContext.getPageActivity().getString(R.string.forum_square_list_has_no_more));
        this.gAi.endLoadData();
    }

    public void dLA() {
        this.npC.setNextPage(this.gAi);
        this.gAi.hideEmptyView();
        this.gAi.getView().setPadding(0, 0, 0, 0);
        this.gAi.showLoading();
    }

    private boolean cqL() {
        if (this.gJn != null) {
            return this.gJn.isViewAttached();
        }
        return false;
    }

    public void hideLoadingView() {
        if (this.gJn != null) {
            this.gJn.dettachView(this.ntv);
            this.gJn = null;
        }
    }

    public void ir(boolean z) {
        if (!cqL()) {
            if (this.gJn == null) {
                this.gJn = new g(this.mPageContext.getPageActivity());
                this.gJn.setTopMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds270));
            }
            this.gJn.onChangeSkinType();
            this.gJn.attachView(this.ntv, z);
        }
    }

    public void Js(int i) {
        this.npC.setVisibility(i);
    }

    public void GY(int i) {
        this.ntw.setVisibility(i);
        this.npC.setVisibility(i);
    }
}
