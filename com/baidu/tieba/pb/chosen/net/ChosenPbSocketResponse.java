package com.baidu.tieba.pb.chosen.net;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.cache.t;
import com.squareup.wire.Wire;
import tbclient.FinePbPage.FinePbPageResIdl;
import tbclient.FinePbPage.ForumInfo;
import tbclient.FinePbPage.User_Info;
/* loaded from: classes.dex */
public class ChosenPbSocketResponse extends SocketResponsedMessage implements a {
    private ForumInfo forumInfo;
    private long nextTid;
    private long preTid;
    private User_Info userInfo;

    public ChosenPbSocketResponse() {
        super(307003);
    }

    public long getPreTid() {
        return this.preTid;
    }

    public long getNextTid() {
        return this.nextTid;
    }

    @Override // com.baidu.tieba.pb.chosen.net.a
    public User_Info getUserInfo() {
        return this.userInfo;
    }

    @Override // com.baidu.tieba.pb.chosen.net.a
    public ForumInfo getForumInfo() {
        return this.forumInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        FinePbPageResIdl finePbPageResIdl = (FinePbPageResIdl) new Wire(new Class[0]).parseFrom(bArr, FinePbPageResIdl.class);
        if (finePbPageResIdl != null) {
            if (finePbPageResIdl.error != null) {
                setError(finePbPageResIdl.error.errorno.intValue());
                setErrorString(finePbPageResIdl.error.usermsg);
            }
            if (finePbPageResIdl.data != null) {
                this.preTid = finePbPageResIdl.data.prevftid.longValue();
                this.nextTid = finePbPageResIdl.data.nextftid.longValue();
                this.userInfo = finePbPageResIdl.data.user_info;
                this.forumInfo = finePbPageResIdl.data.thread_info;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        super.afterDispatchInBackGround(i, (int) bArr);
        if (bArr != null && bArr.length > 0) {
            t<byte[]> cj = com.baidu.tbadk.core.b.a.rI().cj("tb.pb_normal");
            cj.remove("chosen_pb_page_cache");
            cj.f("chosen_pb_page_cache", bArr);
        }
    }

    @Override // com.baidu.tieba.pb.chosen.net.a
    public String getErrorText() {
        return getErrorString();
    }

    @Override // com.baidu.tieba.pb.chosen.net.a
    public int getErroCode() {
        return getError();
    }

    @Override // com.baidu.tieba.pb.chosen.net.a
    public boolean isEmpty() {
        return this.forumInfo == null || this.forumInfo.content == null || this.forumInfo.content.size() <= 0;
    }
}
