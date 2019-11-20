package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] adq;
    private String apn;
    private String apo;
    private String[] apr;
    private AlbumActivity jNL;
    private ImageListFragment jNM;
    private AlbumImageBrowseFragment jNN;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.apn = "tag_image";
        this.apo = "tag_b_image";
        this.jNL = albumActivity;
    }

    public void vK() {
        this.adq = new Fragment[2];
        this.apr = new String[2];
        this.jNM = new ImageListFragment();
        this.adq[0] = this.jNM;
        this.apr[0] = this.apn;
        this.jNN = new AlbumImageBrowseFragment();
        this.adq[1] = this.jNN;
        this.apr[1] = this.apo;
    }

    public Fragment ce(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.adq[i];
    }

    public String cf(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.apr[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.adq.length) {
                if (this.adq[i3] != null && (this.adq[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.adq[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView cye() {
        if (this.jNM == null) {
            return null;
        }
        return this.jNM.cye();
    }

    public void stopCamera() {
        TbCameraView cye = cye();
        if (cye != null) {
            cye.stopCamera();
            cye.setVisibility(4);
        }
    }

    public void aZB() {
        TbCameraView cye = cye();
        if (cye != null) {
            cye.setVisibility(0);
            cye.rR(false);
        }
        if (this.jNM != null && this.jNM.cyj() != null) {
            this.jNM.cyj().wj();
        }
    }

    public View vL() {
        if (this.jNM == null) {
            return null;
        }
        return this.jNM.vT();
    }

    public View vM() {
        if (this.jNM == null) {
            return null;
        }
        return this.jNM.wi();
    }

    public View vN() {
        if (this.jNN == null) {
            return null;
        }
        return this.jNN.vT();
    }

    public View vO() {
        if (this.jNN == null) {
            return null;
        }
        return this.jNN.vU();
    }

    public View vP() {
        if (this.jNN == null) {
            return null;
        }
        return this.jNN.vP();
    }

    public View vQ() {
        if (this.jNM == null) {
            return null;
        }
        return this.jNM.vP();
    }

    public void onDestroy() {
    }

    public void aQ(boolean z) {
        if (this.jNN != null) {
            this.jNN.aQ(z);
        }
        if (this.jNM != null) {
            this.jNM.aQ(z);
        }
    }

    public void a(i iVar) {
        if (this.jNM != null) {
            this.jNM.a(iVar);
        }
    }
}
