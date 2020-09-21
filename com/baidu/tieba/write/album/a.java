package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] aYr;
    private String bsb;
    private String bsc;
    private TbPageContext hON;
    private e mXo;
    private String[] mXp;
    private ImageListFragment mXq;
    private AlbumImageBrowseFragment mXr;

    public a(TbPageContext tbPageContext, e eVar) {
        super(tbPageContext);
        this.bsb = "tag_image";
        this.bsc = "tag_b_image";
        this.hON = tbPageContext;
        this.mXo = eVar;
    }

    public void Pe() {
        this.aYr = new Fragment[2];
        this.mXp = new String[2];
        this.mXq = new ImageListFragment();
        this.mXq.a(this.mXo);
        this.aYr[0] = this.mXq;
        this.mXp[0] = this.bsb;
        this.mXr = new AlbumImageBrowseFragment();
        this.mXr.a(this.mXo);
        this.aYr[1] = this.mXr;
        this.mXp[1] = this.bsc;
    }

    public Fragment Kb(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.aYr[i];
    }

    public String Kc(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.mXp[i];
    }

    public void a(NavigationBar navigationBar) {
        this.mXq.a(navigationBar);
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.aYr.length) {
                if (this.aYr[i3] != null && (this.aYr[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.aYr[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView dJW() {
        if (this.mXq == null) {
            return null;
        }
        return this.mXq.dJW();
    }

    public void stopCamera() {
        TbCameraView dJW = dJW();
        if (dJW != null) {
            dJW.stopCamera();
            dJW.setVisibility(4);
        }
    }

    public void XI() {
        TbCameraView dJW = dJW();
        if (dJW != null) {
            dJW.setVisibility(0);
            dJW.xq(false);
        }
        if (this.mXq != null && this.mXq.dKh() != null) {
            this.mXq.dKh().PB();
        }
    }

    public void dJX() {
        if (this.mXq != null) {
            this.mXq.Pz();
        }
    }

    public View Pf() {
        if (this.mXq == null) {
            return null;
        }
        return this.mXq.Pw();
    }

    public View Pg() {
        if (this.mXq == null) {
            return null;
        }
        return this.mXq.PA();
    }

    public View Ph() {
        if (this.mXr == null) {
            return null;
        }
        return this.mXr.Pw();
    }

    public View Pi() {
        if (this.mXr == null) {
            return null;
        }
        return this.mXr.Px();
    }

    public View Pj() {
        if (this.mXr == null) {
            return null;
        }
        return this.mXr.Pj();
    }

    public View Pk() {
        if (this.mXq == null) {
            return null;
        }
        return this.mXq.Pj();
    }

    public void onDestroy() {
    }

    public ImageListFragment dJY() {
        return this.mXq;
    }

    public void cA(boolean z) {
        if (this.mXr != null) {
            this.mXr.cA(z);
        }
        if (this.mXq != null) {
            this.mXq.cA(z);
        }
    }

    public void a(j jVar) {
        if (this.mXq != null) {
            this.mXq.a(jVar);
        }
    }
}
