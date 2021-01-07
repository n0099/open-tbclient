package com.baidu.tieba.personPolymeric.tab.view;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
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
/* loaded from: classes8.dex */
public class a {
    private BdTypeRecyclerView Yc;
    private TbPageContext eXu;
    private PbListView gCf;
    private NoDataView mNoDataView;
    private View mRootView;
    private n mzl;
    private PersonCenterTabBaseFragment mzm;
    private com.baidu.tbadk.n.b lMN = null;
    private int mSubType = 1010;

    public a(TbPageContext tbPageContext, View view, PersonCenterTabBaseFragment personCenterTabBaseFragment) {
        this.eXu = tbPageContext;
        this.mRootView = view;
        this.mzm = personCenterTabBaseFragment;
        initUI();
    }

    private void initUI() {
        this.Yc = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.new_person_center_common_lv);
        this.Yc.setLayoutManager(new LinearLayoutManager(this.Yc.getContext()) { // from class: com.baidu.tieba.personPolymeric.tab.view.a.1
            @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
                return false;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
                return false;
            }
        });
        this.Yc.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.a.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (a.this.lMN == null) {
                    a.this.lMN = new com.baidu.tbadk.n.b();
                    a.this.lMN.setSubType(a.this.mSubType);
                }
                if (i == 0) {
                    a.this.lMN.bHz();
                } else {
                    a.this.lMN.bHy();
                }
            }
        });
        this.gCf = new PbListView(this.eXu.getPageActivity());
        this.gCf.createView();
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gCf.setHeight(l.getDimens(this.eXu.getPageActivity(), R.dimen.tbds182));
        this.gCf.setLineGone();
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.mzl = new n(this.eXu, this.Yc, this.mzm.getUniqueId());
        this.mzl.setIsHost(this.mzm.isHost());
        this.mzl.Ik(32);
        int i = 0;
        if (this.mzm.isHost()) {
            if (this.mzm instanceof PersonCenterDynamicTabFragment) {
                i = 4;
            } else if (this.mzm instanceof PersonCenterThreadTabFragment) {
                i = 6;
            }
        }
        this.mzl.Il(i);
        this.mzl.setTabType(this.mzm.getTabType());
    }

    public void addHeaderView(View view) {
        this.Yc.addHeaderView(view);
    }

    public void b(BdListView.e eVar) {
        this.Yc.setOnSrollToBottomListener(eVar);
    }

    public void onDestroy() {
        if (this.lMN != null) {
            this.lMN.bHA();
        }
        this.Yc.setOnSrollToBottomListener(null);
    }

    public void fF(List<com.baidu.adp.widget.ListView.n> list) {
        if (x.isEmpty(list)) {
            bVG();
            if (this.Yc.getHeaderViewsCount() == 0) {
                En(R.string.person_center_listempty_txt);
            }
        } else if (this.mNoDataView != null && this.mNoDataView.getParent() != null) {
            this.Yc.removeHeaderView(this.mNoDataView);
        }
        this.Yc.setData(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.mzm.getTabType())));
    }

    private void En(int i) {
        String string;
        if (this.mzm.getTabType() == 1) {
            string = this.mzm.getResources().getString(R.string.person_center_listempty_dynamic_txt);
        } else {
            string = this.mzm.getResources().getString(R.string.person_center_listempty_thread_txt);
        }
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eXu.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.d.dY(null, string), null);
        }
        this.mNoDataView.onChangeSkinType(this.eXu, TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.Yc.removeHeaderView(this.mNoDataView);
        this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.Yc.addHeaderView(this.mNoDataView);
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
        if (this.mzl != null) {
            this.mzl.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eXu, i);
        }
        if (this.gCf != null) {
            this.gCf.setTextColor(ao.getColor(R.color.CAM_X0107));
            this.gCf.changeSkin(i);
        }
    }

    public n dAW() {
        return this.mzl;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void Zh() {
        this.Yc.setNextPage(this.gCf);
        this.gCf.showEmptyView(0);
        this.gCf.startLoadData();
    }

    public void Zi() {
        this.Yc.setNextPage(this.gCf);
        this.gCf.showEmptyView(0);
        this.gCf.endLoadData();
        this.gCf.setText(this.eXu.getString(R.string.list_no_more));
    }

    public void bVG() {
        this.Yc.setNextPage(null);
    }

    public void cEG() {
        this.Yc.smoothScrollToPosition(0);
    }

    public void Is(int i) {
        this.Yc.setNextPage(this.gCf);
        this.gCf.showEmptyView(0);
        this.gCf.endLoadData();
        this.gCf.setText(this.eXu.getString(i));
    }

    public void setSubType(int i) {
        this.mSubType = i;
    }
}
