package com.baidu.tieba.pb;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.pb.view.g;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.core.flow.b {
    private g daV;
    private int mHeight;

    public e(g gVar, int i) {
        this.daV = gVar;
        this.mHeight = i;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.c uB() {
        com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
        cVar.ct(t.f.icon_choose_dot_n);
        cVar.cu(t.f.icon_choose_dot_s);
        cVar.setSpacing(t.e.ds14);
        cVar.setGravity(85);
        cVar.cw(t.e.ds10);
        if (this.daV.getVisibility() == 0) {
            if (this.daV.dqx.getVisibility() == 8 || this.daV.dqy.getVisibility() == 8) {
                cVar.cv(t.e.ds70);
            } else {
                cVar.cv(t.e.ds98);
            }
        } else {
            cVar.cv(t.e.ds10);
        }
        return cVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public TbImageView K(Context context) {
        TbImageView tbImageView = new TbImageView(context);
        tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        tbImageView.setGifIconSupport(false);
        return tbImageView;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.e uC() {
        com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
        eVar.setHeight(this.mHeight);
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public View uD() {
        return this.daV;
    }
}
