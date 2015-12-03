package com.baidu.tieba.pb.pb.praise;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.n;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.f<PraiseListActivity> {
    private c cGO;
    private PraiseListActivity cGP;
    private View cGQ;
    private ProgressBar cGR;
    private TextView mPageFootTextContinue;
    private TextView mPageFootTextMore;
    private View mPageFootView;
    private View mPageHasDataParent;
    private TextView mPageHeadText;
    private View mPageHeadView;
    private BdListView mPageListView;
    private NavigationBar mPageNavigationBar;
    private n mPageNoDataView;
    private ProgressBar mPageProgressBar;

    public f(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.cGO = null;
        this.cGP = null;
        this.cGQ = null;
        this.mPageNavigationBar = null;
        this.mPageHasDataParent = null;
        this.mPageNoDataView = null;
        this.mPageHeadView = null;
        this.mPageHeadText = null;
        this.mPageListView = null;
        this.mPageFootView = null;
        this.mPageFootTextContinue = null;
        this.mPageFootTextMore = null;
        this.mPageProgressBar = null;
        this.cGR = null;
        this.cGP = praiseListActivity;
        praiseListActivity.setContentView(n.g.zan_list_activity);
        this.cGQ = praiseListActivity.findViewById(n.f.zan_list_page_parent);
        this.mPageNavigationBar = (NavigationBar) praiseListActivity.findViewById(n.f.zan_list_page_navigationbar);
        this.mPageHasDataParent = praiseListActivity.findViewById(n.f.zan_list_page_frame);
        this.mPageNoDataView = NoDataViewFactory.a(this.cGP.getPageContext().getContext(), this.cGQ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cS(n.i.praise_list_no_data), null);
        this.mPageListView = (BdListView) praiseListActivity.findViewById(n.f.zan_list_page_list);
        this.mPageProgressBar = (ProgressBar) praiseListActivity.findViewById(n.f.zan_list_page_progress);
        this.cGO = new c(praiseListActivity);
        this.mPageListView.setAdapter((ListAdapter) this.cGO);
        this.mPageListView.setOnScrollListener(this.cGO);
        this.mPageNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mPageNavigationBar.setTitleText("");
        this.mPageHeadView = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(n.g.zan_list_head, (ViewGroup) null);
        this.mPageHeadView.setOnClickListener(praiseListActivity);
        this.mPageHeadText = (TextView) this.mPageHeadView.findViewById(n.f.zan_list_head_text);
        this.mPageHeadText.setText(str);
        this.mPageListView.addHeaderView(this.mPageHeadView);
        this.mPageFootView = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(n.g.zan_list_foot, (ViewGroup) null);
        this.mPageFootTextContinue = (TextView) this.mPageFootView.findViewById(n.f.zan_list_foot_text_continue);
        this.mPageFootTextMore = (TextView) this.mPageFootView.findViewById(n.f.zan_list_foot_text_more);
        this.cGR = (ProgressBar) this.mPageFootView.findViewById(n.f.zan_list_foot_progress);
        this.mPageFootTextContinue.setOnClickListener(praiseListActivity);
        this.mPageListView.addFooterView(this.mPageFootView);
        this.mPageListView.setOnItemClickListener(praiseListActivity);
    }

    public void refreshList() {
        if (this.cGO != null) {
            this.cGO.notifyDataSetChanged();
        }
    }

    public void fy(boolean z) {
        if (z) {
            this.cGR.setVisibility(0);
        } else {
            this.mPageProgressBar.setVisibility(0);
        }
    }

    public void stopLoadData() {
        this.mPageProgressBar.setVisibility(8);
        this.cGR.setVisibility(8);
    }

    public boolean isLoading() {
        return this.mPageProgressBar.getVisibility() == 0 || this.cGR.getVisibility() == 0;
    }

    public void updateData(int i, List<a> list, int i2, int i3) {
        this.mPageProgressBar.setVisibility(8);
        this.cGR.setVisibility(8);
        if (i > 0) {
            this.mPageNavigationBar.setTitleText(String.format(this.cGP.getResources().getString(n.i.praise_list_title_count), Integer.valueOf(i)));
        } else {
            this.mPageNavigationBar.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            showNoData();
            return;
        }
        this.mPageHasDataParent.setVisibility(0);
        this.mPageNoDataView.setVisibility(8);
        this.cGO.setZanItemDataList(list);
        this.cGO.notifyDataSetChanged();
        switch (i2) {
            case BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES /* 1001 */:
                this.mPageFootView.setVisibility(0);
                this.mPageFootTextContinue.setVisibility(0);
                this.mPageFootTextMore.setVisibility(8);
                return;
            case BDLocationStatusCodes.GEOFENCE_SERVICE_NO_ALIVIABLE /* 1002 */:
                this.mPageFootView.setVisibility(8);
                return;
            case 1003:
                this.mPageFootView.setVisibility(0);
                TbadkCoreApplication.m411getInst().getSkinType();
                as.i(this.mPageFootView, n.e.bg_pack);
                this.mPageFootTextContinue.setVisibility(8);
                this.mPageFootTextMore.setVisibility(0);
                this.mPageFootTextMore.setText(String.format(this.cGP.getResources().getString(n.i.praise_item_more), Integer.valueOf(i3)));
                return;
            default:
                this.mPageFootView.setVisibility(8);
                return;
        }
    }

    public void showNoData() {
        this.mPageProgressBar.setVisibility(8);
        this.cGR.setVisibility(8);
        this.mPageHasDataParent.setVisibility(8);
        this.mPageNoDataView.setVisibility(0);
    }

    public void changeSkinType(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.af(i == 1);
            cVar.k(this.cGQ);
            cVar.k(this.mPageHeadView);
            cVar.k(this.mPageFootView);
            this.mPageNavigationBar.onChangeSkinType(this.cGP.getPageContext(), i);
            as.i(this.mPageFootView, n.e.bg_pack);
            if (this.mPageNoDataView != null) {
                this.mPageNoDataView.onChangeSkinType(this.cGP.getPageContext(), i);
            }
        }
    }

    public View getPageHeadView() {
        return this.mPageHeadView;
    }

    public View getPageFootContinue() {
        return this.mPageFootTextContinue;
    }
}
