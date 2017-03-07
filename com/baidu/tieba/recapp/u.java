package com.baidu.tieba.recapp;

import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements TbImageView.a {
    private final /* synthetic */ TbImageView fbc;
    private final /* synthetic */ int fbd;
    private final /* synthetic */ float fbe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(TbImageView tbImageView, int i, float f) {
        this.fbc = tbImageView;
        this.fbd = i;
        this.fbe = f;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void v(String str, boolean z) {
        ViewGroup.LayoutParams layoutParams = this.fbc.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = this.fbd;
            layoutParams.width = (int) ((this.fbe > 0.0f ? this.fbe : 2.0f) * layoutParams.height);
            this.fbc.setLayoutParams(layoutParams);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                this.fbc.setAlpha(0.8f);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
