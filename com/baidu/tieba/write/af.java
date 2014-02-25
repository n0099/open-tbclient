package com.baidu.tieba.write;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.WriteData;
/* loaded from: classes.dex */
public class af {
    public static void a(String str, ag agVar) {
        if (com.baidu.tieba.util.bs.c(str)) {
            if (agVar != null) {
                agVar.a(null);
                return;
            }
            return;
        }
        new ah(a(str), agVar).execute(new String[0]);
    }

    public static void b(String str, ag agVar) {
        if (com.baidu.tieba.util.bs.c(str)) {
            if (agVar != null) {
                agVar.a(null);
                return;
            }
            return;
        }
        new ah(b(str), agVar).execute(new String[0]);
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

    protected static String a(String str) {
        return String.valueOf(TiebaApplication.A()) + "@pb" + str;
    }

    protected static String b(String str) {
        return String.valueOf(TiebaApplication.A()) + "@frs" + str;
    }
}
