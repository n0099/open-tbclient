package com.baidu.tieba.pb.sub;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ l bGw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar) {
        this.bGw = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        z = this.bGw.bGu;
        if (z) {
            this.bGw.aac();
        } else {
            this.bGw.hG(null);
        }
    }
}
