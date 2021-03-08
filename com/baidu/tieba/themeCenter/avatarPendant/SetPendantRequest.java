package com.baidu.tieba.themeCenter.avatarPendant;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.v;
import tbclient.SetPendant.DataReq;
import tbclient.SetPendant.SetPendantReqIdl;
/* loaded from: classes8.dex */
public class SetPendantRequest extends NetMessage {
    private int freeUseLevel;
    private long pendantId;
    private int type;

    public SetPendantRequest() {
        super(1003179, CmdConfigSocket.CMD_SET_PENDANT);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.props_id = Long.valueOf(this.pendantId);
        builder.type = Integer.valueOf(this.type);
        if (z) {
            v.b(builder, true);
        }
        SetPendantReqIdl.Builder builder2 = new SetPendantReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public long getPendantId() {
        return this.pendantId;
    }

    public void setPendantId(long j) {
        this.pendantId = j;
    }

    public void setFreeUseLevel(int i) {
        this.freeUseLevel = i;
    }

    public int getFreeUseLevel() {
        return this.freeUseLevel;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
