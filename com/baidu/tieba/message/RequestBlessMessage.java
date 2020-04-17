package com.baidu.tieba.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import tbclient.CommonReq;
import tbclient.UserPk.DataReq;
import tbclient.UserPk.UserPkReqIdl;
/* loaded from: classes.dex */
public class RequestBlessMessage extends NetMessage {
    private int click_type;

    /* renamed from: common  reason: collision with root package name */
    private CommonReq f1031common;
    public Long pk_id;
    private int pk_index;
    private int pk_type;
    private Long topic_id;
    private long user_pk_id;

    public RequestBlessMessage() {
        super(1003065, CmdConfigSocket.CMD_TOPIC_BLESS);
    }

    public void setCommon(CommonReq commonReq) {
        this.f1031common = commonReq;
    }

    public void setPkId(Long l) {
        this.pk_id = l;
    }

    public void setTopicId(Long l) {
        this.topic_id = l;
    }

    public void setPkIndex(int i) {
        this.pk_index = i;
    }

    public void setClickType(int i) {
        this.click_type = i;
    }

    public void setPkType(int i) {
        this.pk_type = i;
    }

    public void setUserPkId(long j) {
        this.user_pk_id = j;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.f1278common = this.f1031common;
        builder.pk_id = this.pk_id;
        builder.topic_id = this.topic_id;
        builder.pk_index = Integer.valueOf(this.pk_index);
        builder.click_type = Integer.valueOf(this.click_type);
        builder.pk_type = Integer.valueOf(this.pk_type);
        builder.user_pk_id = Long.valueOf(this.user_pk_id);
        if (z) {
            t.a(builder, true);
        }
        UserPkReqIdl.Builder builder2 = new UserPkReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
