package com.baidu.tieba.write.write;

import android.view.View;
/* loaded from: classes.dex */
class u implements View.OnClickListener {
    final /* synthetic */ VcodeActivity esx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(VcodeActivity vcodeActivity) {
        this.esx = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.esx.finish();
    }
}
