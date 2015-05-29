package com.baidu.tieba.tbadkCore;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ad {
    private static boolean jt(String str) {
        String[] stringArray = TbadkCoreApplication.m411getInst().getApp().getResources().getStringArray(com.baidu.tieba.l.voice_black_frs_list);
        String string = TbadkCoreApplication.m411getInst().getApp().getResources().getString(com.baidu.tieba.t.forum);
        int length = stringArray.length;
        for (int i = 0; i < length; i++) {
            if (stringArray[i].equals(str) || str.equals(String.valueOf(stringArray[i]) + string)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(String str, Boolean bool) {
        if (com.baidu.adp.lib.b.f.gD().ai("voice") == 0) {
            if ((str == null || !jt(str)) && bool != null) {
                return bool.booleanValue();
            }
            return false;
        }
        return false;
    }
}
