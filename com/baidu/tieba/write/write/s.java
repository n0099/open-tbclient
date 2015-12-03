package com.baidu.tieba.write.write;

import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.write.write.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ q.b dPO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q.b bVar) {
        this.dPO = bVar;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        this.dPO.hL(true);
        if (aVar != null) {
            tbImageView2 = this.dPO.aEB;
            aVar.a(tbImageView2);
            return;
        }
        tbImageView = this.dPO.aEB;
        tbImageView.setDefaultResource(n.e.image_group_load_f);
    }
}
