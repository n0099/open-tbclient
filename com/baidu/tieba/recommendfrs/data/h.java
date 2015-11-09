package com.baidu.tieba.recommendfrs.data;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import java.util.HashMap;
import tbclient.FineFrsPage.DataReq;
import tbclient.FineFrsPage.FinefrspageReqIdl;
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.mvc.b.h {
    private int cKj;
    private int cKw;
    private String tag;

    public String aqQ() {
        return this.tag;
    }

    public void lf(String str) {
        this.tag = str;
    }

    public void kE(int i) {
        this.cKj = i;
    }

    public void kF(int i) {
        this.cKw = i;
    }

    public int aqW() {
        return this.cKw;
    }

    @Override // com.baidu.tbadk.mvc.b.g
    public HashMap<String, Object> oY() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public Object aa(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.publish_time = Integer.valueOf(this.cKw);
        builder.scr_w = Integer.valueOf(k.K(TbadkCoreApplication.m411getInst()));
        builder.scr_h = Integer.valueOf(k.L(TbadkCoreApplication.m411getInst()));
        builder.scr_dip = Double.valueOf(k.M(TbadkCoreApplication.m411getInst()));
        builder.tag = this.tag;
        builder.q_type = Integer.valueOf(at.uK().uM() ? 2 : 1);
        builder.forder = Integer.valueOf(this.cKj);
        FinefrspageReqIdl.Builder builder2 = new FinefrspageReqIdl.Builder();
        builder2.data = builder.build(false);
        com.baidu.tbadk.util.h.a(builder2.data, true);
        return builder2.build(false);
    }
}
