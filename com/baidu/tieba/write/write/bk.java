package com.baidu.tieba.write.write;

import android.graphics.drawable.BitmapDrawable;
import android.text.style.ImageSpan;
/* loaded from: classes.dex */
class bk implements com.baidu.tbadk.imageManager.a {
    final /* synthetic */ WriteActivity cyc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(WriteActivity writeActivity) {
        this.cyc = writeActivity;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public ImageSpan eo(String str) {
        com.baidu.adp.widget.a.a eg = com.baidu.tbadk.editortool.aa.yL().eg(str);
        if (eg == null) {
            eg = com.baidu.tbadk.editortool.aa.yL().ag(null, str);
        }
        if (eg == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(eg.mz());
        int width = eg.getWidth();
        bitmapDrawable.setBounds(0, 0, width, width);
        bitmapDrawable.setGravity(119);
        return new ImageSpan(bitmapDrawable, 0);
    }
}
