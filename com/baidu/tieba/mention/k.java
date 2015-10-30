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
    protected BdListView aJO;
    private com.baidu.tbadk.mvc.h.a aJQ;
    protected SingleMentionActivity caj;
    private boolean car;
    private boolean cas;
    private com.baidu.tbadk.core.view.r mPullView;
    protected View rootView;

    public k(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity.getPageContext());
        this.car = true;
        this.cas = false;
        this.caj = singleMentionActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.Da()) {
                this.aJQ.ow();
                if (aVar.CY()) {
                    this.aJQ.et(i.h.loading);
                } else if (aVar.CZ()) {
                    this.aJQ.et(i.h.loading);
                } else {
                    this.aJQ.eu(i.h.no_more_msg);
                }
            } else {
                this.aJQ.hide();
            }
            if (aVar.isPullRefreshing()) {
                acK();
            } else {
                acL();
            }
        }
    }

    public void acK() {
        this.mPullView.a((p.b) null);
        this.aJO.nw();
        this.mPullView.a(this);
    }

    public void acL() {
        this.aJO.completePullRefresh();
    }

    @Override // com.baidu.tbadk.core.view.p.b
    public void a(View view, boolean z) {
        if (this instanceof j) {
            this.caj.add().bB(z);
        } else {
            this.caj.adc().bB(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        acL();
        if (this.aJQ != null) {
            this.aJQ.eu(i.h.no_more_msg);
        }
    }

    protected View oZ() {
        this.rootView = this.caj.getLayoutInflater().inflate(i.g.mvc_template_list, (ViewGroup) null);
        this.aJO = (BdListView) this.caj.findViewById(i.f.view_list);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oQ() {
        this.mPullView = new com.baidu.tbadk.core.view.r(this.caj.getPageContext());
        this.mPullView.a(this);
        this.aJO.setDividerHeight(0);
        this.aJO.setExOnSrollToBottomListener(new l(this));
        this.aJO.setPullRefresh(this.mPullView);
        this.aJQ = new com.baidu.tbadk.mvc.h.a(this.caj);
        this.aJQ.no();
        this.aJO.setNextPage(this.aJQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(Bundle bundle) {
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public void onPrimary() {
        if (this.car || this.cas) {
            this.car = false;
            this.cas = false;
            if (this instanceof j) {
                this.caj.add().oR();
            } else {
                this.caj.adc().oR();
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public void bn(boolean z) {
        if (z && this.aJO != null && this.aJO.getWrappedAdapter() != null && this.aJO.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.h.hg().post(new m(this));
        }
    }

    public void Dd() {
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public void De() {
    }

    public void dV(boolean z) {
        this.cas = z;
    }

    public View getView() {
        return this.rootView;
    }
}
