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
    private ProgressBar Bs;
    private FrameLayout cfR;
    private TbImageView cfS;
    private com.baidu.tbadk.img.e cfT;
    final /* synthetic */ r cfU;
    private int index;

    public t(r rVar, int i) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        this.cfU = rVar;
        this.Bs = null;
        this.index = -1;
        this.index = i;
        com.baidu.adp.lib.g.b ei = com.baidu.adp.lib.g.b.ei();
        baseActivity = rVar.UJ;
        this.cfR = (FrameLayout) ei.inflate(baseActivity.getPageContext().getContext(), com.baidu.tieba.x.progress_tb_imageview, null);
        this.cfS = (TbImageView) this.cfR.findViewById(com.baidu.tieba.w.progress_tb_imageview);
        this.cfS.setClickable(true);
        this.cfS.setDefaultResource(0);
        this.cfS.setDefaultBgResource(0);
        this.cfS.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        baseActivity2 = rVar.UJ;
        this.cfT = new com.baidu.tbadk.img.e(baseActivity2.getPageContext().getContext());
        this.cfS.setOnClickListener(new u(this));
        this.Bs = (ProgressBar) this.cfR.findViewById(com.baidu.tieba.w.progress_tb_imageview_progress);
        this.Bs.setVisibility(8);
    }

    public View getView() {
        return this.cfR;
    }

    public void h(ImageFileInfo imageFileInfo) {
        qx();
        this.cfS.setDefaultResource(0);
        this.cfS.setDefaultBgResource(0);
        com.baidu.adp.widget.a.a a = this.cfT.a(imageFileInfo, false);
        if (a != null) {
            a.a(this.cfS);
            return;
        }
        eP(false);
        this.cfT.a(imageFileInfo, new v(this), false);
    }

    public void qx() {
        if (this.cfT != null) {
            this.cfT.wm();
        }
        if (this.cfS != null) {
            this.cfS.setImageDrawable(null);
        }
    }

    public boolean akm() {
        return this.Bs.getVisibility() != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eP(boolean z) {
        s sVar;
        com.baidu.tbadk.coreExtra.view.j[] jVarArr;
        s sVar2;
        s sVar3;
        com.baidu.tbadk.coreExtra.view.j[] jVarArr2;
        s sVar4;
        if (z) {
            if (this.Bs.getVisibility() != 8) {
                sVar3 = this.cfU.cfM;
                if (sVar3 != null) {
                    sVar4 = this.cfU.cfM;
                    sVar4.akl();
                }
                this.Bs.setVisibility(8);
                jVarArr2 = this.cfU.cfO;
                jVarArr2[this.index].setCanbeClick(true);
            }
        } else if (this.Bs.getVisibility() != 0) {
            sVar = this.cfU.cfM;
            if (sVar != null) {
                sVar2 = this.cfU.cfM;
                sVar2.akk();
            }
            this.Bs.setVisibility(0);
            jVarArr = this.cfU.cfO;
            jVarArr[this.index].setCanbeClick(false);
        }
    }
}
