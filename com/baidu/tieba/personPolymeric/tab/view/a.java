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
/* loaded from: classes23.dex */
public class a {
    private BdTypeRecyclerView WM;
    private TbPageContext ehG;
    private PbListView fHm;
    private n lxM;
    private PersonCenterTabBaseFragment lxN;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tbadk.n.b kLJ = null;
    private int mSubType = 1010;

    public a(TbPageContext tbPageContext, View view, PersonCenterTabBaseFragment personCenterTabBaseFragment) {
        this.ehG = tbPageContext;
        this.mRootView = view;
        this.lxN = personCenterTabBaseFragment;
        initUI();
    }

    private void initUI() {
        this.WM = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.new_person_center_common_lv);
        this.WM.setLayoutManager(new LinearLayoutManager(this.WM.getContext()) { // from class: com.baidu.tieba.personPolymeric.tab.view.a.1
            @Override // android.support.v7.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
                return false;
            }

            @Override // android.support.v7.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
                return false;
            }
        });
        this.WM.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.a.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (a.this.kLJ == null) {
                    a.this.kLJ = new com.baidu.tbadk.n.b();
                    a.this.kLJ.setSubType(a.this.mSubType);
                }
                if (i == 0) {
                    a.this.kLJ.bvj();
                } else {
                    a.this.kLJ.bvi();
                }
            }
        });
        this.fHm = new PbListView(this.ehG.getPageActivity());
        this.fHm.createView();
        this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fHm.setHeight(l.getDimens(this.ehG.getPageActivity(), R.dimen.tbds182));
        this.fHm.setLineGone();
        this.fHm.setTextSize(R.dimen.tbfontsize33);
        this.fHm.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fHm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.lxM = new n(this.ehG, this.WM, this.lxN.getUniqueId());
        this.lxM.setIsHost(this.lxN.isHost());
        this.lxM.FP(32);
        int i = 0;
        if (this.lxN.isHost()) {
            if (this.lxN instanceof PersonCenterDynamicTabFragment) {
                i = 4;
            } else if (this.lxN instanceof PersonCenterThreadTabFragment) {
                i = 6;
            }
        }
        this.lxM.FQ(i);
        this.lxM.setTabType(this.lxN.getTabType());
    }

    public void addHeaderView(View view) {
        this.WM.addHeaderView(view);
    }

    public void b(BdListView.e eVar) {
        this.WM.setOnSrollToBottomListener(eVar);
    }

    public void onDestroy() {
        if (this.kLJ != null) {
            this.kLJ.bvk();
        }
        this.WM.setOnSrollToBottomListener(null);
    }

    public void eZ(List<q> list) {
        if (y.isEmpty(list)) {
            bIk();
            if (this.WM.getHeaderViewsCount() == 0) {
                BE(R.string.person_center_listempty_txt);
            }
        } else if (this.mNoDataView != null && this.mNoDataView.getParent() != null) {
            this.WM.removeHeaderView(this.mNoDataView);
        }
        this.WM.setData(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.lxN.getTabType())));
    }

    private void BE(int i) {
        String string;
        if (this.lxN.getTabType() == 1) {
            string = this.lxN.getResources().getString(R.string.person_center_listempty_dynamic_txt);
        } else {
            string = this.lxN.getResources().getString(R.string.person_center_listempty_thread_txt);
        }
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ehG.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.d.dG(null, string), null);
        }
        this.mNoDataView.onChangeSkinType(this.ehG, TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.WM.removeHeaderView(this.mNoDataView);
        this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.WM.addHeaderView(this.mNoDataView);
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        if (this.lxM != null) {
            this.lxM.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.ehG, i);
        }
        if (this.fHm != null) {
            this.fHm.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fHm.changeSkin(i);
        }
    }

    public n dmS() {
        return this.lxM;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void bIi() {
        this.WM.setNextPage(this.fHm);
        this.fHm.showEmptyView(0);
        this.fHm.startLoadData();
    }

    public void bIj() {
        this.WM.setNextPage(this.fHm);
        this.fHm.showEmptyView(0);
        this.fHm.endLoadData();
        this.fHm.setText(this.ehG.getString(R.string.list_no_more));
    }

    public void bIk() {
        this.WM.setNextPage(null);
    }

    public void coM() {
        this.WM.smoothScrollToPosition(0);
    }

    public void FX(int i) {
        this.WM.setNextPage(this.fHm);
        this.fHm.showEmptyView(0);
        this.fHm.endLoadData();
        this.fHm.setText(this.ehG.getString(i));
    }

    public void setSubType(int i) {
        this.mSubType = i;
    }
}
