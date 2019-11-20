package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public final class SettingTextVersionView extends TbSettingTextTipView {
    public static String iVC = "has_shown_funtion_intro";

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
            am.setBackgroundResource(this.cBi, R.drawable.icon_news_head_new);
            this.cBi.setText((CharSequence) null);
            return;
        }
        this.cBi.setText(TbConfig.getVersion());
        this.cBi.setBackgroundDrawable(null);
        this.cBi.setTextAppearance(this.mContext, z2 ? R.style.setting_version_text_1 : R.style.setting_version_text);
    }
}
