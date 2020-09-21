package com.baidu.tieba.interestlabel.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.interestlabel.b.b;
import tbclient.CommonReq;
import tbclient.GetTagList.DataReq;
import tbclient.GetTagList.GetTagListReqIdl;
/* loaded from: classes22.dex */
public class RequestGetLabelMessage extends NetMessage {

    /* renamed from: common  reason: collision with root package name */
    private CommonReq f986common;
    private int from;
    private b mLabelDataSet;

    public RequestGetLabelMessage() {
        super(1003333, CmdConfigSocket.CMD_GET_INTEREST_LABEL_LIST);
    }

    public void setCommon(CommonReq commonReq) {
        this.f986common = commonReq;
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
        builder.f1125common = this.f986common;
        builder.from = Integer.valueOf(this.from);
        if (z) {
            u.a(builder, true);
        }
        GetTagListReqIdl.Builder builder2 = new GetTagListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
