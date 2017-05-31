package com.baidu.tieba.pb.video;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ l eAW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(l lVar) {
        this.eAW = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.eAW.jk(true);
    }
}
