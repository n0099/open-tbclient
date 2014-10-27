package com.baidu.tieba.im.util;

import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
import java.util.List;
import protobuf.UserInfo;
/* loaded from: classes.dex */
public final class POJOConverter {
    public static UserData fromUserInfo(UserInfo userInfo) {
        if (userInfo == null) {
            return null;
        }
        UserData userData = new UserData();
        userData.setLoginTime(userInfo.loginTime.intValue());
        userData.setLastReplyTime(userInfo.lastReplyTime.intValue());
        userData.setInTime(userInfo.inTime.intValue());
        userData.setLat(String.valueOf(userInfo.lat));
        userData.setLng(String.valueOf(userInfo.lng));
        userData.setPortrait(userInfo.portrait);
        userData.setUserIdLong(userInfo.userId.intValue());
        userData.setUserName(userInfo.userName);
        userData.setPortrait(userInfo.portrait);
        userData.setSex(userInfo.sex.intValue());
        return userData;
    }

    public static List<UserData> fromUserInfo(List<UserInfo> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (UserInfo userInfo : list) {
            arrayList.add(fromUserInfo(userInfo));
        }
        return arrayList;
    }
}
