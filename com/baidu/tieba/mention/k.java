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
    protected BdListView aKK;
    private com.baidu.tbadk.mvc.h.a aKM;
    protected SingleMentionActivity bWm;
    private boolean bWu;
    private boolean bWv;
    private com.baidu.tbadk.core.view.z mPullView;
    protected View rootView;

    public k(SingleMentionActivity singleMentionActivity) {
        super(singleMentionActivity.getPageContext());
        this.bWu = true;
        this.bWv = false;
        this.bWm = singleMentionActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.Dq()) {
                this.aKM.ov();
                if (aVar.Do()) {
                    this.aKM.es(i.h.loading);
                } else if (aVar.Dp()) {
                    this.aKM.es(i.h.loading);
                } else {
                    this.aKM.et(i.h.no_more_msg);
                }
            } else {
                this.aKM.hide();
            }
            if (aVar.isPullRefreshing()) {
                abA();
            } else {
                abB();
            }
        }
    }

    public void abA() {
        this.mPullView.a((x.b) null);
        this.aKK.nv();
        this.mPullView.a(this);
    }

    public void abB() {
        this.aKK.completePullRefresh();
    }

    @Override // com.baidu.tbadk.core.view.x.b
    public void a(View view, boolean z) {
        if (this instanceof j) {
            this.bWm.abP().bE(z);
        } else {
            this.bWm.abO().bE(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        abB();
        if (this.aKM != null) {
            this.aKM.et(i.h.no_more_msg);
        }
    }

    protected View oY() {
        this.rootView = this.bWm.getLayoutInflater().inflate(i.g.mvc_template_list, (ViewGroup) null);
        this.aKK = (BdListView) this.bWm.findViewById(i.f.view_list);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oP() {
        this.mPullView = new com.baidu.tbadk.core.view.z(this.bWm.getPageContext());
        this.mPullView.a(this);
        this.aKK.setDividerHeight(0);
        this.aKK.setExOnSrollToBottomListener(new l(this));
        this.aKK.setPullRefresh(this.mPullView);
        this.aKM = new com.baidu.tbadk.mvc.h.a(this.bWm);
        this.aKM.nn();
        this.aKK.setNextPage(this.aKM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(Bundle bundle) {
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public void onPrimary() {
        if (this.bWu || this.bWv) {
            this.bWu = false;
            this.bWv = false;
            if (this instanceof j) {
                this.bWm.abP().oQ();
            } else {
                this.bWm.abO().oQ();
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public void bp(boolean z) {
        if (z && this.aKK != null && this.aKK.getWrappedAdapter() != null && this.aKK.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.h.hf().post(new m(this));
        }
    }

    public void Dt() {
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public void Du() {
    }

    public void dU(boolean z) {
        this.bWv = z;
    }

    public View getView() {
        return this.rootView;
    }
}
