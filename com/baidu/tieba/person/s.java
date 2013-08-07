package com.baidu.tieba.person;

import android.view.View;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditHeadActivity f1613a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(EditHeadActivity editHeadActivity, String str, int i) {
        this.f1613a = editHeadActivity;
        this.b = str;
        this.c = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        String str;
        progressBar = this.f1613a.n;
        if (progressBar.getVisibility() != 0) {
            String str2 = this.b;
            str = this.f1613a.A;
            if (!str2.equals(str)) {
                this.f1613a.c(this.b);
                this.f1613a.d(this.b);
                this.f1613a.y = this.c;
            }
        }
    }
}
