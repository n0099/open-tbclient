package com.baidu.tieba.person;

import android.view.View;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ EditHeadActivity a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(EditHeadActivity editHeadActivity, String str, int i) {
        this.a = editHeadActivity;
        this.b = str;
        this.c = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        String str;
        progressBar = this.a.n;
        if (progressBar.getVisibility() != 0) {
            String str2 = this.b;
            str = this.a.A;
            if (!str2.equals(str)) {
                this.a.c(this.b);
                this.a.d(this.b);
                this.a.y = this.c;
            }
        }
    }
}
