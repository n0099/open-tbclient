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
/* loaded from: classes8.dex */
public class a {
    private BdTypeRecyclerView XW;
    private TbPageContext eUY;
    private PbListView gAi;
    private n mDL;
    private PersonCenterTabBaseFragment mDM;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tbadk.n.b lRd = null;
    private int mSubType = 1010;

    public a(TbPageContext tbPageContext, View view, PersonCenterTabBaseFragment personCenterTabBaseFragment) {
        this.eUY = tbPageContext;
        this.mRootView = view;
        this.mDM = personCenterTabBaseFragment;
        initUI();
    }

    private void initUI() {
        this.XW = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.new_person_center_common_lv);
        this.XW.setLayoutManager(new LinearLayoutManager(this.XW.getContext()) { // from class: com.baidu.tieba.personPolymeric.tab.view.a.1
            @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
                return false;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
                return false;
            }
        });
        this.XW.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.a.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (a.this.lRd == null) {
                    a.this.lRd = new com.baidu.tbadk.n.b();
                    a.this.lRd.setSubType(a.this.mSubType);
                }
                if (i == 0) {
                    a.this.lRd.bDZ();
                } else {
                    a.this.lRd.bDY();
                }
            }
        });
        this.gAi = new PbListView(this.eUY.getPageActivity());
        this.gAi.createView();
        this.gAi.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gAi.setHeight(l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds182));
        this.gAi.setLineGone();
        this.gAi.setTextSize(R.dimen.tbfontsize33);
        this.gAi.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gAi.setNoMoreTextColorId(R.color.CAM_X0110);
        this.mDL = new n(this.eUY, this.XW, this.mDM.getUniqueId());
        this.mDL.setIsHost(this.mDM.isHost());
        this.mDL.GV(32);
        int i = 0;
        if (this.mDM.isHost()) {
            if (this.mDM instanceof PersonCenterDynamicTabFragment) {
                i = 4;
            } else if (this.mDM instanceof PersonCenterThreadTabFragment) {
                i = 6;
            }
        }
        this.mDL.GW(i);
        this.mDL.setTabType(this.mDM.getTabType());
    }

    public void addHeaderView(View view) {
        this.XW.addHeaderView(view);
    }

    public void b(BdListView.e eVar) {
        this.XW.setOnSrollToBottomListener(eVar);
    }

    public void onDestroy() {
        if (this.lRd != null) {
            this.lRd.bEa();
        }
        this.XW.setOnSrollToBottomListener(null);
    }

    public void fD(List<com.baidu.adp.widget.ListView.n> list) {
        if (y.isEmpty(list)) {
            bSr();
            if (this.XW.getHeaderViewsCount() == 0) {
                CY(R.string.person_center_listempty_txt);
            }
        } else if (this.mNoDataView != null && this.mNoDataView.getParent() != null) {
            this.XW.removeHeaderView(this.mNoDataView);
        }
        this.XW.setData(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.mDM.getTabType())));
    }

    private void CY(int i) {
        String string;
        if (this.mDM.getTabType() == 1) {
            string = this.mDM.getResources().getString(R.string.person_center_listempty_dynamic_txt);
        } else {
            string = this.mDM.getResources().getString(R.string.person_center_listempty_thread_txt);
        }
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eUY.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.d.dS(null, string), null);
        }
        this.mNoDataView.onChangeSkinType(this.eUY, TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.XW.removeHeaderView(this.mNoDataView);
        this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.XW.addHeaderView(this.mNoDataView);
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
        if (this.mDL != null) {
            this.mDL.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eUY, i);
        }
        if (this.gAi != null) {
            this.gAi.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gAi.changeSkin(i);
        }
    }

    public n dzn() {
        return this.mDL;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void WX() {
        this.XW.setNextPage(this.gAi);
        this.gAi.showEmptyView(0);
        this.gAi.startLoadData();
    }

    public void WY() {
        this.XW.setNextPage(this.gAi);
        this.gAi.showEmptyView(0);
        this.gAi.endLoadData();
        this.gAi.setText(this.eUY.getString(R.string.list_no_more));
    }

    public void bSr() {
        this.XW.setNextPage(null);
    }

    public void cBZ() {
        this.XW.smoothScrollToPosition(0);
    }

    public void Hd(int i) {
        this.XW.setNextPage(this.gAi);
        this.gAi.showEmptyView(0);
        this.gAi.endLoadData();
        this.gAi.setText(this.eUY.getString(i));
    }

    public void setSubType(int i) {
        this.mSubType = i;
    }
}
