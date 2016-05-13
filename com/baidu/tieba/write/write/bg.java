package com.baidu.tieba.write.write;

import android.view.View;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements View.OnClickListener {
    final /* synthetic */ WriteActivity fea;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(WriteActivity writeActivity) {
        this.fea = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        File file;
        File file2;
        file = this.fea.fdM;
        if (file != null) {
            WriteActivity writeActivity = this.fea;
            file2 = this.fea.fdM;
            writeActivity.pq(file2.getAbsolutePath());
        }
    }
}
