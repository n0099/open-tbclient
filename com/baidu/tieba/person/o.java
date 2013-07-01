package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tieba.view.EditHeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditHeadActivity f1368a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(EditHeadActivity editHeadActivity) {
        this.f1368a = editHeadActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditHeadImageView editHeadImageView;
        boolean a2;
        editHeadImageView = this.f1368a.e;
        a2 = this.f1368a.a("tieba_head_image", editHeadImageView.getHeadBitmap());
        if (a2) {
            this.f1368a.m();
        }
    }
}
