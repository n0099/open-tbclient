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
    private FrameLayout bTl;
    private TbImageView bTm;
    private com.baidu.tbadk.img.e bTn;
    final /* synthetic */ r bTo;
    private int index;
    private ProgressBar xM;

    public t(r rVar, int i) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        this.bTo = rVar;
        this.xM = null;
        this.index = -1;
        this.index = i;
        com.baidu.adp.lib.g.b ek = com.baidu.adp.lib.g.b.ek();
        baseActivity = rVar.Or;
        this.bTl = (FrameLayout) ek.inflate(baseActivity, com.baidu.tieba.w.progress_tb_imageview, null);
        this.bTm = (TbImageView) this.bTl.findViewById(com.baidu.tieba.v.progress_tb_imageview);
        this.bTm.setClickable(true);
        this.bTm.setDefaultResource(0);
        this.bTm.setDefaultBgResource(0);
        this.bTm.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        baseActivity2 = rVar.Or;
        this.bTn = new com.baidu.tbadk.img.e(baseActivity2);
        this.bTm.setOnClickListener(new u(this));
        this.xM = (ProgressBar) this.bTl.findViewById(com.baidu.tieba.v.progress_tb_imageview_progress);
        this.xM.setVisibility(8);
    }

    public View getView() {
        return this.bTl;
    }

    public void h(ImageFileInfo imageFileInfo) {
        adq();
        this.bTm.setDefaultResource(0);
        this.bTm.setDefaultBgResource(0);
        com.baidu.adp.widget.a.a a = this.bTn.a(imageFileInfo, false);
        if (a != null) {
            a.a(this.bTm);
            return;
        }
        eL(false);
        this.bTn.a(imageFileInfo, new v(this), false);
    }

    public void adq() {
        if (this.bTn != null) {
            this.bTn.sq();
        }
        if (this.bTm != null) {
            this.bTm.setImageDrawable(null);
        }
    }

    public boolean afl() {
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
                sVar3 = this.bTo.bTg;
                if (sVar3 != null) {
                    sVar4 = this.bTo.bTg;
                    sVar4.afk();
                }
                this.xM.setVisibility(8);
                jVarArr2 = this.bTo.bTi;
                jVarArr2[this.index].setCanbeClick(true);
            }
        } else if (this.xM.getVisibility() != 0) {
            sVar = this.bTo.bTg;
            if (sVar != null) {
                sVar2 = this.bTo.bTg;
                sVar2.afj();
            }
            this.xM.setVisibility(0);
            jVarArr = this.bTo.bTi;
            jVarArr[this.index].setCanbeClick(false);
        }
    }
}
