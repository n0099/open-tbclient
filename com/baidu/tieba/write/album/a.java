package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] aGS;
    private String aWb;
    private String aWc;
    private String[] aWe;
    private AlbumActivity lya;
    private ImageListFragment lyb;
    private AlbumImageBrowseFragment lyc;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.aWb = "tag_image";
        this.aWc = "tag_b_image";
        this.lya = albumActivity;
    }

    public void Fw() {
        this.aGS = new Fragment[2];
        this.aWe = new String[2];
        this.lyb = new ImageListFragment();
        this.aGS[0] = this.lyb;
        this.aWe[0] = this.aWb;
        this.lyc = new AlbumImageBrowseFragment();
        this.aGS[1] = this.lyc;
        this.aWe[1] = this.aWc;
    }

    public Fragment dc(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.aGS[i];
    }

    public String dd(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.aWe[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.aGS.length) {
                if (this.aGS[i3] != null && (this.aGS[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.aGS[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView dft() {
        if (this.lyb == null) {
            return null;
        }
        return this.lyb.dft();
    }

    public void stopCamera() {
        TbCameraView dft = dft();
        if (dft != null) {
            dft.stopCamera();
            dft.setVisibility(4);
        }
    }

    public void Nw() {
        TbCameraView dft = dft();
        if (dft != null) {
            dft.setVisibility(0);
            dft.uU(false);
        }
        if (this.lyb != null && this.lyb.dfy() != null) {
            this.lyb.dfy().FV();
        }
    }

    public View Fx() {
        if (this.lyb == null) {
            return null;
        }
        return this.lyb.FF();
    }

    public View Fy() {
        if (this.lyb == null) {
            return null;
        }
        return this.lyb.FU();
    }

    public View Fz() {
        if (this.lyc == null) {
            return null;
        }
        return this.lyc.FF();
    }

    public View FA() {
        if (this.lyc == null) {
            return null;
        }
        return this.lyc.FG();
    }

    public View FB() {
        if (this.lyc == null) {
            return null;
        }
        return this.lyc.FB();
    }

    public View FC() {
        if (this.lyb == null) {
            return null;
        }
        return this.lyb.FB();
    }

    public void onDestroy() {
    }

    public void bY(boolean z) {
        if (this.lyc != null) {
            this.lyc.bY(z);
        }
        if (this.lyb != null) {
            this.lyb.bY(z);
        }
    }

    public void a(i iVar) {
        if (this.lyb != null) {
            this.lyb.a(iVar);
        }
    }
}
