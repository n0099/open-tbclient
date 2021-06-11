package com.baidu.tieba.interestlabel.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.m0.z0.w;
import d.a.n0.i1.b.b;
import tbclient.CommonReq;
import tbclient.GetTagList.DataReq;
import tbclient.GetTagList.GetTagListReqIdl;
/* loaded from: classes4.dex */
public class RequestGetLabelMessage extends NetMessage {

    /* renamed from: common  reason: collision with root package name */
    public CommonReq f17817common;
    public int from;
    public b mLabelDataSet;

    public RequestGetLabelMessage() {
        super(CmdConfigHttp.CMD_GET_INTEREST_LABEL_LIST, 309467);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.f72727common = this.f17817common;
        builder.from = Integer.valueOf(this.from);
        if (z) {
            w.a(builder, true);
        }
        GetTagListReqIdl.Builder builder2 = new GetTagListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public b getLabelDataSet() {
        return this.mLabelDataSet;
    }

    public void setCommon(CommonReq commonReq) {
        this.f17817common = commonReq;
    }

    public void setFrom(int i2) {
        this.from = i2;
    }

    public void setLabelDataSet(b bVar) {
        this.mLabelDataSet = bVar;
    }
}
