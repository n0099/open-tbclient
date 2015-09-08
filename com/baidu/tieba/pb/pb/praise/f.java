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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.u;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.f<PraiseListActivity> {
    private c cgI;
    private PraiseListActivity cgJ;
    private View cgK;
    private ProgressBar cgL;
    private TextView mPageFootTextContinue;
    private TextView mPageFootTextMore;
    private View mPageFootView;
    private View mPageHasDataParent;
    private TextView mPageHeadText;
    private View mPageHeadView;
    private BdListView mPageListView;
    private NavigationBar mPageNavigationBar;
    private u mPageNoDataView;
    private ProgressBar mPageProgressBar;

    public f(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.cgI = null;
        this.cgJ = null;
        this.cgK = null;
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
        this.cgL = null;
        this.cgJ = praiseListActivity;
        praiseListActivity.setContentView(i.g.zan_list_activity);
        this.cgK = praiseListActivity.findViewById(i.f.zan_list_page_parent);
        this.mPageNavigationBar = (NavigationBar) praiseListActivity.findViewById(i.f.zan_list_page_navigationbar);
        this.mPageHasDataParent = praiseListActivity.findViewById(i.f.zan_list_page_frame);
        this.mPageNoDataView = NoDataViewFactory.a(this.cgJ.getPageContext().getContext(), this.cgK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cJ(i.h.praise_list_no_data), null);
        this.mPageListView = (BdListView) praiseListActivity.findViewById(i.f.zan_list_page_list);
        this.mPageProgressBar = (ProgressBar) praiseListActivity.findViewById(i.f.zan_list_page_progress);
        this.cgI = new c(praiseListActivity);
        this.mPageListView.setAdapter((ListAdapter) this.cgI);
        this.mPageListView.setOnScrollListener(this.cgI);
        this.mPageNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mPageNavigationBar.setTitleText("");
        this.mPageHeadView = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(i.g.zan_list_head, (ViewGroup) null);
        this.mPageHeadView.setOnClickListener(praiseListActivity);
        this.mPageHeadText = (TextView) this.mPageHeadView.findViewById(i.f.zan_list_head_text);
        this.mPageHeadText.setText(str);
        this.mPageListView.addHeaderView(this.mPageHeadView);
        this.mPageFootView = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(i.g.zan_list_foot, (ViewGroup) null);
        this.mPageFootTextContinue = (TextView) this.mPageFootView.findViewById(i.f.zan_list_foot_text_continue);
        this.mPageFootTextMore = (TextView) this.mPageFootView.findViewById(i.f.zan_list_foot_text_more);
        this.cgL = (ProgressBar) this.mPageFootView.findViewById(i.f.zan_list_foot_progress);
        this.mPageFootTextContinue.setOnClickListener(praiseListActivity);
        this.mPageListView.addFooterView(this.mPageFootView);
        this.mPageListView.setOnItemClickListener(praiseListActivity);
    }

    public void refreshList() {
        if (this.cgI != null) {
            this.cgI.notifyDataSetChanged();
        }
    }

    public void eM(boolean z) {
        if (z) {
            this.cgL.setVisibility(0);
        } else {
            this.mPageProgressBar.setVisibility(0);
        }
    }

    public void stopLoadData() {
        this.mPageProgressBar.setVisibility(8);
        this.cgL.setVisibility(8);
    }

    public boolean isLoading() {
        return this.mPageProgressBar.getVisibility() == 0 || this.cgL.getVisibility() == 0;
    }

    public void updateData(int i, List<a> list, int i2, int i3) {
        this.mPageProgressBar.setVisibility(8);
        this.cgL.setVisibility(8);
        if (i > 0) {
            this.mPageNavigationBar.setTitleText(String.format(this.cgJ.getResources().getString(i.h.praise_list_title_count), Integer.valueOf(i)));
        } else {
            this.mPageNavigationBar.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            showNoData();
            return;
        }
        this.mPageHasDataParent.setVisibility(0);
        this.mPageNoDataView.setVisibility(8);
        this.cgI.setZanItemDataList(list);
        this.cgI.notifyDataSetChanged();
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
                al.h(this.mPageFootView, i.e.bg_pack);
                this.mPageFootTextContinue.setVisibility(8);
                this.mPageFootTextMore.setVisibility(0);
                this.mPageFootTextMore.setText(String.format(this.cgJ.getResources().getString(i.h.praise_item_more), Integer.valueOf(i3)));
                return;
            default:
                this.mPageFootView.setVisibility(8);
                return;
        }
    }

    public void showNoData() {
        this.mPageProgressBar.setVisibility(8);
        this.cgL.setVisibility(8);
        this.mPageHasDataParent.setVisibility(8);
        this.mPageNoDataView.setVisibility(0);
    }

    public void changeSkinType(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.ad(i == 1);
            cVar.k(this.cgK);
            cVar.k(this.mPageHeadView);
            cVar.k(this.mPageFootView);
            this.mPageNavigationBar.onChangeSkinType(this.cgJ.getPageContext(), i);
            al.h(this.mPageFootView, i.e.bg_pack);
            if (this.mPageNoDataView != null) {
                this.mPageNoDataView.onChangeSkinType(this.cgJ.getPageContext(), i);
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
