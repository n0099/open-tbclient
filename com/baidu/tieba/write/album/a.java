package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] dff;
    private String jmK;
    private String jmL;
    private AlbumActivity jmM;
    private String[] jmN;
    private ImageListFragment jmO;
    private AlbumImageBrowseFragment jmP;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.jmK = "tag_image";
        this.jmL = "tag_b_image";
        this.jmM = albumActivity;
    }

    public void bjP() {
        this.dff = new Fragment[2];
        this.jmN = new String[2];
        this.jmO = new ImageListFragment();
        this.dff[0] = this.jmO;
        this.jmN[0] = this.jmK;
        this.jmP = new AlbumImageBrowseFragment();
        this.dff[1] = this.jmP;
        this.jmN[1] = this.jmL;
    }

    public Fragment Bb(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.dff[i];
    }

    public String Bc(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.jmN[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.dff.length) {
                if (this.dff[i3] != null && (this.dff[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.dff[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView coK() {
        if (this.jmO == null) {
            return null;
        }
        return this.jmO.coK();
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
        if (this.jmO != null && this.jmO.cpi() != null) {
            this.jmO.cpi().cpn();
        }
    }

    public View coL() {
        if (this.jmO == null) {
            return null;
        }
        return this.jmO.bZQ();
    }

    public View coM() {
        if (this.jmO == null) {
            return null;
        }
        return this.jmO.cph();
    }

    public View coN() {
        if (this.jmP == null) {
            return null;
        }
        return this.jmP.bZQ();
    }

    public View coO() {
        if (this.jmP == null) {
            return null;
        }
        return this.jmP.coT();
    }

    public View coP() {
        if (this.jmP == null) {
            return null;
        }
        return this.jmP.coP();
    }

    public View coQ() {
        if (this.jmO == null) {
            return null;
        }
        return this.jmO.coP();
    }

    public void onDestroy() {
    }

    public void qZ(boolean z) {
        if (this.jmP != null) {
            this.jmP.qZ(z);
        }
        if (this.jmO != null) {
            this.jmO.qZ(z);
        }
    }

    public void a(i iVar) {
        if (this.jmO != null) {
            this.jmO.a(iVar);
        }
    }
}
