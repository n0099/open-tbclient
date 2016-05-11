package com.baidu.tieba.write.write;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.EditText;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ WriteActivity feb;
    private final /* synthetic */ boolean fef;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(WriteActivity writeActivity, boolean z) {
        this.feb = writeActivity;
        this.fef = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText bdN;
        EditText bdN2;
        a.InterfaceC0073a interfaceC0073a;
        super.a((ba) aVar, str, i);
        if (aVar != null && aVar.iY() != null && aVar.jc() != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.m11getInst().getResources(), aVar.iY(), aVar.iY().getNinePatchChunk(), aVar.jc(), null);
            if (TbadkCoreApplication.m11getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(com.baidu.tieba.tbadkCore.ad.mAlpha);
            }
            bdN = this.feb.bdN();
            bdN.setBackgroundDrawable(ninePatchDrawable);
            if (this.fef) {
                WriteActivity writeActivity = this.feb;
                bdN2 = this.feb.bdN();
                interfaceC0073a = this.feb.doS;
                com.baidu.tieba.tbadkCore.b.a.a(writeActivity, bdN2, true, interfaceC0073a);
            }
        }
    }
}
