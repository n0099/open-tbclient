package com.baidu.tieba.tbadkCore;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class v {
    private static boolean ps(String str) {
        String[] stringArray = TbadkCoreApplication.m9getInst().getApp().getResources().getStringArray(u.b.voice_black_frs_list);
        String string = TbadkCoreApplication.m9getInst().getApp().getResources().getString(u.j.forum);
        int length = stringArray.length;
        for (int i = 0; i < length; i++) {
            if (stringArray[i].equals(str) || str.equals(String.valueOf(stringArray[i]) + string)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(String str, Boolean bool) {
        if (com.baidu.adp.lib.c.e.cT().Z("voice") == 0) {
            if ((str == null || !ps(str)) && bool != null) {
                return bool.booleanValue();
            }
            return false;
        }
        return false;
    }
}
