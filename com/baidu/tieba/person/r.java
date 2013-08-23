package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;
import com.baidu.tieba.view.EditHeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditHeadActivity f1658a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(EditHeadActivity editHeadActivity, String str, int i) {
        this.f1658a = editHeadActivity;
        this.b = str;
        this.c = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        EditHeadImageView editHeadImageView;
        Bitmap bitmap;
        progressBar = this.f1658a.n;
        if (progressBar.getVisibility() != 0) {
            editHeadImageView = this.f1658a.e;
            bitmap = this.f1658a.f;
            editHeadImageView.a(bitmap);
            this.f1658a.C = false;
            this.f1658a.d(this.b);
            this.f1658a.y = this.c;
        }
    }
}
