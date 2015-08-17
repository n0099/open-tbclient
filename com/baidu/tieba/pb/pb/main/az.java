package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* loaded from: classes.dex */
class az implements View.OnClickListener {
    final /* synthetic */ PbActivity cbo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(PbActivity pbActivity) {
        this.cbo = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        PbActivity pbActivity = this.cbo;
        str = this.cbo.arU;
        pbActivity.showToast(str);
    }
}
