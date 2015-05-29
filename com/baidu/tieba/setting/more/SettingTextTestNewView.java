package com.baidu.tieba.setting.more;

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
        hideArrow();
        e(0, 0, com.baidu.adp.lib.util.n.d(context, com.baidu.tieba.o.ds30), 0);
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
            this.agH.setText("new");
            this.agH.setTextAppearance(this.mContext, z2 ? com.baidu.tieba.u.setting_version_prompt_text_1 : com.baidu.tieba.u.setting_version_prompt_text);
            com.baidu.tbadk.core.util.ay.i((View) this.agH, com.baidu.tieba.p.icon_news_text_prompt);
            return;
        }
        this.agH.setText((TbConfig.getVersionType() != 1 || com.baidu.tbadk.core.util.bb.isEmpty(TbConfig.getSubVersion())) ? TbConfig.getVersion() : String.valueOf(version) + "." + TbConfig.getSubVersion());
        this.agH.setBackgroundDrawable(null);
        this.agH.setTextAppearance(this.mContext, z2 ? com.baidu.tieba.u.setting_version_text_1 : com.baidu.tieba.u.setting_version_text);
    }
}
