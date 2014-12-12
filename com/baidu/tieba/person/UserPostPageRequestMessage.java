package com.baidu.tieba.person;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Message;
import java.lang.ref.WeakReference;
import tbclient.UserPost.DataReq;
import tbclient.UserPost.UserPostReqIdl;
/* loaded from: classes.dex */
public class UserPostPageRequestMessage extends NetMessage {
    private boolean isReset;
    private boolean isThread;
    private WeakReference<br> mCallbackWeakReference;
    private boolean needContent;
    private int pn;
    private int rn;
    private String uid;

    public UserPostPageRequestMessage() {
        super(CmdConfigHttp.USER_POST_HTTP_CMD, 303002);
    }

    public WeakReference<br> getmCallbackWeakReference() {
        return this.mCallbackWeakReference;
    }

    public void setmCallbackWeakReference(WeakReference<br> weakReference) {
        this.mCallbackWeakReference = weakReference;
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

    public int getRn() {
        return this.rn;
    }

    public void setRn(int i) {
        this.rn = i;
    }

    public boolean isNeedContent() {
        return this.needContent;
    }

    public void setNeedContent(boolean z) {
        this.needContent = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.NetMessage
    public Message encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.uid = Long.valueOf(com.baidu.adp.lib.g.c.a(this.uid, 0L));
        builder.pn = Integer.valueOf(this.pn);
        builder.rn = Integer.valueOf(this.rn);
        builder.is_thread = Integer.valueOf(this.isThread ? 1 : 0);
        builder.need_content = Integer.valueOf(this.needContent ? 1 : 0);
        if (z) {
            com.baidu.tbadk.util.h.a(builder, true);
        }
        UserPostReqIdl.Builder builder2 = new UserPostReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
