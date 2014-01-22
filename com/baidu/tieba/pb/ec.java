package com.baidu.tieba.pb;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ec implements View.OnClickListener {
    final /* synthetic */ eb a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ec(eb ebVar) {
        this.a = ebVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.q();
    }
}
