package com.baidu.tieba.signall;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ SignAllForumAdvertActivity ejS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(SignAllForumAdvertActivity signAllForumAdvertActivity) {
        this.ejS = signAllForumAdvertActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ejS.finish();
    }
}
