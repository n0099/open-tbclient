package com.baidu.tieba.signall;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ z cQZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.cQZ = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SignAllForumActivity signAllForumActivity;
        signAllForumActivity = this.cQZ.cQP;
        signAllForumActivity.finish();
    }
}
