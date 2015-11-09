package com.baidu.tieba.pb.chosen.a;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e cgm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cgm = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cgm.cgg != null) {
            this.cgm.cgg.aeV();
        }
    }
}
