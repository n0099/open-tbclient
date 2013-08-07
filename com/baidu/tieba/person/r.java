package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;
import com.baidu.tieba.view.EditHeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditHeadActivity f1612a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(EditHeadActivity editHeadActivity, String str, int i) {
        this.f1612a = editHeadActivity;
        this.b = str;
        this.c = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        EditHeadImageView editHeadImageView;
        Bitmap bitmap;
        progressBar = this.f1612a.n;
        if (progressBar.getVisibility() != 0) {
            editHeadImageView = this.f1612a.e;
            bitmap = this.f1612a.f;
            editHeadImageView.a(bitmap);
            this.f1612a.C = false;
            this.f1612a.d(this.b);
            this.f1612a.y = this.c;
        }
    }
}
