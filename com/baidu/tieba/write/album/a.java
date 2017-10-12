package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private String gGK;
    private String gGL;
    private AlbumActivity gGM;
    private Fragment[] gGN;
    private String[] gGO;
    private l gGP;
    private b gGQ;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.gGK = "tag_image";
        this.gGL = "tag_b_image";
        this.gGM = albumActivity;
    }

    public void aLX() {
        this.gGN = new Fragment[2];
        this.gGO = new String[2];
        this.gGP = new l();
        this.gGN[0] = this.gGP;
        this.gGO[0] = this.gGK;
        this.gGQ = new b();
        this.gGN[1] = this.gGQ;
        this.gGO[1] = this.gGL;
    }

    public Fragment uN(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.gGN[i];
    }

    public String uO(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.gGO[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.gGN.length) {
                if (this.gGN[i3] != null && (this.gGN[i3] instanceof l)) {
                    ((l) this.gGN[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView bzm() {
        if (this.gGP == null) {
            return null;
        }
        return this.gGP.bzm();
    }

    public View bzn() {
        if (this.gGP == null) {
            return null;
        }
        return this.gGP.biW();
    }

    public View bzo() {
        if (this.gGP == null) {
            return null;
        }
        return this.gGP.bzJ();
    }

    public View bzp() {
        if (this.gGQ == null) {
            return null;
        }
        return this.gGQ.biW();
    }

    public View bzq() {
        if (this.gGQ == null) {
            return null;
        }
        return this.gGQ.bzx();
    }

    public View bzr() {
        if (this.gGQ == null) {
            return null;
        }
        return this.gGQ.bzr();
    }

    public View bzs() {
        if (this.gGP == null) {
            return null;
        }
        return this.gGP.bzr();
    }

    public void onDestroy() {
        if (this.gGM.aLU() != null) {
            this.gGM.aLU().Ek();
        }
    }

    public b bzt() {
        return this.gGQ;
    }

    public l bzu() {
        return this.gGP;
    }
}
