package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public final class SettingTextVersionView extends TbSettingTextTipView {
    public static String cQg = "has_shown_funtion_intro";

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
            com.baidu.tbadk.core.util.an.i((View) this.alW, i.e.icon_news_head_new);
            this.alW.setText((CharSequence) null);
            return;
        }
        this.alW.setText(TbConfig.getVersion());
        this.alW.setBackgroundDrawable(null);
        this.alW.setTextAppearance(this.mContext, z2 ? i.C0057i.setting_version_text_1 : i.C0057i.setting_version_text);
    }
}
