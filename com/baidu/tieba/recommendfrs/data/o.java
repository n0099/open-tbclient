package com.baidu.tieba.recommendfrs.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.az;
import java.util.HashMap;
import tbclient.ExcFrsPage.DataReq;
import tbclient.ExcFrsPage.ExcFrsPageReqIdl;
/* loaded from: classes.dex */
public class o implements com.baidu.tbadk.mvc.b.h {
    private long dWZ;
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

    public long aMk() {
        return this.dWZ;
    }

    public void bT(long j) {
        this.dWZ = j;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> oQ() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object W(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.pn = Integer.valueOf(this.pn);
        builder.scr_w = Integer.valueOf(com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m411getInst()));
        builder.scr_h = Integer.valueOf(com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m411getInst()));
        builder.scr_dip = Double.valueOf(com.baidu.adp.lib.util.k.D(TbadkCoreApplication.m411getInst()));
        builder.tag_code = Long.valueOf(this.tagCode);
        builder.q_type = Integer.valueOf(az.wz().wB() ? 2 : 1);
        builder.last_rank = Long.valueOf(this.dWZ);
        ExcFrsPageReqIdl.Builder builder2 = new ExcFrsPageReqIdl.Builder();
        builder2.data = builder.build(false);
        com.baidu.tbadk.util.l.a(builder2.data, true);
        return builder2.build(false);
    }
}
