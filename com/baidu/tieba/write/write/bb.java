package com.baidu.tieba.write.write;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.EditText;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ WriteActivity dYD;
    private final /* synthetic */ boolean dYF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(WriteActivity writeActivity, boolean z) {
        this.dYD = writeActivity;
        this.dYF = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText aMe;
        EditText aMe2;
        a.InterfaceC0080a interfaceC0080a;
        super.a((bb) aVar, str, i);
        if (aVar != null && aVar.mE() != null && aVar.mI() != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.m411getInst().getResources(), aVar.mE(), aVar.mE().getNinePatchChunk(), aVar.mI(), null);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(com.baidu.tieba.tbadkCore.ad.mAlpha);
            }
            aMe = this.dYD.aMe();
            aMe.setBackgroundDrawable(ninePatchDrawable);
            if (this.dYF) {
                WriteActivity writeActivity = this.dYD;
                aMe2 = this.dYD.aMe();
                interfaceC0080a = this.dYD.cJS;
                com.baidu.tieba.tbadkCore.b.a.a(writeActivity, aMe2, true, interfaceC0080a);
            }
        }
    }
}
