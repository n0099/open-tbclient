package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] aPo;
    private String biQ;
    private String biR;
    private TbPageContext hoE;
    private e mmJ;
    private String[] mmK;
    private ImageListFragment mmL;
    private AlbumImageBrowseFragment mmM;

    public a(TbPageContext tbPageContext, e eVar) {
        super(tbPageContext);
        this.biQ = "tag_image";
        this.biR = "tag_b_image";
        this.hoE = tbPageContext;
        this.mmJ = eVar;
    }

    public void IC() {
        this.aPo = new Fragment[2];
        this.mmK = new String[2];
        this.mmL = new ImageListFragment();
        this.mmL.a(this.mmJ);
        this.aPo[0] = this.mmL;
        this.mmK[0] = this.biQ;
        this.mmM = new AlbumImageBrowseFragment();
        this.mmM.a(this.mmJ);
        this.aPo[1] = this.mmM;
        this.mmK[1] = this.biR;
    }

    public Fragment GE(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.aPo[i];
    }

    public String GF(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.mmK[i];
    }

    public void a(NavigationBar navigationBar) {
        this.mmL.a(navigationBar);
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.aPo.length) {
                if (this.aPo[i3] != null && (this.aPo[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.aPo[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView drk() {
        if (this.mmL == null) {
            return null;
        }
        return this.mmL.drk();
    }

    public void stopCamera() {
        TbCameraView drk = drk();
        if (drk != null) {
            drk.stopCamera();
            drk.setVisibility(4);
        }
    }

    public void QO() {
        TbCameraView drk = drk();
        if (drk != null) {
            drk.setVisibility(0);
            drk.vM(false);
        }
        if (this.mmL != null && this.mmL.drv() != null) {
            this.mmL.drv().Ja();
        }
    }

    public void drl() {
        if (this.mmL != null) {
            this.mmL.IY();
        }
    }

    public View ID() {
        if (this.mmL == null) {
            return null;
        }
        return this.mmL.IV();
    }

    public View IE() {
        if (this.mmL == null) {
            return null;
        }
        return this.mmL.IZ();
    }

    public View IF() {
        if (this.mmM == null) {
            return null;
        }
        return this.mmM.IV();
    }

    public View IG() {
        if (this.mmM == null) {
            return null;
        }
        return this.mmM.IW();
    }

    public View IH() {
        if (this.mmM == null) {
            return null;
        }
        return this.mmM.IH();
    }

    public View II() {
        if (this.mmL == null) {
            return null;
        }
        return this.mmL.IH();
    }

    public void onDestroy() {
    }

    public ImageListFragment drm() {
        return this.mmL;
    }

    public void cn(boolean z) {
        if (this.mmM != null) {
            this.mmM.cn(z);
        }
        if (this.mmL != null) {
            this.mmL.cn(z);
        }
    }

    public void a(j jVar) {
        if (this.mmL != null) {
            this.mmL.a(jVar);
        }
    }
}
