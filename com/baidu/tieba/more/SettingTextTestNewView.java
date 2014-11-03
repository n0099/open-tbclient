package com.baidu.tieba.more;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.data.VersionData;
/* loaded from: classes.dex */
public final class SettingTextTestNewView extends TbSettingTextTipView {
    public SettingTextTestNewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void refresh() {
        String version;
        boolean z = false;
        boolean z2 = TbadkApplication.m251getInst().getSkinType() == 1;
        VersionData wK = com.baidu.tieba.aj.wm().wK();
        if (wK != null && wK.hasNewVer()) {
            z = true;
        }
        if (z) {
            this.Pi.setText("New");
            this.Pi.setTextAppearance(this.mContext, z2 ? com.baidu.tieba.z.setting_version_prompt_text_1 : com.baidu.tieba.z.setting_version_prompt_text);
            com.baidu.tbadk.core.util.aw.h((View) this.Pi, com.baidu.tieba.u.icon_news_text_prompt);
            return;
        }
        this.Pi.setText((TbConfig.getVersionType() != 1 || az.aA(TbConfig.getSubVersion())) ? TbConfig.getVersion() : String.valueOf(version) + "." + TbConfig.getSubVersion());
        this.Pi.setBackgroundDrawable(null);
        this.Pi.setTextAppearance(this.mContext, z2 ? com.baidu.tieba.z.setting_version_text_1 : com.baidu.tieba.z.setting_version_text);
    }
}
