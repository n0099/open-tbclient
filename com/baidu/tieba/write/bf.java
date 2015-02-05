package com.baidu.tieba.write;

import android.graphics.drawable.BitmapDrawable;
import android.text.style.ImageSpan;
/* loaded from: classes.dex */
class bf implements com.baidu.tbadk.imageManager.a {
    final /* synthetic */ WriteActivity cgR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(WriteActivity writeActivity) {
        this.cgR = writeActivity;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public ImageSpan eh(String str) {
        com.baidu.adp.widget.a.a dZ = com.baidu.tbadk.editortool.ab.vn().dZ(str);
        if (dZ == null) {
            dZ = com.baidu.tbadk.editortool.ab.vn().ah(null, str);
        }
        if (dZ == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(dZ.jc());
        int width = dZ.getWidth();
        bitmapDrawable.setBounds(0, 0, width + 1, width);
        bitmapDrawable.setGravity(119);
        return new ImageSpan(bitmapDrawable, 0);
    }
}
