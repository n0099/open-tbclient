package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.VersionData;
/* loaded from: classes.dex */
public class SettingTextFunctionIntroView extends SettingTextVersionView {
    public static String cbU = "has_shown_funtion_intro";

    public SettingTextFunctionIntroView(Context context) {
        super(context);
        hideArrow();
    }

    public SettingTextFunctionIntroView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        hideArrow();
    }

    @Override // com.baidu.tieba.setting.more.SettingTextVersionView
    public void refresh() {
        YM();
        VersionData versionData = TbadkCoreApplication.m411getInst().getVersionData();
        boolean z = versionData != null && versionData.hasNewVer();
        boolean z2 = com.baidu.tbadk.core.sharedPref.b.rB().getBoolean(cbU, false);
        if (!z && !z2) {
            com.baidu.tbadk.core.util.ba.i((View) this.afy, com.baidu.tieba.u.icon_news_head_new);
        } else {
            hideTip();
        }
    }
}
