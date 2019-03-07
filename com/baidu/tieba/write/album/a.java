package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] dfe;
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

    public void bjR() {
        this.dfe = new Fragment[2];
        this.jmN = new String[2];
        this.jmO = new ImageListFragment();
        this.dfe[0] = this.jmO;
        this.jmN[0] = this.jmK;
        this.jmP = new AlbumImageBrowseFragment();
        this.dfe[1] = this.jmP;
        this.jmN[1] = this.jmL;
    }

    public Fragment Be(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.dfe[i];
    }

    public String Bf(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.jmN[i];
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

    public TbCameraView coz() {
        if (this.jmO == null) {
            return null;
        }
        return this.jmO.coz();
    }

    public void stopCamera() {
        TbCameraView coz = coz();
        if (coz != null) {
            coz.stopCamera();
            coz.setVisibility(4);
        }
    }

    public void coy() {
        TbCameraView coz = coz();
        if (coz != null) {
            coz.setVisibility(0);
            coz.rd(false);
        }
        if (this.jmO != null && this.jmO.coX() != null) {
            this.jmO.coX().cpc();
        }
    }

    public View coA() {
        if (this.jmO == null) {
            return null;
        }
        return this.jmO.bZR();
    }

    public View coB() {
        if (this.jmO == null) {
            return null;
        }
        return this.jmO.coW();
    }

    public View coC() {
        if (this.jmP == null) {
            return null;
        }
        return this.jmP.bZR();
    }

    public View coD() {
        if (this.jmP == null) {
            return null;
        }
        return this.jmP.coI();
    }

    public View coE() {
        if (this.jmP == null) {
            return null;
        }
        return this.jmP.coE();
    }

    public View coF() {
        if (this.jmO == null) {
            return null;
        }
        return this.jmO.coE();
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
