package com.baidu.tieba.write;

import android.text.style.ImageSpan;
/* loaded from: classes.dex */
final class av implements com.baidu.tbadk.imageManager.a {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public final ImageSpan a(String str) {
        com.baidu.tbadk.editortool.ac.a();
        com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.editortool.ac.b(str);
        if (b == null) {
            b = com.baidu.tbadk.editortool.ac.a().a((String) null, str);
        }
        if (b == null) {
            return null;
        }
        com.baidu.tieba.view.u uVar = new com.baidu.tieba.view.u(b.h());
        uVar.setBounds(0, 0, b.c() + 1, b.d());
        uVar.setGravity(3);
        return new ImageSpan(uVar, 0);
    }
}
