package com.baidu.tieba.recommendfrs.data;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import java.util.HashMap;
import tbclient.FineFrsPage.DataReq;
import tbclient.FineFrsPage.FinefrspageReqIdl;
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.mvc.b.h {
    private int csU;
    private int ctg;
    private String tag;

    public String ajK() {
        return this.tag;
    }

    public void jV(String str) {
        this.tag = str;
    }

    public void jf(int i) {
        this.csU = i;
    }

    public void jg(int i) {
        this.ctg = i;
    }

    public int ajQ() {
        return this.ctg;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> oZ() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object aa(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.publish_time = Integer.valueOf(this.ctg);
        builder.scr_w = Integer.valueOf(k.K(TbadkCoreApplication.m411getInst()));
        builder.scr_h = Integer.valueOf(k.L(TbadkCoreApplication.m411getInst()));
        builder.scr_dip = Double.valueOf(k.M(TbadkCoreApplication.m411getInst()));
        builder.tag = this.tag;
        builder.q_type = Integer.valueOf(ar.uE().uG() ? 2 : 1);
        builder.forder = Integer.valueOf(this.csU);
        FinefrspageReqIdl.Builder builder2 = new FinefrspageReqIdl.Builder();
        builder2.data = builder.build(false);
        com.baidu.tbadk.util.g.a(builder2.data, true);
        return builder2.build(false);
    }
}
