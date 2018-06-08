package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] btX;
    private String hou;
    private String hov;
    private AlbumActivity how;
    private String[] hox;
    private ImageListFragment hoy;
    private AlbumImageBrowseFragment hoz;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.hou = "tag_image";
        this.hov = "tag_b_image";
        this.how = albumActivity;
    }

    public void aYL() {
        this.btX = new Fragment[2];
        this.hox = new String[2];
        this.hoy = new ImageListFragment();
        this.btX[0] = this.hoy;
        this.hox[0] = this.hou;
        this.hoz = new AlbumImageBrowseFragment();
        this.btX[1] = this.hoz;
        this.hox[1] = this.hov;
    }

    public Fragment vg(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.btX[i];
    }

    public String vh(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.hox[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.btX.length) {
                if (this.btX[i3] != null && (this.btX[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.btX[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView bGx() {
        if (this.hoy == null) {
            return null;
        }
        return this.hoy.bGx();
    }

    public void stopCamera() {
        TbCameraView bGx = bGx();
        if (bGx != null) {
            bGx.stopCamera();
            bGx.setVisibility(4);
        }
    }

    public void bGw() {
        TbCameraView bGx = bGx();
        if (bGx != null) {
            bGx.setVisibility(0);
            bGx.nA(false);
        }
        if (this.hoy != null && this.hoy.bGV() != null) {
            this.hoy.bGV().bHa();
        }
    }

    public View bGy() {
        if (this.hoy == null) {
            return null;
        }
        return this.hoy.brt();
    }

    public View bGz() {
        if (this.hoy == null) {
            return null;
        }
        return this.hoy.bGU();
    }

    public View bGA() {
        if (this.hoz == null) {
            return null;
        }
        return this.hoz.brt();
    }

    public View bGB() {
        if (this.hoz == null) {
            return null;
        }
        return this.hoz.bGG();
    }

    public View bGC() {
        if (this.hoz == null) {
            return null;
        }
        return this.hoz.bGC();
    }

    public View bGD() {
        if (this.hoy == null) {
            return null;
        }
        return this.hoy.bGC();
    }

    public void onDestroy() {
    }

    public void nw(boolean z) {
        if (this.hoz != null) {
            this.hoz.nw(z);
        }
        if (this.hoy != null) {
            this.hoy.nw(z);
        }
    }

    public void a(i iVar) {
        if (this.hoy != null) {
            this.hoy.a(iVar);
        }
    }
}
