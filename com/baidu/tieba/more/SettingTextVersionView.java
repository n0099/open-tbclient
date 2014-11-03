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
    public static String bsP = "has_shown_funtion_intro";

    public SettingTextVersionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void refresh() {
        boolean z = true;
        boolean z2 = TbadkApplication.m251getInst().getSkinType() == 1;
        VersionData wK = com.baidu.tieba.aj.wm().wK();
        if (wK == null || !wK.hasNewVer()) {
            z = false;
        }
        boolean z3 = com.baidu.tbadk.core.sharedPref.b.lk().getBoolean(bsP, false);
        if (z || (!z && !z3)) {
            com.baidu.tbadk.core.util.aw.h((View) this.Pi, com.baidu.tieba.u.icon_news_head_new);
            return;
        }
        this.Pi.setText(TbConfig.getVersion());
        this.Pi.setBackgroundDrawable(null);
        this.Pi.setTextAppearance(this.mContext, z2 ? com.baidu.tieba.z.setting_version_text_1 : com.baidu.tieba.z.setting_version_text);
    }
}
