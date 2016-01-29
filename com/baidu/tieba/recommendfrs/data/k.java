package com.baidu.tieba.recommendfrs.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import java.util.HashMap;
import tbclient.ExcFrsPage.DataReq;
import tbclient.ExcFrsPage.ExcFrsPageReqIdl;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.mvc.b.h {
    private long dEY;
    private int pn;
    private long tagCode;

    public void setPn(int i) {
        this.pn = i;
    }

    public long getTagCode() {
        return this.tagCode;
    }

    public void setTagCode(long j) {
        this.tagCode = j;
    }

    public long aFw() {
        return this.dEY;
    }

    public void bJ(long j) {
        this.dEY = j;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> oX() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object X(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.pn = Integer.valueOf(this.pn);
        builder.scr_w = Integer.valueOf(com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst()));
        builder.scr_h = Integer.valueOf(com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst()));
        builder.scr_dip = Double.valueOf(com.baidu.adp.lib.util.k.M(TbadkCoreApplication.m411getInst()));
        builder.tag_code = Long.valueOf(this.tagCode);
        builder.q_type = Integer.valueOf(ax.wg().wi() ? 2 : 1);
        builder.last_rank = Long.valueOf(this.dEY);
        ExcFrsPageReqIdl.Builder builder2 = new ExcFrsPageReqIdl.Builder();
        builder2.data = builder.build(false);
        com.baidu.tbadk.util.i.a(builder2.data, true);
        return builder2.build(false);
    }
}
