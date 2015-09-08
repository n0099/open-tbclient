package com.baidu.tieba.write.write;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.EditText;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.c.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ WriteActivity ddQ;
    private final /* synthetic */ boolean ddT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(WriteActivity writeActivity, boolean z) {
        this.ddQ = writeActivity;
        this.ddT = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText azK;
        EditText azK2;
        a.InterfaceC0071a interfaceC0071a;
        super.a((az) aVar, str, i);
        if (aVar != null && aVar.mZ() != null && aVar.nd() != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.m411getInst().getResources(), aVar.mZ(), aVar.mZ().getNinePatchChunk(), aVar.nd(), null);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(com.baidu.tieba.tbadkCore.ac.mAlpha);
            }
            azK = this.ddQ.azK();
            azK.setBackgroundDrawable(ninePatchDrawable);
            if (this.ddT) {
                WriteActivity writeActivity = this.ddQ;
                azK2 = this.ddQ.azK();
                interfaceC0071a = this.ddQ.cga;
                com.baidu.tieba.tbadkCore.c.a.a(writeActivity, azK2, true, interfaceC0071a);
            }
        }
    }
}
