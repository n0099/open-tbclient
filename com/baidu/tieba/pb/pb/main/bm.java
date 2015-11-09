package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* loaded from: classes.dex */
class bm implements View.OnClickListener {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(PbActivity pbActivity) {
        this.cjN = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        PbActivity pbActivity = this.cjN;
        str = this.cjN.aqB;
        pbActivity.showToast(str);
    }
}
