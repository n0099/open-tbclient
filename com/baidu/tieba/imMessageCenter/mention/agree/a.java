package com.baidu.tieba.imMessageCenter.mention.agree;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.base.d;
import com.baidu.tieba.imMessageCenter.mention.base.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class a {
    private BdTypeRecyclerView WM;
    private TbPageContext ehG;
    private NoNetworkView fHl;
    private PbListView fHm;
    protected BdSwipeRefreshLayout fJy;
    private View jOH;
    private InterfaceC0725a jOI;
    private e jOd;
    private boolean jOe;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private g mPullView;
    private View.OnClickListener jOi = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.fHm != null && a.this.jOI != null) {
                a.this.fHm.showEmptyView(0);
                a.this.fHm.setOnClickListener(null);
                a.this.fHm.startLoadData();
                a.this.jOI.cdG();
            }
        }
    };
    private final f.c fOd = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                if (a.this.jOI != null) {
                    a.this.jOI.cso();
                }
            } else if (a.this.fJy != null) {
                a.this.fJy.setRefreshing(false);
            }
        }
    };

    /* renamed from: com.baidu.tieba.imMessageCenter.mention.agree.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC0725a {
        void cdG();

        void cso();
    }

    public a(TbPageContext tbPageContext, View view) {
        this.ehG = tbPageContext;
        this.jOH = view.findViewById(R.id.agree_me_layout);
        w(tbPageContext);
        this.jOd = new e(tbPageContext, this.WM);
    }

    public void a(InterfaceC0725a interfaceC0725a) {
        this.jOI = interfaceC0725a;
    }

    private void w(TbPageContext tbPageContext) {
        if (this.jOH != null) {
            if (this.mPullView == null) {
                this.mPullView = new g(tbPageContext);
                this.mPullView.setListPullRefreshListener(this.fOd);
            }
            this.mPullView.setTag(tbPageContext.getUniqueId());
            if (this.fHm == null) {
                this.fHm = new PbListView(tbPageContext.getPageActivity());
                this.fHm.getView();
            }
            this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.fHm.setHeight(l.getDimens(tbPageContext.getContext(), R.dimen.tbds182));
            this.fHm.setLineGone();
            this.fHm.setTextSize(R.dimen.tbfontsize33);
            this.fHm.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fHm.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fHm.setOnClickListener(this.jOi);
            this.fHl = (NoNetworkView) this.jOH.findViewById(R.id.no_networkview);
            this.fHl.onChangeSkinType(this.ehG, TbadkCoreApplication.getInst().getSkinType());
            this.mContainer = (RelativeLayout) this.jOH.findViewById(R.id.container);
            this.mNavigationBar = (NavigationBar) this.jOH.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.ehG.getString(R.string.agree_me));
            this.fJy = (BdSwipeRefreshLayout) this.jOH.findViewById(R.id.agree_me_pull_refresh_layout);
            this.fJy.setProgressView(this.mPullView);
            this.WM = (BdTypeRecyclerView) this.jOH.findViewById(R.id.agree_me_recycler_view);
            ((DefaultItemAnimator) this.WM.getItemAnimator()).setSupportsChangeAnimations(false);
            this.WM.setLayoutManager(new LinearLayoutManager(this.ehG.getContext()));
            this.WM.setFadingEdgeLength(0);
            this.WM.setBackgroundColor(ap.getColor(R.color.transparent));
            this.WM.setOverScrollMode(2);
            this.WM.addItemDecoration(new d());
            this.WM.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view = viewHolder.itemView;
                }
            });
            this.WM.setNextPage(this.fHm);
            this.WM.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.a.4
                @Override // com.baidu.adp.widget.ListView.BdListView.e
                public void onScrollToBottom() {
                    if (a.this.fHm != null && a.this.jOI != null) {
                        a.this.fHm.showEmptyView(0);
                        a.this.fHm.setOnClickListener(null);
                        a.this.fHm.showLoading();
                        a.this.jOI.cdG();
                    }
                }
            });
        }
    }

    public void c(boolean z, ArrayList<q> arrayList) {
        if (this.fJy != null && this.fHm != null && this.WM != null && this.jOd != null) {
            this.fJy.setRefreshing(false);
            if (z) {
                this.fHm.showEmptyView(0);
                this.fHm.endLoadData();
                this.fHm.setOnClickListener(this.jOi);
            } else {
                this.fHm.showEmptyView(0);
                this.fHm.endLoadData();
                this.fHm.setText(this.ehG.getResources().getString(R.string.list_no_more));
                this.fHm.setOnClickListener(null);
            }
            if (y.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.ehG.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.d.dG(null, this.ehG.getResources().getString(R.string.agree_me_nodata)), null);
                    this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                    ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.jOe) {
                    this.jOe = true;
                    this.WM.addHeaderView(this.mNoDataView, 0);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.ehG, TbadkCoreApplication.getInst().getSkinType());
                }
                this.WM.setNextPage(null);
                return;
            }
            this.WM.removeHeaderView(this.mNoDataView);
            this.jOe = false;
            this.WM.setNextPage(this.fHm);
            this.jOd.setData(arrayList);
            this.jOd.notifyDataSetChanged();
        }
    }

    public void rr(boolean z) {
        if (this.fJy != null) {
            this.fJy.setRefreshing(z);
        }
    }

    public void changeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fHl != null) {
            this.fHl.onChangeSkinType(this.ehG, i);
        }
        if (this.fHm != null) {
            this.fHm.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fHm.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.ehG, i);
            ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.ehG, i);
        }
        if (this.jOd != null) {
            this.jOd.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.jOH, R.color.cp_bg_line_e);
        ap.setBackgroundColor(this.mContainer, R.color.cp_bg_line_e);
        ap.setBackgroundColor(this.fJy, R.color.cp_bg_line_e);
        ap.setBackgroundColor(this.WM, R.color.cp_bg_line_c);
    }

    public void onDestroy() {
        if (this.jOd != null) {
            this.jOd.onDestory();
        }
        if (this.mPullView != null) {
            this.mPullView.release();
        }
    }

    public void e(ab abVar) {
        if (this.jOd != null) {
            this.jOd.e(abVar);
        }
    }

    public List<q> getDatas() {
        if (this.WM == null) {
            return null;
        }
        return this.WM.getData();
    }

    public View getRootView() {
        return this.jOH;
    }

    public RelativeLayout bHE() {
        return this.mContainer;
    }
}
