package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public final class SettingTextVersionView extends TbSettingTextTipView {
    public SettingTextVersionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void i() {
        boolean z = false;
        boolean z2 = TbadkCoreApplication.getInst().getSkinType() == 1;
        VersionData versionData = TbadkCoreApplication.getInst().getVersionData();
        if (versionData != null && versionData.hasNewVer()) {
            z = true;
        }
        if (z) {
            SkinManager.setBackgroundResource(this.j, R.drawable.icon_news_head_new);
            this.j.setText((CharSequence) null);
            return;
        }
        this.j.setText(TbConfig.getVersion());
        this.j.setBackgroundDrawable(null);
        this.j.setTextAppearance(this.f13439e, z2 ? R.style.setting_version_text_1 : R.style.setting_version_text);
    }
}
