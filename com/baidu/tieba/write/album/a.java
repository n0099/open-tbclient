package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private String gyU;
    private String gyV;
    private AlbumActivity gyW;
    private Fragment[] gyX;
    private String[] gyY;
    private l gyZ;
    private b gza;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.gyU = "tag_image";
        this.gyV = "tag_b_image";
        this.gyW = albumActivity;
    }

    public void aLs() {
        this.gyX = new Fragment[2];
        this.gyY = new String[2];
        this.gyZ = new l();
        this.gyX[0] = this.gyZ;
        this.gyY[0] = this.gyU;
        this.gza = new b();
        this.gyX[1] = this.gza;
        this.gyY[1] = this.gyV;
    }

    public Fragment ud(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.gyX[i];
    }

    public String ue(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.gyY[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.gyX.length) {
                if (this.gyX[i3] != null && (this.gyX[i3] instanceof l)) {
                    ((l) this.gyX[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView bxQ() {
        if (this.gyZ == null) {
            return null;
        }
        return this.gyZ.bxQ();
    }

    public View bxR() {
        if (this.gyZ == null) {
            return null;
        }
        return this.gyZ.bkA();
    }

    public View bxS() {
        if (this.gyZ == null) {
            return null;
        }
        return this.gyZ.bym();
    }

    public View bxT() {
        if (this.gza == null) {
            return null;
        }
        return this.gza.bkA();
    }

    public View bxU() {
        if (this.gza == null) {
            return null;
        }
        return this.gza.bya();
    }

    public View bxV() {
        if (this.gza == null) {
            return null;
        }
        return this.gza.bxV();
    }

    public void onDestroy() {
        if (this.gyW.amx() != null) {
            this.gyW.amx().Ez();
        }
    }

    public b bxW() {
        return this.gza;
    }

    public l bxX() {
        return this.gyZ;
    }
}
