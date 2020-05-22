package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public final class SettingTextTestNewView extends TbSettingTextTipView {
    public SettingTextTestNewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        hideArrow();
        t(0, 0, l.getDimens(context, R.dimen.ds30), 0);
    }

    public void refresh() {
        boolean z = false;
        boolean z2 = TbadkCoreApplication.getInst().getSkinType() == 1;
        VersionData versionData = TbadkCoreApplication.getInst().getVersionData();
        if (versionData != null && versionData.hasNewVer()) {
            z = true;
        }
        if (z) {
            this.ehU.setText("new");
            this.ehU.setTextAppearance(this.mContext, z2 ? R.style.setting_version_prompt_text_1 : R.style.setting_version_prompt_text);
            am.setBackgroundResource(this.ehU, R.drawable.icon_news_text_prompt);
            return;
        }
        String version = TbConfig.getVersion();
        this.ehU.setText((TbConfig.getVersionType() != 1 || aq.isEmpty(TbConfig.getSubVersion())) ? version : version + "." + TbConfig.getSubVersion());
        this.ehU.setBackgroundDrawable(null);
        this.ehU.setTextAppearance(this.mContext, z2 ? R.style.setting_version_text_1 : R.style.setting_version_text);
    }
}
