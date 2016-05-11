package com.baidu.tieba.recommendfrs.control;

import com.baidu.tieba.recommendfrs.control.a.m;
import com.baidu.tieba.recommendfrs.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.t;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements m.a {
    final /* synthetic */ a dYW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.dYW = aVar;
    }

    @Override // com.baidu.tieba.recommendfrs.control.a.m.a
    public void a(boolean z, com.baidu.tieba.recommendfrs.data.n nVar, boolean z2, long j) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        if (z) {
            this.dYW.aMj();
        }
        if (z) {
            scrollFragmentTabHost2 = this.dYW.dYN;
            if (!scrollFragmentTabHost2.aom() && nVar != null && nVar.isEmpty()) {
                if (this.dYW.getPageContext() == null || this.dYW.getPageContext().getResources() == null) {
                    return;
                }
                this.dYW.I(this.dYW.getPageContext().getResources().getString(t.j.neterror), false);
                return;
            }
        }
        scrollFragmentTabHost = this.dYW.dYN;
        scrollFragmentTabHost.b(z, j, nVar, z2);
    }

    @Override // com.baidu.tieba.recommendfrs.control.a.m.a
    public void a(long j, String str, int i) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        this.dYW.aMj();
        scrollFragmentTabHost = this.dYW.dYN;
        if (scrollFragmentTabHost.aom()) {
            scrollFragmentTabHost2 = this.dYW.dYN;
            scrollFragmentTabHost2.b(j, str, i);
        } else if (this.dYW.getPageContext() == null || this.dYW.getPageContext().getResources() == null) {
        } else {
            this.dYW.I(this.dYW.getPageContext().getResources().getString(t.j.net_error_text, str, Integer.valueOf(i)), false);
        }
    }

    @Override // com.baidu.tieba.recommendfrs.control.a.m.a
    public void a(long j, DataRes dataRes, boolean z) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        this.dYW.aMj();
        scrollFragmentTabHost = this.dYW.dYN;
        scrollFragmentTabHost.c(j, dataRes, z);
    }
}
