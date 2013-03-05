package com.baidu.tieba.more;

import android.view.View;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ BrowseSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(BrowseSettingActivity browseSettingActivity) {
        this.a = browseSettingActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.finish();
    }
}
