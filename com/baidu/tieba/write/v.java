package com.baidu.tieba.write;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ t cfV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.cfV = tVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        this.cfV.eP(true);
        if (aVar != null) {
            tbImageView2 = this.cfV.cfS;
            aVar.a(tbImageView2);
            return;
        }
        tbImageView = this.cfV.cfS;
        tbImageView.setDefaultResource(com.baidu.tieba.v.image_group_load_f);
    }
}
