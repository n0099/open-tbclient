package com.baidu.tieba.write.write;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.EditText;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ WriteActivity ets;
    private final /* synthetic */ boolean etu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(WriteActivity writeActivity, boolean z) {
        this.ets = writeActivity;
        this.etu = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText aUY;
        EditText aUY2;
        a.InterfaceC0084a interfaceC0084a;
        super.a((ay) aVar, str, i);
        if (aVar != null && aVar.mS() != null && aVar.mW() != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.m411getInst().getResources(), aVar.mS(), aVar.mS().getNinePatchChunk(), aVar.mW(), null);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(com.baidu.tieba.tbadkCore.ac.mAlpha);
            }
            aUY = this.ets.aUY();
            aUY.setBackgroundDrawable(ninePatchDrawable);
            if (this.etu) {
                WriteActivity writeActivity = this.ets;
                aUY2 = this.ets.aUY();
                interfaceC0084a = this.ets.cRX;
                com.baidu.tieba.tbadkCore.b.a.a(writeActivity, aUY2, true, interfaceC0084a);
            }
        }
    }
}
