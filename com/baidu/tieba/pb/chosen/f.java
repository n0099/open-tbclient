package com.baidu.tieba.pb.chosen;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ PbChosenActivity bJa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PbChosenActivity pbChosenActivity) {
        this.bJa = pbChosenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bJa.finish();
    }
}
