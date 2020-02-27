package com.baidu.tieba.pb.chosen.net;

import java.util.List;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes10.dex */
public interface a {
    int getErroCode();

    String getErrorText();

    List<Post> getPostList();

    ExcellentPbThreadInfo getThreadInfo();

    UserInfo getUserInfo();

    List<User> getUserList();

    boolean isEmpty();
}
