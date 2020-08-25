package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public final class SettingTextVersionView extends TbSettingTextTipView {
    public static String lRv = "has_shown_funtion_intro";

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
            ap.setBackgroundResource(this.eHw, R.drawable.icon_news_head_new);
            this.eHw.setText((CharSequence) null);
            return;
        }
        this.eHw.setText(TbConfig.getVersion());
        this.eHw.setBackgroundDrawable(null);
        this.eHw.setTextAppearance(this.mContext, z2 ? R.style.setting_version_text_1 : R.style.setting_version_text);
    }
}
