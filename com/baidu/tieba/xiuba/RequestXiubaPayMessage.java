package com.baidu.tieba.xiuba;

import com.baidu.adp.lib.g.c;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import tbclient.XiubaExchange.DataReq;
import tbclient.XiubaExchange.XiubaExchangeReqIdl;
/* loaded from: classes.dex */
public class RequestXiubaPayMessage extends TbSocketMessage {
    private String password;
    private long tdouNum;
    private String xiubaUserId;

    public RequestXiubaPayMessage() {
        super(308006);
    }

    public String getXiubaUserId() {
        return this.xiubaUserId;
    }

    public void setXiubaUserId(String str) {
        this.xiubaUserId = str;
    }

    public long getTdouNum() {
        return this.tdouNum;
    }

    public void setTdouNum(long j) {
        this.tdouNum = j;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.xiubaUserId = Long.valueOf(c.a(getXiubaUserId(), 0L));
        builder.tdouNum = Long.valueOf(getTdouNum());
        builder.password = getPassword();
        XiubaExchangeReqIdl.Builder builder2 = new XiubaExchangeReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
