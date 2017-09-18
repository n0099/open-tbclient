package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private String gBD;
    private String gBE;
    private AlbumActivity gBF;
    private Fragment[] gBG;
    private String[] gBH;
    private l gBI;
    private b gBJ;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.gBD = "tag_image";
        this.gBE = "tag_b_image";
        this.gBF = albumActivity;
    }

    public void aOd() {
        this.gBG = new Fragment[2];
        this.gBH = new String[2];
        this.gBI = new l();
        this.gBG[0] = this.gBI;
        this.gBH[0] = this.gBD;
        this.gBJ = new b();
        this.gBG[1] = this.gBJ;
        this.gBH[1] = this.gBE;
    }

    public Fragment uq(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.gBG[i];
    }

    public String ur(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.gBH[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.gBG.length) {
                if (this.gBG[i3] != null && (this.gBG[i3] instanceof l)) {
                    ((l) this.gBG[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView bxY() {
        if (this.gBI == null) {
            return null;
        }
        return this.gBI.bxY();
    }

    public View bxZ() {
        if (this.gBI == null) {
            return null;
        }
        return this.gBI.bku();
    }

    public View bya() {
        if (this.gBI == null) {
            return null;
        }
        return this.gBI.byu();
    }

    public View byb() {
        if (this.gBJ == null) {
            return null;
        }
        return this.gBJ.bku();
    }

    public View byc() {
        if (this.gBJ == null) {
            return null;
        }
        return this.gBJ.byi();
    }

    public View byd() {
        if (this.gBJ == null) {
            return null;
        }
        return this.gBJ.byd();
    }

    public void onDestroy() {
        if (this.gBF.apd() != null) {
            this.gBF.apd().EF();
        }
    }

    public b bye() {
        return this.gBJ;
    }

    public l byf() {
        return this.gBI;
    }
}
