package com.baidu.tieba.mention;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.CommonReq;
import tbclient.ReplyMe.DataReq;
import tbclient.ReplyMe.ReplyMeReqIdl;
/* loaded from: classes.dex */
public class ReplyMeRequestMessage extends NetMessage {
    private CommonReq common;
    private String ids;
    private com.baidu.tieba.model.am model;
    private Integer pn;
    private int updateType;

    public ReplyMeRequestMessage() {
        super(CmdConfigHttp.REPLYME_HTTP_CMD, 303007);
    }

    public com.baidu.tieba.model.am getModel() {
        return this.model;
    }

    public void setModel(com.baidu.tieba.model.am amVar) {
        this.model = amVar;
    }

    public int getUpdateType() {
        return this.updateType;
    }

    public void setUpdateType(int i) {
        this.updateType = i;
    }

    public Integer get_pn() {
        return this.pn;
    }

    public void set_pn(Integer num) {
        this.pn = num;
    }

    public String get_ids() {
        return this.ids;
    }

    public void set_ids(String str) {
        this.ids = str;
    }

    public CommonReq get_common() {
        return this.common;
    }

    public void set_common(CommonReq commonReq) {
        this.common = commonReq;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.pn = get_pn();
            builder.ids = get_ids();
            builder.common = get_common();
            if (z) {
                com.baidu.tbadk.util.g.a(builder, true);
            }
            ReplyMeReqIdl.Builder builder2 = new ReplyMeReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
