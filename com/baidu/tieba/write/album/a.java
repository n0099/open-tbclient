package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private String bHL;
    private String bHM;
    private Fragment[] bgH;
    private TbPageContext iHO;
    private e nUO;
    private String[] nUP;
    private ImageListFragment nUQ;
    private AlbumImageBrowseFragment nUR;

    public a(TbPageContext tbPageContext, e eVar) {
        super(tbPageContext);
        this.bHL = "tag_image";
        this.bHM = "tag_b_image";
        this.iHO = tbPageContext;
        this.nUO = eVar;
    }

    public void VD() {
        this.bgH = new Fragment[2];
        this.nUP = new String[2];
        this.nUQ = new ImageListFragment();
        this.nUQ.a(this.nUO);
        this.bgH[0] = this.nUQ;
        this.nUP[0] = this.bHL;
        this.nUR = new AlbumImageBrowseFragment();
        this.nUR.a(this.nUO);
        this.bgH[1] = this.nUR;
        this.nUP[1] = this.bHM;
    }

    public Fragment MH(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.bgH[i];
    }

    public String MI(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.nUP[i];
    }

    public void b(NavigationBar navigationBar) {
        this.nUQ.b(navigationBar);
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bgH.length) {
                if (this.bgH[i3] != null && (this.bgH[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.bgH[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView dYJ() {
        if (this.nUQ == null) {
            return null;
        }
        return this.nUQ.dYJ();
    }

    public void stopCamera() {
        TbCameraView dYJ = dYJ();
        if (dYJ != null) {
            dYJ.stopCamera();
            dYJ.setVisibility(4);
        }
    }

    public void openCamera() {
        TbCameraView dYJ = dYJ();
        if (dYJ != null) {
            dYJ.setVisibility(0);
            dYJ.zj(false);
        }
        if (this.nUQ != null && this.nUQ.dYU() != null) {
            this.nUQ.dYU().Wa();
        }
    }

    public void dYK() {
        if (this.nUQ != null) {
            this.nUQ.VY();
        }
    }

    public View VE() {
        if (this.nUQ == null) {
            return null;
        }
        return this.nUQ.VV();
    }

    public View VF() {
        if (this.nUQ == null) {
            return null;
        }
        return this.nUQ.VZ();
    }

    public View VG() {
        if (this.nUR == null) {
            return null;
        }
        return this.nUR.VV();
    }

    public View VH() {
        if (this.nUR == null) {
            return null;
        }
        return this.nUR.VW();
    }

    public View VI() {
        if (this.nUR == null) {
            return null;
        }
        return this.nUR.VI();
    }

    public View VJ() {
        if (this.nUQ == null) {
            return null;
        }
        return this.nUQ.VI();
    }

    public void onDestroy() {
    }

    public ImageListFragment dYL() {
        return this.nUQ;
    }

    public void dg(boolean z) {
        if (this.nUR != null) {
            this.nUR.dg(z);
        }
        if (this.nUQ != null) {
            this.nUQ.dg(z);
        }
    }

    public void a(j jVar) {
        if (this.nUQ != null) {
            this.nUQ.a(jVar);
        }
    }
}
