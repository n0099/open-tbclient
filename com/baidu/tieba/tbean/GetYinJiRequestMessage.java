package com.baidu.tieba.tbean;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.GetIconList.GetIconListReqIdl;
import tbclient.GetIconList.ReqData;
/* loaded from: classes.dex */
public class GetYinJiRequestMessage extends NetMessage {
    private String st_type;

    public GetYinJiRequestMessage() {
        super(CmdConfigHttp.CMD_HTTP_GET_YINJI, 306001);
    }

    public String getSt_type() {
        this.st_type = "st_type";
        return this.st_type;
    }

    public void setSt_type(String str) {
        this.st_type = str;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        ReqData.Builder builder = new ReqData.Builder();
        builder.st_type = getSt_type();
        if (z) {
            com.baidu.tbadk.util.j.a(builder, true);
        }
        GetIconListReqIdl.Builder builder2 = new GetIconListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
