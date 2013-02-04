package com.baidu.tieba.more;

import android.widget.RadioGroup;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class s implements RadioGroup.OnCheckedChangeListener {
    final /* synthetic */ BrowseSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(BrowseSettingActivity browseSettingActivity) {
        this.a = browseSettingActivity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.image_quality_high /* 2131230838 */:
                TiebaApplication.a().m(true);
                TiebaApplication.a().f(1);
                return;
            case R.id.image_quality_low /* 2131230839 */:
                TiebaApplication.a().m(true);
                TiebaApplication.a().f(2);
                return;
            case R.id.image_quality_close /* 2131230840 */:
                TiebaApplication.a().m(false);
                return;
            default:
                return;
        }
    }
}
