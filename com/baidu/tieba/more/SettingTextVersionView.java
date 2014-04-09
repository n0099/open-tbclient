package com.baidu.tieba.more;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.data.VersionData;
/* loaded from: classes.dex */
public final class SettingTextVersionView extends TbSettingTextTipView {
    public static String f = "has_shown_funtion_intro";

    public SettingTextVersionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void e() {
        boolean z = true;
        boolean z2 = TbadkApplication.j().l() == 1;
        VersionData y = com.baidu.tieba.p.c().y();
        if (y == null || y.getHas_new_ver() != 1) {
            z = false;
        }
        boolean a = com.baidu.tbadk.core.sharedPref.b.a().a(f, false);
        if (z || !a) {
            this.d.setBackgroundResource(z2 ? com.baidu.tieba.a.g.icon_news_head_new_1 : com.baidu.tieba.a.g.icon_news_head_new);
            return;
        }
        this.d.setText(com.baidu.tbadk.core.data.n.c());
        this.d.setBackgroundDrawable(null);
        this.d.setTextAppearance(this.a, z2 ? com.baidu.tieba.a.l.setting_version_text_1 : com.baidu.tieba.a.l.setting_version_text);
    }
}
