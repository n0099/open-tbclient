package com.baidu.tieba.write.write;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.EditText;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ WriteActivity gpp;
    private final /* synthetic */ boolean gpr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(WriteActivity writeActivity, boolean z) {
        this.gpp = writeActivity;
        this.gpr = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText bwx;
        EditText bwx2;
        a.InterfaceC0078a interfaceC0078a;
        super.a((av) aVar, str, i);
        if (aVar != null && aVar.jV() != null && aVar.jZ() != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.m9getInst().getResources(), aVar.jV(), aVar.jV().getNinePatchChunk(), aVar.jZ(), null);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
            }
            bwx = this.gpp.bwx();
            bwx.setBackgroundDrawable(ninePatchDrawable);
            if (this.gpr) {
                WriteActivity writeActivity = this.gpp;
                bwx2 = this.gpp.bwx();
                interfaceC0078a = this.gpp.eCp;
                com.baidu.tieba.tbadkCore.b.a.a(writeActivity, bwx2, true, interfaceC0078a);
            }
        }
    }
}
