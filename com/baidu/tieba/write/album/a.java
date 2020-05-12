package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] aGY;
    private String aWg;
    private String aWh;
    private String[] aWj;
    private AlbumActivity lye;
    private ImageListFragment lyf;
    private AlbumImageBrowseFragment lyg;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.aWg = "tag_image";
        this.aWh = "tag_b_image";
        this.lye = albumActivity;
    }

    public void Fv() {
        this.aGY = new Fragment[2];
        this.aWj = new String[2];
        this.lyf = new ImageListFragment();
        this.aGY[0] = this.lyf;
        this.aWj[0] = this.aWg;
        this.lyg = new AlbumImageBrowseFragment();
        this.aGY[1] = this.lyg;
        this.aWj[1] = this.aWh;
    }

    public Fragment dc(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.aGY[i];
    }

    public String dd(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.aWj[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.aGY.length) {
                if (this.aGY[i3] != null && (this.aGY[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.aGY[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView dfr() {
        if (this.lyf == null) {
            return null;
        }
        return this.lyf.dfr();
    }

    public void stopCamera() {
        TbCameraView dfr = dfr();
        if (dfr != null) {
            dfr.stopCamera();
            dfr.setVisibility(4);
        }
    }

    public void Nv() {
        TbCameraView dfr = dfr();
        if (dfr != null) {
            dfr.setVisibility(0);
            dfr.uU(false);
        }
        if (this.lyf != null && this.lyf.dfw() != null) {
            this.lyf.dfw().FU();
        }
    }

    public View Fw() {
        if (this.lyf == null) {
            return null;
        }
        return this.lyf.FE();
    }

    public View Fx() {
        if (this.lyf == null) {
            return null;
        }
        return this.lyf.FT();
    }

    public View Fy() {
        if (this.lyg == null) {
            return null;
        }
        return this.lyg.FE();
    }

    public View Fz() {
        if (this.lyg == null) {
            return null;
        }
        return this.lyg.FF();
    }

    public View FA() {
        if (this.lyg == null) {
            return null;
        }
        return this.lyg.FA();
    }

    public View FB() {
        if (this.lyf == null) {
            return null;
        }
        return this.lyf.FA();
    }

    public void onDestroy() {
    }

    public void bY(boolean z) {
        if (this.lyg != null) {
            this.lyg.bY(z);
        }
        if (this.lyf != null) {
            this.lyf.bY(z);
        }
    }

    public void a(i iVar) {
        if (this.lyf != null) {
            this.lyf.a(iVar);
        }
    }
}
