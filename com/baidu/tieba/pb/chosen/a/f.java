package com.baidu.tieba.pb.chosen.a;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e cav;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cav = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cav.cap != null) {
            this.cav.cap.acH();
        }
    }
}
