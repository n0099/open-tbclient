package com.baidu.tieba.write;

import com.baidu.tbadk.widget.TbImageView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ad implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ ab a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar) {
        this.a = abVar;
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
        tbImageView.setDefaultResource(R.drawable.image_group_load_f);
        tbImageView2 = this.a.c;
        tbImageView2.setNightDefaultResource(R.drawable.image_group_load_f);
    }
}
