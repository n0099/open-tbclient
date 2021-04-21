package com.baidu.tieba.personPolymeric.mode.message;

import UserPost.DataReq;
import UserPost.UserPostReqIdl;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.squareup.wire.Message;
import d.b.c.e.m.b;
import d.b.i0.z0.w;
import tbclient.User;
/* loaded from: classes3.dex */
public class UserPostPageRequestMessage extends NetMessage {
    public int from;
    public boolean isHost;
    public boolean isReset;
    public boolean isThread;
    public int is_view_card;
    public PersonPostModel.c mCallback;
    public boolean needContent;
    public int pn;
    public int q_type;
    public int rn;
    public double scr_dip;
    public int scr_h;
    public int scr_w;
    public int sub_type;
    public User threadUser;
    public String uid;

    public UserPostPageRequestMessage() {
        super(CmdConfigHttp.USER_POST_HTTP_CMD, 303002);
    }

    public PersonPostModel.c getCallback() {
        return this.mCallback;
    }

    public int getFrom() {
        return this.from;
    }

    public int getPn() {
        return this.pn;
    }

    public User getThreadUser() {
        return this.threadUser;
    }

    public String getUid() {
        return this.uid;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public boolean isReset() {
        return this.isReset;
    }

    public boolean isThread() {
        return this.isThread;
    }

    public void setCallback(PersonPostModel.c cVar) {
        this.mCallback = cVar;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setNeedContent(boolean z) {
        this.needContent = z;
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public void setReset(boolean z) {
        this.isReset = z;
    }

    public void setRn(int i) {
        this.rn = i;
    }

    public void setThread(boolean z) {
        this.isThread = z;
    }

    public void setThreadUser(User user) {
        this.threadUser = user;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void set_is_view_card(int i) {
        this.is_view_card = i;
    }

    public void set_q_type(int i) {
        this.q_type = i;
    }

    public void set_scr_dip(double d2) {
        this.scr_dip = d2;
    }

    public void set_scr_h(int i) {
        this.scr_h = i;
    }

    public void set_scr_w(int i) {
        this.scr_w = i;
    }

    public void set_sub_type(int i) {
        this.sub_type = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.NetMessage
    public Message encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.uid = Long.valueOf(b.f(this.uid, 0L));
        builder.pn = Integer.valueOf(this.pn);
        builder.rn = Integer.valueOf(this.rn);
        builder.is_thread = Integer.valueOf(this.isThread ? 1 : 0);
        builder.need_content = Integer.valueOf(this.needContent ? 1 : 0);
        builder.scr_dip = Double.valueOf(this.scr_dip);
        builder.q_type = Integer.valueOf(this.q_type);
        builder.scr_h = Integer.valueOf(this.scr_h);
        builder.scr_w = Integer.valueOf(this.scr_w);
        builder.subtype = Integer.valueOf(this.sub_type);
        builder.is_view_card = Integer.valueOf(this.is_view_card);
        if (z) {
            w.a(builder, true);
        }
        UserPostReqIdl.Builder builder2 = new UserPostReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
