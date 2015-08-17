package com.baidu.tieba.tbadkCore;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class t {
    private static boolean kp(String str) {
        String[] stringArray = TbadkCoreApplication.m411getInst().getApp().getResources().getStringArray(i.b.voice_black_frs_list);
        String string = TbadkCoreApplication.m411getInst().getApp().getResources().getString(i.C0057i.forum);
        int length = stringArray.length;
        for (int i = 0; i < length; i++) {
            if (stringArray[i].equals(str) || str.equals(String.valueOf(stringArray[i]) + string)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(String str, Boolean bool) {
        if (com.baidu.adp.lib.b.e.gy().ah("voice") == 0) {
            if ((str == null || !kp(str)) && bool != null) {
                return bool.booleanValue();
            }
            return false;
        }
        return false;
    }
}
