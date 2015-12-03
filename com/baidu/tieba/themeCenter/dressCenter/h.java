package com.baidu.tieba.themeCenter.dressCenter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class h implements com.baidu.tbadk.core.flow.b {
    final /* synthetic */ f dGd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.dGd = fVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.c tI() {
        com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
        cVar.setDrawableId(n.e.icon_diandian_white_n);
        cVar.cf(n.e.icon_diandian_white_s);
        cVar.setSpacing(n.d.ds1);
        cVar.setGravity(85);
        cVar.ch(n.d.ds30);
        cVar.cg(n.d.ds20);
        return cVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public TbImageView X(Context context) {
        TbImageView tbImageView = new TbImageView(context);
        tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        tbImageView.setGifIconSupport(false);
        return tbImageView;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.e tJ() {
        com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
        eVar.setHeight(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds280));
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public View tK() {
        return null;
    }
}
