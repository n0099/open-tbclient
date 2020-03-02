package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes13.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private String aCf;
    private String aCg;
    private String[] aCi;
    private Fragment[] aoo;
    private AlbumActivity kMN;
    private ImageListFragment kMO;
    private AlbumImageBrowseFragment kMP;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.aCf = "tag_image";
        this.aCg = "tag_b_image";
        this.kMN = albumActivity;
    }

    public void Ar() {
        this.aoo = new Fragment[2];
        this.aCi = new String[2];
        this.kMO = new ImageListFragment();
        this.aoo[0] = this.kMO;
        this.aCi[0] = this.aCf;
        this.kMP = new AlbumImageBrowseFragment();
        this.aoo[1] = this.kMP;
        this.aCi[1] = this.aCg;
    }

    public Fragment cN(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.aoo[i];
    }

    public String cO(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.aCi[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.aoo.length) {
                if (this.aoo[i3] != null && (this.aoo[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.aoo[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView cUB() {
        if (this.kMO == null) {
            return null;
        }
        return this.kMO.cUB();
    }

    public void stopCamera() {
        TbCameraView cUB = cUB();
        if (cUB != null) {
            cUB.stopCamera();
            cUB.setVisibility(4);
        }
    }

    public void FF() {
        TbCameraView cUB = cUB();
        if (cUB != null) {
            cUB.setVisibility(0);
            cUB.tN(false);
        }
        if (this.kMO != null && this.kMO.cUG() != null) {
            this.kMO.cUG().AQ();
        }
    }

    public View As() {
        if (this.kMO == null) {
            return null;
        }
        return this.kMO.AA();
    }

    public View At() {
        if (this.kMO == null) {
            return null;
        }
        return this.kMO.AP();
    }

    public View Au() {
        if (this.kMP == null) {
            return null;
        }
        return this.kMP.AA();
    }

    public View Av() {
        if (this.kMP == null) {
            return null;
        }
        return this.kMP.AB();
    }

    public View Aw() {
        if (this.kMP == null) {
            return null;
        }
        return this.kMP.Aw();
    }

    public View Ax() {
        if (this.kMO == null) {
            return null;
        }
        return this.kMO.Aw();
    }

    public void onDestroy() {
    }

    public void bt(boolean z) {
        if (this.kMP != null) {
            this.kMP.bt(z);
        }
        if (this.kMO != null) {
            this.kMO.bt(z);
        }
    }

    public void a(i iVar) {
        if (this.kMO != null) {
            this.kMO.a(iVar);
        }
    }
}
