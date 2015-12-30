package com.baidu.tieba.recommendfrs.control;

import com.baidu.tieba.n;
import com.baidu.tieba.recommendfrs.control.a.j;
import com.baidu.tieba.recommendfrs.indicator.ScrollFragmentTabHost;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements j.a {
    final /* synthetic */ a doN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.doN = aVar;
    }

    @Override // com.baidu.tieba.recommendfrs.control.a.j.a
    public void a(boolean z, com.baidu.tieba.recommendfrs.data.h hVar, boolean z2, long j) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        if (z) {
            this.doN.au(this.doN.getView());
        }
        if (z) {
            scrollFragmentTabHost2 = this.doN.doG;
            if (!scrollFragmentTabHost2.ayF() && hVar != null && hVar.isEmpty()) {
                if (this.doN.getPageContext() == null || this.doN.getPageContext().getResources() == null) {
                    return;
                }
                this.doN.showNetRefreshView(this.doN.getView(), this.doN.getPageContext().getResources().getString(n.j.neterror), false);
                return;
            }
        }
        scrollFragmentTabHost = this.doN.doG;
        scrollFragmentTabHost.b(z, j, hVar, z2);
    }

    @Override // com.baidu.tieba.recommendfrs.control.a.j.a
    public void a(long j, String str, int i) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        this.doN.au(this.doN.getView());
        scrollFragmentTabHost = this.doN.doG;
        if (scrollFragmentTabHost.ayF()) {
            scrollFragmentTabHost2 = this.doN.doG;
            scrollFragmentTabHost2.b(j, str, i);
        } else if (this.doN.getPageContext() == null || this.doN.getPageContext().getResources() == null) {
        } else {
            this.doN.showNetRefreshView(this.doN.getView(), this.doN.getPageContext().getResources().getString(n.j.net_error_text, str, Integer.valueOf(i)), false);
        }
    }

    @Override // com.baidu.tieba.recommendfrs.control.a.j.a
    public void a(long j, DataRes dataRes, boolean z) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        this.doN.au(this.doN.getView());
        scrollFragmentTabHost = this.doN.doG;
        scrollFragmentTabHost.c(j, dataRes, z);
    }
}
