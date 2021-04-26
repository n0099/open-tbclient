package com.baidu.tieba.model.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.i0.z0.w;
import tbclient.CheckRealName.CheckRealNameReqIdl;
import tbclient.CheckRealName.DataReq;
/* loaded from: classes3.dex */
public class CheckRealNameRequestNetMessage extends NetMessage {
    public String objSource;
    public Object objTag;

    public CheckRealNameRequestNetMessage() {
        super(CmdConfigHttp.CMD_CHECK_REAL_NAME, 309456);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.obj_source = this.objSource;
        if (z) {
            w.a(builder, true);
        }
        CheckRealNameReqIdl.Builder builder2 = new CheckRealNameReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public String getObjSource() {
        return this.objSource;
    }

    public Object getObjTag() {
        return this.objTag;
    }

    public void setObjSource(String str) {
        this.objSource = str;
    }

    public void setObjTag(Object obj) {
        this.objTag = obj;
    }
}
