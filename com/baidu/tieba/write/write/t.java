package com.baidu.tieba.write.write;

import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
import com.baidu.tieba.write.write.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ r.b fIq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r.b bVar) {
        this.fIq = bVar;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        this.fIq.lm(true);
        if (aVar != null) {
            tbImageView2 = this.fIq.aGB;
            aVar.a(tbImageView2);
            return;
        }
        tbImageView = this.fIq.aGB;
        tbImageView.setDefaultResource(u.f.image_group_load_f);
    }
}
