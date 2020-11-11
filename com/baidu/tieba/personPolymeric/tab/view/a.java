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
/* loaded from: classes24.dex */
public class a {
    private BdTypeRecyclerView Xe;
    private TbPageContext eIc;
    private PbListView gjo;
    private NoDataView mNoDataView;
    private View mRootView;
    private n mfy;
    private PersonCenterTabBaseFragment mfz;
    private com.baidu.tbadk.n.b ltv = null;
    private int mSubType = 1010;

    public a(TbPageContext tbPageContext, View view, PersonCenterTabBaseFragment personCenterTabBaseFragment) {
        this.eIc = tbPageContext;
        this.mRootView = view;
        this.mfz = personCenterTabBaseFragment;
        initUI();
    }

    private void initUI() {
        this.Xe = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.new_person_center_common_lv);
        this.Xe.setLayoutManager(new LinearLayoutManager(this.Xe.getContext()) { // from class: com.baidu.tieba.personPolymeric.tab.view.a.1
            @Override // android.support.v7.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
                return false;
            }

            @Override // android.support.v7.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
                return false;
            }
        });
        this.Xe.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.a.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (a.this.ltv == null) {
                    a.this.ltv = new com.baidu.tbadk.n.b();
                    a.this.ltv.setSubType(a.this.mSubType);
                }
                if (i == 0) {
                    a.this.ltv.bCl();
                } else {
                    a.this.ltv.bCk();
                }
            }
        });
        this.gjo = new PbListView(this.eIc.getPageActivity());
        this.gjo.createView();
        this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gjo.setHeight(l.getDimens(this.eIc.getPageActivity(), R.dimen.tbds182));
        this.gjo.setLineGone();
        this.gjo.setTextSize(R.dimen.tbfontsize33);
        this.gjo.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.gjo.setNoMoreTextColorId(R.color.cp_cont_e);
        this.mfy = new n(this.eIc, this.Xe, this.mfz.getUniqueId());
        this.mfy.setIsHost(this.mfz.isHost());
        this.mfy.Hb(32);
        int i = 0;
        if (this.mfz.isHost()) {
            if (this.mfz instanceof PersonCenterDynamicTabFragment) {
                i = 4;
            } else if (this.mfz instanceof PersonCenterThreadTabFragment) {
                i = 6;
            }
        }
        this.mfy.Hc(i);
        this.mfy.setTabType(this.mfz.getTabType());
    }

    public void addHeaderView(View view) {
        this.Xe.addHeaderView(view);
    }

    public void b(BdListView.e eVar) {
        this.Xe.setOnSrollToBottomListener(eVar);
    }

    public void onDestroy() {
        if (this.ltv != null) {
            this.ltv.bCm();
        }
        this.Xe.setOnSrollToBottomListener(null);
    }

    public void ft(List<q> list) {
        if (y.isEmpty(list)) {
            bPW();
            if (this.Xe.getHeaderViewsCount() == 0) {
                CQ(R.string.person_center_listempty_txt);
            }
        } else if (this.mNoDataView != null && this.mNoDataView.getParent() != null) {
            this.Xe.removeHeaderView(this.mNoDataView);
        }
        this.Xe.setData(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.mfz.getTabType())));
    }

    private void CQ(int i) {
        String string;
        if (this.mfz.getTabType() == 1) {
            string = this.mfz.getResources().getString(R.string.person_center_listempty_dynamic_txt);
        } else {
            string = this.mfz.getResources().getString(R.string.person_center_listempty_thread_txt);
        }
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eIc.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.d.dS(null, string), null);
        }
        this.mNoDataView.onChangeSkinType(this.eIc, TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.Xe.removeHeaderView(this.mNoDataView);
        this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.Xe.addHeaderView(this.mNoDataView);
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        if (this.mfy != null) {
            this.mfy.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eIc, i);
        }
        if (this.gjo != null) {
            this.gjo.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.gjo.changeSkin(i);
        }
    }

    public n dwn() {
        return this.mfy;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void Wi() {
        this.Xe.setNextPage(this.gjo);
        this.gjo.showEmptyView(0);
        this.gjo.startLoadData();
    }

    public void Wj() {
        this.Xe.setNextPage(this.gjo);
        this.gjo.showEmptyView(0);
        this.gjo.endLoadData();
        this.gjo.setText(this.eIc.getString(R.string.list_no_more));
    }

    public void bPW() {
        this.Xe.setNextPage(null);
    }

    public void cxS() {
        this.Xe.smoothScrollToPosition(0);
    }

    public void Hj(int i) {
        this.Xe.setNextPage(this.gjo);
        this.gjo.showEmptyView(0);
        this.gjo.endLoadData();
        this.gjo.setText(this.eIc.getString(i));
    }

    public void setSubType(int i) {
        this.mSubType = i;
    }
}
