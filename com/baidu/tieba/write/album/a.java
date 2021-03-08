package com.baidu.tieba.write.album;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes7.dex */
public class a extends com.baidu.adp.base.d<BaseFragmentActivity> {
    private String bMX;
    private String bMY;
    private Fragment[] bij;
    private TbPageContext iWY;
    private e ogs;
    private String[] ogt;
    private ImageListFragment ogu;
    private AlbumImageBrowseFragment ogv;

    public a(TbPageContext tbPageContext, e eVar) {
        super(tbPageContext);
        this.bMX = "tag_image";
        this.bMY = "tag_b_image";
        this.iWY = tbPageContext;
        this.ogs = eVar;
    }

    public void Ux() {
        this.bij = new Fragment[2];
        this.ogt = new String[2];
        this.ogu = new ImageListFragment();
        this.ogu.a(this.ogs);
        this.bij[0] = this.ogu;
        this.ogt[0] = this.bMX;
        this.ogv = new AlbumImageBrowseFragment();
        this.ogv.a(this.ogs);
        this.bij[1] = this.ogv;
        this.ogt[1] = this.bMY;
    }

    public Fragment Ln(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.bij[i];
    }

    public String Lo(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.ogt[i];
    }

    public void b(NavigationBar navigationBar) {
        this.ogu.b(navigationBar);
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bij.length) {
                if (this.bij[i3] != null && (this.bij[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.bij[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView dXa() {
        if (this.ogu == null) {
            return null;
        }
        return this.ogu.dXa();
    }

    public void stopCamera() {
        TbCameraView dXa = dXa();
        if (dXa != null) {
            dXa.stopCamera();
            dXa.setVisibility(4);
        }
    }

    public void openCamera() {
        TbCameraView dXa = dXa();
        if (dXa != null) {
            dXa.setVisibility(0);
            dXa.zB(false);
        }
        if (this.ogu != null && this.ogu.dXl() != null) {
            this.ogu.dXl().UU();
        }
    }

    public void dXb() {
        if (this.ogu != null) {
            this.ogu.US();
        }
    }

    public View Uy() {
        if (this.ogu == null) {
            return null;
        }
        return this.ogu.UP();
    }

    public View Uz() {
        if (this.ogu == null) {
            return null;
        }
        return this.ogu.UT();
    }

    public View UA() {
        if (this.ogv == null) {
            return null;
        }
        return this.ogv.UP();
    }

    public View UB() {
        if (this.ogv == null) {
            return null;
        }
        return this.ogv.UQ();
    }

    public View UC() {
        if (this.ogv == null) {
            return null;
        }
        return this.ogv.UC();
    }

    public View UD() {
        if (this.ogu == null) {
            return null;
        }
        return this.ogu.UC();
    }

    public void onDestroy() {
    }

    public ImageListFragment dXc() {
        return this.ogu;
    }

    public void dn(boolean z) {
        if (this.ogv != null) {
            this.ogv.dn(z);
        }
        if (this.ogu != null) {
            this.ogu.dn(z);
        }
    }

    public void a(j jVar) {
        if (this.ogu != null) {
            this.ogu.a(jVar);
        }
    }
}
