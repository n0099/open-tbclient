package com.baidu.tieba.more;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.VersionData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class SettingTextVersionView extends SettingTextTipView {
    public static String a = "has_shown_funtion_intro";

    public SettingTextVersionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a() {
        boolean z = true;
        boolean z2 = TiebaApplication.g().al() == 1;
        VersionData as = TiebaApplication.g().as();
        if (as == null || as.getHas_new_ver() != 1) {
            z = false;
        }
        boolean a2 = com.baidu.tieba.sharedPref.b.a().a(a, false);
        if (z || (!z && !a2)) {
            this.e.setBackgroundResource(z2 ? R.drawable.icon_news_head_new_1 : R.drawable.icon_news_head_new);
            return;
        }
        this.e.setText(com.baidu.tieba.data.i.u());
        this.e.setBackgroundDrawable(null);
        this.e.setTextAppearance(this.b, z2 ? R.style.setting_version_text_1 : R.style.setting_version_text);
    }
}
