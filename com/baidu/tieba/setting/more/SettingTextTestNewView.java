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
public final class SettingTextTestNewView extends TbSettingTextTipView {
    public SettingTextTestNewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        hideArrow();
        h(0, 0, com.baidu.adp.lib.util.k.d(context, i.d.ds30), 0);
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
            this.alN.setText("new");
            this.alN.setTextAppearance(this.mContext, z2 ? i.j.setting_version_prompt_text_1 : i.j.setting_version_prompt_text);
            com.baidu.tbadk.core.util.al.i((View) this.alN, i.e.icon_news_text_prompt);
            return;
        }
        this.alN.setText((TbConfig.getVersionType() != 1 || com.baidu.tbadk.core.util.aq.isEmpty(TbConfig.getSubVersion())) ? TbConfig.getVersion() : String.valueOf(version) + "." + TbConfig.getSubVersion());
        this.alN.setBackgroundDrawable(null);
        this.alN.setTextAppearance(this.mContext, z2 ? i.j.setting_version_text_1 : i.j.setting_version_text);
    }
}
