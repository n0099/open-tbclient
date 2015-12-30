package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.recommendfrs.control.a.g;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class j {
    private i doV;
    private n doW;
    private g doX;
    private a doZ;
    private g.a dpa = new k(this);
    private com.baidu.tieba.recommendfrs.data.i doY = new com.baidu.tieba.recommendfrs.data.i();

    /* loaded from: classes.dex */
    public interface a {
        void a(long j, String str, int i);

        void a(long j, DataRes dataRes, boolean z);

        void a(boolean z, com.baidu.tieba.recommendfrs.data.h hVar, boolean z2, long j);
    }

    public j(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.doV = new i(tbPageContext);
        this.doV.setUniqueId(bdUniqueId);
        this.doW = new n(tbPageContext, this.doY);
        this.doW.setUniqueId(bdUniqueId);
        this.doX = new g(tbPageContext, bdUniqueId);
        this.doX.a(this.dpa);
        this.doV.a(new l(this));
        this.doW.a(new m(this));
    }

    public void a(int i, boolean z, int i2, int i3, int i4, int i5) {
        if (this.doX != null) {
            this.doX.a(i, z, i2, i3, i4, i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(MvcNetMessage<com.baidu.tieba.recommendfrs.data.i, com.baidu.tieba.recommendfrs.data.h> mvcNetMessage) {
        com.baidu.tieba.recommendfrs.data.i requestData;
        if (mvcNetMessage == null || (requestData = mvcNetMessage.getRequestData()) == null) {
            return -1L;
        }
        return requestData.getTagCode();
    }

    public void bG(long j) {
        this.doV.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.recommendfrs.data.g(j));
    }

    public void c(int i, long j, long j2) {
        if (!this.doW.isLoading()) {
            this.doY.setPn(i);
            this.doY.setTagCode(j);
            this.doY.bH(j2);
            this.doW.Dy();
        }
    }

    public void a(a aVar) {
        this.doZ = aVar;
    }
}
