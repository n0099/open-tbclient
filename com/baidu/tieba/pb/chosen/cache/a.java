package com.baidu.tieba.pb.chosen.cache;

import java.util.List;
import tbclient.FinePbPage.ForumInfo;
import tbclient.FinePbPage.User_Info;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.pb.chosen.net.a {
    private User_Info cac;
    private ForumInfo forumInfo;
    private long nextTid;
    private List<Post> postList;
    private long preTid;
    private List<User> userList;

    public a(long j, long j2, User_Info user_Info, ForumInfo forumInfo, List<Post> list, List<User> list2) {
        this.preTid = j;
        this.nextTid = j2;
        this.cac = user_Info;
        this.forumInfo = forumInfo;
        this.postList = list;
        this.userList = list2;
    }

    @Override // com.baidu.tieba.pb.chosen.net.a
    public User_Info getUserInfo() {
        return this.cac;
    }

    @Override // com.baidu.tieba.pb.chosen.net.a
    public ForumInfo getForumInfo() {
        return this.forumInfo;
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
