package com.baidu.tieba.write;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ t bTp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.bTp = tVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        this.bTp.eL(true);
        if (aVar != null) {
            tbImageView2 = this.bTp.bTm;
            aVar.a(tbImageView2);
            return;
        }
        tbImageView = this.bTp.bTm;
        tbImageView.setDefaultResource(com.baidu.tieba.u.image_group_load_f);
    }
}
