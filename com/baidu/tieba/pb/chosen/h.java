package com.baidu.tieba.pb.chosen;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ PbChosenActivity cfl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PbChosenActivity pbChosenActivity) {
        this.cfl = pbChosenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cfl.finish();
    }
}
