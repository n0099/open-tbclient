package com.baidu.tieba.write;

import android.graphics.drawable.BitmapDrawable;
import android.text.style.ImageSpan;
/* loaded from: classes.dex */
class bf implements com.baidu.tbadk.imageManager.a {
    final /* synthetic */ WriteActivity cgS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(WriteActivity writeActivity) {
        this.cgS = writeActivity;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public ImageSpan ek(String str) {
        com.baidu.adp.widget.a.a ec = com.baidu.tbadk.editortool.ab.vt().ec(str);
        if (ec == null) {
            ec = com.baidu.tbadk.editortool.ab.vt().ah(null, str);
        }
        if (ec == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(ec.jj());
        int width = ec.getWidth();
        bitmapDrawable.setBounds(0, 0, width + 1, width);
        bitmapDrawable.setGravity(119);
        return new ImageSpan(bitmapDrawable, 0);
    }
}
