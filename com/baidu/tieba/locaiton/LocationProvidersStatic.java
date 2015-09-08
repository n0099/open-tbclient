package com.baidu.tieba.locaiton;

import android.os.Build;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class LocationProvidersStatic {
    static {
        com.baidu.adp.lib.d.a.gC().a(c.ZP());
        boolean loadBoolean = TbadkSettings.getInst().loadBoolean("bd_loc_switcher", true);
        if (Build.VERSION.SDK_INT <= 4) {
            loadBoolean = false;
        }
        if (loadBoolean) {
            com.baidu.adp.lib.d.a.gC().a(a.ZO());
        }
    }
}
