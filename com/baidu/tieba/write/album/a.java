package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] bcZ;
    private String byd;
    private String bye;
    private TbPageContext iqk;
    private e nzn;
    private String[] nzo;
    private ImageListFragment nzp;
    private AlbumImageBrowseFragment nzq;

    public a(TbPageContext tbPageContext, e eVar) {
        super(tbPageContext);
        this.byd = "tag_image";
        this.bye = "tag_b_image";
        this.iqk = tbPageContext;
        this.nzn = eVar;
    }

    public void Re() {
        this.bcZ = new Fragment[2];
        this.nzo = new String[2];
        this.nzp = new ImageListFragment();
        this.nzp.a(this.nzn);
        this.bcZ[0] = this.nzp;
        this.nzo[0] = this.byd;
        this.nzq = new AlbumImageBrowseFragment();
        this.nzq.a(this.nzn);
        this.bcZ[1] = this.nzq;
        this.nzo[1] = this.bye;
    }

    public Fragment KZ(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.bcZ[i];
    }

    public String La(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.nzo[i];
    }

    public void a(NavigationBar navigationBar) {
        this.nzp.a(navigationBar);
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bcZ.length) {
                if (this.bcZ[i3] != null && (this.bcZ[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.bcZ[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView dQQ() {
        if (this.nzp == null) {
            return null;
        }
        return this.nzp.dQQ();
    }

    public void stopCamera() {
        TbCameraView dQQ = dQQ();
        if (dQQ != null) {
            dQQ.stopCamera();
            dQQ.setVisibility(4);
        }
    }

    public void openCamera() {
        TbCameraView dQQ = dQQ();
        if (dQQ != null) {
            dQQ.setVisibility(0);
            dQQ.yo(false);
        }
        if (this.nzp != null && this.nzp.dRb() != null) {
            this.nzp.dRb().RB();
        }
    }

    public void dQR() {
        if (this.nzp != null) {
            this.nzp.Rz();
        }
    }

    public View Rf() {
        if (this.nzp == null) {
            return null;
        }
        return this.nzp.Rw();
    }

    public View Rg() {
        if (this.nzp == null) {
            return null;
        }
        return this.nzp.RA();
    }

    public View Rh() {
        if (this.nzq == null) {
            return null;
        }
        return this.nzq.Rw();
    }

    public View Ri() {
        if (this.nzq == null) {
            return null;
        }
        return this.nzq.Rx();
    }

    public View Rj() {
        if (this.nzq == null) {
            return null;
        }
        return this.nzq.Rj();
    }

    public View Rk() {
        if (this.nzp == null) {
            return null;
        }
        return this.nzp.Rj();
    }

    public void onDestroy() {
    }

    public ImageListFragment dQS() {
        return this.nzp;
    }

    public void cJ(boolean z) {
        if (this.nzq != null) {
            this.nzq.cJ(z);
        }
        if (this.nzp != null) {
            this.nzp.cJ(z);
        }
    }

    public void a(j jVar) {
        if (this.nzp != null) {
            this.nzp.a(jVar);
        }
    }
}
