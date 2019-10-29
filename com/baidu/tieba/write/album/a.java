package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] adI;
    private String apG;
    private String apH;
    private String[] apJ;
    private AlbumActivity jOC;
    private ImageListFragment jOD;
    private AlbumImageBrowseFragment jOE;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.apG = "tag_image";
        this.apH = "tag_b_image";
        this.jOC = albumActivity;
    }

    public void vJ() {
        this.adI = new Fragment[2];
        this.apJ = new String[2];
        this.jOD = new ImageListFragment();
        this.adI[0] = this.jOD;
        this.apJ[0] = this.apG;
        this.jOE = new AlbumImageBrowseFragment();
        this.adI[1] = this.jOE;
        this.apJ[1] = this.apH;
    }

    public Fragment ce(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.adI[i];
    }

    public String cf(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.apJ[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.adI.length) {
                if (this.adI[i3] != null && (this.adI[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.adI[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView cyg() {
        if (this.jOD == null) {
            return null;
        }
        return this.jOD.cyg();
    }

    public void stopCamera() {
        TbCameraView cyg = cyg();
        if (cyg != null) {
            cyg.stopCamera();
            cyg.setVisibility(4);
        }
    }

    public void aZD() {
        TbCameraView cyg = cyg();
        if (cyg != null) {
            cyg.setVisibility(0);
            cyg.rR(false);
        }
        if (this.jOD != null && this.jOD.cyl() != null) {
            this.jOD.cyl().wi();
        }
    }

    public View vK() {
        if (this.jOD == null) {
            return null;
        }
        return this.jOD.vS();
    }

    public View vL() {
        if (this.jOD == null) {
            return null;
        }
        return this.jOD.wh();
    }

    public View vM() {
        if (this.jOE == null) {
            return null;
        }
        return this.jOE.vS();
    }

    public View vN() {
        if (this.jOE == null) {
            return null;
        }
        return this.jOE.vT();
    }

    public View vO() {
        if (this.jOE == null) {
            return null;
        }
        return this.jOE.vO();
    }

    public View vP() {
        if (this.jOD == null) {
            return null;
        }
        return this.jOD.vO();
    }

    public void onDestroy() {
    }

    public void aQ(boolean z) {
        if (this.jOE != null) {
            this.jOE.aQ(z);
        }
        if (this.jOD != null) {
            this.jOD.aQ(z);
        }
    }

    public void a(i iVar) {
        if (this.jOD != null) {
            this.jOD.a(iVar);
        }
    }
}
