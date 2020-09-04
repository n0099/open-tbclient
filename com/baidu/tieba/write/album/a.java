package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] aVX;
    private String boS;
    private String boT;
    private TbPageContext hHM;
    private e mNr;
    private String[] mNs;
    private ImageListFragment mNt;
    private AlbumImageBrowseFragment mNu;

    public a(TbPageContext tbPageContext, e eVar) {
        super(tbPageContext);
        this.boS = "tag_image";
        this.boT = "tag_b_image";
        this.hHM = tbPageContext;
        this.mNr = eVar;
    }

    public void OB() {
        this.aVX = new Fragment[2];
        this.mNs = new String[2];
        this.mNt = new ImageListFragment();
        this.mNt.a(this.mNr);
        this.aVX[0] = this.mNt;
        this.mNs[0] = this.boS;
        this.mNu = new AlbumImageBrowseFragment();
        this.mNu.a(this.mNr);
        this.aVX[1] = this.mNu;
        this.mNs[1] = this.boT;
    }

    public Fragment Jx(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.aVX[i];
    }

    public String Jy(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.mNs[i];
    }

    public void a(NavigationBar navigationBar) {
        this.mNt.a(navigationBar);
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.aVX.length) {
                if (this.aVX[i3] != null && (this.aVX[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.aVX[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView dGc() {
        if (this.mNt == null) {
            return null;
        }
        return this.mNt.dGc();
    }

    public void stopCamera() {
        TbCameraView dGc = dGc();
        if (dGc != null) {
            dGc.stopCamera();
            dGc.setVisibility(4);
        }
    }

    public void WZ() {
        TbCameraView dGc = dGc();
        if (dGc != null) {
            dGc.setVisibility(0);
            dGc.xh(false);
        }
        if (this.mNt != null && this.mNt.dGn() != null) {
            this.mNt.dGn().OY();
        }
    }

    public void dGd() {
        if (this.mNt != null) {
            this.mNt.OW();
        }
    }

    public View OC() {
        if (this.mNt == null) {
            return null;
        }
        return this.mNt.OT();
    }

    public View OD() {
        if (this.mNt == null) {
            return null;
        }
        return this.mNt.OX();
    }

    public View OE() {
        if (this.mNu == null) {
            return null;
        }
        return this.mNu.OT();
    }

    public View OF() {
        if (this.mNu == null) {
            return null;
        }
        return this.mNu.OU();
    }

    public View OG() {
        if (this.mNu == null) {
            return null;
        }
        return this.mNu.OG();
    }

    public View OH() {
        if (this.mNt == null) {
            return null;
        }
        return this.mNt.OG();
    }

    public void onDestroy() {
    }

    public ImageListFragment dGe() {
        return this.mNt;
    }

    public void cz(boolean z) {
        if (this.mNu != null) {
            this.mNu.cz(z);
        }
        if (this.mNt != null) {
            this.mNt.cz(z);
        }
    }

    public void a(j jVar) {
        if (this.mNt != null) {
            this.mNt.a(jVar);
        }
    }
}
