package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes13.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private String aCu;
    private String aCv;
    private String[] aCx;
    private Fragment[] aoz;
    private AlbumActivity kOJ;
    private ImageListFragment kOK;
    private AlbumImageBrowseFragment kOL;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.aCu = "tag_image";
        this.aCv = "tag_b_image";
        this.kOJ = albumActivity;
    }

    public void Ay() {
        this.aoz = new Fragment[2];
        this.aCx = new String[2];
        this.kOK = new ImageListFragment();
        this.aoz[0] = this.kOK;
        this.aCx[0] = this.aCu;
        this.kOL = new AlbumImageBrowseFragment();
        this.aoz[1] = this.kOL;
        this.aCx[1] = this.aCv;
    }

    public Fragment cN(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.aoz[i];
    }

    public String cO(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.aCx[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.aoz.length) {
                if (this.aoz[i3] != null && (this.aoz[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.aoz[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView cUX() {
        if (this.kOK == null) {
            return null;
        }
        return this.kOK.cUX();
    }

    public void stopCamera() {
        TbCameraView cUX = cUX();
        if (cUX != null) {
            cUX.stopCamera();
            cUX.setVisibility(4);
        }
    }

    public void FK() {
        TbCameraView cUX = cUX();
        if (cUX != null) {
            cUX.setVisibility(0);
            cUX.tU(false);
        }
        if (this.kOK != null && this.kOK.cVc() != null) {
            this.kOK.cVc().AX();
        }
    }

    public View Az() {
        if (this.kOK == null) {
            return null;
        }
        return this.kOK.AH();
    }

    public View AA() {
        if (this.kOK == null) {
            return null;
        }
        return this.kOK.AW();
    }

    public View AB() {
        if (this.kOL == null) {
            return null;
        }
        return this.kOL.AH();
    }

    public View AC() {
        if (this.kOL == null) {
            return null;
        }
        return this.kOL.AI();
    }

    public View AD() {
        if (this.kOL == null) {
            return null;
        }
        return this.kOL.AD();
    }

    public View AE() {
        if (this.kOK == null) {
            return null;
        }
        return this.kOK.AD();
    }

    public void onDestroy() {
    }

    public void bu(boolean z) {
        if (this.kOL != null) {
            this.kOL.bu(z);
        }
        if (this.kOK != null) {
            this.kOK.bu(z);
        }
    }

    public void a(i iVar) {
        if (this.kOK != null) {
            this.kOK.a(iVar);
        }
    }
}
