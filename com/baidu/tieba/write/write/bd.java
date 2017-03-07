package com.baidu.tieba.write.write;

import android.view.View;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements View.OnClickListener {
    final /* synthetic */ WriteActivity fQG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(WriteActivity writeActivity) {
        this.fQG = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        File file;
        File file2;
        file = this.fQG.fQh;
        if (file != null) {
            WriteActivity writeActivity = this.fQG;
            file2 = this.fQG.fQh;
            writeActivity.qU(file2.getAbsolutePath());
        }
    }
}
