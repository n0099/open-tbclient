package com.baidu.tieba.write;

import android.view.View;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bl implements View.OnClickListener {
    final /* synthetic */ WriteImageActivity a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(WriteImageActivity writeImageActivity, String str, int i) {
        this.a = writeImageActivity;
        this.b = str;
        this.c = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ProgressBar progressBar;
        String str;
        progressBar = this.a.g;
        if (progressBar.getVisibility() != 0) {
            String str2 = this.b;
            str = this.a.v;
            if (!str2.equals(str)) {
                WriteImageActivity.b(this.a, this.b);
                this.a.b(this.b);
                this.a.s = this.c;
            }
        }
    }
}
