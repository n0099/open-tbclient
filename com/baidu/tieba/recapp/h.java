package com.baidu.tieba.recapp;

import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements TbImageView.a {
    private final /* synthetic */ TbImageView fcY;
    private final /* synthetic */ int fcZ;
    private final /* synthetic */ float fda;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(TbImageView tbImageView, int i, float f) {
        this.fcY = tbImageView;
        this.fcZ = i;
        this.fda = f;
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void v(String str, boolean z) {
        ViewGroup.LayoutParams layoutParams = this.fcY.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = this.fcZ;
            layoutParams.width = (int) ((this.fda > 0.0f ? this.fda : 2.0f) * layoutParams.height);
            this.fcY.setLayoutParams(layoutParams);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                this.fcY.setAlpha(0.8f);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView.a
    public void onCancel() {
    }
}
