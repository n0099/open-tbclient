package com.baidu.tieba.write.write;

import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import com.baidu.tieba.write.write.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ q.b fRA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q.b bVar) {
        this.fRA = bVar;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        this.fRA.lI(true);
        if (aVar != null) {
            tbImageView2 = this.fRA.aPg;
            aVar.e(tbImageView2);
            return;
        }
        tbImageView = this.fRA.aPg;
        tbImageView.setDefaultResource(w.g.image_group_load_f);
    }
}
