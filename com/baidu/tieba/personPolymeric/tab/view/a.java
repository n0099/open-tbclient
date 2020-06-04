package com.baidu.tieba.personPolymeric.tab.view;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.o;
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
    private BdTypeRecyclerView Vw;
    private TbPageContext dIF;
    private PbListView fcj;
    private n kvF;
    private PersonCenterTabBaseFragment kvG;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view, PersonCenterTabBaseFragment personCenterTabBaseFragment) {
        this.dIF = tbPageContext;
        this.mRootView = view;
        this.kvG = personCenterTabBaseFragment;
        initUI();
    }

    private void initUI() {
        this.Vw = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.new_person_center_common_lv);
        this.Vw.setLayoutManager(new LinearLayoutManager(this.Vw.getContext()));
        this.fcj = new PbListView(this.dIF.getPageActivity());
        this.fcj.createView();
        this.fcj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fcj.setHeight(l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds182));
        this.fcj.setLineGone();
        this.fcj.setTextSize(R.dimen.tbfontsize33);
        this.fcj.setTextColor(am.getColor(R.color.cp_cont_j));
        this.fcj.setNoMoreTextColorId(R.color.cp_cont_e);
        this.kvF = new n(this.dIF, this.Vw, this.kvG.getUniqueId());
        this.kvF.setIsHost(this.kvG.isHost());
        this.kvF.Br(32);
        int i = 0;
        if (this.kvG.isHost()) {
            if (this.kvG instanceof PersonCenterDynamicTabFragment) {
                i = 4;
            } else if (this.kvG instanceof PersonCenterThreadTabFragment) {
                i = 6;
            }
        }
        this.kvF.Bs(i);
        this.kvF.setTabType(this.kvG.getTabType());
    }

    public void addHeaderView(View view) {
        this.Vw.addHeaderView(view);
    }

    public void b(BdListView.e eVar) {
        this.Vw.setOnSrollToBottomListener(eVar);
    }

    public void onDestroy() {
        this.Vw.setOnSrollToBottomListener(null);
    }

    public void ep(List<o> list) {
        if (v.isEmpty(list)) {
            brO();
            if (this.Vw.getHeaderViewsCount() == 0) {
                xC(R.string.person_center_listempty_txt);
            }
        } else if (this.mNoDataView != null && this.mNoDataView.getParent() != null) {
            this.Vw.removeHeaderView(this.mNoDataView);
        }
        this.Vw.setData(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.kvG.getTabType())));
    }

    private void xC(int i) {
        String string;
        if (this.kvG.getTabType() == 1) {
            string = this.kvG.getResources().getString(R.string.person_center_listempty_dynamic_txt);
        } else {
            string = this.kvG.getResources().getString(R.string.person_center_listempty_thread_txt);
        }
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dIF.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.d.dj(null, string), null);
        }
        this.mNoDataView.onChangeSkinType(this.dIF, TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.Vw.removeHeaderView(this.mNoDataView);
        this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.Vw.addHeaderView(this.mNoDataView);
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        if (this.kvF != null) {
            this.kvF.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dIF, i);
        }
        if (this.fcj != null) {
            this.fcj.setTextColor(am.getColor(R.color.cp_cont_j));
            this.fcj.changeSkin(i);
        }
    }

    public n cPZ() {
        return this.kvF;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void brM() {
        this.Vw.setNextPage(this.fcj);
        this.fcj.showEmptyView(0);
        this.fcj.startLoadData();
    }

    public void brN() {
        this.Vw.setNextPage(this.fcj);
        this.fcj.showEmptyView(0);
        this.fcj.endLoadData();
        this.fcj.setText(this.dIF.getString(R.string.list_no_more));
    }

    public void brO() {
        this.Vw.setNextPage(null);
    }

    public void bUA() {
        this.Vw.smoothScrollToPosition(0);
    }

    public void Bz(int i) {
        this.Vw.setNextPage(this.fcj);
        this.fcj.showEmptyView(0);
        this.fcj.endLoadData();
        this.fcj.setText(this.dIF.getString(i));
    }
}
