package com.baidu.tieba.write;

import android.widget.ImageView;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class af implements com.baidu.tieba.model.bc {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2679a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(WriteActivity writeActivity) {
        this.f2679a = writeActivity;
    }

    @Override // com.baidu.tieba.model.bc
    public void a(com.baidu.tieba.data.ah ahVar) {
        LinearLayout linearLayout;
        linearLayout = this.f2679a.D;
        ImageView imageView = (ImageView) linearLayout.findViewWithTag(ahVar.d);
        if (imageView != null) {
            imageView.setImageBitmap(ahVar.e);
        }
    }

    @Override // com.baidu.tieba.model.bc
    public void a(boolean z, String str) {
        if (!z) {
            this.f2679a.showToast(str);
        }
    }
}
