package com.baidu.tieba.recommendfrs.data;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import java.util.HashMap;
import tbclient.FineFrsPage.DataReq;
import tbclient.FineFrsPage.FinefrspageReqIdl;
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.mvc.b.h {
    private int cBm;
    private int cBz;
    private String tag;

    public String anQ() {
        return this.tag;
    }

    public void kA(String str) {
        this.tag = str;
    }

    public void jP(int i) {
        this.cBm = i;
    }

    public void jQ(int i) {
        this.cBz = i;
    }

    public int anW() {
        return this.cBz;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> oW() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object aa(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.publish_time = Integer.valueOf(this.cBz);
        builder.scr_w = Integer.valueOf(k.K(TbadkCoreApplication.m411getInst()));
        builder.scr_h = Integer.valueOf(k.L(TbadkCoreApplication.m411getInst()));
        builder.scr_dip = Double.valueOf(k.M(TbadkCoreApplication.m411getInst()));
        builder.tag = this.tag;
        builder.q_type = Integer.valueOf(ar.uK().uM() ? 2 : 1);
        builder.forder = Integer.valueOf(this.cBm);
        FinefrspageReqIdl.Builder builder2 = new FinefrspageReqIdl.Builder();
        builder2.data = builder.build(false);
        com.baidu.tbadk.util.g.a(builder2.data, true);
        return builder2.build(false);
    }
}
