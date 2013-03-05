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
            case R.id.image_quality_high /* 2131230862 */:
                TiebaApplication.b().n(true);
                TiebaApplication.b().f(1);
                return;
            case R.id.image_quality_low /* 2131230863 */:
                TiebaApplication.b().n(true);
                TiebaApplication.b().f(2);
                return;
            case R.id.image_quality_close /* 2131230864 */:
                TiebaApplication.b().n(false);
                return;
            default:
                return;
        }
    }
}
