package com.baidu.tieba.write.write;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ y cBQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar) {
        this.cBQ = yVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        this.cBQ.fE(true);
        if (aVar != null) {
            tbImageView2 = this.cBQ.cBN;
            aVar.a(tbImageView2);
            return;
        }
        tbImageView = this.cBQ.cBN;
        tbImageView.setDefaultResource(com.baidu.tieba.p.image_group_load_f);
    }
}
