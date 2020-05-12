package com.baidu.tieba.personPolymeric.tab.view;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.a.n;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private BdTypeRecyclerView Vi;
    private TbPageContext duK;
    private PbListView ePr;
    private n kcI;
    private PersonCenterTabBaseFragment kcJ;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view, PersonCenterTabBaseFragment personCenterTabBaseFragment) {
        this.duK = tbPageContext;
        this.mRootView = view;
        this.kcJ = personCenterTabBaseFragment;
        initUI();
    }

    private void initUI() {
        this.Vi = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.new_person_center_common_lv);
        this.Vi.setLayoutManager(new LinearLayoutManager(this.Vi.getContext()));
        this.ePr = new PbListView(this.duK.getPageActivity());
        this.ePr.createView();
        this.ePr.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ePr.setHeight(l.getDimens(this.duK.getPageActivity(), R.dimen.tbds182));
        this.ePr.setLineGone();
        this.ePr.setTextSize(R.dimen.tbfontsize33);
        this.ePr.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ePr.setNoMoreTextColorId(R.color.cp_cont_e);
        this.kcI = new n(this.duK, this.Vi, this.kcJ.getUniqueId());
        this.kcI.setIsHost(this.kcJ.isHost());
        this.kcI.AE(32);
        int i = 0;
        if (this.kcJ.isHost()) {
            if (this.kcJ instanceof PersonCenterDynamicTabFragment) {
                i = 4;
            } else if (this.kcJ instanceof PersonCenterThreadTabFragment) {
                i = 6;
            }
        }
        this.kcI.AF(i);
        this.kcI.setTabType(this.kcJ.getTabType());
    }

    public void addHeaderView(View view) {
        this.Vi.addHeaderView(view);
    }

    public void b(BdListView.e eVar) {
        this.Vi.setOnSrollToBottomListener(eVar);
    }

    public void onDestroy() {
        this.Vi.setOnSrollToBottomListener(null);
    }

    public void eg(List<m> list) {
        if (v.isEmpty(list)) {
            bmo();
            if (this.Vi.getHeaderViewsCount() == 0) {
                wU(R.string.person_center_listempty_txt);
            }
        } else if (this.mNoDataView != null && this.mNoDataView.getParent() != null) {
            this.Vi.removeHeaderView(this.mNoDataView);
        }
        this.Vi.setData(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.kcJ.getTabType())));
    }

    private void wU(int i) {
        String string;
        if (this.kcJ.getTabType() == 1) {
            string = this.kcJ.getResources().getString(R.string.person_center_listempty_dynamic_txt);
        } else {
            string = this.kcJ.getResources().getString(R.string.person_center_listempty_thread_txt);
        }
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.duK.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.d.cK(null, string), null);
        }
        this.mNoDataView.onChangeSkinType(this.duK, TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.Vi.removeHeaderView(this.mNoDataView);
        this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.Vi.addHeaderView(this.mNoDataView);
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        if (this.kcI != null) {
            this.kcI.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.duK, i);
        }
        if (this.ePr != null) {
            this.ePr.setTextColor(am.getColor(R.color.cp_cont_j));
            this.ePr.changeSkin(i);
        }
    }

    public n cIK() {
        return this.kcI;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void bmm() {
        this.Vi.setNextPage(this.ePr);
        this.ePr.showEmptyView(0);
        this.ePr.startLoadData();
    }

    public void bmn() {
        this.Vi.setNextPage(this.ePr);
        this.ePr.showEmptyView(0);
        this.ePr.endLoadData();
        this.ePr.setText(this.duK.getString(R.string.list_no_more));
    }

    public void bmo() {
        this.Vi.setNextPage(null);
    }

    public void bOd() {
        this.Vi.smoothScrollToPosition(0);
    }

    public void AM(int i) {
        this.Vi.setNextPage(this.ePr);
        this.ePr.showEmptyView(0);
        this.ePr.endLoadData();
        this.ePr.setText(this.duK.getString(i));
    }
}
