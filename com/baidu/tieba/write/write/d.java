package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ AtListActivity fcq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AtListActivity atListActivity) {
        this.fcq = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.fcq.crz.getText().clear();
    }
}
