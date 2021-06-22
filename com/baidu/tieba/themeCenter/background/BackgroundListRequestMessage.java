package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.n0.z0.w;
import tbclient.GetBgList.DataReq;
import tbclient.GetBgList.GetBgListReqIdl;
/* loaded from: classes5.dex */
public class BackgroundListRequestMessage extends NetMessage {
    public int pn;
    public int rn;

    public BackgroundListRequestMessage() {
        super(CmdConfigHttp.CMD_PERSONAL_BACKGROUND_LIST, 309021);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.pn = Integer.valueOf(this.pn);
        builder.rn = Integer.valueOf(this.rn);
        if (z) {
            w.a(builder, true);
        }
        GetBgListReqIdl.Builder builder2 = new GetBgListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setPn(int i2) {
        this.pn = i2;
    }

    public void setRn(int i2) {
        this.rn = i2;
    }
}
