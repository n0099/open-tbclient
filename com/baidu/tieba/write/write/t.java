package com.baidu.tieba.write.write;

import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.write.write.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ r.b eLZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r.b bVar) {
        this.eLZ = bVar;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        this.eLZ.jv(true);
        if (aVar != null) {
            tbImageView2 = this.eLZ.aJQ;
            aVar.a(tbImageView2);
            return;
        }
        tbImageView = this.eLZ.aJQ;
        tbImageView.setDefaultResource(t.f.image_group_load_f);
    }
}
