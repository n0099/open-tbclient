package com.baidu.tieba.personPolymeric.tab.view;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.a.n;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment;
import java.util.List;
/* loaded from: classes24.dex */
public class a {
    private BdTypeRecyclerView Xe;
    private TbPageContext eCn;
    private PbListView gdy;
    private n lZy;
    private PersonCenterTabBaseFragment lZz;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tbadk.n.b lnu = null;
    private int mSubType = 1010;

    public a(TbPageContext tbPageContext, View view, PersonCenterTabBaseFragment personCenterTabBaseFragment) {
        this.eCn = tbPageContext;
        this.mRootView = view;
        this.lZz = personCenterTabBaseFragment;
        initUI();
    }

    private void initUI() {
        this.Xe = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.new_person_center_common_lv);
        this.Xe.setLayoutManager(new LinearLayoutManager(this.Xe.getContext()) { // from class: com.baidu.tieba.personPolymeric.tab.view.a.1
            @Override // android.support.v7.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
                return false;
            }

            @Override // android.support.v7.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
                return false;
            }
        });
        this.Xe.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.a.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (a.this.lnu == null) {
                    a.this.lnu = new com.baidu.tbadk.n.b();
                    a.this.lnu.setSubType(a.this.mSubType);
                }
                if (i == 0) {
                    a.this.lnu.bzM();
                } else {
                    a.this.lnu.bzL();
                }
            }
        });
        this.gdy = new PbListView(this.eCn.getPageActivity());
        this.gdy.createView();
        this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gdy.setHeight(l.getDimens(this.eCn.getPageActivity(), R.dimen.tbds182));
        this.gdy.setLineGone();
        this.gdy.setTextSize(R.dimen.tbfontsize33);
        this.gdy.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.gdy.setNoMoreTextColorId(R.color.cp_cont_e);
        this.lZy = new n(this.eCn, this.Xe, this.lZz.getUniqueId());
        this.lZy.setIsHost(this.lZz.isHost());
        this.lZy.GO(32);
        int i = 0;
        if (this.lZz.isHost()) {
            if (this.lZz instanceof PersonCenterDynamicTabFragment) {
                i = 4;
            } else if (this.lZz instanceof PersonCenterThreadTabFragment) {
                i = 6;
            }
        }
        this.lZy.GP(i);
        this.lZy.setTabType(this.lZz.getTabType());
    }

    public void addHeaderView(View view) {
        this.Xe.addHeaderView(view);
    }

    public void b(BdListView.e eVar) {
        this.Xe.setOnSrollToBottomListener(eVar);
    }

    public void onDestroy() {
        if (this.lnu != null) {
            this.lnu.bzN();
        }
        this.Xe.setOnSrollToBottomListener(null);
    }

    public void fl(List<q> list) {
        if (y.isEmpty(list)) {
            bNw();
            if (this.Xe.getHeaderViewsCount() == 0) {
                CD(R.string.person_center_listempty_txt);
            }
        } else if (this.mNoDataView != null && this.mNoDataView.getParent() != null) {
            this.Xe.removeHeaderView(this.mNoDataView);
        }
        this.Xe.setData(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.lZz.getTabType())));
    }

    private void CD(int i) {
        String string;
        if (this.lZz.getTabType() == 1) {
            string = this.lZz.getResources().getString(R.string.person_center_listempty_dynamic_txt);
        } else {
            string = this.lZz.getResources().getString(R.string.person_center_listempty_thread_txt);
        }
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eCn.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.d.dS(null, string), null);
        }
        this.mNoDataView.onChangeSkinType(this.eCn, TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.Xe.removeHeaderView(this.mNoDataView);
        this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.Xe.addHeaderView(this.mNoDataView);
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        if (this.lZy != null) {
            this.lZy.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eCn, i);
        }
        if (this.gdy != null) {
            this.gdy.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.gdy.changeSkin(i);
        }
    }

    public n dtL() {
        return this.lZy;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void TI() {
        this.Xe.setNextPage(this.gdy);
        this.gdy.showEmptyView(0);
        this.gdy.startLoadData();
    }

    public void TJ() {
        this.Xe.setNextPage(this.gdy);
        this.gdy.showEmptyView(0);
        this.gdy.endLoadData();
        this.gdy.setText(this.eCn.getString(R.string.list_no_more));
    }

    public void bNw() {
        this.Xe.setNextPage(null);
    }

    public void cvr() {
        this.Xe.smoothScrollToPosition(0);
    }

    public void GW(int i) {
        this.Xe.setNextPage(this.gdy);
        this.gdy.showEmptyView(0);
        this.gdy.endLoadData();
        this.gdy.setText(this.eCn.getString(i));
    }

    public void setSubType(int i) {
        this.mSubType = i;
    }
}
