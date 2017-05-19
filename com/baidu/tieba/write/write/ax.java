package com.baidu.tieba.write.write;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.EditText;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ WriteActivity fSV;
    private final /* synthetic */ boolean fSX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(WriteActivity writeActivity, boolean z) {
        this.fSV = writeActivity;
        this.fSX = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText bow;
        EditText bow2;
        a.InterfaceC0078a interfaceC0078a;
        super.onLoaded((ax) aVar, str, i);
        if (aVar != null && aVar.kR() != null && aVar.kV() != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.m9getInst().getResources(), aVar.kR(), aVar.kR().getNinePatchChunk(), aVar.kV(), null);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
            }
            bow = this.fSV.bow();
            bow.setBackgroundDrawable(ninePatchDrawable);
            if (this.fSX) {
                WriteActivity writeActivity = this.fSV;
                bow2 = this.fSV.bow();
                interfaceC0078a = this.fSV.eoS;
                com.baidu.tieba.tbadkCore.b.a.a(writeActivity, bow2, true, interfaceC0078a);
            }
        }
    }
}
