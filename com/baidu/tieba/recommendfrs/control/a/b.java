package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.mvc.model.q;
import com.baidu.tieba.recommendfrs.data.g;
/* loaded from: classes.dex */
public class b {
    private a cbN;
    private f cbO;
    private g cbP = new g();
    private e cbQ;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.cbN = new a(tbPageContext);
        this.cbN.setUniqueId(bdUniqueId);
        this.cbO = new f(tbPageContext, this.cbP);
        this.cbO.setUniqueId(bdUniqueId);
        this.cbN.a(new c(this));
        this.cbO.a((q) new d(this));
    }

    public void iW(String str) {
        this.cbN.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.recommendfrs.data.e(str));
    }

    public void B(int i, String str) {
        this.cbP.il(i);
        this.cbP.ja(str);
        this.cbO.BL();
    }

    public void a(e eVar) {
        this.cbQ = eVar;
    }
}
