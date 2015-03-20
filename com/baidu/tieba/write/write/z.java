package com.baidu.tieba.write.write;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ x cxf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.cxf = xVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        this.cxf.fj(true);
        if (aVar != null) {
            tbImageView2 = this.cxf.cxc;
            aVar.a(tbImageView2);
            return;
        }
        tbImageView = this.cxf.cxc;
        tbImageView.setDefaultResource(com.baidu.tieba.u.image_group_load_f);
    }
}
