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
/* loaded from: classes23.dex */
public class a {
    private BdTypeRecyclerView Xi;
    private TbPageContext eGu;
    private PbListView giV;
    private NoDataView mNoDataView;
    private View mRootView;
    private n mfR;
    private PersonCenterTabBaseFragment mfS;
    private com.baidu.tbadk.n.b ltL = null;
    private int mSubType = 1010;

    public a(TbPageContext tbPageContext, View view, PersonCenterTabBaseFragment personCenterTabBaseFragment) {
        this.eGu = tbPageContext;
        this.mRootView = view;
        this.mfS = personCenterTabBaseFragment;
        initUI();
    }

    private void initUI() {
        this.Xi = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.new_person_center_common_lv);
        this.Xi.setLayoutManager(new LinearLayoutManager(this.Xi.getContext()) { // from class: com.baidu.tieba.personPolymeric.tab.view.a.1
            @Override // android.support.v7.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
                return false;
            }

            @Override // android.support.v7.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
                return false;
            }
        });
        this.Xi.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.a.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (a.this.ltL == null) {
                    a.this.ltL = new com.baidu.tbadk.n.b();
                    a.this.ltL.setSubType(a.this.mSubType);
                }
                if (i == 0) {
                    a.this.ltL.bBB();
                } else {
                    a.this.ltL.bBA();
                }
            }
        });
        this.giV = new PbListView(this.eGu.getPageActivity());
        this.giV.createView();
        this.giV.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.giV.setHeight(l.getDimens(this.eGu.getPageActivity(), R.dimen.tbds182));
        this.giV.setLineGone();
        this.giV.setTextSize(R.dimen.tbfontsize33);
        this.giV.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.giV.setNoMoreTextColorId(R.color.CAM_X0110);
        this.mfR = new n(this.eGu, this.Xi, this.mfS.getUniqueId());
        this.mfR.setIsHost(this.mfS.isHost());
        this.mfR.Hz(32);
        int i = 0;
        if (this.mfS.isHost()) {
            if (this.mfS instanceof PersonCenterDynamicTabFragment) {
                i = 4;
            } else if (this.mfS instanceof PersonCenterThreadTabFragment) {
                i = 6;
            }
        }
        this.mfR.HA(i);
        this.mfR.setTabType(this.mfS.getTabType());
    }

    public void addHeaderView(View view) {
        this.Xi.addHeaderView(view);
    }

    public void b(BdListView.e eVar) {
        this.Xi.setOnSrollToBottomListener(eVar);
    }

    public void onDestroy() {
        if (this.ltL != null) {
            this.ltL.bBC();
        }
        this.Xi.setOnSrollToBottomListener(null);
    }

    public void ft(List<q> list) {
        if (y.isEmpty(list)) {
            bPp();
            if (this.Xi.getHeaderViewsCount() == 0) {
                Do(R.string.person_center_listempty_txt);
            }
        } else if (this.mNoDataView != null && this.mNoDataView.getParent() != null) {
            this.Xi.removeHeaderView(this.mNoDataView);
        }
        this.Xi.setData(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.mfS.getTabType())));
    }

    private void Do(int i) {
        String string;
        if (this.mfS.getTabType() == 1) {
            string = this.mfS.getResources().getString(R.string.person_center_listempty_dynamic_txt);
        } else {
            string = this.mfS.getResources().getString(R.string.person_center_listempty_thread_txt);
        }
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eGu.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.d.dS(null, string), null);
        }
        this.mNoDataView.onChangeSkinType(this.eGu, TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.Xi.removeHeaderView(this.mNoDataView);
        this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.Xi.addHeaderView(this.mNoDataView);
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
        if (this.mfR != null) {
            this.mfR.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eGu, i);
        }
        if (this.giV != null) {
            this.giV.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.giV.changeSkin(i);
        }
    }

    public n dvN() {
        return this.mfR;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void Vz() {
        this.Xi.setNextPage(this.giV);
        this.giV.showEmptyView(0);
        this.giV.startLoadData();
    }

    public void VA() {
        this.Xi.setNextPage(this.giV);
        this.giV.showEmptyView(0);
        this.giV.endLoadData();
        this.giV.setText(this.eGu.getString(R.string.list_no_more));
    }

    public void bPp() {
        this.Xi.setNextPage(null);
    }

    public void cxv() {
        this.Xi.smoothScrollToPosition(0);
    }

    public void HH(int i) {
        this.Xi.setNextPage(this.giV);
        this.giV.showEmptyView(0);
        this.giV.endLoadData();
        this.giV.setText(this.eGu.getString(i));
    }

    public void setSubType(int i) {
        this.mSubType = i;
    }
}
