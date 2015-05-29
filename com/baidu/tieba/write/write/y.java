package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y {
    private FrameLayout cBM;
    private TbImageView cBN;
    private com.baidu.tbadk.img.e cBO;
    final /* synthetic */ w cBP;
    private ProgressBar cmk;
    private int index;

    public y(w wVar, int i) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        this.cBP = wVar;
        this.cmk = null;
        this.index = -1;
        this.index = i;
        com.baidu.adp.lib.g.b hr = com.baidu.adp.lib.g.b.hr();
        baseActivity = wVar.awl;
        this.cBM = (FrameLayout) hr.inflate(baseActivity.getPageContext().getContext(), com.baidu.tieba.r.progress_tb_imageview, null);
        this.cBN = (TbImageView) this.cBM.findViewById(com.baidu.tieba.q.progress_tb_imageview);
        this.cBN.setClickable(true);
        this.cBN.setDefaultResource(0);
        this.cBN.setDefaultBgResource(0);
        this.cBN.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        baseActivity2 = wVar.awl;
        this.cBO = new com.baidu.tbadk.img.e(baseActivity2.getPageContext().getContext());
        this.cBN.setOnClickListener(new z(this));
        this.cmk = (ProgressBar) this.cBM.findViewById(com.baidu.tieba.q.progress_tb_imageview_progress);
        this.cmk.setVisibility(8);
    }

    public View getView() {
        return this.cBM;
    }

    public void i(ImageFileInfo imageFileInfo) {
        apI();
        this.cBN.setDefaultResource(0);
        this.cBN.setDefaultBgResource(0);
        com.baidu.adp.widget.a.a a = this.cBO.a(imageFileInfo, false);
        if (a != null) {
            a.a(this.cBN);
            return;
        }
        fE(false);
        this.cBO.a(imageFileInfo, new aa(this), false);
    }

    public void apI() {
        if (this.cBO != null) {
            this.cBO.As();
        }
        if (this.cBN != null) {
            this.cBN.setImageDrawable(null);
        }
    }

    public boolean asX() {
        return this.cmk.getVisibility() != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fE(boolean z) {
        x xVar;
        com.baidu.tbadk.coreExtra.view.j[] jVarArr;
        x xVar2;
        x xVar3;
        com.baidu.tbadk.coreExtra.view.j[] jVarArr2;
        x xVar4;
        if (z) {
            if (this.cmk.getVisibility() != 8) {
                xVar3 = this.cBP.cBH;
                if (xVar3 != null) {
                    xVar4 = this.cBP.cBH;
                    xVar4.asW();
                }
                this.cmk.setVisibility(8);
                jVarArr2 = this.cBP.cBJ;
                jVarArr2[this.index].setCanbeClick(true);
            }
        } else if (this.cmk.getVisibility() != 0) {
            xVar = this.cBP.cBH;
            if (xVar != null) {
                xVar2 = this.cBP.cBH;
                xVar2.asV();
            }
            this.cmk.setVisibility(0);
            jVarArr = this.cBP.cBJ;
            jVarArr[this.index].setCanbeClick(false);
        }
    }
}
