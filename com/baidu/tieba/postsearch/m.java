package com.baidu.tieba.postsearch;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ l dxN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.dxN = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dxN.abs();
    }
}
