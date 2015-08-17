package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.recommendfrs.data.f;
import com.baidu.tieba.recommendfrs.data.g;
import com.baidu.tieba.recommendfrs.data.h;
/* loaded from: classes.dex */
public class b {
    private com.baidu.tieba.recommendfrs.control.a.a csJ;
    private e csK;
    private h csL = new h();
    private a csM;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, g gVar, boolean z2, String str);

        void h(String str, String str2, int i);
    }

    public b(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.csJ = new com.baidu.tieba.recommendfrs.control.a.a(tbPageContext);
        this.csJ.setUniqueId(bdUniqueId);
        this.csK = new e(tbPageContext, this.csL);
        this.csK.setUniqueId(bdUniqueId);
        this.csJ.a(new c(this));
        this.csK.a(new d(this));
    }

    public void jR(String str) {
        this.csJ.a((com.baidu.tbadk.mvc.b.e) new f(str));
    }

    public void c(int i, String str, int i2) {
        if (!this.csK.isLoading()) {
            this.csL.jg(i);
            this.csL.jV(str);
            this.csL.jf(i2);
            this.csK.CV();
        }
    }

    public void a(a aVar) {
        this.csM = aVar;
    }
}
