package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public final class SettingTextVersionView extends TbSettingTextTipView {
    public static String eet = "has_shown_funtion_intro";

    public SettingTextVersionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void refresh() {
        boolean z = true;
        boolean z2 = TbadkCoreApplication.m411getInst().getSkinType() == 1;
        VersionData versionData = TbadkCoreApplication.m411getInst().getVersionData();
        if (versionData == null || !versionData.hasNewVer()) {
            z = false;
        }
        if (z) {
            com.baidu.tbadk.core.util.at.k(this.aqt, t.f.icon_news_head_new);
            this.aqt.setText((CharSequence) null);
            return;
        }
        this.aqt.setText(TbConfig.getVersion());
        this.aqt.setBackgroundDrawable(null);
        this.aqt.setTextAppearance(this.mContext, z2 ? t.k.setting_version_text_1 : t.k.setting_version_text);
    }
}
