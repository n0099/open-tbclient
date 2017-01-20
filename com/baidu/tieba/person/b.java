package com.baidu.tieba.person;

import tbclient.Feedback;
import tbclient.Profile.UserGodInfo;
import tbclient.TbBookrack;
import tbclient.User;
import tbclient.UserManChannelInfo;
/* loaded from: classes.dex */
public interface b {
    User GetUser();

    TbBookrack getBookrackData();

    int getErrorCode();

    Feedback getFeedBack();

    f getUcCardData();

    UserManChannelInfo getUserChannelInfo();

    UserGodInfo getUserGodInfo();
}
