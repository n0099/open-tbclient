package com.baidu.tieba.write.write;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.EditText;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.c.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ WriteActivity cUM;
    private final /* synthetic */ boolean cUP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(WriteActivity writeActivity, boolean z) {
        this.cUM = writeActivity;
        this.cUP = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText editText;
        EditText editText2;
        a.InterfaceC0069a interfaceC0069a;
        super.a((aw) aVar, str, i);
        if (aVar != null && aVar.nc() != null && aVar.ng() != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.m411getInst().getResources(), aVar.nc(), aVar.nc().getNinePatchChunk(), aVar.ng(), null);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(com.baidu.tieba.tbadkCore.ab.mAlpha);
            }
            editText = this.cUM.cSo;
            editText.setBackgroundDrawable(ninePatchDrawable);
            if (this.cUP) {
                WriteActivity writeActivity = this.cUM;
                editText2 = this.cUM.cSo;
                interfaceC0069a = this.cUM.cfd;
                com.baidu.tieba.tbadkCore.c.a.a(writeActivity, editText2, true, interfaceC0069a);
            }
        }
    }
}
