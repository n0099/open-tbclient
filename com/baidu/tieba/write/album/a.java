package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] aMI;
    private String bdD;
    private String bdE;
    private AlbumActivity lRt;
    private String[] lRu;
    private ImageListFragment lRv;
    private AlbumImageBrowseFragment lRw;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.bdD = "tag_image";
        this.bdE = "tag_b_image";
        this.lRt = albumActivity;
    }

    public void Hp() {
        this.aMI = new Fragment[2];
        this.lRu = new String[2];
        this.lRv = new ImageListFragment();
        this.aMI[0] = this.lRv;
        this.lRu[0] = this.bdD;
        this.lRw = new AlbumImageBrowseFragment();
        this.aMI[1] = this.lRw;
        this.lRu[1] = this.bdE;
    }

    public Fragment Fy(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.aMI[i];
    }

    public String Fz(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.lRu[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.aMI.length) {
                if (this.aMI[i3] != null && (this.aMI[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.aMI[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView dmH() {
        if (this.lRv == null) {
            return null;
        }
        return this.lRv.dmH();
    }

    public void stopCamera() {
        TbCameraView dmH = dmH();
        if (dmH != null) {
            dmH.stopCamera();
            dmH.setVisibility(4);
        }
    }

    public void PI() {
        TbCameraView dmH = dmH();
        if (dmH != null) {
            dmH.setVisibility(0);
            dmH.vs(false);
        }
        if (this.lRv != null && this.lRv.dmM() != null) {
            this.lRv.dmM().HN();
        }
    }

    public View Hq() {
        if (this.lRv == null) {
            return null;
        }
        return this.lRv.HI();
    }

    public View Hr() {
        if (this.lRv == null) {
            return null;
        }
        return this.lRv.HM();
    }

    public View Hs() {
        if (this.lRw == null) {
            return null;
        }
        return this.lRw.HI();
    }

    public View Ht() {
        if (this.lRw == null) {
            return null;
        }
        return this.lRw.HJ();
    }

    public View Hu() {
        if (this.lRw == null) {
            return null;
        }
        return this.lRw.Hu();
    }

    public View Hv() {
        if (this.lRv == null) {
            return null;
        }
        return this.lRv.Hu();
    }

    public void onDestroy() {
    }

    public void ci(boolean z) {
        if (this.lRw != null) {
            this.lRw.ci(z);
        }
        if (this.lRv != null) {
            this.lRv.ci(z);
        }
    }

    public void a(i iVar) {
        if (this.lRv != null) {
            this.lRv.a(iVar);
        }
    }
}
