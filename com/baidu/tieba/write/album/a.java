package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] dpJ;
    private String jFN;
    private String jFO;
    private AlbumActivity jFP;
    private String[] jFQ;
    private ImageListFragment jFR;
    private AlbumImageBrowseFragment jFS;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.jFN = "tag_image";
        this.jFO = "tag_b_image";
        this.jFP = albumActivity;
    }

    public void brk() {
        this.dpJ = new Fragment[2];
        this.jFQ = new String[2];
        this.jFR = new ImageListFragment();
        this.dpJ[0] = this.jFR;
        this.jFQ[0] = this.jFN;
        this.jFS = new AlbumImageBrowseFragment();
        this.dpJ[1] = this.jFS;
        this.jFQ[1] = this.jFO;
    }

    public Fragment Ck(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.dpJ[i];
    }

    public String Cl(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.jFQ[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.dpJ.length) {
                if (this.dpJ[i3] != null && (this.dpJ[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.dpJ[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView cwS() {
        if (this.jFR == null) {
            return null;
        }
        return this.jFR.cwS();
    }

    public void stopCamera() {
        TbCameraView cwS = cwS();
        if (cwS != null) {
            cwS.stopCamera();
            cwS.setVisibility(4);
        }
    }

    public void aWY() {
        TbCameraView cwS = cwS();
        if (cwS != null) {
            cwS.setVisibility(0);
            cwS.rS(false);
        }
        if (this.jFR != null && this.jFR.cxq() != null) {
            this.jFR.cxq().cxu();
        }
    }

    public View cwT() {
        if (this.jFR == null) {
            return null;
        }
        return this.jFR.chW();
    }

    public View cwU() {
        if (this.jFR == null) {
            return null;
        }
        return this.jFR.cxp();
    }

    public View cwV() {
        if (this.jFS == null) {
            return null;
        }
        return this.jFS.chW();
    }

    public View cwW() {
        if (this.jFS == null) {
            return null;
        }
        return this.jFS.cxb();
    }

    public View cwX() {
        if (this.jFS == null) {
            return null;
        }
        return this.jFS.cwX();
    }

    public View cwY() {
        if (this.jFR == null) {
            return null;
        }
        return this.jFR.cwX();
    }

    public void onDestroy() {
    }

    public void rO(boolean z) {
        if (this.jFS != null) {
            this.jFS.rO(z);
        }
        if (this.jFR != null) {
            this.jFR.rO(z);
        }
    }

    public void a(i iVar) {
        if (this.jFR != null) {
            this.jFR.a(iVar);
        }
    }
}
