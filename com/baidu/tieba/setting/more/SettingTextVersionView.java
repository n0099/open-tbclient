package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public final class SettingTextVersionView extends TbSettingTextTipView {
    public static String lAc = "has_shown_funtion_intro";

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
            ao.setBackgroundResource(this.ewW, R.drawable.icon_news_head_new);
            this.ewW.setText((CharSequence) null);
            return;
        }
        this.ewW.setText(TbConfig.getVersion());
        this.ewW.setBackgroundDrawable(null);
        this.ewW.setTextAppearance(this.mContext, z2 ? R.style.setting_version_text_1 : R.style.setting_version_text);
    }
}
