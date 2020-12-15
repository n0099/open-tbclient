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
    private BdTypeRecyclerView Yf;
    private TbPageContext eNx;
    private PbListView grg;
    private NoDataView mNoDataView;
    private View mRootView;
    private n mtZ;
    private PersonCenterTabBaseFragment mua;
    private com.baidu.tbadk.n.b lHz = null;
    private int mSubType = 1010;

    public a(TbPageContext tbPageContext, View view, PersonCenterTabBaseFragment personCenterTabBaseFragment) {
        this.eNx = tbPageContext;
        this.mRootView = view;
        this.mua = personCenterTabBaseFragment;
        initUI();
    }

    private void initUI() {
        this.Yf = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.new_person_center_common_lv);
        this.Yf.setLayoutManager(new LinearLayoutManager(this.Yf.getContext()) { // from class: com.baidu.tieba.personPolymeric.tab.view.a.1
            @Override // android.support.v7.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
                return false;
            }

            @Override // android.support.v7.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
                return false;
            }
        });
        this.Yf.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.a.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (a.this.lHz == null) {
                    a.this.lHz = new com.baidu.tbadk.n.b();
                    a.this.lHz.setSubType(a.this.mSubType);
                }
                if (i == 0) {
                    a.this.lHz.bFe();
                } else {
                    a.this.lHz.bFd();
                }
            }
        });
        this.grg = new PbListView(this.eNx.getPageActivity());
        this.grg.createView();
        this.grg.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.grg.setHeight(l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds182));
        this.grg.setLineGone();
        this.grg.setTextSize(R.dimen.tbfontsize33);
        this.grg.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.grg.setNoMoreTextColorId(R.color.CAM_X0110);
        this.mtZ = new n(this.eNx, this.Yf, this.mua.getUniqueId());
        this.mtZ.setIsHost(this.mua.isHost());
        this.mtZ.Iq(32);
        int i = 0;
        if (this.mua.isHost()) {
            if (this.mua instanceof PersonCenterDynamicTabFragment) {
                i = 4;
            } else if (this.mua instanceof PersonCenterThreadTabFragment) {
                i = 6;
            }
        }
        this.mtZ.Ir(i);
        this.mtZ.setTabType(this.mua.getTabType());
    }

    public void addHeaderView(View view) {
        this.Yf.addHeaderView(view);
    }

    public void b(BdListView.e eVar) {
        this.Yf.setOnSrollToBottomListener(eVar);
    }

    public void onDestroy() {
        if (this.lHz != null) {
            this.lHz.bFf();
        }
        this.Yf.setOnSrollToBottomListener(null);
    }

    public void fF(List<q> list) {
        if (y.isEmpty(list)) {
            bTb();
            if (this.Yf.getHeaderViewsCount() == 0) {
                Ed(R.string.person_center_listempty_txt);
            }
        } else if (this.mNoDataView != null && this.mNoDataView.getParent() != null) {
            this.Yf.removeHeaderView(this.mNoDataView);
        }
        this.Yf.setData(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.mua.getTabType())));
    }

    private void Ed(int i) {
        String string;
        if (this.mua.getTabType() == 1) {
            string = this.mua.getResources().getString(R.string.person_center_listempty_dynamic_txt);
        } else {
            string = this.mua.getResources().getString(R.string.person_center_listempty_thread_txt);
        }
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eNx.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.d.dZ(null, string), null);
        }
        this.mNoDataView.onChangeSkinType(this.eNx, TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.Yf.removeHeaderView(this.mNoDataView);
        this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.Yf.addHeaderView(this.mNoDataView);
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
        if (this.mtZ != null) {
            this.mtZ.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eNx, i);
        }
        if (this.grg != null) {
            this.grg.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.grg.changeSkin(i);
        }
    }

    public n dBg() {
        return this.mtZ;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void XZ() {
        this.Yf.setNextPage(this.grg);
        this.grg.showEmptyView(0);
        this.grg.startLoadData();
    }

    public void Ya() {
        this.Yf.setNextPage(this.grg);
        this.grg.showEmptyView(0);
        this.grg.endLoadData();
        this.grg.setText(this.eNx.getString(R.string.list_no_more));
    }

    public void bTb() {
        this.Yf.setNextPage(null);
    }

    public void cBM() {
        this.Yf.smoothScrollToPosition(0);
    }

    public void Iy(int i) {
        this.Yf.setNextPage(this.grg);
        this.grg.showEmptyView(0);
        this.grg.endLoadData();
        this.grg.setText(this.eNx.getString(i));
    }

    public void setSubType(int i) {
        this.mSubType = i;
    }
}
