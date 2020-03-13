package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes13.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private String aCg;
    private String aCh;
    private String[] aCj;
    private Fragment[] aop;
    private AlbumActivity kMZ;
    private ImageListFragment kNa;
    private AlbumImageBrowseFragment kNb;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.aCg = "tag_image";
        this.aCh = "tag_b_image";
        this.kMZ = albumActivity;
    }

    public void Ar() {
        this.aop = new Fragment[2];
        this.aCj = new String[2];
        this.kNa = new ImageListFragment();
        this.aop[0] = this.kNa;
        this.aCj[0] = this.aCg;
        this.kNb = new AlbumImageBrowseFragment();
        this.aop[1] = this.kNb;
        this.aCj[1] = this.aCh;
    }

    public Fragment cN(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.aop[i];
    }

    public String cO(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.aCj[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.aop.length) {
                if (this.aop[i3] != null && (this.aop[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.aop[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView cUC() {
        if (this.kNa == null) {
            return null;
        }
        return this.kNa.cUC();
    }

    public void stopCamera() {
        TbCameraView cUC = cUC();
        if (cUC != null) {
            cUC.stopCamera();
            cUC.setVisibility(4);
        }
    }

    public void FF() {
        TbCameraView cUC = cUC();
        if (cUC != null) {
            cUC.setVisibility(0);
            cUC.tN(false);
        }
        if (this.kNa != null && this.kNa.cUH() != null) {
            this.kNa.cUH().AQ();
        }
    }

    public View As() {
        if (this.kNa == null) {
            return null;
        }
        return this.kNa.AA();
    }

    public View At() {
        if (this.kNa == null) {
            return null;
        }
        return this.kNa.AP();
    }

    public View Au() {
        if (this.kNb == null) {
            return null;
        }
        return this.kNb.AA();
    }

    public View Av() {
        if (this.kNb == null) {
            return null;
        }
        return this.kNb.AB();
    }

    public View Aw() {
        if (this.kNb == null) {
            return null;
        }
        return this.kNb.Aw();
    }

    public View Ax() {
        if (this.kNa == null) {
            return null;
        }
        return this.kNa.Aw();
    }

    public void onDestroy() {
    }

    public void bt(boolean z) {
        if (this.kNb != null) {
            this.kNb.bt(z);
        }
        if (this.kNa != null) {
            this.kNa.bt(z);
        }
    }

    public void a(i iVar) {
        if (this.kNa != null) {
            this.kNa.a(iVar);
        }
    }
}
