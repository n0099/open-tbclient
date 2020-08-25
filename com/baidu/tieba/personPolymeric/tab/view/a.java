package com.baidu.tieba.personPolymeric.tab.view;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.a.n;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment;
import java.util.List;
/* loaded from: classes18.dex */
public class a {
    private BdTypeRecyclerView Wu;
    private TbPageContext efn;
    private PbListView fDW;
    private n loJ;
    private PersonCenterTabBaseFragment loK;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tbadk.n.b kDe = null;
    private int mSubType = 1010;

    public a(TbPageContext tbPageContext, View view, PersonCenterTabBaseFragment personCenterTabBaseFragment) {
        this.efn = tbPageContext;
        this.mRootView = view;
        this.loK = personCenterTabBaseFragment;
        initUI();
    }

    private void initUI() {
        this.Wu = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.new_person_center_common_lv);
        this.Wu.setLayoutManager(new LinearLayoutManager(this.Wu.getContext()) { // from class: com.baidu.tieba.personPolymeric.tab.view.a.1
            @Override // android.support.v7.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
                return false;
            }

            @Override // android.support.v7.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
                return false;
            }
        });
        this.Wu.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.a.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (a.this.kDe == null) {
                    a.this.kDe = new com.baidu.tbadk.n.b();
                    a.this.kDe.setSubType(a.this.mSubType);
                }
                if (i == 0) {
                    a.this.kDe.bue();
                } else {
                    a.this.kDe.bud();
                }
            }
        });
        this.fDW = new PbListView(this.efn.getPageActivity());
        this.fDW.createView();
        this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fDW.setHeight(l.getDimens(this.efn.getPageActivity(), R.dimen.tbds182));
        this.fDW.setLineGone();
        this.fDW.setTextSize(R.dimen.tbfontsize33);
        this.fDW.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fDW.setNoMoreTextColorId(R.color.cp_cont_e);
        this.loJ = new n(this.efn, this.Wu, this.loK.getUniqueId());
        this.loJ.setIsHost(this.loK.isHost());
        this.loJ.Fo(32);
        int i = 0;
        if (this.loK.isHost()) {
            if (this.loK instanceof PersonCenterDynamicTabFragment) {
                i = 4;
            } else if (this.loK instanceof PersonCenterThreadTabFragment) {
                i = 6;
            }
        }
        this.loJ.Fp(i);
        this.loJ.setTabType(this.loK.getTabType());
    }

    public void addHeaderView(View view) {
        this.Wu.addHeaderView(view);
    }

    public void b(BdListView.e eVar) {
        this.Wu.setOnSrollToBottomListener(eVar);
    }

    public void onDestroy() {
        if (this.kDe != null) {
            this.kDe.buf();
        }
        this.Wu.setOnSrollToBottomListener(null);
    }

    public void eR(List<q> list) {
        if (y.isEmpty(list)) {
            bGT();
            if (this.Wu.getHeaderViewsCount() == 0) {
                Bd(R.string.person_center_listempty_txt);
            }
        } else if (this.mNoDataView != null && this.mNoDataView.getParent() != null) {
            this.Wu.removeHeaderView(this.mNoDataView);
        }
        this.Wu.setData(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.loK.getTabType())));
    }

    private void Bd(int i) {
        String string;
        if (this.loK.getTabType() == 1) {
            string = this.loK.getResources().getString(R.string.person_center_listempty_dynamic_txt);
        } else {
            string = this.loK.getResources().getString(R.string.person_center_listempty_thread_txt);
        }
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.efn.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.d.dE(null, string), null);
        }
        this.mNoDataView.onChangeSkinType(this.efn, TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.Wu.removeHeaderView(this.mNoDataView);
        this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.Wu.addHeaderView(this.mNoDataView);
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        if (this.loJ != null) {
            this.loJ.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.efn, i);
        }
        if (this.fDW != null) {
            this.fDW.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fDW.changeSkin(i);
        }
    }

    public n djk() {
        return this.loJ;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void bGR() {
        this.Wu.setNextPage(this.fDW);
        this.fDW.showEmptyView(0);
        this.fDW.startLoadData();
    }

    public void bGS() {
        this.Wu.setNextPage(this.fDW);
        this.fDW.showEmptyView(0);
        this.fDW.endLoadData();
        this.fDW.setText(this.efn.getString(R.string.list_no_more));
    }

    public void bGT() {
        this.Wu.setNextPage(null);
    }

    public void clz() {
        this.Wu.smoothScrollToPosition(0);
    }

    public void Fw(int i) {
        this.Wu.setNextPage(this.fDW);
        this.fDW.showEmptyView(0);
        this.fDW.endLoadData();
        this.fDW.setText(this.efn.getString(i));
    }

    public void setSubType(int i) {
        this.mSubType = i;
    }
}
