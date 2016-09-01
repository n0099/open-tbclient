package com.baidu.tieba.person;

import tbclient.Profile.UserGodInfo;
import tbclient.TbBookrack;
import tbclient.User;
/* loaded from: classes.dex */
public interface c {
    User GetUser();

    TbBookrack getBookrackData();

    int getErrorCode();

    g getUcCardData();

    UserGodInfo getUserGodInfo();
}
