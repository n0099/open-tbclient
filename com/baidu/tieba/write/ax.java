package com.baidu.tieba.write;

import android.text.style.ImageSpan;
/* loaded from: classes.dex */
class ax implements com.baidu.tbadk.imageManager.a {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public ImageSpan a(String str) {
        com.baidu.adp.widget.a.a b = com.baidu.tbadk.editortool.aa.a().b(str);
        if (b == null) {
            b = com.baidu.tbadk.editortool.aa.a().a((String) null, str);
        }
        if (b == null) {
            return null;
        }
        com.baidu.tieba.view.v vVar = new com.baidu.tieba.view.v(b.h());
        vVar.setBounds(0, 0, b.c() + 1, b.d());
        vVar.setGravity(3);
        return new ImageSpan(vVar, 0);
    }
}
