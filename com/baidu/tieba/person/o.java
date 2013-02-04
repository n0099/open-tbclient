package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;
import com.baidu.tieba.view.EditHeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ EditHeadActivity a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(EditHeadActivity editHeadActivity, String str, int i) {
        this.a = editHeadActivity;
        this.b = str;
        this.c = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        EditHeadImageView editHeadImageView;
        Bitmap bitmap;
        progressBar = this.a.m;
        if (progressBar.getVisibility() == 0) {
            return;
        }
        editHeadImageView = this.a.f;
        bitmap = this.a.g;
        editHeadImageView.a(bitmap);
        this.a.B = false;
        this.a.d(this.b);
        this.a.x = this.c;
    }
}
