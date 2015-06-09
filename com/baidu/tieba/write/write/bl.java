package com.baidu.tieba.write.write;

import android.graphics.drawable.BitmapDrawable;
import android.text.style.ImageSpan;
/* loaded from: classes.dex */
class bl implements com.baidu.tbadk.imageManager.a {
    final /* synthetic */ WriteActivity cCQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(WriteActivity writeActivity) {
        this.cCQ = writeActivity;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public ImageSpan eI(String str) {
        com.baidu.adp.widget.a.a eA = com.baidu.tbadk.editortool.aa.zF().eA(str);
        if (eA == null) {
            eA = com.baidu.tbadk.editortool.aa.zF().al(null, str);
        }
        if (eA == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(eA.mS());
        int width = eA.getWidth();
        bitmapDrawable.setBounds(0, 0, width, width);
        bitmapDrawable.setGravity(119);
        return new ImageSpan(bitmapDrawable, 0);
    }
}
