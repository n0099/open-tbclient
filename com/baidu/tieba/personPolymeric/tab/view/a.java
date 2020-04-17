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
    private BdTypeRecyclerView Vf;
    private TbPageContext duG;
    private PbListView ePm;
    private n kcE;
    private PersonCenterTabBaseFragment kcF;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view, PersonCenterTabBaseFragment personCenterTabBaseFragment) {
        this.duG = tbPageContext;
        this.mRootView = view;
        this.kcF = personCenterTabBaseFragment;
        initUI();
    }

    private void initUI() {
        this.Vf = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.new_person_center_common_lv);
        this.Vf.setLayoutManager(new LinearLayoutManager(this.Vf.getContext()));
        this.ePm = new PbListView(this.duG.getPageActivity());
        this.ePm.createView();
        this.ePm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ePm.setHeight(l.getDimens(this.duG.getPageActivity(), R.dimen.tbds182));
        this.ePm.setLineGone();
        this.ePm.setTextSize(R.dimen.tbfontsize33);
        this.ePm.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ePm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.kcE = new n(this.duG, this.Vf, this.kcF.getUniqueId());
        this.kcE.setIsHost(this.kcF.isHost());
        this.kcE.AE(32);
        int i = 0;
        if (this.kcF.isHost()) {
            if (this.kcF instanceof PersonCenterDynamicTabFragment) {
                i = 4;
            } else if (this.kcF instanceof PersonCenterThreadTabFragment) {
                i = 6;
            }
        }
        this.kcE.AF(i);
        this.kcE.setTabType(this.kcF.getTabType());
    }

    public void addHeaderView(View view) {
        this.Vf.addHeaderView(view);
    }

    public void b(BdListView.e eVar) {
        this.Vf.setOnSrollToBottomListener(eVar);
    }

    public void onDestroy() {
        this.Vf.setOnSrollToBottomListener(null);
    }

    public void eg(List<m> list) {
        if (v.isEmpty(list)) {
            bmq();
            if (this.Vf.getHeaderViewsCount() == 0) {
                wU(R.string.person_center_listempty_txt);
            }
        } else if (this.mNoDataView != null && this.mNoDataView.getParent() != null) {
            this.Vf.removeHeaderView(this.mNoDataView);
        }
        this.Vf.setData(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.kcF.getTabType())));
    }

    private void wU(int i) {
        String string;
        if (this.kcF.getTabType() == 1) {
            string = this.kcF.getResources().getString(R.string.person_center_listempty_dynamic_txt);
        } else {
            string = this.kcF.getResources().getString(R.string.person_center_listempty_thread_txt);
        }
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.duG.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.d.cK(null, string), null);
        }
        this.mNoDataView.onChangeSkinType(this.duG, TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.Vf.removeHeaderView(this.mNoDataView);
        this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.Vf.addHeaderView(this.mNoDataView);
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        if (this.kcE != null) {
            this.kcE.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.duG, i);
        }
        if (this.ePm != null) {
            this.ePm.setTextColor(am.getColor(R.color.cp_cont_j));
            this.ePm.changeSkin(i);
        }
    }

    public n cIM() {
        return this.kcE;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void bmo() {
        this.Vf.setNextPage(this.ePm);
        this.ePm.showEmptyView(0);
        this.ePm.startLoadData();
    }

    public void bmp() {
        this.Vf.setNextPage(this.ePm);
        this.ePm.showEmptyView(0);
        this.ePm.endLoadData();
        this.ePm.setText(this.duG.getString(R.string.list_no_more));
    }

    public void bmq() {
        this.Vf.setNextPage(null);
    }

    public void bOe() {
        this.Vf.smoothScrollToPosition(0);
    }

    public void AM(int i) {
        this.Vf.setNextPage(this.ePm);
        this.ePm.showEmptyView(0);
        this.ePm.endLoadData();
        this.ePm.setText(this.duG.getString(i));
    }
}
