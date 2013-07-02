package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tieba.view.EditHeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ EditHeadActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(EditHeadActivity editHeadActivity) {
        this.a = editHeadActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditHeadImageView editHeadImageView;
        boolean a;
        editHeadImageView = this.a.e;
        a = this.a.a("tieba_head_image", editHeadImageView.getHeadBitmap());
        if (a) {
            this.a.m();
        }
    }
}
