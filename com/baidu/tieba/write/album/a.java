package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] bPa;
    private String hVc;
    private String hVd;
    private AlbumActivity hVe;
    private String[] hVf;
    private ImageListFragment hVg;
    private AlbumImageBrowseFragment hVh;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.hVc = "tag_image";
        this.hVd = "tag_b_image";
        this.hVe = albumActivity;
    }

    public void aIy() {
        this.bPa = new Fragment[2];
        this.hVf = new String[2];
        this.hVg = new ImageListFragment();
        this.bPa[0] = this.hVg;
        this.hVf[0] = this.hVc;
        this.hVh = new AlbumImageBrowseFragment();
        this.bPa[1] = this.hVh;
        this.hVf[1] = this.hVd;
    }

    public Fragment xo(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.bPa[i];
    }

    public String xp(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.hVf[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bPa.length) {
                if (this.bPa[i3] != null && (this.bPa[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.bPa[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView bOk() {
        if (this.hVg == null) {
            return null;
        }
        return this.hVg.bOk();
    }

    public void stopCamera() {
        TbCameraView bOk = bOk();
        if (bOk != null) {
            bOk.stopCamera();
            bOk.setVisibility(4);
        }
    }

    public void bOj() {
        TbCameraView bOk = bOk();
        if (bOk != null) {
            bOk.setVisibility(0);
            bOk.oC(false);
        }
        if (this.hVg != null && this.hVg.bOI() != null) {
            this.hVg.bOI().bON();
        }
    }

    public View bOl() {
        if (this.hVg == null) {
            return null;
        }
        return this.hVg.byu();
    }

    public View bOm() {
        if (this.hVg == null) {
            return null;
        }
        return this.hVg.bOH();
    }

    public View bOn() {
        if (this.hVh == null) {
            return null;
        }
        return this.hVh.byu();
    }

    public View bOo() {
        if (this.hVh == null) {
            return null;
        }
        return this.hVh.bOt();
    }

    public View bOp() {
        if (this.hVh == null) {
            return null;
        }
        return this.hVh.bOp();
    }

    public View bOq() {
        if (this.hVg == null) {
            return null;
        }
        return this.hVg.bOp();
    }

    public void onDestroy() {
    }

    public void oy(boolean z) {
        if (this.hVh != null) {
            this.hVh.oy(z);
        }
        if (this.hVg != null) {
            this.hVg.oy(z);
        }
    }

    public void a(i iVar) {
        if (this.hVg != null) {
            this.hVg.a(iVar);
        }
    }
}
