package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] dfe;
    private String jnd;
    private String jne;
    private AlbumActivity jnf;
    private String[] jng;
    private ImageListFragment jnh;
    private AlbumImageBrowseFragment jni;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.jnd = "tag_image";
        this.jne = "tag_b_image";
        this.jnf = albumActivity;
    }

    public void bjS() {
        this.dfe = new Fragment[2];
        this.jng = new String[2];
        this.jnh = new ImageListFragment();
        this.dfe[0] = this.jnh;
        this.jng[0] = this.jnd;
        this.jni = new AlbumImageBrowseFragment();
        this.dfe[1] = this.jni;
        this.jng[1] = this.jne;
    }

    public Fragment Bf(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.dfe[i];
    }

    public String Bg(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.jng[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.dfe.length) {
                if (this.dfe[i3] != null && (this.dfe[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.dfe[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView coJ() {
        if (this.jnh == null) {
            return null;
        }
        return this.jnh.coJ();
    }

    public void stopCamera() {
        TbCameraView coJ = coJ();
        if (coJ != null) {
            coJ.stopCamera();
            coJ.setVisibility(4);
        }
    }

    public void coI() {
        TbCameraView coJ = coJ();
        if (coJ != null) {
            coJ.setVisibility(0);
            coJ.rd(false);
        }
        if (this.jnh != null && this.jnh.cph() != null) {
            this.jnh.cph().cpm();
        }
    }

    public View coK() {
        if (this.jnh == null) {
            return null;
        }
        return this.jnh.bZS();
    }

    public View coL() {
        if (this.jnh == null) {
            return null;
        }
        return this.jnh.cpg();
    }

    public View coM() {
        if (this.jni == null) {
            return null;
        }
        return this.jni.bZS();
    }

    public View coN() {
        if (this.jni == null) {
            return null;
        }
        return this.jni.coS();
    }

    public View coO() {
        if (this.jni == null) {
            return null;
        }
        return this.jni.coO();
    }

    public View coP() {
        if (this.jnh == null) {
            return null;
        }
        return this.jnh.coO();
    }

    public void onDestroy() {
    }

    public void qZ(boolean z) {
        if (this.jni != null) {
            this.jni.qZ(z);
        }
        if (this.jnh != null) {
            this.jnh.qZ(z);
        }
    }

    public void a(i iVar) {
        if (this.jnh != null) {
            this.jnh.a(iVar);
        }
    }
}
