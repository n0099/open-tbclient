package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* loaded from: classes.dex */
public final class SettingTextVersionView extends TbSettingTextTipView {
    public static String cgN = "has_shown_funtion_intro";

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
            com.baidu.tbadk.core.util.ay.i((View) this.agH, com.baidu.tieba.p.icon_news_head_new);
            this.agH.setText((CharSequence) null);
            return;
        }
        this.agH.setText(TbConfig.getVersion());
        this.agH.setBackgroundDrawable(null);
        this.agH.setTextAppearance(this.mContext, z2 ? com.baidu.tieba.u.setting_version_text_1 : com.baidu.tieba.u.setting_version_text);
    }
}
