package com.baidu.tieba.write.write;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.EditText;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ WriteActivity cCQ;
    private final /* synthetic */ boolean cCT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(WriteActivity writeActivity, boolean z) {
        this.cCQ = writeActivity;
        this.cCT = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText editText;
        EditText editText2;
        com.baidu.tieba.tbadkCore.c.h hVar;
        super.a((be) aVar, str, i);
        if (aVar != null && aVar.mS() != null && aVar.mW() != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.m411getInst().getResources(), aVar.mS(), aVar.mS().getNinePatchChunk(), aVar.mW(), null);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(com.baidu.tieba.tbadkCore.an.mAlpha);
            }
            editText = this.cCQ.cAz;
            editText.setBackgroundDrawable(ninePatchDrawable);
            if (this.cCT) {
                WriteActivity writeActivity = this.cCQ;
                editText2 = this.cCQ.cAz;
                hVar = this.cCQ.bOA;
                com.baidu.tieba.tbadkCore.c.a.a(writeActivity, editText2, true, hVar);
            }
        }
    }
}
