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
    private TbPageContext iHQ;
    private e nUQ;
    private String[] nUR;
    private ImageListFragment nUS;
    private AlbumImageBrowseFragment nUT;

    public a(TbPageContext tbPageContext, e eVar) {
        super(tbPageContext);
        this.bHL = "tag_image";
        this.bHM = "tag_b_image";
        this.iHQ = tbPageContext;
        this.nUQ = eVar;
    }

    public void VD() {
        this.bgH = new Fragment[2];
        this.nUR = new String[2];
        this.nUS = new ImageListFragment();
        this.nUS.a(this.nUQ);
        this.bgH[0] = this.nUS;
        this.nUR[0] = this.bHL;
        this.nUT = new AlbumImageBrowseFragment();
        this.nUT.a(this.nUQ);
        this.bgH[1] = this.nUT;
        this.nUR[1] = this.bHM;
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
        return this.nUR[i];
    }

    public void b(NavigationBar navigationBar) {
        this.nUS.b(navigationBar);
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

    public TbCameraView dYK() {
        if (this.nUS == null) {
            return null;
        }
        return this.nUS.dYK();
    }

    public void stopCamera() {
        TbCameraView dYK = dYK();
        if (dYK != null) {
            dYK.stopCamera();
            dYK.setVisibility(4);
        }
    }

    public void openCamera() {
        TbCameraView dYK = dYK();
        if (dYK != null) {
            dYK.setVisibility(0);
            dYK.zj(false);
        }
        if (this.nUS != null && this.nUS.dYV() != null) {
            this.nUS.dYV().Wa();
        }
    }

    public void dYL() {
        if (this.nUS != null) {
            this.nUS.VY();
        }
    }

    public View VE() {
        if (this.nUS == null) {
            return null;
        }
        return this.nUS.VV();
    }

    public View VF() {
        if (this.nUS == null) {
            return null;
        }
        return this.nUS.VZ();
    }

    public View VG() {
        if (this.nUT == null) {
            return null;
        }
        return this.nUT.VV();
    }

    public View VH() {
        if (this.nUT == null) {
            return null;
        }
        return this.nUT.VW();
    }

    public View VI() {
        if (this.nUT == null) {
            return null;
        }
        return this.nUT.VI();
    }

    public View VJ() {
        if (this.nUS == null) {
            return null;
        }
        return this.nUS.VI();
    }

    public void onDestroy() {
    }

    public ImageListFragment dYM() {
        return this.nUS;
    }

    public void dg(boolean z) {
        if (this.nUT != null) {
            this.nUT.dg(z);
        }
        if (this.nUS != null) {
            this.nUS.dg(z);
        }
    }

    public void a(j jVar) {
        if (this.nUS != null) {
            this.nUS.a(jVar);
        }
    }
}
