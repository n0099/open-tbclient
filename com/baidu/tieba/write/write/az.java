package com.baidu.tieba.write.write;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.EditText;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.c.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ WriteActivity dpI;
    private final /* synthetic */ boolean dpL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(WriteActivity writeActivity, boolean z) {
        this.dpI = writeActivity;
        this.dpL = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText aDm;
        EditText aDm2;
        a.InterfaceC0074a interfaceC0074a;
        super.a((az) aVar, str, i);
        if (aVar != null && aVar.na() != null && aVar.ne() != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.m411getInst().getResources(), aVar.na(), aVar.na().getNinePatchChunk(), aVar.ne(), null);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(com.baidu.tieba.tbadkCore.ac.mAlpha);
            }
            aDm = this.dpI.aDm();
            aDm.setBackgroundDrawable(ninePatchDrawable);
            if (this.dpL) {
                WriteActivity writeActivity = this.dpI;
                aDm2 = this.dpI.aDm();
                interfaceC0074a = this.dpI.clt;
                com.baidu.tieba.tbadkCore.c.a.a(writeActivity, aDm2, true, interfaceC0074a);
            }
        }
    }
}
