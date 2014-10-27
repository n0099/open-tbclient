package com.baidu.tieba.write;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t {
    private FrameLayout bSW;
    private TbImageView bSX;
    private com.baidu.tbadk.img.e bSY;
    final /* synthetic */ r bSZ;
    private int index;
    private ProgressBar xM;

    public t(r rVar, int i) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        this.bSZ = rVar;
        this.xM = null;
        this.index = -1;
        this.index = i;
        com.baidu.adp.lib.g.b ek = com.baidu.adp.lib.g.b.ek();
        baseActivity = rVar.On;
        this.bSW = (FrameLayout) ek.inflate(baseActivity, com.baidu.tieba.w.progress_tb_imageview, null);
        this.bSX = (TbImageView) this.bSW.findViewById(com.baidu.tieba.v.progress_tb_imageview);
        this.bSX.setClickable(true);
        this.bSX.setDefaultResource(0);
        this.bSX.setDefaultBgResource(0);
        this.bSX.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        baseActivity2 = rVar.On;
        this.bSY = new com.baidu.tbadk.img.e(baseActivity2);
        this.bSX.setOnClickListener(new u(this));
        this.xM = (ProgressBar) this.bSW.findViewById(com.baidu.tieba.v.progress_tb_imageview_progress);
        this.xM.setVisibility(8);
    }

    public View getView() {
        return this.bSW;
    }

    public void h(ImageFileInfo imageFileInfo) {
        adn();
        this.bSX.setDefaultResource(0);
        this.bSX.setDefaultBgResource(0);
        com.baidu.adp.widget.a.a a = this.bSY.a(imageFileInfo, false);
        if (a != null) {
            a.a(this.bSX);
            return;
        }
        eL(false);
        this.bSY.a(imageFileInfo, new v(this), false);
    }

    public void adn() {
        if (this.bSY != null) {
            this.bSY.so();
        }
        if (this.bSX != null) {
            this.bSX.setImageDrawable(null);
        }
    }

    public boolean afi() {
        return this.xM.getVisibility() != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eL(boolean z) {
        s sVar;
        com.baidu.tbadk.coreExtra.view.j[] jVarArr;
        s sVar2;
        s sVar3;
        com.baidu.tbadk.coreExtra.view.j[] jVarArr2;
        s sVar4;
        if (z) {
            if (this.xM.getVisibility() != 8) {
                sVar3 = this.bSZ.bSR;
                if (sVar3 != null) {
                    sVar4 = this.bSZ.bSR;
                    sVar4.afh();
                }
                this.xM.setVisibility(8);
                jVarArr2 = this.bSZ.bST;
                jVarArr2[this.index].setCanbeClick(true);
            }
        } else if (this.xM.getVisibility() != 0) {
            sVar = this.bSZ.bSR;
            if (sVar != null) {
                sVar2 = this.bSZ.bSR;
                sVar2.afg();
            }
            this.xM.setVisibility(0);
            jVarArr = this.bSZ.bST;
            jVarArr[this.index].setCanbeClick(false);
        }
    }
}
