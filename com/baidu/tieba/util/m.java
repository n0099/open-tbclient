package com.baidu.tieba.util;

import com.baidu.adp.lib.cache.t;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class m {
    public static void a(String str, n nVar) {
        if (ba.c(str)) {
            if (nVar != null) {
                nVar.a(null);
                return;
            }
            return;
        }
        new o(a(str), nVar).execute(new String[0]);
    }

    public static void b(String str, n nVar) {
        if (ba.c(str)) {
            if (nVar != null) {
                nVar.a(null);
                return;
            }
            return;
        }
        new o(b(str), nVar).execute(new String[0]);
    }

    public static void a(int i, n nVar) {
        new o(a(i), nVar).execute(new String[0]);
    }

    public static void a(int i, WriteData writeData) {
        t<String> b = com.baidu.tbadk.core.a.a.a().b("tb.pb_editor");
        if (writeData != null && writeData.hasContentToSave()) {
            b.b(a(i), writeData.toDraftString(), 604800000L);
        } else {
            b.d(a(i));
        }
    }

    public static void a(String str, WriteData writeData) {
        if (!ba.c(str)) {
            t<String> b = com.baidu.tbadk.core.a.a.a().b("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                b.b(b(str), writeData.toDraftString(), 604800000L);
            } else {
                b.d(b(str));
            }
        }
    }

    public static void b(String str, WriteData writeData) {
        if (!ba.c(str)) {
            t<String> b = com.baidu.tbadk.core.a.a.a().b("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                b.b(a(str), writeData.toDraftString(), 604800000L);
            } else {
                b.d(a(str));
            }
        }
    }

    protected static String a(String str) {
        return String.valueOf(TbadkApplication.getCurrentAccount()) + "@pb" + str;
    }

    protected static String b(String str) {
        return String.valueOf(TbadkApplication.getCurrentAccount()) + "@frs" + str;
    }

    protected static String a(int i) {
        return String.valueOf(TbadkApplication.getCurrentAccount()) + "@live" + i;
    }
}
