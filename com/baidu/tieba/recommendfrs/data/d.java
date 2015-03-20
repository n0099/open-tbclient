package com.baidu.tieba.recommendfrs.data;

import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.mvc.b.i;
import com.baidu.tbadk.util.j;
import java.util.HashMap;
import tbclient.FineFrsPage.DataReq;
import tbclient.FineFrsPage.FinefrspageReqIdl;
/* loaded from: classes.dex */
public class d implements i {
    private int bXP;

    public void hL(int i) {
        this.bXP = i;
    }

    public int afH() {
        return this.bXP;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> oC() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.l
    public Object V(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.publish_time = Integer.valueOf(this.bXP);
        builder.scr_w = Integer.valueOf(n.M(TbadkCoreApplication.m411getInst()));
        builder.scr_h = Integer.valueOf(n.N(TbadkCoreApplication.m411getInst()));
        builder.scr_dip = Double.valueOf(n.O(TbadkCoreApplication.m411getInst()));
        builder.q_type = Integer.valueOf(be.sY().ta() ? 2 : 1);
        FinefrspageReqIdl.Builder builder2 = new FinefrspageReqIdl.Builder();
        builder2.data = builder.build(false);
        j.a(builder2.data, true);
        return builder2.build(false);
    }
}
