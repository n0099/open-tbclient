package com.baidu.tieba.util;

import com.baidu.adp.lib.cache.s;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public final class m {
    public static void a(String str, n nVar) {
        if (bc.c(str)) {
            if (nVar != null) {
                nVar.a(null);
                return;
            }
            return;
        }
        new o(a(str), nVar).execute(new String[0]);
    }

    public static void b(String str, n nVar) {
        if (bc.c(str)) {
            if (nVar != null) {
                nVar.a(null);
                return;
            }
            return;
        }
        new o(b(str), nVar).execute(new String[0]);
    }

    public static void a(String str, WriteData writeData) {
        if (!bc.c(str)) {
            s<String> d = com.baidu.tbadk.core.c.b.a().d();
            if (writeData != null && writeData.hasContentToSave()) {
                d.b(b(str), writeData.toDraftString(), 604800000L);
            } else {
                d.d(b(str));
            }
        }
    }

    public static void b(String str, WriteData writeData) {
        if (!bc.c(str)) {
            s<String> d = com.baidu.tbadk.core.c.b.a().d();
            if (writeData != null && writeData.hasContentToSave()) {
                d.b(a(str), writeData.toDraftString(), 604800000L);
            } else {
                d.d(a(str));
            }
        }
    }

    private static String a(String str) {
        return String.valueOf(TbadkApplication.E()) + "@pb" + str;
    }

    private static String b(String str) {
        return String.valueOf(TbadkApplication.E()) + "@frs" + str;
    }
}
