package com.baidu.tieba.tbadkCore;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class ao {
    public static void a(String str, ap apVar) {
        if (bd.isEmpty(str)) {
            if (apVar != null) {
                apVar.a(null);
                return;
            }
            return;
        }
        new aq(iH(str), apVar).execute(new String[0]);
    }

    public static void b(String str, ap apVar) {
        if (bd.isEmpty(str)) {
            if (apVar != null) {
                apVar.a(null);
                return;
            }
            return;
        }
        new aq(iI(str), apVar).execute(new String[0]);
    }

    public static void a(int i, ap apVar) {
        new aq(is(i), apVar).execute(new String[0]);
    }

    public static void a(int i, WriteData writeData) {
        com.baidu.adp.lib.cache.t<String> bX = com.baidu.tbadk.core.b.a.rc().bX("tb.pb_editor");
        if (writeData != null && writeData.hasContentToSave()) {
            bX.b(is(i), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
        } else {
            bX.ac(is(i));
        }
    }

    public static void a(String str, WriteData writeData) {
        if (!bd.isEmpty(str)) {
            com.baidu.adp.lib.cache.t<String> bX = com.baidu.tbadk.core.b.a.rc().bX("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                bX.b(iI(str), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                bX.ac(iI(str));
            }
        }
    }

    public static void b(String str, WriteData writeData) {
        if (!bd.isEmpty(str)) {
            com.baidu.adp.lib.cache.t<String> bX = com.baidu.tbadk.core.b.a.rc().bX("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                bX.b(iH(str), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                bX.ac(iH(str));
            }
        }
    }

    protected static String iH(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@pb" + str;
    }

    protected static String iI(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@frs" + str;
    }

    protected static String is(int i) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@live" + i;
    }
}
