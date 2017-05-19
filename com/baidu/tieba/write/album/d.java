package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.e<BaseFragmentActivity> {
    private String fMe;
    private String fMf;
    private AlbumActivity fMg;
    private Fragment[] fMh;
    private String[] fMi;
    private ac fMj;
    private f fMk;

    public d(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.fMe = "tag_image";
        this.fMf = "tag_b_image";
        this.fMg = albumActivity;
    }

    public void blZ() {
        this.fMh = new Fragment[2];
        this.fMi = new String[2];
        this.fMj = new ac();
        this.fMh[0] = this.fMj;
        this.fMi[0] = this.fMe;
        this.fMk = new f();
        this.fMh[1] = this.fMk;
        this.fMi[1] = this.fMf;
    }

    public Fragment sL(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.fMh[i];
    }

    public String sM(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.fMi[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.fMh.length) {
                if (this.fMh[i3] != null && (this.fMh[i3] instanceof ac)) {
                    ((ac) this.fMh[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView bma() {
        if (this.fMj == null) {
            return null;
        }
        return this.fMj.bma();
    }

    public View bmb() {
        if (this.fMj == null) {
            return null;
        }
        return this.fMj.bbq();
    }

    public View bmc() {
        if (this.fMj == null) {
            return null;
        }
        return this.fMj.bmC();
    }

    public View bmd() {
        if (this.fMk == null) {
            return null;
        }
        return this.fMk.bbq();
    }

    public View bme() {
        if (this.fMk == null) {
            return null;
        }
        return this.fMk.bmm();
    }

    public View bmf() {
        if (this.fMk == null) {
            return null;
        }
        return this.fMk.bmf();
    }

    public void onDestroy() {
        if (this.fMg.afY() != null) {
            this.fMg.afY().DT();
        }
    }

    public f bmg() {
        return this.fMk;
    }

    public ac bmh() {
        return this.fMj;
    }
}
