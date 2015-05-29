package com.baidu.tieba.tbadkCore;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class ao {
    public static void a(String str, ap apVar) {
        if (bb.isEmpty(str)) {
            if (apVar != null) {
                apVar.a(null);
                return;
            }
            return;
        }
        new aq(jB(str), apVar).execute(new String[0]);
    }

    public static void b(String str, ap apVar) {
        if (bb.isEmpty(str)) {
            if (apVar != null) {
                apVar.a(null);
                return;
            }
            return;
        }
        new aq(jA(str), apVar).execute(new String[0]);
    }

    public static void c(String str, ap apVar) {
        if (bb.isEmpty(str)) {
            if (apVar != null) {
                apVar.a(null);
                return;
            }
            return;
        }
        new aq(jC(str), apVar).execute(new String[0]);
    }

    public static void a(int i, ap apVar) {
        new aq(iO(i), apVar).execute(new String[0]);
    }

    public static void a(int i, WriteData writeData) {
        com.baidu.adp.lib.cache.t<String> ck = com.baidu.tbadk.core.b.a.rI().ck("tb.pb_editor");
        if (writeData != null && writeData.hasContentToSave()) {
            ck.b(iO(i), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
        } else {
            ck.ae(iO(i));
        }
    }

    public static void a(String str, WriteData writeData) {
        if (!bb.isEmpty(str)) {
            com.baidu.adp.lib.cache.t<String> ck = com.baidu.tbadk.core.b.a.rI().ck("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                ck.b(jC(str), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                ck.ae(jC(str));
            }
        }
    }

    public static void b(String str, WriteData writeData) {
        if (!bb.isEmpty(str)) {
            com.baidu.adp.lib.cache.t<String> ck = com.baidu.tbadk.core.b.a.rI().ck("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                ck.b(jB(str), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                ck.ae(jB(str));
            }
        }
    }

    public static void c(String str, WriteData writeData) {
        if (!bb.isEmpty(str)) {
            com.baidu.adp.lib.cache.t<String> ck = com.baidu.tbadk.core.b.a.rI().ck("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                ck.b(jA(str), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                ck.ae(jA(str));
            }
        }
    }

    protected static String jA(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@subpb" + str;
    }

    protected static String jB(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@pb" + str;
    }

    protected static String jC(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@frs" + str;
    }

    protected static String iO(int i) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@live" + i;
    }
}
