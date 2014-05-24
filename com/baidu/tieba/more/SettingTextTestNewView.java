package com.baidu.tieba.more;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.data.VersionData;
/* loaded from: classes.dex */
public final class SettingTextTestNewView extends TbSettingTextTipView {
    public SettingTextTestNewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a() {
        String version;
        boolean z = false;
        boolean z2 = TbadkApplication.m252getInst().getSkinType() == 1;
        VersionData B = com.baidu.tieba.ai.c().B();
        if (B != null && B.hasNewVer()) {
            z = true;
        }
        if (z) {
            this.d.setText("New");
            this.d.setTextAppearance(this.a, z2 ? com.baidu.tieba.z.setting_version_prompt_text_1 : com.baidu.tieba.z.setting_version_prompt_text);
            this.d.setBackgroundResource(z2 ? com.baidu.tieba.u.icon_news_text_prompt_1 : com.baidu.tieba.u.icon_news_text_prompt);
            return;
        }
        this.d.setText((TbConfig.getVersionType() != 1 || be.c(TbConfig.getSubVersion())) ? TbConfig.getVersion() : String.valueOf(version) + "." + TbConfig.getSubVersion());
        this.d.setBackgroundDrawable(null);
        this.d.setTextAppearance(this.a, z2 ? com.baidu.tieba.z.setting_version_text_1 : com.baidu.tieba.z.setting_version_text);
    }
}
