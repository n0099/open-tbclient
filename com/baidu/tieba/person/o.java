package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.view.View;
import com.baidu.tieba.view.EditHeadImageView;
import com.slidingmenu.lib.R;
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
        int i;
        EditHeadImageView editHeadImageView;
        int i2;
        boolean a;
        int i3;
        String str = "tieba_head_image";
        i = this.a.i;
        if (i != 0) {
            str = "tieba_group_image";
        }
        editHeadImageView = this.a.g;
        i2 = this.a.i;
        Bitmap a2 = editHeadImageView.a(i2);
        if (a2 != null) {
            a = this.a.a(str, a2);
            if (a) {
                i3 = this.a.i;
                if (i3 == 0) {
                    this.a.d();
                    return;
                }
                com.baidu.tieba.im.model.ag agVar = new com.baidu.tieba.im.model.ag(com.baidu.tieba.util.ad.c("tieba_group_image"), 0, 0, 0, 0);
                agVar.a(new p(this));
                agVar.a();
                this.a.showLoadingDialog(this.a.getString(R.string.uploading));
            }
        }
    }
}
