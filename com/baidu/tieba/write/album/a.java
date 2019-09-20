package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] dtK;
    private AlbumImageBrowseFragment jQA;
    private String jQv;
    private String jQw;
    private AlbumActivity jQx;
    private String[] jQy;
    private ImageListFragment jQz;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.jQv = "tag_image";
        this.jQw = "tag_b_image";
        this.jQx = albumActivity;
    }

    public void buo() {
        this.dtK = new Fragment[2];
        this.jQy = new String[2];
        this.jQz = new ImageListFragment();
        this.dtK[0] = this.jQz;
        this.jQy[0] = this.jQv;
        this.jQA = new AlbumImageBrowseFragment();
        this.dtK[1] = this.jQA;
        this.jQy[1] = this.jQw;
    }

    public Fragment CX(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.dtK[i];
    }

    public String CY(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.jQy[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.dtK.length) {
                if (this.dtK[i3] != null && (this.dtK[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.dtK[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView cBb() {
        if (this.jQz == null) {
            return null;
        }
        return this.jQz.cBb();
    }

    public void stopCamera() {
        TbCameraView cBb = cBb();
        if (cBb != null) {
            cBb.stopCamera();
            cBb.setVisibility(4);
        }
    }

    public void aZA() {
        TbCameraView cBb = cBb();
        if (cBb != null) {
            cBb.setVisibility(0);
            cBb.sm(false);
        }
        if (this.jQz != null && this.jQz.cBz() != null) {
            this.jQz.cBz().cBD();
        }
    }

    public View cBc() {
        if (this.jQz == null) {
            return null;
        }
        return this.jQz.clS();
    }

    public View cBd() {
        if (this.jQz == null) {
            return null;
        }
        return this.jQz.cBy();
    }

    public View cBe() {
        if (this.jQA == null) {
            return null;
        }
        return this.jQA.clS();
    }

    public View cBf() {
        if (this.jQA == null) {
            return null;
        }
        return this.jQA.cBk();
    }

    public View cBg() {
        if (this.jQA == null) {
            return null;
        }
        return this.jQA.cBg();
    }

    public View cBh() {
        if (this.jQz == null) {
            return null;
        }
        return this.jQz.cBg();
    }

    public void onDestroy() {
    }

    public void si(boolean z) {
        if (this.jQA != null) {
            this.jQA.si(z);
        }
        if (this.jQz != null) {
            this.jQz.si(z);
        }
    }

    public void a(i iVar) {
        if (this.jQz != null) {
            this.jQz.a(iVar);
        }
    }
}
