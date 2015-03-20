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
public class x {
    private ProgressBar byG;
    private FrameLayout cxb;
    private TbImageView cxc;
    private com.baidu.tbadk.img.e cxd;
    final /* synthetic */ v cxe;
    private int index;

    public x(v vVar, int i) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        this.cxe = vVar;
        this.byG = null;
        this.index = -1;
        this.index = i;
        com.baidu.adp.lib.g.b hH = com.baidu.adp.lib.g.b.hH();
        baseActivity = vVar.auA;
        this.cxb = (FrameLayout) hH.inflate(baseActivity.getPageContext().getContext(), com.baidu.tieba.w.progress_tb_imageview, null);
        this.cxc = (TbImageView) this.cxb.findViewById(com.baidu.tieba.v.progress_tb_imageview);
        this.cxc.setClickable(true);
        this.cxc.setDefaultResource(0);
        this.cxc.setDefaultBgResource(0);
        this.cxc.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        baseActivity2 = vVar.auA;
        this.cxd = new com.baidu.tbadk.img.e(baseActivity2.getPageContext().getContext());
        this.cxc.setOnClickListener(new y(this));
        this.byG = (ProgressBar) this.cxb.findViewById(com.baidu.tieba.v.progress_tb_imageview_progress);
        this.byG.setVisibility(8);
    }

    public View getView() {
        return this.cxb;
    }

    public void i(ImageFileInfo imageFileInfo) {
        anB();
        this.cxc.setDefaultResource(0);
        this.cxc.setDefaultBgResource(0);
        com.baidu.adp.widget.a.a a = this.cxd.a(imageFileInfo, false);
        if (a != null) {
            a.a(this.cxc);
            return;
        }
        fj(false);
        this.cxd.a(imageFileInfo, new z(this), false);
    }

    public void anB() {
        if (this.cxd != null) {
            this.cxd.zA();
        }
        if (this.cxc != null) {
            this.cxc.setImageDrawable(null);
        }
    }

    public boolean aqS() {
        return this.byG.getVisibility() != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fj(boolean z) {
        w wVar;
        com.baidu.tbadk.coreExtra.view.j[] jVarArr;
        w wVar2;
        w wVar3;
        com.baidu.tbadk.coreExtra.view.j[] jVarArr2;
        w wVar4;
        if (z) {
            if (this.byG.getVisibility() != 8) {
                wVar3 = this.cxe.cwW;
                if (wVar3 != null) {
                    wVar4 = this.cxe.cwW;
                    wVar4.aqR();
                }
                this.byG.setVisibility(8);
                jVarArr2 = this.cxe.cwY;
                jVarArr2[this.index].setCanbeClick(true);
            }
        } else if (this.byG.getVisibility() != 0) {
            wVar = this.cxe.cwW;
            if (wVar != null) {
                wVar2 = this.cxe.cwW;
                wVar2.aqQ();
            }
            this.byG.setVisibility(0);
            jVarArr = this.cxe.cwY;
            jVarArr[this.index].setCanbeClick(false);
        }
    }
}
