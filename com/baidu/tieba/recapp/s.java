package com.baidu.tieba.recapp;

import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements TbImageView.a {
    private final /* synthetic */ TbImageView eXk;
    private final /* synthetic */ int eXl;
    private final /* synthetic */ float eXm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(TbImageView tbImageView, int i, float f) {
        this.eXk = tbImageView;
        this.eXl = i;
        this.eXm = f;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void v(String str, boolean z) {
        ViewGroup.LayoutParams layoutParams = this.eXk.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = this.eXl;
            layoutParams.width = (int) ((this.eXm > 0.0f ? this.eXm : 2.0f) * layoutParams.height);
            this.eXk.setLayoutParams(layoutParams);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                this.eXk.setAlpha(0.8f);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
