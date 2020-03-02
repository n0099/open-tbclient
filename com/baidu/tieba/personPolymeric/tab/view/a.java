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
    private TbPageContext cVh;
    private PbListView elj;
    private n jqD;
    private PersonCenterTabBaseFragment jqE;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view, PersonCenterTabBaseFragment personCenterTabBaseFragment) {
        this.cVh = tbPageContext;
        this.mRootView = view;
        this.jqE = personCenterTabBaseFragment;
        initUI();
    }

    private void initUI() {
        this.BK = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.new_person_center_common_lv);
        this.BK.setLayoutManager(new LinearLayoutManager(this.BK.getContext()));
        this.elj = new PbListView(this.cVh.getPageActivity());
        this.elj.createView();
        this.elj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elj.setHeight(l.getDimens(this.cVh.getPageActivity(), R.dimen.tbds182));
        this.elj.setLineGone();
        this.elj.setTextSize(R.dimen.tbfontsize33);
        this.elj.setTextColor(am.getColor(R.color.cp_cont_j));
        this.elj.setNoMoreTextColorId(R.color.cp_cont_e);
        this.jqD = new n(this.cVh, this.BK, this.jqE.getUniqueId());
        this.jqD.setIsHost(this.jqE.isHost());
        this.jqD.zV(32);
        int i = 0;
        if (this.jqE.isHost()) {
            if (this.jqE instanceof PersonCenterDynamicTabFragment) {
                i = 4;
            } else if (this.jqE instanceof PersonCenterThreadTabFragment) {
                i = 6;
            }
        }
        this.jqD.zW(i);
        this.jqD.setTabType(this.jqE.getTabType());
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
            bdt();
            if (this.BK.getHeaderViewsCount() == 0) {
                wo(R.string.person_center_listempty_txt);
            }
        } else if (this.mNoDataView != null && this.mNoDataView.getParent() != null) {
            this.BK.removeHeaderView(this.mNoDataView);
        }
        this.BK.setData(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.jqE.getTabType())));
    }

    private void wo(int i) {
        String string;
        if (this.jqE.getTabType() == 1) {
            string = this.jqE.getResources().getString(R.string.person_center_listempty_dynamic_txt);
        } else {
            string = this.jqE.getResources().getString(R.string.person_center_listempty_thread_txt);
        }
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cVh.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.d.cA(null, string), null);
        }
        this.mNoDataView.onChangeSkinType(this.cVh, TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.BK.removeHeaderView(this.mNoDataView);
        this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.BK.addHeaderView(this.mNoDataView);
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        if (this.jqD != null) {
            this.jqD.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cVh, i);
        }
        if (this.elj != null) {
            this.elj.setTextColor(am.getColor(R.color.cp_cont_j));
            this.elj.changeSkin(i);
        }
    }

    public n cxI() {
        return this.jqD;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void bdr() {
        this.BK.setNextPage(this.elj);
        this.elj.showEmptyView(0);
        this.elj.startLoadData();
    }

    public void bds() {
        this.BK.setNextPage(this.elj);
        this.elj.showEmptyView(0);
        this.elj.endLoadData();
        this.elj.setText(this.cVh.getString(R.string.list_no_more));
    }

    public void bdt() {
        this.BK.setNextPage(null);
    }

    public void scrollToTop() {
        this.BK.smoothScrollToPosition(0);
    }

    public void Ad(int i) {
        this.BK.setNextPage(this.elj);
        this.elj.showEmptyView(0);
        this.elj.endLoadData();
        this.elj.setText(this.cVh.getString(i));
    }
}
