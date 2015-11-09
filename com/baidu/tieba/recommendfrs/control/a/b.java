package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.recommendfrs.data.f;
import com.baidu.tieba.recommendfrs.data.g;
import com.baidu.tieba.recommendfrs.data.h;
/* loaded from: classes.dex */
public class b {
    private com.baidu.tieba.recommendfrs.control.a.a cJY;
    private e cJZ;
    private h cKa = new h();
    private a cKb;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, g gVar, boolean z2, String str);

        void i(String str, String str2, int i);
    }

    public b(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.cJY = new com.baidu.tieba.recommendfrs.control.a.a(tbPageContext);
        this.cJY.setUniqueId(bdUniqueId);
        this.cJZ = new e(tbPageContext, this.cKa);
        this.cJZ.setUniqueId(bdUniqueId);
        this.cJY.a(new c(this));
        this.cJZ.a(new d(this));
    }

    public void lb(String str) {
        this.cJY.a((com.baidu.tbadk.mvc.b.e) new f(str));
    }

    public void c(int i, String str, int i2) {
        if (!this.cJZ.isLoading()) {
            this.cKa.kF(i);
            this.cKa.lf(str);
            this.cKa.kE(i2);
            this.cJZ.CI();
        }
    }

    public void a(a aVar) {
        this.cKb = aVar;
    }
}
