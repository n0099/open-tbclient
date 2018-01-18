package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] bZu;
    private String hCR;
    private String hCS;
    private AlbumActivity hCT;
    private String[] hCU;
    private k hCV;
    private b hCW;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.hCR = "tag_image";
        this.hCS = "tag_b_image";
        this.hCT = albumActivity;
    }

    public void aXg() {
        this.bZu = new Fragment[2];
        this.hCU = new String[2];
        this.hCV = new k();
        this.bZu[0] = this.hCV;
        this.hCU[0] = this.hCR;
        this.hCW = new b();
        this.bZu[1] = this.hCW;
        this.hCU[1] = this.hCS;
    }

    public Fragment xl(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.bZu[i];
    }

    public String xm(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.hCU[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bZu.length) {
                if (this.bZu[i3] != null && (this.bZu[i3] instanceof k)) {
                    ((k) this.bZu[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView bFm() {
        if (this.hCV == null) {
            return null;
        }
        return this.hCV.bFm();
    }

    public void stopCamera() {
        TbCameraView bFm = bFm();
        if (bFm != null) {
            bFm.stopCamera();
            bFm.setVisibility(4);
        }
    }

    public void bFl() {
        TbCameraView bFm = bFm();
        if (bFm != null) {
            bFm.setVisibility(0);
            bFm.ny(false);
        }
        if (this.hCV != null && this.hCV.bFK() != null) {
            this.hCV.bFK().bFP();
        }
    }

    public View bFn() {
        if (this.hCV == null) {
            return null;
        }
        return this.hCV.bpP();
    }

    public View bFo() {
        if (this.hCV == null) {
            return null;
        }
        return this.hCV.bFJ();
    }

    public View bFp() {
        if (this.hCW == null) {
            return null;
        }
        return this.hCW.bpP();
    }

    public View bFq() {
        if (this.hCW == null) {
            return null;
        }
        return this.hCW.bFv();
    }

    public View bFr() {
        if (this.hCW == null) {
            return null;
        }
        return this.hCW.bFr();
    }

    public View bFs() {
        if (this.hCV == null) {
            return null;
        }
        return this.hCV.bFr();
    }

    public void onDestroy() {
    }

    public void nu(boolean z) {
        if (this.hCW != null) {
            this.hCW.nu(z);
        }
        if (this.hCV != null) {
            this.hCV.nu(z);
        }
    }

    public void a(l lVar) {
        if (this.hCV != null) {
            this.hCV.a(lVar);
        }
    }
}
