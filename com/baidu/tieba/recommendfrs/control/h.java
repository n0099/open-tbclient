package com.baidu.tieba.recommendfrs.control;

import com.baidu.tieba.recommendfrs.control.a.j;
import com.baidu.tieba.recommendfrs.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.t;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements j.a {
    final /* synthetic */ a dEd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.dEd = aVar;
    }

    @Override // com.baidu.tieba.recommendfrs.control.a.j.a
    public void a(boolean z, com.baidu.tieba.recommendfrs.data.j jVar, boolean z2, long j) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        if (z) {
            this.dEd.aK(this.dEd.getView());
        }
        if (z) {
            scrollFragmentTabHost2 = this.dEd.dDV;
            if (!scrollFragmentTabHost2.aFM() && jVar != null && jVar.isEmpty()) {
                if (this.dEd.getPageContext() == null || this.dEd.getPageContext().getResources() == null) {
                    return;
                }
                this.dEd.showNetRefreshView(this.dEd.getView(), this.dEd.getPageContext().getResources().getString(t.j.neterror), false);
                return;
            }
        }
        scrollFragmentTabHost = this.dEd.dDV;
        scrollFragmentTabHost.b(z, j, jVar, z2);
    }

    @Override // com.baidu.tieba.recommendfrs.control.a.j.a
    public void a(long j, String str, int i) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        this.dEd.aK(this.dEd.getView());
        scrollFragmentTabHost = this.dEd.dDV;
        if (scrollFragmentTabHost.aFM()) {
            scrollFragmentTabHost2 = this.dEd.dDV;
            scrollFragmentTabHost2.b(j, str, i);
        } else if (this.dEd.getPageContext() == null || this.dEd.getPageContext().getResources() == null) {
        } else {
            this.dEd.showNetRefreshView(this.dEd.getView(), this.dEd.getPageContext().getResources().getString(t.j.net_error_text, str, Integer.valueOf(i)), false);
        }
    }

    @Override // com.baidu.tieba.recommendfrs.control.a.j.a
    public void a(long j, DataRes dataRes, boolean z) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        this.dEd.aK(this.dEd.getView());
        scrollFragmentTabHost = this.dEd.dDV;
        scrollFragmentTabHost.c(j, dataRes, z);
    }
}
