package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;
import com.baidu.tieba.view.EditHeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ int b;
    final /* synthetic */ EditHeadActivity c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(EditHeadActivity editHeadActivity, String str, int i) {
        this.c = editHeadActivity;
        this.a = str;
        this.b = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        EditHeadImageView editHeadImageView;
        Bitmap bitmap;
        progressBar = this.c.n;
        if (progressBar.getVisibility() != 0) {
            editHeadImageView = this.c.g;
            bitmap = this.c.h;
            editHeadImageView.a(bitmap);
            this.c.D = false;
            this.c.b(this.a);
            this.c.z = this.b;
        }
    }
}
