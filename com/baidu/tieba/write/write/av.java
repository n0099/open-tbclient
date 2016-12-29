package com.baidu.tieba.write.write;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.EditText;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ WriteActivity fDQ;
    private final /* synthetic */ boolean fDS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(WriteActivity writeActivity, boolean z) {
        this.fDQ = writeActivity;
        this.fDS = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText bnw;
        EditText bnw2;
        a.InterfaceC0072a interfaceC0072a;
        super.a((av) aVar, str, i);
        if (aVar != null && aVar.jV() != null && aVar.jZ() != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.m9getInst().getResources(), aVar.jV(), aVar.jV().getNinePatchChunk(), aVar.jZ(), null);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
            }
            bnw = this.fDQ.bnw();
            bnw.setBackgroundDrawable(ninePatchDrawable);
            if (this.fDS) {
                WriteActivity writeActivity = this.fDQ;
                bnw2 = this.fDQ.bnw();
                interfaceC0072a = this.fDQ.egv;
                com.baidu.tieba.tbadkCore.b.a.a(writeActivity, bnw2, true, interfaceC0072a);
            }
        }
    }
}
