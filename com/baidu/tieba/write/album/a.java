package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] bBQ;
    private String hBI;
    private String hBJ;
    private AlbumActivity hBK;
    private String[] hBL;
    private ImageListFragment hBM;
    private AlbumImageBrowseFragment hBN;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.hBI = "tag_image";
        this.hBJ = "tag_b_image";
        this.hBK = albumActivity;
    }

    public void aDh() {
        this.bBQ = new Fragment[2];
        this.hBL = new String[2];
        this.hBM = new ImageListFragment();
        this.bBQ[0] = this.hBM;
        this.hBL[0] = this.hBI;
        this.hBN = new AlbumImageBrowseFragment();
        this.bBQ[1] = this.hBN;
        this.hBL[1] = this.hBJ;
    }

    public Fragment vO(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.bBQ[i];
    }

    public String vP(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.hBL[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bBQ.length) {
                if (this.bBQ[i3] != null && (this.bBQ[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.bBQ[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView bID() {
        if (this.hBM == null) {
            return null;
        }
        return this.hBM.bID();
    }

    public void stopCamera() {
        TbCameraView bID = bID();
        if (bID != null) {
            bID.stopCamera();
            bID.setVisibility(4);
        }
    }

    public void bIC() {
        TbCameraView bID = bID();
        if (bID != null) {
            bID.setVisibility(0);
            bID.nT(false);
        }
        if (this.hBM != null && this.hBM.bJb() != null) {
            this.hBM.bJb().bJg();
        }
    }

    public View bIE() {
        if (this.hBM == null) {
            return null;
        }
        return this.hBM.btb();
    }

    public View bIF() {
        if (this.hBM == null) {
            return null;
        }
        return this.hBM.bJa();
    }

    public View bIG() {
        if (this.hBN == null) {
            return null;
        }
        return this.hBN.btb();
    }

    public View bIH() {
        if (this.hBN == null) {
            return null;
        }
        return this.hBN.bIM();
    }

    public View bII() {
        if (this.hBN == null) {
            return null;
        }
        return this.hBN.bII();
    }

    public View bIJ() {
        if (this.hBM == null) {
            return null;
        }
        return this.hBM.bII();
    }

    public void onDestroy() {
    }

    public void nP(boolean z) {
        if (this.hBN != null) {
            this.hBN.nP(z);
        }
        if (this.hBM != null) {
            this.hBM.nP(z);
        }
    }

    public void a(i iVar) {
        if (this.hBM != null) {
            this.hBM.a(iVar);
        }
    }
}
