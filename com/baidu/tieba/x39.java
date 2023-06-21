package com.baidu.tieba;

import java.util.List;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes8.dex */
public interface x39 {
    int getErroCode();

    String getErrorText();

    List<Post> getPostList();

    ExcellentPbThreadInfo getThreadInfo();

    UserInfo getUserInfo();

    List<User> getUserList();

    boolean isEmpty();
}
