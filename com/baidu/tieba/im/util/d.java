package com.baidu.tieba.im.util;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.chat.ImMessageCenterShowItemData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.groupInfo.v;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public final class d {
    public static void a(ImMessageCenterPojo imMessageCenterPojo) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(imMessageCenterPojo.getGid(), 0L);
        com.baidu.tieba.im.i.a(new e(imMessageCenterPojo, linkedHashMap), new f(imMessageCenterPojo));
    }

    public static void a(String str) {
        com.baidu.tieba.im.db.l.a().b(str);
        com.baidu.tieba.im.c.a.d().a((ImMessageCenterShowItemData) null);
        com.baidu.tieba.im.i.a(new g(str), null);
    }

    public static void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.im.i.a(new h(str, str2), new i(str, str2));
        }
    }

    public static void b(String str, String str2) {
        com.baidu.tieba.im.i.a(new j(str, str2), new k(str, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean b(String str) {
        if (v.c(TiebaApplication.v(), str)) {
            v.a(TiebaApplication.v(), str, false);
            v.c(TiebaApplication.v(), str, false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.baidu.tieba.im.db.k.a();
        return com.baidu.tieba.im.db.c.a().a(str, "apply_join_group") & true & com.baidu.tieba.im.db.k.a(str) & com.baidu.tieba.im.db.b.a().e(str);
    }
}
