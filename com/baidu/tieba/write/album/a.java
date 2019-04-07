package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] dfe;
    private String jmJ;
    private String jmK;
    private AlbumActivity jmL;
    private String[] jmM;
    private ImageListFragment jmN;
    private AlbumImageBrowseFragment jmO;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.jmJ = "tag_image";
        this.jmK = "tag_b_image";
        this.jmL = albumActivity;
    }

    public void bjP() {
        this.dfe = new Fragment[2];
        this.jmM = new String[2];
        this.jmN = new ImageListFragment();
        this.dfe[0] = this.jmN;
        this.jmM[0] = this.jmJ;
        this.jmO = new AlbumImageBrowseFragment();
        this.dfe[1] = this.jmO;
        this.jmM[1] = this.jmK;
    }

    public Fragment Bb(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.dfe[i];
    }

    public String Bc(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.jmM[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.dfe.length) {
                if (this.dfe[i3] != null && (this.dfe[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.dfe[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView coK() {
        if (this.jmN == null) {
            return null;
        }
        return this.jmN.coK();
    }

    public void stopCamera() {
        TbCameraView coK = coK();
        if (coK != null) {
            coK.stopCamera();
            coK.setVisibility(4);
        }
    }

    public void coJ() {
        TbCameraView coK = coK();
        if (coK != null) {
            coK.setVisibility(0);
            coK.rd(false);
        }
        if (this.jmN != null && this.jmN.cpi() != null) {
            this.jmN.cpi().cpn();
        }
    }

    public View coL() {
        if (this.jmN == null) {
            return null;
        }
        return this.jmN.bZQ();
    }

    public View coM() {
        if (this.jmN == null) {
            return null;
        }
        return this.jmN.cph();
    }

    public View coN() {
        if (this.jmO == null) {
            return null;
        }
        return this.jmO.bZQ();
    }

    public View coO() {
        if (this.jmO == null) {
            return null;
        }
        return this.jmO.coT();
    }

    public View coP() {
        if (this.jmO == null) {
            return null;
        }
        return this.jmO.coP();
    }

    public View coQ() {
        if (this.jmN == null) {
            return null;
        }
        return this.jmN.coP();
    }

    public void onDestroy() {
    }

    public void qZ(boolean z) {
        if (this.jmO != null) {
            this.jmO.qZ(z);
        }
        if (this.jmN != null) {
            this.jmN.qZ(z);
        }
    }

    public void a(i iVar) {
        if (this.jmN != null) {
            this.jmN.a(iVar);
        }
    }
}
