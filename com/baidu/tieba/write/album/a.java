package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private l gGA;
    private b gGB;
    private String gGv;
    private String gGw;
    private AlbumActivity gGx;
    private Fragment[] gGy;
    private String[] gGz;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.gGv = "tag_image";
        this.gGw = "tag_b_image";
        this.gGx = albumActivity;
    }

    public void aLS() {
        this.gGy = new Fragment[2];
        this.gGz = new String[2];
        this.gGA = new l();
        this.gGy[0] = this.gGA;
        this.gGz[0] = this.gGv;
        this.gGB = new b();
        this.gGy[1] = this.gGB;
        this.gGz[1] = this.gGw;
    }

    public Fragment uM(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.gGy[i];
    }

    public String uN(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.gGz[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.gGy.length) {
                if (this.gGy[i3] != null && (this.gGy[i3] instanceof l)) {
                    ((l) this.gGy[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView bzg() {
        if (this.gGA == null) {
            return null;
        }
        return this.gGA.bzg();
    }

    public View bzh() {
        if (this.gGA == null) {
            return null;
        }
        return this.gGA.biR();
    }

    public View bzi() {
        if (this.gGA == null) {
            return null;
        }
        return this.gGA.bzD();
    }

    public View bzj() {
        if (this.gGB == null) {
            return null;
        }
        return this.gGB.biR();
    }

    public View bzk() {
        if (this.gGB == null) {
            return null;
        }
        return this.gGB.bzr();
    }

    public View bzl() {
        if (this.gGB == null) {
            return null;
        }
        return this.gGB.bzl();
    }

    public View bzm() {
        if (this.gGA == null) {
            return null;
        }
        return this.gGA.bzl();
    }

    public void onDestroy() {
        if (this.gGx.aLP() != null) {
            this.gGx.aLP().Ee();
        }
    }

    public b bzn() {
        return this.gGB;
    }

    public l bzo() {
        return this.gGA;
    }
}
