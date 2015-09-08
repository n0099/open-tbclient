package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.recommendfrs.data.f;
import com.baidu.tieba.recommendfrs.data.g;
import com.baidu.tieba.recommendfrs.data.h;
/* loaded from: classes.dex */
public class b {
    private com.baidu.tieba.recommendfrs.control.a.a cBb;
    private e cBc;
    private h cBd = new h();
    private a cBe;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, g gVar, boolean z2, String str);

        void h(String str, String str2, int i);
    }

    public b(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.cBb = new com.baidu.tieba.recommendfrs.control.a.a(tbPageContext);
        this.cBb.setUniqueId(bdUniqueId);
        this.cBc = new e(tbPageContext, this.cBd);
        this.cBc.setUniqueId(bdUniqueId);
        this.cBb.a(new c(this));
        this.cBc.a(new d(this));
    }

    public void kw(String str) {
        this.cBb.a((com.baidu.tbadk.mvc.b.e) new f(str));
    }

    public void c(int i, String str, int i2) {
        if (!this.cBc.isLoading()) {
            this.cBd.jQ(i);
            this.cBd.kA(str);
            this.cBd.jP(i2);
            this.cBc.Df();
        }
    }

    public void a(a aVar) {
        this.cBe = aVar;
    }
}
