package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PbActivity pbActivity) {
        this.ebT = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        PbActivity pbActivity = this.ebT;
        str = this.ebT.atf;
        pbActivity.showToast(str);
    }
}
