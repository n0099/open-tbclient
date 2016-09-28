package com.baidu.tieba.write.write;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.EditText;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ WriteActivity ghD;
    private final /* synthetic */ boolean ghF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(WriteActivity writeActivity, boolean z) {
        this.ghD = writeActivity;
        this.ghF = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText buf;
        EditText buf2;
        a.InterfaceC0077a interfaceC0077a;
        super.a((aw) aVar, str, i);
        if (aVar != null && aVar.jV() != null && aVar.jZ() != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.m9getInst().getResources(), aVar.jV(), aVar.jV().getNinePatchChunk(), aVar.jZ(), null);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(com.baidu.tieba.tbadkCore.ad.mAlpha);
            }
            buf = this.ghD.buf();
            buf.setBackgroundDrawable(ninePatchDrawable);
            if (this.ghF) {
                WriteActivity writeActivity = this.ghD;
                buf2 = this.ghD.buf();
                interfaceC0077a = this.ghD.ewf;
                com.baidu.tieba.tbadkCore.b.a.a(writeActivity, buf2, true, interfaceC0077a);
            }
        }
    }
}
