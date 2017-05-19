package com.baidu.tieba.write.write;

import android.view.View;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements View.OnClickListener {
    final /* synthetic */ WriteActivity fSV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(WriteActivity writeActivity) {
        this.fSV = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        File file;
        File file2;
        file = this.fSV.fSu;
        if (file != null) {
            WriteActivity writeActivity = this.fSV;
            file2 = this.fSV.fSu;
            writeActivity.rk(file2.getAbsolutePath());
        }
    }
}
