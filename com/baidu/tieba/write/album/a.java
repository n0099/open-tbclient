package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes10.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] alo;
    private String axf;
    private String axg;
    private String[] axi;
    private ImageListFragment kIA;
    private AlbumImageBrowseFragment kIB;
    private AlbumActivity kIz;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.axf = "tag_image";
        this.axg = "tag_b_image";
        this.kIz = albumActivity;
    }

    public void xI() {
        this.alo = new Fragment[2];
        this.axi = new String[2];
        this.kIA = new ImageListFragment();
        this.alo[0] = this.kIA;
        this.axi[0] = this.axf;
        this.kIB = new AlbumImageBrowseFragment();
        this.alo[1] = this.kIB;
        this.axi[1] = this.axg;
    }

    public Fragment cw(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.alo[i];
    }

    public String cx(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.axi[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.alo.length) {
                if (this.alo[i3] != null && (this.alo[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.alo[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView cSg() {
        if (this.kIA == null) {
            return null;
        }
        return this.kIA.cSg();
    }

    public void stopCamera() {
        TbCameraView cSg = cSg();
        if (cSg != null) {
            cSg.stopCamera();
            cSg.setVisibility(4);
        }
    }

    public void CL() {
        TbCameraView cSg = cSg();
        if (cSg != null) {
            cSg.setVisibility(0);
            cSg.tx(false);
        }
        if (this.kIA != null && this.kIA.cSl() != null) {
            this.kIA.cSl().yh();
        }
    }

    public View xJ() {
        if (this.kIA == null) {
            return null;
        }
        return this.kIA.xR();
    }

    public View xK() {
        if (this.kIA == null) {
            return null;
        }
        return this.kIA.yg();
    }

    public View xL() {
        if (this.kIB == null) {
            return null;
        }
        return this.kIB.xR();
    }

    public View xM() {
        if (this.kIB == null) {
            return null;
        }
        return this.kIB.xS();
    }

    public View xN() {
        if (this.kIB == null) {
            return null;
        }
        return this.kIB.xN();
    }

    public View xO() {
        if (this.kIA == null) {
            return null;
        }
        return this.kIA.xN();
    }

    public void onDestroy() {
    }

    public void bh(boolean z) {
        if (this.kIB != null) {
            this.kIB.bh(z);
        }
        if (this.kIA != null) {
            this.kIA.bh(z);
        }
    }

    public void a(i iVar) {
        if (this.kIA != null) {
            this.kIA.a(iVar);
        }
    }
}
