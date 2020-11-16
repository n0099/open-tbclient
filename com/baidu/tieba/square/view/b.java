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
/* loaded from: classes21.dex */
public class b {
    private BdListView.e VT = new BdListView.e() { // from class: com.baidu.tieba.square.view.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.mQM != null) {
                b.this.mQM.stopScroll();
            }
            if (b.this.mUT != null) {
                b.this.mUT.onScrollToBottom();
            }
        }
    };
    private PbListView giV;
    private g grV;
    private TbPageContext<?> mPageContext;
    private BdTypeRecyclerView mQM;
    private final View mRoot;
    private RelativeLayout mUN;
    private RecyclerView mUO;
    private LinearLayoutManager mUP;
    private com.baidu.tieba.square.a.a mUQ;
    private LinearLayoutManager mUR;
    private com.baidu.tieba.square.a.b mUS;
    private BdListView.e mUT;

    public b(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.mRoot = view;
        initView();
        dxy();
    }

    private void initView() {
        this.mUN = (RelativeLayout) this.mRoot.findViewById(R.id.right_container);
        this.mUO = (RecyclerView) this.mRoot.findViewById(R.id.rv_left);
        this.mQM = (BdTypeRecyclerView) this.mRoot.findViewById(R.id.rv_right);
    }

    public String dHP() {
        return this.mUQ.dIb();
    }

    public void RV(String str) {
        if (str != null) {
            int RW = this.mUQ.RW(str);
            this.mUQ.vm(RW);
            JT(RW);
        }
    }

    public void c(String str, List<String> list, boolean z) {
        int position = y.getPosition(list, str);
        this.mUQ.p(position, list);
        if (z) {
            JT(position);
        }
    }

    public void dHQ() {
        ArrayList arrayList = new ArrayList();
        z zVar = new z();
        zVar.showText = this.mPageContext.getString(R.string.forum_square_list_no_data);
        zVar.resId = R.drawable.new_pic_emotion_06;
        arrayList.add(zVar);
        this.mUS.setData(arrayList);
    }

    public void fF(List<q> list) {
        v(list, 0);
    }

    public void v(List<q> list, int i) {
        if (y.isEmpty(list)) {
            dHQ();
            return;
        }
        if (i > 0) {
            Pair<Integer, Integer> dHO = dHO();
            int intValue = ((Integer) dHO.first).intValue();
            int intValue2 = ((Integer) dHO.second).intValue();
            int i2 = intValue - i;
            if (this.mUR != null && this.mQM != null) {
                this.mQM.qR();
                this.mUR.scrollToPositionWithOffset(i2, intValue2);
                this.mQM.qS();
            }
        }
        this.mUS.setData(list);
    }

    private void dxy() {
        this.mUP = new LinearLayoutManager(this.mPageContext.getPageActivity());
        this.mUO.setLayoutManager(this.mUP);
        this.mUQ = new com.baidu.tieba.square.a.a(this.mPageContext.getPageActivity());
        this.mUO.setAdapter(this.mUQ);
        this.mUS = new com.baidu.tieba.square.a.b(this.mPageContext, this.mQM);
        this.mUR = new LinearLayoutManager(this.mPageContext.getPageActivity());
        this.mQM.setLayoutManager(this.mUR);
        this.mQM.setFadingEdgeLength(0);
        this.mQM.setOverScrollMode(2);
        this.mQM.setOnSrollToBottomListener(this.VT);
        this.giV = new PbListView(this.mPageContext.getPageActivity());
        this.giV.getView();
        this.giV.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.giV.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.giV.setLineGone();
        this.giV.setTextSize(R.dimen.tbfontsize33);
        this.giV.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.giV.setNoMoreTextColorId(R.color.CAM_X0110);
        this.giV.brI();
    }

    public void e(BdListView.e eVar) {
        this.mUT = eVar;
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.mQM != null) {
            this.mQM.removeOnScrollListener(onScrollListener);
            this.mQM.addOnScrollListener(onScrollListener);
        }
    }

    public void a(a.InterfaceC0849a interfaceC0849a) {
        if (this.mUQ != null) {
            this.mUQ.b(interfaceC0849a);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mUS != null) {
            this.mUS.notifyDataSetChanged();
        }
        if (this.mUQ != null) {
            this.mUQ.notifyDataSetChanged();
        }
        if (this.giV != null) {
            this.giV.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.giV.changeSkin(i);
        }
        if (this.grV != null) {
            this.grV.onChangeSkinType();
        }
    }

    public Pair<Integer, Integer> dHO() {
        int firstVisiblePosition = this.mQM.getFirstVisiblePosition();
        View childAt = this.mQM.getChildAt(0);
        return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(childAt != null ? childAt.getTop() : 0));
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.mQM != null && (this.mQM.getLayoutManager() instanceof LinearLayoutManager) && i <= this.mQM.getCount() - 1) {
            ((LinearLayoutManager) this.mQM.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    private void JT(int i) {
        if (this.mUO != null && (this.mUO.getLayoutManager() instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.mUO.getLayoutManager();
            if (i < 0) {
                i = 0;
            } else if (i > this.mUQ.getItemCount() - 1) {
                i = this.mUQ.getItemCount() - 1;
            }
            linearLayoutManager.scrollToPositionWithOffset(i, 0);
        }
    }

    public void bPp() {
        this.mQM.setNextPage(null);
    }

    public void dHV() {
        this.mQM.setNextPage(this.giV);
        this.giV.hideEmptyView();
        this.giV.getView().setPadding(0, 0, 0, 0);
        this.giV.setText(this.mPageContext.getPageActivity().getString(R.string.pb_load_more));
        this.giV.endLoadData();
    }

    public void dHW() {
        this.mQM.setNextPage(this.giV);
        this.giV.hideEmptyView();
        this.giV.getView().setPadding(0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds62), 0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds362));
        this.giV.setText(this.mPageContext.getPageActivity().getString(R.string.forum_square_list_has_no_more));
        this.giV.endLoadData();
    }

    public void dHX() {
        this.mQM.setNextPage(this.giV);
        this.giV.hideEmptyView();
        this.giV.getView().setPadding(0, 0, 0, 0);
        this.giV.showLoading();
    }

    private boolean cml() {
        if (this.grV != null) {
            return this.grV.isViewAttached();
        }
        return false;
    }

    public void hideLoadingView() {
        if (this.grV != null) {
            this.grV.dettachView(this.mUN);
            this.grV = null;
        }
    }

    public void hM(boolean z) {
        if (!cml()) {
            if (this.grV == null) {
                this.grV = new g(this.mPageContext.getPageActivity());
                this.grV.setTopMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds270));
            }
            this.grV.onChangeSkinType();
            this.grV.attachView(this.mUN, z);
        }
    }

    public void JU(int i) {
        this.mQM.setVisibility(i);
    }

    public void HC(int i) {
        this.mUO.setVisibility(i);
        this.mQM.setVisibility(i);
    }
}
