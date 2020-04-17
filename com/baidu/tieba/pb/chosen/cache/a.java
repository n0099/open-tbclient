package com.baidu.tieba.pb.chosen.cache;

import java.util.List;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes10.dex */
public class a implements com.baidu.tieba.pb.chosen.net.a {
    private UserInfo jmz;
    private List<Post> postList;
    private ExcellentPbThreadInfo threadInfo;
    private List<User> userList;

    public a(UserInfo userInfo, ExcellentPbThreadInfo excellentPbThreadInfo, List<Post> list, List<User> list2) {
        this.jmz = userInfo;
        this.threadInfo = excellentPbThreadInfo;
        this.postList = list;
        this.userList = list2;
    }

    @Override // com.baidu.tieba.pb.chosen.net.a
    public UserInfo getUserInfo() {
        return this.jmz;
    }

    @Override // com.baidu.tieba.pb.chosen.net.a
    public ExcellentPbThreadInfo getThreadInfo() {
        return this.threadInfo;
    }

    @Override // com.baidu.tieba.pb.chosen.net.a
    public int getErroCode() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.chosen.net.a
    public String getErrorText() {
        return null;
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
