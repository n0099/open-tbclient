package com.baidu.tieba.write.write;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.EditText;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ WriteActivity dRf;
    private final /* synthetic */ boolean dRh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(WriteActivity writeActivity, boolean z) {
        this.dRf = writeActivity;
        this.dRh = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText aJJ;
        EditText aJJ2;
        a.InterfaceC0084a interfaceC0084a;
        super.a((bb) aVar, str, i);
        if (aVar != null && aVar.ng() != null && aVar.nk() != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.m411getInst().getResources(), aVar.ng(), aVar.ng().getNinePatchChunk(), aVar.nk(), null);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(com.baidu.tieba.tbadkCore.ad.mAlpha);
            }
            aJJ = this.dRf.aJJ();
            aJJ.setBackgroundDrawable(ninePatchDrawable);
            if (this.dRh) {
                WriteActivity writeActivity = this.dRf;
                aJJ2 = this.dRf.aJJ();
                interfaceC0084a = this.dRf.cFT;
                com.baidu.tieba.tbadkCore.b.a.a(writeActivity, aJJ2, true, interfaceC0084a);
            }
        }
    }
}
