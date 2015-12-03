package com.baidu.tieba.location;

import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class LocationProvidersStatic {
    static {
        com.baidu.adp.lib.e.a.gD().a(c.aeW());
        boolean loadBoolean = TbadkSettings.getInst().loadBoolean("bd_loc_switcher", true);
        if (Build.VERSION.SDK_INT <= 4) {
            loadBoolean = false;
        }
        if (loadBoolean) {
            com.baidu.adp.lib.e.a.gD().a(a.aeV());
        }
        MessageManager.getInstance().registerListener(new i(CmdConfigCustom.EDITOR_COLLECT_TOOL));
    }
}
