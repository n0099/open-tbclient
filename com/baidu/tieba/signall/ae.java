package com.baidu.tieba.signall;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {
    final /* synthetic */ ad bSe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.bSe = adVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SignAllForumActivity signAllForumActivity;
        signAllForumActivity = this.bSe.bRU;
        signAllForumActivity.finish();
    }
}
