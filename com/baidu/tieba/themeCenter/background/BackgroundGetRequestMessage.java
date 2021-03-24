package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.h0.z0.w;
import tbclient.GetBackground.DataReq;
import tbclient.GetBackground.GetBackgroundReqIdl;
/* loaded from: classes5.dex */
public class BackgroundGetRequestMessage extends NetMessage {
    public int propId;

    public BackgroundGetRequestMessage() {
        super(CmdConfigHttp.CMD_PERSONAL_BACKGROUND_GET, 309023);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.props_id = Integer.valueOf(this.propId);
        if (z) {
            w.a(builder, true);
        }
        GetBackgroundReqIdl.Builder builder2 = new GetBackgroundReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setPropId(int i) {
        this.propId = i;
    }
}
