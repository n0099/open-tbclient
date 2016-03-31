package com.baidu.tieba.write.write;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.EditText;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ WriteActivity eNd;
    private final /* synthetic */ boolean eNf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(WriteActivity writeActivity, boolean z) {
        this.eNd = writeActivity;
        this.eNf = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText bby;
        EditText bby2;
        a.InterfaceC0081a interfaceC0081a;
        super.a((az) aVar, str, i);
        if (aVar != null && aVar.mK() != null && aVar.mO() != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.m411getInst().getResources(), aVar.mK(), aVar.mK().getNinePatchChunk(), aVar.mO(), null);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(com.baidu.tieba.tbadkCore.ac.mAlpha);
            }
            bby = this.eNd.bby();
            bby.setBackgroundDrawable(ninePatchDrawable);
            if (this.eNf) {
                WriteActivity writeActivity = this.eNd;
                bby2 = this.eNd.bby();
                interfaceC0081a = this.eNd.dmy;
                com.baidu.tieba.tbadkCore.b.a.a(writeActivity, bby2, true, interfaceC0081a);
            }
        }
    }
}
