package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] bvZ;
    private String htL;
    private String htM;
    private AlbumActivity htN;
    private String[] htO;
    private ImageListFragment htP;
    private AlbumImageBrowseFragment htQ;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.htL = "tag_image";
        this.htM = "tag_b_image";
        this.htN = albumActivity;
    }

    public void aBc() {
        this.bvZ = new Fragment[2];
        this.htO = new String[2];
        this.htP = new ImageListFragment();
        this.bvZ[0] = this.htP;
        this.htO[0] = this.htL;
        this.htQ = new AlbumImageBrowseFragment();
        this.bvZ[1] = this.htQ;
        this.htO[1] = this.htM;
    }

    public Fragment vo(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.bvZ[i];
    }

    public String vp(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.htO[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bvZ.length) {
                if (this.bvZ[i3] != null && (this.bvZ[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.bvZ[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView bFJ() {
        if (this.htP == null) {
            return null;
        }
        return this.htP.bFJ();
    }

    public void stopCamera() {
        TbCameraView bFJ = bFJ();
        if (bFJ != null) {
            bFJ.stopCamera();
            bFJ.setVisibility(4);
        }
    }

    public void bFI() {
        TbCameraView bFJ = bFJ();
        if (bFJ != null) {
            bFJ.setVisibility(0);
            bFJ.nw(false);
        }
        if (this.htP != null && this.htP.bGh() != null) {
            this.htP.bGh().bGm();
        }
    }

    public View bFK() {
        if (this.htP == null) {
            return null;
        }
        return this.htP.bqx();
    }

    public View bFL() {
        if (this.htP == null) {
            return null;
        }
        return this.htP.bGg();
    }

    public View bFM() {
        if (this.htQ == null) {
            return null;
        }
        return this.htQ.bqx();
    }

    public View bFN() {
        if (this.htQ == null) {
            return null;
        }
        return this.htQ.bFS();
    }

    public View bFO() {
        if (this.htQ == null) {
            return null;
        }
        return this.htQ.bFO();
    }

    public View bFP() {
        if (this.htP == null) {
            return null;
        }
        return this.htP.bFO();
    }

    public void onDestroy() {
    }

    public void ns(boolean z) {
        if (this.htQ != null) {
            this.htQ.ns(z);
        }
        if (this.htP != null) {
            this.htP.ns(z);
        }
    }

    public void a(i iVar) {
        if (this.htP != null) {
            this.htP.a(iVar);
        }
    }
}
