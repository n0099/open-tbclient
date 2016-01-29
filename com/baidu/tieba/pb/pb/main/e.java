package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PbActivity pbActivity) {
        this.cNq = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        PbActivity pbActivity = this.cNq;
        str = this.cNq.avb;
        pbActivity.showToast(str);
    }
}
