package com.baidu.tieba.util;

import com.baidu.adp.lib.cache.t;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class l {
    public static void a(String str, m mVar) {
        if (az.aA(str)) {
            if (mVar != null) {
                mVar.a(null);
                return;
            }
            return;
        }
        new n(hE(str), mVar).execute(new String[0]);
    }

    public static void b(String str, m mVar) {
        if (az.aA(str)) {
            if (mVar != null) {
                mVar.a(null);
                return;
            }
            return;
        }
        new n(hF(str), mVar).execute(new String[0]);
    }

    public static void a(int i, m mVar) {
        new n(hB(i), mVar).execute(new String[0]);
    }

    public static void a(int i, WriteData writeData) {
        t<String> bd = com.baidu.tbadk.core.a.a.kS().bd("tb.pb_editor");
        if (writeData != null && writeData.hasContentToSave()) {
            bd.b(hB(i), writeData.toDraftString(), 604800000L);
        } else {
            bd.H(hB(i));
        }
    }

    public static void a(String str, WriteData writeData) {
        if (!az.aA(str)) {
            t<String> bd = com.baidu.tbadk.core.a.a.kS().bd("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                bd.b(hF(str), writeData.toDraftString(), 604800000L);
            } else {
                bd.H(hF(str));
            }
        }
    }

    public static void b(String str, WriteData writeData) {
        if (!az.aA(str)) {
            t<String> bd = com.baidu.tbadk.core.a.a.kS().bd("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                bd.b(hE(str), writeData.toDraftString(), 604800000L);
            } else {
                bd.H(hE(str));
            }
        }
    }

    protected static String hE(String str) {
        return String.valueOf(TbadkApplication.getCurrentAccount()) + "@pb" + str;
    }

    protected static String hF(String str) {
        return String.valueOf(TbadkApplication.getCurrentAccount()) + "@frs" + str;
    }

    protected static String hB(int i) {
        return String.valueOf(TbadkApplication.getCurrentAccount()) + "@live" + i;
    }
}
