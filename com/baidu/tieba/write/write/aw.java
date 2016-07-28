package com.baidu.tieba.write.write;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.EditText;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ WriteActivity fVn;
    private final /* synthetic */ boolean fVq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(WriteActivity writeActivity, boolean z) {
        this.fVn = writeActivity;
        this.fVq = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText bpj;
        EditText bpj2;
        a.InterfaceC0074a interfaceC0074a;
        super.a((aw) aVar, str, i);
        if (aVar != null && aVar.ja() != null && aVar.je() != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.m10getInst().getResources(), aVar.ja(), aVar.ja().getNinePatchChunk(), aVar.je(), null);
            if (TbadkCoreApplication.m10getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(com.baidu.tieba.tbadkCore.ae.mAlpha);
            }
            bpj = this.fVn.bpj();
            bpj.setBackgroundDrawable(ninePatchDrawable);
            if (this.fVq) {
                WriteActivity writeActivity = this.fVn;
                bpj2 = this.fVn.bpj();
                interfaceC0074a = this.fVn.ehS;
                com.baidu.tieba.tbadkCore.b.a.a(writeActivity, bpj2, true, interfaceC0074a);
            }
        }
    }
}
