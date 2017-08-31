package com.baidu.tieba.tbadkCore;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class m {
    private static boolean rW(String str) {
        String[] stringArray = TbadkCoreApplication.getInst().getApp().getResources().getStringArray(d.b.voice_black_frs_list);
        String string = TbadkCoreApplication.getInst().getApp().getResources().getString(d.l.forum);
        int length = stringArray.length;
        for (int i = 0; i < length; i++) {
            if (stringArray[i].equals(str) || str.equals(stringArray[i] + string)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(String str, Boolean bool) {
        if (com.baidu.adp.lib.b.d.eW().af("voice") == 0) {
            if ((str == null || !rW(str)) && bool != null) {
                return bool.booleanValue();
            }
            return false;
        }
        return false;
    }
}
