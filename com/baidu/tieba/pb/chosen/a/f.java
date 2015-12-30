package com.baidu.tieba.pb.chosen.a;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e cCt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cCt = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cCt.cCo != null) {
            this.cCt.cCo.aku();
        }
    }
}
