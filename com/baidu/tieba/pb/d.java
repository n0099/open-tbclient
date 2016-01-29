package com.baidu.tieba.pb;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.pb.view.g;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class d implements com.baidu.tbadk.core.flow.b {
    private g cHM;
    private int mHeight;

    public d(g gVar, int i) {
        this.cHM = gVar;
        this.mHeight = i;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.c uw() {
        com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
        cVar.setDrawableId(t.f.icon_choose_dot_n);
        cVar.cr(t.f.icon_choose_dot_s);
        cVar.setSpacing(t.e.ds14);
        cVar.setGravity(85);
        cVar.ct(t.e.ds10);
        if (this.cHM.getVisibility() == 0) {
            if (this.cHM.cVC.getVisibility() == 8 || this.cHM.cVD.getVisibility() == 8) {
                cVar.cs(t.e.ds70);
            } else {
                cVar.cs(t.e.ds98);
            }
        } else {
            cVar.cs(t.e.ds10);
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
    public com.baidu.tbadk.core.flow.a.e ux() {
        com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
        eVar.setHeight(this.mHeight);
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public View uy() {
        return this.cHM;
    }
}
