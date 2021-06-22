package com.baidu.tieba.pb.chosen.net;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.pb.chosen.PbChosenActivity;
import com.squareup.wire.Wire;
import d.a.c.e.d.l;
import d.a.o0.e2.g.c.a;
import java.util.List;
import tbclient.Error;
import tbclient.ExcPbPage.DataRes;
import tbclient.ExcPbPage.ExcContent;
import tbclient.ExcPbPage.ExcPbPageResIdl;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes5.dex */
public class ChosenPbHttpResponse extends HttpResponsedMessage implements a {
    public List<Post> postList;
    public ExcellentPbThreadInfo threadInfo;
    public UserInfo userInfo;
    public List<User> userList;

    public ChosenPbHttpResponse(int i2) {
        super(i2);
    }

    @Override // d.a.o0.e2.g.c.a
    public int getErroCode() {
        return super.getError();
    }

    @Override // d.a.o0.e2.g.c.a
    public String getErrorText() {
        return getErrorString();
    }

    @Override // d.a.o0.e2.g.c.a
    public List<Post> getPostList() {
        return this.postList;
    }

    @Override // d.a.o0.e2.g.c.a
    public ExcellentPbThreadInfo getThreadInfo() {
        return this.threadInfo;
    }

    @Override // d.a.o0.e2.g.c.a
    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    @Override // d.a.o0.e2.g.c.a
    public List<User> getUserList() {
        return this.userList;
    }

    @Override // d.a.o0.e2.g.c.a
    public boolean isEmpty() {
        List<ExcContent> list;
        ExcellentPbThreadInfo excellentPbThreadInfo = this.threadInfo;
        return excellentPbThreadInfo == null || (list = excellentPbThreadInfo.content) == null || list.size() <= 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i2, byte[] bArr) {
        super.afterDispatchInBackGround(i2, (int) bArr);
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        l<byte[]> d2 = d.a.n0.r.r.a.f().d("tb.pb_normal");
        d2.remove(PbChosenActivity.CHOSEN_PB_TABLE_NAME);
        d2.g(PbChosenActivity.CHOSEN_PB_TABLE_NAME, bArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        ExcPbPageResIdl excPbPageResIdl = (ExcPbPageResIdl) new Wire(new Class[0]).parseFrom(bArr, ExcPbPageResIdl.class);
        if (excPbPageResIdl == null) {
            return;
        }
        Error error = excPbPageResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(excPbPageResIdl.error.usermsg);
        }
        DataRes dataRes = excPbPageResIdl.data;
        if (dataRes == null) {
            return;
        }
        this.userInfo = dataRes.user_info;
        this.threadInfo = dataRes.thread_info;
        this.postList = dataRes.post_list;
        this.userList = dataRes.user_list;
    }
}
