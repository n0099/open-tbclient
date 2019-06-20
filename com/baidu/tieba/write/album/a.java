package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] dpJ;
    private String jFQ;
    private String jFR;
    private AlbumActivity jFS;
    private String[] jFT;
    private ImageListFragment jFU;
    private AlbumImageBrowseFragment jFV;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.jFQ = "tag_image";
        this.jFR = "tag_b_image";
        this.jFS = albumActivity;
    }

    public void brm() {
        this.dpJ = new Fragment[2];
        this.jFT = new String[2];
        this.jFU = new ImageListFragment();
        this.dpJ[0] = this.jFU;
        this.jFT[0] = this.jFQ;
        this.jFV = new AlbumImageBrowseFragment();
        this.dpJ[1] = this.jFV;
        this.jFT[1] = this.jFR;
    }

    public Fragment Ck(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.dpJ[i];
    }

    public String Cl(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.jFT[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.dpJ.length) {
                if (this.dpJ[i3] != null && (this.dpJ[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.dpJ[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView cwR() {
        if (this.jFU == null) {
            return null;
        }
        return this.jFU.cwR();
    }

    public void stopCamera() {
        TbCameraView cwR = cwR();
        if (cwR != null) {
            cwR.stopCamera();
            cwR.setVisibility(4);
        }
    }

    public void aWY() {
        TbCameraView cwR = cwR();
        if (cwR != null) {
            cwR.setVisibility(0);
            cwR.rT(false);
        }
        if (this.jFU != null && this.jFU.cxp() != null) {
            this.jFU.cxp().cxt();
        }
    }

    public View cwS() {
        if (this.jFU == null) {
            return null;
        }
        return this.jFU.chX();
    }

    public View cwT() {
        if (this.jFU == null) {
            return null;
        }
        return this.jFU.cxo();
    }

    public View cwU() {
        if (this.jFV == null) {
            return null;
        }
        return this.jFV.chX();
    }

    public View cwV() {
        if (this.jFV == null) {
            return null;
        }
        return this.jFV.cxa();
    }

    public View cwW() {
        if (this.jFV == null) {
            return null;
        }
        return this.jFV.cwW();
    }

    public View cwX() {
        if (this.jFU == null) {
            return null;
        }
        return this.jFU.cwW();
    }

    public void onDestroy() {
    }

    public void rP(boolean z) {
        if (this.jFV != null) {
            this.jFV.rP(z);
        }
        if (this.jFU != null) {
            this.jFU.rP(z);
        }
    }

    public void a(i iVar) {
        if (this.jFU != null) {
            this.jFU.a(iVar);
        }
    }
}
