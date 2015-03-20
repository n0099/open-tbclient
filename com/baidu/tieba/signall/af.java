package com.baidu.tieba.signall;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ ae ceZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar) {
        this.ceZ = aeVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SignAllForumActivity signAllForumActivity;
        signAllForumActivity = this.ceZ.ceP;
        signAllForumActivity.finish();
    }
}
