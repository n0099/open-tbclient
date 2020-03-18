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
    private TbPageContext cVv;
    private PbListView elM;
    private n jso;
    private PersonCenterTabBaseFragment jsp;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view, PersonCenterTabBaseFragment personCenterTabBaseFragment) {
        this.cVv = tbPageContext;
        this.mRootView = view;
        this.jsp = personCenterTabBaseFragment;
        initUI();
    }

    private void initUI() {
        this.BK = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.new_person_center_common_lv);
        this.BK.setLayoutManager(new LinearLayoutManager(this.BK.getContext()));
        this.elM = new PbListView(this.cVv.getPageActivity());
        this.elM.createView();
        this.elM.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elM.setHeight(l.getDimens(this.cVv.getPageActivity(), R.dimen.tbds182));
        this.elM.setLineGone();
        this.elM.setTextSize(R.dimen.tbfontsize33);
        this.elM.setTextColor(am.getColor(R.color.cp_cont_j));
        this.elM.setNoMoreTextColorId(R.color.cp_cont_e);
        this.jso = new n(this.cVv, this.BK, this.jsp.getUniqueId());
        this.jso.setIsHost(this.jsp.isHost());
        this.jso.Ad(32);
        int i = 0;
        if (this.jsp.isHost()) {
            if (this.jsp instanceof PersonCenterDynamicTabFragment) {
                i = 4;
            } else if (this.jsp instanceof PersonCenterThreadTabFragment) {
                i = 6;
            }
        }
        this.jso.Ae(i);
        this.jso.setTabType(this.jsp.getTabType());
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
            bdz();
            if (this.BK.getHeaderViewsCount() == 0) {
                ww(R.string.person_center_listempty_txt);
            }
        } else if (this.mNoDataView != null && this.mNoDataView.getParent() != null) {
            this.BK.removeHeaderView(this.mNoDataView);
        }
        this.BK.setData(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.jsp.getTabType())));
    }

    private void ww(int i) {
        String string;
        if (this.jsp.getTabType() == 1) {
            string = this.jsp.getResources().getString(R.string.person_center_listempty_dynamic_txt);
        } else {
            string = this.jsp.getResources().getString(R.string.person_center_listempty_thread_txt);
        }
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cVv.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.d.cz(null, string), null);
        }
        this.mNoDataView.onChangeSkinType(this.cVv, TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.BK.removeHeaderView(this.mNoDataView);
        this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.BK.addHeaderView(this.mNoDataView);
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        if (this.jso != null) {
            this.jso.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cVv, i);
        }
        if (this.elM != null) {
            this.elM.setTextColor(am.getColor(R.color.cp_cont_j));
            this.elM.changeSkin(i);
        }
    }

    public n cyc() {
        return this.jso;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void bdx() {
        this.BK.setNextPage(this.elM);
        this.elM.showEmptyView(0);
        this.elM.startLoadData();
    }

    public void bdy() {
        this.BK.setNextPage(this.elM);
        this.elM.showEmptyView(0);
        this.elM.endLoadData();
        this.elM.setText(this.cVv.getString(R.string.list_no_more));
    }

    public void bdz() {
        this.BK.setNextPage(null);
    }

    public void scrollToTop() {
        this.BK.smoothScrollToPosition(0);
    }

    public void Al(int i) {
        this.BK.setNextPage(this.elM);
        this.elM.showEmptyView(0);
        this.elM.endLoadData();
        this.elM.setText(this.cVv.getString(i));
    }
}
