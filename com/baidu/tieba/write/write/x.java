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
    private ProgressBar cij;
    private FrameLayout cxu;
    private TbImageView cxv;
    private com.baidu.tbadk.img.e cxw;
    final /* synthetic */ v cxx;
    private int index;

    public x(v vVar, int i) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        this.cxx = vVar;
        this.cij = null;
        this.index = -1;
        this.index = i;
        com.baidu.adp.lib.g.b hH = com.baidu.adp.lib.g.b.hH();
        baseActivity = vVar.auI;
        this.cxu = (FrameLayout) hH.inflate(baseActivity.getPageContext().getContext(), com.baidu.tieba.w.progress_tb_imageview, null);
        this.cxv = (TbImageView) this.cxu.findViewById(com.baidu.tieba.v.progress_tb_imageview);
        this.cxv.setClickable(true);
        this.cxv.setDefaultResource(0);
        this.cxv.setDefaultBgResource(0);
        this.cxv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        baseActivity2 = vVar.auI;
        this.cxw = new com.baidu.tbadk.img.e(baseActivity2.getPageContext().getContext());
        this.cxv.setOnClickListener(new y(this));
        this.cij = (ProgressBar) this.cxu.findViewById(com.baidu.tieba.v.progress_tb_imageview_progress);
        this.cij.setVisibility(8);
    }

    public View getView() {
        return this.cxu;
    }

    public void i(ImageFileInfo imageFileInfo) {
        anQ();
        this.cxv.setDefaultResource(0);
        this.cxv.setDefaultBgResource(0);
        com.baidu.adp.widget.a.a a = this.cxw.a(imageFileInfo, false);
        if (a != null) {
            a.a(this.cxv);
            return;
        }
        fi(false);
        this.cxw.a(imageFileInfo, new z(this), false);
    }

    public void anQ() {
        if (this.cxw != null) {
            this.cxw.zG();
        }
        if (this.cxv != null) {
            this.cxv.setImageDrawable(null);
        }
    }

    public boolean arh() {
        return this.cij.getVisibility() != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fi(boolean z) {
        w wVar;
        com.baidu.tbadk.coreExtra.view.j[] jVarArr;
        w wVar2;
        w wVar3;
        com.baidu.tbadk.coreExtra.view.j[] jVarArr2;
        w wVar4;
        if (z) {
            if (this.cij.getVisibility() != 8) {
                wVar3 = this.cxx.cxp;
                if (wVar3 != null) {
                    wVar4 = this.cxx.cxp;
                    wVar4.arg();
                }
                this.cij.setVisibility(8);
                jVarArr2 = this.cxx.cxr;
                jVarArr2[this.index].setCanbeClick(true);
            }
        } else if (this.cij.getVisibility() != 0) {
            wVar = this.cxx.cxp;
            if (wVar != null) {
                wVar2 = this.cxx.cxp;
                wVar2.arf();
            }
            this.cij.setVisibility(0);
            jVarArr = this.cxx.cxr;
            jVarArr[this.index].setCanbeClick(false);
        }
    }
}
