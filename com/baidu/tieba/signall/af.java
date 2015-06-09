package com.baidu.tieba.signall;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ ae cjt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar) {
        this.cjt = aeVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SignAllForumActivity signAllForumActivity;
        signAllForumActivity = this.cjt.cjj;
        signAllForumActivity.finish();
    }
}
