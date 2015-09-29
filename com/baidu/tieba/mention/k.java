package com.baidu.tieba.mention;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.view.p;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public abstract class k extends com.baidu.adp.base.f<SingleMentionActivity> implements p.b, com.baidu.tbadk.mvc.f.a.a {
    protected BdListView aJD;
    private com.baidu.tbadk.mvc.h.a aJF;
    protected SingleMentionActivity bZY;
    private boolean cag;
    private boolean cah;
    private com.baidu.tbadk.core.view.r mPullView;
    protected View rootView;

    public k(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity.getPageContext());
        this.cag = true;
        this.cah = false;
        this.bZY = singleMentionActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.Dd()) {
                this.aJF.ow();
                if (aVar.Db()) {
                    this.aJF.et(i.h.loading);
                } else if (aVar.Dc()) {
                    this.aJF.et(i.h.loading);
                } else {
                    this.aJF.eu(i.h.no_more_msg);
                }
            } else {
                this.aJF.hide();
            }
            if (aVar.isPullRefreshing()) {
                acO();
            } else {
                acP();
            }
        }
    }

    public void acO() {
        this.mPullView.a((p.b) null);
        this.aJD.nw();
        this.mPullView.a(this);
    }

    public void acP() {
        this.aJD.completePullRefresh();
    }

    @Override // com.baidu.tbadk.core.view.p.b
    public void a(View view, boolean z) {
        if (this instanceof j) {
            this.bZY.adh().bB(z);
        } else {
            this.bZY.adg().bB(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        acP();
        if (this.aJF != null) {
            this.aJF.eu(i.h.no_more_msg);
        }
    }

    protected View oZ() {
        this.rootView = this.bZY.getLayoutInflater().inflate(i.g.mvc_template_list, (ViewGroup) null);
        this.aJD = (BdListView) this.bZY.findViewById(i.f.view_list);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oQ() {
        this.mPullView = new com.baidu.tbadk.core.view.r(this.bZY.getPageContext());
        this.mPullView.a(this);
        this.aJD.setDividerHeight(0);
        this.aJD.setExOnSrollToBottomListener(new l(this));
        this.aJD.setPullRefresh(this.mPullView);
        this.aJF = new com.baidu.tbadk.mvc.h.a(this.bZY);
        this.aJF.no();
        this.aJD.setNextPage(this.aJF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(Bundle bundle) {
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public void onPrimary() {
        if (this.cag || this.cah) {
            this.cag = false;
            this.cah = false;
            if (this instanceof j) {
                this.bZY.adh().oR();
            } else {
                this.bZY.adg().oR();
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public void bn(boolean z) {
        if (z && this.aJD != null && this.aJD.getWrappedAdapter() != null && this.aJD.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.h.hg().post(new m(this));
        }
    }

    public void Dg() {
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public void Dh() {
    }

    public void dV(boolean z) {
        this.cah = z;
    }

    public View getView() {
        return this.rootView;
    }
}
