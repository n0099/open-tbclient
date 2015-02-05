package com.baidu.tieba.pb.praise;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.mvc.i.c {
    private com.baidu.tbadk.mvc.j.c<a, com.baidu.tbadk.mvc.e.c, b> bFo;
    private PraiseListActivity bFp;
    private View bFq;
    private ProgressBar bFr;
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
        this.bFo = null;
        this.bFp = null;
        this.bFq = null;
        this.mPageNavigationBar = null;
        this.mPageHeadView = null;
        this.mPageHeadText = null;
        this.mPageListView = null;
        this.mPageFootView = null;
        this.mPageFootTextContinue = null;
        this.mPageFootTextMore = null;
        this.mPageProgressBar = null;
        this.bFr = null;
        this.bFp = praiseListActivity;
        wH().addEventDelegate(this);
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int kB() {
        return x.zan_list_activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void kC() {
        this.bFq = getView().findViewById(w.zan_list_page_parent);
        this.mPageNavigationBar = (NavigationBar) getView().findViewById(w.zan_list_page_navigationbar);
        this.mPageListView = (BdListView) getView().findViewById(w.zan_list_page_list);
        this.mPageProgressBar = (ProgressBar) getView().findViewById(w.zan_list_page_progress);
        this.bFo = new com.baidu.tbadk.mvc.j.c<>(this.adH.getPageContext(), b.class, x.zan_list_item, null);
        this.bFo.a(aa.a(NoDataViewFactory.ImgType.NODATA), ab.cp(z.praise_list_no_data), (com.baidu.tbadk.core.view.z) null, (FrameLayout.LayoutParams) null);
        this.mPageListView.setAdapter((ListAdapter) this.bFo);
        this.mPageNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mPageNavigationBar.setTitleText("");
        this.mPageHeadView = getLayoutInflater().inflate(x.zan_list_head, (ViewGroup) null);
        this.mPageHeadView.setOnClickListener(this.bFp);
        this.mPageHeadText = (TextView) this.mPageHeadView.findViewById(w.zan_list_head_text);
        this.mPageListView.addHeaderView(this.mPageHeadView);
        this.mPageFootView = getLayoutInflater().inflate(x.zan_list_foot, (ViewGroup) null);
        this.mPageFootTextContinue = (TextView) this.mPageFootView.findViewById(w.zan_list_foot_text_continue);
        this.mPageFootTextMore = (TextView) this.mPageFootView.findViewById(w.zan_list_foot_text_more);
        this.bFr = (ProgressBar) this.mPageFootView.findViewById(w.zan_list_foot_progress);
        wH().setViewClickListener(this.mPageFootTextContinue, yq());
        this.mPageFootView.setVisibility(8);
        this.mPageListView.addFooterView(this.mPageFootView);
        this.mPageListView.setOnItemClickListener(this.bFp);
        this.mPageHeadText.setText(this.head);
        yp();
        ed(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void g(Bundle bundle) {
        super.g(bundle);
        this.head = bundle.getString(com.baidu.tbadk.core.frameworkData.a.POST_DESC);
    }

    public void ed(boolean z) {
        if (z) {
            this.bFr.setVisibility(0);
        } else {
            this.mPageProgressBar.setVisibility(0);
        }
    }

    public void stopLoadData() {
        this.mPageProgressBar.setVisibility(8);
        this.bFr.setVisibility(8);
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof c) {
            c cVar = (c) aVar;
            int Zx = cVar.Zx();
            List<a> Zz = cVar.Zz();
            int Zx2 = cVar.Zx() - cVar.Zy();
            stopLoadData();
            if (Zx > 0) {
                this.mPageNavigationBar.setTitleText(String.format(this.bFp.getPageContext().getString(z.praise_list_title_count), Integer.valueOf(Zx)));
            } else {
                this.mPageNavigationBar.setTitleText("");
            }
            if (Zz == null || Zz.size() < 1) {
                this.bFo.w(new ArrayList());
                showNoData();
                return;
            }
            this.bFo.w(Zz);
            switch (cVar.getStatus()) {
                case 1001:
                    this.mPageFootView.setVisibility(0);
                    this.mPageFootTextContinue.setVisibility(0);
                    this.mPageFootTextMore.setVisibility(8);
                    return;
                case 1002:
                    this.mPageFootView.setVisibility(8);
                    return;
                case 1003:
                    this.mPageFootView.setVisibility(0);
                    bc.i(this.mPageFootView, v.bg_pack);
                    this.mPageFootTextContinue.setVisibility(8);
                    this.mPageFootTextMore.setVisibility(0);
                    this.mPageFootTextMore.setText(String.format(this.bFp.getPageContext().getString(z.praise_item_more), Integer.valueOf(Zx2)));
                    return;
                default:
                    this.mPageFootView.setVisibility(8);
                    return;
            }
        }
    }

    public void showNoData() {
        this.mPageProgressBar.setVisibility(8);
        this.bFr.setVisibility(8);
        this.mPageFootView.setVisibility(8);
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        super.a(tbPageContext, i);
        com.baidu.tbadk.g.a.a(tbPageContext, this.bFq);
        com.baidu.tbadk.g.a.a(tbPageContext, this.mPageHeadView);
        com.baidu.tbadk.g.a.a(tbPageContext, this.mPageFootView);
        this.mPageNavigationBar.onChangeSkinType(tbPageContext, i);
        this.bFo.a(tbPageContext, i);
        bc.i(this.mPageFootView, v.bg_pack);
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
    protected void kz() {
        stopLoadData();
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void kA() {
        ed(true);
    }
}
