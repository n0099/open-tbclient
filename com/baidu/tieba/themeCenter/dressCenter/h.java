package com.baidu.tieba.themeCenter.dressCenter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class h implements com.baidu.tbadk.core.flow.b {
    final /* synthetic */ f dfO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.dfO = fVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.c td() {
        com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
        cVar.setDrawableId(i.e.icon_diandian_white_n);
        cVar.bX(i.e.icon_diandian_white_s);
        cVar.setSpacing(i.d.ds1);
        cVar.setGravity(85);
        cVar.bZ(i.d.ds30);
        cVar.bY(i.d.ds20);
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
    public com.baidu.tbadk.core.flow.a.e te() {
        com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
        eVar.setHeight(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds280));
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public View tf() {
        return null;
    }
}
