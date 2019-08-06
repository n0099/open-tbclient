package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] drY;
    private String jOa;
    private String jOb;
    private AlbumActivity jOc;
    private String[] jOd;
    private ImageListFragment jOe;
    private AlbumImageBrowseFragment jOf;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.jOa = "tag_image";
        this.jOb = "tag_b_image";
        this.jOc = albumActivity;
    }

    public void btA() {
        this.drY = new Fragment[2];
        this.jOd = new String[2];
        this.jOe = new ImageListFragment();
        this.drY[0] = this.jOe;
        this.jOd[0] = this.jOa;
        this.jOf = new AlbumImageBrowseFragment();
        this.drY[1] = this.jOf;
        this.jOd[1] = this.jOb;
    }

    public Fragment CT(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.drY[i];
    }

    public String CU(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.jOd[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.drY.length) {
                if (this.drY[i3] != null && (this.drY[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.drY[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView cAn() {
        if (this.jOe == null) {
            return null;
        }
        return this.jOe.cAn();
    }

    public void stopCamera() {
        TbCameraView cAn = cAn();
        if (cAn != null) {
            cAn.stopCamera();
            cAn.setVisibility(4);
        }
    }

    public void aYW() {
        TbCameraView cAn = cAn();
        if (cAn != null) {
            cAn.setVisibility(0);
            cAn.sj(false);
        }
        if (this.jOe != null && this.jOe.cAL() != null) {
            this.jOe.cAL().cAP();
        }
    }

    public View cAo() {
        if (this.jOe == null) {
            return null;
        }
        return this.jOe.clg();
    }

    public View cAp() {
        if (this.jOe == null) {
            return null;
        }
        return this.jOe.cAK();
    }

    public View cAq() {
        if (this.jOf == null) {
            return null;
        }
        return this.jOf.clg();
    }

    public View cAr() {
        if (this.jOf == null) {
            return null;
        }
        return this.jOf.cAw();
    }

    public View cAs() {
        if (this.jOf == null) {
            return null;
        }
        return this.jOf.cAs();
    }

    public View cAt() {
        if (this.jOe == null) {
            return null;
        }
        return this.jOe.cAs();
    }

    public void onDestroy() {
    }

    public void sf(boolean z) {
        if (this.jOf != null) {
            this.jOf.sf(z);
        }
        if (this.jOe != null) {
            this.jOe.sf(z);
        }
    }

    public void a(i iVar) {
        if (this.jOe != null) {
            this.jOe.a(iVar);
        }
    }
}
