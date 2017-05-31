package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.e<BaseFragmentActivity> {
    private String fTL;
    private String fTM;
    private AlbumActivity fTN;
    private Fragment[] fTO;
    private String[] fTP;
    private ac fTQ;
    private f fTR;

    public d(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext());
        this.fTL = "tag_image";
        this.fTM = "tag_b_image";
        this.fTN = albumActivity;
    }

    public void bnw() {
        this.fTO = new Fragment[2];
        this.fTP = new String[2];
        this.fTQ = new ac();
        this.fTO[0] = this.fTQ;
        this.fTP[0] = this.fTL;
        this.fTR = new f();
        this.fTO[1] = this.fTR;
        this.fTP[1] = this.fTM;
    }

    public Fragment tg(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.fTO[i];
    }

    public String th(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.fTP[i];
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.fTO.length) {
                if (this.fTO[i3] != null && (this.fTO[i3] instanceof ac)) {
                    ((ac) this.fTO[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView bnx() {
        if (this.fTQ == null) {
            return null;
        }
        return this.fTQ.bnx();
    }

    public View bny() {
        if (this.fTQ == null) {
            return null;
        }
        return this.fTQ.bcK();
    }

    public View bnz() {
        if (this.fTQ == null) {
            return null;
        }
        return this.fTQ.bnZ();
    }

    public View bnA() {
        if (this.fTR == null) {
            return null;
        }
        return this.fTR.bcK();
    }

    public View bnB() {
        if (this.fTR == null) {
            return null;
        }
        return this.fTR.bnJ();
    }

    public View bnC() {
        if (this.fTR == null) {
            return null;
        }
        return this.fTR.bnC();
    }

    public void onDestroy() {
        if (this.fTN.ahn() != null) {
            this.fTN.ahn().DN();
        }
    }

    public f bnD() {
        return this.fTR;
    }

    public ac bnE() {
        return this.fTQ;
    }
}
