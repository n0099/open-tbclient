package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* loaded from: classes.dex */
class s implements View.OnClickListener {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbActivity pbActivity) {
        this.dht = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        PbActivity pbActivity = this.dht;
        str = this.dht.avB;
        pbActivity.showToast(str);
    }
}
