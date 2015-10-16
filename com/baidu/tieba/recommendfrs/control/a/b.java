package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.recommendfrs.data.f;
import com.baidu.tieba.recommendfrs.data.g;
import com.baidu.tieba.recommendfrs.data.h;
/* loaded from: classes.dex */
public class b {
    private com.baidu.tieba.recommendfrs.control.a.a cIC;
    private e cID;
    private h cIE = new h();
    private a cIF;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, g gVar, boolean z2, String str);

        void i(String str, String str2, int i);
    }

    public b(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.cIC = new com.baidu.tieba.recommendfrs.control.a.a(tbPageContext);
        this.cIC.setUniqueId(bdUniqueId);
        this.cID = new e(tbPageContext, this.cIE);
        this.cID.setUniqueId(bdUniqueId);
        this.cIC.a(new c(this));
        this.cID.a(new d(this));
    }

    public void kX(String str) {
        this.cIC.a((com.baidu.tbadk.mvc.b.e) new f(str));
    }

    public void c(int i, String str, int i2) {
        if (!this.cID.isLoading()) {
            this.cIE.kr(i);
            this.cIE.lb(str);
            this.cIE.kq(i2);
            this.cID.CS();
        }
    }

    public void a(a aVar) {
        this.cIF = aVar;
    }
}
