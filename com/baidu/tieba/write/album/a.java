package com.baidu.tieba.write.album;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes8.dex */
public class a extends com.baidu.adp.base.d<BaseFragmentActivity> {
    private String bMA;
    private String bMz;
    private Fragment[] biq;
    private TbPageContext iUb;
    private e nYl;
    private String[] nYm;
    private ImageListFragment nYn;
    private AlbumImageBrowseFragment nYo;

    public a(TbPageContext tbPageContext, e eVar) {
        super(tbPageContext);
        this.bMz = "tag_image";
        this.bMA = "tag_b_image";
        this.iUb = tbPageContext;
        this.nYl = eVar;
    }

    public void WF() {
        this.biq = new Fragment[2];
        this.nYm = new String[2];
        this.nYn = new ImageListFragment();
        this.nYn.a(this.nYl);
        this.biq[0] = this.nYn;
        this.nYm[0] = this.bMz;
        this.nYo = new AlbumImageBrowseFragment();
        this.nYo.a(this.nYl);
        this.biq[1] = this.nYo;
        this.nYm[1] = this.bMA;
    }

    public Fragment Mu(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.biq[i];
    }

    public String Mv(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.nYm[i];
    }

    public void b(NavigationBar navigationBar) {
        this.nYn.b(navigationBar);
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.biq.length) {
                if (this.biq[i3] != null && (this.biq[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.biq[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView dYn() {
        if (this.nYn == null) {
            return null;
        }
        return this.nYn.dYn();
    }

    public void stopCamera() {
        TbCameraView dYn = dYn();
        if (dYn != null) {
            dYn.stopCamera();
            dYn.setVisibility(4);
        }
    }

    public void openCamera() {
        TbCameraView dYn = dYn();
        if (dYn != null) {
            dYn.setVisibility(0);
            dYn.zk(false);
        }
        if (this.nYn != null && this.nYn.dYy() != null) {
            this.nYn.dYy().Xc();
        }
    }

    public void dYo() {
        if (this.nYn != null) {
            this.nYn.Xa();
        }
    }

    public View WG() {
        if (this.nYn == null) {
            return null;
        }
        return this.nYn.WX();
    }

    public View WH() {
        if (this.nYn == null) {
            return null;
        }
        return this.nYn.Xb();
    }

    public View WI() {
        if (this.nYo == null) {
            return null;
        }
        return this.nYo.WX();
    }

    public View WJ() {
        if (this.nYo == null) {
            return null;
        }
        return this.nYo.WY();
    }

    public View WK() {
        if (this.nYo == null) {
            return null;
        }
        return this.nYo.WK();
    }

    public View WL() {
        if (this.nYn == null) {
            return null;
        }
        return this.nYn.WK();
    }

    public void onDestroy() {
    }

    public ImageListFragment dYp() {
        return this.nYn;
    }

    public void dj(boolean z) {
        if (this.nYo != null) {
            this.nYo.dj(z);
        }
        if (this.nYn != null) {
            this.nYn.dj(z);
        }
    }

    public void a(j jVar) {
        if (this.nYn != null) {
            this.nYn.a(jVar);
        }
    }
}
