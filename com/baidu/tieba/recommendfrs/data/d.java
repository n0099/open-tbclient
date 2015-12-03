package com.baidu.tieba.recommendfrs.data;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.util.i;
import java.util.HashMap;
import tbclient.ExcFrsPage.DataReq;
import tbclient.ExcFrsPage.ExcFrsPageReqIdl;
/* loaded from: classes.dex */
public class d implements h {
    private long diN;
    private int pn;
    private long tagCode;

    public void setPn(int i) {
        this.pn = i;
    }

    public long awm() {
        return this.tagCode;
    }

    public void setTagCode(long j) {
        this.tagCode = j;
    }

    public long awn() {
        return this.diN;
    }

    public void by(long j) {
        this.diN = j;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> pe() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object aa(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.pn = Integer.valueOf(this.pn);
        builder.scr_w = Integer.valueOf(k.K(TbadkCoreApplication.m411getInst()));
        builder.scr_h = Integer.valueOf(k.L(TbadkCoreApplication.m411getInst()));
        builder.scr_dip = Double.valueOf(k.M(TbadkCoreApplication.m411getInst()));
        builder.tag_code = Long.valueOf(this.tagCode);
        builder.q_type = Integer.valueOf(ay.vq().vs() ? 2 : 1);
        builder.last_rank = Long.valueOf(this.diN);
        ExcFrsPageReqIdl.Builder builder2 = new ExcFrsPageReqIdl.Builder();
        builder2.data = builder.build(false);
        i.a(builder2.data, true);
        return builder2.build(false);
    }
}
