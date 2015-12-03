package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.GetBackground.DataReq;
import tbclient.GetBackground.GetBackgroundReqIdl;
/* loaded from: classes.dex */
public class BackgroundGetRequestMessage extends NetMessage {
    private int propId;

    public BackgroundGetRequestMessage() {
        super(CmdConfigHttp.CMD_PERSONAL_BACKGROUND_GET, 309023);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.props_id = Integer.valueOf(this.propId);
        if (z) {
            com.baidu.tbadk.util.i.a(builder, true);
        }
        GetBackgroundReqIdl.Builder builder2 = new GetBackgroundReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setPropId(int i) {
        this.propId = i;
    }
}
