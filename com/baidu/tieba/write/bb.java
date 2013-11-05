package com.baidu.tieba.write;

import android.view.View;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2650a;
    final /* synthetic */ int b;
    final /* synthetic */ WriteImageActivity c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(WriteImageActivity writeImageActivity, String str, int i) {
        this.c = writeImageActivity;
        this.f2650a = str;
        this.b = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        String str;
        progressBar = this.c.j;
        if (progressBar.getVisibility() != 0) {
            String str2 = this.f2650a;
            str = this.c.x;
            if (!str2.equals(str)) {
                this.c.c(this.f2650a);
                this.c.e(this.f2650a);
                this.c.u = this.b;
            }
        }
    }
}
