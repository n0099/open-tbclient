package com.baidu.tieba.pb.richview.b;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.n;
/* loaded from: classes.dex */
class d implements n {
    final /* synthetic */ b bOF;
    private final /* synthetic */ TbImageView bOG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, TbImageView tbImageView) {
        this.bOF = bVar;
        this.bOG = tbImageView;
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
        com.baidu.adp.widget.a.a bdImage = this.bOG.getBdImage();
        if (bdImage != null) {
            int height = bdImage.getHeight();
            int width = bdImage.getWidth();
            if (height > 0 && width > 0) {
                i5 = this.bOF.maxWidth;
                ae = this.bOF.ae(width, height);
                i = i5;
                i2 = ae;
            } else {
                i = -1;
                i2 = -2;
            }
            ViewGroup.LayoutParams layoutParams2 = this.bOG.getLayoutParams();
            if (layoutParams2 instanceof LinearLayout.LayoutParams) {
                layoutParams = (LinearLayout.LayoutParams) layoutParams2;
                layoutParams.width = i;
                layoutParams.height = i2;
            } else {
                layoutParams = new LinearLayout.LayoutParams(i, i2);
            }
            i3 = this.bOF.margin;
            layoutParams.topMargin = i3;
            i4 = this.bOF.margin;
            layoutParams.bottomMargin = i4;
            this.bOG.setLayoutParams(layoutParams);
            this.bOG.setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.widget.n
    public void onCancel() {
    }
}
