package com.baidu.tieba.pb.sub;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ l bEM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar) {
        this.bEM = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        z = this.bEM.bEK;
        if (z) {
            this.bEM.ZC();
        } else {
            this.bEM.hC(null);
        }
    }
}
