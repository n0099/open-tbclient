package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ AtListActivity fTK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AtListActivity atListActivity) {
        this.fTK = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.fTK.cZK.getText().clear();
    }
}
