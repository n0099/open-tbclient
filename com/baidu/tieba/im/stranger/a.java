package com.baidu.tieba.im.stranger;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
public class a {
    public static void a(String str, int i) {
        ImMessageCenterPojo a;
        if (!TextUtils.isEmpty(str) && (a = com.baidu.tieba.im.b.k.a().a(str)) != null && i != a.getIsFriend()) {
            com.baidu.tieba.im.i.a(new b(str, i), null);
            a.setIsFriend(i);
        }
    }

    public static void a(ImMessageCenterPojo imMessageCenterPojo, int i) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getIsFriend() != i) {
            com.baidu.tieba.im.i.a(new c(imMessageCenterPojo, i), null);
            imMessageCenterPojo.setIsFriend(i);
        }
    }

    public static void a(String str) {
        ImMessageCenterPojo a;
        if (!TextUtils.isEmpty(str) && (a = com.baidu.tieba.im.b.k.a().a(str)) != null) {
            a.setIs_hidden(1);
            com.baidu.tieba.im.i.a(new d(str), null);
        }
    }
}
