package com.baidu.tieba.write;

import android.text.style.ImageSpan;
/* loaded from: classes.dex */
class bf implements com.baidu.tbadk.imageManager.a {
    final /* synthetic */ WriteActivity cft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(WriteActivity writeActivity) {
        this.cft = writeActivity;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public ImageSpan ek(String str) {
        com.baidu.adp.widget.a.a ec = com.baidu.tbadk.editortool.ab.vc().ec(str);
        if (ec == null) {
            ec = com.baidu.tbadk.editortool.ab.vc().ae(null, str);
        }
        if (ec == null) {
            return null;
        }
        com.baidu.tieba.view.l lVar = new com.baidu.tieba.view.l(ec.ji());
        lVar.setBounds(0, 0, ec.getWidth() + 1, ec.getHeight());
        lVar.setGravity(3);
        return new ImageSpan(lVar, 0);
    }
}
