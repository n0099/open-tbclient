package com.baidu.tieba.pb.chosen.net;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.j;
import tbclient.FinePbPage.DataReq;
import tbclient.FinePbPage.FinePbPageReqIdl;
/* loaded from: classes.dex */
public class ChosenPbNetMessage extends NetMessage {
    public static final int QUALITY_HIGH = 80;
    public static final int QUALITY_LOW = 45;
    private long q_type;
    private long scrH;
    private long scrW;
    private long scr_dip;
    private long tid;

    public ChosenPbNetMessage() {
        super(CmdConfigHttp.CMD_GET_FINE_PB, 307003);
    }

    public void setTid(long j) {
        this.tid = j;
    }

    public void setScrH(long j) {
        this.scrH = j;
    }

    public void setScrW(long j) {
        this.scrW = j;
    }

    public void setScr_dip(long j) {
        this.scr_dip = j;
    }

    public void setQ_type(long j) {
        this.q_type = j;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.ftid = Long.valueOf(this.tid);
        builder.q_type = Long.valueOf(this.q_type);
        builder.scr_h = Long.valueOf(this.scrH);
        builder.scr_w = Long.valueOf(this.scrW);
        builder.scr_dip = Long.valueOf(this.scr_dip);
        j.a(builder, true);
        FinePbPageReqIdl.Builder builder2 = new FinePbPageReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
