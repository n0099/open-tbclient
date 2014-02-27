package com.baidu.tieba.write;

import android.text.style.ImageSpan;
/* loaded from: classes.dex */
final class ay implements com.baidu.tbadk.imageManager.a {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public final ImageSpan a(String str) {
        com.baidu.tieba.data.emotions.l.a();
        com.baidu.adp.widget.ImageView.b b = com.baidu.tieba.data.emotions.l.b(str);
        if (b == null) {
            b = com.baidu.tieba.data.emotions.l.a().a((String) null, str);
        }
        if (b == null) {
            return null;
        }
        com.baidu.tieba.view.bu buVar = new com.baidu.tieba.view.bu(b.h());
        buVar.setBounds(0, 0, b.c() + 1, b.d());
        buVar.setGravity(3);
        return new ImageSpan(buVar, 0);
    }
}
