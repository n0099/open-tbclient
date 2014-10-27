package com.baidu.tieba.more;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.data.VersionData;
/* loaded from: classes.dex */
public final class SettingTextVersionView extends TbSettingTextTipView {
    public static String bsB = "has_shown_funtion_intro";

    public SettingTextVersionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void refresh() {
        boolean z = true;
        boolean z2 = TbadkApplication.m251getInst().getSkinType() == 1;
        VersionData wI = com.baidu.tieba.aj.wk().wI();
        if (wI == null || !wI.hasNewVer()) {
            z = false;
        }
        boolean z3 = com.baidu.tbadk.core.sharedPref.b.lk().getBoolean(bsB, false);
        if (z || (!z && !z3)) {
            com.baidu.tbadk.core.util.aw.h((View) this.Pe, com.baidu.tieba.u.icon_news_head_new);
            return;
        }
        this.Pe.setText(TbConfig.getVersion());
        this.Pe.setBackgroundDrawable(null);
        this.Pe.setTextAppearance(this.mContext, z2 ? com.baidu.tieba.z.setting_version_text_1 : com.baidu.tieba.z.setting_version_text);
    }
}
