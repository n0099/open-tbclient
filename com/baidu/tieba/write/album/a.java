package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private String gAK;
    private String gAL;
    private AlbumActivity gAM;
    private Fragment[] gAN;
    private String[] gAO;
    private l gAP;
    private b gAQ;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.gAK = "tag_image";
        this.gAL = "tag_b_image";
        this.gAM = albumActivity;
    }

    public void aNS() {
        this.gAN = new Fragment[2];
        this.gAO = new String[2];
        this.gAP = new l();
        this.gAN[0] = this.gAP;
        this.gAO[0] = this.gAK;
        this.gAQ = new b();
        this.gAN[1] = this.gAQ;
        this.gAO[1] = this.gAL;
    }

    public Fragment uo(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.gAN[i];
    }

    public String up(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.gAO[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.gAN.length) {
                if (this.gAN[i3] != null && (this.gAN[i3] instanceof l)) {
                    ((l) this.gAN[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView bxN() {
        if (this.gAP == null) {
            return null;
        }
        return this.gAP.bxN();
    }

    public View bxO() {
        if (this.gAP == null) {
            return null;
        }
        return this.gAP.bkj();
    }

    public View bxP() {
        if (this.gAP == null) {
            return null;
        }
        return this.gAP.byj();
    }

    public View bxQ() {
        if (this.gAQ == null) {
            return null;
        }
        return this.gAQ.bkj();
    }

    public View bxR() {
        if (this.gAQ == null) {
            return null;
        }
        return this.gAQ.bxX();
    }

    public View bxS() {
        if (this.gAQ == null) {
            return null;
        }
        return this.gAQ.bxS();
    }

    public void onDestroy() {
        if (this.gAM.aoS() != null) {
            this.gAM.aoS().EF();
        }
    }

    public b bxT() {
        return this.gAQ;
    }

    public l bxU() {
        return this.gAP;
    }
}
