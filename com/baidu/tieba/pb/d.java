package com.baidu.tieba.pb;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.flow.a.e;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.view.g;
/* loaded from: classes.dex */
public class d implements com.baidu.tbadk.core.flow.b {
    private g cBg;
    private int mHeight;

    public d(g gVar, int i) {
        this.cBg = gVar;
        this.mHeight = i;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.c ts() {
        com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
        cVar.setDrawableId(n.f.icon_choose_dot_n);
        cVar.bY(n.f.icon_choose_dot_s);
        cVar.setSpacing(n.e.ds14);
        cVar.setGravity(85);
        cVar.ca(n.e.ds10);
        if (this.cBg.getVisibility() == 0) {
            if (this.cBg.cMO.getVisibility() == 8 || this.cBg.cMP.getVisibility() == 8) {
                cVar.bZ(n.e.ds70);
            } else {
                cVar.bZ(n.e.ds98);
            }
        } else {
            cVar.bZ(n.e.ds10);
        }
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
    public e tt() {
        e eVar = new e();
        eVar.setHeight(this.mHeight);
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public View tu() {
        return this.cBg;
    }
}
