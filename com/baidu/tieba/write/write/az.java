package com.baidu.tieba.write.write;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.EditText;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.c.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ WriteActivity dqi;
    private final /* synthetic */ boolean dql;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(WriteActivity writeActivity, boolean z) {
        this.dqi = writeActivity;
        this.dql = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText aDs;
        EditText aDs2;
        a.InterfaceC0074a interfaceC0074a;
        super.a((az) aVar, str, i);
        if (aVar != null && aVar.na() != null && aVar.ne() != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.m411getInst().getResources(), aVar.na(), aVar.na().getNinePatchChunk(), aVar.ne(), null);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(com.baidu.tieba.tbadkCore.ac.mAlpha);
            }
            aDs = this.dqi.aDs();
            aDs.setBackgroundDrawable(ninePatchDrawable);
            if (this.dql) {
                WriteActivity writeActivity = this.dqi;
                aDs2 = this.dqi.aDs();
                interfaceC0074a = this.dqi.clE;
                com.baidu.tieba.tbadkCore.c.a.a(writeActivity, aDs2, true, interfaceC0074a);
            }
        }
    }
}
