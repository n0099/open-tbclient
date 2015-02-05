package com.baidu.tieba.more;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* loaded from: classes.dex */
public final class SettingTextTestNewView extends TbSettingTextTipView {
    public SettingTextTestNewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void refresh() {
        String version;
        boolean z = false;
        boolean z2 = TbadkCoreApplication.m255getInst().getSkinType() == 1;
        VersionData versionData = TbadkCoreApplication.m255getInst().getVersionData();
        if (versionData != null && versionData.hasNewVer()) {
            z = true;
        }
        if (z) {
            this.Vw.setText("new");
            this.Vw.setTextAppearance(this.mContext, z2 ? com.baidu.tieba.aa.setting_version_prompt_text_1 : com.baidu.tieba.aa.setting_version_prompt_text);
            com.baidu.tbadk.core.util.bc.i((View) this.Vw, com.baidu.tieba.v.icon_news_text_prompt);
            return;
        }
        this.Vw.setText((TbConfig.getVersionType() != 1 || com.baidu.tbadk.core.util.bf.isEmpty(TbConfig.getSubVersion())) ? TbConfig.getVersion() : String.valueOf(version) + "." + TbConfig.getSubVersion());
        this.Vw.setBackgroundDrawable(null);
        this.Vw.setTextAppearance(this.mContext, z2 ? com.baidu.tieba.aa.setting_version_text_1 : com.baidu.tieba.aa.setting_version_text);
    }
}
