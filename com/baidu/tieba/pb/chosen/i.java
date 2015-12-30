package com.baidu.tieba.pb.chosen;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ PbChosenActivity cBV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PbChosenActivity pbChosenActivity) {
        this.cBV = pbChosenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cBV.finish();
    }
}
