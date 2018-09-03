package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public final class SettingTextTestNewView extends TbSettingTextTipView {
    public SettingTextTestNewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        hideArrow();
        f(0, 0, l.f(context, f.e.ds30), 0);
    }

    public void refresh() {
        boolean z = false;
        boolean z2 = TbadkCoreApplication.getInst().getSkinType() == 1;
        VersionData versionData = TbadkCoreApplication.getInst().getVersionData();
        if (versionData != null && versionData.hasNewVer()) {
            z = true;
        }
        if (z) {
            this.aIs.setText("new");
            this.aIs.setTextAppearance(this.mContext, z2 ? f.k.setting_version_prompt_text_1 : f.k.setting_version_prompt_text);
            am.i(this.aIs, f.C0146f.icon_news_text_prompt);
            return;
        }
        String version = TbConfig.getVersion();
        this.aIs.setText((TbConfig.getVersionType() != 1 || ap.isEmpty(TbConfig.getSubVersion())) ? version : version + "." + TbConfig.getSubVersion());
        this.aIs.setBackgroundDrawable(null);
        this.aIs.setTextAppearance(this.mContext, z2 ? f.k.setting_version_text_1 : f.k.setting_version_text);
    }
}
