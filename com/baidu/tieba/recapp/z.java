package com.baidu.tieba.recapp;

import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements TbImageView.a {
    private final /* synthetic */ int fbA;
    private final /* synthetic */ float fbB;
    private final /* synthetic */ TbImageView fbz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(TbImageView tbImageView, int i, float f) {
        this.fbz = tbImageView;
        this.fbA = i;
        this.fbB = f;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void v(String str, boolean z) {
        ViewGroup.LayoutParams layoutParams = this.fbz.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = this.fbA;
            layoutParams.width = (int) ((this.fbB > 0.0f ? this.fbB : 2.0f) * layoutParams.height);
            this.fbz.setLayoutParams(layoutParams);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                this.fbz.setAlpha(0.8f);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
