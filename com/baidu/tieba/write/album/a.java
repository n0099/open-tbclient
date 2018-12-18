package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] bOX;
    private String hRR;
    private String hRS;
    private AlbumActivity hRT;
    private String[] hRU;
    private ImageListFragment hRV;
    private AlbumImageBrowseFragment hRW;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.hRR = "tag_image";
        this.hRS = "tag_b_image";
        this.hRT = albumActivity;
    }

    public void aHJ() {
        this.bOX = new Fragment[2];
        this.hRU = new String[2];
        this.hRV = new ImageListFragment();
        this.bOX[0] = this.hRV;
        this.hRU[0] = this.hRR;
        this.hRW = new AlbumImageBrowseFragment();
        this.bOX[1] = this.hRW;
        this.hRU[1] = this.hRS;
    }

    public Fragment xb(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.bOX[i];
    }

    public String xc(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.hRU[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bOX.length) {
                if (this.bOX[i3] != null && (this.bOX[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.bOX[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView bNt() {
        if (this.hRV == null) {
            return null;
        }
        return this.hRV.bNt();
    }

    public void stopCamera() {
        TbCameraView bNt = bNt();
        if (bNt != null) {
            bNt.stopCamera();
            bNt.setVisibility(4);
        }
    }

    public void bNs() {
        TbCameraView bNt = bNt();
        if (bNt != null) {
            bNt.setVisibility(0);
            bNt.oz(false);
        }
        if (this.hRV != null && this.hRV.bNR() != null) {
            this.hRV.bNR().bNW();
        }
    }

    public View bNu() {
        if (this.hRV == null) {
            return null;
        }
        return this.hRV.bxE();
    }

    public View bNv() {
        if (this.hRV == null) {
            return null;
        }
        return this.hRV.bNQ();
    }

    public View bNw() {
        if (this.hRW == null) {
            return null;
        }
        return this.hRW.bxE();
    }

    public View bNx() {
        if (this.hRW == null) {
            return null;
        }
        return this.hRW.bNC();
    }

    public View bNy() {
        if (this.hRW == null) {
            return null;
        }
        return this.hRW.bNy();
    }

    public View bNz() {
        if (this.hRV == null) {
            return null;
        }
        return this.hRV.bNy();
    }

    public void onDestroy() {
    }

    public void ov(boolean z) {
        if (this.hRW != null) {
            this.hRW.ov(z);
        }
        if (this.hRV != null) {
            this.hRV.ov(z);
        }
    }

    public void a(i iVar) {
        if (this.hRV != null) {
            this.hRV.a(iVar);
        }
    }
}
