package com.baidu.tieba.tbadkCore;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class u {
    private static boolean ru(String str) {
        String[] stringArray = TbadkCoreApplication.m9getInst().getApp().getResources().getStringArray(r.b.voice_black_frs_list);
        String string = TbadkCoreApplication.m9getInst().getApp().getResources().getString(r.j.forum);
        int length = stringArray.length;
        for (int i = 0; i < length; i++) {
            if (stringArray[i].equals(str) || str.equals(String.valueOf(stringArray[i]) + string)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(String str, Boolean bool) {
        if (com.baidu.adp.lib.c.e.dN().ac("voice") == 0) {
            if ((str == null || !ru(str)) && bool != null) {
                return bool.booleanValue();
            }
            return false;
        }
        return false;
    }
}
