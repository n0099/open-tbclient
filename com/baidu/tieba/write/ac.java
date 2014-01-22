package com.baidu.tieba.write;

import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.model.bc;
/* loaded from: classes.dex */
class ac implements bc {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // com.baidu.tieba.model.bc
    public void a(com.baidu.tieba.data.ah ahVar) {
        LinearLayout linearLayout;
        linearLayout = this.a.B;
        ImageView imageView = (ImageView) linearLayout.findViewWithTag(ahVar.d);
        if (imageView != null) {
            imageView.setImageBitmap(ahVar.e);
        }
    }

    @Override // com.baidu.tieba.model.bc
    public void a(boolean z, String str) {
        if (!z) {
            this.a.showToast(str);
        }
    }
}
