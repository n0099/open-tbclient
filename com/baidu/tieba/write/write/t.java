package com.baidu.tieba.write.write;

import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import com.baidu.tieba.write.write.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ r.b ggv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r.b bVar) {
        this.ggv = bVar;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        this.ggv.lQ(true);
        if (aVar != null) {
            tbImageView2 = this.ggv.aKh;
            aVar.e(tbImageView2);
            return;
        }
        tbImageView = this.ggv.aKh;
        tbImageView.setDefaultResource(r.f.image_group_load_f);
    }
}
