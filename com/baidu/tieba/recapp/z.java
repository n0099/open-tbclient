package com.baidu.tieba.recapp;

import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements TbImageView.a {
    private final /* synthetic */ TbImageView eZi;
    private final /* synthetic */ int eZj;
    private final /* synthetic */ float eZk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(TbImageView tbImageView, int i, float f) {
        this.eZi = tbImageView;
        this.eZj = i;
        this.eZk = f;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void v(String str, boolean z) {
        ViewGroup.LayoutParams layoutParams = this.eZi.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = this.eZj;
            layoutParams.width = (int) ((this.eZk > 0.0f ? this.eZk : 2.0f) * layoutParams.height);
            this.eZi.setLayoutParams(layoutParams);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                this.eZi.setAlpha(0.8f);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
