package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public final class NewFriendDbManagerStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic", new ArrayList());
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2001305", "com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic");
        hashMap.put("2001216", "com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic");
        hashMap.put("2001175", "com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic");
        hashMap.put("2001189", "com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic");
        hashMap.put("2001169", "com.baidu.tieba.addresslist.im.newFriend.NewFriendDbManagerStatic");
        return hashMap;
    }
}
