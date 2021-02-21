package com.baidu.tieba.write.album;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes8.dex */
public class a extends com.baidu.adp.base.d<BaseFragmentActivity> {
    private String bLx;
    private String bLy;
    private Fragment[] bgH;
    private TbPageContext iVp;
    private e oem;
    private String[] oen;
    private ImageListFragment oeo;
    private AlbumImageBrowseFragment oep;

    public a(TbPageContext tbPageContext, e eVar) {
        super(tbPageContext);
        this.bLx = "tag_image";
        this.bLy = "tag_b_image";
        this.iVp = tbPageContext;
        this.oem = eVar;
    }

    public void Uu() {
        this.bgH = new Fragment[2];
        this.oen = new String[2];
        this.oeo = new ImageListFragment();
        this.oeo.a(this.oem);
        this.bgH[0] = this.oeo;
        this.oen[0] = this.bLx;
        this.oep = new AlbumImageBrowseFragment();
        this.oep.a(this.oem);
        this.bgH[1] = this.oep;
        this.oen[1] = this.bLy;
    }

    public Fragment Lj(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.bgH[i];
    }

    public String Lk(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.oen[i];
    }

    public void b(NavigationBar navigationBar) {
        this.oeo.b(navigationBar);
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

    public TbCameraView dWS() {
        if (this.oeo == null) {
            return null;
        }
        return this.oeo.dWS();
    }

    public void stopCamera() {
        TbCameraView dWS = dWS();
        if (dWS != null) {
            dWS.stopCamera();
            dWS.setVisibility(4);
        }
    }

    public void openCamera() {
        TbCameraView dWS = dWS();
        if (dWS != null) {
            dWS.setVisibility(0);
            dWS.zC(false);
        }
        if (this.oeo != null && this.oeo.dXd() != null) {
            this.oeo.dXd().UR();
        }
    }

    public void dWT() {
        if (this.oeo != null) {
            this.oeo.UP();
        }
    }

    public View Uv() {
        if (this.oeo == null) {
            return null;
        }
        return this.oeo.UM();
    }

    public View Uw() {
        if (this.oeo == null) {
            return null;
        }
        return this.oeo.UQ();
    }

    public View Ux() {
        if (this.oep == null) {
            return null;
        }
        return this.oep.UM();
    }

    public View Uy() {
        if (this.oep == null) {
            return null;
        }
        return this.oep.UN();
    }

    public View Uz() {
        if (this.oep == null) {
            return null;
        }
        return this.oep.Uz();
    }

    public View UA() {
        if (this.oeo == null) {
            return null;
        }
        return this.oeo.Uz();
    }

    public void onDestroy() {
    }

    public ImageListFragment dWU() {
        return this.oeo;
    }

    public void dn(boolean z) {
        if (this.oep != null) {
            this.oep.dn(z);
        }
        if (this.oeo != null) {
            this.oeo.dn(z);
        }
    }

    public void a(j jVar) {
        if (this.oeo != null) {
            this.oeo.a(jVar);
        }
    }
}
