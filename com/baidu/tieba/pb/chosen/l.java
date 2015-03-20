package com.baidu.tieba.pb.chosen;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ PbChosenActivity bFY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PbChosenActivity pbChosenActivity) {
        this.bFY = pbChosenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bFY.finish();
    }
}
