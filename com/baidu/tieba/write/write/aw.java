package com.baidu.tieba.write.write;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.EditText;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ WriteActivity fJw;
    private final /* synthetic */ boolean fJz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(WriteActivity writeActivity, boolean z) {
        this.fJw = writeActivity;
        this.fJz = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText bmp;
        EditText bmp2;
        a.InterfaceC0075a interfaceC0075a;
        super.a((aw) aVar, str, i);
        if (aVar != null && aVar.jb() != null && aVar.jf() != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.m9getInst().getResources(), aVar.jb(), aVar.jb().getNinePatchChunk(), aVar.jf(), null);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(com.baidu.tieba.tbadkCore.ae.mAlpha);
            }
            bmp = this.fJw.bmp();
            bmp.setBackgroundDrawable(ninePatchDrawable);
            if (this.fJz) {
                WriteActivity writeActivity = this.fJw;
                bmp2 = this.fJw.bmp();
                interfaceC0075a = this.fJw.dVr;
                com.baidu.tieba.tbadkCore.b.a.a(writeActivity, bmp2, true, interfaceC0075a);
            }
        }
    }
}
