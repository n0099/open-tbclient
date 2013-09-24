package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.view.View;
import com.baidu.tieba.view.EditHeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditHeadActivity f1700a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(EditHeadActivity editHeadActivity) {
        this.f1700a = editHeadActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditHeadImageView editHeadImageView;
        boolean a2;
        editHeadImageView = this.f1700a.e;
        Bitmap headBitmap = editHeadImageView.getHeadBitmap();
        if (headBitmap == null) {
            return;
        }
        a2 = this.f1700a.a("tieba_head_image", headBitmap);
        if (a2) {
            this.f1700a.e();
        }
    }
}
