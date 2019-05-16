package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] dpI;
    private String jFM;
    private String jFN;
    private AlbumActivity jFO;
    private String[] jFP;
    private ImageListFragment jFQ;
    private AlbumImageBrowseFragment jFR;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.jFM = "tag_image";
        this.jFN = "tag_b_image";
        this.jFO = albumActivity;
    }

    public void brh() {
        this.dpI = new Fragment[2];
        this.jFP = new String[2];
        this.jFQ = new ImageListFragment();
        this.dpI[0] = this.jFQ;
        this.jFP[0] = this.jFM;
        this.jFR = new AlbumImageBrowseFragment();
        this.dpI[1] = this.jFR;
        this.jFP[1] = this.jFN;
    }

    public Fragment Ck(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.dpI[i];
    }

    public String Cl(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.jFP[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.dpI.length) {
                if (this.dpI[i3] != null && (this.dpI[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.dpI[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView cwQ() {
        if (this.jFQ == null) {
            return null;
        }
        return this.jFQ.cwQ();
    }

    public void stopCamera() {
        TbCameraView cwQ = cwQ();
        if (cwQ != null) {
            cwQ.stopCamera();
            cwQ.setVisibility(4);
        }
    }

    public void aWV() {
        TbCameraView cwQ = cwQ();
        if (cwQ != null) {
            cwQ.setVisibility(0);
            cwQ.rS(false);
        }
        if (this.jFQ != null && this.jFQ.cxo() != null) {
            this.jFQ.cxo().cxs();
        }
    }

    public View cwR() {
        if (this.jFQ == null) {
            return null;
        }
        return this.jFQ.chU();
    }

    public View cwS() {
        if (this.jFQ == null) {
            return null;
        }
        return this.jFQ.cxn();
    }

    public View cwT() {
        if (this.jFR == null) {
            return null;
        }
        return this.jFR.chU();
    }

    public View cwU() {
        if (this.jFR == null) {
            return null;
        }
        return this.jFR.cwZ();
    }

    public View cwV() {
        if (this.jFR == null) {
            return null;
        }
        return this.jFR.cwV();
    }

    public View cwW() {
        if (this.jFQ == null) {
            return null;
        }
        return this.jFQ.cwV();
    }

    public void onDestroy() {
    }

    public void rO(boolean z) {
        if (this.jFR != null) {
            this.jFR.rO(z);
        }
        if (this.jFQ != null) {
            this.jFQ.rO(z);
        }
    }

    public void a(i iVar) {
        if (this.jFQ != null) {
            this.jFQ.a(iVar);
        }
    }
}
