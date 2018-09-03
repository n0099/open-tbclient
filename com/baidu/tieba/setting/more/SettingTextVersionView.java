package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public final class SettingTextVersionView extends TbSettingTextTipView {
    public static String gBp = "has_shown_funtion_intro";

    public SettingTextVersionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void refresh() {
        boolean z = true;
        boolean z2 = TbadkCoreApplication.getInst().getSkinType() == 1;
        VersionData versionData = TbadkCoreApplication.getInst().getVersionData();
        if (versionData == null || !versionData.hasNewVer()) {
            z = false;
        }
        if (z) {
            am.i(this.aIs, f.C0146f.icon_news_head_new);
            this.aIs.setText((CharSequence) null);
            return;
        }
        this.aIs.setText(TbConfig.getVersion());
        this.aIs.setBackgroundDrawable(null);
        this.aIs.setTextAppearance(this.mContext, z2 ? f.k.setting_version_text_1 : f.k.setting_version_text);
    }
}
