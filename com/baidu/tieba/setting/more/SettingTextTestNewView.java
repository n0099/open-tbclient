package com.baidu.tieba.setting.more;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.l;
import com.baidu.ar.util.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public final class SettingTextTestNewView extends TbSettingTextTipView {
    public SettingTextTestNewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        hideArrow();
        o(0, 0, l.t(context, d.e.ds30), 0);
    }

    public void refresh() {
        boolean z = false;
        boolean z2 = TbadkCoreApplication.getInst().getSkinType() == 1;
        VersionData versionData = TbadkCoreApplication.getInst().getVersionData();
        if (versionData != null && versionData.hasNewVer()) {
            z = true;
        }
        if (z) {
            this.boz.setText("new");
            this.boz.setTextAppearance(this.mContext, z2 ? d.k.setting_version_prompt_text_1 : d.k.setting_version_prompt_text);
            aj.s(this.boz, d.f.icon_news_text_prompt);
            return;
        }
        String version = TbConfig.getVersion();
        this.boz.setText((TbConfig.getVersionType() != 1 || am.isEmpty(TbConfig.getSubVersion())) ? version : version + Constants.DOT + TbConfig.getSubVersion());
        this.boz.setBackgroundDrawable(null);
        this.boz.setTextAppearance(this.mContext, z2 ? d.k.setting_version_text_1 : d.k.setting_version_text);
    }
}
