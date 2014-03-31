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
        com.baidu.tbadk.editortool.ab.a();
        com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.editortool.ab.b(str);
        if (b == null) {
            b = com.baidu.tbadk.editortool.ab.a().a((String) null, str);
        }
        if (b == null) {
            return null;
        }
        com.baidu.tieba.view.w wVar = new com.baidu.tieba.view.w(b.h());
        wVar.setBounds(0, 0, b.c() + 1, b.d());
        wVar.setGravity(3);
        return new ImageSpan(wVar, 0);
    }
}
