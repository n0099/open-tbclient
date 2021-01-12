package com.baidu.tieba.write.album;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes7.dex */
public class a extends com.baidu.adp.base.d<BaseFragmentActivity> {
    private String bHN;
    private String bHO;
    private Fragment[] bdx;
    private TbPageContext iPu;
    private e nTF;
    private String[] nTG;
    private ImageListFragment nTH;
    private AlbumImageBrowseFragment nTI;

    public a(TbPageContext tbPageContext, e eVar) {
        super(tbPageContext);
        this.bHN = "tag_image";
        this.bHO = "tag_b_image";
        this.iPu = tbPageContext;
        this.nTF = eVar;
    }

    public void SN() {
        this.bdx = new Fragment[2];
        this.nTG = new String[2];
        this.nTH = new ImageListFragment();
        this.nTH.a(this.nTF);
        this.bdx[0] = this.nTH;
        this.nTG[0] = this.bHN;
        this.nTI = new AlbumImageBrowseFragment();
        this.nTI.a(this.nTF);
        this.bdx[1] = this.nTI;
        this.nTG[1] = this.bHO;
    }

    public Fragment KN(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.bdx[i];
    }

    public String KO(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        return this.nTG[i];
    }

    public void b(NavigationBar navigationBar) {
        this.nTH.b(navigationBar);
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bdx.length) {
                if (this.bdx[i3] != null && (this.bdx[i3] instanceof ImageListFragment)) {
                    ((ImageListFragment) this.bdx[i3]).onChangeSkinType(i);
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public TbCameraView dUw() {
        if (this.nTH == null) {
            return null;
        }
        return this.nTH.dUw();
    }

    public void stopCamera() {
        TbCameraView dUw = dUw();
        if (dUw != null) {
            dUw.stopCamera();
            dUw.setVisibility(4);
        }
    }

    public void openCamera() {
        TbCameraView dUw = dUw();
        if (dUw != null) {
            dUw.setVisibility(0);
            dUw.zg(false);
        }
        if (this.nTH != null && this.nTH.dUH() != null) {
            this.nTH.dUH().Tk();
        }
    }

    public void dUx() {
        if (this.nTH != null) {
            this.nTH.Ti();
        }
    }

    public View SO() {
        if (this.nTH == null) {
            return null;
        }
        return this.nTH.Tf();
    }

    public View SP() {
        if (this.nTH == null) {
            return null;
        }
        return this.nTH.Tj();
    }

    public View SQ() {
        if (this.nTI == null) {
            return null;
        }
        return this.nTI.Tf();
    }

    public View SR() {
        if (this.nTI == null) {
            return null;
        }
        return this.nTI.Tg();
    }

    public View SS() {
        if (this.nTI == null) {
            return null;
        }
        return this.nTI.SS();
    }

    public View ST() {
        if (this.nTH == null) {
            return null;
        }
        return this.nTH.SS();
    }

    public void onDestroy() {
    }

    public ImageListFragment dUy() {
        return this.nTH;
    }

    public void df(boolean z) {
        if (this.nTI != null) {
            this.nTI.df(z);
        }
        if (this.nTH != null) {
            this.nTH.df(z);
        }
    }

    public void a(j jVar) {
        if (this.nTH != null) {
            this.nTH.a(jVar);
        }
    }
}
