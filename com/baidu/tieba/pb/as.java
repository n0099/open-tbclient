package com.baidu.tieba.pb;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.s();
    }
}
