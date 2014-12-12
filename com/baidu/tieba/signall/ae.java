package com.baidu.tieba.signall;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {
    final /* synthetic */ ad bQt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.bQt = adVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SignAllForumActivity signAllForumActivity;
        signAllForumActivity = this.bQt.bQj;
        signAllForumActivity.finish();
    }
}
