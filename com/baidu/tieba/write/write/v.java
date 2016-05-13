package com.baidu.tieba.write.write;

import android.view.View;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ VcodeActivity fcU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(VcodeActivity vcodeActivity) {
        this.fcU = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.fcU.finish();
    }
}
