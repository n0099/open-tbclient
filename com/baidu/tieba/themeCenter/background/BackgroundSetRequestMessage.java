package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.SetBackground.DataReq;
import tbclient.SetBackground.SetBackgroundReqIdl;
/* loaded from: classes.dex */
public class BackgroundSetRequestMessage extends NetMessage {
    private int propId;

    public BackgroundSetRequestMessage() {
        super(CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.props_id = Integer.valueOf(this.propId);
        if (z) {
            com.baidu.tbadk.util.i.a(builder, true);
        }
        SetBackgroundReqIdl.Builder builder2 = new SetBackgroundReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setPropId(int i) {
        this.propId = i;
    }

    public int getPropId() {
        return this.propId;
    }
}
