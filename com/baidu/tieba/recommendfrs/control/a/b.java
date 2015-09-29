package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.recommendfrs.data.f;
import com.baidu.tieba.recommendfrs.data.g;
import com.baidu.tieba.recommendfrs.data.h;
/* loaded from: classes.dex */
public class b {
    private com.baidu.tieba.recommendfrs.control.a.a cId;
    private e cIe;
    private h cIf = new h();
    private a cIg;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, g gVar, boolean z2, String str);

        void i(String str, String str2, int i);
    }

    public b(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.cId = new com.baidu.tieba.recommendfrs.control.a.a(tbPageContext);
        this.cId.setUniqueId(bdUniqueId);
        this.cIe = new e(tbPageContext, this.cIf);
        this.cIe.setUniqueId(bdUniqueId);
        this.cId.a(new c(this));
        this.cIe.a(new d(this));
    }

    public void kU(String str) {
        this.cId.a((com.baidu.tbadk.mvc.b.e) new f(str));
    }

    public void c(int i, String str, int i2) {
        if (!this.cIe.isLoading()) {
            this.cIf.kp(i);
            this.cIf.kY(str);
            this.cIf.ko(i2);
            this.cIe.CS();
        }
    }

    public void a(a aVar) {
        this.cIg = aVar;
    }
}
