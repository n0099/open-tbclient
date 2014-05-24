package com.baidu.tieba.more;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.data.VersionData;
/* loaded from: classes.dex */
public final class SettingTextVersionView extends TbSettingTextTipView {
    public static String f = "has_shown_funtion_intro";

    public SettingTextVersionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a() {
        boolean z = true;
        boolean z2 = TbadkApplication.m252getInst().getSkinType() == 1;
        VersionData B = com.baidu.tieba.ai.c().B();
        if (B == null || !B.hasNewVer()) {
            z = false;
        }
        boolean a = com.baidu.tbadk.core.sharedPref.b.a().a(f, false);
        if (z || (!z && !a)) {
            this.d.setBackgroundResource(z2 ? com.baidu.tieba.u.icon_news_head_new_1 : com.baidu.tieba.u.icon_news_head_new);
            return;
        }
        this.d.setText(TbConfig.getVersion());
        this.d.setBackgroundDrawable(null);
        this.d.setTextAppearance(this.a, z2 ? com.baidu.tieba.z.setting_version_text_1 : com.baidu.tieba.z.setting_version_text);
    }
}
