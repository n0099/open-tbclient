package com.baidu.tieba.more;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.data.VersionData;
/* loaded from: classes.dex */
public final class SettingTextTestNewView extends TbSettingTextTipView {
    public SettingTextTestNewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void e() {
        String c;
        boolean z = false;
        boolean z2 = TbadkApplication.j().l() == 1;
        VersionData y = com.baidu.tieba.p.c().y();
        if (y != null && y.getHas_new_ver() == 1) {
            z = true;
        }
        if (z) {
            this.d.setText("New");
            this.d.setTextAppearance(this.a, z2 ? com.baidu.tieba.a.l.setting_version_prompt_text_1 : com.baidu.tieba.a.l.setting_version_prompt_text);
            this.d.setBackgroundResource(z2 ? com.baidu.tieba.a.g.icon_news_text_prompt_1 : com.baidu.tieba.a.g.icon_news_text_prompt);
            return;
        }
        this.d.setText((com.baidu.tbadk.core.data.n.e() != 1 || bc.c(com.baidu.tbadk.core.data.n.d())) ? com.baidu.tbadk.core.data.n.c() : String.valueOf(c) + "." + com.baidu.tbadk.core.data.n.d());
        this.d.setBackgroundDrawable(null);
        this.d.setTextAppearance(this.a, z2 ? com.baidu.tieba.a.l.setting_version_text_1 : com.baidu.tieba.a.l.setting_version_text);
    }
}
