package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] bwb;
    private String htN;
    private String htO;
    private AlbumActivity htP;
    private String[] htQ;
    private ImageListFragment htR;
    private AlbumImageBrowseFragment htS;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.htN = "tag_image";
        this.htO = "tag_b_image";
        this.htP = albumActivity;
    }

    public void aAZ() {
        this.bwb = new Fragment[2];
        this.htQ = new String[2];
        this.htR = new ImageListFragment();
        this.bwb[0] = this.htR;
        this.htQ[0] = this.htN;
        this.htS = new AlbumImageBrowseFragment();
        this.bwb[1] = this.htS;
        this.htQ[1] = this.htO;
    }

    public Fragment vo(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.bwb[i];
    }

    public String vp(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.htQ[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bwb.length) {
                if (this.bwb[i3] != null && (this.bwb[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.bwb[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView bFN() {
        if (this.htR == null) {
            return null;
        }
        return this.htR.bFN();
    }

    public void stopCamera() {
        TbCameraView bFN = bFN();
        if (bFN != null) {
            bFN.stopCamera();
            bFN.setVisibility(4);
        }
    }

    public void bFM() {
        TbCameraView bFN = bFN();
        if (bFN != null) {
            bFN.setVisibility(0);
            bFN.nw(false);
        }
        if (this.htR != null && this.htR.bGl() != null) {
            this.htR.bGl().bGq();
        }
    }

    public View bFO() {
        if (this.htR == null) {
            return null;
        }
        return this.htR.bqy();
    }

    public View bFP() {
        if (this.htR == null) {
            return null;
        }
        return this.htR.bGk();
    }

    public View bFQ() {
        if (this.htS == null) {
            return null;
        }
        return this.htS.bqy();
    }

    public View bFR() {
        if (this.htS == null) {
            return null;
        }
        return this.htS.bFW();
    }

    public View bFS() {
        if (this.htS == null) {
            return null;
        }
        return this.htS.bFS();
    }

    public View bFT() {
        if (this.htR == null) {
            return null;
        }
        return this.htR.bFS();
    }

    public void onDestroy() {
    }

    public void ns(boolean z) {
        if (this.htS != null) {
            this.htS.ns(z);
        }
        if (this.htR != null) {
            this.htR.ns(z);
        }
    }

    public void a(i iVar) {
        if (this.htR != null) {
            this.htR.a(iVar);
        }
    }
}
