package com.baidu.tieba.write;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.WriteData;
/* loaded from: classes.dex */
public final class ae {
    public static void a(String str, af afVar) {
        if (com.baidu.tieba.util.bs.c(str)) {
            if (afVar != null) {
                afVar.a(null);
                return;
            }
            return;
        }
        new ag(a(str), afVar).execute(new String[0]);
    }

    public static void b(String str, af afVar) {
        if (com.baidu.tieba.util.bs.c(str)) {
            if (afVar != null) {
                afVar.a(null);
                return;
            }
            return;
        }
        new ag(b(str), afVar).execute(new String[0]);
    }

    public static void a(String str, WriteData writeData) {
        if (!com.baidu.tieba.util.bs.c(str)) {
            com.baidu.adp.lib.cache.s<String> d = com.baidu.tieba.c.a.a().d();
            if (writeData != null && writeData.hasContentToSave()) {
                d.b(b(str), writeData.toDraftString(), 604800000L);
            } else {
                d.d(b(str));
            }
        }
    }

    public static void b(String str, WriteData writeData) {
        if (!com.baidu.tieba.util.bs.c(str)) {
            com.baidu.adp.lib.cache.s<String> d = com.baidu.tieba.c.a.a().d();
            if (writeData != null && writeData.hasContentToSave()) {
                d.b(a(str), writeData.toDraftString(), 604800000L);
            } else {
                d.d(a(str));
            }
        }
    }

    private static String a(String str) {
        return String.valueOf(TiebaApplication.v()) + "@pb" + str;
    }

    private static String b(String str) {
        return String.valueOf(TiebaApplication.v()) + "@frs" + str;
    }
}
