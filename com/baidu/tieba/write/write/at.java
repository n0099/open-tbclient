package com.baidu.tieba.write.write;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.EditText;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ WriteActivity fSq;
    private final /* synthetic */ boolean fSs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(WriteActivity writeActivity, boolean z) {
        this.fSq = writeActivity;
        this.fSs = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText bpr;
        EditText bpr2;
        a.InterfaceC0072a interfaceC0072a;
        super.onLoaded((at) aVar, str, i);
        if (aVar != null && aVar.kR() != null && aVar.kV() != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.m9getInst().getResources(), aVar.kR(), aVar.kR().getNinePatchChunk(), aVar.kV(), null);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
            }
            bpr = this.fSq.bpr();
            bpr.setBackgroundDrawable(ninePatchDrawable);
            if (this.fSs) {
                WriteActivity writeActivity = this.fSq;
                bpr2 = this.fSq.bpr();
                interfaceC0072a = this.fSq.eqR;
                com.baidu.tieba.tbadkCore.b.a.a(writeActivity, bpr2, true, interfaceC0072a);
            }
        }
    }
}
