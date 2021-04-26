package com.baidu.tieba.themeCenter.avatarPendant;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.i0.z0.w;
import tbclient.SetPendant.DataReq;
import tbclient.SetPendant.SetPendantReqIdl;
/* loaded from: classes5.dex */
public class SetPendantRequest extends NetMessage {
    public int freeUseLevel;
    public long pendantId;
    public int type;

    public SetPendantRequest() {
        super(CmdConfigHttp.CMD_SET_PENDANT, 309412);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.props_id = Long.valueOf(this.pendantId);
        builder.type = Integer.valueOf(this.type);
        if (z) {
            w.a(builder, true);
        }
        SetPendantReqIdl.Builder builder2 = new SetPendantReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public int getFreeUseLevel() {
        return this.freeUseLevel;
    }

    public long getPendantId() {
        return this.pendantId;
    }

    public int getType() {
        return this.type;
    }

    public void setFreeUseLevel(int i2) {
        this.freeUseLevel = i2;
    }

    public void setPendantId(long j) {
        this.pendantId = j;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}
