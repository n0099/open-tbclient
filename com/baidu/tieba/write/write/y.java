package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ VcodeActivity fcV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(VcodeActivity vcodeActivity) {
        this.fcV = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.fcV.pp(null);
    }
}
