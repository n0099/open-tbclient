package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.view.View;
import com.baidu.tieba.view.EditHeadImageView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditHeadActivity f2221a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(EditHeadActivity editHeadActivity) {
        this.f2221a = editHeadActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        EditHeadImageView editHeadImageView;
        int i2;
        int i3;
        boolean a2;
        String str = "tieba_head_image";
        i = this.f2221a.k;
        if (i != 0) {
            str = "tieba_group_image";
        }
        editHeadImageView = this.f2221a.g;
        i2 = this.f2221a.k;
        Bitmap a3 = editHeadImageView.a(i2);
        if (a3 != null) {
            a2 = this.f2221a.a(str, a3);
            if (!a2) {
                return;
            }
        }
        i3 = this.f2221a.k;
        if (i3 == 0) {
            this.f2221a.e();
            return;
        }
        com.baidu.tieba.im.model.r rVar = new com.baidu.tieba.im.model.r(com.baidu.tieba.util.w.c("tieba_group_image"), 0, 0, 0, 0);
        rVar.a(new p(this));
        rVar.a();
        this.f2221a.b(this.f2221a.getString(R.string.uploading));
    }
}
