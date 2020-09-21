package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
/* loaded from: classes25.dex */
public final class SettingTextTestNewView extends TbSettingTextTipView {
    public SettingTextTestNewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        hideArrow();
        u(0, 0, l.getDimens(context, R.dimen.ds30), 0);
    }

    public void refresh() {
        boolean z = false;
        boolean z2 = TbadkCoreApplication.getInst().getSkinType() == 1;
        VersionData versionData = TbadkCoreApplication.getInst().getVersionData();
        if (versionData != null && versionData.hasNewVer()) {
            z = true;
        }
        if (z) {
            this.eJH.setText("new");
            this.eJH.setTextAppearance(this.mContext, z2 ? R.style.setting_version_prompt_text_1 : R.style.setting_version_prompt_text);
            ap.setBackgroundResource(this.eJH, R.drawable.icon_news_text_prompt);
            return;
        }
        String version = TbConfig.getVersion();
        this.eJH.setText((TbConfig.getVersionType() != 1 || at.isEmpty(TbConfig.getSubVersion())) ? version : version + "." + TbConfig.getSubVersion());
        this.eJH.setBackgroundDrawable(null);
        this.eJH.setTextAppearance(this.mContext, z2 ? R.style.setting_version_text_1 : R.style.setting_version_text);
    }
}
