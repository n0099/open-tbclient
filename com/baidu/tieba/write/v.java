package com.baidu.tieba.write;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ t cew;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.cew = tVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        this.cew.eK(true);
        if (aVar != null) {
            tbImageView2 = this.cew.cet;
            aVar.a(tbImageView2);
            return;
        }
        tbImageView = this.cew.cet;
        tbImageView.setDefaultResource(com.baidu.tieba.v.image_group_load_f);
    }
}
