package com.baidu.tieba.recapp;

import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements TbImageView.a {
    private final /* synthetic */ TbImageView eXr;
    private final /* synthetic */ int eXs;
    private final /* synthetic */ float eXt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(TbImageView tbImageView, int i, float f) {
        this.eXr = tbImageView;
        this.eXs = i;
        this.eXt = f;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void v(String str, boolean z) {
        ViewGroup.LayoutParams layoutParams = this.eXr.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = this.eXs;
            layoutParams.width = (int) ((this.eXt > 0.0f ? this.eXt : 2.0f) * layoutParams.height);
            this.eXr.setLayoutParams(layoutParams);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                this.eXr.setAlpha(0.8f);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
