package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ WriteActivity dYD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(WriteActivity writeActivity) {
        this.dYD = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        WriteActivity writeActivity = this.dYD;
        str = this.dYD.auj;
        writeActivity.showToast(str);
    }
}
