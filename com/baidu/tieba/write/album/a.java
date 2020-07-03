package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private Fragment[] aPo;
    private String biQ;
    private String biR;
    private TbPageContext hoE;
    private e mmG;
    private String[] mmH;
    private ImageListFragment mmI;
    private AlbumImageBrowseFragment mmJ;

    public a(TbPageContext tbPageContext, e eVar) {
        super(tbPageContext);
        this.biQ = "tag_image";
        this.biR = "tag_b_image";
        this.hoE = tbPageContext;
        this.mmG = eVar;
    }

    public void IC() {
        this.aPo = new Fragment[2];
        this.mmH = new String[2];
        this.mmI = new ImageListFragment();
        this.mmI.a(this.mmG);
        this.aPo[0] = this.mmI;
        this.mmH[0] = this.biQ;
        this.mmJ = new AlbumImageBrowseFragment();
        this.mmJ.a(this.mmG);
        this.aPo[1] = this.mmJ;
        this.mmH[1] = this.biR;
    }

    public Fragment GE(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.aPo[i];
    }

    public String GF(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.mmH[i];
    }

    public void a(NavigationBar navigationBar) {
        this.mmI.a(navigationBar);
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.aPo.length) {
                if (this.aPo[i3] != null && (this.aPo[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.aPo[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView drg() {
        if (this.mmI == null) {
            return null;
        }
        return this.mmI.drg();
    }

    public void stopCamera() {
        TbCameraView drg = drg();
        if (drg != null) {
            drg.stopCamera();
            drg.setVisibility(4);
        }
    }

    public void QO() {
        TbCameraView drg = drg();
        if (drg != null) {
            drg.setVisibility(0);
            drg.vM(false);
        }
        if (this.mmI != null && this.mmI.drr() != null) {
            this.mmI.drr().Ja();
        }
    }

    public void drh() {
        if (this.mmI != null) {
            this.mmI.IY();
        }
    }

    public View ID() {
        if (this.mmI == null) {
            return null;
        }
        return this.mmI.IV();
    }

    public View IE() {
        if (this.mmI == null) {
            return null;
        }
        return this.mmI.IZ();
    }

    public View IF() {
        if (this.mmJ == null) {
            return null;
        }
        return this.mmJ.IV();
    }

    public View IG() {
        if (this.mmJ == null) {
            return null;
        }
        return this.mmJ.IW();
    }

    public View IH() {
        if (this.mmJ == null) {
            return null;
        }
        return this.mmJ.IH();
    }

    public View II() {
        if (this.mmI == null) {
            return null;
        }
        return this.mmI.IH();
    }

    public void onDestroy() {
    }

    public ImageListFragment dri() {
        return this.mmI;
    }

    public void cn(boolean z) {
        if (this.mmJ != null) {
            this.mmJ.cn(z);
        }
        if (this.mmI != null) {
            this.mmI.cn(z);
        }
    }

    public void a(j jVar) {
        if (this.mmI != null) {
            this.mmI.a(jVar);
        }
    }
}
