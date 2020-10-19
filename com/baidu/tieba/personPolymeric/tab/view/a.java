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
    private BdTypeRecyclerView Xc;
    private TbPageContext etO;
    private PbListView fTv;
    private n lNc;
    private PersonCenterTabBaseFragment lNd;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tbadk.n.b laV = null;
    private int mSubType = 1010;

    public a(TbPageContext tbPageContext, View view, PersonCenterTabBaseFragment personCenterTabBaseFragment) {
        this.etO = tbPageContext;
        this.mRootView = view;
        this.lNd = personCenterTabBaseFragment;
        initUI();
    }

    private void initUI() {
        this.Xc = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.new_person_center_common_lv);
        this.Xc.setLayoutManager(new LinearLayoutManager(this.Xc.getContext()) { // from class: com.baidu.tieba.personPolymeric.tab.view.a.1
            @Override // android.support.v7.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
                return false;
            }

            @Override // android.support.v7.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
                return false;
            }
        });
        this.Xc.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.a.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (a.this.laV == null) {
                    a.this.laV = new com.baidu.tbadk.n.b();
                    a.this.laV.setSubType(a.this.mSubType);
                }
                if (i == 0) {
                    a.this.laV.bxT();
                } else {
                    a.this.laV.bxS();
                }
            }
        });
        this.fTv = new PbListView(this.etO.getPageActivity());
        this.fTv.createView();
        this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fTv.setHeight(l.getDimens(this.etO.getPageActivity(), R.dimen.tbds182));
        this.fTv.setLineGone();
        this.fTv.setTextSize(R.dimen.tbfontsize33);
        this.fTv.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fTv.setNoMoreTextColorId(R.color.cp_cont_e);
        this.lNc = new n(this.etO, this.Xc, this.lNd.getUniqueId());
        this.lNc.setIsHost(this.lNd.isHost());
        this.lNc.Gv(32);
        int i = 0;
        if (this.lNd.isHost()) {
            if (this.lNd instanceof PersonCenterDynamicTabFragment) {
                i = 4;
            } else if (this.lNd instanceof PersonCenterThreadTabFragment) {
                i = 6;
            }
        }
        this.lNc.Gw(i);
        this.lNc.setTabType(this.lNd.getTabType());
    }

    public void addHeaderView(View view) {
        this.Xc.addHeaderView(view);
    }

    public void b(BdListView.e eVar) {
        this.Xc.setOnSrollToBottomListener(eVar);
    }

    public void onDestroy() {
        if (this.laV != null) {
            this.laV.bxU();
        }
        this.Xc.setOnSrollToBottomListener(null);
    }

    public void fc(List<q> list) {
        if (y.isEmpty(list)) {
            bKU();
            if (this.Xc.getHeaderViewsCount() == 0) {
                Ck(R.string.person_center_listempty_txt);
            }
        } else if (this.mNoDataView != null && this.mNoDataView.getParent() != null) {
            this.Xc.removeHeaderView(this.mNoDataView);
        }
        this.Xc.setData(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.lNd.getTabType())));
    }

    private void Ck(int i) {
        String string;
        if (this.lNd.getTabType() == 1) {
            string = this.lNd.getResources().getString(R.string.person_center_listempty_dynamic_txt);
        } else {
            string = this.lNd.getResources().getString(R.string.person_center_listempty_thread_txt);
        }
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.etO.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.d.dL(null, string), null);
        }
        this.mNoDataView.onChangeSkinType(this.etO, TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.Xc.removeHeaderView(this.mNoDataView);
        this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.Xc.addHeaderView(this.mNoDataView);
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        if (this.lNc != null) {
            this.lNc.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.etO, i);
        }
        if (this.fTv != null) {
            this.fTv.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fTv.changeSkin(i);
        }
    }

    public n dqE() {
        return this.lNc;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void SI() {
        this.Xc.setNextPage(this.fTv);
        this.fTv.showEmptyView(0);
        this.fTv.startLoadData();
    }

    public void SJ() {
        this.Xc.setNextPage(this.fTv);
        this.fTv.showEmptyView(0);
        this.fTv.endLoadData();
        this.fTv.setText(this.etO.getString(R.string.list_no_more));
    }

    public void bKU() {
        this.Xc.setNextPage(null);
    }

    public void csk() {
        this.Xc.smoothScrollToPosition(0);
    }

    public void GD(int i) {
        this.Xc.setNextPage(this.fTv);
        this.fTv.showEmptyView(0);
        this.fTv.endLoadData();
        this.fTv.setText(this.etO.getString(i));
    }

    public void setSubType(int i) {
        this.mSubType = i;
    }
}
