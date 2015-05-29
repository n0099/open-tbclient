package com.baidu.tieba.pb.chosen.net;

import tbclient.FinePbPage.ForumInfo;
import tbclient.FinePbPage.User_Info;
/* loaded from: classes.dex */
public interface a {
    int getErroCode();

    String getErrorText();

    ForumInfo getForumInfo();

    User_Info getUserInfo();

    boolean isEmpty();
}
