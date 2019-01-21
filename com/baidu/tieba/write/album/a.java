package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] bPM;
    private String hWk;
    private String hWl;
    private AlbumActivity hWm;
    private String[] hWn;
    private ImageListFragment hWo;
    private AlbumImageBrowseFragment hWp;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.hWk = "tag_image";
        this.hWl = "tag_b_image";
        this.hWm = albumActivity;
    }

    public void aIW() {
        this.bPM = new Fragment[2];
        this.hWn = new String[2];
        this.hWo = new ImageListFragment();
        this.bPM[0] = this.hWo;
        this.hWn[0] = this.hWk;
        this.hWp = new AlbumImageBrowseFragment();
        this.bPM[1] = this.hWp;
        this.hWn[1] = this.hWl;
    }

    public Fragment xq(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.bPM[i];
    }

    public String xr(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.hWn[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bPM.length) {
                if (this.bPM[i3] != null && (this.bPM[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.bPM[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView bOS() {
        if (this.hWo == null) {
            return null;
        }
        return this.hWo.bOS();
    }

    public void stopCamera() {
        TbCameraView bOS = bOS();
        if (bOS != null) {
            bOS.stopCamera();
            bOS.setVisibility(4);
        }
    }

    public void bOR() {
        TbCameraView bOS = bOS();
        if (bOS != null) {
            bOS.setVisibility(0);
            bOS.oD(false);
        }
        if (this.hWo != null && this.hWo.bPq() != null) {
            this.hWo.bPq().bPv();
        }
    }

    public View bOT() {
        if (this.hWo == null) {
            return null;
        }
        return this.hWo.bzd();
    }

    public View bOU() {
        if (this.hWo == null) {
            return null;
        }
        return this.hWo.bPp();
    }

    public View bOV() {
        if (this.hWp == null) {
            return null;
        }
        return this.hWp.bzd();
    }

    public View bOW() {
        if (this.hWp == null) {
            return null;
        }
        return this.hWp.bPb();
    }

    public View bOX() {
        if (this.hWp == null) {
            return null;
        }
        return this.hWp.bOX();
    }

    public View bOY() {
        if (this.hWo == null) {
            return null;
        }
        return this.hWo.bOX();
    }

    public void onDestroy() {
    }

    public void oz(boolean z) {
        if (this.hWp != null) {
            this.hWp.oz(z);
        }
        if (this.hWo != null) {
            this.hWo.oz(z);
        }
    }

    public void a(i iVar) {
        if (this.hWo != null) {
            this.hWo.a(iVar);
        }
    }
}
