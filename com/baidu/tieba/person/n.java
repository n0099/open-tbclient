package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tieba.view.EditHeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ EditHeadActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(EditHeadActivity editHeadActivity) {
        this.a = editHeadActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditHeadImageView editHeadImageView;
        boolean a;
        editHeadImageView = this.a.g;
        a = this.a.a("tieba_head_image", editHeadImageView.getHeadBitmap());
        if (a) {
            this.a.l();
        }
    }
}
