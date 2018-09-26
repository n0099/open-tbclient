package com.baidu.tieba.interestlabel.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.p;
import com.baidu.tieba.interestlabel.b.b;
import tbclient.CommonReq;
import tbclient.GetTagList.DataReq;
import tbclient.GetTagList.GetTagListReqIdl;
/* loaded from: classes3.dex */
public class RequestGetLabelMessage extends NetMessage {
    private CommonReq common;
    private int from;
    private b mLabelDataSet;

    public RequestGetLabelMessage() {
        super(CmdConfigHttp.CMD_GET_INTEREST_LABEL_LIST, 309467);
    }

    public void setCommon(CommonReq commonReq) {
        this.common = commonReq;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setLabelDataSet(b bVar) {
        this.mLabelDataSet = bVar;
    }

    public b getLabelDataSet() {
        return this.mLabelDataSet;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.common = this.common;
        builder.from = Integer.valueOf(this.from);
        if (z) {
            p.bindCommonParamsToProtobufData(builder, true);
        }
        GetTagListReqIdl.Builder builder2 = new GetTagListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
