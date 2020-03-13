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
    private BdTypeRecyclerView BK;
    private TbPageContext cVi;
    private PbListView elw;
    private n jqP;
    private PersonCenterTabBaseFragment jqQ;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view, PersonCenterTabBaseFragment personCenterTabBaseFragment) {
        this.cVi = tbPageContext;
        this.mRootView = view;
        this.jqQ = personCenterTabBaseFragment;
        initUI();
    }

    private void initUI() {
        this.BK = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.new_person_center_common_lv);
        this.BK.setLayoutManager(new LinearLayoutManager(this.BK.getContext()));
        this.elw = new PbListView(this.cVi.getPageActivity());
        this.elw.createView();
        this.elw.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elw.setHeight(l.getDimens(this.cVi.getPageActivity(), R.dimen.tbds182));
        this.elw.setLineGone();
        this.elw.setTextSize(R.dimen.tbfontsize33);
        this.elw.setTextColor(am.getColor(R.color.cp_cont_j));
        this.elw.setNoMoreTextColorId(R.color.cp_cont_e);
        this.jqP = new n(this.cVi, this.BK, this.jqQ.getUniqueId());
        this.jqP.setIsHost(this.jqQ.isHost());
        this.jqP.zV(32);
        int i = 0;
        if (this.jqQ.isHost()) {
            if (this.jqQ instanceof PersonCenterDynamicTabFragment) {
                i = 4;
            } else if (this.jqQ instanceof PersonCenterThreadTabFragment) {
                i = 6;
            }
        }
        this.jqP.zW(i);
        this.jqP.setTabType(this.jqQ.getTabType());
    }

    public void addHeaderView(View view) {
        this.BK.addHeaderView(view);
    }

    public void b(BdListView.e eVar) {
        this.BK.setOnSrollToBottomListener(eVar);
    }

    public void onDestroy() {
        this.BK.setOnSrollToBottomListener(null);
    }

    public void dV(List<m> list) {
        if (v.isEmpty(list)) {
            bdu();
            if (this.BK.getHeaderViewsCount() == 0) {
                wo(R.string.person_center_listempty_txt);
            }
        } else if (this.mNoDataView != null && this.mNoDataView.getParent() != null) {
            this.BK.removeHeaderView(this.mNoDataView);
        }
        this.BK.setData(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.jqQ.getTabType())));
    }

    private void wo(int i) {
        String string;
        if (this.jqQ.getTabType() == 1) {
            string = this.jqQ.getResources().getString(R.string.person_center_listempty_dynamic_txt);
        } else {
            string = this.jqQ.getResources().getString(R.string.person_center_listempty_thread_txt);
        }
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cVi.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.d.cA(null, string), null);
        }
        this.mNoDataView.onChangeSkinType(this.cVi, TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.BK.removeHeaderView(this.mNoDataView);
        this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.BK.addHeaderView(this.mNoDataView);
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        if (this.jqP != null) {
            this.jqP.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cVi, i);
        }
        if (this.elw != null) {
            this.elw.setTextColor(am.getColor(R.color.cp_cont_j));
            this.elw.changeSkin(i);
        }
    }

    public n cxJ() {
        return this.jqP;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void bds() {
        this.BK.setNextPage(this.elw);
        this.elw.showEmptyView(0);
        this.elw.startLoadData();
    }

    public void bdt() {
        this.BK.setNextPage(this.elw);
        this.elw.showEmptyView(0);
        this.elw.endLoadData();
        this.elw.setText(this.cVi.getString(R.string.list_no_more));
    }

    public void bdu() {
        this.BK.setNextPage(null);
    }

    public void scrollToTop() {
        this.BK.smoothScrollToPosition(0);
    }

    public void Ad(int i) {
        this.BK.setNextPage(this.elw);
        this.elw.showEmptyView(0);
        this.elw.endLoadData();
        this.elw.setText(this.cVi.getString(i));
    }
}
