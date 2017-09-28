package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private String gGL;
    private String gGM;
    private AlbumActivity gGN;
    private Fragment[] gGO;
    private String[] gGP;
    private l gGQ;
    private b gGR;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.gGL = "tag_image";
        this.gGM = "tag_b_image";
        this.gGN = albumActivity;
    }

    public void aLX() {
        this.gGO = new Fragment[2];
        this.gGP = new String[2];
        this.gGQ = new l();
        this.gGO[0] = this.gGQ;
        this.gGP[0] = this.gGL;
        this.gGR = new b();
        this.gGO[1] = this.gGR;
        this.gGP[1] = this.gGM;
    }

    public Fragment uN(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.gGO[i];
    }

    public String uO(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.gGP[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.gGO.length) {
                if (this.gGO[i3] != null && (this.gGO[i3] instanceof l)) {
                    ((l) this.gGO[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView bzn() {
        if (this.gGQ == null) {
            return null;
        }
        return this.gGQ.bzn();
    }

    public View bzo() {
        if (this.gGQ == null) {
            return null;
        }
        return this.gGQ.biX();
    }

    public View bzp() {
        if (this.gGQ == null) {
            return null;
        }
        return this.gGQ.bzK();
    }

    public View bzq() {
        if (this.gGR == null) {
            return null;
        }
        return this.gGR.biX();
    }

    public View bzr() {
        if (this.gGR == null) {
            return null;
        }
        return this.gGR.bzy();
    }

    public View bzs() {
        if (this.gGR == null) {
            return null;
        }
        return this.gGR.bzs();
    }

    public View bzt() {
        if (this.gGQ == null) {
            return null;
        }
        return this.gGQ.bzs();
    }

    public void onDestroy() {
        if (this.gGN.aLU() != null) {
            this.gGN.aLU().Ek();
        }
    }

    public b bzu() {
        return this.gGR;
    }

    public l bzv() {
        return this.gGQ;
    }
}
