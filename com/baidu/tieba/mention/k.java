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
    protected BdListView aII;
    private com.baidu.tbadk.mvc.h.a aIK;
    protected SingleMentionActivity caK;
    private boolean caS;
    private boolean caT;
    private com.baidu.tbadk.core.view.r mPullView;
    protected View rootView;

    public k(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity.getPageContext());
        this.caS = true;
        this.caT = false;
        this.caK = singleMentionActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.CT()) {
                this.aIK.ox();
                if (aVar.CR()) {
                    this.aIK.er(i.h.loading);
                } else if (aVar.CS()) {
                    this.aIK.er(i.h.loading);
                } else {
                    this.aIK.es(i.h.no_more_msg);
                }
            } else {
                this.aIK.hide();
            }
            if (aVar.isPullRefreshing()) {
                adf();
            } else {
                adg();
            }
        }
    }

    public void adf() {
        this.mPullView.a((p.b) null);
        this.aII.nx();
        this.mPullView.a(this);
    }

    public void adg() {
        this.aII.completePullRefresh();
    }

    @Override // com.baidu.tbadk.core.view.p.b
    public void a(View view, boolean z) {
        if (this instanceof j) {
            this.caK.ady().bD(z);
        } else {
            this.caK.adx().bD(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        adg();
        if (this.aIK != null) {
            this.aIK.es(i.h.no_more_msg);
        }
    }

    protected View pa() {
        this.rootView = this.caK.getLayoutInflater().inflate(i.g.mvc_template_list, (ViewGroup) null);
        this.aII = (BdListView) this.caK.findViewById(i.f.view_list);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oR() {
        this.mPullView = new com.baidu.tbadk.core.view.r(this.caK.getPageContext());
        this.mPullView.a(this);
        this.aII.setDividerHeight(0);
        this.aII.setExOnSrollToBottomListener(new l(this));
        this.aII.setPullRefresh(this.mPullView);
        this.aIK = new com.baidu.tbadk.mvc.h.a(this.caK);
        this.aIK.np();
        this.aII.setNextPage(this.aIK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(Bundle bundle) {
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public void onPrimary() {
        if (this.caS || this.caT) {
            this.caS = false;
            this.caT = false;
            if (this instanceof j) {
                this.caK.ady().oS();
            } else {
                this.caK.adx().oS();
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public void bq(boolean z) {
        if (z && this.aII != null && this.aII.getWrappedAdapter() != null && this.aII.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.h.hh().post(new m(this));
        }
    }

    public void CW() {
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public void CX() {
    }

    public void dX(boolean z) {
        this.caT = z;
    }

    public View getView() {
        return this.rootView;
    }
}
