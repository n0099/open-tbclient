package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PbActivity pbActivity) {
        this.eob = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        PbActivity pbActivity = this.eob;
        str = this.eob.awm;
        pbActivity.showToast(str);
    }
}
