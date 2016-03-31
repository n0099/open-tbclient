package com.baidu.tieba.recommendfrs.control;

import com.baidu.tieba.recommendfrs.control.a.m;
import com.baidu.tieba.recommendfrs.data.n;
import com.baidu.tieba.recommendfrs.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.t;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements m.a {
    final /* synthetic */ a dVV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.dVV = aVar;
    }

    @Override // com.baidu.tieba.recommendfrs.control.a.m.a
    public void a(boolean z, n nVar, boolean z2, long j) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        if (z) {
            this.dVV.aD(this.dVV.getView());
        }
        if (z) {
            scrollFragmentTabHost2 = this.dVV.dVM;
            if (!scrollFragmentTabHost2.aoj() && nVar != null && nVar.isEmpty()) {
                if (this.dVV.getPageContext() == null || this.dVV.getPageContext().getResources() == null) {
                    return;
                }
                this.dVV.showNetRefreshView(this.dVV.getView(), this.dVV.getPageContext().getResources().getString(t.j.neterror), false);
                return;
            }
        }
        scrollFragmentTabHost = this.dVV.dVM;
        scrollFragmentTabHost.b(z, j, nVar, z2);
    }

    @Override // com.baidu.tieba.recommendfrs.control.a.m.a
    public void a(long j, String str, int i) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        this.dVV.aD(this.dVV.getView());
        scrollFragmentTabHost = this.dVV.dVM;
        if (scrollFragmentTabHost.aoj()) {
            scrollFragmentTabHost2 = this.dVV.dVM;
            scrollFragmentTabHost2.b(j, str, i);
        } else if (this.dVV.getPageContext() == null || this.dVV.getPageContext().getResources() == null) {
        } else {
            this.dVV.showNetRefreshView(this.dVV.getView(), this.dVV.getPageContext().getResources().getString(t.j.net_error_text, str, Integer.valueOf(i)), false);
        }
    }

    @Override // com.baidu.tieba.recommendfrs.control.a.m.a
    public void a(long j, DataRes dataRes, boolean z) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        this.dVV.aD(this.dVV.getView());
        scrollFragmentTabHost = this.dVV.dVM;
        scrollFragmentTabHost.c(j, dataRes, z);
    }
}
