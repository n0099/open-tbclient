package com.baidu.tieba.pb;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.pb.view.m;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.core.flow.b {
    private m ddp;
    private int mHeight;

    public e(m mVar, int i) {
        this.ddp = mVar;
        this.mHeight = i;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.c sh() {
        com.baidu.tbadk.core.flow.a.c cVar = new com.baidu.tbadk.core.flow.a.c();
        cVar.cd(t.f.icon_choose_dot_n);
        cVar.ce(t.f.icon_choose_dot_s);
        cVar.setSpacing(t.e.ds14);
        cVar.setGravity(85);
        cVar.cg(t.e.ds10);
        if (this.ddp.getVisibility() == 0) {
            if (this.ddp.dsB.getVisibility() == 8 || this.ddp.dsC.getVisibility() == 8) {
                cVar.cf(t.e.ds70);
            } else {
                cVar.cf(t.e.ds98);
            }
        } else {
            cVar.cf(t.e.ds10);
        }
        return cVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public TbImageView J(Context context) {
        TbImageView tbImageView = new TbImageView(context);
        tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        tbImageView.setGifIconSupport(false);
        return tbImageView;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public com.baidu.tbadk.core.flow.a.e si() {
        com.baidu.tbadk.core.flow.a.e eVar = new com.baidu.tbadk.core.flow.a.e();
        eVar.setHeight(this.mHeight);
        return eVar;
    }

    @Override // com.baidu.tbadk.core.flow.b
    public View sj() {
        return this.ddp;
    }
}
