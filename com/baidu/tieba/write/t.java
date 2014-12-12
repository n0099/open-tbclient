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
    private FrameLayout ces;
    private TbImageView cet;
    private com.baidu.tbadk.img.e ceu;
    final /* synthetic */ r cev;
    private int index;

    public t(r rVar, int i) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        this.cev = rVar;
        this.Bs = null;
        this.index = -1;
        this.index = i;
        com.baidu.adp.lib.g.b ek = com.baidu.adp.lib.g.b.ek();
        baseActivity = rVar.Ud;
        this.ces = (FrameLayout) ek.inflate(baseActivity.getPageContext().getContext(), com.baidu.tieba.x.progress_tb_imageview, null);
        this.cet = (TbImageView) this.ces.findViewById(com.baidu.tieba.w.progress_tb_imageview);
        this.cet.setClickable(true);
        this.cet.setDefaultResource(0);
        this.cet.setDefaultBgResource(0);
        this.cet.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        baseActivity2 = rVar.Ud;
        this.ceu = new com.baidu.tbadk.img.e(baseActivity2.getPageContext().getContext());
        this.cet.setOnClickListener(new u(this));
        this.Bs = (ProgressBar) this.ces.findViewById(com.baidu.tieba.w.progress_tb_imageview_progress);
        this.Bs.setVisibility(8);
    }

    public View getView() {
        return this.ces;
    }

    public void h(ImageFileInfo imageFileInfo) {
        qm();
        this.cet.setDefaultResource(0);
        this.cet.setDefaultBgResource(0);
        com.baidu.adp.widget.a.a a = this.ceu.a(imageFileInfo, false);
        if (a != null) {
            a.a(this.cet);
            return;
        }
        eK(false);
        this.ceu.a(imageFileInfo, new v(this), false);
    }

    public void qm() {
        if (this.ceu != null) {
            this.ceu.vT();
        }
        if (this.cet != null) {
            this.cet.setImageDrawable(null);
        }
    }

    public boolean ajP() {
        return this.Bs.getVisibility() != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eK(boolean z) {
        s sVar;
        com.baidu.tbadk.coreExtra.view.j[] jVarArr;
        s sVar2;
        s sVar3;
        com.baidu.tbadk.coreExtra.view.j[] jVarArr2;
        s sVar4;
        if (z) {
            if (this.Bs.getVisibility() != 8) {
                sVar3 = this.cev.cen;
                if (sVar3 != null) {
                    sVar4 = this.cev.cen;
                    sVar4.ajO();
                }
                this.Bs.setVisibility(8);
                jVarArr2 = this.cev.cep;
                jVarArr2[this.index].setCanbeClick(true);
            }
        } else if (this.Bs.getVisibility() != 0) {
            sVar = this.cev.cen;
            if (sVar != null) {
                sVar2 = this.cev.cen;
                sVar2.ajN();
            }
            this.Bs.setVisibility(0);
            jVarArr = this.cev.cep;
            jVarArr[this.index].setCanbeClick(false);
        }
    }
}
