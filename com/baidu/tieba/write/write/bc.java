package com.baidu.tieba.write.write;

import android.view.View;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements View.OnClickListener {
    final /* synthetic */ WriteActivity gfs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(WriteActivity writeActivity) {
        this.gfs = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        File file;
        File file2;
        file = this.gfs.gfc;
        if (file != null) {
            WriteActivity writeActivity = this.gfs;
            file2 = this.gfs.gfc;
            writeActivity.su(file2.getAbsolutePath());
        }
    }
}
