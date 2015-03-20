package com.baidu.tieba.recommendfrs.b;

import android.content.Context;
import android.widget.ImageView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tbadk.core.flow.b {
    final /* synthetic */ c bYb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bYb = cVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.c rl() {
        com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
        cVar.setDrawableId(u.icon_banner_n);
        cVar.bI(u.icon_banner_s);
        cVar.setSpacing(t.square_indicator_spacing);
        cVar.setGravity(85);
        cVar.bK(t.ds30);
        cVar.bJ(t.ds22);
        return cVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public TbImageView V(Context context) {
        TbImageView tbImageView = new TbImageView(context);
        tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        tbImageView.setGifIconSupport(false);
        return tbImageView;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.e rm() {
        com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
        eVar.setHeight(TbadkApplication.getInst().getResources().getDimensionPixelSize(t.ds314));
        return eVar;
    }
}
