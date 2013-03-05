package com.baidu.tieba.more;

import android.view.View;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ AboutActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AboutActivity aboutActivity) {
        this.a = aboutActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.i();
    }
}
