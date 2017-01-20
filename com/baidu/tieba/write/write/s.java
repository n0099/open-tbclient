package com.baidu.tieba.write.write;

import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import com.baidu.tieba.write.write.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ q.b fKX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q.b bVar) {
        this.fKX = bVar;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        this.fKX.lN(true);
        if (aVar != null) {
            tbImageView2 = this.fKX.aIY;
            aVar.e(tbImageView2);
            return;
        }
        tbImageView = this.fKX.aIY;
        tbImageView.setDefaultResource(r.g.image_group_load_f);
    }
}
