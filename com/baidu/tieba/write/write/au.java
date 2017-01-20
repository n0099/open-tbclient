package com.baidu.tieba.write.write;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.EditText;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ WriteActivity fMl;
    private final /* synthetic */ boolean fMn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(WriteActivity writeActivity, boolean z) {
        this.fMl = writeActivity;
        this.fMn = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText boU;
        EditText boU2;
        a.InterfaceC0074a interfaceC0074a;
        super.onLoaded((au) aVar, str, i);
        if (aVar != null && aVar.jT() != null && aVar.jX() != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.m9getInst().getResources(), aVar.jT(), aVar.jT().getNinePatchChunk(), aVar.jX(), null);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
            }
            boU = this.fMl.boU();
            boU.setBackgroundDrawable(ninePatchDrawable);
            if (this.fMn) {
                WriteActivity writeActivity = this.fMl;
                boU2 = this.fMl.boU();
                interfaceC0074a = this.fMl.epC;
                com.baidu.tieba.tbadkCore.b.a.a(writeActivity, boU2, true, interfaceC0074a);
            }
        }
    }
}
