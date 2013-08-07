package com.baidu.tieba.write;

import android.view.View;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteImageActivity f1891a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(WriteImageActivity writeImageActivity, String str, int i) {
        this.f1891a = writeImageActivity;
        this.b = str;
        this.c = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        String str;
        progressBar = this.f1891a.j;
        if (progressBar.getVisibility() != 0) {
            String str2 = this.b;
            str = this.f1891a.w;
            if (!str2.equals(str)) {
                this.f1891a.c(this.b);
                this.f1891a.e(this.b);
                this.f1891a.u = this.c;
            }
        }
    }
}
