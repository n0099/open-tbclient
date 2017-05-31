package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ WriteActivity gaR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(WriteActivity writeActivity) {
        this.gaR = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        WriteActivity writeActivity = this.gaR;
        str = this.gaR.aAG;
        writeActivity.showToast(str);
    }
}
