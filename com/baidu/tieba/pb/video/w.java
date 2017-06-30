package com.baidu.tieba.pb.video;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ l eKu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(l lVar) {
        this.eKu = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.eKu.jI(true);
    }
}
