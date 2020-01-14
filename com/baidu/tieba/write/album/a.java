package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes11.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] amb;
    private String axO;
    private String axP;
    private String[] axR;
    private AlbumActivity kMf;
    private ImageListFragment kMg;
    private AlbumImageBrowseFragment kMh;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.axO = "tag_image";
        this.axP = "tag_b_image";
        this.kMf = albumActivity;
    }

    public void xY() {
        this.amb = new Fragment[2];
        this.axR = new String[2];
        this.kMg = new ImageListFragment();
        this.amb[0] = this.kMg;
        this.axR[0] = this.axO;
        this.kMh = new AlbumImageBrowseFragment();
        this.amb[1] = this.kMh;
        this.axR[1] = this.axP;
    }

    public Fragment cx(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.amb[i];
    }

    public String cy(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.axR[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.amb.length) {
                if (this.amb[i3] != null && (this.amb[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.amb[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView cTl() {
        if (this.kMg == null) {
            return null;
        }
        return this.kMg.cTl();
    }

    public void stopCamera() {
        TbCameraView cTl = cTl();
        if (cTl != null) {
            cTl.stopCamera();
            cTl.setVisibility(4);
        }
    }

    public void Dh() {
        TbCameraView cTl = cTl();
        if (cTl != null) {
            cTl.setVisibility(0);
            cTl.tJ(false);
        }
        if (this.kMg != null && this.kMg.cTq() != null) {
            this.kMg.cTq().yx();
        }
    }

    public View xZ() {
        if (this.kMg == null) {
            return null;
        }
        return this.kMg.yh();
    }

    public View ya() {
        if (this.kMg == null) {
            return null;
        }
        return this.kMg.yw();
    }

    public View yb() {
        if (this.kMh == null) {
            return null;
        }
        return this.kMh.yh();
    }

    public View yc() {
        if (this.kMh == null) {
            return null;
        }
        return this.kMh.yi();
    }

    public View yd() {
        if (this.kMh == null) {
            return null;
        }
        return this.kMh.yd();
    }

    public View ye() {
        if (this.kMg == null) {
            return null;
        }
        return this.kMg.yd();
    }

    public void onDestroy() {
    }

    public void bl(boolean z) {
        if (this.kMh != null) {
            this.kMh.bl(z);
        }
        if (this.kMg != null) {
            this.kMg.bl(z);
        }
    }

    public void a(i iVar) {
        if (this.kMg != null) {
            this.kMg.a(iVar);
        }
    }
}
