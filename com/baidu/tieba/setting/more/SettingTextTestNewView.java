package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public final class SettingTextTestNewView extends TbSettingTextTipView {
    public SettingTextTestNewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        hideArrow();
        g(0, 0, l.h(context, e.C0175e.ds30), 0);
    }

    public void refresh() {
        boolean z = false;
        boolean z2 = TbadkCoreApplication.getInst().getSkinType() == 1;
        VersionData versionData = TbadkCoreApplication.getInst().getVersionData();
        if (versionData != null && versionData.hasNewVer()) {
            z = true;
        }
        if (z) {
            this.aQk.setText("new");
            this.aQk.setTextAppearance(this.mContext, z2 ? e.k.setting_version_prompt_text_1 : e.k.setting_version_prompt_text);
            al.i(this.aQk, e.f.icon_news_text_prompt);
            return;
        }
        String version = TbConfig.getVersion();
        this.aQk.setText((TbConfig.getVersionType() != 1 || ao.isEmpty(TbConfig.getSubVersion())) ? version : version + "." + TbConfig.getSubVersion());
        this.aQk.setBackgroundDrawable(null);
        this.aQk.setTextAppearance(this.mContext, z2 ? e.k.setting_version_text_1 : e.k.setting_version_text);
    }
}
