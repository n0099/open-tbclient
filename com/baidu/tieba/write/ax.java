package com.baidu.tieba.write;

import android.view.View;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements View.OnClickListener {
    final /* synthetic */ WriteImageActivity a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(WriteImageActivity writeImageActivity, String str, int i) {
        this.a = writeImageActivity;
        this.b = str;
        this.c = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        String str;
        progressBar = this.a.j;
        if (progressBar.getVisibility() != 0) {
            String str2 = this.b;
            str = this.a.w;
            if (!str2.equals(str)) {
                this.a.c(this.b);
                this.a.e(this.b);
                this.a.u = this.c;
            }
        }
    }
}
