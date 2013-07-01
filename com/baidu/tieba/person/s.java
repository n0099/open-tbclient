package com.baidu.tieba.person;

import android.view.View;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditHeadActivity f1372a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(EditHeadActivity editHeadActivity, String str, int i) {
        this.f1372a = editHeadActivity;
        this.b = str;
        this.c = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        String str;
        progressBar = this.f1372a.n;
        if (progressBar.getVisibility() != 0) {
            String str2 = this.b;
            str = this.f1372a.A;
            if (!str2.equals(str)) {
                this.f1372a.c(this.b);
                this.f1372a.d(this.b);
                this.f1372a.y = this.c;
            }
        }
    }
}
