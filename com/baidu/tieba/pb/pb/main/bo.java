package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* loaded from: classes.dex */
class bo implements View.OnClickListener {
    final /* synthetic */ PbActivity cCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(PbActivity pbActivity) {
        this.cCm = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        PbActivity pbActivity = this.cCm;
        str = this.cCm.asF;
        pbActivity.showToast(str);
    }
}
