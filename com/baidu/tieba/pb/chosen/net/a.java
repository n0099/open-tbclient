package com.baidu.tieba.pb.chosen.net;

import java.util.List;
import tbclient.FinePbPage.ForumInfo;
import tbclient.FinePbPage.User_Info;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes.dex */
public interface a {
    int getErroCode();

    String getErrorText();

    ForumInfo getForumInfo();

    List<Post> getPostList();

    User_Info getUserInfo();

    List<User> getUserList();

    boolean isEmpty();
}
