package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class s {
    private static boolean ND(String str) {
        String[] stringArray = TbadkCoreApplication.getInst().getApp().getResources().getStringArray(R.array.voice_black_frs_list);
        String string = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.forum);
        int length = stringArray.length;
        for (int i = 0; i < length; i++) {
            if (stringArray[i].equals(str) || str.equals(stringArray[i] + string)) {
                return true;
            }
        }
        return false;
    }

    public static boolean d(String str, Boolean bool) {
        if (SwitchManager.getInstance().findType("voice") == 0) {
            if ((str == null || !ND(str)) && bool != null) {
                return bool.booleanValue();
            }
            return false;
        }
        return false;
    }
}
