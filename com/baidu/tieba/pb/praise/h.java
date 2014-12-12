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
import com.baidu.tbadk.core.util.ax;
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
    private com.baidu.tbadk.mvc.j.c<a, com.baidu.tbadk.mvc.e.c, b> bDE;
    private PraiseListActivity bDF;
    private View bDG;
    private ProgressBar bDH;
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
        this.bDE = null;
        this.bDF = null;
        this.bDG = null;
        this.mPageNavigationBar = null;
        this.mPageHeadView = null;
        this.mPageHeadText = null;
        this.mPageListView = null;
        this.mPageFootView = null;
        this.mPageFootTextContinue = null;
        this.mPageFootTextMore = null;
        this.mPageProgressBar = null;
        this.bDH = null;
        this.bDF = praiseListActivity;
        wx().addEventDelegate(this);
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int kI() {
        return x.zan_list_activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void kJ() {
        this.bDG = getView().findViewById(w.zan_list_page_parent);
        this.mPageNavigationBar = (NavigationBar) getView().findViewById(w.zan_list_page_navigationbar);
        this.mPageListView = (BdListView) getView().findViewById(w.zan_list_page_list);
        this.mPageProgressBar = (ProgressBar) getView().findViewById(w.zan_list_page_progress);
        this.bDE = new com.baidu.tbadk.mvc.j.c<>(this.adn.getPageContext(), b.class, x.zan_list_item, null);
        this.bDE.a(aa.a(NoDataViewFactory.ImgType.NODATA), ab.ci(z.praise_list_no_data), (com.baidu.tbadk.core.view.z) null, (FrameLayout.LayoutParams) null);
        this.mPageListView.setAdapter((ListAdapter) this.bDE);
        this.mPageNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mPageNavigationBar.setTitleText("");
        this.mPageHeadView = getLayoutInflater().inflate(x.zan_list_head, (ViewGroup) null);
        this.mPageHeadView.setOnClickListener(this.bDF);
        this.mPageHeadText = (TextView) this.mPageHeadView.findViewById(w.zan_list_head_text);
        this.mPageListView.addHeaderView(this.mPageHeadView);
        this.mPageFootView = getLayoutInflater().inflate(x.zan_list_foot, (ViewGroup) null);
        this.mPageFootTextContinue = (TextView) this.mPageFootView.findViewById(w.zan_list_foot_text_continue);
        this.mPageFootTextMore = (TextView) this.mPageFootView.findViewById(w.zan_list_foot_text_more);
        this.bDH = (ProgressBar) this.mPageFootView.findViewById(w.zan_list_foot_progress);
        wx().setViewClickListener(this.mPageFootTextContinue, yg());
        this.mPageFootView.setVisibility(8);
        this.mPageListView.addFooterView(this.mPageFootView);
        this.mPageListView.setOnItemClickListener(this.bDF);
        this.mPageHeadText.setText(this.head);
        yf();
        dX(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void g(Bundle bundle) {
        super.g(bundle);
        this.head = bundle.getString(com.baidu.tbadk.core.frameworkData.a.POST_DESC);
    }

    public void dX(boolean z) {
        if (z) {
            this.bDH.setVisibility(0);
        } else {
            this.mPageProgressBar.setVisibility(0);
        }
    }

    public void stopLoadData() {
        this.mPageProgressBar.setVisibility(8);
        this.bDH.setVisibility(8);
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof c) {
            c cVar = (c) aVar;
            int YX = cVar.YX();
            List<a> YZ = cVar.YZ();
            int YX2 = cVar.YX() - cVar.YY();
            stopLoadData();
            if (YX > 0) {
                this.mPageNavigationBar.setTitleText(String.format(this.bDF.getPageContext().getString(z.praise_list_title_count), Integer.valueOf(YX)));
            } else {
                this.mPageNavigationBar.setTitleText("");
            }
            if (YZ == null || YZ.size() < 1) {
                this.bDE.w(new ArrayList());
                showNoData();
                return;
            }
            this.bDE.w(YZ);
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
                    ax.i(this.mPageFootView, v.bg_pack);
                    this.mPageFootTextContinue.setVisibility(8);
                    this.mPageFootTextMore.setVisibility(0);
                    this.mPageFootTextMore.setText(String.format(this.bDF.getPageContext().getString(z.praise_item_more), Integer.valueOf(YX2)));
                    return;
                default:
                    this.mPageFootView.setVisibility(8);
                    return;
            }
        }
    }

    public void showNoData() {
        this.mPageProgressBar.setVisibility(8);
        this.bDH.setVisibility(8);
        this.mPageFootView.setVisibility(8);
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        super.a(tbPageContext, i);
        com.baidu.tbadk.g.a.a(tbPageContext, this.bDG);
        com.baidu.tbadk.g.a.a(tbPageContext, this.mPageHeadView);
        com.baidu.tbadk.g.a.a(tbPageContext, this.mPageFootView);
        this.mPageNavigationBar.onChangeSkinType(tbPageContext, i);
        this.bDE.a(tbPageContext, i);
        ax.i(this.mPageFootView, v.bg_pack);
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
    protected void kG() {
        stopLoadData();
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void kH() {
        dX(true);
    }
}
