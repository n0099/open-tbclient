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
    private TbPageContext cVg;
    private PbListView eli;
    private n jqB;
    private PersonCenterTabBaseFragment jqC;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view, PersonCenterTabBaseFragment personCenterTabBaseFragment) {
        this.cVg = tbPageContext;
        this.mRootView = view;
        this.jqC = personCenterTabBaseFragment;
        initUI();
    }

    private void initUI() {
        this.BK = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.new_person_center_common_lv);
        this.BK.setLayoutManager(new LinearLayoutManager(this.BK.getContext()));
        this.eli = new PbListView(this.cVg.getPageActivity());
        this.eli.createView();
        this.eli.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.eli.setHeight(l.getDimens(this.cVg.getPageActivity(), R.dimen.tbds182));
        this.eli.setLineGone();
        this.eli.setTextSize(R.dimen.tbfontsize33);
        this.eli.setTextColor(am.getColor(R.color.cp_cont_j));
        this.eli.setNoMoreTextColorId(R.color.cp_cont_e);
        this.jqB = new n(this.cVg, this.BK, this.jqC.getUniqueId());
        this.jqB.setIsHost(this.jqC.isHost());
        this.jqB.zV(32);
        int i = 0;
        if (this.jqC.isHost()) {
            if (this.jqC instanceof PersonCenterDynamicTabFragment) {
                i = 4;
            } else if (this.jqC instanceof PersonCenterThreadTabFragment) {
                i = 6;
            }
        }
        this.jqB.zW(i);
        this.jqB.setTabType(this.jqC.getTabType());
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
            bdr();
            if (this.BK.getHeaderViewsCount() == 0) {
                wo(R.string.person_center_listempty_txt);
            }
        } else if (this.mNoDataView != null && this.mNoDataView.getParent() != null) {
            this.BK.removeHeaderView(this.mNoDataView);
        }
        this.BK.setData(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.jqC.getTabType())));
    }

    private void wo(int i) {
        String string;
        if (this.jqC.getTabType() == 1) {
            string = this.jqC.getResources().getString(R.string.person_center_listempty_dynamic_txt);
        } else {
            string = this.jqC.getResources().getString(R.string.person_center_listempty_thread_txt);
        }
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cVg.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.d.cA(null, string), null);
        }
        this.mNoDataView.onChangeSkinType(this.cVg, TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.BK.removeHeaderView(this.mNoDataView);
        this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.BK.addHeaderView(this.mNoDataView);
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        if (this.jqB != null) {
            this.jqB.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cVg, i);
        }
        if (this.eli != null) {
            this.eli.setTextColor(am.getColor(R.color.cp_cont_j));
            this.eli.changeSkin(i);
        }
    }

    public n cxG() {
        return this.jqB;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void bdp() {
        this.BK.setNextPage(this.eli);
        this.eli.showEmptyView(0);
        this.eli.startLoadData();
    }

    public void bdq() {
        this.BK.setNextPage(this.eli);
        this.eli.showEmptyView(0);
        this.eli.endLoadData();
        this.eli.setText(this.cVg.getString(R.string.list_no_more));
    }

    public void bdr() {
        this.BK.setNextPage(null);
    }

    public void scrollToTop() {
        this.BK.smoothScrollToPosition(0);
    }

    public void Ad(int i) {
        this.BK.setNextPage(this.eli);
        this.eli.showEmptyView(0);
        this.eli.endLoadData();
        this.eli.setText(this.cVg.getString(i));
    }
}
