package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.view.View;
import com.baidu.tieba.im.chat.LocalViewSize;
import com.baidu.tieba.view.EditHeadImageView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r implements View.OnClickListener {
    final /* synthetic */ EditHeadActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(EditHeadActivity editHeadActivity) {
        this.a = editHeadActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
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
        if (a2 == null) {
            return;
        }
        a = this.a.a(str, a2);
        if (a) {
            i3 = this.a.i;
            if (i3 == 0) {
                EditHeadActivity.o(this.a);
                return;
            }
            com.baidu.tieba.img.a<?> aVar = new com.baidu.tieba.img.a<>(com.baidu.tieba.util.af.c("tieba_group_image"), "head");
            LocalViewSize.a().a(aVar);
            aVar.a(new s(this));
            aVar.a();
            this.a.showLoadingDialog(this.a.getString(R.string.uploading));
        }
    }
}
