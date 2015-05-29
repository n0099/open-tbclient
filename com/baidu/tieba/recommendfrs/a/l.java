package com.baidu.tieba.recommendfrs.a;

import android.content.Context;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.o;
import com.baidu.tieba.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.core.flow.b {
    final /* synthetic */ k ccC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.ccC = kVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.c rV() {
        com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
        cVar.setDrawableId(p.icon_banner_n);
        cVar.bM(p.icon_banner_s);
        cVar.setSpacing(o.ds14);
        cVar.setGravity(85);
        cVar.bO(o.ds30);
        cVar.bN(o.ds22);
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
    public com.baidu.tbadk.core.flow.a.e rW() {
        com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
        eVar.setHeight(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(o.ds314));
        return eVar;
    }
}
