package com.baidu.tieba.write.write;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.EditText;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    private final /* synthetic */ boolean cyA;
    final /* synthetic */ WriteActivity cyx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(WriteActivity writeActivity, boolean z) {
        this.cyx = writeActivity;
        this.cyA = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText editText;
        EditText editText2;
        com.baidu.tieba.tbadkCore.b.h hVar;
        super.onLoaded((bd) aVar, str, i);
        if (aVar != null && aVar.mz() != null && aVar.mD() != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.m411getInst().getResources(), aVar.mz(), aVar.mz().getNinePatchChunk(), aVar.mD(), null);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(com.baidu.tieba.tbadkCore.an.mAlpha);
            }
            editText = this.cyx.cwi;
            editText.setBackgroundDrawable(ninePatchDrawable);
            if (this.cyA) {
                WriteActivity writeActivity = this.cyx;
                editText2 = this.cyx.cwi;
                hVar = this.cyx.bMv;
                com.baidu.tieba.tbadkCore.b.a.a(writeActivity, editText2, true, hVar);
            }
        }
    }
}
