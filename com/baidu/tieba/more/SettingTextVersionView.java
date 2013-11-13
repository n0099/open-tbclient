package com.baidu.tieba.more;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.VersionData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class SettingTextVersionView extends SettingTextTipView {

    /* renamed from: a  reason: collision with root package name */
    public static String f1965a = "has_shown_funtion_intro";

    public SettingTextVersionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a() {
        boolean z = true;
        boolean z2 = TiebaApplication.g().ap() == 1;
        VersionData au = TiebaApplication.g().au();
        if (au == null || au.getHas_new_ver() != 1) {
            z = false;
        }
        boolean a2 = com.baidu.tieba.sharedPref.b.a().a(f1965a, false);
        if (z || (!z && !a2)) {
            this.e.setText("New");
            this.e.setTextAppearance(this.b, z2 ? R.style.setting_version_prompt_text_1 : R.style.setting_version_prompt_text);
            this.e.setBackgroundResource(z2 ? R.drawable.icon_news_text_prompt_1 : R.drawable.icon_news_text_prompt);
            return;
        }
        this.e.setText(com.baidu.tieba.data.h.j());
        this.e.setBackgroundDrawable(null);
        this.e.setTextAppearance(this.b, z2 ? R.style.setting_version_text_1 : R.style.setting_version_text);
    }
}
