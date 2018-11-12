package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] bLi;
    private String hKG;
    private String hKH;
    private AlbumActivity hKI;
    private String[] hKJ;
    private ImageListFragment hKK;
    private AlbumImageBrowseFragment hKL;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.hKG = "tag_image";
        this.hKH = "tag_b_image";
        this.hKI = albumActivity;
    }

    public void aFX() {
        this.bLi = new Fragment[2];
        this.hKJ = new String[2];
        this.hKK = new ImageListFragment();
        this.bLi[0] = this.hKK;
        this.hKJ[0] = this.hKG;
        this.hKL = new AlbumImageBrowseFragment();
        this.bLi[1] = this.hKL;
        this.hKJ[1] = this.hKH;
    }

    public Fragment wE(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.bLi[i];
    }

    public String wF(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.hKJ[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bLi.length) {
                if (this.bLi[i3] != null && (this.bLi[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.bLi[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView bLo() {
        if (this.hKK == null) {
            return null;
        }
        return this.hKK.bLo();
    }

    public void stopCamera() {
        TbCameraView bLo = bLo();
        if (bLo != null) {
            bLo.stopCamera();
            bLo.setVisibility(4);
        }
    }

    public void bLn() {
        TbCameraView bLo = bLo();
        if (bLo != null) {
            bLo.setVisibility(0);
            bLo.ox(false);
        }
        if (this.hKK != null && this.hKK.bLM() != null) {
            this.hKK.bLM().bLR();
        }
    }

    public View bLp() {
        if (this.hKK == null) {
            return null;
        }
        return this.hKK.bvM();
    }

    public View bLq() {
        if (this.hKK == null) {
            return null;
        }
        return this.hKK.bLL();
    }

    public View bLr() {
        if (this.hKL == null) {
            return null;
        }
        return this.hKL.bvM();
    }

    public View bLs() {
        if (this.hKL == null) {
            return null;
        }
        return this.hKL.bLx();
    }

    public View bLt() {
        if (this.hKL == null) {
            return null;
        }
        return this.hKL.bLt();
    }

    public View bLu() {
        if (this.hKK == null) {
            return null;
        }
        return this.hKK.bLt();
    }

    public void onDestroy() {
    }

    public void ot(boolean z) {
        if (this.hKL != null) {
            this.hKL.ot(z);
        }
        if (this.hKK != null) {
            this.hKK.ot(z);
        }
    }

    public void a(i iVar) {
        if (this.hKK != null) {
            this.hKK.a(iVar);
        }
    }
}
