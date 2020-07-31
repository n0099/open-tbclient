package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] aQH;
    private String bjk;
    private String bjl;
    private TbPageContext huq;
    private e muJ;
    private String[] muK;
    private ImageListFragment muL;
    private AlbumImageBrowseFragment muM;

    public a(TbPageContext tbPageContext, e eVar) {
        super(tbPageContext);
        this.bjk = "tag_image";
        this.bjl = "tag_b_image";
        this.huq = tbPageContext;
        this.muJ = eVar;
    }

    public void II() {
        this.aQH = new Fragment[2];
        this.muK = new String[2];
        this.muL = new ImageListFragment();
        this.muL.a(this.muJ);
        this.aQH[0] = this.muL;
        this.muK[0] = this.bjk;
        this.muM = new AlbumImageBrowseFragment();
        this.muM.a(this.muJ);
        this.aQH[1] = this.muM;
        this.muK[1] = this.bjl;
    }

    public Fragment Ha(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.aQH[i];
    }

    public String Hb(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.muK[i];
    }

    public void a(NavigationBar navigationBar) {
        this.muL.a(navigationBar);
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.aQH.length) {
                if (this.aQH[i3] != null && (this.aQH[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.aQH[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView duw() {
        if (this.muL == null) {
            return null;
        }
        return this.muL.duw();
    }

    public void stopCamera() {
        TbCameraView duw = duw();
        if (duw != null) {
            duw.stopCamera();
            duw.setVisibility(4);
        }
    }

    public void Rd() {
        TbCameraView duw = duw();
        if (duw != null) {
            duw.setVisibility(0);
            duw.wq(false);
        }
        if (this.muL != null && this.muL.duH() != null) {
            this.muL.duH().Jg();
        }
    }

    public void dux() {
        if (this.muL != null) {
            this.muL.Je();
        }
    }

    public View IJ() {
        if (this.muL == null) {
            return null;
        }
        return this.muL.Jb();
    }

    public View IK() {
        if (this.muL == null) {
            return null;
        }
        return this.muL.Jf();
    }

    public View IL() {
        if (this.muM == null) {
            return null;
        }
        return this.muM.Jb();
    }

    public View IM() {
        if (this.muM == null) {
            return null;
        }
        return this.muM.Jc();
    }

    public View IN() {
        if (this.muM == null) {
            return null;
        }
        return this.muM.IN();
    }

    public View IO() {
        if (this.muL == null) {
            return null;
        }
        return this.muL.IN();
    }

    public void onDestroy() {
    }

    public ImageListFragment duy() {
        return this.muL;
    }

    public void cp(boolean z) {
        if (this.muM != null) {
            this.muM.cp(z);
        }
        if (this.muL != null) {
            this.muL.cp(z);
        }
    }

    public void a(j jVar) {
        if (this.muL != null) {
            this.muL.a(jVar);
        }
    }
}
