package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.view.View;
import com.baidu.tieba.view.EditHeadImageView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditHeadActivity f2360a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(EditHeadActivity editHeadActivity) {
        this.f2360a = editHeadActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        EditHeadImageView editHeadImageView;
        int i2;
        int i3;
        boolean a2;
        String str = "tieba_head_image";
        i = this.f2360a.i;
        if (i != 0) {
            str = "tieba_group_image";
        }
        editHeadImageView = this.f2360a.g;
        i2 = this.f2360a.i;
        Bitmap a3 = editHeadImageView.a(i2);
        if (a3 != null) {
            a2 = this.f2360a.a(str, a3);
            if (!a2) {
                return;
            }
        }
        i3 = this.f2360a.i;
        if (i3 == 0) {
            this.f2360a.d();
            return;
        }
        com.baidu.tieba.im.model.t tVar = new com.baidu.tieba.im.model.t(com.baidu.tieba.util.x.c("tieba_group_image"), 0, 0, 0, 0);
        tVar.a(new p(this));
        tVar.a();
        this.f2360a.showLoadingDialog(this.f2360a.getString(R.string.uploading));
    }
}
