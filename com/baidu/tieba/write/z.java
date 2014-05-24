package com.baidu.tieba.write;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ x a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.a = xVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        TbImageView tbImageView3;
        this.a.a(true);
        if (aVar != null) {
            tbImageView3 = this.a.c;
            aVar.a(tbImageView3);
            return;
        }
        tbImageView = this.a.c;
        tbImageView.setDefaultResource(com.baidu.tieba.u.image_group_load_f);
        tbImageView2 = this.a.c;
        tbImageView2.setNightDefaultResource(com.baidu.tieba.u.image_group_load_f);
    }
}
