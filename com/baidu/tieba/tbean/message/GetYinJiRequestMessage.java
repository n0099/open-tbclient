package com.baidu.tieba.tbean.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.m0.z0.w;
import tbclient.GetIconList.GetIconListReqIdl;
import tbclient.GetIconList.ReqData;
/* loaded from: classes5.dex */
public class GetYinJiRequestMessage extends NetMessage {
    public String st_type;

    public GetYinJiRequestMessage() {
        super(CmdConfigHttp.CMD_HTTP_GET_YINJI, 306001);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        ReqData.Builder builder = new ReqData.Builder();
        builder.st_type = getSt_type();
        if (z) {
            w.a(builder, true);
        }
        GetIconListReqIdl.Builder builder2 = new GetIconListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public String getSt_type() {
        this.st_type = "st_type";
        return "st_type";
    }

    public void setSt_type(String str) {
        this.st_type = str;
    }
}
