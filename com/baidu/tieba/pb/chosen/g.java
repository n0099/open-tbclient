package com.baidu.tieba.pb.chosen;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ PbChosenActivity bYY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PbChosenActivity pbChosenActivity) {
        this.bYY = pbChosenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bYY.finish();
    }
}
