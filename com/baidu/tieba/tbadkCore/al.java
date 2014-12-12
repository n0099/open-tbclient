package com.baidu.tieba.tbadkCore;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class al {
    public static void a(String str, am amVar) {
        if (ba.isEmpty(str)) {
            if (amVar != null) {
                amVar.a(null);
                return;
            }
            return;
        }
        new an(id(str), amVar).execute(new String[0]);
    }

    public static void b(String str, am amVar) {
        if (ba.isEmpty(str)) {
            if (amVar != null) {
                amVar.a(null);
                return;
            }
            return;
        }
        new an(ie(str), amVar).execute(new String[0]);
    }

    public static void a(int i, am amVar) {
        new an(hK(i), amVar).execute(new String[0]);
    }

    public static void a(int i, WriteData writeData) {
        com.baidu.adp.lib.cache.t<String> bV = com.baidu.tbadk.core.a.a.nS().bV("tb.pb_editor");
        if (writeData != null && writeData.hasContentToSave()) {
            bV.b(hK(i), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
        } else {
            bV.V(hK(i));
        }
    }

    public static void a(String str, WriteData writeData) {
        if (!ba.isEmpty(str)) {
            com.baidu.adp.lib.cache.t<String> bV = com.baidu.tbadk.core.a.a.nS().bV("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                bV.b(ie(str), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                bV.V(ie(str));
            }
        }
    }

    public static void b(String str, WriteData writeData) {
        if (!ba.isEmpty(str)) {
            com.baidu.adp.lib.cache.t<String> bV = com.baidu.tbadk.core.a.a.nS().bV("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                bV.b(id(str), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                bV.V(id(str));
            }
        }
    }

    protected static String id(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@pb" + str;
    }

    protected static String ie(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@frs" + str;
    }

    protected static String hK(int i) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@live" + i;
    }
}
