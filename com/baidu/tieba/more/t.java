package com.baidu.tieba.more;

import android.widget.RadioGroup;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
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
            case R.id.image_quality_high /* 2131099828 */:
                TiebaApplication.d().o(true);
                TiebaApplication.d().f(1);
                return;
            case R.id.image_quality_low /* 2131099829 */:
                TiebaApplication.d().o(true);
                TiebaApplication.d().f(2);
                return;
            case R.id.image_quality_close /* 2131099830 */:
                TiebaApplication.d().o(false);
                return;
            default:
                return;
        }
    }
}
