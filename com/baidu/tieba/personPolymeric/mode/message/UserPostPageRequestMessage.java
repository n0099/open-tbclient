package com.baidu.tieba.personPolymeric.mode.message;

import UserPost.DataReq;
import UserPost.UserPostReqIdl;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.p;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.squareup.wire.Message;
/* loaded from: classes3.dex */
public class UserPostPageRequestMessage extends NetMessage {
    private int from;
    private boolean isHost;
    private boolean isReset;
    private boolean isThread;
    private int is_view_card;
    private PersonPostModel.a mCallback;
    private boolean needContent;
    private int pn;
    private int q_type;
    private int rn;
    private double scr_dip;
    private int scr_h;
    private int scr_w;
    private int sub_type;
    private String uid;

    public UserPostPageRequestMessage() {
        super(CmdConfigHttp.USER_POST_HTTP_CMD, 303002);
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public int getFrom() {
        return this.from;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public PersonPostModel.a getCallback() {
        return this.mCallback;
    }

    public void setCallback(PersonPostModel.a aVar) {
        this.mCallback = aVar;
    }

    public boolean isThread() {
        return this.isThread;
    }

    public void setThread(boolean z) {
        this.isThread = z;
    }

    public boolean isReset() {
        return this.isReset;
    }

    public void setReset(boolean z) {
        this.isReset = z;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public int getPn() {
        return this.pn;
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public void setRn(int i) {
        this.rn = i;
    }

    public void setNeedContent(boolean z) {
        this.needContent = z;
    }

    public void set_scr_w(int i) {
        this.scr_w = i;
    }

    public void set_scr_h(int i) {
        this.scr_h = i;
    }

    public void set_scr_dip(double d) {
        this.scr_dip = d;
    }

    public void set_q_type(int i) {
        this.q_type = i;
    }

    public void set_sub_type(int i) {
        this.sub_type = i;
    }

    public void set_is_view_card(int i) {
        this.is_view_card = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.NetMessage
    public Message encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.uid = Long.valueOf(b.c(this.uid, 0L));
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
            p.bindCommonParamsToProtobufData(builder, true);
        }
        UserPostReqIdl.Builder builder2 = new UserPostReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
