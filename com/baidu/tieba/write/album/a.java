package com.baidu.tieba.write.album;

import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private String bCD;
    private String bCE;
    private Fragment[] bcH;
    private TbPageContext iwW;
    private e nGI;
    private String[] nGJ;
    private ImageListFragment nGK;
    private AlbumImageBrowseFragment nGL;

    public a(TbPageContext tbPageContext, e eVar) {
        super(tbPageContext);
        this.bCD = "tag_image";
        this.bCE = "tag_b_image";
        this.iwW = tbPageContext;
        this.nGI = eVar;
    }

    public void Td() {
        this.bcH = new Fragment[2];
        this.nGJ = new String[2];
        this.nGK = new ImageListFragment();
        this.nGK.a(this.nGI);
        this.bcH[0] = this.nGK;
        this.nGJ[0] = this.bCD;
        this.nGL = new AlbumImageBrowseFragment();
        this.nGL.a(this.nGI);
        this.bcH[1] = this.nGL;
        this.nGJ[1] = this.bCE;
    }

    public Fragment LP(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.bcH[i];
    }

    public String LQ(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.nGJ[i];
    }

    public void a(NavigationBar navigationBar) {
        this.nGK.a(navigationBar);
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bcH.length) {
                if (this.bcH[i3] != null && (this.bcH[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.bcH[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView dTp() {
        if (this.nGK == null) {
            return null;
        }
        return this.nGK.dTp();
    }

    public void stopCamera() {
        TbCameraView dTp = dTp();
        if (dTp != null) {
            dTp.stopCamera();
            dTp.setVisibility(4);
        }
    }

    public void openCamera() {
        TbCameraView dTp = dTp();
        if (dTp != null) {
            dTp.setVisibility(0);
            dTp.yE(false);
        }
        if (this.nGK != null && this.nGK.dTA() != null) {
            this.nGK.dTA().TA();
        }
    }

    public void dTq() {
        if (this.nGK != null) {
            this.nGK.Ty();
        }
    }

    public View Te() {
        if (this.nGK == null) {
            return null;
        }
        return this.nGK.Tv();
    }

    public View Tf() {
        if (this.nGK == null) {
            return null;
        }
        return this.nGK.Tz();
    }

    public View Tg() {
        if (this.nGL == null) {
            return null;
        }
        return this.nGL.Tv();
    }

    public View Th() {
        if (this.nGL == null) {
            return null;
        }
        return this.nGL.Tw();
    }

    public View Ti() {
        if (this.nGL == null) {
            return null;
        }
        return this.nGL.Ti();
    }

    public View Tj() {
        if (this.nGK == null) {
            return null;
        }
        return this.nGK.Ti();
    }

    public void onDestroy() {
    }

    public ImageListFragment dTr() {
        return this.nGK;
    }

    public void cS(boolean z) {
        if (this.nGL != null) {
            this.nGL.cS(z);
        }
        if (this.nGK != null) {
            this.nGK.cS(z);
        }
    }

    public void a(j jVar) {
        if (this.nGK != null) {
            this.nGK.a(jVar);
        }
    }
}
