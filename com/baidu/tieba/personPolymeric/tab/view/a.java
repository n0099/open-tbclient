package com.baidu.tieba.personPolymeric.tab.view;

import android.support.v7.widget.LinearLayoutManager;
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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
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
    private BdTypeRecyclerView Wa;
    private TbPageContext dPv;
    private PbListView fnt;
    private n kPC;
    private PersonCenterTabBaseFragment kPD;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view, PersonCenterTabBaseFragment personCenterTabBaseFragment) {
        this.dPv = tbPageContext;
        this.mRootView = view;
        this.kPD = personCenterTabBaseFragment;
        initUI();
    }

    private void initUI() {
        this.Wa = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.new_person_center_common_lv);
        this.Wa.setLayoutManager(new LinearLayoutManager(this.Wa.getContext()));
        this.fnt = new PbListView(this.dPv.getPageActivity());
        this.fnt.createView();
        this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fnt.setHeight(l.getDimens(this.dPv.getPageActivity(), R.dimen.tbds182));
        this.fnt.setLineGone();
        this.fnt.setTextSize(R.dimen.tbfontsize33);
        this.fnt.setTextColor(an.getColor(R.color.cp_cont_j));
        this.fnt.setNoMoreTextColorId(R.color.cp_cont_e);
        this.kPC = new n(this.dPv, this.Wa, this.kPD.getUniqueId());
        this.kPC.setIsHost(this.kPD.isHost());
        this.kPC.Ct(32);
        int i = 0;
        if (this.kPD.isHost()) {
            if (this.kPD instanceof PersonCenterDynamicTabFragment) {
                i = 4;
            } else if (this.kPD instanceof PersonCenterThreadTabFragment) {
                i = 6;
            }
        }
        this.kPC.Cu(i);
        this.kPC.setTabType(this.kPD.getTabType());
    }

    public void addHeaderView(View view) {
        this.Wa.addHeaderView(view);
    }

    public void b(BdListView.e eVar) {
        this.Wa.setOnSrollToBottomListener(eVar);
    }

    public void onDestroy() {
        this.Wa.setOnSrollToBottomListener(null);
    }

    public void eD(List<q> list) {
        if (w.isEmpty(list)) {
            buL();
            if (this.Wa.getHeaderViewsCount() == 0) {
                ym(R.string.person_center_listempty_txt);
            }
        } else if (this.mNoDataView != null && this.mNoDataView.getParent() != null) {
            this.Wa.removeHeaderView(this.mNoDataView);
        }
        this.Wa.setData(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.kPD.getTabType())));
    }

    private void ym(int i) {
        String string;
        if (this.kPD.getTabType() == 1) {
            string = this.kPD.getResources().getString(R.string.person_center_listempty_dynamic_txt);
        } else {
            string = this.kPD.getResources().getString(R.string.person_center_listempty_thread_txt);
        }
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dPv.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.d.dm(null, string), null);
        }
        this.mNoDataView.onChangeSkinType(this.dPv, TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.Wa.removeHeaderView(this.mNoDataView);
        this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.Wa.addHeaderView(this.mNoDataView);
    }

    public void onChangeSkinType(int i) {
        an.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        if (this.kPC != null) {
            this.kPC.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dPv, i);
        }
        if (this.fnt != null) {
            this.fnt.setTextColor(an.getColor(R.color.cp_cont_j));
            this.fnt.changeSkin(i);
        }
    }

    public n cUr() {
        return this.kPC;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void buJ() {
        this.Wa.setNextPage(this.fnt);
        this.fnt.showEmptyView(0);
        this.fnt.startLoadData();
    }

    public void buK() {
        this.Wa.setNextPage(this.fnt);
        this.fnt.showEmptyView(0);
        this.fnt.endLoadData();
        this.fnt.setText(this.dPv.getString(R.string.list_no_more));
    }

    public void buL() {
        this.Wa.setNextPage(null);
    }

    public void bXH() {
        this.Wa.smoothScrollToPosition(0);
    }

    public void CB(int i) {
        this.Wa.setNextPage(this.fnt);
        this.fnt.showEmptyView(0);
        this.fnt.endLoadData();
        this.fnt.setText(this.dPv.getString(i));
    }
}
