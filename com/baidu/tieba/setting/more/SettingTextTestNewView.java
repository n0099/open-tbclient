package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public final class SettingTextTestNewView extends TbSettingTextTipView {
    public SettingTextTestNewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        hideArrow();
        k(0, 0, l.h(context, d.e.ds30), 0);
    }

    public void refresh() {
        boolean z = false;
        boolean z2 = TbadkCoreApplication.getInst().getSkinType() == 1;
        VersionData versionData = TbadkCoreApplication.getInst().getVersionData();
        if (versionData != null && versionData.hasNewVer()) {
            z = true;
        }
        if (z) {
            this.ceI.setText("new");
            this.ceI.setTextAppearance(this.mContext, z2 ? d.k.setting_version_prompt_text_1 : d.k.setting_version_prompt_text);
            al.k(this.ceI, d.f.icon_news_text_prompt);
            return;
        }
        String version = TbConfig.getVersion();
        this.ceI.setText((TbConfig.getVersionType() != 1 || ap.isEmpty(TbConfig.getSubVersion())) ? version : version + "." + TbConfig.getSubVersion());
        this.ceI.setBackgroundDrawable(null);
        this.ceI.setTextAppearance(this.mContext, z2 ? d.k.setting_version_text_1 : d.k.setting_version_text);
    }
}
