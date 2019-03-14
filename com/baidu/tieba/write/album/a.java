package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] dfa;
    private String jmV;
    private String jmW;
    private AlbumActivity jmX;
    private String[] jmY;
    private ImageListFragment jmZ;
    private AlbumImageBrowseFragment jna;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.jmV = "tag_image";
        this.jmW = "tag_b_image";
        this.jmX = albumActivity;
    }

    public void bjR() {
        this.dfa = new Fragment[2];
        this.jmY = new String[2];
        this.jmZ = new ImageListFragment();
        this.dfa[0] = this.jmZ;
        this.jmY[0] = this.jmV;
        this.jna = new AlbumImageBrowseFragment();
        this.dfa[1] = this.jna;
        this.jmY[1] = this.jmW;
    }

    public Fragment Bf(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.dfa[i];
    }

    public String Bg(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.jmY[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.dfa.length) {
                if (this.dfa[i3] != null && (this.dfa[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.dfa[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView coM() {
        if (this.jmZ == null) {
            return null;
        }
        return this.jmZ.coM();
    }

    public void stopCamera() {
        TbCameraView coM = coM();
        if (coM != null) {
            coM.stopCamera();
            coM.setVisibility(4);
        }
    }

    public void coL() {
        TbCameraView coM = coM();
        if (coM != null) {
            coM.setVisibility(0);
            coM.rd(false);
        }
        if (this.jmZ != null && this.jmZ.cpk() != null) {
            this.jmZ.cpk().cpp();
        }
    }

    public View coN() {
        if (this.jmZ == null) {
            return null;
        }
        return this.jmZ.bZU();
    }

    public View coO() {
        if (this.jmZ == null) {
            return null;
        }
        return this.jmZ.cpj();
    }

    public View coP() {
        if (this.jna == null) {
            return null;
        }
        return this.jna.bZU();
    }

    public View coQ() {
        if (this.jna == null) {
            return null;
        }
        return this.jna.coV();
    }

    public View coR() {
        if (this.jna == null) {
            return null;
        }
        return this.jna.coR();
    }

    public View coS() {
        if (this.jmZ == null) {
            return null;
        }
        return this.jmZ.coR();
    }

    public void onDestroy() {
    }

    public void qZ(boolean z) {
        if (this.jna != null) {
            this.jna.qZ(z);
        }
        if (this.jmZ != null) {
            this.jmZ.qZ(z);
        }
    }

    public void a(i iVar) {
        if (this.jmZ != null) {
            this.jmZ.a(iVar);
        }
    }
}
