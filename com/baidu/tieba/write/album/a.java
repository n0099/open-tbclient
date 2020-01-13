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
    private AlbumActivity kMa;
    private ImageListFragment kMb;
    private AlbumImageBrowseFragment kMc;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.axO = "tag_image";
        this.axP = "tag_b_image";
        this.kMa = albumActivity;
    }

    public void xY() {
        this.amb = new Fragment[2];
        this.axR = new String[2];
        this.kMb = new ImageListFragment();
        this.amb[0] = this.kMb;
        this.axR[0] = this.axO;
        this.kMc = new AlbumImageBrowseFragment();
        this.amb[1] = this.kMc;
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

    public TbCameraView cTj() {
        if (this.kMb == null) {
            return null;
        }
        return this.kMb.cTj();
    }

    public void stopCamera() {
        TbCameraView cTj = cTj();
        if (cTj != null) {
            cTj.stopCamera();
            cTj.setVisibility(4);
        }
    }

    public void Dh() {
        TbCameraView cTj = cTj();
        if (cTj != null) {
            cTj.setVisibility(0);
            cTj.tJ(false);
        }
        if (this.kMb != null && this.kMb.cTo() != null) {
            this.kMb.cTo().yx();
        }
    }

    public View xZ() {
        if (this.kMb == null) {
            return null;
        }
        return this.kMb.yh();
    }

    public View ya() {
        if (this.kMb == null) {
            return null;
        }
        return this.kMb.yw();
    }

    public View yb() {
        if (this.kMc == null) {
            return null;
        }
        return this.kMc.yh();
    }

    public View yc() {
        if (this.kMc == null) {
            return null;
        }
        return this.kMc.yi();
    }

    public View yd() {
        if (this.kMc == null) {
            return null;
        }
        return this.kMc.yd();
    }

    public View ye() {
        if (this.kMb == null) {
            return null;
        }
        return this.kMb.yd();
    }

    public void onDestroy() {
    }

    public void bl(boolean z) {
        if (this.kMc != null) {
            this.kMc.bl(z);
        }
        if (this.kMb != null) {
            this.kMb.bl(z);
        }
    }

    public void a(i iVar) {
        if (this.kMb != null) {
            this.kMb.a(iVar);
        }
    }
}
