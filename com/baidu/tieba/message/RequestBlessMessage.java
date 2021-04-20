package com.baidu.tieba.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.h0.z0.w;
import tbclient.CommonReq;
import tbclient.UserPk.DataReq;
import tbclient.UserPk.UserPkReqIdl;
/* loaded from: classes3.dex */
public class RequestBlessMessage extends NetMessage {
    public int click_type;

    /* renamed from: common  reason: collision with root package name */
    public CommonReq f18702common;
    public Long pk_id;
    public int pk_index;
    public int pk_type;
    public Long topic_id;
    public long user_pk_id;

    public RequestBlessMessage() {
        super(CmdConfigHttp.CMD_TOPIC_BLESS, 309085);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.f69665common = this.f18702common;
        builder.pk_id = this.pk_id;
        builder.topic_id = this.topic_id;
        builder.pk_index = Integer.valueOf(this.pk_index);
        builder.click_type = Integer.valueOf(this.click_type);
        builder.pk_type = Integer.valueOf(this.pk_type);
        builder.user_pk_id = Long.valueOf(this.user_pk_id);
        if (z) {
            w.a(builder, true);
        }
        UserPkReqIdl.Builder builder2 = new UserPkReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setClickType(int i) {
        this.click_type = i;
    }

    public void setCommon(CommonReq commonReq) {
        this.f18702common = commonReq;
    }

    public void setPkId(Long l) {
        this.pk_id = l;
    }

    public void setPkIndex(int i) {
        this.pk_index = i;
    }

    public void setPkType(int i) {
        this.pk_type = i;
    }

    public void setTopicId(Long l) {
        this.topic_id = l;
    }

    public void setUserPkId(long j) {
        this.user_pk_id = j;
    }
}
