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
/* loaded from: classes9.dex */
public class a {
    private BdTypeRecyclerView Bs;
    private TbPageContext cRe;
    private PbListView ehe;
    private n jpB;
    private PersonCenterTabBaseFragment jpC;
    private NoDataView mNoDataView;
    private View mRootView;

    public a(TbPageContext tbPageContext, View view, PersonCenterTabBaseFragment personCenterTabBaseFragment) {
        this.cRe = tbPageContext;
        this.mRootView = view;
        this.jpC = personCenterTabBaseFragment;
        initUI();
    }

    private void initUI() {
        this.Bs = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.new_person_center_common_lv);
        this.Bs.setLayoutManager(new LinearLayoutManager(this.Bs.getContext()));
        this.ehe = new PbListView(this.cRe.getPageActivity());
        this.ehe.createView();
        this.ehe.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ehe.setHeight(l.getDimens(this.cRe.getPageActivity(), R.dimen.tbds182));
        this.ehe.setLineGone();
        this.ehe.setTextSize(R.dimen.tbfontsize33);
        this.ehe.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ehe.setNoMoreTextColorId(R.color.cp_cont_e);
        this.jpB = new n(this.cRe, this.Bs, this.jpC.getUniqueId());
        this.jpB.setIsHost(this.jpC.isHost());
        this.jpB.zO(32);
        int i = 0;
        if (this.jpC.isHost()) {
            if (this.jpC instanceof PersonCenterDynamicTabFragment) {
                i = 4;
            } else if (this.jpC instanceof PersonCenterThreadTabFragment) {
                i = 6;
            }
        }
        this.jpB.zP(i);
        this.jpB.setTabType(this.jpC.getTabType());
    }

    public void addHeaderView(View view) {
        this.Bs.addHeaderView(view);
    }

    public void b(BdListView.e eVar) {
        this.Bs.setOnSrollToBottomListener(eVar);
    }

    public void onDestroy() {
        this.Bs.setOnSrollToBottomListener(null);
    }

    public void dY(List<m> list) {
        if (v.isEmpty(list)) {
            bbc();
            if (this.Bs.getHeaderViewsCount() == 0) {
                wi(R.string.person_center_listempty_txt);
            }
        } else if (this.mNoDataView != null && this.mNoDataView.getParent() != null) {
            this.Bs.removeHeaderView(this.mNoDataView);
        }
        this.Bs.setData(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.jpC.getTabType())));
    }

    private void wi(int i) {
        String string;
        if (this.jpC.getTabType() == 1) {
            string = this.jpC.getResources().getString(R.string.person_center_listempty_dynamic_txt);
        } else {
            string = this.jpC.getResources().getString(R.string.person_center_listempty_thread_txt);
        }
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cRe.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.d.cr(null, string), null);
        }
        this.mNoDataView.onChangeSkinType(this.cRe, TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.Bs.removeHeaderView(this.mNoDataView);
        this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.Bs.addHeaderView(this.mNoDataView);
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        if (this.jpB != null) {
            this.jpB.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cRe, i);
        }
        if (this.ehe != null) {
            this.ehe.setTextColor(am.getColor(R.color.cp_cont_j));
            this.ehe.changeSkin(i);
        }
    }

    public n cwi() {
        return this.jpB;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void bba() {
        this.Bs.setNextPage(this.ehe);
        this.ehe.showEmptyView(0);
        this.ehe.startLoadData();
    }

    public void bbb() {
        this.Bs.setNextPage(this.ehe);
        this.ehe.showEmptyView(0);
        this.ehe.endLoadData();
        this.ehe.setText(this.cRe.getString(R.string.list_no_more));
    }

    public void bbc() {
        this.Bs.setNextPage(null);
    }

    public void scrollToTop() {
        this.Bs.smoothScrollToPosition(0);
    }

    public void cwj() {
        this.Bs.setNextPage(this.ehe);
        this.ehe.showEmptyView(0);
        this.ehe.endLoadData();
        this.ehe.setText("");
    }
}
