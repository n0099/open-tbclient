package com.baidu.tieba.write;

import android.widget.ImageView;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class af implements com.baidu.tieba.model.bc {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // com.baidu.tieba.model.bc
    public void a(com.baidu.tieba.data.ag agVar) {
        LinearLayout linearLayout;
        linearLayout = this.a.D;
        ImageView imageView = (ImageView) linearLayout.findViewWithTag(agVar.d);
        if (imageView != null) {
            imageView.setImageBitmap(agVar.e);
        }
    }

    @Override // com.baidu.tieba.model.bc
    public void a(boolean z, String str) {
        if (!z) {
            this.a.showToast(str);
        }
    }
}
