package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] bZn;
    private String hNj;
    private String hNk;
    private AlbumActivity hNl;
    private String[] hNm;
    private k hNn;
    private b hNo;

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.hNj = "tag_image";
        this.hNk = "tag_b_image";
        this.hNl = albumActivity;
    }

    public void aXb() {
        this.bZn = new Fragment[2];
        this.hNm = new String[2];
        this.hNn = new k();
        this.bZn[0] = this.hNn;
        this.hNm[0] = this.hNj;
        this.hNo = new b();
        this.bZn[1] = this.hNo;
        this.hNm[1] = this.hNk;
    }

    public Fragment yI(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.bZn[i];
    }

    public String yJ(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.hNm[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bZn.length) {
                if (this.bZn[i3] != null && (this.bZn[i3] instanceof k)) {
                    ((k) this.bZn[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView bLM() {
        if (this.hNn == null) {
            return null;
        }
        return this.hNn.bLM();
    }

    public void stopCamera() {
        TbCameraView bLM = bLM();
        if (bLM != null) {
            bLM.stopCamera();
            bLM.setVisibility(4);
        }
    }

    public void bLL() {
        TbCameraView bLM = bLM();
        if (bLM != null) {
            bLM.setVisibility(0);
            bLM.ov(false);
        }
        if (this.hNn != null && this.hNn.bMk() != null) {
            this.hNn.bMk().bMp();
        }
    }

    public View bLN() {
        if (this.hNn == null) {
            return null;
        }
        return this.hNn.bwv();
    }

    public View bLO() {
        if (this.hNn == null) {
            return null;
        }
        return this.hNn.bMj();
    }

    public View bLP() {
        if (this.hNo == null) {
            return null;
        }
        return this.hNo.bwv();
    }

    public View bLQ() {
        if (this.hNo == null) {
            return null;
        }
        return this.hNo.bLV();
    }

    public View bLR() {
        if (this.hNo == null) {
            return null;
        }
        return this.hNo.bLR();
    }

    public View bLS() {
        if (this.hNn == null) {
            return null;
        }
        return this.hNn.bLR();
    }

    public void onDestroy() {
    }

    public void or(boolean z) {
        if (this.hNo != null) {
            this.hNo.or(z);
        }
        if (this.hNn != null) {
            this.hNn.or(z);
        }
    }

    public void a(l lVar) {
        if (this.hNn != null) {
            this.hNn.a(lVar);
        }
    }
}
