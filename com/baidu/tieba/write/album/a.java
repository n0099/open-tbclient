package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] aVV;
    private String boP;
    private String boQ;
    private TbPageContext hHG;
    private e mMZ;
    private String[] mNa;
    private ImageListFragment mNb;
    private AlbumImageBrowseFragment mNc;

    public a(TbPageContext tbPageContext, e eVar) {
        super(tbPageContext);
        this.boP = "tag_image";
        this.boQ = "tag_b_image";
        this.hHG = tbPageContext;
        this.mMZ = eVar;
    }

    public void OB() {
        this.aVV = new Fragment[2];
        this.mNa = new String[2];
        this.mNb = new ImageListFragment();
        this.mNb.a(this.mMZ);
        this.aVV[0] = this.mNb;
        this.mNa[0] = this.boP;
        this.mNc = new AlbumImageBrowseFragment();
        this.mNc.a(this.mMZ);
        this.aVV[1] = this.mNc;
        this.mNa[1] = this.boQ;
    }

    public Fragment Jx(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.aVV[i];
    }

    public String Jy(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.mNa[i];
    }

    public void a(NavigationBar navigationBar) {
        this.mNb.a(navigationBar);
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.aVV.length) {
                if (this.aVV[i3] != null && (this.aVV[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.aVV[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView dFT() {
        if (this.mNb == null) {
            return null;
        }
        return this.mNb.dFT();
    }

    public void stopCamera() {
        TbCameraView dFT = dFT();
        if (dFT != null) {
            dFT.stopCamera();
            dFT.setVisibility(4);
        }
    }

    public void WZ() {
        TbCameraView dFT = dFT();
        if (dFT != null) {
            dFT.setVisibility(0);
            dFT.xf(false);
        }
        if (this.mNb != null && this.mNb.dGe() != null) {
            this.mNb.dGe().OY();
        }
    }

    public void dFU() {
        if (this.mNb != null) {
            this.mNb.OW();
        }
    }

    public View OC() {
        if (this.mNb == null) {
            return null;
        }
        return this.mNb.OT();
    }

    public View OD() {
        if (this.mNb == null) {
            return null;
        }
        return this.mNb.OX();
    }

    public View OE() {
        if (this.mNc == null) {
            return null;
        }
        return this.mNc.OT();
    }

    public View OF() {
        if (this.mNc == null) {
            return null;
        }
        return this.mNc.OU();
    }

    public View OG() {
        if (this.mNc == null) {
            return null;
        }
        return this.mNc.OG();
    }

    public View OH() {
        if (this.mNb == null) {
            return null;
        }
        return this.mNb.OG();
    }

    public void onDestroy() {
    }

    public ImageListFragment dFV() {
        return this.mNb;
    }

    public void cy(boolean z) {
        if (this.mNc != null) {
            this.mNc.cy(z);
        }
        if (this.mNb != null) {
            this.mNb.cy(z);
        }
    }

    public void a(j jVar) {
        if (this.mNb != null) {
            this.mNb.a(jVar);
        }
    }
}
