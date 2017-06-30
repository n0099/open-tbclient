package com.baidu.tieba.recapp;

import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements TbImageView.a {
    private final /* synthetic */ TbImageView fqA;
    private final /* synthetic */ int fqB;
    private final /* synthetic */ float fqC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(TbImageView tbImageView, int i, float f) {
        this.fqA = tbImageView;
        this.fqB = i;
        this.fqC = f;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void t(String str, boolean z) {
        ViewGroup.LayoutParams layoutParams = this.fqA.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = this.fqB;
            layoutParams.width = (int) ((this.fqC > 0.0f ? this.fqC : 2.0f) * layoutParams.height);
            this.fqA.setLayoutParams(layoutParams);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                this.fqA.setAlpha(0.8f);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
