package com.baidu.tieba.write;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.EditText;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar extends com.baidu.adp.lib.resourceLoader.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ WriteActivity a;
    private final /* synthetic */ boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(WriteActivity writeActivity, boolean z) {
        this.a = writeActivity;
        this.b = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.resourceLoader.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText editText;
        EditText editText2;
        com.baidu.tieba.bubble.t tVar;
        super.a((ar) aVar, str, i);
        if (aVar != null && aVar.h() != null && aVar.l() != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkApplication.m252getInst().getResources(), aVar.h(), aVar.h().getNinePatchChunk(), aVar.l(), null);
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(com.baidu.tieba.pb.main.bs.a);
            }
            editText = this.a.i;
            editText.setBackgroundDrawable(ninePatchDrawable);
            if (this.b) {
                WriteActivity writeActivity = this.a;
                editText2 = this.a.i;
                tVar = this.a.ad;
                com.baidu.tieba.bubble.h.a(writeActivity, editText2, true, tVar);
            }
        }
    }
}
