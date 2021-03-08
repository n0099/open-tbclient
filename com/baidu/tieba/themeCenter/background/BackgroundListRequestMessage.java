package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.v;
import tbclient.GetBgList.DataReq;
import tbclient.GetBgList.GetBgListReqIdl;
/* loaded from: classes8.dex */
public class BackgroundListRequestMessage extends NetMessage {
    private int pn;
    private int rn;

    public BackgroundListRequestMessage() {
        super(1003034, CmdConfigSocket.CMD_PERSONAL_BACKGROUND_LIST);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.pn = Integer.valueOf(this.pn);
        builder.rn = Integer.valueOf(this.rn);
        if (z) {
            v.b(builder, true);
        }
        GetBgListReqIdl.Builder builder2 = new GetBgListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public void setRn(int i) {
        this.rn = i;
    }
}
