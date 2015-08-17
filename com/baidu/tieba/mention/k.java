package com.baidu.tieba.mention;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.view.x;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public abstract class k extends com.baidu.adp.base.f<SingleMentionActivity> implements x.b, com.baidu.tbadk.mvc.f.a.a {
    protected BdListView aKx;
    private com.baidu.tbadk.mvc.h.a aKz;
    protected SingleMentionActivity bVG;
    private boolean bVO;
    private boolean bVP;
    private com.baidu.tbadk.core.view.z mPullView;
    protected View rootView;

    public k(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity.getPageContext());
        this.bVO = true;
        this.bVP = false;
        this.bVG = singleMentionActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.Dg()) {
                this.aKz.oy();
                if (aVar.De()) {
                    this.aKz.ek(i.C0057i.loading);
                } else if (aVar.Df()) {
                    this.aKz.ek(i.C0057i.loading);
                } else {
                    this.aKz.el(i.C0057i.no_more_msg);
                }
            } else {
                this.aKz.hide();
            }
            if (aVar.isPullRefreshing()) {
                abv();
            } else {
                abw();
            }
        }
    }

    public void abv() {
        this.mPullView.a((x.b) null);
        this.aKx.ny();
        this.mPullView.a(this);
    }

    public void abw() {
        this.aKx.completePullRefresh();
    }

    @Override // com.baidu.tbadk.core.view.x.b
    public void a(View view, boolean z) {
        if (this instanceof j) {
            this.bVG.abK().bz(z);
        } else {
            this.bVG.abJ().bz(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        abw();
        if (this.aKz != null) {
            this.aKz.el(i.C0057i.no_more_msg);
        }
    }

    protected View pb() {
        this.rootView = this.bVG.getLayoutInflater().inflate(i.g.mvc_template_list, (ViewGroup) null);
        this.aKx = (BdListView) this.bVG.findViewById(i.f.view_list);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oS() {
        this.mPullView = new com.baidu.tbadk.core.view.z(this.bVG.getPageContext());
        this.mPullView.a(this);
        this.aKx.setDividerHeight(0);
        this.aKx.setExOnSrollToBottomListener(new l(this));
        this.aKx.setPullRefresh(this.mPullView);
        this.aKz = new com.baidu.tbadk.mvc.h.a(this.bVG);
        this.aKz.nq();
        this.aKx.setNextPage(this.aKz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(Bundle bundle) {
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public void onPrimary() {
        if (this.bVO || this.bVP) {
            this.bVO = false;
            this.bVP = false;
            if (this instanceof j) {
                this.bVG.abK().oT();
            } else {
                this.bVG.abJ().oT();
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public void bi(boolean z) {
        if (z && this.aKx != null && this.aKx.getWrappedAdapter() != null && this.aKx.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.h.hi().post(new m(this));
        }
    }

    public void Dj() {
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public void Dk() {
    }

    public void dP(boolean z) {
        this.bVP = z;
    }

    public View getView() {
        return this.rootView;
    }
}
