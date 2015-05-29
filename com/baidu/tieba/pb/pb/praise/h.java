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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.core.view.z;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.mvc.i.c {
    private com.baidu.tbadk.mvc.j.d<a, com.baidu.tbadk.mvc.e.c, b> bPj;
    private PraiseListActivity bPk;
    private View bPl;
    private ProgressBar bPm;
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
        this.bPj = null;
        this.bPk = null;
        this.bPl = null;
        this.mPageNavigationBar = null;
        this.mPageHeadView = null;
        this.mPageHeadText = null;
        this.mPageListView = null;
        this.mPageFootView = null;
        this.mPageFootTextContinue = null;
        this.mPageFootTextMore = null;
        this.mPageProgressBar = null;
        this.bPm = null;
        this.bPk = praiseListActivity;
        AL().addEventDelegate(this);
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int oK() {
        return r.zan_list_activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void oL() {
        this.bPl = getView().findViewById(q.zan_list_page_parent);
        this.mPageNavigationBar = (NavigationBar) getView().findViewById(q.zan_list_page_navigationbar);
        this.mPageListView = (BdListView) getView().findViewById(q.zan_list_page_list);
        this.mPageProgressBar = (ProgressBar) getView().findViewById(q.zan_list_page_progress);
        this.bPj = new com.baidu.tbadk.mvc.j.d<>(this.anm.getPageContext(), b.class, r.zan_list_item, null);
        this.bPj.a(aa.a(NoDataViewFactory.ImgType.NODATA), ab.cv(t.praise_list_no_data), (z) null, (FrameLayout.LayoutParams) null);
        this.mPageListView.setAdapter((ListAdapter) this.bPj);
        this.mPageNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mPageNavigationBar.setTitleText("");
        this.mPageHeadView = getLayoutInflater().inflate(r.zan_list_head, (ViewGroup) null);
        this.mPageHeadView.setOnClickListener(this.bPk);
        this.mPageHeadText = (TextView) this.mPageHeadView.findViewById(q.zan_list_head_text);
        this.mPageListView.addHeaderView(this.mPageHeadView);
        this.mPageFootView = getLayoutInflater().inflate(r.zan_list_foot, (ViewGroup) null);
        this.mPageFootTextContinue = (TextView) this.mPageFootView.findViewById(q.zan_list_foot_text_continue);
        this.mPageFootTextMore = (TextView) this.mPageFootView.findViewById(q.zan_list_foot_text_more);
        this.bPm = (ProgressBar) this.mPageFootView.findViewById(q.zan_list_foot_progress);
        AL().setViewClickListener(this.mPageFootTextContinue, Cw());
        this.mPageFootView.setVisibility(8);
        this.mPageListView.addFooterView(this.mPageFootView);
        this.mPageListView.setOnItemClickListener(this.bPk);
        this.mPageHeadText.setText(this.head);
        Cv();
        ek(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void g(Bundle bundle) {
        super.g(bundle);
        this.head = bundle.getString(com.baidu.tbadk.core.frameworkData.c.POST_DESC);
    }

    public void ek(boolean z) {
        if (z) {
            this.bPm.setVisibility(0);
        } else {
            this.mPageProgressBar.setVisibility(0);
        }
    }

    public void stopLoadData() {
        this.mPageProgressBar.setVisibility(8);
        this.bPm.setVisibility(8);
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof c) {
            c cVar = (c) aVar;
            int acM = cVar.acM();
            List<a> acO = cVar.acO();
            int acM2 = cVar.acM() - cVar.acN();
            stopLoadData();
            if (acM > 0) {
                this.mPageNavigationBar.setTitleText(String.format(this.bPk.getPageContext().getString(t.praise_list_title_count), Integer.valueOf(acM)));
            } else {
                this.mPageNavigationBar.setTitleText("");
            }
            if (acO == null || acO.size() < 1) {
                this.bPj.s(new ArrayList());
                showNoData();
                return;
            }
            this.bPj.s(acO);
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
                    ay.i(this.mPageFootView, p.bg_pack);
                    this.mPageFootTextContinue.setVisibility(8);
                    this.mPageFootTextMore.setVisibility(0);
                    this.mPageFootTextMore.setText(String.format(this.bPk.getPageContext().getString(t.praise_item_more), Integer.valueOf(acM2)));
                    return;
                default:
                    this.mPageFootView.setVisibility(8);
                    return;
            }
        }
    }

    public void showNoData() {
        this.mPageProgressBar.setVisibility(8);
        this.bPm.setVisibility(8);
        this.mPageFootView.setVisibility(8);
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        super.a(tbPageContext, i);
        com.baidu.tbadk.f.a.a(tbPageContext, this.bPl);
        com.baidu.tbadk.f.a.a(tbPageContext, this.mPageHeadView);
        com.baidu.tbadk.f.a.a(tbPageContext, this.mPageFootView);
        this.mPageNavigationBar.onChangeSkinType(tbPageContext, i);
        this.bPj.a(tbPageContext, i);
        ay.i(this.mPageFootView, p.bg_pack);
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
    protected void oI() {
        stopLoadData();
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void oJ() {
        ek(true);
    }
}
