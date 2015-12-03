package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
/* loaded from: classes.dex */
public class b {
    private com.baidu.tieba.recommendfrs.control.a.a diC;
    private e diD;
    private com.baidu.tieba.recommendfrs.data.d diE = new com.baidu.tieba.recommendfrs.data.d();
    private a diF;

    /* loaded from: classes.dex */
    public interface a {
        void a(long j, String str, int i);

        void a(boolean z, com.baidu.tieba.recommendfrs.data.c cVar, boolean z2, long j);
    }

    public b(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.diC = new com.baidu.tieba.recommendfrs.control.a.a(tbPageContext);
        this.diC.setUniqueId(bdUniqueId);
        this.diD = new e(tbPageContext, this.diE);
        this.diD.setUniqueId(bdUniqueId);
        this.diC.a(new c(this));
        this.diD.a(new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(MvcNetMessage<com.baidu.tieba.recommendfrs.data.d, com.baidu.tieba.recommendfrs.data.c> mvcNetMessage) {
        com.baidu.tieba.recommendfrs.data.d requestData;
        if (mvcNetMessage == null || (requestData = mvcNetMessage.getRequestData()) == null) {
            return -1L;
        }
        return requestData.awm();
    }

    public void bx(long j) {
        this.diC.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.recommendfrs.data.b(j));
    }

    public void c(int i, long j, long j2) {
        if (!this.diD.isLoading()) {
            this.diE.setPn(i);
            this.diE.setTagCode(j);
            this.diE.by(j2);
            this.diD.DJ();
        }
    }

    public void a(a aVar) {
        this.diF = aVar;
    }
}
