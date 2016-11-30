package com.baidu.tieba.recapp;

import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements TbImageView.a {
    private final /* synthetic */ TbImageView fkk;
    private final /* synthetic */ int fkl;
    private final /* synthetic */ float fkm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(TbImageView tbImageView, int i, float f) {
        this.fkk = tbImageView;
        this.fkl = i;
        this.fkm = f;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void v(String str, boolean z) {
        ViewGroup.LayoutParams layoutParams = this.fkk.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = this.fkl;
            layoutParams.width = (int) ((this.fkm > 0.0f ? this.fkm : 2.0f) * layoutParams.height);
            this.fkk.setLayoutParams(layoutParams);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                this.fkk.setAlpha(0.8f);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
