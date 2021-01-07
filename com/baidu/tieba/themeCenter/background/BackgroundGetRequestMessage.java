package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import tbclient.GetBackground.DataReq;
import tbclient.GetBackground.GetBackgroundReqIdl;
/* loaded from: classes9.dex */
public class BackgroundGetRequestMessage extends NetMessage {
    private int propId;

    public BackgroundGetRequestMessage() {
        super(1003035, CmdConfigSocket.CMD_PERSONAL_BACKGROUND_GET);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.props_id = Integer.valueOf(this.propId);
        if (z) {
            t.b(builder, true);
        }
        GetBackgroundReqIdl.Builder builder2 = new GetBackgroundReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setPropId(int i) {
        this.propId = i;
    }
}
