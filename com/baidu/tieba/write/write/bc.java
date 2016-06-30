package com.baidu.tieba.write.write;

import android.view.View;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements View.OnClickListener {
    final /* synthetic */ WriteActivity fJw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(WriteActivity writeActivity) {
        this.fJw = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        File file;
        File file2;
        file = this.fJw.fJg;
        if (file != null) {
            WriteActivity writeActivity = this.fJw;
            file2 = this.fJw.fJg;
            writeActivity.ra(file2.getAbsolutePath());
        }
    }
}
