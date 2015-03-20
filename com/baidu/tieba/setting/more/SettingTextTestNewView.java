package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.coreExtra.data.VersionData;
/* loaded from: classes.dex */
public final class SettingTextTestNewView extends SettingTextVersionView {
    public SettingTextTestNewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        hideArrow();
    }

    @Override // com.baidu.tieba.setting.more.SettingTextVersionView
    public void refresh() {
        String version;
        boolean z = false;
        boolean z2 = TbadkCoreApplication.m411getInst().getSkinType() == 1;
        VersionData versionData = TbadkCoreApplication.m411getInst().getVersionData();
        if (versionData != null && versionData.hasNewVer()) {
            z = true;
        }
        if (z) {
            com.baidu.tbadk.core.util.ba.i((View) this.afy, com.baidu.tieba.u.icon_news_head_new);
            this.afy.setText((CharSequence) null);
            return;
        }
        this.afy.setText((TbConfig.getVersionType() != 1 || bd.isEmpty(TbConfig.getSubVersion())) ? TbConfig.getVersion() : String.valueOf(version) + "." + TbConfig.getSubVersion());
        this.afy.setBackgroundDrawable(null);
        this.afy.setTextAppearance(this.mContext, z2 ? com.baidu.tieba.z.setting_version_text_1 : com.baidu.tieba.z.setting_version_text);
    }
}
