package com.baidu.tieba.pb.chosen;

import android.view.View;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ PbChosenActivity cfM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PbChosenActivity pbChosenActivity) {
        this.cfM = pbChosenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cfM.finish();
    }
}
