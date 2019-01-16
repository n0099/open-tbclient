package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] bPL;
    private String hWj;
    private String hWk;
    private AlbumActivity hWl;
    private String[] hWm;
    private ImageListFragment hWn;
    private AlbumImageBrowseFragment hWo;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.hWj = "tag_image";
        this.hWk = "tag_b_image";
        this.hWl = albumActivity;
    }

    public void aIW() {
        this.bPL = new Fragment[2];
        this.hWm = new String[2];
        this.hWn = new ImageListFragment();
        this.bPL[0] = this.hWn;
        this.hWm[0] = this.hWj;
        this.hWo = new AlbumImageBrowseFragment();
        this.bPL[1] = this.hWo;
        this.hWm[1] = this.hWk;
    }

    public Fragment xq(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.bPL[i];
    }

    public String xr(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.hWm[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bPL.length) {
                if (this.bPL[i3] != null && (this.bPL[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.bPL[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView bOS() {
        if (this.hWn == null) {
            return null;
        }
        return this.hWn.bOS();
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
        if (this.hWn != null && this.hWn.bPq() != null) {
            this.hWn.bPq().bPv();
        }
    }

    public View bOT() {
        if (this.hWn == null) {
            return null;
        }
        return this.hWn.bzd();
    }

    public View bOU() {
        if (this.hWn == null) {
            return null;
        }
        return this.hWn.bPp();
    }

    public View bOV() {
        if (this.hWo == null) {
            return null;
        }
        return this.hWo.bzd();
    }

    public View bOW() {
        if (this.hWo == null) {
            return null;
        }
        return this.hWo.bPb();
    }

    public View bOX() {
        if (this.hWo == null) {
            return null;
        }
        return this.hWo.bOX();
    }

    public View bOY() {
        if (this.hWn == null) {
            return null;
        }
        return this.hWn.bOX();
    }

    public void onDestroy() {
    }

    public void oz(boolean z) {
        if (this.hWo != null) {
            this.hWo.oz(z);
        }
        if (this.hWn != null) {
            this.hWn.oz(z);
        }
    }

    public void a(i iVar) {
        if (this.hWn != null) {
            this.hWn.a(iVar);
        }
    }
}
