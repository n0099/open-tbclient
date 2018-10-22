package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] bKx;
    private String hIW;
    private String hIX;
    private AlbumActivity hIY;
    private String[] hIZ;
    private ImageListFragment hJa;
    private AlbumImageBrowseFragment hJb;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.hIW = "tag_image";
        this.hIX = "tag_b_image";
        this.hIY = albumActivity;
    }

    public void aGz() {
        this.bKx = new Fragment[2];
        this.hIZ = new String[2];
        this.hJa = new ImageListFragment();
        this.bKx[0] = this.hJa;
        this.hIZ[0] = this.hIW;
        this.hJb = new AlbumImageBrowseFragment();
        this.bKx[1] = this.hJb;
        this.hIZ[1] = this.hIX;
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
        return this.hIZ[i];
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
        if (this.hJa == null) {
            return null;
        }
        return this.hJa.bLP();
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
        if (this.hJa != null && this.hJa.bMn() != null) {
            this.hJa.bMn().bMs();
        }
    }

    public View bLQ() {
        if (this.hJa == null) {
            return null;
        }
        return this.hJa.bwq();
    }

    public View bLR() {
        if (this.hJa == null) {
            return null;
        }
        return this.hJa.bMm();
    }

    public View bLS() {
        if (this.hJb == null) {
            return null;
        }
        return this.hJb.bwq();
    }

    public View bLT() {
        if (this.hJb == null) {
            return null;
        }
        return this.hJb.bLY();
    }

    public View bLU() {
        if (this.hJb == null) {
            return null;
        }
        return this.hJb.bLU();
    }

    public View bLV() {
        if (this.hJa == null) {
            return null;
        }
        return this.hJa.bLU();
    }

    public void onDestroy() {
    }

    public void of(boolean z) {
        if (this.hJb != null) {
            this.hJb.of(z);
        }
        if (this.hJa != null) {
            this.hJa.of(z);
        }
    }

    public void a(i iVar) {
        if (this.hJa != null) {
            this.hJa.a(iVar);
        }
    }
}
