package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private String gQt;
    private String gQu;
    private AlbumActivity gQv;
    private Fragment[] gQw;
    private String[] gQx;
    private l gQy;
    private b gQz;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.gQt = "tag_image";
        this.gQu = "tag_b_image";
        this.gQv = albumActivity;
    }

    public void aOK() {
        this.gQw = new Fragment[2];
        this.gQx = new String[2];
        this.gQy = new l();
        this.gQw[0] = this.gQy;
        this.gQx[0] = this.gQt;
        this.gQz = new b();
        this.gQw[1] = this.gQz;
        this.gQx[1] = this.gQu;
    }

    public Fragment vg(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.gQw[i];
    }

    public String vh(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.gQx[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.gQw.length) {
                if (this.gQw[i3] != null && (this.gQw[i3] instanceof l)) {
                    ((l) this.gQw[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView bCE() {
        if (this.gQy == null) {
            return null;
        }
        return this.gQy.bCE();
    }

    public View bCF() {
        if (this.gQy == null) {
            return null;
        }
        return this.gQy.blY();
    }

    public View bCG() {
        if (this.gQy == null) {
            return null;
        }
        return this.gQy.bDb();
    }

    public View bCH() {
        if (this.gQz == null) {
            return null;
        }
        return this.gQz.blY();
    }

    public View bCI() {
        if (this.gQz == null) {
            return null;
        }
        return this.gQz.bCP();
    }

    public View bCJ() {
        if (this.gQz == null) {
            return null;
        }
        return this.gQz.bCJ();
    }

    public View bCK() {
        if (this.gQy == null) {
            return null;
        }
        return this.gQy.bCJ();
    }

    public void onDestroy() {
        if (this.gQv.aOH() != null) {
            this.gQv.aOH().Er();
        }
    }

    public b bCL() {
        return this.gQz;
    }

    public l bCM() {
        return this.gQy;
    }
}
