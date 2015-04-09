package com.baidu.tieba.tbadkCore;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ad {
    private static boolean iA(String str) {
        String[] stringArray = TbadkCoreApplication.m411getInst().getApp().getResources().getStringArray(com.baidu.tieba.q.voice_black_frs_list);
        String string = TbadkCoreApplication.m411getInst().getApp().getResources().getString(com.baidu.tieba.y.forum);
        int length = stringArray.length;
        for (int i = 0; i < length; i++) {
            if (stringArray[i].equals(str) || str.equals(String.valueOf(stringArray[i]) + string)) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(String str, Boolean bool) {
        if (com.baidu.adp.lib.b.f.gz().ag("voice") == 0) {
            if ((str == null || !iA(str)) && bool != null) {
                return bool.booleanValue();
            }
            return false;
        }
        return false;
    }
}
