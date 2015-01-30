package com.baidu.tieba.more;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* loaded from: classes.dex */
public class SettingTextFunctionIntroView extends TbSettingTextTipView {
    public static String bxX = "has_shown_funtion_intro";

    public SettingTextFunctionIntroView(Context context) {
        super(context);
    }

    public SettingTextFunctionIntroView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void refresh() {
        VersionData versionData = TbadkCoreApplication.m255getInst().getVersionData();
        boolean z = versionData != null && versionData.hasNewVer();
        boolean z2 = com.baidu.tbadk.core.sharedPref.b.oj().getBoolean(bxX, false);
        if (!z && !z2) {
            com.baidu.tbadk.core.util.bc.i((View) this.Vz, com.baidu.tieba.v.icon_news_head_new);
        } else {
            tW();
        }
    }
}
