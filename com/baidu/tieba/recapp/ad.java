package com.baidu.tieba.recapp;

import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements TbImageView.a {
    private final /* synthetic */ TbImageView fgi;
    private final /* synthetic */ int fgj;
    private final /* synthetic */ float fgk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(TbImageView tbImageView, int i, float f) {
        this.fgi = tbImageView;
        this.fgj = i;
        this.fgk = f;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void s(String str, boolean z) {
        ViewGroup.LayoutParams layoutParams = this.fgi.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = this.fgj;
            layoutParams.width = (int) ((this.fgk > 0.0f ? this.fgk : 2.0f) * layoutParams.height);
            this.fgi.setLayoutParams(layoutParams);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                this.fgi.setAlpha(0.8f);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
