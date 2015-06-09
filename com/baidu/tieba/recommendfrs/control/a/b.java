package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.mvc.model.q;
import com.baidu.tieba.recommendfrs.data.g;
/* loaded from: classes.dex */
public class b {
    private a cbO;
    private f cbP;
    private g cbQ = new g();
    private e cbR;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.cbO = new a(tbPageContext);
        this.cbO.setUniqueId(bdUniqueId);
        this.cbP = new f(tbPageContext, this.cbQ);
        this.cbP.setUniqueId(bdUniqueId);
        this.cbO.a(new c(this));
        this.cbP.a((q) new d(this));
    }

    public void iW(String str) {
        this.cbO.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.recommendfrs.data.e(str));
    }

    public void B(int i, String str) {
        this.cbQ.il(i);
        this.cbQ.ja(str);
        this.cbP.BM();
    }

    public void a(e eVar) {
        this.cbR = eVar;
    }
}
