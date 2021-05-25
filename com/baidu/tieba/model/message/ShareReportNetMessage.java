package com.baidu.tieba.model.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.m0.z0.w;
import tbclient.CommonReq;
import tbclient.Share.DataReq;
import tbclient.Share.ShareReqIdl;
/* loaded from: classes3.dex */
public class ShareReportNetMessage extends NetMessage {

    /* renamed from: common  reason: collision with root package name */
    public CommonReq f18359common;
    public long fid;
    public int from;
    public long tid;

    public ShareReportNetMessage() {
        super(CmdConfigHttp.CMD_SHARE_REPORT, 309480);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.f69550common = getCommon();
        builder.fid = Long.valueOf(getFid());
        builder.tid = Long.valueOf(getTid());
        builder.from = Integer.valueOf(getFrom());
        if (z) {
            w.a(builder, true);
        }
        ShareReqIdl.Builder builder2 = new ShareReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public CommonReq getCommon() {
        return this.f18359common;
    }

    public long getFid() {
        return this.fid;
    }

    public int getFrom() {
        return this.from;
    }

    public long getTid() {
        return this.tid;
    }

    public void setCommon(CommonReq commonReq) {
        this.f18359common = commonReq;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setFrom(int i2) {
        this.from = i2;
    }

    public void setTid(long j) {
        this.tid = j;
    }
}
