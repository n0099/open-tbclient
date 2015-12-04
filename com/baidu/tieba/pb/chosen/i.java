package com.baidu.tieba.pb.chosen;

import android.view.View;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ PbChosenActivity cyo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PbChosenActivity pbChosenActivity) {
        this.cyo = pbChosenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cyo.finish();
    }
}
