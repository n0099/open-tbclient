package com.baidu.tieba.write;

import com.baidu.tbadk.widget.TbImageView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ ac a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ac acVar) {
        this.a = acVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        TbImageView tbImageView3;
        TbImageView tbImageView4;
        this.a.a(true);
        if (bVar != null) {
            tbImageView3 = this.a.c;
            if (str.equals(tbImageView3.getTag())) {
                tbImageView4 = this.a.c;
                tbImageView4.invalidate();
                return;
            }
        }
        tbImageView = this.a.c;
        tbImageView.setDefaultResource(R.drawable.image_group_load_f);
        tbImageView2 = this.a.c;
        tbImageView2.setNightDefaultResource(R.drawable.image_group_load_f);
    }
}
