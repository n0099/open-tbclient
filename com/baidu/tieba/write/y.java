package com.baidu.tieba.write;

import com.baidu.tbadk.widget.TbImageView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ v a;
    private final /* synthetic */ TbImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(v vVar, TbImageView tbImageView) {
        this.a = vVar;
        this.b = tbImageView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        int i;
        int i2;
        TbImageView[] tbImageViewArr;
        if (bVar != null && str.equals(this.b.getTag())) {
            this.b.invalidate();
            this.b.setDefaultResource(0);
            this.b.setNightDefaultResource(0);
        } else {
            this.b.setDefaultResource(R.drawable.image_group_load_f);
            this.b.setNightDefaultResource(R.drawable.image_group_load_f);
        }
        v vVar = this.a;
        i = vVar.o;
        vVar.o = i + 1;
        i2 = this.a.o;
        tbImageViewArr = this.a.f;
        if (i2 >= tbImageViewArr.length) {
            this.a.n = false;
        }
    }
}
