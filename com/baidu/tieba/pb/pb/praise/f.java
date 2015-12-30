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
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.f<PraiseListActivity> {
    private c cKN;
    private PraiseListActivity cKO;
    private View cKP;
    private ProgressBar cKQ;
    private TextView mPageFootTextContinue;
    private TextView mPageFootTextMore;
    private View mPageFootView;
    private View mPageHasDataParent;
    private TextView mPageHeadText;
    private View mPageHeadView;
    private BdListView mPageListView;
    private NavigationBar mPageNavigationBar;
    private o mPageNoDataView;
    private ProgressBar mPageProgressBar;

    public f(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity.getPageContext());
        this.cKN = null;
        this.cKO = null;
        this.cKP = null;
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
        this.cKQ = null;
        this.cKO = praiseListActivity;
        praiseListActivity.setContentView(n.h.zan_list_activity);
        this.cKP = praiseListActivity.findViewById(n.g.zan_list_page_parent);
        this.mPageNavigationBar = (NavigationBar) praiseListActivity.findViewById(n.g.zan_list_page_navigationbar);
        this.mPageHasDataParent = praiseListActivity.findViewById(n.g.zan_list_page_frame);
        this.mPageNoDataView = NoDataViewFactory.a(this.cKO.getPageContext().getContext(), this.cKP, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cM(n.j.praise_list_no_data), null);
        this.mPageListView = (BdListView) praiseListActivity.findViewById(n.g.zan_list_page_list);
        this.mPageProgressBar = (ProgressBar) praiseListActivity.findViewById(n.g.zan_list_page_progress);
        this.cKN = new c(praiseListActivity);
        this.mPageListView.setAdapter((ListAdapter) this.cKN);
        this.mPageListView.setOnScrollListener(this.cKN);
        this.mPageNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mPageNavigationBar.setTitleText("");
        this.mPageHeadView = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(n.h.zan_list_head, (ViewGroup) null);
        this.mPageHeadView.setOnClickListener(praiseListActivity);
        this.mPageHeadText = (TextView) this.mPageHeadView.findViewById(n.g.zan_list_head_text);
        this.mPageHeadText.setText(str);
        this.mPageListView.addHeaderView(this.mPageHeadView);
        this.mPageFootView = LayoutInflater.from(praiseListActivity.getPageContext().getContext()).inflate(n.h.zan_list_foot, (ViewGroup) null);
        this.mPageFootTextContinue = (TextView) this.mPageFootView.findViewById(n.g.zan_list_foot_text_continue);
        this.mPageFootTextMore = (TextView) this.mPageFootView.findViewById(n.g.zan_list_foot_text_more);
        this.cKQ = (ProgressBar) this.mPageFootView.findViewById(n.g.zan_list_foot_progress);
        this.mPageFootTextContinue.setOnClickListener(praiseListActivity);
        this.mPageListView.addFooterView(this.mPageFootView);
        this.mPageListView.setOnItemClickListener(praiseListActivity);
    }

    public void refreshList() {
        if (this.cKN != null) {
            this.cKN.notifyDataSetChanged();
        }
    }

    public void fx(boolean z) {
        if (z) {
            this.cKQ.setVisibility(0);
        } else {
            this.mPageProgressBar.setVisibility(0);
        }
    }

    public void stopLoadData() {
        this.mPageProgressBar.setVisibility(8);
        this.cKQ.setVisibility(8);
    }

    public boolean isLoading() {
        return this.mPageProgressBar.getVisibility() == 0 || this.cKQ.getVisibility() == 0;
    }

    public void updateData(int i, List<a> list, int i2, int i3) {
        this.mPageProgressBar.setVisibility(8);
        this.cKQ.setVisibility(8);
        if (i > 0) {
            this.mPageNavigationBar.setTitleText(String.format(this.cKO.getResources().getString(n.j.praise_list_title_count), Integer.valueOf(i)));
        } else {
            this.mPageNavigationBar.setTitleText("");
        }
        if (list == null || list.size() < 1) {
            showNoData();
            return;
        }
        this.mPageHasDataParent.setVisibility(0);
        this.mPageNoDataView.setVisibility(8);
        this.cKN.setZanItemDataList(list);
        this.cKN.notifyDataSetChanged();
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
                as.i(this.mPageFootView, n.f.bg_pack);
                this.mPageFootTextContinue.setVisibility(8);
                this.mPageFootTextMore.setVisibility(0);
                this.mPageFootTextMore.setText(String.format(this.cKO.getResources().getString(n.j.praise_item_more), Integer.valueOf(i3)));
                return;
            default:
                this.mPageFootView.setVisibility(8);
                return;
        }
    }

    public void showNoData() {
        this.mPageProgressBar.setVisibility(8);
        this.cKQ.setVisibility(8);
        this.mPageHasDataParent.setVisibility(8);
        this.mPageNoDataView.setVisibility(0);
    }

    public void changeSkinType(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.ac(i == 1);
            cVar.k(this.cKP);
            cVar.k(this.mPageHeadView);
            cVar.k(this.mPageFootView);
            this.mPageNavigationBar.onChangeSkinType(this.cKO.getPageContext(), i);
            as.i(this.mPageFootView, n.f.bg_pack);
            if (this.mPageNoDataView != null) {
                this.mPageNoDataView.onChangeSkinType(this.cKO.getPageContext(), i);
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
