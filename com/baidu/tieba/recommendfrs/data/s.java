package com.baidu.tieba.recommendfrs.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.az;
import java.util.HashMap;
import tbclient.GodFeed.DataReq;
import tbclient.GodFeed.GodFeedReqIdl;
/* loaded from: classes.dex */
public class s implements com.baidu.tbadk.mvc.b.h {
    private long eae;
    private int pn;
    private int rn;
    private long tagCode;

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> ld() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object W(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.timeline = Long.valueOf(this.eae);
        builder.pn = Integer.valueOf(this.pn);
        builder.rn = Integer.valueOf(this.rn);
        builder.scr_w = Integer.valueOf(com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m11getInst()));
        builder.scr_h = Integer.valueOf(com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m11getInst()));
        builder.scr_dip = Double.valueOf(com.baidu.adp.lib.util.k.D(TbadkCoreApplication.m11getInst()));
        builder.q_type = Integer.valueOf(az.ug().ui() ? 2 : 1);
        GodFeedReqIdl.Builder builder2 = new GodFeedReqIdl.Builder();
        builder2.data = builder.build(false);
        com.baidu.tbadk.util.o.a(builder2.data, true);
        return builder2.build(false);
    }

    public void setRn(int i) {
        this.rn = i;
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public int getPn() {
        return this.pn;
    }

    public void bU(long j) {
        this.eae = j;
    }

    public long getTagCode() {
        return this.tagCode;
    }

    public void setTagCode(long j) {
        this.tagCode = j;
    }
}
