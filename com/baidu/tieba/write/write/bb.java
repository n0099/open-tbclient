package com.baidu.tieba.write.write;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.EditText;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.c.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ WriteActivity dsa;
    private final /* synthetic */ boolean dsd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(WriteActivity writeActivity, boolean z) {
        this.dsa = writeActivity;
        this.dsd = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText aEm;
        EditText aEm2;
        a.InterfaceC0075a interfaceC0075a;
        super.a((bb) aVar, str, i);
        if (aVar != null && aVar.nb() != null && aVar.nf() != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.m411getInst().getResources(), aVar.nb(), aVar.nb().getNinePatchChunk(), aVar.nf(), null);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(com.baidu.tieba.tbadkCore.ac.mAlpha);
            }
            aEm = this.dsa.aEm();
            aEm.setBackgroundDrawable(ninePatchDrawable);
            if (this.dsd) {
                WriteActivity writeActivity = this.dsa;
                aEm2 = this.dsa.aEm();
                interfaceC0075a = this.dsa.cmS;
                com.baidu.tieba.tbadkCore.c.a.a(writeActivity, aEm2, true, interfaceC0075a);
            }
        }
    }
}
