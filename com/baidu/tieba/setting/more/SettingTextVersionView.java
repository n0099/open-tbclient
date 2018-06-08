package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public final class SettingTextVersionView extends TbSettingTextTipView {
    public static String gwl = "has_shown_funtion_intro";

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
            al.i(this.aHx, d.f.icon_news_head_new);
            this.aHx.setText((CharSequence) null);
            return;
        }
        this.aHx.setText(TbConfig.getVersion());
        this.aHx.setBackgroundDrawable(null);
        this.aHx.setTextAppearance(this.mContext, z2 ? d.l.setting_version_text_1 : d.l.setting_version_text);
    }
}
