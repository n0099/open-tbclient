package com.baidu.tieba.more;

import android.view.View;
/* loaded from: classes.dex */
class x implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BrowseSettingActivity f1465a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(BrowseSettingActivity browseSettingActivity) {
        this.f1465a = browseSettingActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1465a.finish();
    }
}
