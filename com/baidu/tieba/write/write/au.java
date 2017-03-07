package com.baidu.tieba.write.write;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.EditText;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ WriteActivity fQG;
    private final /* synthetic */ boolean fQI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(WriteActivity writeActivity, boolean z) {
        this.fQG = writeActivity;
        this.fQI = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText boI;
        EditText boI2;
        a.InterfaceC0073a interfaceC0073a;
        super.onLoaded((au) aVar, str, i);
        if (aVar != null && aVar.kN() != null && aVar.kR() != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.m9getInst().getResources(), aVar.kN(), aVar.kN().getNinePatchChunk(), aVar.kR(), null);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
            }
            boI = this.fQG.boI();
            boI.setBackgroundDrawable(ninePatchDrawable);
            if (this.fQI) {
                WriteActivity writeActivity = this.fQG;
                boI2 = this.fQG.boI();
                interfaceC0073a = this.fQG.esI;
                com.baidu.tieba.tbadkCore.b.a.a(writeActivity, boI2, true, interfaceC0073a);
            }
        }
    }
}
