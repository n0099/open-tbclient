package com.baidu.tieba.model.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.o;
import tbclient.CommonReq;
import tbclient.Share.DataReq;
import tbclient.Share.ShareReqIdl;
/* loaded from: classes.dex */
public class ShareReportNetMessage extends NetMessage {
    private CommonReq common;
    private long fid;
    private int from;
    private long tid;

    public ShareReportNetMessage() {
        super(CmdConfigHttp.CMD_SHARE_REPORT, 309480);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.common = getCommon();
        builder.fid = Long.valueOf(getFid());
        builder.tid = Long.valueOf(getTid());
        builder.from = Integer.valueOf(getFrom());
        if (z) {
            o.bindCommonParamsToProtobufData(builder, true);
        }
        ShareReqIdl.Builder builder2 = new ShareReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public CommonReq getCommon() {
        return this.common;
    }

    public void setCommon(CommonReq commonReq) {
        this.common = commonReq;
    }

    public long getFid() {
        return this.fid;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public long getTid() {
        return this.tid;
    }

    public void setTid(long j) {
        this.tid = j;
    }

    public int getFrom() {
        return this.from;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
