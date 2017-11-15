package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private String gRB;
    private String gRC;
    private AlbumActivity gRD;
    private Fragment[] gRE;
    private String[] gRF;
    private l gRG;
    private b gRH;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.gRB = "tag_image";
        this.gRC = "tag_b_image";
        this.gRD = albumActivity;
    }

    public void aOS() {
        this.gRE = new Fragment[2];
        this.gRF = new String[2];
        this.gRG = new l();
        this.gRE[0] = this.gRG;
        this.gRF[0] = this.gRB;
        this.gRH = new b();
        this.gRE[1] = this.gRH;
        this.gRF[1] = this.gRC;
    }

    public Fragment vk(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.gRE[i];
    }

    public String vl(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.gRF[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.gRE.length) {
                if (this.gRE[i3] != null && (this.gRE[i3] instanceof l)) {
                    ((l) this.gRE[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView bCQ() {
        if (this.gRG == null) {
            return null;
        }
        return this.gRG.bCQ();
    }

    public View bCR() {
        if (this.gRG == null) {
            return null;
        }
        return this.gRG.bmj();
    }

    public View bCS() {
        if (this.gRG == null) {
            return null;
        }
        return this.gRG.bDn();
    }

    public View bCT() {
        if (this.gRH == null) {
            return null;
        }
        return this.gRH.bmj();
    }

    public View bCU() {
        if (this.gRH == null) {
            return null;
        }
        return this.gRH.bDb();
    }

    public View bCV() {
        if (this.gRH == null) {
            return null;
        }
        return this.gRH.bCV();
    }

    public View bCW() {
        if (this.gRG == null) {
            return null;
        }
        return this.gRG.bCV();
    }

    public void onDestroy() {
        if (this.gRD.aOP() != null) {
            this.gRD.aOP().ED();
        }
    }

    public b bCX() {
        return this.gRH;
    }

    public l bCY() {
        return this.gRG;
    }
}
