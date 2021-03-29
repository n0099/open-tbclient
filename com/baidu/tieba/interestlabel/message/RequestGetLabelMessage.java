package com.baidu.tieba.interestlabel.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.h0.z0.w;
import d.b.i0.g1.b.b;
import tbclient.CommonReq;
import tbclient.GetTagList.DataReq;
import tbclient.GetTagList.GetTagListReqIdl;
/* loaded from: classes3.dex */
public class RequestGetLabelMessage extends NetMessage {

    /* renamed from: common  reason: collision with root package name */
    public CommonReq f18483common;
    public int from;
    public b mLabelDataSet;

    public RequestGetLabelMessage() {
        super(CmdConfigHttp.CMD_GET_INTEREST_LABEL_LIST, 309467);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.f68493common = this.f18483common;
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
        this.f18483common = commonReq;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setLabelDataSet(b bVar) {
        this.mLabelDataSet = bVar;
    }
}
