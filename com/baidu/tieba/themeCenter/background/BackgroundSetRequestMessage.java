package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import tbclient.SetBackground.DataReq;
import tbclient.SetBackground.SetBackgroundReqIdl;
/* loaded from: classes9.dex */
public class BackgroundSetRequestMessage extends NetMessage {
    private boolean isFromDetail;
    private int propId;
    private BdUniqueId requestUniqueId;

    public BackgroundSetRequestMessage() {
        super(1003036, CmdConfigSocket.CMD_PERSONAL_BACKGROUND_SET);
        this.isFromDetail = false;
        this.requestUniqueId = null;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.props_id = Integer.valueOf(this.propId);
        if (z) {
            t.b(builder, true);
        }
        SetBackgroundReqIdl.Builder builder2 = new SetBackgroundReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setRequestUniqueId(BdUniqueId bdUniqueId) {
        this.requestUniqueId = bdUniqueId;
    }

    public BdUniqueId getRequestUniqueId() {
        return this.requestUniqueId;
    }

    public void setPropId(int i) {
        this.propId = i;
    }

    public int getPropId() {
        return this.propId;
    }

    public void setFromDetail(boolean z) {
        this.isFromDetail = z;
    }

    public boolean getFromDetail() {
        return this.isFromDetail;
    }
}
