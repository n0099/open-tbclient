package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* loaded from: classes.dex */
class az implements View.OnClickListener {
    final /* synthetic */ PbActivity ciz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(PbActivity pbActivity) {
        this.ciz = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        PbActivity pbActivity = this.ciz;
        str = this.ciz.asb;
        pbActivity.showToast(str);
    }
}
