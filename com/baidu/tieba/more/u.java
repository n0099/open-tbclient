package com.baidu.tieba.more;

import android.widget.RadioGroup;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements RadioGroup.OnCheckedChangeListener {
    final /* synthetic */ BrowseSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(BrowseSettingActivity browseSettingActivity) {
        this.a = browseSettingActivity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.font_size_big /* 2131230861 */:
                TiebaApplication.b().g(1);
                return;
            case R.id.font_size_mid /* 2131230862 */:
                TiebaApplication.b().g(2);
                return;
            case R.id.font_size_small /* 2131230863 */:
                TiebaApplication.b().g(3);
                return;
            default:
                return;
        }
    }
}
