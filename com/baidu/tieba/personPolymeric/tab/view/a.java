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
/* loaded from: classes8.dex */
public class a {
    private BdTypeRecyclerView Bn;
    private TbPageContext cQU;
    private PbListView egU;
    private n jlY;
    private PersonCenterTabBaseFragment jlZ;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view, PersonCenterTabBaseFragment personCenterTabBaseFragment) {
        this.cQU = tbPageContext;
        this.mRootView = view;
        this.jlZ = personCenterTabBaseFragment;
        initUI();
    }

    private void initUI() {
        this.Bn = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.new_person_center_common_lv);
        this.Bn.setLayoutManager(new LinearLayoutManager(this.Bn.getContext()));
        this.egU = new PbListView(this.cQU.getPageActivity());
        this.egU.createView();
        this.egU.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.egU.setHeight(l.getDimens(this.cQU.getPageActivity(), R.dimen.tbds182));
        this.egU.setLineGone();
        this.egU.setTextSize(R.dimen.tbfontsize33);
        this.egU.setTextColor(am.getColor(R.color.cp_cont_j));
        this.egU.setNoMoreTextColorId(R.color.cp_cont_e);
        this.jlY = new n(this.cQU, this.Bn, this.jlZ.getUniqueId());
        this.jlY.setIsHost(this.jlZ.isHost());
        this.jlY.zJ(32);
        int i = 0;
        if (this.jlZ.isHost()) {
            if (this.jlZ instanceof PersonCenterDynamicTabFragment) {
                i = 4;
            } else if (this.jlZ instanceof PersonCenterThreadTabFragment) {
                i = 6;
            }
        }
        this.jlY.zK(i);
        this.jlY.setTabType(this.jlZ.getTabType());
    }

    public void addHeaderView(View view) {
        this.Bn.addHeaderView(view);
    }

    public void b(BdListView.e eVar) {
        this.Bn.setOnSrollToBottomListener(eVar);
    }

    public void onDestroy() {
        this.Bn.setOnSrollToBottomListener(null);
    }

    public void dY(List<m> list) {
        if (v.isEmpty(list)) {
            baH();
            if (this.Bn.getHeaderViewsCount() == 0) {
                wd(R.string.person_center_listempty_txt);
            }
        } else if (this.mNoDataView != null && this.mNoDataView.getParent() != null) {
            this.Bn.removeHeaderView(this.mNoDataView);
        }
        this.Bn.setData(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.jlZ.getTabType())));
    }

    private void wd(int i) {
        String string;
        if (this.jlZ.getTabType() == 1) {
            string = this.jlZ.getResources().getString(R.string.person_center_listempty_dynamic_txt);
        } else {
            string = this.jlZ.getResources().getString(R.string.person_center_listempty_thread_txt);
        }
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cQU.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.d.cr(null, string), null);
        }
        this.mNoDataView.onChangeSkinType(this.cQU, TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.Bn.removeHeaderView(this.mNoDataView);
        this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.Bn.addHeaderView(this.mNoDataView);
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        if (this.jlY != null) {
            this.jlY.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cQU, i);
        }
        if (this.egU != null) {
            this.egU.setTextColor(am.getColor(R.color.cp_cont_j));
            this.egU.changeSkin(i);
        }
    }

    public n cvb() {
        return this.jlY;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void baF() {
        this.Bn.setNextPage(this.egU);
        this.egU.showEmptyView(0);
        this.egU.startLoadData();
    }

    public void baG() {
        this.Bn.setNextPage(this.egU);
        this.egU.showEmptyView(0);
        this.egU.endLoadData();
        this.egU.setText(this.cQU.getString(R.string.list_no_more));
    }

    public void baH() {
        this.Bn.setNextPage(null);
    }

    public void scrollToTop() {
        this.Bn.smoothScrollToPosition(0);
    }

    public void cvc() {
        this.Bn.setNextPage(this.egU);
        this.egU.showEmptyView(0);
        this.egU.endLoadData();
        this.egU.setText("");
    }
}
