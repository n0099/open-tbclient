package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import d.b.b.e.p.k;
import d.b.b.e.p.l;
/* loaded from: classes5.dex */
public final class SettingTextTestNewView extends TbSettingTextTipView {
    public SettingTextTestNewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
        h(0, 0, l.g(context, R.dimen.ds30), 0);
    }

    public void i() {
        boolean z = false;
        boolean z2 = TbadkCoreApplication.getInst().getSkinType() == 1;
        VersionData versionData = TbadkCoreApplication.getInst().getVersionData();
        if (versionData != null && versionData.hasNewVer()) {
            z = true;
        }
        if (z) {
            this.j.setText("new");
            this.j.setTextAppearance(this.f13777e, z2 ? R.style.setting_version_prompt_text_1 : R.style.setting_version_prompt_text);
            SkinManager.setBackgroundResource(this.j, R.drawable.icon_news_text_prompt);
            return;
        }
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !k.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.j.setText(version);
        this.j.setBackgroundDrawable(null);
        this.j.setTextAppearance(this.f13777e, z2 ? R.style.setting_version_text_1 : R.style.setting_version_text);
    }
}
