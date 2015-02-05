package com.baidu.tieba.more;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* loaded from: classes.dex */
public final class SettingTextVersionView extends TbSettingTextTipView {
    public static String bxW = "has_shown_funtion_intro";

    public SettingTextVersionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void refresh() {
        boolean z = true;
        boolean z2 = TbadkCoreApplication.m255getInst().getSkinType() == 1;
        VersionData versionData = TbadkCoreApplication.m255getInst().getVersionData();
        if (versionData == null || !versionData.hasNewVer()) {
            z = false;
        }
        boolean z3 = com.baidu.tbadk.core.sharedPref.b.oc().getBoolean(bxW, false);
        if (z || (!z && !z3)) {
            com.baidu.tbadk.core.util.bc.i((View) this.Vw, com.baidu.tieba.v.icon_news_head_new);
            this.Vw.setText((CharSequence) null);
            return;
        }
        this.Vw.setText(TbConfig.getVersion());
        this.Vw.setBackgroundDrawable(null);
        this.Vw.setTextAppearance(this.mContext, z2 ? com.baidu.tieba.aa.setting_version_text_1 : com.baidu.tieba.aa.setting_version_text);
    }
}
