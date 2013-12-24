package com.baidu.tieba.person;

import android.view.View;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ int b;
    final /* synthetic */ EditHeadActivity c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(EditHeadActivity editHeadActivity, String str, int i) {
        this.c = editHeadActivity;
        this.a = str;
        this.b = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        String str;
        progressBar = this.c.o;
        if (progressBar.getVisibility() != 0) {
            String str2 = this.a;
            str = this.c.C;
            if (!str2.equals(str)) {
                this.c.a(this.a);
                this.c.b(this.a);
                this.c.A = this.b;
            }
        }
    }
}
