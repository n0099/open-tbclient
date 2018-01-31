package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] bZC;
    private String hDl;
    private String hDm;
    private AlbumActivity hDn;
    private String[] hDo;
    private k hDp;
    private b hDq;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.hDl = "tag_image";
        this.hDm = "tag_b_image";
        this.hDn = albumActivity;
    }

    public void aXl() {
        this.bZC = new Fragment[2];
        this.hDo = new String[2];
        this.hDp = new k();
        this.bZC[0] = this.hDp;
        this.hDo[0] = this.hDl;
        this.hDq = new b();
        this.bZC[1] = this.hDq;
        this.hDo[1] = this.hDm;
    }

    public Fragment xl(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.bZC[i];
    }

    public String xm(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.hDo[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bZC.length) {
                if (this.bZC[i3] != null && (this.bZC[i3] instanceof k)) {
                    ((k) this.bZC[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView bFo() {
        if (this.hDp == null) {
            return null;
        }
        return this.hDp.bFo();
    }

    public void stopCamera() {
        TbCameraView bFo = bFo();
        if (bFo != null) {
            bFo.stopCamera();
            bFo.setVisibility(4);
        }
    }

    public void bFn() {
        TbCameraView bFo = bFo();
        if (bFo != null) {
            bFo.setVisibility(0);
            bFo.nA(false);
        }
        if (this.hDp != null && this.hDp.bFM() != null) {
            this.hDp.bFM().bFR();
        }
    }

    public View bFp() {
        if (this.hDp == null) {
            return null;
        }
        return this.hDp.bpR();
    }

    public View bFq() {
        if (this.hDp == null) {
            return null;
        }
        return this.hDp.bFL();
    }

    public View bFr() {
        if (this.hDq == null) {
            return null;
        }
        return this.hDq.bpR();
    }

    public View bFs() {
        if (this.hDq == null) {
            return null;
        }
        return this.hDq.bFx();
    }

    public View bFt() {
        if (this.hDq == null) {
            return null;
        }
        return this.hDq.bFt();
    }

    public View bFu() {
        if (this.hDp == null) {
            return null;
        }
        return this.hDp.bFt();
    }

    public void onDestroy() {
    }

    public void nw(boolean z) {
        if (this.hDq != null) {
            this.hDq.nw(z);
        }
        if (this.hDp != null) {
            this.hDp.nw(z);
        }
    }

    public void a(l lVar) {
        if (this.hDp != null) {
            this.hDp.a(lVar);
        }
    }
}
