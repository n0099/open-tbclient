package com.baidu.tieba.im.util;

import com.baidu.tieba.data.UserData;
import java.util.ArrayList;
import java.util.List;
import protobuf.Im;
/* loaded from: classes.dex */
public final class m {
    public static UserData a(Im.UserInfo userInfo) {
        if (userInfo == null) {
            return null;
        }
        UserData userData = new UserData();
        userData.setLoginTime(userInfo.getLoginTime());
        userData.setLastReplyTime(userInfo.getLastReplyTime());
        userData.setInTime(userInfo.getInTime());
        userData.setLat(String.valueOf(userInfo.getLat()));
        userData.setLng(String.valueOf(userInfo.getLng()));
        userData.setPortrait(userInfo.getPortrait());
        userData.setUserIdLong(userInfo.getUserId());
        userData.setUserName(userInfo.getUserName());
        userData.setPortrait(userInfo.getPortrait());
        userData.setSex(userInfo.getSex());
        return userData;
    }

    public static List<UserData> a(List<Im.UserInfo> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Im.UserInfo userInfo : list) {
            arrayList.add(a(userInfo));
        }
        return arrayList;
    }
}
