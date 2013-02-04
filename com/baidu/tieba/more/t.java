package com.baidu.tieba.more;

import android.widget.RadioGroup;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class t implements RadioGroup.OnCheckedChangeListener {
    final /* synthetic */ BrowseSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(BrowseSettingActivity browseSettingActivity) {
        this.a = browseSettingActivity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.font_size_big /* 2131230842 */:
                TiebaApplication.a().g(1);
                return;
            case R.id.font_size_mid /* 2131230843 */:
                TiebaApplication.a().g(2);
                return;
            case R.id.font_size_small /* 2131230844 */:
                TiebaApplication.a().g(3);
                return;
            default:
                return;
        }
    }
}
