package com.baidu.tieba.write.write;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.EditText;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ WriteActivity gaR;
    private final /* synthetic */ boolean gaT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(WriteActivity writeActivity, boolean z) {
        this.gaR = writeActivity;
        this.gaT = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText bpV;
        EditText bpV2;
        a.InterfaceC0080a interfaceC0080a;
        super.onLoaded((ax) aVar, str, i);
        if (aVar != null && aVar.kR() != null && aVar.kV() != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.m9getInst().getResources(), aVar.kR(), aVar.kR().getNinePatchChunk(), aVar.kV(), null);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
            }
            bpV = this.gaR.bpV();
            bpV.setBackgroundDrawable(ninePatchDrawable);
            if (this.gaT) {
                WriteActivity writeActivity = this.gaR;
                bpV2 = this.gaR.bpV();
                interfaceC0080a = this.gaR.euI;
                com.baidu.tieba.tbadkCore.b.a.a(writeActivity, bpV2, true, interfaceC0080a);
            }
        }
    }
}
