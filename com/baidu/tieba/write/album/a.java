package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private String bEo;
    private String bEp;
    private Fragment[] beu;
    private TbPageContext iwh;
    private e nFh;
    private String[] nFi;
    private ImageListFragment nFj;
    private AlbumImageBrowseFragment nFk;

    public a(TbPageContext tbPageContext, e eVar) {
        super(tbPageContext);
        this.bEo = "tag_image";
        this.bEp = "tag_b_image";
        this.iwh = tbPageContext;
        this.nFh = eVar;
    }

    public void TM() {
        this.beu = new Fragment[2];
        this.nFi = new String[2];
        this.nFj = new ImageListFragment();
        this.nFj.a(this.nFh);
        this.beu[0] = this.nFj;
        this.nFi[0] = this.bEo;
        this.nFk = new AlbumImageBrowseFragment();
        this.nFk.a(this.nFh);
        this.beu[1] = this.nFk;
        this.nFi[1] = this.bEp;
    }

    public Fragment Lm(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.beu[i];
    }

    public String Ln(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.nFi[i];
    }

    public void a(NavigationBar navigationBar) {
        this.nFj.a(navigationBar);
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.beu.length) {
                if (this.beu[i3] != null && (this.beu[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.beu[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView dTq() {
        if (this.nFj == null) {
            return null;
        }
        return this.nFj.dTq();
    }

    public void stopCamera() {
        TbCameraView dTq = dTq();
        if (dTq != null) {
            dTq.stopCamera();
            dTq.setVisibility(4);
        }
    }

    public void openCamera() {
        TbCameraView dTq = dTq();
        if (dTq != null) {
            dTq.setVisibility(0);
            dTq.yx(false);
        }
        if (this.nFj != null && this.nFj.dTB() != null) {
            this.nFj.dTB().Uj();
        }
    }

    public void dTr() {
        if (this.nFj != null) {
            this.nFj.Uh();
        }
    }

    public View TN() {
        if (this.nFj == null) {
            return null;
        }
        return this.nFj.Ue();
    }

    public View TO() {
        if (this.nFj == null) {
            return null;
        }
        return this.nFj.Ui();
    }

    public View TP() {
        if (this.nFk == null) {
            return null;
        }
        return this.nFk.Ue();
    }

    public View TQ() {
        if (this.nFk == null) {
            return null;
        }
        return this.nFk.Uf();
    }

    public View TR() {
        if (this.nFk == null) {
            return null;
        }
        return this.nFk.TR();
    }

    public View TS() {
        if (this.nFj == null) {
            return null;
        }
        return this.nFj.TR();
    }

    public void onDestroy() {
    }

    public ImageListFragment dTs() {
        return this.nFj;
    }

    public void cQ(boolean z) {
        if (this.nFk != null) {
            this.nFk.cQ(z);
        }
        if (this.nFj != null) {
            this.nFj.cQ(z);
        }
    }

    public void a(j jVar) {
        if (this.nFj != null) {
            this.nFj.a(jVar);
        }
    }
}
