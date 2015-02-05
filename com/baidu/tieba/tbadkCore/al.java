package com.baidu.tieba.tbadkCore;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class al {
    public static void a(String str, am amVar) {
        if (bf.isEmpty(str)) {
            if (amVar != null) {
                amVar.a(null);
                return;
            }
            return;
        }
        new an(ij(str), amVar).execute(new String[0]);
    }

    public static void b(String str, am amVar) {
        if (bf.isEmpty(str)) {
            if (amVar != null) {
                amVar.a(null);
                return;
            }
            return;
        }
        new an(ik(str), amVar).execute(new String[0]);
    }

    public static void a(int i, am amVar) {
        new an(hT(i), amVar).execute(new String[0]);
    }

    public static void a(int i, WriteData writeData) {
        com.baidu.adp.lib.cache.t<String> bQ = com.baidu.tbadk.core.a.a.nO().bQ("tb.pb_editor");
        if (writeData != null && writeData.hasContentToSave()) {
            bQ.b(hT(i), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
        } else {
            bQ.V(hT(i));
        }
    }

    public static void a(String str, WriteData writeData) {
        if (!bf.isEmpty(str)) {
            com.baidu.adp.lib.cache.t<String> bQ = com.baidu.tbadk.core.a.a.nO().bQ("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                bQ.b(ik(str), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                bQ.V(ik(str));
            }
        }
    }

    public static void b(String str, WriteData writeData) {
        if (!bf.isEmpty(str)) {
            com.baidu.adp.lib.cache.t<String> bQ = com.baidu.tbadk.core.a.a.nO().bQ("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                bQ.b(ij(str), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                bQ.V(ij(str));
            }
        }
    }

    protected static String ij(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@pb" + str;
    }

    protected static String ik(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@frs" + str;
    }

    protected static String hT(int i) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@live" + i;
    }
}
