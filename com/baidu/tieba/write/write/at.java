package com.baidu.tieba.write.write;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.EditText;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ WriteActivity fUM;
    private final /* synthetic */ boolean fUO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(WriteActivity writeActivity, boolean z) {
        this.fUM = writeActivity;
        this.fUO = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText bqs;
        EditText bqs2;
        a.InterfaceC0072a interfaceC0072a;
        super.onLoaded((at) aVar, str, i);
        if (aVar != null && aVar.kS() != null && aVar.kW() != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.m9getInst().getResources(), aVar.kS(), aVar.kS().getNinePatchChunk(), aVar.kW(), null);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
            }
            bqs = this.fUM.bqs();
            bqs.setBackgroundDrawable(ninePatchDrawable);
            if (this.fUO) {
                WriteActivity writeActivity = this.fUM;
                bqs2 = this.fUM.bqs();
                interfaceC0072a = this.fUM.etj;
                com.baidu.tieba.tbadkCore.b.a.a(writeActivity, bqs2, true, interfaceC0072a);
            }
        }
    }
}
