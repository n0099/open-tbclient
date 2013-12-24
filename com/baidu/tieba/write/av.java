package com.baidu.tieba.write;

import android.view.View;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ int b;
    final /* synthetic */ WriteImageActivity c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(WriteImageActivity writeImageActivity, String str, int i) {
        this.c = writeImageActivity;
        this.a = str;
        this.b = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        String str;
        progressBar = this.c.g;
        if (progressBar.getVisibility() != 0) {
            String str2 = this.a;
            str = this.c.v;
            if (!str2.equals(str)) {
                this.c.a(this.a);
                this.c.c(this.a);
                this.c.s = this.b;
            }
        }
    }
}
