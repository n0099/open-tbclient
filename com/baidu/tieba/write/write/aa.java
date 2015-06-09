package com.baidu.tieba.write.write;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ y cBR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar) {
        this.cBR = yVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        this.cBR.fE(true);
        if (aVar != null) {
            tbImageView2 = this.cBR.cBO;
            aVar.a(tbImageView2);
            return;
        }
        tbImageView = this.cBR.cBO;
        tbImageView.setDefaultResource(com.baidu.tieba.p.image_group_load_f);
    }
}
