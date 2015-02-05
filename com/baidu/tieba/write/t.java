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
    private ProgressBar Bp;
    private FrameLayout cfQ;
    private TbImageView cfR;
    private com.baidu.tbadk.img.e cfS;
    final /* synthetic */ r cfT;
    private int index;

    public t(r rVar, int i) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        this.cfT = rVar;
        this.Bp = null;
        this.index = -1;
        this.index = i;
        com.baidu.adp.lib.g.b ei = com.baidu.adp.lib.g.b.ei();
        baseActivity = rVar.UG;
        this.cfQ = (FrameLayout) ei.inflate(baseActivity.getPageContext().getContext(), com.baidu.tieba.x.progress_tb_imageview, null);
        this.cfR = (TbImageView) this.cfQ.findViewById(com.baidu.tieba.w.progress_tb_imageview);
        this.cfR.setClickable(true);
        this.cfR.setDefaultResource(0);
        this.cfR.setDefaultBgResource(0);
        this.cfR.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        baseActivity2 = rVar.UG;
        this.cfS = new com.baidu.tbadk.img.e(baseActivity2.getPageContext().getContext());
        this.cfR.setOnClickListener(new u(this));
        this.Bp = (ProgressBar) this.cfQ.findViewById(com.baidu.tieba.w.progress_tb_imageview_progress);
        this.Bp.setVisibility(8);
    }

    public View getView() {
        return this.cfQ;
    }

    public void h(ImageFileInfo imageFileInfo) {
        qq();
        this.cfR.setDefaultResource(0);
        this.cfR.setDefaultBgResource(0);
        com.baidu.adp.widget.a.a a = this.cfS.a(imageFileInfo, false);
        if (a != null) {
            a.a(this.cfR);
            return;
        }
        eP(false);
        this.cfS.a(imageFileInfo, new v(this), false);
    }

    public void qq() {
        if (this.cfS != null) {
            this.cfS.wg();
        }
        if (this.cfR != null) {
            this.cfR.setImageDrawable(null);
        }
    }

    public boolean akh() {
        return this.Bp.getVisibility() != 0;
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
            if (this.Bp.getVisibility() != 8) {
                sVar3 = this.cfT.cfL;
                if (sVar3 != null) {
                    sVar4 = this.cfT.cfL;
                    sVar4.akg();
                }
                this.Bp.setVisibility(8);
                jVarArr2 = this.cfT.cfN;
                jVarArr2[this.index].setCanbeClick(true);
            }
        } else if (this.Bp.getVisibility() != 0) {
            sVar = this.cfT.cfL;
            if (sVar != null) {
                sVar2 = this.cfT.cfL;
                sVar2.akf();
            }
            this.Bp.setVisibility(0);
            jVarArr = this.cfT.cfN;
            jVarArr[this.index].setCanbeClick(false);
        }
    }
}
