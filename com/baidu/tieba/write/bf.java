package com.baidu.tieba.write;

import android.text.style.ImageSpan;
/* loaded from: classes.dex */
class bf implements com.baidu.tbadk.imageManager.a {
    final /* synthetic */ WriteActivity bTX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(WriteActivity writeActivity) {
        this.bTX = writeActivity;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public ImageSpan dq(String str) {
        com.baidu.adp.widget.a.a dg = com.baidu.tbadk.editortool.aa.rz().dg(str);
        if (dg == null) {
            dg = com.baidu.tbadk.editortool.aa.rz().T(null, str);
        }
        if (dg == null) {
            return null;
        }
        com.baidu.tieba.view.v vVar = new com.baidu.tieba.view.v(dg.hl());
        vVar.setBounds(0, 0, dg.getWidth() + 1, dg.getHeight());
        vVar.setGravity(3);
        return new ImageSpan(vVar, 0);
    }
}
