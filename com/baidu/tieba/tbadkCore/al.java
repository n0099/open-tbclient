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
        new an(il(str), amVar).execute(new String[0]);
    }

    public static void b(String str, am amVar) {
        if (bf.isEmpty(str)) {
            if (amVar != null) {
                amVar.a(null);
                return;
            }
            return;
        }
        new an(im(str), amVar).execute(new String[0]);
    }

    public static void a(int i, am amVar) {
        new an(hT(i), amVar).execute(new String[0]);
    }

    public static void a(int i, WriteData writeData) {
        com.baidu.adp.lib.cache.t<String> bT = com.baidu.tbadk.core.a.a.nV().bT("tb.pb_editor");
        if (writeData != null && writeData.hasContentToSave()) {
            bT.b(hT(i), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
        } else {
            bT.V(hT(i));
        }
    }

    public static void a(String str, WriteData writeData) {
        if (!bf.isEmpty(str)) {
            com.baidu.adp.lib.cache.t<String> bT = com.baidu.tbadk.core.a.a.nV().bT("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                bT.b(im(str), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                bT.V(im(str));
            }
        }
    }

    public static void b(String str, WriteData writeData) {
        if (!bf.isEmpty(str)) {
            com.baidu.adp.lib.cache.t<String> bT = com.baidu.tbadk.core.a.a.nV().bT("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                bT.b(il(str), writeData.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            } else {
                bT.V(il(str));
            }
        }
    }

    protected static String il(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@pb" + str;
    }

    protected static String im(String str) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@frs" + str;
    }

    protected static String hT(int i) {
        return String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@live" + i;
    }
}
