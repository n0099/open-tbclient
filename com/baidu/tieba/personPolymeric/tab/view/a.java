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
    private TbPageContext efr;
    private PbListView fEa;
    private n loU;
    private PersonCenterTabBaseFragment loV;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tbadk.n.b kDl = null;
    private int mSubType = 1010;

    public a(TbPageContext tbPageContext, View view, PersonCenterTabBaseFragment personCenterTabBaseFragment) {
        this.efr = tbPageContext;
        this.mRootView = view;
        this.loV = personCenterTabBaseFragment;
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
                if (a.this.kDl == null) {
                    a.this.kDl = new com.baidu.tbadk.n.b();
                    a.this.kDl.setSubType(a.this.mSubType);
                }
                if (i == 0) {
                    a.this.kDl.buf();
                } else {
                    a.this.kDl.bue();
                }
            }
        });
        this.fEa = new PbListView(this.efr.getPageActivity());
        this.fEa.createView();
        this.fEa.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fEa.setHeight(l.getDimens(this.efr.getPageActivity(), R.dimen.tbds182));
        this.fEa.setLineGone();
        this.fEa.setTextSize(R.dimen.tbfontsize33);
        this.fEa.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fEa.setNoMoreTextColorId(R.color.cp_cont_e);
        this.loU = new n(this.efr, this.Wu, this.loV.getUniqueId());
        this.loU.setIsHost(this.loV.isHost());
        this.loU.Fo(32);
        int i = 0;
        if (this.loV.isHost()) {
            if (this.loV instanceof PersonCenterDynamicTabFragment) {
                i = 4;
            } else if (this.loV instanceof PersonCenterThreadTabFragment) {
                i = 6;
            }
        }
        this.loU.Fp(i);
        this.loU.setTabType(this.loV.getTabType());
    }

    public void addHeaderView(View view) {
        this.Wu.addHeaderView(view);
    }

    public void b(BdListView.e eVar) {
        this.Wu.setOnSrollToBottomListener(eVar);
    }

    public void onDestroy() {
        if (this.kDl != null) {
            this.kDl.bug();
        }
        this.Wu.setOnSrollToBottomListener(null);
    }

    public void eR(List<q> list) {
        if (y.isEmpty(list)) {
            bGU();
            if (this.Wu.getHeaderViewsCount() == 0) {
                Bd(R.string.person_center_listempty_txt);
            }
        } else if (this.mNoDataView != null && this.mNoDataView.getParent() != null) {
            this.Wu.removeHeaderView(this.mNoDataView);
        }
        this.Wu.setData(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.loV.getTabType())));
    }

    private void Bd(int i) {
        String string;
        if (this.loV.getTabType() == 1) {
            string = this.loV.getResources().getString(R.string.person_center_listempty_dynamic_txt);
        } else {
            string = this.loV.getResources().getString(R.string.person_center_listempty_thread_txt);
        }
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.efr.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.d.dE(null, string), null);
        }
        this.mNoDataView.onChangeSkinType(this.efr, TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.Wu.removeHeaderView(this.mNoDataView);
        this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.Wu.addHeaderView(this.mNoDataView);
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        if (this.loU != null) {
            this.loU.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.efr, i);
        }
        if (this.fEa != null) {
            this.fEa.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fEa.changeSkin(i);
        }
    }

    public n djn() {
        return this.loU;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void bGS() {
        this.Wu.setNextPage(this.fEa);
        this.fEa.showEmptyView(0);
        this.fEa.startLoadData();
    }

    public void bGT() {
        this.Wu.setNextPage(this.fEa);
        this.fEa.showEmptyView(0);
        this.fEa.endLoadData();
        this.fEa.setText(this.efr.getString(R.string.list_no_more));
    }

    public void bGU() {
        this.Wu.setNextPage(null);
    }

    public void clA() {
        this.Wu.smoothScrollToPosition(0);
    }

    public void Fw(int i) {
        this.Wu.setNextPage(this.fEa);
        this.fEa.showEmptyView(0);
        this.fEa.endLoadData();
        this.fEa.setText(this.efr.getString(i));
    }

    public void setSubType(int i) {
        this.mSubType = i;
    }
}
