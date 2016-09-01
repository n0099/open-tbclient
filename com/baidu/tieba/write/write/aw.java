package com.baidu.tieba.write.write;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.EditText;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ WriteActivity gfs;
    private final /* synthetic */ boolean gfv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(WriteActivity writeActivity, boolean z) {
        this.gfs = writeActivity;
        this.gfv = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText bty;
        EditText bty2;
        a.InterfaceC0074a interfaceC0074a;
        super.a((aw) aVar, str, i);
        if (aVar != null && aVar.jV() != null && aVar.jZ() != null) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.m9getInst().getResources(), aVar.jV(), aVar.jV().getNinePatchChunk(), aVar.jZ(), null);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                ninePatchDrawable.getPaint().setAlpha(com.baidu.tieba.tbadkCore.ad.mAlpha);
            }
            bty = this.gfs.bty();
            bty.setBackgroundDrawable(ninePatchDrawable);
            if (this.gfv) {
                WriteActivity writeActivity = this.gfs;
                bty2 = this.gfs.bty();
                interfaceC0074a = this.gfs.etZ;
                com.baidu.tieba.tbadkCore.b.a.a(writeActivity, bty2, true, interfaceC0074a);
            }
        }
    }
}
