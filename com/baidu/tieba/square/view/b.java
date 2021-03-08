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
    private BdListView.e Yb = new BdListView.e() { // from class: com.baidu.tieba.square.view.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.nsg != null) {
                b.this.nsg.stopScroll();
            }
            if (b.this.nwg != null) {
                b.this.nwg.onScrollToBottom();
            }
        }
    };
    private PbListView gCf;
    private g gLk;
    private TbPageContext<?> mPageContext;
    private final View mRoot;
    private BdTypeRecyclerView nsg;
    private RelativeLayout nwa;
    private RecyclerView nwb;
    private LinearLayoutManager nwc;
    private LeftAdapter nwd;
    private LinearLayoutManager nwe;
    private com.baidu.tieba.square.adapter.a nwf;
    private BdListView.e nwg;

    public b(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRoot = view;
        initView();
        dBn();
    }

    private void initView() {
        this.nwa = (RelativeLayout) this.mRoot.findViewById(R.id.right_container);
        this.nwb = (RecyclerView) this.mRoot.findViewById(R.id.rv_left);
        this.nsg = (BdTypeRecyclerView) this.mRoot.findViewById(R.id.rv_right);
    }

    public String dLI() {
        return this.nwd.dLU();
    }

    public void SZ(String str) {
        if (str != null) {
            int Ta = this.nwd.Ta(str);
            this.nwd.uG(Ta);
            Jv(Ta);
        }
    }

    public void e(String str, List<String> list, boolean z) {
        int position = y.getPosition(list, str);
        this.nwd.setData(position, list);
        if (z) {
            Jv(position);
        }
    }

    public void dLJ() {
        ArrayList arrayList = new ArrayList();
        v vVar = new v();
        vVar.showText = this.mPageContext.getString(R.string.forum_square_list_no_data);
        vVar.resId = R.drawable.new_pic_emotion_06;
        arrayList.add(vVar);
        this.nwf.setData(arrayList);
    }

    public void fQ(List<n> list) {
        v(list, 0);
    }

    public void v(List<n> list, int i) {
        if (y.isEmpty(list)) {
            dLJ();
            return;
        }
        if (i > 0) {
            Pair<Integer, Integer> dLH = dLH();
            int intValue = ((Integer) dLH.first).intValue();
            int intValue2 = ((Integer) dLH.second).intValue();
            int i2 = intValue - i;
            if (this.nwe != null && this.nsg != null) {
                this.nsg.qt();
                this.nwe.scrollToPositionWithOffset(i2, intValue2);
                this.nsg.qu();
            }
        }
        this.nwf.setData(list);
    }

    private void dBn() {
        this.nwc = new LinearLayoutManager(this.mPageContext.getPageActivity());
        this.nwb.setLayoutManager(this.nwc);
        this.nwd = new LeftAdapter(this.mPageContext.getPageActivity());
        this.nwb.setAdapter(this.nwd);
        this.nwf = new com.baidu.tieba.square.adapter.a(this.mPageContext, this.nsg);
        this.nwe = new LinearLayoutManager(this.mPageContext.getPageActivity());
        this.nsg.setLayoutManager(this.nwe);
        this.nsg.setFadingEdgeLength(0);
        this.nsg.setOverScrollMode(2);
        this.nsg.setOnSrollToBottomListener(this.Yb);
        this.gCf = new PbListView(this.mPageContext.getPageActivity());
        this.gCf.getView();
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gCf.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.gCf.setLineGone();
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gCf.bug();
    }

    public void e(BdListView.e eVar) {
        this.nwg = eVar;
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.nsg != null) {
            this.nsg.removeOnScrollListener(onScrollListener);
            this.nsg.addOnScrollListener(onScrollListener);
        }
    }

    public void a(LeftAdapter.a aVar) {
        if (this.nwd != null) {
            this.nwd.b(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.nwf != null) {
            this.nwf.notifyDataSetChanged();
        }
        if (this.nwd != null) {
            this.nwd.notifyDataSetChanged();
        }
        if (this.gCf != null) {
            this.gCf.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gCf.changeSkin(i);
        }
        if (this.gLk != null) {
            this.gLk.onChangeSkinType();
        }
    }

    public Pair<Integer, Integer> dLH() {
        int firstVisiblePosition = this.nsg.getFirstVisiblePosition();
        View childAt = this.nsg.getChildAt(0);
        return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(childAt != null ? childAt.getTop() : 0));
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.nsg != null && (this.nsg.getLayoutManager() instanceof LinearLayoutManager) && i <= this.nsg.getCount() - 1) {
            ((LinearLayoutManager) this.nsg.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    private void Jv(int i) {
        if (this.nwb != null && (this.nwb.getLayoutManager() instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.nwb.getLayoutManager();
            if (i < 0) {
                i = 0;
            } else if (i > this.nwd.getItemCount() - 1) {
                i = this.nwd.getItemCount() - 1;
            }
            linearLayoutManager.scrollToPositionWithOffset(i, 0);
        }
    }

    public void bSE() {
        this.nsg.setNextPage(null);
    }

    public void dLO() {
        this.nsg.setNextPage(this.gCf);
        this.gCf.hideEmptyView();
        this.gCf.getView().setPadding(0, 0, 0, 0);
        this.gCf.setText(this.mPageContext.getPageActivity().getString(R.string.pb_load_more));
        this.gCf.endLoadData();
    }

    public void dLP() {
        this.nsg.setNextPage(this.gCf);
        this.gCf.hideEmptyView();
        this.gCf.getView().setPadding(0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds62), 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds362));
        this.gCf.setText(this.mPageContext.getPageActivity().getString(R.string.forum_square_list_has_no_more));
        this.gCf.endLoadData();
    }

    public void dLQ() {
        this.nsg.setNextPage(this.gCf);
        this.gCf.hideEmptyView();
        this.gCf.getView().setPadding(0, 0, 0, 0);
        this.gCf.showLoading();
    }

    private boolean cqY() {
        if (this.gLk != null) {
            return this.gLk.isViewAttached();
        }
        return false;
    }

    public void hideLoadingView() {
        if (this.gLk != null) {
            this.gLk.dettachView(this.nwa);
            this.gLk = null;
        }
    }

    public void ir(boolean z) {
        if (!cqY()) {
            if (this.gLk == null) {
                this.gLk = new g(this.mPageContext.getPageActivity());
                this.gLk.setTopMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds270));
            }
            this.gLk.onChangeSkinType();
            this.gLk.attachView(this.nwa, z);
        }
    }

    public void Jw(int i) {
        this.nsg.setVisibility(i);
    }

    public void Hb(int i) {
        this.nwb.setVisibility(i);
        this.nsg.setVisibility(i);
    }
}
