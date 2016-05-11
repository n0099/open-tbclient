package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PbActivity pbActivity) {
        this.djE = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        PbActivity pbActivity = this.djE;
        str = this.djE.arA;
        pbActivity.showToast(str);
    }
}
