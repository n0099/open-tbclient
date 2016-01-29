package com.baidu.tieba.pb.chosen.a;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e cIY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cIY = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cIY.cIT != null) {
            this.cIY.cIT.aos();
        }
    }
}
