package com.baidu.tieba.pb.chosen.net;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.cache.l;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.ExcPbPage.ExcPbPageResIdl;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes3.dex */
public class ChosenPbHttpResponse extends HttpResponsedMessage implements a {
    private List<Post> postList;
    private ExcellentPbThreadInfo threadInfo;
    private UserInfo userInfo;
    private List<User> userList;

    @Override // com.baidu.tieba.pb.chosen.net.a
    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    @Override // com.baidu.tieba.pb.chosen.net.a
    public ExcellentPbThreadInfo getThreadInfo() {
        return this.threadInfo;
    }

    public ChosenPbHttpResponse(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        ExcPbPageResIdl excPbPageResIdl = (ExcPbPageResIdl) new Wire(new Class[0]).parseFrom(bArr, ExcPbPageResIdl.class);
        if (excPbPageResIdl != null) {
            if (excPbPageResIdl.error != null) {
                setError(excPbPageResIdl.error.errorno.intValue());
                setErrorString(excPbPageResIdl.error.usermsg);
            }
            if (excPbPageResIdl.data != null) {
                this.userInfo = excPbPageResIdl.data.user_info;
                this.threadInfo = excPbPageResIdl.data.thread_info;
                this.postList = excPbPageResIdl.data.post_list;
                this.userList = excPbPageResIdl.data.user_list;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        super.afterDispatchInBackGround(i, (int) bArr);
        if (bArr != null && bArr.length > 0) {
            l<byte[]> dA = com.baidu.tbadk.core.c.a.xj().dA("tb.pb_normal");
            dA.remove("chosen_pb_page_cache");
            dA.e("chosen_pb_page_cache", bArr);
        }
    }

    @Override // com.baidu.tieba.pb.chosen.net.a
    public int getErroCode() {
        return super.getError();
    }

    @Override // com.baidu.tieba.pb.chosen.net.a
    public String getErrorText() {
        return getErrorString();
    }

    @Override // com.baidu.tieba.pb.chosen.net.a
    public boolean isEmpty() {
        return this.threadInfo == null || this.threadInfo.content == null || this.threadInfo.content.size() <= 0;
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
