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
/* loaded from: classes7.dex */
public class a {
    private BdTypeRecyclerView Ya;
    private TbPageContext eSJ;
    private PbListView gxy;
    private NoDataView mNoDataView;
    private View mRootView;
    private n muH;
    private PersonCenterTabBaseFragment muI;
    private com.baidu.tbadk.n.b lIj = null;
    private int mSubType = 1010;

    public a(TbPageContext tbPageContext, View view, PersonCenterTabBaseFragment personCenterTabBaseFragment) {
        this.eSJ = tbPageContext;
        this.mRootView = view;
        this.muI = personCenterTabBaseFragment;
        initUI();
    }

    private void initUI() {
        this.Ya = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.new_person_center_common_lv);
        this.Ya.setLayoutManager(new LinearLayoutManager(this.Ya.getContext()) { // from class: com.baidu.tieba.personPolymeric.tab.view.a.1
            @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
                return false;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
                return false;
            }
        });
        this.Ya.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.tab.view.a.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (a.this.lIj == null) {
                    a.this.lIj = new com.baidu.tbadk.n.b();
                    a.this.lIj.setSubType(a.this.mSubType);
                }
                if (i == 0) {
                    a.this.lIj.bDH();
                } else {
                    a.this.lIj.bDG();
                }
            }
        });
        this.gxy = new PbListView(this.eSJ.getPageActivity());
        this.gxy.createView();
        this.gxy.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gxy.setHeight(l.getDimens(this.eSJ.getPageActivity(), R.dimen.tbds182));
        this.gxy.setLineGone();
        this.gxy.setTextSize(R.dimen.tbfontsize33);
        this.gxy.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gxy.setNoMoreTextColorId(R.color.CAM_X0110);
        this.muH = new n(this.eSJ, this.Ya, this.muI.getUniqueId());
        this.muH.setIsHost(this.muI.isHost());
        this.muH.GD(32);
        int i = 0;
        if (this.muI.isHost()) {
            if (this.muI instanceof PersonCenterDynamicTabFragment) {
                i = 4;
            } else if (this.muI instanceof PersonCenterThreadTabFragment) {
                i = 6;
            }
        }
        this.muH.GE(i);
        this.muH.setTabType(this.muI.getTabType());
    }

    public void addHeaderView(View view) {
        this.Ya.addHeaderView(view);
    }

    public void b(BdListView.e eVar) {
        this.Ya.setOnSrollToBottomListener(eVar);
    }

    public void onDestroy() {
        if (this.lIj != null) {
            this.lIj.bDI();
        }
        this.Ya.setOnSrollToBottomListener(null);
    }

    public void fF(List<com.baidu.adp.widget.ListView.n> list) {
        if (x.isEmpty(list)) {
            bRO();
            if (this.Ya.getHeaderViewsCount() == 0) {
                CH(R.string.person_center_listempty_txt);
            }
        } else if (this.mNoDataView != null && this.mNoDataView.getParent() != null) {
            this.Ya.removeHeaderView(this.mNoDataView);
        }
        this.Ya.setData(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921435, Integer.valueOf(this.muI.getTabType())));
    }

    private void CH(int i) {
        String string;
        if (this.muI.getTabType() == 1) {
            string = this.muI.getResources().getString(R.string.person_center_listempty_dynamic_txt);
        } else {
            string = this.muI.getResources().getString(R.string.person_center_listempty_thread_txt);
        }
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eSJ.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds180)), NoDataViewFactory.d.dX(null, string), null);
        }
        this.mNoDataView.onChangeSkinType(this.eSJ, TbadkApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.Ya.removeHeaderView(this.mNoDataView);
        this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.Ya.addHeaderView(this.mNoDataView);
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
        if (this.muH != null) {
            this.muH.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eSJ, i);
        }
        if (this.gxy != null) {
            this.gxy.setTextColor(ao.getColor(R.color.CAM_X0107));
            this.gxy.changeSkin(i);
        }
    }

    public n dxe() {
        return this.muH;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void Vo() {
        this.Ya.setNextPage(this.gxy);
        this.gxy.showEmptyView(0);
        this.gxy.startLoadData();
    }

    public void Vp() {
        this.Ya.setNextPage(this.gxy);
        this.gxy.showEmptyView(0);
        this.gxy.endLoadData();
        this.gxy.setText(this.eSJ.getString(R.string.list_no_more));
    }

    public void bRO() {
        this.Ya.setNextPage(null);
    }

    public void cAO() {
        this.Ya.smoothScrollToPosition(0);
    }

    public void GL(int i) {
        this.Ya.setNextPage(this.gxy);
        this.gxy.showEmptyView(0);
        this.gxy.endLoadData();
        this.gxy.setText(this.eSJ.getString(i));
    }

    public void setSubType(int i) {
        this.mSubType = i;
    }
}
