package com.baidu.tieba.tbadkCore;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class aa {
    private static boolean ib(String str) {
        String[] stringArray = TbadkCoreApplication.m255getInst().getApp().getResources().getStringArray(com.baidu.tieba.r.voice_black_frs_list);
        String string = TbadkCoreApplication.m255getInst().getApp().getResources().getString(com.baidu.tieba.z.forum);
        int length = stringArray.length;
        for (int i = 0; i < length; i++) {
            if (stringArray[i].equals(str) || str.equals(String.valueOf(stringArray[i]) + string)) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(String str, Boolean bool) {
        if (com.baidu.adp.lib.b.f.da().Z("voice") == 0) {
            if ((str == null || !ib(str)) && bool != null) {
                return bool.booleanValue();
            }
            return false;
        }
        return false;
    }
}
