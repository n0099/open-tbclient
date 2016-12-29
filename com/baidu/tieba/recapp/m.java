package com.baidu.tieba.recapp;

import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements TbImageView.a {
    private final /* synthetic */ TbImageView eNG;
    private final /* synthetic */ int eNH;
    private final /* synthetic */ float eNI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(TbImageView tbImageView, int i, float f) {
        this.eNG = tbImageView;
        this.eNH = i;
        this.eNI = f;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void v(String str, boolean z) {
        ViewGroup.LayoutParams layoutParams = this.eNG.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = this.eNH;
            layoutParams.width = (int) ((this.eNI > 0.0f ? this.eNI : 2.0f) * layoutParams.height);
            this.eNG.setLayoutParams(layoutParams);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                this.eNG.setAlpha(0.8f);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
