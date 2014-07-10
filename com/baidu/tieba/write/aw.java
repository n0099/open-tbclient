package com.baidu.tieba.write;

import android.text.style.ImageSpan;
/* loaded from: classes.dex */
class aw implements com.baidu.tbadk.imageManager.a {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public ImageSpan a(String str) {
        com.baidu.adp.widget.a.a b = com.baidu.tbadk.editortool.ab.a().b(str);
        if (b == null) {
            b = com.baidu.tbadk.editortool.ab.a().a((String) null, str);
        }
        if (b == null) {
            return null;
        }
        com.baidu.tieba.view.x xVar = new com.baidu.tieba.view.x(b.h());
        xVar.setBounds(0, 0, b.c() + 1, b.d());
        xVar.setGravity(3);
        return new ImageSpan(xVar, 0);
    }
}
