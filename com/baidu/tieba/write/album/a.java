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
    private e muL;
    private String[] muM;
    private ImageListFragment muN;
    private AlbumImageBrowseFragment muO;

    public a(TbPageContext tbPageContext, e eVar) {
        super(tbPageContext);
        this.bjk = "tag_image";
        this.bjl = "tag_b_image";
        this.huq = tbPageContext;
        this.muL = eVar;
    }

    public void II() {
        this.aQH = new Fragment[2];
        this.muM = new String[2];
        this.muN = new ImageListFragment();
        this.muN.a(this.muL);
        this.aQH[0] = this.muN;
        this.muM[0] = this.bjk;
        this.muO = new AlbumImageBrowseFragment();
        this.muO.a(this.muL);
        this.aQH[1] = this.muO;
        this.muM[1] = this.bjl;
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
        return this.muM[i];
    }

    public void a(NavigationBar navigationBar) {
        this.muN.a(navigationBar);
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

    public TbCameraView dux() {
        if (this.muN == null) {
            return null;
        }
        return this.muN.dux();
    }

    public void stopCamera() {
        TbCameraView dux = dux();
        if (dux != null) {
            dux.stopCamera();
            dux.setVisibility(4);
        }
    }

    public void Rd() {
        TbCameraView dux = dux();
        if (dux != null) {
            dux.setVisibility(0);
            dux.wq(false);
        }
        if (this.muN != null && this.muN.duI() != null) {
            this.muN.duI().Jg();
        }
    }

    public void duy() {
        if (this.muN != null) {
            this.muN.Je();
        }
    }

    public View IJ() {
        if (this.muN == null) {
            return null;
        }
        return this.muN.Jb();
    }

    public View IK() {
        if (this.muN == null) {
            return null;
        }
        return this.muN.Jf();
    }

    public View IL() {
        if (this.muO == null) {
            return null;
        }
        return this.muO.Jb();
    }

    public View IM() {
        if (this.muO == null) {
            return null;
        }
        return this.muO.Jc();
    }

    public View IN() {
        if (this.muO == null) {
            return null;
        }
        return this.muO.IN();
    }

    public View IO() {
        if (this.muN == null) {
            return null;
        }
        return this.muN.IN();
    }

    public void onDestroy() {
    }

    public ImageListFragment duz() {
        return this.muN;
    }

    public void cp(boolean z) {
        if (this.muO != null) {
            this.muO.cp(z);
        }
        if (this.muN != null) {
            this.muN.cp(z);
        }
    }

    public void a(j jVar) {
        if (this.muN != null) {
            this.muN.a(jVar);
        }
    }
}
