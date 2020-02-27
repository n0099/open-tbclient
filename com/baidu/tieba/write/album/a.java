package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes13.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private String aCe;
    private String aCf;
    private String[] aCh;
    private Fragment[] aoo;
    private AlbumActivity kML;
    private ImageListFragment kMM;
    private AlbumImageBrowseFragment kMN;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.aCe = "tag_image";
        this.aCf = "tag_b_image";
        this.kML = albumActivity;
    }

    public void Ap() {
        this.aoo = new Fragment[2];
        this.aCh = new String[2];
        this.kMM = new ImageListFragment();
        this.aoo[0] = this.kMM;
        this.aCh[0] = this.aCe;
        this.kMN = new AlbumImageBrowseFragment();
        this.aoo[1] = this.kMN;
        this.aCh[1] = this.aCf;
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
        return this.aCh[i];
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

    public TbCameraView cUz() {
        if (this.kMM == null) {
            return null;
        }
        return this.kMM.cUz();
    }

    public void stopCamera() {
        TbCameraView cUz = cUz();
        if (cUz != null) {
            cUz.stopCamera();
            cUz.setVisibility(4);
        }
    }

    public void FD() {
        TbCameraView cUz = cUz();
        if (cUz != null) {
            cUz.setVisibility(0);
            cUz.tN(false);
        }
        if (this.kMM != null && this.kMM.cUE() != null) {
            this.kMM.cUE().AO();
        }
    }

    public View Aq() {
        if (this.kMM == null) {
            return null;
        }
        return this.kMM.Ay();
    }

    public View Ar() {
        if (this.kMM == null) {
            return null;
        }
        return this.kMM.AN();
    }

    public View As() {
        if (this.kMN == null) {
            return null;
        }
        return this.kMN.Ay();
    }

    public View At() {
        if (this.kMN == null) {
            return null;
        }
        return this.kMN.Az();
    }

    public View Au() {
        if (this.kMN == null) {
            return null;
        }
        return this.kMN.Au();
    }

    public View Av() {
        if (this.kMM == null) {
            return null;
        }
        return this.kMM.Au();
    }

    public void onDestroy() {
    }

    public void bt(boolean z) {
        if (this.kMN != null) {
            this.kMN.bt(z);
        }
        if (this.kMM != null) {
            this.kMM.bt(z);
        }
    }

    public void a(i iVar) {
        if (this.kMM != null) {
            this.kMM.a(iVar);
        }
    }
}
