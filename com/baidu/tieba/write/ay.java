package com.baidu.tieba.write;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.EditText;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ WriteActivity cgS;
    private final /* synthetic */ boolean cgV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(WriteActivity writeActivity, boolean z) {
        this.cgS = writeActivity;
        this.cgV = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText editText;
        EditText editText2;
        com.baidu.tieba.tbadkCore.bubble.y yVar;
        super.onLoaded((ay) aVar, str, i);
        if (aVar != null && aVar.jj() != null && aVar.jn() != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.m255getInst().getResources(), aVar.jj(), aVar.jj().getNinePatchChunk(), aVar.jn(), null);
            if (TbadkCoreApplication.m255getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(com.baidu.tieba.tbadkCore.ak.mAlpha);
            }
            editText = this.cgS.bPK;
            editText.setBackgroundDrawable(ninePatchDrawable);
            if (this.cgV) {
                WriteActivity writeActivity = this.cgS;
                editText2 = this.cgS.bPK;
                yVar = this.cgS.aGh;
                com.baidu.tieba.tbadkCore.bubble.m.a(writeActivity, editText2, true, yVar);
            }
        }
    }
}
