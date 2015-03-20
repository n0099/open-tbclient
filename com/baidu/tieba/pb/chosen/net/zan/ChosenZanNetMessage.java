package com.baidu.tieba.pb.chosen.net.zan;

import android.text.TextUtils;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.j;
import tbclient.FineZan.DataReq;
import tbclient.FineZan.FineZanReqIdl;
/* loaded from: classes.dex */
public class ChosenZanNetMessage extends NetMessage {
    private String action;
    private long ftid;

    public ChosenZanNetMessage() {
        super(CmdConfigHttp.CMD_CHOSEN_PB_PRAISE, 307005);
    }

    public void setFtid(long j) {
        this.ftid = j;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public boolean isPraise() {
        return TextUtils.equals(this.action, "like");
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.action = this.action;
        builder.ftid = Long.valueOf(this.ftid);
        j.a(builder, true);
        FineZanReqIdl.Builder builder2 = new FineZanReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
