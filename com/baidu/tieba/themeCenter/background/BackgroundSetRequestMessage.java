package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.m0.z0.w;
import tbclient.SetBackground.DataReq;
import tbclient.SetBackground.SetBackgroundReqIdl;
/* loaded from: classes5.dex */
public class BackgroundSetRequestMessage extends NetMessage {
    public boolean isFromDetail;
    public int propId;
    public BdUniqueId requestUniqueId;

    public BackgroundSetRequestMessage() {
        super(CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);
        this.isFromDetail = false;
        this.requestUniqueId = null;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.props_id = Integer.valueOf(this.propId);
        if (z) {
            w.a(builder, true);
        }
        SetBackgroundReqIdl.Builder builder2 = new SetBackgroundReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public boolean getFromDetail() {
        return this.isFromDetail;
    }

    public int getPropId() {
        return this.propId;
    }

    public BdUniqueId getRequestUniqueId() {
        return this.requestUniqueId;
    }

    public void setFromDetail(boolean z) {
        this.isFromDetail = z;
    }

    public void setPropId(int i2) {
        this.propId = i2;
    }

    public void setRequestUniqueId(BdUniqueId bdUniqueId) {
        this.requestUniqueId = bdUniqueId;
    }
}
