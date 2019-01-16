package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public final class SettingTextVersionView extends TbSettingTextTipView {
    public static String hcz = "has_shown_funtion_intro";

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
            al.i(this.aVj, e.f.icon_news_head_new);
            this.aVj.setText((CharSequence) null);
            return;
        }
        this.aVj.setText(TbConfig.getVersion());
        this.aVj.setBackgroundDrawable(null);
        this.aVj.setTextAppearance(this.mContext, z2 ? e.k.setting_version_text_1 : e.k.setting_version_text);
    }
}
