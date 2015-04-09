package com.baidu.tieba.write.write;

import android.graphics.drawable.BitmapDrawable;
import android.text.style.ImageSpan;
/* loaded from: classes.dex */
class bk implements com.baidu.tbadk.imageManager.a {
    final /* synthetic */ WriteActivity cyx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(WriteActivity writeActivity) {
        this.cyx = writeActivity;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public ImageSpan er(String str) {
        com.baidu.adp.widget.a.a ej = com.baidu.tbadk.editortool.aa.yR().ej(str);
        if (ej == null) {
            ej = com.baidu.tbadk.editortool.aa.yR().ag(null, str);
        }
        if (ej == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(ej.mz());
        int width = ej.getWidth();
        bitmapDrawable.setBounds(0, 0, width, width);
        bitmapDrawable.setGravity(119);
        return new ImageSpan(bitmapDrawable, 0);
    }
}
