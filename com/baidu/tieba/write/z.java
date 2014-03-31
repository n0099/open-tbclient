package com.baidu.tieba.write;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ x a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.a = xVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        TbImageView tbImageView3;
        this.a.a(true);
        if (bVar != null) {
            tbImageView3 = this.a.c;
            bVar.a(tbImageView3);
            return;
        }
        tbImageView = this.a.c;
        tbImageView.setDefaultResource(com.baidu.tieba.a.g.image_group_load_f);
        tbImageView2 = this.a.c;
        tbImageView2.setNightDefaultResource(com.baidu.tieba.a.g.image_group_load_f);
    }
}
