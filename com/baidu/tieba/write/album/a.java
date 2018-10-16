package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] bKx;
    private String hIV;
    private String hIW;
    private AlbumActivity hIX;
    private String[] hIY;
    private ImageListFragment hIZ;
    private AlbumImageBrowseFragment hJa;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.hIV = "tag_image";
        this.hIW = "tag_b_image";
        this.hIX = albumActivity;
    }

    public void aGz() {
        this.bKx = new Fragment[2];
        this.hIY = new String[2];
        this.hIZ = new ImageListFragment();
        this.bKx[0] = this.hIZ;
        this.hIY[0] = this.hIV;
        this.hJa = new AlbumImageBrowseFragment();
        this.bKx[1] = this.hJa;
        this.hIY[1] = this.hIW;
    }

    public Fragment wl(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.bKx[i];
    }

    public String wm(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.hIY[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bKx.length) {
                if (this.bKx[i3] != null && (this.bKx[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.bKx[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView bLP() {
        if (this.hIZ == null) {
            return null;
        }
        return this.hIZ.bLP();
    }

    public void stopCamera() {
        TbCameraView bLP = bLP();
        if (bLP != null) {
            bLP.stopCamera();
            bLP.setVisibility(4);
        }
    }

    public void bLO() {
        TbCameraView bLP = bLP();
        if (bLP != null) {
            bLP.setVisibility(0);
            bLP.oj(false);
        }
        if (this.hIZ != null && this.hIZ.bMn() != null) {
            this.hIZ.bMn().bMs();
        }
    }

    public View bLQ() {
        if (this.hIZ == null) {
            return null;
        }
        return this.hIZ.bwq();
    }

    public View bLR() {
        if (this.hIZ == null) {
            return null;
        }
        return this.hIZ.bMm();
    }

    public View bLS() {
        if (this.hJa == null) {
            return null;
        }
        return this.hJa.bwq();
    }

    public View bLT() {
        if (this.hJa == null) {
            return null;
        }
        return this.hJa.bLY();
    }

    public View bLU() {
        if (this.hJa == null) {
            return null;
        }
        return this.hJa.bLU();
    }

    public View bLV() {
        if (this.hIZ == null) {
            return null;
        }
        return this.hIZ.bLU();
    }

    public void onDestroy() {
    }

    public void of(boolean z) {
        if (this.hJa != null) {
            this.hJa.of(z);
        }
        if (this.hIZ != null) {
            this.hIZ.of(z);
        }
    }

    public void a(i iVar) {
        if (this.hIZ != null) {
            this.hIZ.a(iVar);
        }
    }
}
