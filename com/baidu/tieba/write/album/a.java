package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] drR;
    private String jMT;
    private String jMU;
    private AlbumActivity jMV;
    private String[] jMW;
    private ImageListFragment jMX;
    private AlbumImageBrowseFragment jMY;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.jMT = "tag_image";
        this.jMU = "tag_b_image";
        this.jMV = albumActivity;
    }

    public void btn() {
        this.drR = new Fragment[2];
        this.jMW = new String[2];
        this.jMX = new ImageListFragment();
        this.drR[0] = this.jMX;
        this.jMW[0] = this.jMT;
        this.jMY = new AlbumImageBrowseFragment();
        this.drR[1] = this.jMY;
        this.jMW[1] = this.jMU;
    }

    public Fragment CR(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.drR[i];
    }

    public String CS(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.jMW[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.drR.length) {
                if (this.drR[i3] != null && (this.drR[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.drR[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView czS() {
        if (this.jMX == null) {
            return null;
        }
        return this.jMX.czS();
    }

    public void stopCamera() {
        TbCameraView czS = czS();
        if (czS != null) {
            czS.stopCamera();
            czS.setVisibility(4);
        }
    }

    public void aYU() {
        TbCameraView czS = czS();
        if (czS != null) {
            czS.setVisibility(0);
            czS.si(false);
        }
        if (this.jMX != null && this.jMX.cAq() != null) {
            this.jMX.cAq().cAu();
        }
    }

    public View czT() {
        if (this.jMX == null) {
            return null;
        }
        return this.jMX.ckO();
    }

    public View czU() {
        if (this.jMX == null) {
            return null;
        }
        return this.jMX.cAp();
    }

    public View czV() {
        if (this.jMY == null) {
            return null;
        }
        return this.jMY.ckO();
    }

    public View czW() {
        if (this.jMY == null) {
            return null;
        }
        return this.jMY.cAb();
    }

    public View czX() {
        if (this.jMY == null) {
            return null;
        }
        return this.jMY.czX();
    }

    public View czY() {
        if (this.jMX == null) {
            return null;
        }
        return this.jMX.czX();
    }

    public void onDestroy() {
    }

    public void se(boolean z) {
        if (this.jMY != null) {
            this.jMY.se(z);
        }
        if (this.jMX != null) {
            this.jMX.se(z);
        }
    }

    public void a(i iVar) {
        if (this.jMX != null) {
            this.jMX.a(iVar);
        }
    }
}
