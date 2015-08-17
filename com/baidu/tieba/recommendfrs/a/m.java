package com.baidu.tieba.recommendfrs.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.tbadk.core.flow.b {
    final /* synthetic */ l cua;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.cua = lVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.c tb() {
        com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
        cVar.setDrawableId(i.e.icon_diandian_white_n);
        cVar.bU(i.e.icon_diandian_white_s);
        cVar.setSpacing(i.d.ds1);
        cVar.setGravity(85);
        cVar.bW(i.d.ds30);
        cVar.bV(i.d.ds22);
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
    public com.baidu.tbadk.core.flow.a.e tc() {
        com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
        eVar.setHeight(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds314));
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public View td() {
        return null;
    }
}
