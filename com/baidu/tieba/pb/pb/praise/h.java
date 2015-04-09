package com.baidu.tieba.pb.pb.praise;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.mvc.i.c {
    private com.baidu.tbadk.mvc.j.d<a, com.baidu.tbadk.mvc.e.c, b> bNl;
    private PraiseListActivity bNm;
    private View bNn;
    private ProgressBar bNo;
    private String head;
    private TextView mPageFootTextContinue;
    private TextView mPageFootTextMore;
    private View mPageFootView;
    private TextView mPageHeadText;
    private View mPageHeadView;
    private BdListView mPageListView;
    private NavigationBar mPageNavigationBar;
    private ProgressBar mPageProgressBar;

    public h(PraiseListActivity praiseListActivity) {
        super(praiseListActivity);
        this.bNl = null;
        this.bNm = null;
        this.bNn = null;
        this.mPageNavigationBar = null;
        this.mPageHeadView = null;
        this.mPageHeadText = null;
        this.mPageListView = null;
        this.mPageFootView = null;
        this.mPageFootTextContinue = null;
        this.mPageFootTextMore = null;
        this.mPageProgressBar = null;
        this.bNo = null;
        this.bNm = praiseListActivity;
        zZ().addEventDelegate(this);
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int ou() {
        return w.zan_list_activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void ov() {
        this.bNn = getView().findViewById(v.zan_list_page_parent);
        this.mPageNavigationBar = (NavigationBar) getView().findViewById(v.zan_list_page_navigationbar);
        this.mPageListView = (BdListView) getView().findViewById(v.zan_list_page_list);
        this.mPageProgressBar = (ProgressBar) getView().findViewById(v.zan_list_page_progress);
        this.bNl = new com.baidu.tbadk.mvc.j.d<>(this.amj.getPageContext(), b.class, w.zan_list_item, null);
        this.bNl.a(com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.w.cq(y.praise_list_no_data), (u) null, (FrameLayout.LayoutParams) null);
        this.mPageListView.setAdapter((ListAdapter) this.bNl);
        this.mPageNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mPageNavigationBar.setTitleText("");
        this.mPageHeadView = getLayoutInflater().inflate(w.zan_list_head, (ViewGroup) null);
        this.mPageHeadView.setOnClickListener(this.bNm);
        this.mPageHeadText = (TextView) this.mPageHeadView.findViewById(v.zan_list_head_text);
        this.mPageListView.addHeaderView(this.mPageHeadView);
        this.mPageFootView = getLayoutInflater().inflate(w.zan_list_foot, (ViewGroup) null);
        this.mPageFootTextContinue = (TextView) this.mPageFootView.findViewById(v.zan_list_foot_text_continue);
        this.mPageFootTextMore = (TextView) this.mPageFootView.findViewById(v.zan_list_foot_text_more);
        this.bNo = (ProgressBar) this.mPageFootView.findViewById(v.zan_list_foot_progress);
        zZ().setViewClickListener(this.mPageFootTextContinue, BK());
        this.mPageFootView.setVisibility(8);
        this.mPageListView.addFooterView(this.mPageFootView);
        this.mPageListView.setOnItemClickListener(this.bNm);
        this.mPageHeadText.setText(this.head);
        BJ();
        dY(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void g(Bundle bundle) {
        super.g(bundle);
        this.head = bundle.getString(com.baidu.tbadk.core.frameworkData.a.POST_DESC);
    }

    public void dY(boolean z) {
        if (z) {
            this.bNo.setVisibility(0);
        } else {
            this.mPageProgressBar.setVisibility(0);
        }
    }

    public void stopLoadData() {
        this.mPageProgressBar.setVisibility(8);
        this.bNo.setVisibility(8);
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof c) {
            c cVar = (c) aVar;
            int abU = cVar.abU();
            List<a> abW = cVar.abW();
            int abU2 = cVar.abU() - cVar.abV();
            stopLoadData();
            if (abU > 0) {
                this.mPageNavigationBar.setTitleText(String.format(this.bNm.getPageContext().getString(y.praise_list_title_count), Integer.valueOf(abU)));
            } else {
                this.mPageNavigationBar.setTitleText("");
            }
            if (abW == null || abW.size() < 1) {
                this.bNl.r(new ArrayList());
                showNoData();
                return;
            }
            this.bNl.r(abW);
            switch (cVar.getStatus()) {
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
                    ba.i(this.mPageFootView, com.baidu.tieba.u.bg_pack);
                    this.mPageFootTextContinue.setVisibility(8);
                    this.mPageFootTextMore.setVisibility(0);
                    this.mPageFootTextMore.setText(String.format(this.bNm.getPageContext().getString(y.praise_item_more), Integer.valueOf(abU2)));
                    return;
                default:
                    this.mPageFootView.setVisibility(8);
                    return;
            }
        }
    }

    public void showNoData() {
        this.mPageProgressBar.setVisibility(8);
        this.bNo.setVisibility(8);
        this.mPageFootView.setVisibility(8);
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        super.a(tbPageContext, i);
        com.baidu.tbadk.f.a.a(tbPageContext, this.bNn);
        com.baidu.tbadk.f.a.a(tbPageContext, this.mPageHeadView);
        com.baidu.tbadk.f.a.a(tbPageContext, this.mPageFootView);
        this.mPageNavigationBar.onChangeSkinType(tbPageContext, i);
        this.bNl.a(tbPageContext, i);
        ba.i(this.mPageFootView, com.baidu.tieba.u.bg_pack);
        return true;
    }

    public View getPageHeadView() {
        return this.mPageHeadView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void a(ErrorData errorData) {
        stopLoadData();
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void os() {
        stopLoadData();
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void ot() {
        dY(true);
    }
}
