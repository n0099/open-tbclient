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
/* loaded from: classes7.dex */
public class a {
    private BdTypeRecyclerView Zq;
    private TbPageContext eWx;
    private PbListView gCf;
    private n mGc;
    private PersonCenterTabBaseFragment mGd;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tbadk.n.b lTu = null;
    private int mSubType = 1010;

    public a(TbPageContext tbPageContext, View view, PersonCenterTabBaseFragment personCenterTabBaseFragment) {
        this.eWx = tbPageContext;
        this.mRootView = view;
        this.mGd = personCenterTabBaseFragment;
        initUI();
    }

    private void initUI() {
        this.Zq = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.new_person_center_common_lv);
        this.Zq.setLayoutManager(new LinearLayoutManager(this.Zq.getContext()) { // from class: com.baidu.tieba.personPolymeric.tab.view.a.1
            @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
                return false;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
                return false;
            }
        });
        this.Zq.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.a.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (a.this.lTu == null) {
                    a.this.lTu = new com.baidu.tbadk.n.b();
                    a.this.lTu.setSubType(a.this.mSubType);
                }
                if (i == 0) {
                    a.this.lTu.bEd();
                } else {
                    a.this.lTu.bEc();
                }
            }
        });
        this.gCf = new PbListView(this.eWx.getPageActivity());
        this.gCf.createView();
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gCf.setHeight(l.getDimens(this.eWx.getPageActivity(), R.dimen.tbds182));
        this.gCf.setLineGone();
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.mGc = new n(this.eWx, this.Zq, this.mGd.getUniqueId());
        this.mGc.setIsHost(this.mGd.isHost());
        this.mGc.GY(32);
        int i = 0;
        if (this.mGd.isHost()) {
            if (this.mGd instanceof PersonCenterDynamicTabFragment) {
                i = 4;
            } else if (this.mGd instanceof PersonCenterThreadTabFragment) {
                i = 6;
            }
        }
        this.mGc.GZ(i);
        this.mGc.setTabType(this.mGd.getTabType());
    }

    public void addHeaderView(View view) {
        this.Zq.addHeaderView(view);
    }

    public void b(BdListView.e eVar) {
        this.Zq.setOnSrollToBottomListener(eVar);
    }

    public void onDestroy() {
        if (this.lTu != null) {
            this.lTu.bEe();
        }
        this.Zq.setOnSrollToBottomListener(null);
    }

    public void fD(List<com.baidu.adp.widget.ListView.n> list) {
        if (y.isEmpty(list)) {
            bSE();
            if (this.Zq.getHeaderViewsCount() == 0) {
                Db(R.string.person_center_listempty_txt);
            }
        } else if (this.mNoDataView != null && this.mNoDataView.getParent() != null) {
            this.Zq.removeHeaderView(this.mNoDataView);
        }
        this.Zq.setData(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.mGd.getTabType())));
    }

    private void Db(int i) {
        String string;
        if (this.mGd.getTabType() == 1) {
            string = this.mGd.getResources().getString(R.string.person_center_listempty_dynamic_txt);
        } else {
            string = this.mGd.getResources().getString(R.string.person_center_listempty_thread_txt);
        }
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eWx.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.d.dS(null, string), null);
        }
        this.mNoDataView.onChangeSkinType(this.eWx, TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.Zq.removeHeaderView(this.mNoDataView);
        this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.Zq.addHeaderView(this.mNoDataView);
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
        if (this.mGc != null) {
            this.mGc.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eWx, i);
        }
        if (this.gCf != null) {
            this.gCf.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gCf.changeSkin(i);
        }
    }

    public n dzD() {
        return this.mGc;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void Xa() {
        this.Zq.setNextPage(this.gCf);
        this.gCf.showEmptyView(0);
        this.gCf.startLoadData();
    }

    public void Xb() {
        this.Zq.setNextPage(this.gCf);
        this.gCf.showEmptyView(0);
        this.gCf.endLoadData();
        this.gCf.setText(this.eWx.getString(R.string.list_no_more));
    }

    public void bSE() {
        this.Zq.setNextPage(null);
    }

    public void cCm() {
        this.Zq.smoothScrollToPosition(0);
    }

    public void Hg(int i) {
        this.Zq.setNextPage(this.gCf);
        this.gCf.showEmptyView(0);
        this.gCf.endLoadData();
        this.gCf.setText(this.eWx.getString(i));
    }

    public void setSubType(int i) {
        this.mSubType = i;
    }
}
