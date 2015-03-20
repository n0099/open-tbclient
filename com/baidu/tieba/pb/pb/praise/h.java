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
    private com.baidu.tbadk.mvc.j.d<a, com.baidu.tbadk.mvc.e.c, b> bMV;
    private PraiseListActivity bMW;
    private View bMX;
    private ProgressBar bMY;
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
        this.bMV = null;
        this.bMW = null;
        this.bMX = null;
        this.mPageNavigationBar = null;
        this.mPageHeadView = null;
        this.mPageHeadText = null;
        this.mPageListView = null;
        this.mPageFootView = null;
        this.mPageFootTextContinue = null;
        this.mPageFootTextMore = null;
        this.mPageProgressBar = null;
        this.bMY = null;
        this.bMW = praiseListActivity;
        zT().addEventDelegate(this);
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int ou() {
        return w.zan_list_activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void ov() {
        this.bMX = getView().findViewById(v.zan_list_page_parent);
        this.mPageNavigationBar = (NavigationBar) getView().findViewById(v.zan_list_page_navigationbar);
        this.mPageListView = (BdListView) getView().findViewById(v.zan_list_page_list);
        this.mPageProgressBar = (ProgressBar) getView().findViewById(v.zan_list_page_progress);
        this.bMV = new com.baidu.tbadk.mvc.j.d<>(this.amb.getPageContext(), b.class, w.zan_list_item, null);
        this.bMV.a(com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.w.cq(y.praise_list_no_data), (u) null, (FrameLayout.LayoutParams) null);
        this.mPageListView.setAdapter((ListAdapter) this.bMV);
        this.mPageNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mPageNavigationBar.setTitleText("");
        this.mPageHeadView = getLayoutInflater().inflate(w.zan_list_head, (ViewGroup) null);
        this.mPageHeadView.setOnClickListener(this.bMW);
        this.mPageHeadText = (TextView) this.mPageHeadView.findViewById(v.zan_list_head_text);
        this.mPageListView.addHeaderView(this.mPageHeadView);
        this.mPageFootView = getLayoutInflater().inflate(w.zan_list_foot, (ViewGroup) null);
        this.mPageFootTextContinue = (TextView) this.mPageFootView.findViewById(v.zan_list_foot_text_continue);
        this.mPageFootTextMore = (TextView) this.mPageFootView.findViewById(v.zan_list_foot_text_more);
        this.bMY = (ProgressBar) this.mPageFootView.findViewById(v.zan_list_foot_progress);
        zT().setViewClickListener(this.mPageFootTextContinue, BE());
        this.mPageFootView.setVisibility(8);
        this.mPageListView.addFooterView(this.mPageFootView);
        this.mPageListView.setOnItemClickListener(this.bMW);
        this.mPageHeadText.setText(this.head);
        BD();
        ea(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void g(Bundle bundle) {
        super.g(bundle);
        this.head = bundle.getString(com.baidu.tbadk.core.frameworkData.a.POST_DESC);
    }

    public void ea(boolean z) {
        if (z) {
            this.bMY.setVisibility(0);
        } else {
            this.mPageProgressBar.setVisibility(0);
        }
    }

    public void stopLoadData() {
        this.mPageProgressBar.setVisibility(8);
        this.bMY.setVisibility(8);
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof c) {
            c cVar = (c) aVar;
            int abF = cVar.abF();
            List<a> abH = cVar.abH();
            int abF2 = cVar.abF() - cVar.abG();
            stopLoadData();
            if (abF > 0) {
                this.mPageNavigationBar.setTitleText(String.format(this.bMW.getPageContext().getString(y.praise_list_title_count), Integer.valueOf(abF)));
            } else {
                this.mPageNavigationBar.setTitleText("");
            }
            if (abH == null || abH.size() < 1) {
                this.bMV.r(new ArrayList());
                showNoData();
                return;
            }
            this.bMV.r(abH);
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
                    this.mPageFootTextMore.setText(String.format(this.bMW.getPageContext().getString(y.praise_item_more), Integer.valueOf(abF2)));
                    return;
                default:
                    this.mPageFootView.setVisibility(8);
                    return;
            }
        }
    }

    public void showNoData() {
        this.mPageProgressBar.setVisibility(8);
        this.bMY.setVisibility(8);
        this.mPageFootView.setVisibility(8);
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        super.a(tbPageContext, i);
        com.baidu.tbadk.f.a.a(tbPageContext, this.bMX);
        com.baidu.tbadk.f.a.a(tbPageContext, this.mPageHeadView);
        com.baidu.tbadk.f.a.a(tbPageContext, this.mPageFootView);
        this.mPageNavigationBar.onChangeSkinType(tbPageContext, i);
        this.bMV.a(tbPageContext, i);
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
        ea(true);
    }
}
