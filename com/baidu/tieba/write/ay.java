package com.baidu.tieba.write;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.EditText;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ WriteActivity bUm;
    private final /* synthetic */ boolean bUp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(WriteActivity writeActivity, boolean z) {
        this.bUm = writeActivity;
        this.bUp = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText editText;
        EditText editText2;
        com.baidu.tieba.bubble.t tVar;
        super.a((ay) aVar, str, i);
        if (aVar != null && aVar.hl() != null && aVar.hp() != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkApplication.m251getInst().getResources(), aVar.hl(), aVar.hl().getNinePatchChunk(), aVar.hp(), null);
            if (TbadkApplication.m251getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(com.baidu.tieba.pb.main.bv.jh);
            }
            editText = this.bUm.bJK;
            editText.setBackgroundDrawable(ninePatchDrawable);
            if (this.bUp) {
                WriteActivity writeActivity = this.bUm;
                editText2 = this.bUm.bJK;
                tVar = this.bUm.aDB;
                com.baidu.tieba.bubble.h.a(writeActivity, editText2, true, tVar);
            }
        }
    }
}
