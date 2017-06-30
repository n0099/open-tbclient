package com.baidu.tieba.write.write;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.EditText;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ WriteActivity glP;
    private final /* synthetic */ boolean glR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(WriteActivity writeActivity, boolean z) {
        this.glP = writeActivity;
        this.glR = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText bus;
        EditText bus2;
        a.InterfaceC0083a interfaceC0083a;
        super.onLoaded((av) aVar, str, i);
        if (aVar != null && aVar.kP() != null && aVar.kT() != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.m9getInst().getResources(), aVar.kP(), aVar.kP().getNinePatchChunk(), aVar.kT(), null);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
            }
            bus = this.glP.bus();
            bus.setBackgroundDrawable(ninePatchDrawable);
            if (this.glR) {
                WriteActivity writeActivity = this.glP;
                bus2 = this.glP.bus();
                interfaceC0083a = this.glP.eDV;
                com.baidu.tieba.tbadkCore.b.a.a(writeActivity, bus2, true, interfaceC0083a);
            }
        }
    }
}
