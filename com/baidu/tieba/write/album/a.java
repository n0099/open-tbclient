package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private String gBX;
    private String gBY;
    private AlbumActivity gBZ;
    private Fragment[] gCa;
    private String[] gCb;
    private l gCc;
    private b gCd;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.gBX = "tag_image";
        this.gBY = "tag_b_image";
        this.gBZ = albumActivity;
    }

    public void aMk() {
        this.gCa = new Fragment[2];
        this.gCb = new String[2];
        this.gCc = new l();
        this.gCa[0] = this.gCc;
        this.gCb[0] = this.gBX;
        this.gCd = new b();
        this.gCa[1] = this.gCd;
        this.gCb[1] = this.gBY;
    }

    public Fragment um(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.gCa[i];
    }

    public String un(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.gCb[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.gCa.length) {
                if (this.gCa[i3] != null && (this.gCa[i3] instanceof l)) {
                    ((l) this.gCa[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView byE() {
        if (this.gCc == null) {
            return null;
        }
        return this.gCc.byE();
    }

    public View byF() {
        if (this.gCc == null) {
            return null;
        }
        return this.gCc.blq();
    }

    public View byG() {
        if (this.gCc == null) {
            return null;
        }
        return this.gCc.bza();
    }

    public View byH() {
        if (this.gCd == null) {
            return null;
        }
        return this.gCd.blq();
    }

    public View byI() {
        if (this.gCd == null) {
            return null;
        }
        return this.gCd.byO();
    }

    public View byJ() {
        if (this.gCd == null) {
            return null;
        }
        return this.gCd.byJ();
    }

    public void onDestroy() {
        if (this.gBZ.anq() != null) {
            this.gBZ.anq().EH();
        }
    }

    public b byK() {
        return this.gCd;
    }

    public l byL() {
        return this.gCc;
    }
}
