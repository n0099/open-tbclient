package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private String gAf;
    private String gAg;
    private AlbumActivity gAh;
    private Fragment[] gAi;
    private String[] gAj;
    private l gAk;
    private b gAl;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.gAf = "tag_image";
        this.gAg = "tag_b_image";
        this.gAh = albumActivity;
    }

    public void aLD() {
        this.gAi = new Fragment[2];
        this.gAj = new String[2];
        this.gAk = new l();
        this.gAi[0] = this.gAk;
        this.gAj[0] = this.gAf;
        this.gAl = new b();
        this.gAi[1] = this.gAl;
        this.gAj[1] = this.gAg;
    }

    public Fragment ud(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.gAi[i];
    }

    public String ue(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.gAj[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.gAi.length) {
                if (this.gAi[i3] != null && (this.gAi[i3] instanceof l)) {
                    ((l) this.gAi[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView bxX() {
        if (this.gAk == null) {
            return null;
        }
        return this.gAk.bxX();
    }

    public View bxY() {
        if (this.gAk == null) {
            return null;
        }
        return this.gAk.bkK();
    }

    public View bxZ() {
        if (this.gAk == null) {
            return null;
        }
        return this.gAk.byt();
    }

    public View bya() {
        if (this.gAl == null) {
            return null;
        }
        return this.gAl.bkK();
    }

    public View byb() {
        if (this.gAl == null) {
            return null;
        }
        return this.gAl.byh();
    }

    public View byc() {
        if (this.gAl == null) {
            return null;
        }
        return this.gAl.byc();
    }

    public void onDestroy() {
        if (this.gAh.amK() != null) {
            this.gAh.amK().EH();
        }
    }

    public b byd() {
        return this.gAl;
    }

    public l bye() {
        return this.gAk;
    }
}
