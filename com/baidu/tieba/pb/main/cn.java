package com.baidu.tieba.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cn implements View.OnFocusChangeListener {
    final /* synthetic */ bt a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(bt btVar) {
        this.a = btVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        PbActivity pbActivity;
        if (!z) {
            pbActivity = this.a.k;
            com.baidu.adp.lib.util.j.a(pbActivity, view);
        }
    }
}
