package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] bvt;
    private String hsE;
    private String hsF;
    private AlbumActivity hsG;
    private String[] hsH;
    private ImageListFragment hsI;
    private AlbumImageBrowseFragment hsJ;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.hsE = "tag_image";
        this.hsF = "tag_b_image";
        this.hsG = albumActivity;
    }

    public void aZs() {
        this.bvt = new Fragment[2];
        this.hsH = new String[2];
        this.hsI = new ImageListFragment();
        this.bvt[0] = this.hsI;
        this.hsH[0] = this.hsE;
        this.hsJ = new AlbumImageBrowseFragment();
        this.bvt[1] = this.hsJ;
        this.hsH[1] = this.hsF;
    }

    public Fragment vp(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.bvt[i];
    }

    public String vq(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.hsH[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bvt.length) {
                if (this.bvt[i3] != null && (this.bvt[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.bvt[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView bGY() {
        if (this.hsI == null) {
            return null;
        }
        return this.hsI.bGY();
    }

    public void stopCamera() {
        TbCameraView bGY = bGY();
        if (bGY != null) {
            bGY.stopCamera();
            bGY.setVisibility(4);
        }
    }

    public void bGX() {
        TbCameraView bGY = bGY();
        if (bGY != null) {
            bGY.setVisibility(0);
            bGY.nI(false);
        }
        if (this.hsI != null && this.hsI.bHw() != null) {
            this.hsI.bHw().bHB();
        }
    }

    public View bGZ() {
        if (this.hsI == null) {
            return null;
        }
        return this.hsI.brU();
    }

    public View bHa() {
        if (this.hsI == null) {
            return null;
        }
        return this.hsI.bHv();
    }

    public View bHb() {
        if (this.hsJ == null) {
            return null;
        }
        return this.hsJ.brU();
    }

    public View bHc() {
        if (this.hsJ == null) {
            return null;
        }
        return this.hsJ.bHh();
    }

    public View bHd() {
        if (this.hsJ == null) {
            return null;
        }
        return this.hsJ.bHd();
    }

    public View bHe() {
        if (this.hsI == null) {
            return null;
        }
        return this.hsI.bHd();
    }

    public void onDestroy() {
    }

    public void nE(boolean z) {
        if (this.hsJ != null) {
            this.hsJ.nE(z);
        }
        if (this.hsI != null) {
            this.hsI.nE(z);
        }
    }

    public void a(i iVar) {
        if (this.hsI != null) {
            this.hsI.a(iVar);
        }
    }
}
