package com.baidu.tieba.recommendfrs.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.core.flow.b {
    final /* synthetic */ m cJx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.cJx = mVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.c td() {
        com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
        cVar.setDrawableId(i.e.icon_diandian_white_n);
        cVar.bX(i.e.icon_diandian_white_s);
        cVar.setSpacing(i.d.ds1);
        cVar.setGravity(85);
        cVar.bZ(i.d.ds30);
        cVar.bY(i.d.ds22);
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
        eVar.setHeight(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds314));
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public View tf() {
        return null;
    }
}
