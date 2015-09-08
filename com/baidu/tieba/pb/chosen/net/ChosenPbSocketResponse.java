package com.baidu.tieba.pb.chosen.net;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.cache.o;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.FinePbPage.FinePbPageResIdl;
import tbclient.FinePbPage.ForumInfo;
import tbclient.FinePbPage.User_Info;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes.dex */
public class ChosenPbSocketResponse extends SocketResponsedMessage implements a {
    private ForumInfo forumInfo;
    private long nextTid;
    private List<Post> postList;
    private long preTid;
    private User_Info userInfo;
    private List<User> userList;

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
    @Override // com.baidu.adp.framework.message.a
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
                this.postList = finePbPageResIdl.data.post_list;
                this.userList = finePbPageResIdl.data.user_list;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        super.afterDispatchInBackGround(i, (int) bArr);
        if (bArr != null && bArr.length > 0) {
            o<byte[]> cp = com.baidu.tbadk.core.b.a.sR().cp("tb.pb_normal");
            cp.remove("chosen_pb_page_cache");
            cp.f("chosen_pb_page_cache", bArr);
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

    @Override // com.baidu.tieba.pb.chosen.net.a
    public List<Post> getPostList() {
        return this.postList;
    }

    @Override // com.baidu.tieba.pb.chosen.net.a
    public List<User> getUserList() {
        return this.userList;
    }
}
