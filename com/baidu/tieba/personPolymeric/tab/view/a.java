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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.a.n;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment;
import java.util.List;
/* loaded from: classes18.dex */
public class a {
    private BdTypeRecyclerView VT;
    private TbPageContext dVN;
    private PbListView fsC;
    private n kYA;
    private PersonCenterTabBaseFragment kYB;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view, PersonCenterTabBaseFragment personCenterTabBaseFragment) {
        this.dVN = tbPageContext;
        this.mRootView = view;
        this.kYB = personCenterTabBaseFragment;
        initUI();
    }

    private void initUI() {
        this.VT = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.new_person_center_common_lv);
        this.VT.setLayoutManager(new LinearLayoutManager(this.VT.getContext()));
        this.fsC = new PbListView(this.dVN.getPageActivity());
        this.fsC.createView();
        this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fsC.setHeight(l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds182));
        this.fsC.setLineGone();
        this.fsC.setTextSize(R.dimen.tbfontsize33);
        this.fsC.setTextColor(ao.getColor(R.color.cp_cont_j));
        this.fsC.setNoMoreTextColorId(R.color.cp_cont_e);
        this.kYA = new n(this.dVN, this.VT, this.kYB.getUniqueId());
        this.kYA.setIsHost(this.kYB.isHost());
        this.kYA.CT(32);
        int i = 0;
        if (this.kYB.isHost()) {
            if (this.kYB instanceof PersonCenterDynamicTabFragment) {
                i = 4;
            } else if (this.kYB instanceof PersonCenterThreadTabFragment) {
                i = 6;
            }
        }
        this.kYA.CU(i);
        this.kYA.setTabType(this.kYB.getTabType());
    }

    public void addHeaderView(View view) {
        this.VT.addHeaderView(view);
    }

    public void b(BdListView.e eVar) {
        this.VT.setOnSrollToBottomListener(eVar);
    }

    public void onDestroy() {
        this.VT.setOnSrollToBottomListener(null);
    }

    public void eJ(List<q> list) {
        if (x.isEmpty(list)) {
            bxU();
            if (this.VT.getHeaderViewsCount() == 0) {
                yK(R.string.person_center_listempty_txt);
            }
        } else if (this.mNoDataView != null && this.mNoDataView.getParent() != null) {
            this.VT.removeHeaderView(this.mNoDataView);
        }
        this.VT.setData(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.kYB.getTabType())));
    }

    private void yK(int i) {
        String string;
        if (this.kYB.getTabType() == 1) {
            string = this.kYB.getResources().getString(R.string.person_center_listempty_dynamic_txt);
        } else {
            string = this.kYB.getResources().getString(R.string.person_center_listempty_thread_txt);
        }
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dVN.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.d.m31do(null, string), null);
        }
        this.mNoDataView.onChangeSkinType(this.dVN, TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.VT.removeHeaderView(this.mNoDataView);
        this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.VT.addHeaderView(this.mNoDataView);
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        if (this.kYA != null) {
            this.kYA.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dVN, i);
        }
        if (this.fsC != null) {
            this.fsC.setTextColor(ao.getColor(R.color.cp_cont_j));
            this.fsC.changeSkin(i);
        }
    }

    public n cYh() {
        return this.kYA;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void bxS() {
        this.VT.setNextPage(this.fsC);
        this.fsC.showEmptyView(0);
        this.fsC.startLoadData();
    }

    public void bxT() {
        this.VT.setNextPage(this.fsC);
        this.fsC.showEmptyView(0);
        this.fsC.endLoadData();
        this.fsC.setText(this.dVN.getString(R.string.list_no_more));
    }

    public void bxU() {
        this.VT.setNextPage(null);
    }

    public void cbd() {
        this.VT.smoothScrollToPosition(0);
    }

    public void Db(int i) {
        this.VT.setNextPage(this.fsC);
        this.fsC.showEmptyView(0);
        this.fsC.endLoadData();
        this.fsC.setText(this.dVN.getString(i));
    }
}
