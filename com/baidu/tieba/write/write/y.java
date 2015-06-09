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
    private FrameLayout cBN;
    private TbImageView cBO;
    private com.baidu.tbadk.img.e cBP;
    final /* synthetic */ w cBQ;
    private ProgressBar cml;
    private int index;

    public y(w wVar, int i) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        this.cBQ = wVar;
        this.cml = null;
        this.index = -1;
        this.index = i;
        com.baidu.adp.lib.g.b hr = com.baidu.adp.lib.g.b.hr();
        baseActivity = wVar.awm;
        this.cBN = (FrameLayout) hr.inflate(baseActivity.getPageContext().getContext(), com.baidu.tieba.r.progress_tb_imageview, null);
        this.cBO = (TbImageView) this.cBN.findViewById(com.baidu.tieba.q.progress_tb_imageview);
        this.cBO.setClickable(true);
        this.cBO.setDefaultResource(0);
        this.cBO.setDefaultBgResource(0);
        this.cBO.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        baseActivity2 = wVar.awm;
        this.cBP = new com.baidu.tbadk.img.e(baseActivity2.getPageContext().getContext());
        this.cBO.setOnClickListener(new z(this));
        this.cml = (ProgressBar) this.cBN.findViewById(com.baidu.tieba.q.progress_tb_imageview_progress);
        this.cml.setVisibility(8);
    }

    public View getView() {
        return this.cBN;
    }

    public void i(ImageFileInfo imageFileInfo) {
        apJ();
        this.cBO.setDefaultResource(0);
        this.cBO.setDefaultBgResource(0);
        com.baidu.adp.widget.a.a a = this.cBP.a(imageFileInfo, false);
        if (a != null) {
            a.a(this.cBO);
            return;
        }
        fE(false);
        this.cBP.a(imageFileInfo, new aa(this), false);
    }

    public void apJ() {
        if (this.cBP != null) {
            this.cBP.At();
        }
        if (this.cBO != null) {
            this.cBO.setImageDrawable(null);
        }
    }

    public boolean asY() {
        return this.cml.getVisibility() != 0;
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
            if (this.cml.getVisibility() != 8) {
                xVar3 = this.cBQ.cBI;
                if (xVar3 != null) {
                    xVar4 = this.cBQ.cBI;
                    xVar4.asX();
                }
                this.cml.setVisibility(8);
                jVarArr2 = this.cBQ.cBK;
                jVarArr2[this.index].setCanbeClick(true);
            }
        } else if (this.cml.getVisibility() != 0) {
            xVar = this.cBQ.cBI;
            if (xVar != null) {
                xVar2 = this.cBQ.cBI;
                xVar2.asW();
            }
            this.cml.setVisibility(0);
            jVarArr = this.cBQ.cBK;
            jVarArr[this.index].setCanbeClick(false);
        }
    }
}
