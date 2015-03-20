package com.baidu.tieba.pb.richview.b;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.n;
/* loaded from: classes.dex */
class d implements n {
    final /* synthetic */ b bOp;
    private final /* synthetic */ TbImageView bOq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, TbImageView tbImageView) {
        this.bOp = bVar;
        this.bOq = tbImageView;
    }

    @Override // com.baidu.tbadk.widget.n
    public void onComplete(String str, boolean z) {
        int i;
        int i2;
        LinearLayout.LayoutParams layoutParams;
        int i3;
        int i4;
        int i5;
        int ae;
        com.baidu.adp.widget.a.a bdImage = this.bOq.getBdImage();
        if (bdImage != null) {
            int height = bdImage.getHeight();
            int width = bdImage.getWidth();
            if (height > 0 && width > 0) {
                i5 = this.bOp.maxWidth;
                ae = this.bOp.ae(width, height);
                i = i5;
                i2 = ae;
            } else {
                i = -1;
                i2 = -2;
            }
            ViewGroup.LayoutParams layoutParams2 = this.bOq.getLayoutParams();
            if (layoutParams2 instanceof LinearLayout.LayoutParams) {
                layoutParams = (LinearLayout.LayoutParams) layoutParams2;
                layoutParams.width = i;
                layoutParams.height = i2;
            } else {
                layoutParams = new LinearLayout.LayoutParams(i, i2);
            }
            i3 = this.bOp.margin;
            layoutParams.topMargin = i3;
            i4 = this.bOp.margin;
            layoutParams.bottomMargin = i4;
            this.bOq.setLayoutParams(layoutParams);
            this.bOq.setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.widget.n
    public void onCancel() {
    }
}
