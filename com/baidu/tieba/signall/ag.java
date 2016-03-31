package com.baidu.tieba.signall;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    final /* synthetic */ af eho;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.eho = afVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SignAllForumActivity signAllForumActivity;
        signAllForumActivity = this.eho.ehe;
        signAllForumActivity.finish();
    }
}
