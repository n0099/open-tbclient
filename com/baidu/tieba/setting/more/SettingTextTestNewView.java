package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public final class SettingTextTestNewView extends TbSettingTextTipView {
    public SettingTextTestNewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        hideArrow();
        g(0, 0, com.baidu.adp.lib.util.k.c(context, t.e.ds30), 0);
    }

    public void refresh() {
        String version;
        boolean z = false;
        boolean z2 = TbadkCoreApplication.m411getInst().getSkinType() == 1;
        VersionData versionData = TbadkCoreApplication.m411getInst().getVersionData();
        if (versionData != null && versionData.hasNewVer()) {
            z = true;
        }
        if (z) {
            this.aqc.setText("new");
            this.aqc.setTextAppearance(this.mContext, z2 ? t.k.setting_version_prompt_text_1 : t.k.setting_version_prompt_text);
            com.baidu.tbadk.core.util.ar.k(this.aqc, t.f.icon_news_text_prompt);
            return;
        }
        this.aqc.setText((TbConfig.getVersionType() != 1 || com.baidu.tbadk.core.util.aw.isEmpty(TbConfig.getSubVersion())) ? TbConfig.getVersion() : String.valueOf(version) + "." + TbConfig.getSubVersion());
        this.aqc.setBackgroundDrawable(null);
        this.aqc.setTextAppearance(this.mContext, z2 ? t.k.setting_version_text_1 : t.k.setting_version_text);
    }
}
