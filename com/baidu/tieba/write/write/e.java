package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ AtListActivity fCf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AtListActivity atListActivity) {
        this.fCf = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.fCf.Ck.requestFocus();
    }
}
