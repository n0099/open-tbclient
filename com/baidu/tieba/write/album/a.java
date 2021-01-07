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
    private e nYk;
    private String[] nYl;
    private ImageListFragment nYm;
    private AlbumImageBrowseFragment nYn;

    public a(TbPageContext tbPageContext, e eVar) {
        super(tbPageContext);
        this.bMz = "tag_image";
        this.bMA = "tag_b_image";
        this.iUb = tbPageContext;
        this.nYk = eVar;
    }

    public void WG() {
        this.biq = new Fragment[2];
        this.nYl = new String[2];
        this.nYm = new ImageListFragment();
        this.nYm.a(this.nYk);
        this.biq[0] = this.nYm;
        this.nYl[0] = this.bMz;
        this.nYn = new AlbumImageBrowseFragment();
        this.nYn.a(this.nYk);
        this.biq[1] = this.nYn;
        this.nYl[1] = this.bMA;
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
        return this.nYl[i];
    }

    public void b(NavigationBar navigationBar) {
        this.nYm.b(navigationBar);
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

    public TbCameraView dYo() {
        if (this.nYm == null) {
            return null;
        }
        return this.nYm.dYo();
    }

    public void stopCamera() {
        TbCameraView dYo = dYo();
        if (dYo != null) {
            dYo.stopCamera();
            dYo.setVisibility(4);
        }
    }

    public void openCamera() {
        TbCameraView dYo = dYo();
        if (dYo != null) {
            dYo.setVisibility(0);
            dYo.zk(false);
        }
        if (this.nYm != null && this.nYm.dYz() != null) {
            this.nYm.dYz().Xd();
        }
    }

    public void dYp() {
        if (this.nYm != null) {
            this.nYm.Xb();
        }
    }

    public View WH() {
        if (this.nYm == null) {
            return null;
        }
        return this.nYm.WY();
    }

    public View WI() {
        if (this.nYm == null) {
            return null;
        }
        return this.nYm.Xc();
    }

    public View WJ() {
        if (this.nYn == null) {
            return null;
        }
        return this.nYn.WY();
    }

    public View WK() {
        if (this.nYn == null) {
            return null;
        }
        return this.nYn.WZ();
    }

    public View WL() {
        if (this.nYn == null) {
            return null;
        }
        return this.nYn.WL();
    }

    public View WM() {
        if (this.nYm == null) {
            return null;
        }
        return this.nYm.WL();
    }

    public void onDestroy() {
    }

    public ImageListFragment dYq() {
        return this.nYm;
    }

    public void dj(boolean z) {
        if (this.nYn != null) {
            this.nYn.dj(z);
        }
        if (this.nYm != null) {
            this.nYm.dj(z);
        }
    }

    public void a(j jVar) {
        if (this.nYm != null) {
            this.nYm.a(jVar);
        }
    }
}
